package blacksonata.game;

public enum SetType {
    ACORN("suspect-back-acorn.png"),
    BLUEBELL("suspect-back-bluebell.png"),
    OAK("suspect-back-oak.png"),
    PURPLE("suspect-back-purple.png"),
    ROSE("suspect-back-rose.png"),
    THISTLE("suspect-back-thistle.png");

    private String imageName;
    SetType(String imageName){
        this.imageName = imageName;
    }

    public String getImageName(){ return imageName; }
}
