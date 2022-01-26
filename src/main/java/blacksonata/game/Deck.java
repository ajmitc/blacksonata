package blacksonata.game;
import java.util.ArrayList;
import java.util.List;

public class Deck<T> {
    private List<T> cards = new ArrayList<>();
    private List<T> discardPile = new ArrayList<>();

    public Deck(){

    }

    /**
     * Remove top card from list
     */
    public T draw(){
        if (cards.isEmpty()){
            cards.addAll(discardPile);
            discardPile.clear();
        }
        return cards.remove(0);
    }

    /**
     * Return card without removing it from the list
     */
    public T peek(){
        if (cards.isEmpty()){
            cards.addAll(discardPile);
            discardPile.clear();
        }
        return cards.get(0);
    }

    /**
     * Place card at end of discard pile
     */
    public void discard(T card){
        discardPile.add(card);
    }

    /**
     * Add card at end of cards list (used during setup only)
     */
    public void add(T card){
        cards.add(card);
    }

    /**
     * Put the card on top of the card list
     */
    public void putOnTop(T card){
        cards.add(0, card);
    }

    public void clear(){
        cards.clear();
        discardPile.clear();
    }
}
