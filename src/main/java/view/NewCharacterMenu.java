package view;

import control.json.JsonInterpreter;
import models.character.CharacterSheet;
import models.movementSpeed.MovementSpeed;
import models.skills.SkillsList;
import models.species.SpeciesIndex;
import models.species.SpeciesInfo;
import models.stats.StatBlock;
import models.stats.StatContainer;
import models.stats.StatRoll;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class NewCharacterMenu {
    public static final String DEFAULT_SKILLS_RESOURCE = "defaultSkills.json";
    public static final String SPECIES_INFO_RESOURCE = "speciesInfo.json";

    private final SpeciesIndex speciesIndex;
    private final SkillsList defaultSkillsList;
    private final JFrame menuFrame;

    private final JTabbedPane statOptions;

    private final JPanel statBlock;
    private JTextField strBlock;
    private JTextField dexBlock;
    private JTextField conBlock;
    private JTextField intBlock;
    private JTextField wisBlock;
    private JTextField chaBlock;

    private final JPanel statRoll;
    private JTextField strRoll1;
    private JTextField strRoll2;
    private JTextField strRoll3;
    private JTextField strRoll4;
    private JTextField dexRoll1;
    private JTextField dexRoll2;
    private JTextField dexRoll3;
    private JTextField dexRoll4;
    private JTextField conRoll1;
    private JTextField conRoll2;
    private JTextField conRoll3;
    private JTextField conRoll4;
    private JTextField intRoll1;
    private JTextField intRoll2;
    private JTextField intRoll3;
    private JTextField intRoll4;
    private JTextField wisRoll1;
    private JTextField wisRoll2;
    private JTextField wisRoll3;
    private JTextField wisRoll4;
    private JTextField chaRoll1;
    private JTextField chaRoll2;
    private JTextField chaRoll3;
    private JTextField chaRoll4;

    private final JComboBox<String> speciesSelect;

    private final JTextField charName;

    private JButton createButton;
    private final JTextArea errorText;

    public NewCharacterMenu() {
        speciesIndex = JsonInterpreter.readFromResource(SPECIES_INFO_RESOURCE, SpeciesIndex.class);
        defaultSkillsList = JsonInterpreter.readFromResource(DEFAULT_SKILLS_RESOURCE, SkillsList.class);

        menuFrame = new JFrame();
        menuFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                menuFrame.dispose();
            }
        });
        menuFrame.setSize(1000, 1000);
        menuFrame.setLayout(new GridLayout(4, 1));

        statOptions = new JTabbedPane();
        statOptions.setSize(1000, 500);
        statBlock = new JPanel();
        statBlock.setLayout(new GridLayout(6, 2, 20, 20));
        statRoll = new JPanel();
        statRoll.setLayout(new GridLayout(6, 5, 20, 20));

        setupStatBlock();
        setupStatRoll();
        statOptions.add("Statblock", statBlock);
        statOptions.add("Roll for stats", statRoll);

        Object[] speciesNamesRaw = speciesIndex.getSpeciesNames().toArray();
        String[] speciesNames = Arrays.copyOf(speciesNamesRaw, speciesNamesRaw.length, String[].class);
        speciesSelect = new JComboBox<String>(speciesNames);

        JPanel nameBox = new JPanel();
        nameBox.setLayout(new GridLayout(2, 1));
        nameBox.add(new JLabel("Name:"));
        charName = new JTextField();
        nameBox.add(charName);

        JPanel infoChoicePane = new JPanel();
        infoChoicePane.setLayout(new GridLayout(1, 2));
        infoChoicePane.add(nameBox);
        infoChoicePane.add(speciesSelect);

        createButton = new JButton("Create Character");
        errorText = new JTextArea("Error: could not create");
        errorText.setVisible(false);
        errorText.setEditable(false);
        createButton.addActionListener(createButtonActionListener());

        menuFrame.add(statOptions);
        menuFrame.add(infoChoicePane);
        menuFrame.add(createButton);
        menuFrame.add(errorText);

    }

    public void makeNewCharacter() {
        menuFrame.setVisible(true);
    }

    private void setupStatBlock() {
        JTextField strLabel = new JTextField("STR:");
        strLabel.setEditable(false);
        strBlock = new JTextField();
        statBlock.add(strLabel);
        statBlock.add(strBlock);
        JTextField dexLabel = new JTextField("DEX:");
        dexLabel.setEditable(false);
        dexBlock = new JTextField();
        statBlock.add(dexLabel);
        statBlock.add(dexBlock);
        JTextField conLabel = new JTextField("CON:");
        conLabel.setEditable(false);
        conBlock = new JTextField();
        statBlock.add(conLabel);
        statBlock.add(conBlock);
        JTextField intLabel = new JTextField("INT:");
        intLabel.setEditable(false);
        intBlock = new JTextField();
        statBlock.add(intLabel);
        statBlock.add(intBlock);
        JTextField wisLabel = new JTextField("WIS:");
        wisLabel.setEditable(false);
        wisBlock = new JTextField();
        statBlock.add(wisLabel);
        statBlock.add(wisBlock);
        JTextField chaLabel = new JTextField("CHA:");
        chaLabel.setEditable(false);
        chaBlock = new JTextField();
        statBlock.add(chaLabel);
        statBlock.add(chaBlock);
    }

    private void setupStatRoll() {
        JTextField strLabel = new JTextField("STR:");
        strLabel.setEditable(false);
        strRoll1 = new JTextField();
        strRoll2 = new JTextField();
        strRoll3 = new JTextField();
        strRoll4 = new JTextField();
        statRoll.add(strLabel);
        statRoll.add(strRoll1);
        statRoll.add(strRoll2);
        statRoll.add(strRoll3);
        statRoll.add(strRoll4);
        JTextField dexLabel = new JTextField("DEX:");
        dexLabel.setEditable(false);
        dexRoll1 = new JTextField();
        dexRoll2 = new JTextField();
        dexRoll3 = new JTextField();
        dexRoll4 = new JTextField();
        statRoll.add(dexLabel);
        statRoll.add(dexRoll1);
        statRoll.add(dexRoll2);
        statRoll.add(dexRoll3);
        statRoll.add(dexRoll4);
        JTextField conLabel = new JTextField("CON:");
        conLabel.setEditable(false);
        conRoll1 = new JTextField();
        conRoll2 = new JTextField();
        conRoll3 = new JTextField();
        conRoll4 = new JTextField();
        statRoll.add(conLabel);
        statRoll.add(conRoll1);
        statRoll.add(conRoll2);
        statRoll.add(conRoll3);
        statRoll.add(conRoll4);
        JTextField intLabel = new JTextField("INT:");
        intLabel.setEditable(false);
        intRoll1 = new JTextField();
        intRoll2 = new JTextField();
        intRoll3 = new JTextField();
        intRoll4 = new JTextField();
        statRoll.add(intLabel);
        statRoll.add(intRoll1);
        statRoll.add(intRoll2);
        statRoll.add(intRoll3);
        statRoll.add(intRoll4);
        JTextField wisLabel = new JTextField("WIS:");
        wisLabel.setEditable(false);
        wisRoll1 = new JTextField();
        wisRoll2 = new JTextField();
        wisRoll3 = new JTextField();
        wisRoll4 = new JTextField();
        statRoll.add(wisLabel);
        statRoll.add(wisRoll1);
        statRoll.add(wisRoll2);
        statRoll.add(wisRoll3);
        statRoll.add(wisRoll4);
        JTextField chaLabel = new JTextField("CHA:");
        chaLabel.setEditable(false);
        chaRoll1 = new JTextField();
        chaRoll2 = new JTextField();
        chaRoll3 = new JTextField();
        chaRoll4 = new JTextField();
        statRoll.add(chaLabel);
        statRoll.add(chaRoll1);
        statRoll.add(chaRoll2);
        statRoll.add(chaRoll3);
        statRoll.add(chaRoll4);
    }

    private ActionListener createButtonActionListener() {
        return e -> {
            CharacterSheet characterSheet = new CharacterSheet();

            StatContainer characterStats = null;
            if (statOptions.getSelectedComponent() == statBlock) {
                characterStats = getStatBlock();
            }
            else if (statOptions.getSelectedComponent() == statRoll) {
                characterStats = getStatRoll();
            }
            if (characterStats == null) return;
            characterSheet.setStats(characterStats);

            characterSheet.addSkills(defaultSkillsList);

            SpeciesInfo species = speciesIndex.getSpecies(speciesSelect.getSelectedItem().toString());
            if (species == null) return;
            if (species.getDoubledDigSpeed() != null) {
                characterSheet.setSpecies(species.getSpeciesName(), new MovementSpeed(
                        species.getWalkSpeed(),
                        species.getDoubledDigSpeed(),
                        species.getSwimSpeed(),
                        species.getFlySpeed(),
                        species.getClimbSpeed()));
            } else {
                characterSheet.setSpecies(species.getSpeciesName(), new MovementSpeed(
                        species.getWalkSpeed(),
                        species.getSwimSpeed(),
                        species.getFlySpeed(),
                        species.getClimbSpeed()));
            }

            characterSheet.setName(charName.getText());

            menuFrame.dispose();
            CharacterSheetDisplay sheetDisplay = new CharacterSheetDisplay(characterSheet);
            sheetDisplay.showDisplay();
        };
    }

    private StatContainer getStatBlock() {
        if (strBlock.getText().isEmpty() ||
                dexBlock.getText().isEmpty() ||
                conBlock.getText().isEmpty() ||
                intBlock.getText().isEmpty() ||
                wisBlock.getText().isEmpty() ||
                chaBlock.getText().isEmpty()) {
            errorText.setText("Error: not all fields filled");
            errorText.setVisible(true);
            return null;
        }

        int str;
        int dex;
        int con;
        int intl;
        int wis;
        int cha;

        try {
            str = Integer.parseInt(strBlock.getText());
            dex = Integer.parseInt(dexBlock.getText());
            con = Integer.parseInt(conBlock.getText());
            intl = Integer.parseInt(intBlock.getText());
            wis = Integer.parseInt(wisBlock.getText());
            cha = Integer.parseInt(chaBlock.getText());
        }
        catch (Exception exception) {
            errorText.setText("Error: fields must be numbers");
            errorText.setVisible(true);
            return null;
        }

        if (str <= 0 ||
                dex <= 0 ||
                con <= 0 ||
                intl <= 0 ||
                wis <= 0 ||
                cha <= 0) {
            errorText.setText("Error: fields must be at least 1");
            errorText.setVisible(true);
            return null;
        }

        return new StatContainer(new StatBlock(str, dex, con, intl, wis, cha));
    }

    private StatContainer getStatRoll() {
        if (strRoll1.getText().isEmpty() ||
                strRoll2.getText().isEmpty() ||
                strRoll3.getText().isEmpty() ||
                strRoll4.getText().isEmpty() ||
                dexRoll1.getText().isEmpty() ||
                dexRoll2.getText().isEmpty() ||
                dexRoll3.getText().isEmpty() ||
                dexRoll4.getText().isEmpty() ||
                conRoll1.getText().isEmpty() ||
                conRoll2.getText().isEmpty() ||
                conRoll3.getText().isEmpty() ||
                conRoll4.getText().isEmpty() ||
                intRoll1.getText().isEmpty() ||
                intRoll2.getText().isEmpty() ||
                intRoll3.getText().isEmpty() ||
                intRoll4.getText().isEmpty() ||
                wisRoll1.getText().isEmpty() ||
                wisRoll2.getText().isEmpty() ||
                wisRoll3.getText().isEmpty() ||
                wisRoll4.getText().isEmpty() ||
                chaRoll1.getText().isEmpty() ||
                chaRoll2.getText().isEmpty() ||
                chaRoll3.getText().isEmpty() ||
                chaRoll4.getText().isEmpty()) {
            errorText.setText("Error: not all fields filled");
            errorText.setVisible(true);
            return null;
        }

        ArrayList<Integer> str = new ArrayList<>();
        ArrayList<Integer> dex = new ArrayList<>();
        ArrayList<Integer> con = new ArrayList<>();
        ArrayList<Integer> intl = new ArrayList<>();
        ArrayList<Integer> wis = new ArrayList<>();
        ArrayList<Integer> cha = new ArrayList<>();

        try {
            str.add(Integer.parseInt(strRoll1.getText()));
            str.add(Integer.parseInt(strRoll2.getText()));
            str.add(Integer.parseInt(strRoll3.getText()));
            str.add(Integer.parseInt(strRoll4.getText()));
            dex.add(Integer.parseInt(dexRoll1.getText()));
            dex.add(Integer.parseInt(dexRoll2.getText()));
            dex.add(Integer.parseInt(dexRoll3.getText()));
            dex.add(Integer.parseInt(dexRoll4.getText()));
            con.add(Integer.parseInt(conRoll1.getText()));
            con.add(Integer.parseInt(conRoll2.getText()));
            con.add(Integer.parseInt(conRoll3.getText()));
            con.add(Integer.parseInt(conRoll4.getText()));
            intl.add(Integer.parseInt(intRoll1.getText()));
            intl.add(Integer.parseInt(intRoll2.getText()));
            intl.add(Integer.parseInt(intRoll3.getText()));
            intl.add(Integer.parseInt(intRoll4.getText()));
            wis.add(Integer.parseInt(wisRoll1.getText()));
            wis.add(Integer.parseInt(wisRoll2.getText()));
            wis.add(Integer.parseInt(wisRoll3.getText()));
            wis.add(Integer.parseInt(wisRoll4.getText()));
            cha.add(Integer.parseInt(chaRoll1.getText()));
            cha.add(Integer.parseInt(chaRoll2.getText()));
            cha.add(Integer.parseInt(chaRoll3.getText()));
            cha.add(Integer.parseInt(chaRoll4.getText()));
        }
        catch (Exception exception) {
            errorText.setText("Error: fields must be numbers");
            errorText.setVisible(true);
            return null;
        }

        for (Integer roll : str) {
            if (roll <= 0 || roll > 6) {
                errorText.setText("Error: fields must be between 1 and 6");
                errorText.setVisible(true);
                return null;
            }
        }
        for (Integer roll : dex) {
            if (roll <= 0 || roll > 6) {
                errorText.setText("Error: fields must be between 1 and 6");
                errorText.setVisible(true);
                return null;
            }
        }
        for (Integer roll : con) {
            if (roll <= 0 || roll > 6) {
                errorText.setText("Error: fields must be between 1 and 6");
                errorText.setVisible(true);
                return null;
            }
        }
        for (Integer roll : intl) {
            if (roll <= 0 || roll > 6) {
                errorText.setText("Error: fields must be between 1 and 6");
                errorText.setVisible(true);
                return null;
            }
        }
        for (Integer roll : wis) {
            if (roll <= 0 || roll > 6) {
                errorText.setText("Error: fields must be between 1 and 6");
                errorText.setVisible(true);
                return null;
            }
        }
        for (Integer roll : cha) {
            if (roll <= 0 || roll > 6) {
                errorText.setText("Error: fields must be at least 1");
                errorText.setVisible(true);
                return null;
            }
        }

        return new StatContainer(new StatRoll(str, dex, con, intl, wis, cha));
    }
}
