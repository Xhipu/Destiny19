package de.destiny19.player;

import de.destiny19.Logger;
import de.destiny19.Main;
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
    @XmlTransient
    public Timer m_heal;
    
    //Skillkosten in ticks
    private int nSkillACD, nSkillBCD, nSkillCCD, nSkillDCD;
    private boolean bBerserk, bSkillA, bSkillB, bSkillC, bSkillD;
    private int nBerserkCD;
    
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
        setSkillACD(5);
        setSkillBCD(12); //healskill
        setSkillCCD(6);
        setSkillDCD(20);
        setBerserkCD(5);
        setBerserk(false);
        setSkillA(false);
        setSkillB(false);
        setSkillC(false);
        setSkillD(false);
    }

    public int getLevel() {
        return nLevel;
    }

    public void levelUp(int hpUp, int mpUp, int def) { //use this since its more defined
        nLevel++;
        nHP+=hpUp;
        nMP+=mpUp;
        nSkillPoints++;
        nStatPoints++;
        nEP*=2;
        nAktEP = 0;
    }

    public int getEP() {
        return nEP;
    }

    public int getAktEP() {
        return nAktEP;
    }

    public void addEP(int _nEP) {
        if((nAktEP + _nEP) >= nEP){
            levelUp(10, 10, 1);
            int deltaHp = nHP - nAktHP;
            int deltaMp = nMP - nAktMP;
            regen(deltaHp, deltaMp);
            Logger.trace(String.format("Level up!\n\n"
            		+ "Level: ------------%d\n"
            		+ "Max. HP: ----------%d\n"
            		+ "Max. MP: ----------%d\n"
            		+ "XP for next level: %d\n",
            		nLevel, nHP, nMP, nEP));
        } else {
            nAktEP += _nEP;
            Logger.trace(String.format("XP: %d / %d", nAktEP, nEP));
        }
    }

    public void addStatPoints(int _nStatPoints) {
        nStatPoints += _nStatPoints;
    }

    public void removeStatPoints(int _nStatPoints) {
        nStatPoints -= _nStatPoints;
    }

    public int getStatPoints() {
        return nStatPoints;
    }

    public void addSkillPoints(int _nSkillPoints) {
        nSkillPoints += _nSkillPoints;
    }

    public void removeSkillPoints(int _nSkillPoints) {
        nSkillPoints -= _nSkillPoints;
    }

    public int getSkillPoints() {
        return nSkillPoints;
    }

    public void addHP(int _nHP) {
        nHP += _nHP;
    }

    public int getHP() {
        return nHP;
    }
    
    public void setAktHP() {
        nAktHP = nHP;
    }

    public int getAktHP() {
    	return nAktHP;
    }

    public void regen(int _nHeal, int _nMana) {
        if((nAktHP += _nHeal) >= nHP) {
            nAktHP = nHP;
        } else {
            nAktHP += _nHeal;
        }
            
        if((nAktMP += _nMana) >= nMP) {
        	nAktMP = nMP;
        } else {
        	nAktMP += _nMana;
        }
    }

    public boolean damage(int _nDamage) {
        if((nAktHP -= _nDamage) <= 0) {
            nAktHP = 0;
            return false;
        } else {
            nAktHP -= _nDamage;
            return true;
        }
    }

    public void addMP(int _nMP) {
        nMP += _nMP;
    }

    public void setAktMP() {
        nAktMP = nMP;
    }
    
    public int getAktMP() {
    	return nAktMP;
    }

    public void addMana(int _nMP) {
        if((nAktMP + _nMP) >= nMP) {
            nAktMP = nMP;
        } else {
            nAktMP += _nMP;
        }
    }

    public boolean useMana(int _nMP) {
        if(nAktMP < _nMP) {
            return false;
        } else {
            nAktMP -= _nMP;
            return true;
        }
    }

    public int getMP() {
        return nMP;
    }

    public boolean skillUpStrength() {
        if (nStatPoints >= 1) {
            nStrength++;
            nStatPoints--;
            return true;
        } else {
            return false;
        }
    }

    public void boostStrength(int _nStrength) {
        nStrength += _nStrength;
    }

    public int getStrength() {
        return nStrength;
    }

    public boolean skillUpDefence() {
        if(nStatPoints >= 1) {
            nDefence++;
            nStatPoints--;
            return true;
        }else {
            return false;
        }
    }

    public void boostDefence(int _nDefence) {
        nDefence += _nDefence;
    }

    public int getDefence() {
        return nDefence;
    }

    public boolean skillUpIntelligence() {
        if(nStatPoints >= 1) {
            nIntelligence ++;
            nStatPoints--;
            return true;
        }else{
            return false;
        }
    }

    public void boostIntelligence(int _nIntelligence) {
        nIntelligence += _nIntelligence;
    }

    public int getIntelligence() {
        return nIntelligence;
    }

    public boolean increaseSkillLevelFire() {
        if(nSkillPoints >= 1){
            nSkillLevelFire ++;
            nSkillPoints --;
            return true;
        }else{
            return false;
        }
    }

    public void boostSkillLevelFire(int _nSkillLevelFire) {
        nSkillLevelFire += _nSkillLevelFire;
    }

    public int getSkillLevelFire() {
        return nSkillLevelFire;
    }

    public boolean increaseSkillLevelIce() {
        if(nSkillPoints >= 1) {
            nSkillLevelIce++;
            nSkillPoints--;
            return true;
        } else {
            return false;
        }
    }

    public void boostSkillLevelIce(int _nSkillLevelIce) {
        nSkillLevelIce += _nSkillLevelIce;
    }

    public int getSkillLevelIce() {
        return nSkillLevelIce;
    }

    public boolean increaseSkillLevelEarth() {
        if(nSkillPoints >= 1) {
            nSkillLevelEarth++;
            nSkillPoints--;
            return true;
        } else {
            return false;
        }
    }

    public void boostSkillLevelEarth(int _nSkillLevelEarth) {
        nSkillLevelEarth += _nSkillLevelEarth;
    }

    public int getSKillLevelEarth() {
        return nSkillLevelEarth;
    }

    public void addSkillLevelBlood(int _nSkillLevelBlood) {
        nSkillLevelBlood += _nSkillLevelBlood;
    }

    public int getSkillLevelBlood() {
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
					eHP -= nStrength; 
					Main.GetCurrentEnemy().setHP(eHP);
				} catch (Exception e) {
                    Logger.trace("No enemy");
				}
				
				if(bSkillA) {
					int nCD = nSkillACD;
					if(nCD > 0) {
						nCD--;
						nSkillACD = nCD;
						Logger.trace(String.format("Skill 1 Cooldown: %d", nSkillACD));
					} else if(nCD <= 0) {
						nSkillACD = 5;
						setSkillA(false);
					}
				} else if(bSkillB) {
					int nCD = nSkillBCD;
					if(nCD > 0) {
						nCD--;
						nSkillBCD = nCD;
						Logger.trace(String.format("Skill 2 Cooldown: %d", nSkillBCD));
					} else if(nCD <= 0) {
						nSkillBCD = 12;
						setSkillB(false);
					}
				} else if(bSkillC) {
					int nCD = nSkillCCD;
					if(nCD > 0) {
						nCD--;
						nSkillCCD = nCD;
						Logger.trace(String.format("Skill 3 Cooldown: %d", nSkillCCD));
					} else if(nCD <= 0) {
						nSkillCCD = 6;
						setSkillC(false);
					}
				} else if(bSkillD) {
					if(bBerserk) {
						int nDuration = getBerserkCD();
						if(nDuration > 0) {
							nDuration--;
							setBerserkCD(nDuration);
							Logger.trace(String.format("Berserk Mode Time: %d", getBerserkCD()));
						}
						else if(nDuration <= 0) {
							nStrength /= 2;
							nHP /= 2;
							nMP /= 2;
							nAktHP /= 2;
							nAktMP /= 2;
							setBerserk(false);
							setBerserkCD(5);
						}
					}
					int nCD = nSkillDCD;
					if(nCD > 0) {
						nCD--;
						nSkillDCD = nCD;
						Logger.trace(String.format("Skill 4 Cooldown: %d", nSkillDCD));
					} else if(nCD <= 0) {
						nSkillDCD = 20;
						setSkillD(false);
					}
				}
			}
        });

		m_heal = new Timer() {
            @Override
            public void doAction() {
            	regen(1, 2);
            }
        };
        getTimer().setTaskDuration(60);
        getTimer().init();
        m_heal.setTaskDuration(30);
        m_heal.init();
	}
	
	public void useSkill(int nID) {
		switch(nID) {
			default:
				break;
			case 1: 
				if(isSkillA()) return;
				else if(!useMana(20)) return;
				int eHP;
				try
				{
					eHP = Main.GetCurrentEnemy().getHP();
					eHP -= 50; //getStrength()
					Main.GetCurrentEnemy().setHP(eHP);
					setSkillA(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				break;
			case 2:
				if(isSkillB()) return;
				else if(!useMana(40)) return;
				regen(30, 0);
				setSkillB(true);
				break;
			case 3:
				if(isSkillC()) return;
				else if(!useMana(40)) return;
				try
				{
					//halbiere gegner schaden
					//bis zum tod
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				setSkillC(true);
				break;
			case 4:
				if(isSkillD()) return;
				else if(!useMana(100)) return;
				bBerserk = true;
				nStrength *= 2;
				nHP *= 2;
				nMP *= 2;
				regen(70, 10);
				setSkillD(true);
				break;
		}
	}

	public boolean isBerserk()
	{
		return bBerserk;
	}

	public void setBerserk(boolean bBerserk)
	{
		this.bBerserk = bBerserk;
	}

	public int getBerserkCD()
	{
		return nBerserkCD;
	}

	public void setBerserkCD(int nBerserkCD)
	{
		this.nBerserkCD = nBerserkCD;
	}

	public int getSkillACD()
	{
		return nSkillACD;
	}

	public void setSkillACD(int nSkillACD)
	{
		this.nSkillACD = nSkillACD;
	}

	public int getSkillBCD()
	{
		return nSkillBCD;
	}

	public void setSkillBCD(int nSkillBCD)
	{
		this.nSkillBCD = nSkillBCD;
	}

	public int getSkillCCD()
	{
		return nSkillCCD;
	}

	public void setSkillCCD(int nSkillCCD)
	{
		this.nSkillCCD = nSkillCCD;
	}

	public int getSkillDCD()
	{
		return nSkillDCD;
	}

	public void setSkillDCD(int nSkillDCD)
	{
		this.nSkillDCD = nSkillDCD;
	}

	public boolean isSkillA()
	{
		return bSkillA;
	}

	public void setSkillA(boolean bSkillA)
	{
		this.bSkillA = bSkillA;
	}

	public boolean isSkillB()
	{
		return bSkillB;
	}

	public void setSkillB(boolean bSkillB)
	{
		this.bSkillB = bSkillB;
	}

	public boolean isSkillC()
	{
		return bSkillC;
	}

	public void setSkillC(boolean bSkillC)
	{
		this.bSkillC = bSkillC;
	}

	public boolean isSkillD()
	{
		return bSkillD;
	}

	public void setSkillD(boolean bSkillD)
	{
		this.bSkillD = bSkillD;
	}
}