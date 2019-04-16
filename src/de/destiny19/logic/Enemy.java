package de.destiny19.logic;

import de.destiny19.Main;
import de.destiny19.game.Timer;

public class Enemy {
	private int m_nLevel, m_nHP, m_nAtkSpeed, m_nDmg, m_nMaxHp;
	private Timer m_timer;
	
	public Enemy(int nLevel) {
		setLevel(nLevel);
		setHP(100);
		setMaxHp(100);
		setAtkSpeed(120); //1s 
		m_nDmg = 5;
		scale(nLevel-1);
		setTimer(new Timer() {
			@Override
			public void doAction() {
				Main.GetPlayer().damage(m_nDmg);
			}
		});
		getTimer().init();
		getTimer().setTaskDuration(getAtkSpeed());
	}
	
	public void scale(int nCount) {
		setHP(getHP() + nCount*2);
		setMaxHp((getMaxHp() + nCount*2));
		m_nDmg += nCount;
		setAtkSpeed(getAtkSpeed() + nCount);
	}

	public void setLevel(int m_nLevel) {
		this.m_nLevel = m_nLevel;
	}

	public int getHP() {
		return m_nHP;
	}

	public void setHP(int m_nHP) {
		this.m_nHP = m_nHP;
	}

	public int getAtkSpeed() {
		return m_nAtkSpeed;
	}

	public void setAtkSpeed(int m_nAtkSpeed) {
		this.m_nAtkSpeed = m_nAtkSpeed;
	}

	public Timer getTimer() {
		return m_timer;
	}

	public void setTimer(Timer m_timer) {
		this.m_timer = m_timer;
	}

	public int getMaxHp() {
		return m_nMaxHp;
	}

	public void setMaxHp(int m_nMaxHp) {
		this.m_nMaxHp = m_nMaxHp;
	}

	public int getDmg() {
		return m_nDmg;
	}

	public void setDmg(int m_nDmg) {
		this.m_nDmg = m_nDmg;
	}

	public int getLevel() {
		return m_nLevel;
	}
}
