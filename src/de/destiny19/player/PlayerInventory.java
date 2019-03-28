package de.destiny19.player;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"nGold", "nWood", "nStone", "nCopper", "nIron", "nSteel", "nObsidian", "nEntHearth", "nDeamonSoul", "nFlameEssence", "nIceEssence", "nDarkEssence", "nLightEssence", "nPinkFluffyUnicornHorn"})
@XmlRootElement(name = "playerinventory")
public class PlayerInventory {
    @XmlElement(name="nGold", required = true)
    private int nGold;
    @XmlElement(name="nWood", required = true)
    private int nWood;
    @XmlElement(name="nStone", required = true)
    private int nStone;
    @XmlElement(name="nCopper", required = true)
    private int nCopper;
    @XmlElement(name="nIron", required = true)
    private int nIron;
    @XmlElement(name="nSteel", required = true)
    private int nSteel;
    @XmlElement(name="nObsidian", required = true)
    private int nObsidian;
    @XmlElement(name="nEntHearth", required = true)
    private int nEntHearth;
    @XmlElement(name="nDeamonSoul", required = true)
    private int nDeamonSoul;
    @XmlElement(name="nFlameEssence", required = true)
    private int nFlameEssence;
    @XmlElement(name="nIceEssence", required = true)
    private int nIceEssence;
    @XmlElement(name="nDarkEssence", required = true)
    private int nDarkEssence;
    @XmlElement(name="nLightEssence", required = true)
    private int nLightEssence;
    @XmlElement(name="nPinkFluffyUnicornHorn", required = true)
    private int nPinkFluffyUnicornHorn;

    public PlayerInventory () {
        //PlayerInventory(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    public PlayerInventory(int _nGold, int _nWood, int _nStone, int _nCopper, int _nIron, int _nSteel, int _nObsidian, int _nEntHearth, int _nDeamonSoul, int _nFlameEssence, int _nIceEssence, int _nDarkEssence, int _nLightEssence, int _nPinkFluffyUnicornHorn) {
        nGold = _nGold;
        nWood = _nWood;
        nStone = _nStone;
        nCopper = _nCopper;
        nIron = _nIron;
        nSteel = _nSteel;
        nObsidian = _nObsidian;
        nEntHearth = _nEntHearth;
        nDeamonSoul = _nDeamonSoul;
        nFlameEssence = _nFlameEssence;
        nIceEssence = _nIceEssence;
        nDarkEssence = _nDarkEssence;
        nLightEssence = _nLightEssence;
        nPinkFluffyUnicornHorn = _nPinkFluffyUnicornHorn;
    }

    public void addGold (int _nGold) {
        nGold += _nGold;
    }

    public void removeGold (int _nGold) {
        nGold -= _nGold;
    }

    public int getGold () {
        return nGold;
    }

    public void addWood (int _nWood) {
        nWood += _nWood;
    }

    public void removeWood (int _nWood) {
        nWood -= _nWood;
    }

    public int getWood () {
        return nWood;
    }

    public void addStone (int _nStone) {
        nStone += _nStone;
    }

    public void removeStone (int _nStone) {
        nStone -= _nStone;
    }

    public int getStone () {
        return nStone;
    }

    public void addCopper (int _n) {
        nCopper += _n;
    }

    public void removeCopper (int _nCopper) {
        nCopper -= _nCopper;
    }

    public int getCopper () {
        return nCopper;
    }

    public void addIron (int _nIron) {
        nIron += _nIron;
    }

    public void removeIron (int _nIron) {
        nIron -= _nIron;
    }

    public int getIron () {
        return nIron;
    }

    public void addSteel (int _nSteel) {
        nSteel += _nSteel;
    }

    public void removeSteel (int _nSteel) {
        nSteel -= _nSteel;
    }

    public int getSteel () {
        return nSteel;
    }

    public void addObisian (int _nObisidian) {
        nObsidian += _nObisidian;
    }

    public void removeObsidian (int _nObsidian) {
        nObsidian -= _nObsidian;
    }

    public int getObsidian () {
        return nObsidian;
    }
    
    public void addEntHearth (int _nEntHearth) {
        nEntHearth += _nEntHearth;
    }

    public void removeEntHearth (int _nEntHearth) {
        nEntHearth -= _nEntHearth;
    }

    public int getEntHearth () {
        return nEntHearth;
    }

    public void addDeamonSoul (int _nDeamonSoul) {
        nDeamonSoul += _nDeamonSoul;
    }

    public void removeDeamonSoul (int _nDeamonSoul) {
        nDeamonSoul -= _nDeamonSoul;
    }

    public int getDeamonSoul () {
        return nDeamonSoul;
    }

    public void addFlameEssence (int _nFlameEssence) {
        nFlameEssence += _nFlameEssence;
    }

    public void removeFlameEssence (int _nFlameEssence) {
        nFlameEssence -= _nFlameEssence;
    }

    public int getFlameEssence () {
        return nFlameEssence;
    }

    public void addIceEssence (int _nIceEssence) {
        nIceEssence += _nIceEssence;
    }

    public void removeIceEssece (int _nIceEssence) {
        nIceEssence -= _nIceEssence;
    }

    public int getIceEssence () {
        return nIceEssence;
    }

    public void addDarkEssence (int _nDarkEssence) {
        nDarkEssence += _nDarkEssence;
    }

    public void removeDarkEssence (int _nDarkEssence) {
        nDarkEssence -= _nDarkEssence;
    }

    public int getDarkEssence () {
        return nDarkEssence;
    }

    public void addLightEssence (int _nLightEssence) {
        nLightEssence += _nLightEssence;
    }

    public void removeLightEssence (int _nLightEssence) {
        nLightEssence -= _nLightEssence;
    }

    public int getLightEssence () {
        return nLightEssence;
    }

    public void addPinkFluffyUnicornHorn (int _nPinkFluffyUnicornHorn) {
        nPinkFluffyUnicornHorn += _nPinkFluffyUnicornHorn;
    }

    public void removePinkFluffyUnicornHorn (int _nPinkFluffyUnicornHorn) {
        nPinkFluffyUnicornHorn -= _nPinkFluffyUnicornHorn;
    }

    public int getPinkFluffyUnicornHorn () {
        return nPinkFluffyUnicornHorn;
    }
}