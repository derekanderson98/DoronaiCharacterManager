package models.stats;

import java.util.ArrayList;

public class StatRoll implements StatBase{
    private RawStatRoll str;
    private RawStatRoll dex;
    private RawStatRoll con;
    private RawStatRoll intl;
    private RawStatRoll wis;
    private RawStatRoll cha;

    public StatRoll(ArrayList<Integer> str, ArrayList<Integer> dex, ArrayList<Integer> con, ArrayList<Integer> intl, ArrayList<Integer> wis, ArrayList<Integer> cha) {
        this.str = new RawStatRoll(str);
        this.dex = new RawStatRoll(dex);
        this.con = new RawStatRoll(con);
        this.intl = new RawStatRoll(intl);
        this.wis = new RawStatRoll(wis);
        this.cha = new RawStatRoll(cha);
    }

    public int getStr() {
        return str.getStat();
    }
    public int getDex() {
        return dex.getStat();
    }
    public int getCon() {
        return con.getStat();
    }
    public int getInt() {
        return intl.getStat();
    }
    public int getWis() {
        return wis.getStat();
    }
    public int getCha() {
        return cha.getStat();
    }

    public RawStatRoll getIntl() {
        return intl;
    }

    public void setStr(RawStatRoll str) {
        this.str = str;
    }

    public void setDex(RawStatRoll dex) {
        this.dex = dex;
    }

    public void setCon(RawStatRoll con) {
        this.con = con;
    }

    public void setIntl(RawStatRoll intl) {
        this.intl = intl;
    }

    public void setWis(RawStatRoll wis) {
        this.wis = wis;
    }

    public void setCha(RawStatRoll cha) {
        this.cha = cha;
    }
}
