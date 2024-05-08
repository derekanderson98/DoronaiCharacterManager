package view;

import control.filePicking.FilePickingManager;
import models.character.CharacterSheet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StartMenu {
    private final JFrame menuFrame;

    public StartMenu() {
        menuFrame = new JFrame();
        menuFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                menuFrame.dispose();
            }
        });
        menuFrame.setLayout(new GridLayout(3, 1));
        menuFrame.setSize(500, 500);

        JButton newButton = new JButton("New Character");
        newButton.addActionListener(e -> {
            menuFrame.setVisible(false);
            menuFrame.dispose();
            NewCharacterMenu newCharacterMenu = new NewCharacterMenu();
            newCharacterMenu.makeNewCharacter();
        });

        JButton loadButton = new JButton("Load Character");
        JTextArea errorText = new JTextArea("Error: could not load file");
        errorText.setVisible(false);
        errorText.setEditable(false);
        loadButton.addActionListener(e -> {
            errorText.setVisible(false);
            CharacterSheet characterSheet = FilePickingManager.loadFile(CharacterSheet.class);
            if (characterSheet == null) {
                errorText.setVisible(true);
            }
            else {
                menuFrame.setVisible(false);
                menuFrame.dispose();
                CharacterSheetDisplay sheetDisplay = new CharacterSheetDisplay(characterSheet);
                sheetDisplay.showDisplay();
            }
        });

        menuFrame.add(newButton);
        menuFrame.add(loadButton);
        menuFrame.add(errorText);
    }

    public void showMenu() {
        menuFrame.setVisible(true);
    }
}
