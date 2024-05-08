package models.species;

public class SpeciesInfo {
    private String speciesName;
    private Integer walkSpeed;
    private Integer doubledDigSpeed;
    private Integer flySpeed;
    private Integer swimSpeed;
    private Integer climbSpeed;

    public SpeciesInfo(String speciesName, Integer walkSpeed, Integer doubledDigSpeed, Integer flySpeed, Integer swimSpeed, Integer climbSpeed) {
        this.speciesName = speciesName;
        this.walkSpeed = walkSpeed;
        this.doubledDigSpeed = doubledDigSpeed;
        this.flySpeed = flySpeed;
        this.swimSpeed = swimSpeed;
        this.climbSpeed = climbSpeed;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public Integer getWalkSpeed() {
        return walkSpeed;
    }

    public void setWalkSpeed(Integer walkSpeed) {
        this.walkSpeed = walkSpeed;
    }

    public Integer getDoubledDigSpeed() {
        return doubledDigSpeed;
    }

    public void setDoubledDigSpeed(Integer doubledDigSpeed) {
        this.doubledDigSpeed = doubledDigSpeed;
    }

    public Integer getFlySpeed() {
        return flySpeed;
    }

    public void setFlySpeed(Integer flySpeed) {
        this.flySpeed = flySpeed;
    }

    public Integer getSwimSpeed() {
        return swimSpeed;
    }

    public void setSwimSpeed(Integer swimSpeed) {
        this.swimSpeed = swimSpeed;
    }

    public Integer getClimbSpeed() {
        return climbSpeed;
    }

    public void setClimbSpeed(Integer climbSpeed) {
        this.climbSpeed = climbSpeed;
    }
}
