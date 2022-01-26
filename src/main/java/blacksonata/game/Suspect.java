package blacksonata.game;

import blacksonata.view.ImageUtil;

import java.awt.Image;
import java.util.HashSet;
import java.util.Set;

public class Suspect {
    public static final int CARD_WIDTH = 400;

    private Image imageFront;
    private Image imageBack;
    private SetType setType;
    private Set<Attribute> attributes = new HashSet<>();
    
    public Suspect(String imageFrontName, String imageBackName, SetType setType, Attribute ... attributes){
        this.imageFront = ImageUtil.get(imageFrontName, CARD_WIDTH);
        this.imageBack  = ImageUtil.get(imageBackName, CARD_WIDTH);
        this.setType = setType;
        for (Attribute attr: attributes){
            this.attributes.add(attr);
        }
    }

    public Image getImageFront() {
        return this.imageFront;
    }

    public void setImageFront(Image imageFront) {
        this.imageFront = imageFront;
    }

    public Image getImageBack() {
        return this.imageBack;
    }

    public void setImageBack(Image imageBack) {
        this.imageBack = imageBack;
    }

    public SetType getSetType() {
        return this.setType;
    }

    public void setSetType(SetType setType) {
        this.setType = setType;
    }

    public Set<Attribute> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(Set<Attribute> attributes) {
        this.attributes = attributes;
    }
}
