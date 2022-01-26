package blacksonata.game;

import blacksonata.view.ImageUtil;

import java.awt.Image;

public class FogCard extends Card{
    private int id;
    private Image image;

    public FogCard(int id, String imageName){
        super(CardType.FOG);

        this.id = id;
        this.image = ImageUtil.get(imageName);
    }

    public int getId(){
        return this.id;
    }

    public Image getImage() {
        return this.image;
    }
}
