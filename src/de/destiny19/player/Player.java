package de.destiny19.player;

import de.destiny19.Logger;
import de.destiny19.Main;
import de.destiny19.game.Timer;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"nLevel", "nEP", "nAktEP", "nHP", "nAktHP", "nMP", "nAktMP", "nStrength"})
@XmlRootElement(name = "Player")
public class Player {
    @XmlElement(name="nLevel", required = true) private int nLevel;
    @XmlElement(name="nEp", required = true) private int nEP;
    @XmlElement(name="nAktEP", required = true) private int nAktEP;
    @XmlElement(name="nHP", required = true) private int nHP;
    @XmlElement(name="nAktHP", required = true) private int nAktHP;
    @XmlElement(name="nMP", required = true) private int nMP;
    @XmlElement(name="nnAktMP", required = true) private int nAktMP;
    @XmlElement(name="nStrength", required = true) private int nStrength;

    //Nicht speicherungserforderliche variablen
    @XmlTransient private Timer m_timer;
    @XmlTransient public Timer m_heal;
    
    //Skillkosten in ticks
    @XmlTransient private int nSkillACD;
    @XmlTransient private int nSkillBCD;
    @XmlTransient private int nSkillCCD;
    @XmlTransient private int nSkillDCD;
    @XmlTransient private boolean bBerserk;
    @XmlTransient private boolean bSkillA;
    @XmlTransient private boolean bSkillB;
    @XmlTransient private boolean bSkillC;
    @XmlTransient private boolean bSkillD;
    @XmlTransient private int nBerserkCD;
    
    public Player () {
        //Player(1, 0, 0, 100, 0,500, 500, 100 , 100, 5, 5, 5, 1, 1, 1, 1);
    }

    public Player(int _nLevel, int _nEP, int _nAktEP, int _nHP,int _nAktHP, int _nMP, int _nAktMP, int _nStrength) {
        nLevel = _nLevel;
        nEP = _nEP;
        nAktEP = _nAktEP;
        nHP = _nHP;
        nAktHP = _nAktHP;
        nMP = _nMP;
        nAktMP = _nAktMP;
        nStrength = _nStrength;
        setSkillACD(5);
        setSkillBCD(12);
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

    private void levelUp(int hpUp, int mpUp) { //use this since its more defined
        nLevel++;
        nStrength += 2;
        nHP+=hpUp;
        nMP+=mpUp;
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
            levelUp(10, 10);
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

    public int getHP() {
        return nHP;
    }

    public int getAktHP() {
    	return nAktHP;
    }

    private void regen(int _nHeal, int _nMana) {
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
    
    public int getAktMP() {
    	return nAktMP;
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
            	regen(getLevel(), 2*getLevel());
            }
        };
        getTimer().setTaskDuration(60);
        getTimer().init();
        m_heal.setTaskDuration(30);
        m_heal.init();
	}
	
	public void useSkill(int nID) {
        Logger.trace(String.format("Skill used: %s", getSkillNameFromID(nID)));
		switch(nID) {
            default:
                break;
            case 1:
                if (isSkillA()) return;
                else if (!useMana(20)) return;
                int eHP;
                try {
                    eHP = Main.GetCurrentEnemy().getHP();
                    eHP -= 50; //getStrength()
                    Main.GetCurrentEnemy().setHP(eHP);
                    setSkillA(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                if (isSkillB()) return;
                else if (!useMana(40)) return;
                regen(30, 0);
                setSkillB(true);
                break;
            case 3:
                if (isSkillC()) return;
                else if (!useMana(40)) return;
                try {
                    Main.GetCurrentEnemy().setDmg(Main.GetCurrentEnemy().getDmg() / 2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                setSkillC(true);
                break;
            case 4:
                if (isSkillD()) return;
                else if (!useMana(100)) return;
                bBerserk = true;
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

	public void setSkillACD(int nSkillACD)
	{
		this.nSkillACD = nSkillACD;
	}

	public void setSkillBCD(int nSkillBCD)
	{
		this.nSkillBCD = nSkillBCD;
	}

	public void setSkillCCD(int nSkillCCD)
	{
		this.nSkillCCD = nSkillCCD;
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

	private String getSkillNameFromID(int nID){
        String strRet;
        switch(nID){
            default:
                strRet = "null";
                break;
            case 1:
                strRet = "Bomb";
                break;
            case 2:
                strRet = "Recover";
                break;
            case 3:
                strRet = "Cripple";
                break;
            case 4:
                strRet = "Berserk";
                break;
        }
        return strRet;
    }
	
	public int getStrength() {
		return nStrength;
	}
}