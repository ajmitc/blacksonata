package blacksonata;

import javax.swing.SwingUtilities;

import blacksonata.view.View;

public class Main{
    public static void main(String ... args){
        Model model = new Model();
        View view = new View(model);
        new Controller(model, view);

        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                view.getFrame().setVisible(true);
            }
        });
    }
}

