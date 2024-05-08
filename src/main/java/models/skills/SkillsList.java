package models.skills;

import java.util.ArrayList;

public class SkillsList {
    private ArrayList<Skill> skills;

    public SkillsList(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public ArrayList<Skill> getSkillsByCategory(String category) {
        ArrayList<Skill> result = new ArrayList<>();

        for (Skill skill : skills) {
            if (skill.getCategory().equals(category)) result.add(skill);
        }

        return result;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public void addSkills(SkillsList newSkills) {
        ArrayList<Skill> newList = newSkills.getSkills();
        for (Skill newSkill : newList) {
            /*
            Boolean present = false;
            for (Skill oldSkill : skills) {
                if (oldSkill.equals(newSkill)) present = true;
            }
            if (!present) skills.add(newSkill);
                         */
            if (!skills.contains(newSkill)) skills.add(newSkill);
        }
    }
}
