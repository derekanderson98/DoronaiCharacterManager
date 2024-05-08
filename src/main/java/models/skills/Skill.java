package models.skills;

import models.stats.StatContainer;
import models.modifiers.Modifier;
import models.stats.StatType;

import java.util.ArrayList;
import java.util.Arrays;

public class Skill {
    final static int EXPERTISE_BONUS = 2;

    private String name;
    private String category;
    private StatType statType;
    private int improvements = 0;
    private ArrayList<Modifier> modifiers = new ArrayList<Modifier>();

    public Skill(String name, String category, StatType statType) {
        this.name = name;
        this.category = category;
        this.statType = statType;
    }

    public int getBonus(StatContainer stats, int proficiency) {
        int bonus = stats.getStatBonus(statType);
        if (improvements > 0) bonus += proficiency;
        if (improvements > 1) bonus += ((improvements - 1) * EXPERTISE_BONUS);
        bonus += modifiers();
        return bonus;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public StatType getStatType() {
        return statType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStatType(StatType statType) {
        this.statType = statType;
    }

    public int getImprovements() {
        return improvements;
    }

    public void addImprovement() {
        improvements++;
    }

    public ArrayList<Modifier> getModifiers() {
        return modifiers;
    }

    public int modifiers() {
        if (modifiers == null) modifiers = new ArrayList<>();

        int modifier = 0;
        for (Modifier mod : modifiers) {
            modifier += mod.getValue();
        }
        return modifier;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Skill)) {
            return false;
        }

        Skill comparison = (Skill) o;
        return name.equals(comparison.name);
    }

    public void setImprovements(int improvements) {
        this.improvements = improvements;
    }

    public void setModifiers(ArrayList<Modifier> modifiers) {
        this.modifiers = modifiers;
    }
}
