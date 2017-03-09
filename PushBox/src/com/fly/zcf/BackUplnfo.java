package com.fly.zcf;

class BackUplnfo {
	private int[][] map;
	private int manX;
	private int manY;

	public BackUplnfo(int[][] map, int manX, int manY) {
		this.map = map;
		this.manX = manX;
		this.manY = manY;
	}

	public int[][] getMap() {
		return map;
	}

	public int getManX() {
		return manX;
	}

	public int getManY() {
		return manY;
	}


}
