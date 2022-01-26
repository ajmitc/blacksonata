package blacksonata.view;

import blacksonata.Model;
import blacksonata.game.Attribute;
import blacksonata.game.AttributeState;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class AttributePanel extends JPanel{
    private static final Stroke MATCH_STROKE = new BasicStroke(5.f);
    private static final Color MATCH_COLOR = Color.YELLOW;
    private Model model;
    private View view;

    public AttributePanel(Model model, View view){
        super();
        this.model = model;
        this.view = view;
        setPreferredSize(new Dimension(1500, 170));
    }

    public Attribute getSelectedAttribute(int mx, int my){
        int ord = (mx - CluePanel.WIDTH - BoardPanel.BOARD_XOFFSET) / Attribute.CHAIN.getSolidImage().getWidth(null);
        if (ord >= 0 && ord < Attribute.values().length)
            return Attribute.values()[ord];
        return null;
    }

    @Override
    public void paintComponent(Graphics graphics){
        if (model.getGame() == null)
            return;
        Graphics2D g = (Graphics2D) graphics;

        int x = CluePanel.WIDTH + BoardPanel.BOARD_XOFFSET;
        for (Attribute attribute: Attribute.values()){
            AttributeState state = model.getGame().getAttributeStates().get(attribute);
            switch(state){
                case SOLID:{
                    g.drawImage(attribute.getSolidImage(), x, 0, null);
                    break;
                }
                case FADED:{
                    g.drawImage(attribute.getFadedImage(), x, 0, null);
                    break;
                }
                case MATCH:{
                    g.drawImage(attribute.getSolidImage(), x, 0, null);
                    g.setColor(MATCH_COLOR);
                    g.setStroke(MATCH_STROKE);
                    g.drawRect(x, 0, attribute.getSolidImage().getWidth(null), attribute.getSolidImage().getHeight(null));
                    break;
                }
            }
            x += attribute.getSolidImage().getWidth(null);
        }
    }
}
