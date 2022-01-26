package blacksonata.game;

import blacksonata.view.ImageUtil;

import java.awt.Image;

public enum Attribute {
    CHAIN("attribute-chain-solid.jpg", "attribute-chain-faded.jpg"),
    CROWN("attribute-crown-solid.jpg", "attribute-crown-faded.jpg"),
    HEART("attribute-heart-solid.jpg", "attribute-heart-faded.jpg"),
    MUSIC("attribute-music-solid.jpg", "attribute-music-faded.jpg"),
    QUILL("attribute-quill-solid.jpg", "attribute-quill-faded.jpg"),
    RATTLE("attribute-rattle-solid.jpg", "attribute-rattle-faded.jpg"),
    RING("attribute-ring-solid.jpg", "attribute-ring-faded.jpg");    

    private Image solidImage;
    private Image fadedImage;

    Attribute(String solidName, String fadedName){
        this.solidImage = ImageUtil.get(solidName, 170);
        this.fadedImage = ImageUtil.get(fadedName, 170);
    }

    public Image getSolidImage(){ return this.solidImage; }
    public Image getFadedImage(){ return this.fadedImage; }
}
