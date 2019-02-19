package de.destiny19.graphics;

public abstract class Entity {
	private int x;
	private int y;
	private boolean enableMoving;
	
	public Entity(int x, int y, OBJECTTYPE type) {
		this.setX(x);
		this.setY(y);
		
		switch (type) {
		case STATIC:
			setEnableMoving(false);
			break;
		case ACTOR:
			setEnableMoving(true);
			break;
		case FLEX:
			setEnableMoving(true);
			break;
		}
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isEnableMoving() {
		return enableMoving;
	}

	public void setEnableMoving(boolean enableMoving) {
		this.enableMoving = enableMoving;
	}

	public static enum OBJECTTYPE {
		STATIC, ACTOR, FLEX /*moveable, but no actions*/
	}
}
