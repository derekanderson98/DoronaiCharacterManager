package models;

import exceptions.BadDataException;

import java.util.ArrayList;

public class DiceRoll {
    private int numDice;
    private int dieType;
    private int minimum;
    private ArrayList<Integer> rolls;

    public int getNumDice() {
        return numDice;
    }

    public void setNumDice(int numDice) {
        this.numDice = numDice;
    }

    public int getDieType() {
        return dieType;
    }

    public void setDieType(int dieType) {
        this.dieType = dieType;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public ArrayList<Integer> getRolls() {
        return rolls;
    }

    public void setRolls(ArrayList<Integer> rolls) throws BadDataException {
        if (rolls.size() != numDice) throw new BadDataException();

        for (Integer roll : rolls) {
            if ((roll < 1) || (roll > dieType)) throw new BadDataException();
        }

        this.rolls = rolls;
    }

    public int getRollResult() throws BadDataException {
        if (rolls.size() != numDice) throw new BadDataException();

        int result = 0;

        for (Integer roll : rolls) {
            if (roll < minimum) {
                result += minimum;
            }
            else {
                result += roll;
            }
        }

        return result;
    }
}
