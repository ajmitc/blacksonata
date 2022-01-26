package blacksonata.game;

import blacksonata.view.ImageUtil;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Game {
    private Board board = new Board();
    private Location playerLocation;
    private StealthDeck stealthDeck = new StealthDeck();
    private Suspect darkLady;
    private Suspect visitAllLocationsClue;
    private List<Suspect> suspects = new ArrayList<>();
    private List<FogCard> fogCards = new ArrayList<>();
    private Image fogBackImage;

    private List<Suspect> clues = new ArrayList<>();
    private Map<Attribute, AttributeState> attributeStates = new HashMap<>();
    private Set<String> unvisitedLocations = new HashSet<>();

    private Phase phase = Phase.SETUP;
    private PhaseStep phaseStep = PhaseStep.START_PHASE;
    
    public Game(){
        suspects.add(new Suspect("suspect-aline-florio.jpg", "suspect-back-bluebell.png", SetType.BLUEBELL, Attribute.HEART, Attribute.QUILL, Attribute.RING));
        suspects.add(new Suspect("suspect-anne-hathaway.jpg", "suspect-back-thistle.png", SetType.THISTLE, Attribute.CHAIN, Attribute.RATTLE, Attribute.MUSIC));
        suspects.add(new Suspect("suspect-anne-whateley.jpg", "suspect-back-oak.png", SetType.OAK, Attribute.CHAIN, Attribute.HEART, Attribute.MUSIC));
        suspects.add(new Suspect("suspect-elizabeth-vernon.jpg", "suspect-back-rose.png", SetType.ROSE, Attribute.RING, Attribute.CROWN, Attribute.HEART));
        suspects.add(new Suspect("suspect-emilia-lanier.jpg", "suspect-back-oak.png", SetType.OAK, Attribute.RING, Attribute.CROWN, Attribute.HEART));
        suspects.add(new Suspect("suspect-jacqueline-field.jpg", "suspect-back-purple.png", SetType.PURPLE, Attribute.QUILL, Attribute.RATTLE, Attribute.RING));
        suspects.add(new Suspect("suspect-jane-devenant.jpg", "suspect-back-thistle.png", SetType.THISTLE, Attribute.RING, Attribute.HEART, Attribute.MUSIC));
        suspects.add(new Suspect("suspect-lucy-morgan.jpg", "suspect-back-acorn.png", SetType.ACORN, Attribute.HEART, Attribute.CROWN, Attribute.CHAIN));
        suspects.add(new Suspect("suspect-marie-mountjoy.jpg", "suspect-back-purple.png", SetType.PURPLE, Attribute.HEART, Attribute.CHAIN, Attribute.QUILL));
        suspects.add(new Suspect("suspect-mary-fitton.jpg", "suspect-back-rose.png", SetType.ROSE, Attribute.CROWN, Attribute.CHAIN, Attribute.RATTLE));
        suspects.add(new Suspect("suspect-penelope-rich.jpg", "suspect-back-acorn.png", SetType.ACORN, Attribute.RATTLE, Attribute.RING, Attribute.CROWN));
        suspects.add(new Suspect("suspect-winnifred-burbage.jpg", "suspect-back-bluebell.png", SetType.BLUEBELL, Attribute.CHAIN, Attribute.QUILL, Attribute.RATTLE));

        fogCards.add(new FogCard(1, "fog-1.jpg"));
        fogCards.add(new FogCard(2, "fog-2.jpg"));
        fogCards.add(new FogCard(3, "fog-3.jpg"));
        fogCards.add(new FogCard(4, "fog-4.jpg"));
        fogCards.add(new FogCard(5, "fog-5.jpg"));
        fogCards.add(new FogCard(6, "fog-6.jpg"));
        fogCards.add(new FogCard(7, "fog-7.jpg"));
        fogCards.add(new FogCard(8, "fog-8.jpg"));
        fogCards.add(new FogCard(9, "fog-9.jpg"));
        fogCards.add(new FogCard(10, "fog-10.jpg"));

        fogBackImage = ImageUtil.get("fog-back.jpg");

        for (Attribute attribute: Attribute.values()){
            attributeStates.put(attribute, AttributeState.SOLID);
        }

        unvisitedLocations.add(Location.BISHOPSGATE);
        unvisitedLocations.add(Location.BLACKFRIARS);
        unvisitedLocations.add(Location.CLERKENWELL);
        unvisitedLocations.add(Location.CORNHILL);
        unvisitedLocations.add(Location.CRIPPLEGATE);
        unvisitedLocations.add(Location.EASTCHEAP);
        unvisitedLocations.add(Location.LIBERTY_CLINK);
        unvisitedLocations.add(Location.LONDON_BRIDGE);
        unvisitedLocations.add(Location.SHOREDITCH);
        unvisitedLocations.add(Location.SOUTHWARK);
        unvisitedLocations.add(Location.ST_PAULS);
    }

    public void setPhase(Phase phase){
        this.phase = phase;
        this.phaseStep = PhaseStep.START_PHASE;
    }

    public Phase getPhase(){ return this.phase; }

    public void setPhaseStep(PhaseStep step){ this.phaseStep = step; }

    public PhaseStep getPhaseStep(){ return this.phaseStep; }

    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Location getPlayerLocation() {
        return this.playerLocation;
    }

    public void setPlayerLocation(Location playerLocation) {
        this.playerLocation = playerLocation;
    }

    public StealthDeck getStealthDeck() {
        return this.stealthDeck;
    }

    public Suspect getDarkLady(){ return this.darkLady; }

    public void setDarkLady(Suspect suspect){ this.darkLady = suspect; }

    public List<Suspect> getSuspects(){ return this.suspects; }

    public List<FogCard> getFogCards(){ return this.fogCards; }

    public Image getFogCardBackImage(){ return this.fogBackImage; }

    public void setStealthDeck(StealthDeck stealthDeck) {
        this.stealthDeck = stealthDeck;
    }

    public Suspect getVisitAllLocationsClue() {
        return this.visitAllLocationsClue;
    }

    public void setVisitAllLocationsClue(Suspect visitAllLocationsClue) {
        this.visitAllLocationsClue = visitAllLocationsClue;
    }

    public List<Suspect> getClues() {
        return this.clues;
    }

    public void setClues(List<Suspect> clues) {
        this.clues = clues;
    }

    public Map<Attribute,AttributeState> getAttributeStates() {
        return this.attributeStates;
    }

    public Set<Attribute> getMatchAttributes(){
        Set<Attribute> attrs = new HashSet<>();
        for (Attribute attr: attributeStates.keySet()){
            if (attributeStates.get(attr) == AttributeState.MATCH){
                attrs.add(attr);
            }
        }
        return attrs;
    }

    public Set<String> getUnvisitedLocations(){ return unvisitedLocations; }
}
