package com.ghisoft.mod5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	private int screenWidth = 100;
	private int screenHeight = 100;

	final int FPS = 60;

	// private KeyHandler keyH = new KeyHandler();
	private Thread gameThread;

	private int showFPS;

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		// this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		double drawInterval = 1000000000.0 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;

		while (gameThread != null) {

			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += currentTime - lastTime;
			lastTime = currentTime;

			if (delta > 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}

			if (timer >= 1000000000) {
				showFPS = drawCount;
				drawCount = 0;
				timer = 0;
			}

		}

	}

	private void update() {
//		if (keyH.upPressed) {
//			playerY -= playerSpeed;
//		}
//		if (keyH.downPressed) {
//			playerY += playerSpeed;
//		}
//		if (keyH.leftPressed) {
//			playerX -= playerSpeed;
//		}
//		if (keyH.rightPressed) {
//			playerX += playerSpeed;
//		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.white);

		g.drawString("FPS: " + showFPS, 1, 11);

		g.dispose();
	}

}
