package de.destiny19.player;

import de.destiny19.game.Main;
import de.destiny19.game.Timer;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"nLevel", "nStatPoints", "nSkillPoints", "nEP", "nAktEP", "nHP", "nAktHP", "nMP", "nAktMP", "nStrength", "nDefence", "nIntelligence", "nSkillLevelFire", "nSkillLevelIce", "nSkillLevelEarth", "nSkillLevelBlood"})
@XmlRootElement(name = "Player")
public class Player {
    @XmlElement(name="nLevel", required = true)
    private int nLevel;
    @XmlElement(name="nStatPoints", required = true)
    private int nStatPoints;
    @XmlElement(name="nSkillPoints", required = true)
    private int nSkillPoints;
    @XmlElement(name="nEp", required = true)
    private int nEP;
    @XmlElement(name="nAktEP", required = true)
    private int nAktEP;
    @XmlElement(name="nHP", required = true)
    private int nHP;
    @XmlElement(name="nAktHP", required = true)
    private int nAktHP;
    @XmlElement(name="nMP", required = true)
    private int nMP;
    @XmlElement(name="nnAktMP", required = true)
    private int nAktMP;
    @XmlElement(name="nStrength", required = true)
    private int nStrength;
    @XmlElement(name="nDefence", required = true)
    private int nDefence;
    @XmlElement(name="nIntelligence", required = true)
    private int nIntelligence;
    @XmlElement(name="nSkillLevelFire", required = true)
    private int nSkillLevelFire;
    @XmlElement(name="nSkillLevelIce", required = true)
    private int nSkillLevelIce;
    @XmlElement(name="nSkillLevelEarth", required = true)
    private int nSkillLevelEarth;
    @XmlElement(name="nSkillLevelBlood", required = true)
    private int nSkillLevelBlood;
    @XmlTransient
    private Timer m_timer;

    public Player () {
        //Player(1, 0, 0, 100, 0,500, 500, 100 , 100, 5, 5, 5, 1, 1, 1, 1);
    }

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
            Main.devstream.printf("Healed for %d\n", _nHeal);
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

	public Timer getTimer() {
		return m_timer;
	}

	public void setTimer(Timer m_timer) {
		this.m_timer = m_timer;
	}
	
	public void initTimer() {
		setTimer(new Timer() {
			@Override
			public void doAction() {
				int eHP;
				try {
					eHP = Main.GetCurrentEnemy().getHP();
					eHP -= 2; //getStrength()
					Main.GetCurrentEnemy().setHP(eHP);
				} catch (Exception e) {
					Main.devstream.println("No enemy");
				}
				GetHeal(2);
			
			}
        });
        getTimer().setTaskDuration(60);
        getTimer().init();
	}
}