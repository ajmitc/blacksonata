package blacksonata.view;

import blacksonata.Model;
import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel{
    private Model model;
    private View view;

    private BoardPanel boardPanel;
    private AttributePanel attributePanel;
    private CluePanel cluePanel;

    public GamePanel(Model model, View view){
        super(new BorderLayout());
        this.model = model;
        this.view = view;

        boardPanel = new BoardPanel(model, view);
        attributePanel = new AttributePanel(model, view);
        cluePanel = new CluePanel(model, view);

        add(boardPanel, BorderLayout.CENTER);
        add(attributePanel, BorderLayout.SOUTH);
        add(cluePanel, BorderLayout.WEST);
    }

    public void refresh(){
        boardPanel.repaint();
        attributePanel.repaint();
        cluePanel.repaint();
    }

    public BoardPanel getBoardPanel() {
        return this.boardPanel;
    }

    public AttributePanel getAttributePanel() {
        return this.attributePanel;
    }
    public CluePanel getCluePanel() {
        return this.cluePanel;
    }

}
