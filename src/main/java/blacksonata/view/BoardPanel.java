package blacksonata.view;

import blacksonata.Model;
import blacksonata.game.Suspect;
import java.awt.*;
import java.awt.Image;
import javax.swing.*;

public class BoardPanel extends JPanel{
    public static final int BOARD_XOFFSET = 150;
    private static final int DARK_LADY_YOFFSET = 115;
    private static final int BOARD_WIDTH = 1150;

    private Model model;
    private View view;
    private Image boardImage;

    public BoardPanel(Model model, View view){
        super();
        this.model = model;
        this.view = view;

        boardImage = ImageUtil.get("board.jpg", BOARD_WIDTH);
    }

    @Override
    public void paintComponent(Graphics graphics){
        if (model.getGame() == null)
            return;
        Graphics2D g = (Graphics2D) graphics;

        // Draw Dark Lady Card back
        g.drawImage(model.getGame().getDarkLady().getImageBack(), 0, DARK_LADY_YOFFSET, null);

        // Draw board
        g.drawImage(boardImage, BOARD_XOFFSET, 0, null);

        // TODO Draw possible locations
        // TODO Mark unvisited locations
        // TODO Draw player location
    }
}
