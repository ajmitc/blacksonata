package blacksonata;

import blacksonata.game.Game;

public class Model{
    private Game game;

    public Model(){

    }

    public Game getGame() {
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}