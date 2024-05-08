package models.resourcePools;

import models.stats.StatType;

import java.util.ArrayList;

public class ResourcePool {
    private String name;
    private ArrayList<StatType> floorStatBonusType;
    private ArrayList<StatType> ladderStatBonusType;
    private ArrayList<StatType> capStatBonusType;
    private int floor;
}
