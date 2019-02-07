package de.destiny19.player;

public class PlayerInventory {
    private int nGold;
    private int nWood;
    private int nStone;
    private int nCopper;
    private int nIron;
    private int nSteel;
    private int nObisidian;
    private int nEntHearth;
    private int nDeamonSoul;
    private int nFlameEssence;
    private int nIceEssence;
    private int nDarkEssence;
    private int nLightEssence;
    private int nPinkFluffyUnicornHorn;

    PlayerInventory(int _nGold, int _nWood, int _nStone, int _nCopper, int _nIron, int _nSteel, int _nObisidian, int _nEntHearth, int _nDeamonSoul, int _nFlameEssence, int _nIceEssence, int _nDarkEssence, int _nLightEssence, int _nPinkFluffyUnicornHorn) {
        nGold = _nGold;
        nWood = _nWood;
        nStone = _nStone;
        nCopper = _nCopper;
        nIron = _nIron;
        nSteel = _nSteel;
        nObisidian = _nObisidian;
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
        nObisidian += _nObisidian;
    }

    public void removeObsidian (int _nObsidian) {
        nObisidian -= _nObsidian;
    }

    public int getObisdian () {
        return nObisidian;
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