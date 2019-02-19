package de.destiny19.game;

public abstract class Timer {
	
	//timer executes perform() as long as it is alive
	//a Timer is NOT a thread, it is dependent on the main thread to stay in sync
	//doAction() is defined externally
	
	//start the timer with Timer.init()
	//reset the timer with Timer.reset()
	//kill the timer with Timer.destroy()
	
	private boolean active;
	private long m_lnTaskDuration;
	private long step;
	
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
			doAction();
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
