package de.destiny19.game;

public abstract class DEvent {
	//if performed, calls a timer 
	private Timer eventtimer;
	
	public DEvent(Timer eventtimer) {
		this.setTimer(eventtimer);
		eventtimer.init();
	}

	public Timer getTimer() {
		return eventtimer;
	}

	public void setTimer(Timer eventtimer) {
		this.eventtimer = eventtimer;
	}
}
