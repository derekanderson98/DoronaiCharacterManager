import models.character.CharacterSheet;
import view.StartMenu;

import javax.swing.UIManager;

public class Main {
    public static void main(String args[]) {
        try {
            //in testing somehow this makes the linux look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }

        StartMenu startMenu = new StartMenu();
        startMenu.showMenu();
    }
}
