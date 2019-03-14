package de.destiny19.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class CPicture extends JLabel {

	private static final long serialVersionUID = 1L;
	private BufferedImage myImage;
	private File imgFile;
	
	public CPicture() {
		setBackground(Color.BLACK);
	}
	
	@Override public void paintComponent(Graphics g) {
		if(myImage != null) {
			g.drawImage(myImage, 0, 0, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}
	
	public void setImage(File file) throws IOException {
		imgFile = file;
		myImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
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
}
