package models.character;

import models.movementSpeed.MovementSpeed;
import models.skills.Save;
import models.skills.Skill;
import models.skills.SkillsList;
import models.stats.StatContainer;
import models.stats.StatType;

import java.util.ArrayList;
import java.util.Collections;

public class CharacterSheet {
    private String name;
    private String species;

    private StatContainer stats;

    private MovementSpeed movementSpeed;

    private SkillsList skills = new SkillsList(new ArrayList<Skill>());
    private Save refl = new Save("reflex", "SAVE", StatType.DEX);
    private Save will = new Save("will", "SAVE", StatType.WIS);
    private Save fort = new Save("fortitude", "SAVE", StatType.CON);

    public void setStats(StatContainer stats) {
        this.stats = stats;
    }

    public void setSpecies(String species, MovementSpeed movementSpeed) {
        this.species = species;
        this.movementSpeed = movementSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSkills(SkillsList newSkills) {
        skills.addSkills(newSkills);
    }

    public void setSkills(SkillsList skills) {
        this.skills = skills;
    }

    public String getSpecies() {
        return species;
    }

    public StatContainer getStats() {
        return stats;
    }

    public MovementSpeed getMovementSpeed() {
        return movementSpeed;
    }

    public SkillsList getSkills() {
        return skills;
    }

    public Save getRefl() {
        return refl;
    }

    public Save getWill() {
        return will;
    }

    public Save getFort() {
        return fort;
    }

    public int getProf() {
        //TODO add proficiency
        return 2;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setMovementSpeed(MovementSpeed movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public void setRefl(Save refl) {
        this.refl = refl;
    }

    public void setWill(Save will) {
        this.will = will;
    }

    public void setFort(Save fort) {
        this.fort = fort;
    }
}
