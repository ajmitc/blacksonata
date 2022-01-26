package blacksonata.view;

import blacksonata.Model;
import blacksonata.game.Suspect;
import java.awt.*;
import javax.swing.*;

public class CluePanel extends JPanel{
    public static final int WIDTH = Suspect.CARD_WIDTH + 10;
    private Model model;
    private View view;

    public CluePanel(Model model, View view){
        super(new BorderLayout());
        this.model = model;
        this.view = view;

        setPreferredSize(new Dimension(WIDTH, 800));
    }

    @Override
    public void paintComponent(Graphics graphics){
        
    }
}
