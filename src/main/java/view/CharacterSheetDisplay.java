package view;

import control.filePicking.FilePickingManager;
import models.character.CharacterSheet;
import models.skills.Skill;
import models.stats.StatType;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class CharacterSheetDisplay {
    private final CharacterSheet characterSheet;
    private final JFrame sheetDisplay;

    private final JPanel stats;
    private HashMap<StatType, JLabel> statScores;
    private HashMap<StatType, JLabel> statBonuses;

    private final JPanel skills;
    private HashMap<String, JLabel> skillFields;

    private final JPanel movement;
    private JLabel walkSpeed;
    private JLabel digSpeed;
    private JLabel swimSpeed;
    private JLabel flySpeed;
    private JLabel climbSpeed;

    private final JPanel saves;
    private JLabel reflBonus;
    private JLabel fortBonus;
    private JLabel willBonus;

    public CharacterSheetDisplay(CharacterSheet sheet) {
        characterSheet = sheet;

        sheetDisplay = new JFrame();
        sheetDisplay.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                sheetDisplay.dispose();
            }
        });
        sheetDisplay.setSize(1000, 1000);
        sheetDisplay.setLayout(new GridLayout(1, 3));

        stats = new JPanel();
        stats.setLayout(new GridLayout(6, 1, 10, 10));
        statScores = new HashMap<>();
        statBonuses = new HashMap<>();
        setupStatsDisplay();

        skills = new JPanel();
        skillFields = new HashMap<>();
        setupSkillsDisplay();

        JPanel keyInfo = new JPanel();
        keyInfo.setLayout(new GridLayout(2, 1));
        keyInfo.setBorder(new BevelBorder(BevelBorder.LOWERED));

        JPanel nameSpeciesDisplay = new JPanel();
        nameSpeciesDisplay.setLayout(new GridLayout(2, 2));
        nameSpeciesDisplay.add(new JLabel("Name:"));
        nameSpeciesDisplay.add(new JLabel(characterSheet.getName()));
        nameSpeciesDisplay.add(new JLabel("Species:"));
        nameSpeciesDisplay.add(new JLabel(characterSheet.getSpecies()));
        keyInfo.add(nameSpeciesDisplay);

        movement = new JPanel();
        movement.setLayout(new GridLayout(1, 5));
        setupMovementDisplay();
        keyInfo.add(movement);

        saves = new JPanel();
        saves.setLayout(new GridLayout(3, 1));
        setupSavesDisplay();

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            FilePickingManager.saveFile(characterSheet);
            sheetDisplay.dispose();
        });

        JPanel notStats = new JPanel();
        notStats.setLayout(new GridLayout(3, 1));
        notStats.add(keyInfo);
        notStats.add(saves);
        notStats.add(saveButton);

        sheetDisplay.add(stats);
        sheetDisplay.add(skills);
        sheetDisplay.add(notStats);
    }

    public void showDisplay() {
        sheetDisplay.setVisible(true);
    }

    public void updateStats() {
        statBonuses.get(StatType.STR).setText(toBonusString(characterSheet.getStats().getStatBonus(StatType.STR)));
        statScores.get(StatType.STR).setText(Integer.toString(characterSheet.getStats().getRawStat(StatType.STR)));
        statBonuses.get(StatType.DEX).setText(toBonusString(characterSheet.getStats().getStatBonus(StatType.DEX)));
        statScores.get(StatType.DEX).setText(Integer.toString(characterSheet.getStats().getRawStat(StatType.DEX)));
        statBonuses.get(StatType.CON).setText(toBonusString(characterSheet.getStats().getStatBonus(StatType.CON)));
        statScores.get(StatType.CON).setText(Integer.toString(characterSheet.getStats().getRawStat(StatType.CON)));
        statBonuses.get(StatType.INT).setText(toBonusString(characterSheet.getStats().getStatBonus(StatType.INT)));
        statScores.get(StatType.INT).setText(Integer.toString(characterSheet.getStats().getRawStat(StatType.INT)));
        statBonuses.get(StatType.WIS).setText(toBonusString(characterSheet.getStats().getStatBonus(StatType.WIS)));
        statScores.get(StatType.WIS).setText(Integer.toString(characterSheet.getStats().getRawStat(StatType.WIS)));
        statBonuses.get(StatType.CHA).setText(toBonusString(characterSheet.getStats().getStatBonus(StatType.CHA)));
        statScores.get(StatType.CHA).setText(Integer.toString(characterSheet.getStats().getRawStat(StatType.CHA)));
    }

    public void updateMovementSpeeds() {
        walkSpeed.setText(Integer.toString(characterSheet.getMovementSpeed().getWalk()));
        digSpeed.setText(Double.toString(characterSheet.getMovementSpeed().getDig()));
        swimSpeed.setText(Integer.toString(characterSheet.getMovementSpeed().getSwim()));
        flySpeed.setText(Integer.toString(characterSheet.getMovementSpeed().getFly()));
        climbSpeed.setText(Integer.toString(characterSheet.getMovementSpeed().getClimb()));
    }

    public void updateSkills() {
        ArrayList<Skill> skills = characterSheet.getSkills().getSkills();
        for (Skill skill : skills) {
            if (skillFields.containsKey(skill.getName())) {
                skillFields.get(skill.getName()).setText(toBonusString(skill.getBonus(characterSheet.getStats(),
                        characterSheet.getProf())));
            }
        }
    }

    public void updateSaves() {
        reflBonus.setText(toBonusString(characterSheet.getRefl()
                .getBonus(characterSheet.getStats(), characterSheet.getProf())));
        fortBonus.setText(toBonusString(characterSheet.getFort()
                .getBonus(characterSheet.getStats(), characterSheet.getProf())));
        willBonus.setText(toBonusString(characterSheet.getWill()
                .getBonus(characterSheet.getStats(), characterSheet.getProf())));
    }

    private void setupStatsDisplay() {
        stats.add(makeStatBox(StatType.STR, "STR"));
        stats.add(makeStatBox(StatType.DEX, "DEX"));
        stats.add(makeStatBox(StatType.CON, "CON"));
        stats.add(makeStatBox(StatType.INT, "INT"));
        stats.add(makeStatBox(StatType.WIS, "WIS"));
        stats.add(makeStatBox(StatType.CHA, "CHA"));
    }

    private JPanel makeStatBox(StatType statType, String labelString) {
        JPanel box = new JPanel();
        box.setLayout(new GridLayout(3, 1));
        box.setBorder(new BevelBorder(BevelBorder.LOWERED));
        JLabel label = new JLabel(labelString);
        box.add(label);

        JLabel bonus = new JLabel(toBonusString(characterSheet.getStats().getStatBonus(statType)));
        statBonuses.put(statType, bonus);
        box.add(bonus);
        JLabel score = new JLabel(Integer.toString(characterSheet.getStats().getRawStat(statType)));
        statScores.put(statType, score);
        box.add(score);

        return box;
    }

    private void setupSkillsDisplay() {
        ArrayList<Skill> strSkills = characterSheet.getSkills().getSkillsByCategory("STR");
        ArrayList<Skill> dexSkills = characterSheet.getSkills().getSkillsByCategory("DEX");
        ArrayList<Skill> conSkills = characterSheet.getSkills().getSkillsByCategory("CON");
        ArrayList<Skill> intSkills = characterSheet.getSkills().getSkillsByCategory("INT");
        ArrayList<Skill> wisSkills = characterSheet.getSkills().getSkillsByCategory("WIS");
        ArrayList<Skill> chaSkills = characterSheet.getSkills().getSkillsByCategory("CHA");
        ArrayList<Skill> knowledgeSkills = characterSheet.getSkills().getSkillsByCategory("KNOWLEDGE");
        ArrayList<Skill> freeformSkills = characterSheet.getSkills().getSkillsByCategory("FREEFORM");

        if (freeformSkills.size() > 0) {
            skills.setLayout(new GridLayout(8, 1, 10, 10));
        }
        else {
            skills.setLayout(new GridLayout(7, 1, 10, 10));
        }

        JPanel strSkillBox = new JPanel();
        strSkillBox.setLayout(new GridLayout(strSkills.size() + 1, 1));
        strSkillBox.add(new JLabel("STR"));
        for (Skill skill : strSkills) {
            strSkillBox.add(makeSkillRow(skill));
        }
        strSkillBox.setBorder(new BevelBorder(BevelBorder.LOWERED));
        skills.add(strSkillBox);

        JPanel dexSkillBox = new JPanel();
        dexSkillBox.setLayout(new GridLayout(dexSkills.size() + 1, 1));
        dexSkillBox.add(new JLabel("DEX"));
        for (Skill skill : dexSkills) {
            dexSkillBox.add(makeSkillRow(skill));
        }
        dexSkillBox.setBorder(new BevelBorder(BevelBorder.LOWERED));
        skills.add(dexSkillBox);

        JPanel conSkillBox = new JPanel();
        conSkillBox.setLayout(new GridLayout(conSkills.size() + 1, 1));
        conSkillBox.add(new JLabel("CON"));
        for (Skill skill : conSkills) {
            conSkillBox.add(makeSkillRow(skill));
        }
        conSkillBox.setBorder(new BevelBorder(BevelBorder.LOWERED));
        skills.add(conSkillBox);

        JPanel intSkillBox = new JPanel();
        intSkillBox.setLayout(new GridLayout(intSkills.size() + 1, 1));
        intSkillBox.add(new JLabel("INT"));
        for (Skill skill : intSkills) {
            intSkillBox.add(makeSkillRow(skill));
        }
        intSkillBox.setBorder(new BevelBorder(BevelBorder.LOWERED));
        skills.add(intSkillBox);

        JPanel wisSkillBox = new JPanel();
        wisSkillBox.setLayout(new GridLayout(wisSkills.size() + 1, 1));
        wisSkillBox.add(new JLabel("WIS"));
        for (Skill skill : wisSkills) {
            wisSkillBox.add(makeSkillRow(skill));
        }
        wisSkillBox.setBorder(new BevelBorder(BevelBorder.LOWERED));
        skills.add(wisSkillBox);

        JPanel chaSkillBox = new JPanel();
        chaSkillBox.setLayout(new GridLayout(chaSkills.size() + 1, 1));
        chaSkillBox.add(new JLabel("CHA"));
        for (Skill skill : chaSkills) {
            chaSkillBox.add(makeSkillRow(skill));
        }
        chaSkillBox.setBorder(new BevelBorder(BevelBorder.LOWERED));
        skills.add(chaSkillBox);

        JPanel knowledgeSkillBox = new JPanel();
        knowledgeSkillBox.setLayout(new GridLayout(knowledgeSkills.size() + 1, 1));
        knowledgeSkillBox.add(new JLabel("KNOWLEDGE"));
        for (Skill skill : knowledgeSkills) {
            knowledgeSkillBox.add(makeSkillRow(skill));
        }
        knowledgeSkillBox.setBorder(new BevelBorder(BevelBorder.LOWERED));
        skills.add(knowledgeSkillBox);

        if (freeformSkills.size() > 0) {
            JPanel freeformSkillBox = new JPanel();
            freeformSkillBox.setLayout(new GridLayout(freeformSkills.size() + 1, 1));
            freeformSkillBox.add(new JLabel("FREEFORM"));
            for (Skill skill : freeformSkills) {
                freeformSkillBox.add(makeSkillRow(skill));
            }
            freeformSkillBox.setBorder(new BevelBorder(BevelBorder.LOWERED));
            skills.add(freeformSkillBox);
        }
    }

    private void setupMovementDisplay() {
        JPanel walkBox = new JPanel();
        walkBox.setLayout(new GridLayout(2, 1));
        walkSpeed = new JLabel(Integer.toString(characterSheet.getMovementSpeed().getWalk()));
        walkBox.add(new JLabel("Walk:"));
        walkBox.add(walkSpeed);
        walkBox.setBorder(new BevelBorder(BevelBorder.LOWERED));
        movement.add(walkBox);

        JPanel digBox = new JPanel();
        digBox.setLayout(new GridLayout(2, 1));
        digSpeed = new JLabel(Double.toString(characterSheet.getMovementSpeed().getDig()));
        digBox.add(new JLabel("Dig:"));
        digBox.add(digSpeed);
        digBox.setBorder(new BevelBorder(BevelBorder.LOWERED));
        movement.add(digBox);

        JPanel swimBox = new JPanel();
        swimBox.setLayout(new GridLayout(2, 1));
        swimSpeed = new JLabel(Integer.toString(characterSheet.getMovementSpeed().getSwim()));
        swimBox.add(new JLabel("Swim:"));
        swimBox.add(swimSpeed);
        swimBox.setBorder(new BevelBorder(BevelBorder.LOWERED));
        movement.add(swimBox);

        JPanel flyBox = new JPanel();
        flyBox.setLayout(new GridLayout(2, 1));
        flySpeed = new JLabel(Integer.toString(characterSheet.getMovementSpeed().getFly()));
        flyBox.add(new JLabel("Fly:"));
        flyBox.add(flySpeed);
        flyBox.setBorder(new BevelBorder(BevelBorder.LOWERED));
        movement.add(flyBox);

        JPanel climbBox = new JPanel();
        climbBox.setLayout(new GridLayout(2, 1));
        climbSpeed = new JLabel(Integer.toString(characterSheet.getMovementSpeed().getClimb()));
        climbBox.add(new JLabel("Climb:"));
        climbBox.add(climbSpeed);
        climbBox.setBorder(new BevelBorder(BevelBorder.LOWERED));
        movement.add(climbBox);
    }

    private void setupSavesDisplay() {
        JPanel reflBox = new JPanel();
        reflBox.setLayout(new GridLayout(1, 2));
        reflBox.add(new JLabel("REFL"));
        reflBonus = new JLabel(toBonusString(characterSheet.getRefl()
                .getBonus(characterSheet.getStats(), characterSheet.getProf())));
        reflBox.add(reflBonus);
        reflBox.setBorder(new BevelBorder(BevelBorder.LOWERED));
        saves.add(reflBox);

        JPanel fortBox = new JPanel();
        fortBox.setLayout(new GridLayout(1, 2));
        fortBox.add(new JLabel("FORT"));
        fortBonus = new JLabel(toBonusString(characterSheet.getFort()
                .getBonus(characterSheet.getStats(), characterSheet.getProf())));
        fortBox.add(fortBonus);
        fortBox.setBorder(new BevelBorder(BevelBorder.LOWERED));
        saves.add(fortBox);

        JPanel willBox = new JPanel();
        willBox.setLayout(new GridLayout(1, 2));
        willBox.add(new JLabel("WILL"));
        willBonus = new JLabel(toBonusString(characterSheet.getWill()
                .getBonus(characterSheet.getStats(), characterSheet.getProf())));
        willBox.add(willBonus);
        willBox.setBorder(new BevelBorder(BevelBorder.LOWERED));
        saves.add(willBox);
    }

    private JPanel makeSkillRow (Skill skill) {
        JPanel row = new JPanel();
        row.setLayout(new GridLayout(1, 2));
        row.add(new JLabel(skill.getName()));
        JLabel bonusLabel = new JLabel(toBonusString(skill.getBonus(characterSheet.getStats(),
                characterSheet.getProf())));
        skillFields.put(skill.getName(), bonusLabel);
        row.add(bonusLabel);
        return row;
    }

    private String toBonusString(int bonus) {
        if (bonus >= 0) {
            return "+" + bonus;
        }
        else {
            return Integer.toString(bonus);
        }
    }
}
