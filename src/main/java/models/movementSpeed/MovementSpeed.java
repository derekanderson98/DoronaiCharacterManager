package models.movementSpeed;

import models.modifiers.Modifier;

import java.util.ArrayList;

public class MovementSpeed {
    final static int DEFAULT_DOUBLED_DIG = 1;

    final static int DEFAULT_IMPROVEMENT = 5;
    final static int DIG_IMPROVEMENT = 1;
    final static int FLY_IMPROVEMENT = 10;

    private final int baseWalkSpeed;
    private final int baseDoubledDigSpeed;
    private final int baseSwimSpeed;
    private final int baseFlySpeed;
    private final int baseClimbSpeed;

    private int walkImprovements = 0;
    private int digImprovements = 0;
    private int swimImprovements = 0;
    private int flyImprovements = 0;
    private int climbImprovements = 0;

    private int walkTalents = 0;
    private int digTalents = 0;
    private int swimTalents = 0;
    private int flyTalents = 0;
    private int climbTalents = 0;

    private ArrayList<Modifier> walkModifiers = new ArrayList<>();
    private ArrayList<Modifier> doubleDigModifiers = new ArrayList<>();
    private ArrayList<Modifier> swimModifiers = new ArrayList<>();
    private ArrayList<Modifier> flyModifiers = new ArrayList<>();
    private ArrayList<Modifier> climbModifiers = new ArrayList<>();

    public MovementSpeed(int walk, int swim, int fly, int climb) {
        this(walk, DEFAULT_DOUBLED_DIG, swim, fly, climb);
    }

    public MovementSpeed(int walk, int doubledDig, int swim, int fly, int climb) {
        baseWalkSpeed = walk;
        baseDoubledDigSpeed = doubledDig;
        baseSwimSpeed = swim;
        baseFlySpeed = fly;
        baseClimbSpeed = climb;
    }

    public int getWalk() {
        return baseWalkSpeed + ((walkImprovements + walkTalents) * DEFAULT_IMPROVEMENT) + walkModifiers();
    }

    public int getDoubledDig() {
        return baseDoubledDigSpeed + ((digImprovements + digTalents) * DIG_IMPROVEMENT) + doubledDigModifiers();
    }

    public float getDig() {
        return (float)getDoubledDig() / 2;
    }

    public int getSwim() {
        return baseSwimSpeed + ((swimImprovements + swimTalents) * DEFAULT_IMPROVEMENT) + swimModifiers();
    }

    public int getFly() {
        return baseFlySpeed + ((flyImprovements + flyTalents) * FLY_IMPROVEMENT) + flyModifiers();
    }

    public int getClimb() {
        return baseClimbSpeed + ((climbImprovements + climbTalents) * DEFAULT_IMPROVEMENT) + climbModifiers();
    }

    public int getWalkImprovements() {
        return walkImprovements;
    }

    public int getDigImprovements() {
        return digImprovements;
    }

    public int getSwimImprovements() {
        return swimImprovements;
    }

    public int getFlyImprovements() {
        return flyImprovements;
    }

    public int getClimbImprovements() {
        return climbImprovements;
    }

    public void addWalkImprovement() {
        walkImprovements++;
    }

    public void addDigImprovement() {
        digImprovements++;
    }

    public void addSwimImprovement() {
        swimImprovements++;
    }

    public void addFlyImprovement() {
        flyImprovements++;
    }

    public void addClimbImprovements() {
        climbImprovements++;
    }

    public int getWalkTalents() {
        return walkTalents;
    }

    public int getDigTalents() {
        return digTalents;
    }

    public int getSwimTalents() {
        return swimTalents;
    }

    public int getFlyTalents() {
        return flyTalents;
    }

    public int getClimbTalents() {
        return climbTalents;
    }

    public void addWalkTalent() {
        walkTalents++;
    }

    public void addDigTalent() {
        digTalents++;
    }

    public void addSwimTalent() {
        swimTalents++;
    }

    public void addFlyTalent() {
        flyTalents++;
    }

