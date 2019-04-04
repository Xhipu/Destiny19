package de.destiny19.game;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "timer", propOrder = {"active", "m_lnTaskDuration", "step"})
public abstract class Timer {
	
	//timer executes perform() as long as it is alive
	//a Timer is NOT a thread, it is dependent on the main thread to stay in sync
	//doAction() is defined externally
	
	//start the timer with Timer.init()
	//reset the timer with Timer.reset()
	//kill the timer with Timer.destroy()
	@XmlElement(name="active", required = true)
	private boolean active;
	@XmlElement(name="m_lnTaskDuration", required = true)
	private long m_lnTaskDuration;
	@XmlElement(name="step", required = true)
	public long step;
	
	public abstract void doAction();

	public boolean isActive() {
		return active;
	}

	public void init() {
		this.active = true;
	}
	
	public void reset() {step = 0;}

	public long getTaskDuration() {
		return m_lnTaskDuration;
	}

	public void setTaskDuration(long m_lnTaskDuration) {
		this.m_lnTaskDuration = m_lnTaskDuration;
	}
	
	public void perform() {
		if ( isActive() ) {
			if (step == 0) {
				doAction();
			}
			step++;
			
			//reset if the task duration is reached
			if (step >= getTaskDuration() ) {
				reset();
			}
		}
	}
	
	public void destroy() {
		this.active = false;
	}
}
