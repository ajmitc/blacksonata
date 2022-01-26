package blacksonata;

import blacksonata.game.Attribute;
import blacksonata.game.AttributeState;
import blacksonata.game.Card;
import blacksonata.game.CardType;
import blacksonata.game.CountdownCard;
import blacksonata.game.FogCard;
import blacksonata.game.Game;
import blacksonata.game.Location;
import blacksonata.game.Phase;
import blacksonata.game.PhaseStep;
import blacksonata.game.SetType;
import blacksonata.game.StealthCard;
import blacksonata.game.Suspect;
import blacksonata.view.View;

import java.awt.event.*;

import java.util.Collections;
import java.util.Set;

public class Controller {
    private Model model;
    private View view;
    
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;

        view.getMainMenuPanel().getBtnNewGame().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Game game = new Game();
                model.setGame(game);
                view.showGame();
                view.refresh();
                run();
            }
        });

        view.getGamePanel().getAttributePanel().addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Attribute attribute = view.getGamePanel().getAttributePanel().getSelectedAttribute(e.getX(), e.getY());
                if (attribute != null){
                    AttributeState state = model.getGame().getAttributeStates().get(attribute);
                    switch(state){
                        case SOLID:
                            state = AttributeState.FADED;
                            break;
                        case FADED:
                            state = AttributeState.MATCH;
                            break;
                        case MATCH:
                            state = AttributeState.SOLID;
                            break;
                    }
                    model.getGame().getAttributeStates().put(attribute, state);
                    view.getGamePanel().refresh();
                }
            }
        });
    }

    public void run(){
        while (model.getGame() != null && model.getGame().getPhase() != Phase.GAMEOVER){
            switch(model.getGame().getPhase()){
                case SETUP: {
                    switch(model.getGame().getPhaseStep()){
                        case START_PHASE:{
                            // TODO Player chooses starting location, difficulty, and number of countdown rounds (default "2")
                            String playerStartingLocationName = "Cornhill";
                            int difficulty = 1; // 0: Easy, 2: Hard
                            int countdownValue = 2;

                            Location playerStartingLocation = model.getGame().getBoard().getLocation(playerStartingLocationName);
                            model.getGame().setPlayerLocation(playerStartingLocation);

                            // TODO Based on difficulty, remove SetType
                            // Easy:
                            if (difficulty == 0){
                            //   Lady -> Remove this set
                            //   Rose -> Bluebell
                            //   Oak  -> Acorn
                            //   Bluebell -> Thistle
                            //   Acorn -> Purple
                            //   Thistle -> Rose
                            }
                            // Hard:
                            if (difficulty == 2){
                                //   Rose -> Oak -> Bluebell -> Acorn -> Thistle -> Purple -> Rose
                            }

                            // Shuffle fog cards
                            Collections.shuffle(model.getGame().getFogCards());

                            // Choose random suspect/clue card to be Dark Lady
                            Collections.shuffle(model.getGame().getSuspects());
                            Suspect darkLady = model.getGame().getSuspects().remove(0);
                            model.getGame().setDarkLady(darkLady);

                            // Set aside suspect card with matching SetType as Dark Lady
                            SetType darkLadyType = darkLady.getSetType();
                            for (Suspect suspect: model.getGame().getSuspects()){
                                if (suspect.getSetType() == darkLadyType){
                                    model.getGame().setVisitAllLocationsClue(suspect);
                                    break;
                                }
                            }
                            model.getGame().getSuspects().remove(model.getGame().getVisitAllLocationsClue());

                            // Build the Stealth deck
                            // TODO Randomly choose starting letter and index
                            model.getGame().getStealthDeck().load('A', 0, countdownValue);

                            // TODO Set all attributes to solid

                            model.getGame().setPhaseStep(PhaseStep.END_PHASE);
                            break;
                        }
                        case END_PHASE: {
                            model.getGame().setPhase(Phase.PLAY);
                            break;
                        }
                    }
                    break;
                }
                case PLAY: {
                    view.refresh();
                    switch(model.getGame().getPhaseStep()){
                        case START_PHASE:{
                            // Draw the top card and move to back of deck
                            model.getGame().setPhaseStep(PhaseStep.PLAY_MOVE_DARK_LADY);
                            break;
                        }
                        case PLAY_MOVE_DARK_LADY: {
                            moveDarkLady();
                            model.getGame().setPhaseStep(PhaseStep.PLAY_SELECT_ACTION);
                            break;
                        }
                        case PLAY_SELECT_ACTION: {
                            return;
                        }
                        case PLAY_PLAYER_MOVE: {
                            // TODO Remove location from unvisitedLocations
                            // If player has visited all locations, reveal clue
                            if (model.getGame().getUnvisitedLocations().isEmpty() && model.getGame().getVisitAllLocationsClue() != null){
                                model.getGame().getClues().add(model.getGame().getVisitAllLocationsClue());
                                model.getGame().setVisitAllLocationsClue(null);
                            }
                            model.getGame().setPhaseStep(PhaseStep.END_PHASE);
                            break;
                        }
                        case PLAY_PLAYER_SEARCH: {
                            // Check if player is at dark lady's location
                            Card topCard = model.getGame().getStealthDeck().peek();
                            if (topCard.getType() == CardType.STEALTH){
                                StealthCard sCard = (StealthCard) topCard;
                                // Draw StealthCard
                                model.getGame().getStealthDeck().draw();
                                // Place fog card on top of StealthDeck
                                // TODO What if the fog deck is empty?
                                FogCard fogCard = model.getGame().getFogCards().remove(0);
                                model.getGame().getStealthDeck().putOnTop(fogCard);

                                if (model.getGame().getPlayerLocation().getName().equals(sCard.getLocation())){
                                    // Player has found her, reveal clue/suspect
                                    Suspect clue = model.getGame().getSuspects().remove(0);
                                    model.getGame().getClues().add(clue);
                                }
                                else {
                                    // TODO Player has not found her
                                }

                                // Dark Lady runs
                                for (int i = 0; i < model.getGame().getClues().size(); ++i){
                                    moveDarkLady();
                                }
                            }
                            else {
                                // TODO Must have StealthCard on top of deck to perform search
                            }
                            model.getGame().setPhaseStep(PhaseStep.END_PHASE);
                            break;
                        }
                        case PLAY_PLAYER_USE_FOG: {
                            Card topCard = model.getGame().getStealthDeck().peek();
                            if (topCard.getType() == CardType.FOG){
                                FogCard fCard = (FogCard) topCard;
                                // Remove fog card from deck
                                model.getGame().getStealthDeck().draw();
                                // Put fog card back in supply
                                model.getGame().getFogCards().add(fCard);

                                // Place new fog card on top of StealthDeck
                                // TODO What if the fog deck is empty?
                                FogCard fogCard = model.getGame().getFogCards().remove(0);
                                model.getGame().getStealthDeck().putOnTop(fogCard);

                                // Perform FogCard special ability
                                applyFogCard(fCard);
                            }
                            else {
                                // TODO Must have fog card on top of deck to perform search
                            }
                            model.getGame().setPhaseStep(PhaseStep.END_PHASE);
                            break;
                        }
                        case PLAY_PLAYER_CONFRONT: {
                            // TODO If player has chosen 3 attributes, check if dark lady at player's location
                            Set<Attribute> matchAttributes = model.getGame().getMatchAttributes();
                            if (matchAttributes.size() != 3){
                                // TODO Player must have selected 3 attributes
                                break;
                            }
                            boolean correct = true;
                            for (Attribute attr: model.getGame().getDarkLady().getAttributes()){
                                if (!matchAttributes.contains(attr)){
                                    correct = false;
                                }
                            }
                            // If yes and attributes are correct, player wins; else player loses.
                            if (correct){
                                // TODO Player wins!
                            }
                            else {
                                // TODO Player loses!
                            }

                            model.getGame().setPhase(Phase.GAMEOVER);
                            break;
                        }
                        case PLAY_PASS: {
                            model.getGame().setPhaseStep(PhaseStep.END_PHASE);
                            break;
                        }
                        case END_PHASE: {
                            model.getGame().setPhaseStep(PhaseStep.START_PHASE);
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }

    private void moveDarkLady(){
        // Move Dark Lady
        Card card = model.getGame().getStealthDeck().draw();
        model.getGame().getStealthDeck().discard(card);
        
        Card topCard = model.getGame().getStealthDeck().peek();
        // If round counter and it equals 0, set GAMEOVER
        if (topCard.getType() == CardType.COUNTDOWN){
            ((CountdownCard) topCard).adjRound(-1);
            if (((CountdownCard) topCard).getRound() == 0){
                model.getGame().setPhase(Phase.GAMEOVER);
                return;
            }
            // Move countdown card to bottom of deck
            card = model.getGame().getStealthDeck().draw();
            model.getGame().getStealthDeck().discard(card);
        }
    }

    private void applyFogCard(FogCard card){

    }
}
