package models.skills;

import models.stats.StatContainer;
import models.stats.StatType;

public class Save extends Skill {
    int talents = 0;

    public Save(String name, String category, StatType statType) {
        super(name, category, statType);
    }

    @Override
    public int getBonus(StatContainer stats, int proficiency) {
        int bonus = stats.getStatBonus(super.getStatType());
        if (improvements() > 0) bonus += proficiency;
        if (improvements() > 1) bonus += ((improvements() - 1) * EXPERTISE_BONUS);
        bonus += modifiers();
        return bonus;
    }

    public int getTalents() {
        return talents;
    }

    public void addTalent() {
        talents++;
    }

    private int improvements() {
        return super.getImprovements() + talents;
    }

    public void setTalents(int talents) {
        this.talents = talents;
    }
}
