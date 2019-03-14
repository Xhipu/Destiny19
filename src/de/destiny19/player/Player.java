package de.destiny19.player;

public class Player {
    private int nLevel;
    private int nStatPoints;
    private int nSkillPoints;
    private int nEP;
    private int nAktEP;
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

    public Player(int _nLevel, int _nStatPoints, int _nSkillPoints, int _nEP, int _nAktEP, int _nHP,int _nAktHP, int _nMP, int _nAktMP, int _nStrength, int _nDefence, int _nIntelligence, int _nSkillLevelFire, int _nSkillLevelIce, int _nSkillLevelEarth, int _nSkillLevelBlood) {
        nLevel = _nLevel;
        nStatPoints = _nStatPoints;
        nSkillPoints = _nSkillPoints;
        nEP = _nEP;
        nAktEP = _nAktEP;
        nHP = _nHP;
        nAktHP = _nAktHP;
        nMP = _nMP;
        nAktMP = _nAktMP;
        nStrength = _nStrength;
        nDefence = _nDefence;
        nIntelligence = _nIntelligence;
        nSkillLevelFire = _nSkillLevelFire;
        nSkillLevelIce = _nSkillLevelIce;
        nSkillLevelEarth = _nSkillLevelEarth;
        nSkillLevelBlood = _nSkillLevelBlood;
    }

    public int GetLevel () {
        return nLevel;
    }

    public void LevelUp (int _nLevel) {
        nLevel += _nLevel;
        nHP += _nLevel;
        nMP += _nLevel;
        nDefence += _nLevel;
        nSkillPoints += _nLevel;
        nStatPoints += _nLevel;
        nEP *= 2;
    }

    public int GetEP () {
        return nEP;
    }

    public int GetnAktEP () {
        return nAktEP;
    }

    public void AddEP (int _nEP) {
        if((nAktEP + _nEP) >= nEP){
            LevelUp(1);
        }else {
            nAktEP += _nEP;
        }
    }

    public void AddStatPoints (int _nStatPoints) {
        nStatPoints += _nStatPoints;
    }

    public void RemoveStatPoits (int _nStatPoints) {
        nStatPoints -= _nStatPoints;
    }

    public int GetStatPoints () {
        return nStatPoints;
    }

    public void AddSkillPoints (int _nSkillPoints) {
        nSkillPoints += _nSkillPoints;
    }

    public void RemoveSkillPoints (int _nSkillPoints) {
        nSkillPoints -= _nSkillPoints;
    }

    public int GetSkillPoints () {
        return nSkillPoints;
    }

    public void AddHP (int _nHP) {
        nHP += _nHP;
    }

    public int GetHP () {
        return nHP;
    }
    
    public void SetAktHP () {
        nAktHP = nHP;
    }
    
    public int GetAktHP () {
    	return nAktHP;
    }

    public void GetHeal (int _nHeal) {
        if((nAktHP += _nHeal) >= nHP) {
            nAktHP = nHP;
        } else {
            nAktHP += _nHeal;
        }
        
    }

    public boolean GetDamage (int _nDamage) {
        if((nAktHP -= _nDamage) <= 0) {
            nAktHP = 0;
            return false;
        } else {
            nAktHP -= _nDamage;
            return true;
        }
    }

    public void AddMP (int _nMP) {
        nMP += _nMP;
    }

    public void SetAktMP () {
        nAktMP = nMP;
    }
    
    public int GetAktMP () {
    	return nAktMP;
    }

    public void GetMana (int _nMP) {
        if((nAktMP + _nMP) >= nMP) {
            nAktMP = nMP;
        } else {
            nAktMP += _nMP;
        }
    }

    public boolean UseMana (int _nMP) {
        if(nAktMP < _nMP) {
            return false;
        } else {
            nAktMP -= _nMP;
            return true;
        }
    }

    public int GetMP () {
        return nMP;
    }

    public boolean SkillUpStrength () {
        if (nStatPoints >= 1) {
            nStrength++;
            nStatPoints--;
            return true;
        } else {
            return false;
        }
    }

    public void BoostStrength (int _nStrength) {
        nStrength += _nStrength;
    }

    public int GetStrength () {
        return nStrength;
    }

    public boolean SkillUpDefence () {
        if(nStatPoints >= 1) {
            nDefence++;
            nStatPoints--;
            return true;
        }else {
            return false;
        }
    }

    public void BoostDefence (int _nDefence) {
        nDefence += _nDefence;
    }

    public int GetDefence () {
        return nDefence;
    }

    public boolean SkillUpIntelligence () {
        if(nStatPoints >= 1) {
            nIntelligence ++;
            nStatPoints--;
            return true;
        }else{
            return false;
        }
    }

    public void BoostIntelligence (int _nIntelligence) {
        nIntelligence += _nIntelligence;
    }

    public int GetIntelligence () {
        return nIntelligence;
    }

    public boolean IncreaseSkillLevelFire () {
        if(nSkillPoints >= 1){
            nSkillLevelFire ++;
            nSkillPoints --;
            return true;
        }else{
            return false;
        }
    }

    public void BoostSkillLevelFire (int _nSkillLevelFire) {
        nSkillLevelFire += _nSkillLevelFire;
    }

    public int GetSkillLevelFire () {
        return nSkillLevelFire;
    }

    public boolean IncreaseSkillLevelIce () {
        if(nSkillPoints >= 1) {
            nSkillLevelIce++;
            nSkillPoints--;
            return true;
        } else {
            return false;
        }
    }

    public void BoostSkillLevelIce (int _nSkillLevelIce) {
        nSkillLevelIce += _nSkillLevelIce;
    }

    public int GetSkillLevelIce () {
        return nSkillLevelIce;
    }

    public boolean IncreaseSkillLevelEarth () {
        if(nSkillPoints >= 1) {
            nSkillLevelEarth++;
            nSkillPoints--;
            return true;
        } else {
            return false;
        }
    }

    public void BoostSkillLevelEarth (int _nSkillLevelEarth) {
        nSkillLevelEarth += _nSkillLevelEarth;
    }

    public int GetSKillLevelEarth () {
        return nSkillLevelEarth;
    }

    public void AddSkillLevelBlood (int _nSkillLevelBlood) {
        nSkillLevelBlood += _nSkillLevelBlood;
    }

    public int GetSkillLevelBlood () {
        return nSkillLevelBlood;
    }
}