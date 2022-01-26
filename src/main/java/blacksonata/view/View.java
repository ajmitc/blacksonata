package blacksonata.view;

import blacksonata.Model;

import java.awt.*;
import javax.swing.*;

public class View {
    public static final String MAINMENU = "mainmenu";
    public static final String GAME = "game";

    private Model model;
    private JFrame frame;

    private MainMenuPanel mainMenuPanel;
    private GamePanel gamePanel;

    public View(Model model){
        this.model = model;

        this.frame = new JFrame();
        frame.setTitle("Black Sonata");
        frame.setLocationRelativeTo(null);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        mainMenuPanel = new MainMenuPanel(model, this);
        gamePanel = new GamePanel(model, this);

        frame.getContentPane().setLayout(new CardLayout());
        frame.getContentPane().add(mainMenuPanel, MAINMENU);
        frame.getContentPane().add(gamePanel, GAME);
    }

    public void showMainMenu(){
        show(MAINMENU);
    }

    public void showGame(){
        show(GAME);
    }

    private void show(String card){
        CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
        cardLayout.show(frame.getContentPane(), card);
    }

    public void refresh(){
        gamePanel.refresh();
    }

    public Model getModel(){ return this.model; }
    public JFrame getFrame(){ return this.frame; }

    public MainMenuPanel getMainMenuPanel() {
        return this.mainMenuPanel;
    }
    public GamePanel getGamePanel() {
        return this.gamePanel;
    }
}
