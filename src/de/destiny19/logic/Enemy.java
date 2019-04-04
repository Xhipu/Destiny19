package de.destiny19.logic;

import de.destiny19.game.Main;
import de.destiny19.game.Timer;

public class Enemy {
	private int m_nLevel, m_nHP, m_nAtkSpeed, m_nDmg;
	private Timer m_timer;
	
	public Enemy(int nLevel) {
		setLevel(nLevel);
		setHP(100);
		setAtkSpeed(120); //1s 
		m_nDmg = 10;
		setTimer(new Timer() {
			@Override
			public void doAction() {
				Main.GetPlayer().GetDamage(m_nDmg);
				Main.devstream.println("Current hp: "+Main.GetPlayer().GetAktHP());
			}
		});
		getTimer().init();
		getTimer().setTaskDuration(getAtkSpeed());
	}
	
	public void scale(int nCount) {
		setHP(getHP() + nCount*2);
		m_nDmg += nCount;
		setAtkSpeed(getAtkSpeed() + nCount);
	}

	public int getLevel() {
		return m_nLevel;
	}

	public void setLevel(int m_nLevel) {
		this.m_nLevel = m_nLevel;
	}

	public int getHP() {
		return m_nHP;
	}

	public void setHP(int m_nHP) {
		this.m_nHP = m_nHP;
		Main.devstream.println("Enemy HP: "+getHP());
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
}
