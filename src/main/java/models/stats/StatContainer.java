package models.stats;

import java.util.ArrayList;

public class StatContainer {
    private final StatBase statBase;
    private ArrayList<StatIncrease> statIncreases = new ArrayList<>();

    public StatContainer(StatBase statBase) {
        this.statBase = statBase;
    }

    public int getStatBonus(StatType type) {
        //This is a ubiquitous formula for TTRPG stat bonuses
        return (getRawStat(type) / 2) - 5;
    }

    public int getRawStat(StatType type) {
        return getBaseStat(type) + getStatIncreases(type);
    }

    public int getBaseStat(StatType type) {
        switch (type) {
            case STR:
                return statBase.getStr();
            case DEX:
                return statBase.getDex();
            case CON:
                return statBase.getCon();
            case INT:
                return statBase.getInt();
            case WIS:
                return statBase.getWis();
            case CHA:
                return statBase.getCha();
            default:
                return 0;
        }
    }

    public int getStatIncreases(StatType type) {
        int totalIncrease = 0;

        for (StatIncrease increase : statIncreases) {
            switch (type) {
                case STR:
                    totalIncrease += increase.getStr();
                    break;
                case DEX:
                    totalIncrease += increase.getDex();
                    break;
                case CON:
                    totalIncrease += increase.getCon();
                    break;
                case INT:
                    totalIncrease += increase.getIntl();
                    break;
                case WIS:
                    totalIncrease += increase.getWis();
                    break;
                case CHA:
                    totalIncrease += increase.getCha();
                    break;
                default:
                    totalIncrease += 0;
            }
        }

        return totalIncrease;
    }

    public ArrayList<StatIncrease> getStatIncreases() {
        return statIncreases;
    }

    public void addStatIncrease(StatIncrease increase) {
        statIncreases.add(increase);
    }

    public StatBase getStatBase() {
        return statBase;
    }

    public void setStatIncreases(ArrayList<StatIncrease> statIncreases) {
        this.statIncreases = statIncreases;
    }
}
