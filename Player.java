package de.destiny19.Destiny19;

public class Player {
    private int nLevel;
    private int nStatPoints;
    private int nSkillPoints;
    private int nAktEp;
    private int nMaxEp;
    private int nHP;
    private int nAktHP;
    private int nMP;
    private int nAktMP;
    private int nStrength;
    private int nDefence;
    private int nIntelligence;
    private int nSkillLevelFire;
    private int nSkillLevelIce;
    private int nSkillLevelEarth;
    private int nSkillLevelBlood;

    Player(int _nLevel, int _nStatPoints, int _nSkillPoints, int _nAktEp, int _nHP, int _nMP, int _nStrength, int _nDefence, int _nIntelligence, int nSkillLevelFire, int _nSkillLevelIce, int _nSkillLevelEarth, int _nSkillLevelBlood) {
        nLevel = _nLevel;
        nStatPoints = _nStatPoints;
        nSkillPOints = _nSkillPoints;
        nAktEp = _nAktEp;
        nHP = _nHP;
        nMP = _nMP;
        nStrength = _nStrength;
        nDefence = _nDefence;
        nIntelligence = _nIntelligence;
        nSkillLevelFire = _nSkillLevelFire;
        nSkillLevelIce = _nSkillLevelIce;
        nSkillLevelEarth = _nSkillLevelEarth;
        nSkillLevelBlood = _nSkillLevelBlood;
    }

    public void addLevel (int _nLevel) {
        nLevel += _nLevel;
        addStatPoints(3);
        addSkillPoints(1);
        setMaxEp((50 * 3 ^ nLevel));
        addStrength(1);
        addIntelligence(1);
        addHP(5);
        addMP(5);
        addDefence(1);
    }

    public int getLevel () {
        return nLevel;
    }

    public void addStatPoints (int _nStatPoints) {
        nStatPoints += _nStatPoints;
    }

    public void removeStatPoits (int _nStatPoints) {
        nStatPoints -= _nStatPoints;
    }

    public int getStatPoints () {
        return nStatPoints;
    }

    public void addSkillPoints (int _nSkillPoints) {
        nSkillPoints += _nSkillPoints;
    }

    public void removeSkillPoints (int _nSkillPoints) {
        nSkillPoints -= _nSkillPoints;
    }

    public int getSkillPoints () {
        return nSkillPoints;
    }

    public void setMaxEp (int _nMaxEp) {
        nMaxEp = _nMaxEp;
    }

    public void getEp (int _nAktEp) {
        _nAktEp = _nAktEp * 2 ^ nLevel;
        if((nAktEp + _nAktEp) >= nMaxEp){
            nAktEp = 0;
            addLevel(1);
        } else{
            nAktEp += _nAktEp;
        }
    }

    public int getAktEp () {
        return nAktEp;
    }

    public void addHP (int _nHP) {
        nHP += _nHP;
    }

    public int getHP () {
        return 500 + 50 * nHP;
    }
    
    public void setAktHP () {
        nAktHP = getHP();
    }

    public void getHeal (int _nHeal) {
        if((nAktHP += _nHeal) >= nHP) {
            nAktHP += _nHeal;
        } else {
            nAktHP = nHP;
        }
        
    }

    public boolean getDamage (int _nDamage) {
        if((nAktHP -= _nDamage) <= 0) {
            nAktHP = 0;
            return false;
        } else {
            nAktHP -= _nDamage;
            return true;
        }
    }

    public void addMP (int _nMP) {
        nMP += _nMP;
    }

    public void setAktMP () {
        nAktMP = nMP;
    }

    public void getMana (int _nMP) {
        if((nAktMP + _nMP) >= nMP) {
            nAktMP = nMP;
        } else {
            nAktMP += _nMP;
        }
    }

    public bool useMana (int _nMP) {
        if(nAktMP < _nMP) {
            return false;
        } else {
            nAktHP -= _nMP;
            return true;
        }
    }

    public int getMP () {
        return 100 + 10 * nMP;
    }

    public void addStrength (int _nStrength) {
        nStrength += _nStrength;
    }

    public int getStrength () {
        return nStrength;
    }

    public void addDefence (int _nDefence) {
        nDefence += _nDefence;
    }

    public int getDefence () {
        return nDefence;
    }

    public void addIntelligence (int _nIntelligence) {
        nIntelligence += _nIntelligence;
    }

    public int getIntelligence () {
        return nIntelligence;
    }

    public void addSkillLevelFire (int _nSkillLevelFire) {
        nSkillLevelFire += _nSkillLevelFire;
    }

    public int getSkillLevelFire () {
        return nSkillLevelFire;
    }

    public void addSkillLevelIce (int _nSkillLevelIce) {
        nSkillLevelIce += _nSkillLevelIce;
    }

    public int getSkillLevelIce () {
        return nSkillLevelIce;
    }

    public void addSkillLevelEarth (int _nSkillLevelEarth) {
        nSkillLevelEarth += _nSkillLevelEarth;
    }

    public int getSKillLevelEarth () {
        return nSkillLevelEarth;
    }

    public void addSkillLevelBlood (int _nSkillLevelBlood) {
        nSkillLevelBlood += _nSkillLevelBlood;
    }

    public int getSkillLevelBlood () {
        return nSkillLevelBlood;
    }


}