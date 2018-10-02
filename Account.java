package sample;

import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.Map;

public class Account {


    private String name;
    private int attackLvl;
    private int strenghtLvl;
    private int defenceLvl;
    private int combatLvl;
    private int rangeLvl;
    private int mageLvl;
    private int prayLvl;
    private int hitpointLvl;

    private final Map<String, Map<String, String>> allStyleReqEquip = new HashMap<>();
    private final Map<String, String> rangedRecEquip = new HashMap<>();
    private final Map<String, String> meeleRecEquip = new HashMap<>();
    private final Map<String, String> mageReqEquip = new HashMap<>();




    public Account(String name, int attackLvl, int strenghtLvl, int defenceLvl, int rangeLvl, int mageLvl, int prayLvl, int hitpointLvl) {

        allStyleReqEquip.put("ranged", rangedRecEquip);
        allStyleReqEquip.put("meele", meeleRecEquip);
        allStyleReqEquip.put("mage", mageReqEquip);


        this.name = name;
        this.attackLvl = attackLvl;
        this.strenghtLvl = strenghtLvl;
        this.defenceLvl = defenceLvl;
        this.rangeLvl = rangeLvl;
        this.mageLvl = mageLvl;
        this.prayLvl = prayLvl;
        this.hitpointLvl = hitpointLvl;


        double base = 0.25 * (defenceLvl + hitpointLvl + Math.floor(prayLvl / 2));
        double meele = 0.325 * (attackLvl + strenghtLvl);
        double range = 0.325 * (Math.floor(rangeLvl / 2) + rangeLvl);
        double mage = 0.325 * (Math.floor(mageLvl / 2) + mageLvl);

        boolean meeleHighest = meele > mage && meele > range;
        boolean rangeHighest = meele < range && mage < range;
        boolean mageHighest = meele < mage && range < mage;


        if (meeleHighest)
            this.combatLvl = (int) Math.floor(base + meele);
        if (mageHighest)
            this.combatLvl = (int) Math.floor(base + mage);
        if (rangeHighest)
            this.combatLvl = (int) Math.floor(base + range);

        calculateBestRangedGear();
        System.out.println(rangedRecEquip);


    }


    private void calculateBestRangedGear() {

        if ((this.rangeLvl < 20)) {

           if(this.hitpointLvl < 75 && this.defenceLvl < 60){
               rangedRecEquip.put("helm", "cowl");
               rangedRecEquip.put("cape", "team cape");
               rangedRecEquip.put("shield", "book of law");
               rangedRecEquip.put("body", "leather body");
               rangedRecEquip.put("legs", "leather chaps");
               rangedRecEquip.put("gloves", "leather vambraces");
               rangedRecEquip.put("ring", "archer's ring (i)");
               rangedRecEquip.put("amulet", "amulet of fury");
               rangedRecEquip.put("weapon", "shortbow or iron darts");
               rangedRecEquip.put("quiver", "iron arrows");
               rangedRecEquip.put("boots", "leather boots");
           }  if(this.hitpointLvl >= 75){
                rangedRecEquip.put("helm", "cowl");
                rangedRecEquip.put("cape", "team cape");
                rangedRecEquip.put("shield", "book of law");
                rangedRecEquip.put("body", "leather body");
                rangedRecEquip.put("legs", "leather chaps");
                rangedRecEquip.put("gloves", "leather vambraces");
                rangedRecEquip.put("ring", "archer's ring (i)");
                rangedRecEquip.put("amulet", "amulet of fury");
                rangedRecEquip.put("weapon", "shortbow or iron darts");
                rangedRecEquip.put("quiver", "iron arrows");
                rangedRecEquip.put("boots", "leather boots");            }










        } else if(this.rangeLvl < 30){



        }


    }


    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", attackLvl=" + attackLvl +
                ", strenghtLvl=" + strenghtLvl +
                ", defenceLvl=" + defenceLvl +
                ", combatLvl=" + combatLvl +
                ", rangeLvl=" + rangeLvl +
                ", mageLvl=" + mageLvl +
                ", prayLvl=" + prayLvl +
                ", hitpointLvl=" + hitpointLvl +
                ", rangedRecEquip=" + rangedRecEquip +
                '}';
    }


    public String getName() {
        return name;
    }

    public int getAttackLvl() {
        return attackLvl;
    }

    public int getStrenghtLvl() {
        return strenghtLvl;
    }

    public int getDefenceLvl() {
        return defenceLvl;
    }

    public int getCombatLvl() {
        return combatLvl;
    }

    public int getRangeLvl() {
        return rangeLvl;
    }

    public int getMageLvl() {
        return mageLvl;
    }

    public int getPrayLvl() {
        return prayLvl;
    }

    public int getHitpointLvl() {
        return hitpointLvl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttackLvl(int attackLvl) {
        this.attackLvl = attackLvl;
    }

    public void setStrenghtLvl(int strenghtLvl) {
        this.strenghtLvl = strenghtLvl;
    }

    public void setDefenceLvl(int defenceLvl) {
        this.defenceLvl = defenceLvl;
    }

    public void setRangeLvl(int rangeLvl) {
        this.rangeLvl = rangeLvl;
    }

    public void setMageLvl(int mageLvl) {
        this.mageLvl = mageLvl;
    }

    public void setPrayLvl(int prayLvl) {
        this.prayLvl = prayLvl;
    }

    public void setHitpointLvl(int hitpointLvl) {
        this.hitpointLvl = hitpointLvl;
    }

    public Map<String, Map<String, String>> getAllStyleReqEquip() {
        return allStyleReqEquip;
    }

    public Map<String, String> getRangedRecEquip() {
        return rangedRecEquip;
    }

    public Map<String, String> getMeeleRecEquip() {
        return meeleRecEquip;
    }

    public Map<String, String> getMageReqEquip() {
        return mageReqEquip;
    }
}