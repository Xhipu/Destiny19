package de.destiny19.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class SkillButton extends StaticPanel {

	private Image myImage;
	private File imgFile;
	private boolean bActive;

	public SkillButton(int x, int y, int w, int h) {
		super(x, y, w, h);
		bActive = true;
	}
	
	@Override public void paintComponent(Graphics g) {
		if(myImage != null) {
			g.setColor(getStateColor());
			g.fillRect(0, 0, getWidth(), getHeight());
			g.drawImage(myImage, 0, 0, getWidth(), getHeight(), this);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}
	
	public void setImage(File file) throws IOException {
		imgFile = file;
		myImage = ImageIO.read(imgFile);
		repaint();
	}
	
	public void removeImage() {
		myImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		repaint();
	}
	
	public File getImage() {
		return imgFile;
	}

	public Color getStateColor(){
		if(bActive) return Color.green;
		else return Color.red;
	}

	public boolean isActive() {
		return bActive;
	}

	public void setActive(boolean bActive){
		this.bActive = bActive;
		repaint();
	}
}