    public void addClimbTalent() {
        climbTalents++;
    }

    public ArrayList<Modifier> getWalkModifiers() {
        return walkModifiers;
    }

    public ArrayList<Modifier> getDoubleDigModifiers() {
        return doubleDigModifiers;
    }

    public ArrayList<Modifier> getSwimModifiers() {
        return swimModifiers;
    }

    public ArrayList<Modifier> getFlyModifiers() {
        return flyModifiers;
    }

    public ArrayList<Modifier> getClimbModifiers() {
        return climbModifiers;
    }

    public void addWalkMod(Modifier mod) {
        walkModifiers.add(mod);
    }

    public void addDoubledDigMod(Modifier mod) {
        doubleDigModifiers.add(mod);
    }

    public void addSwimMod(Modifier mod) {
        swimModifiers.add(mod);
    }

    public void addFlyMod(Modifier mod) {
        flyModifiers.add(mod);
    }

    public void addClimbMod(Modifier mod) {
        climbModifiers.add(mod);
    }

    private int walkModifiers() {
        int walkMod = 0;
        for (Modifier mod : walkModifiers) {
            walkMod += mod.getValue();
        }
        return walkMod;
    }

    private int doubledDigModifiers() {
        int digMod = 0;
        for (Modifier mod : doubleDigModifiers) {
            digMod += mod.getValue();
        }
        return digMod;
    }

    private int swimModifiers() {
        int swimMod = 0;
        for (Modifier mod : swimModifiers) {
            swimMod += mod.getValue();
        }
        return swimMod;
    }

    private int flyModifiers() {
        int flyMod = 0;
        for (Modifier mod : flyModifiers) {
            flyMod += mod.getValue();
        }
        return flyMod;
    }

    private int climbModifiers() {
        int climbMod = 0;
        for (Modifier mod : climbModifiers) {
            climbMod += mod.getValue();
        }
        return climbMod;
    }

    public int getBaseWalkSpeed() {
        return baseWalkSpeed;
    }

    public int getBaseDoubledDigSpeed() {
        return baseDoubledDigSpeed;
    }

    public int getBaseSwimSpeed() {
        return baseSwimSpeed;
    }

    public int getBaseFlySpeed() {
        return baseFlySpeed;
    }

    public int getBaseClimbSpeed() {
        return baseClimbSpeed;
    }

    public void setWalkImprovements(int walkImprovements) {
        this.walkImprovements = walkImprovements;
    }

    public void setDigImprovements(int digImprovements) {
        this.digImprovements = digImprovements;
    }

    public void setSwimImprovements(int swimImprovements) {
        this.swimImprovements = swimImprovements;
    }

    public void setFlyImprovements(int flyImprovements) {
        this.flyImprovements = flyImprovements;
    }

    public void setClimbImprovements(int climbImprovements) {
        this.climbImprovements = climbImprovements;
    }

    public void setWalkTalents(int walkTalents) {
        this.walkTalents = walkTalents;
    }

    public void setDigTalents(int digTalents) {
        this.digTalents = digTalents;
    }

    public void setSwimTalents(int swimTalents) {
        this.swimTalents = swimTalents;
    }

    public void setFlyTalents(int flyTalents) {
        this.flyTalents = flyTalents;
    }

    public void setClimbTalents(int climbTalents) {
        this.climbTalents = climbTalents;
    }

    public void setWalkModifiers(ArrayList<Modifier> walkModifiers) {
        this.walkModifiers = walkModifiers;
    }

    public void setDoubleDigModifiers(ArrayList<Modifier> doubleDigModifiers) {
        this.doubleDigModifiers = doubleDigModifiers;
    }

    public void setSwimModifiers(ArrayList<Modifier> swimModifiers) {
        this.swimModifiers = swimModifiers;
    }

    public void setFlyModifiers(ArrayList<Modifier> flyModifiers) {
        this.flyModifiers = flyModifiers;
    }

    public void setClimbModifiers(ArrayList<Modifier> climbModifiers) {
        this.climbModifiers = climbModifiers;
    }
}
