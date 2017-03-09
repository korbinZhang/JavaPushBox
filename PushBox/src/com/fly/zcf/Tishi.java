package com.fly.zcf;

public class Tishi {
	private int[][] tishi;
	public int[][] tishi1=tishi;

	
	public Tishi(int map[][]){
		int i,j;
		int k=10;
		for(i=0;i<20;i++){
			for(j=0;j<20;j++){
				if(map[i][j]==3)
					this.tishi[i][j]=k++;
				else
					tishi[i][j]=map[i][j];
			}
		}
	}

}