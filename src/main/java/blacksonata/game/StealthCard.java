package blacksonata.game;

import blacksonata.view.ImageUtil;

import java.awt.Image;

public class StealthCard extends Card{
    private String[] codes = new String[8]; // "A", "-A"
    private Image imageFront;    
    private Image imageBack;    
    private String location;

    public StealthCard(String[] codes, String imageFrontName, String imageBackName, String location){
        super(CardType.STEALTH);

        this.codes = codes;
        this.imageFront = ImageUtil.get(imageFrontName);
        this.imageBack  = ImageUtil.get(imageBackName);

        this.location = location;
    }

    public String[] getCodes() {
        return this.codes;
    }

    public String getCode(int index) {
        return this.codes[index];
    }

    public Image getImageFront() {
        return this.imageFront;
    }

    public Image getImageBack() {
        return this.imageBack;
    }

    public String getLocation() {
        return this.location;
    }
}
