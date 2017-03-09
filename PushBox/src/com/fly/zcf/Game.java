package com.fly.zcf;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.event.KeyEvent;
import java.util.Stack;

import javax.swing.JPanel;

import com.fly.zcf.LoadMap;
import com.fly.zcf.Tishi;

public class Game extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private LoadMap lm;
	private int level;
	private int manX, manY;
	private int lastImg = 2;
	private int[][] map;
	private int[][] backMap;
	private static final int LEN = 30;
	private static final int WIDTH = 30;
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Image[] imgs = null;
	private Stack<BackUplnfo> myStack = new Stack<BackUplnfo>();
	private BackUplnfo bp; 
	static {
		imgs = new Image[] {
				tk.getImage(GameFrame.class.getClassLoader().getResource(
						"imgs/0.gif")),
				tk.getImage(GameFrame.class.getClassLoader().getResource(
						"imgs/1.gif")),
				tk.getImage(GameFrame.class.getClassLoader().getResource(
						"imgs/2.GIF")),
				tk.getImage(GameFrame.class.getClassLoader().getResource(
						"imgs/3.GIF")),
				tk.getImage(GameFrame.class.getClassLoader().getResource(
						"imgs/4.gif")),
				tk.getImage(GameFrame.class.getClassLoader().getResource(
						"imgs/5.GIF")),
				tk.getImage(GameFrame.class.getClassLoader().getResource(
						"imgs/6.GIF")),
				tk.getImage(GameFrame.class.getClassLoader().getResource(
						"imgs/7.GIF")),
				tk.getImage(GameFrame.class.getClassLoader().getResource(
						"imgs/8.GIF")),
				tk.getImage(GameFrame.class.getClassLoader().getResource(
						"imgs/9.GIF")) };
	}
	public void keyReleased(KeyEvent e) {
		int keycode = e.getKeyCode();
		if (!isPass()) {
			switch (keycode) {
			case KeyEvent.VK_UP:
				moveUp();
				if (isPass()) {
					myStack.clear();
					lm = new LoadMap(++level);
					map = lm.getMap();
					this.manX = lm.getManX();
					this.manY = lm.getManY();
				}
				break;
			case KeyEvent.VK_DOWN:
				moveDown();
				if (isPass()) {
					myStack.clear();
					lm = new LoadMap(++level);
					map = lm.getMap();
					this.manX = lm.getManX();
					this.manY = lm.getManY();
				}
				break;
			case KeyEvent.VK_LEFT:
				moveLeft();
				if (isPass()) {
					myStack.clear();
					lm = new LoadMap(++level);
					map = lm.getMap();
					this.manX = lm.getManX();
					this.manY = lm.getManY();
				}
				break;
			case KeyEvent.VK_RIGHT:
				moveRight();
				if (isPass()) {
					myStack.clear();
					lm = new LoadMap(++level);
					map = lm.getMap();
					this.manX = lm.getManX();
					this.manY = lm.getManY();
				}
				break;
			case KeyEvent.VK_SPACE:
				back();
				break;
			default:
				break;
			}
		}
	}
	
	private void moveUp() {
		if (map[manX][manY - 1] == 2 || map[manX][manY - 1] == 4) {
			backMap = new int[20][20];
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					backMap[i][j] = map[i][j];
				}
			}
			bp = new BackUplnfo(backMap, manX, manY);
			myStack.push(bp);
			map[manX][manY] = lastImg; 
			lastImg = map[manX][manY - 1];
			map[manX][manY - 1] = 8;
			manY--;
			repaint();
		} else if (map[manX][manY - 1] == 3 || map[manX][manY - 1] == 9) {
			backMap = new int[20][20];
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					backMap[i][j] = map[i][j];
				}
			}
			bp = new BackUplnfo(backMap, manX, manY);
			myStack.push(bp);

			if (map[manX][manY - 2] == 2) {
				map[manX][manY - 2] = 3;
				map[manX][manY] = lastImg;
				if (map[manX][manY - 1] == 3) {
					lastImg = 2;
				} else {
					lastImg = 4;
				}
				map[manX][manY - 1] = 8;
				manY--;
				repaint();
			} else if (map[manX][manY - 2] == 4) {
				map[manX][manY - 2] = 9;
				map[manX][manY] = lastImg;
				if (map[manX][manY - 1] == 3) {
					lastImg = 2;
				} else {
					lastImg = 4;
				}
				map[manX][manY - 1] = 8;
				manY--;
				repaint();
			}
		}
	}
	
	private void moveDown() {
		backMap = new int[20][20];
		if (map[manX][manY + 1] == 2 || map[manX][manY + 1] == 4) {
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					backMap[i][j] = map[i][j];
				}
			}
			bp = new BackUplnfo(backMap, manX, manY);
			myStack.push(bp);
			map[manX][manY] = lastImg; 
			lastImg = map[manX][manY + 1];
			map[manX][manY + 1] = 5;
			manY++;
			repaint();
		} else if (map[manX][manY + 1] == 3 || map[manX][manY + 1] == 9) {
			backMap = new int[20][20];
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					backMap[i][j] = map[i][j];
				}
			}
			bp = new BackUplnfo(backMap, manX, manY);
			myStack.push(bp);
			if (map[manX][manY + 2] == 2) {
				map[manX][manY + 2] = 3;
				map[manX][manY] = lastImg;
				if (map[manX][manY + 1] == 3) {
					lastImg = 2;
				} else {
					lastImg = 4;
				}
				map[manX][manY + 1] = 5;
				manY++;
				repaint();
			} else if (map[manX][manY + 2] == 4) {
				map[manX][manY + 2] = 9;
				map[manX][manY] = lastImg;
				if (map[manX][manY + 1] == 3) {
					lastImg = 2;
				} else {
					lastImg = 4;
				}
				map[manX][manY + 1] = 5;
				manY++;
				repaint();
			}
		}
	}
	
	private void moveLeft() {
		if (map[manX - 1][manY] == 2 || map[manX - 1][manY] == 4) {
			backMap = new int[20][20];
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					backMap[i][j] = map[i][j];
				}
			}
			bp = new BackUplnfo(backMap, manX, manY);
			myStack.push(bp);
			map[manX][manY] = lastImg; 
			lastImg = map[manX - 1][manY];
			map[manX - 1][manY] = 6;
			manX--;
			repaint();
		} else if (map[manX - 1][manY] == 3 || map[manX - 1][manY] == 9) {
			backMap = new int[20][20];
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					backMap[i][j] = map[i][j];
				}
			}
			bp = new BackUplnfo(backMap, manX, manY);
			myStack.push(bp);
			if (map[manX - 2][manY] == 2) {
				map[manX - 2][manY] = 3;
				map[manX][manY] = lastImg;
				if (map[manX - 1][manY] == 3) {
					lastImg = 2;
				} else {
					lastImg = 4;
				}
				map[manX - 1][manY] = 6;
				manX--;
				repaint();
			} else if (map[manX - 2][manY] == 4) {
				map[manX - 2][manY] = 9;
				map[manX][manY] = lastImg;
				if (map[manX - 1][manY] == 3) {
					lastImg = 2;
				} else {
					lastImg = 4;
				}
				map[manX - 1][manY] = 6;
				manX--;
				repaint();
			}
		}
	}
	
	private void moveRight() {
		if (map[manX + 1][manY] == 2 || map[manX + 1][manY] == 4) {//人右面是空地或目标
			backMap = new int[20][20];
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					backMap[i][j] = map[i][j];
				}
			}
			bp = new BackUplnfo(backMap, manX, manY);
			myStack.push(bp);
			map[manX][manY] = lastImg;
			lastImg = map[manX + 1][manY];
			map[manX + 1][manY] = 7;
			manX++;
			repaint();
		} else if (map[manX + 1][manY] == 3 || map[manX + 1][manY] == 9) {//人右面是箱子
			backMap = new int[20][20];
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					backMap[i][j] = map[i][j];
				}
			}
			bp = new BackUplnfo(backMap, manX, manY);
			myStack.push(bp);
			if (map[manX + 2][manY] == 2) {//箱子右面是空地
				map[manX + 2][manY] = 3;
				map[manX][manY] = lastImg;
				if (map[manX + 1][manY] == 3) {
					lastImg = 2;
				} else {
					lastImg = 4;
				}
				map[manX + 1][manY] = 7;
				manX++;
				repaint();
			} else if (map[manX + 2][manY] == 4) {//箱子右面是目标
				map[manX + 2][manY] = 9; 
				map[manX][manY] = lastImg;
				if (map[manX + 1][manY] == 3) {
					lastImg = 2;
				} else {
					lastImg = 4;
				}
				map[manX + 1][manY] = 7;
				manX++;
				repaint();
			}
		}
	}
	
	private boolean isPass() {
		boolean pass = true;
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (map[i][j] == 3) {
					pass = false;
					break;
				}
			}
		}
		return pass;
	}
	
    public void paint(Graphics g) {

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {

				g.drawImage(imgs[map[i][j]], i * LEN, j * WIDTH, this);

			}
		}
		g.setColor(Color.BLUE);
		g.setFont(new Font("Times New Roman", Font.BOLD, 30));
		g.drawString("关卡：" + level, 50, 50);
	}
	
	public Game(int level){
		this.setBounds(0,0,600,600);
		this.setVisible(true);
		lm=new LoadMap(level);
		map = lm.getMap();
		this.manX = lm.getManX();
		this.manY = lm.getManY();
		this.level = level;
	}
	
	public void back() {
		if (!myStack.isEmpty()) {
			BackUplnfo bp = myStack.pop();
			backMap = new int[20][20];
			backMap = bp.getMap();
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					map[i][j] = backMap[i][j];
				}
			}
			this.manX = bp.getManX();
			this.manY = bp.getManY();
			repaint();
		}
	}

	public void goBack() {
		if (this.level != 1) {
			myStack.clear();
			lm = new LoadMap(--level);
			map = lm.getMap();
			this.manX = lm.getManX();
			this.manY = lm.getManY();
			repaint();
		}
	}

	public void goNext() {
		if (this.level != 50) {
			myStack.clear();
			lm = new LoadMap(++level);
			map = lm.getMap();
			this.manX = lm.getManX();
			this.manY = lm.getManY();
			repaint();
		}
	}
	
	public void reStart() {
		myStack.clear();
		lm = new LoadMap(level);
		map = lm.getMap();
		this.manX = lm.getManX();
		this.manY = lm.getManY();
		repaint();
	}
	
	public void choice(int level) {
		if (level > 0 && level <= 50) {
			myStack.clear();
			lm = new LoadMap(level);
			map = lm.getMap();
			this.manX = lm.getManX();
			this.manY = lm.getManY();
			this.level = level;
			repaint();
		}
	}

	public  boolean tishi() {
		// TODO Auto-generated method stub
		//1墙2空地3箱子4目标5/6/7/8人9目标箱子
	    @SuppressWarnings("unused")
		Tishi ts=new Tishi(map);
		return false;
	}

}
