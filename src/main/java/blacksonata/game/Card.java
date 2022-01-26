package blacksonata.game;

public abstract class Card {
    private CardType type;

    public Card(CardType type){
        this.type = type;
    }

    public CardType getType(){ return this.type; }
}
