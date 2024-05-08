package models.stats;

public class StatIncrease {
    private String name;
    private int str;
    private int dex;
    private int con;
    private int intl;
    private int wis;
    private int cha;

    public StatIncrease(String name, int str, int dex, int con, int intl, int wis, int cha) {
        this.name = name;
        this.str = str;
        this.dex = dex;
        this.con = con;
        this.intl = intl;
        this.wis = wis;
        this.cha = cha;
    }

    public String getName() {
        return name;
    }

    public int getStr() {
        return str;
    }

    public int getDex() {
        return dex;
    }

    public int getCon() {
        return con;
    }

    public int getIntl() {
        return intl;
    }

    public int getWis() {
        return wis;
    }

    public int getCha() {
        return cha;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public void setIntl(int intl) {
        this.intl = intl;
    }

    public void setWis(int wis) {
        this.wis = wis;
    }

    public void setCha(int cha) {
        this.cha = cha;
    }
}
