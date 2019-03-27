package de.destiny19.player;

import de.destiny19.game.Game;
import de.destiny19.game.Timer;

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
    private Timer m_timer;

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
        setTimer(new Timer() {
			@Override
			public void doAction() {
				Game.devstream.println("Test");
			}
        });
    }

    public int getLevel () {
        return nLevel;
    }

    public void levelUp (int _nLevel) {
        nLevel += _nLevel;
        nHP += _nLevel;
        nMP += _nLevel;
        nDefence += _nLevel;
        nSkillPoints += _nLevel;
        nStatPoints += _nLevel;
        nEP *= 2;
    }

    public int getEP () {
        return nEP;
    }

    public int getAktEP () {
        return nAktEP;
    }

    public void addEP (int _nEP) {
        if((nAktEP + _nEP) >= nEP){
            levelUp(1);
        }else {
            nAktEP += _nEP;
        }
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

    public void addHP (int _nHP) {
        nHP += _nHP;
    }

    public int getHP () {
        return nHP;
    }
    
    public void setAktHP () {
        nAktHP = nHP;
    }
    
    public int getAktHP () {
    	return nAktHP;
    }

    public void getHeal (int _nHeal) {
        if((nAktHP += _nHeal) >= nHP) {
            nAktHP = nHP;
        } else {
            nAktHP += _nHeal;
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
    
    public int getAktMP () {
    	return nAktMP;
    }

    public void getMana (int _nMP) {
        if((nAktMP + _nMP) >= nMP) {
            nAktMP = nMP;
        } else {
            nAktMP += _nMP;
        }
    }

    public boolean useMana (int _nMP) {
        if(nAktMP < _nMP) {
            return false;
        } else {
            nAktMP -= _nMP;
            return true;
        }
    }

    public int getMP () {
        return nMP;
    }

    public boolean skillUpStrength () {
        if (nStatPoints >= 1) {
            nStrength++;
            nStatPoints--;
            return true;
        } else {
            return false;
        }
    }

    public void boostStrength (int _nStrength) {
        nStrength += _nStrength;
    }

    public int getStrength () {
        return nStrength;
    }

    public boolean skillUpDefense () {
        if(nStatPoints >= 1) {
            nDefence++;
            nStatPoints--;
            return true;
        }else {
            return false;
        }
    }

    public void boostDefense (int _nDefence) {
        nDefence += _nDefence;
    }

    public int getDefense () {
        return nDefence;
    }

    public boolean skillUpIntelligence () {
        if(nStatPoints >= 1) {
            nIntelligence ++;
            nStatPoints--;
            return true;
        }else{
            return false;
        }
    }

    public void boostIntelligence (int _nIntelligence) {
        nIntelligence += _nIntelligence;
    }

    public int getIntelligence () {
        return nIntelligence;
    }

    public boolean increaseSkillLevelFire () {
        if(nSkillPoints >= 1){
            nSkillLevelFire ++;
            nSkillPoints --;
            return true;
        }else{
            return false;
        }
    }

    public void boostSkillLevelFire (int _nSkillLevelFire) {
        nSkillLevelFire += _nSkillLevelFire;
    }

    public int getSkillLevelFire () {
        return nSkillLevelFire;
    }

    public boolean increaseSkillLevelIce () {
        if(nSkillPoints >= 1) {
            nSkillLevelIce++;
            nSkillPoints--;
            return true;
        } else {
            return false;
        }
    }

    public void boostSkillLevelIce (int _nSkillLevelIce) {
        nSkillLevelIce += _nSkillLevelIce;
    }

    public int getSkillLevelIce () {
        return nSkillLevelIce;
    }

    public boolean increaseSkillLevelEarth () {
        if(nSkillPoints >= 1) {
            nSkillLevelEarth++;
            nSkillPoints--;
            return true;
        } else {
            return false;
        }
    }

    public void boostSkillLevelEarth (int _nSkillLevelEarth) {
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

	public Timer getTimer() {
		return m_timer;
	}

	public void setTimer(Timer m_timer) {
		this.m_timer = m_timer;
	}


}