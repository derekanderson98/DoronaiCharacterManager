package models.stats;

import java.util.ArrayList;
import java.util.Collections;

public class RawStatRoll {
    private ArrayList<Integer> rolls;
    private int stat;

    public RawStatRoll(ArrayList<Integer> rolls) {
        this.rolls = rolls;
        deriveStat();
    }

    public int getStat() {
        return stat;
    }

    private void deriveStat() {
        int lowestRoll = 0;
        for (int i = 1; i < rolls.size(); i++) {
            if (rolls.get(i) < rolls.get(lowestRoll)) lowestRoll = i;
        }

        int stat = 0;
        for (int i = 0; i < rolls.size(); i++) {
            if (i != lowestRoll) stat += rolls.get(i);
        }
        this.stat = stat;
    }

    public ArrayList<Integer> getRolls() {
        return rolls;
    }

    public void setRolls(ArrayList<Integer> rolls) {
        this.rolls = rolls;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }
}
