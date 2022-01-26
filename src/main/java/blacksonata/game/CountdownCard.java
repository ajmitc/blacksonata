package blacksonata.game;

import blacksonata.view.ImageUtil;
import java.awt.Image;

public class CountdownCard extends Card{
    private int round;
    private Image image3;
    private Image image2;
    private Image image1;
    private Image image0;

    public CountdownCard(){
        super(CardType.COUNTDOWN);

        image3 = ImageUtil.get("countdown-2.jpg", "countdown-3.jpg");
        // TODO Rotate image3
        image2 = ImageUtil.get("countdown-2.jpg", "countdown-2.jpg");
        image1 = ImageUtil.get("countdown-0.jpg", "countdown-1.jpg");
        // TODO Rotate image1
        image0 = ImageUtil.get("countdown-0.jpg", "countdown-0.jpg");
    }

    public int getRound() {
        return this.round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void adjRound(int amount) {
        this.round += amount;
    }

    public Image getImage(){
        if (round == 3) return image3;
        if (round == 2) return image2;
        if (round == 1) return image1;
        return image0;
    }
}
