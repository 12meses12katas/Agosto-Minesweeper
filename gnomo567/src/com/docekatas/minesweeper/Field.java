package com.docekatas.minesweeper;

import java.util.ArrayList;

public class Field {
	
	private int rows = 0;
	private int cols = 0;
	private ArrayList<String> content;
	private int[][] results;

	public Field(String string) {
		content = new ArrayList<String>();
		
		if( string != null && !string.isEmpty() ) {
			String[] lines = string.split("\n");
			boolean firstLine = true;
			
			for (String line : lines) {
				if( firstLine ) {
					getFieldSize(line);
					firstLine = false;
				}
				else {
					content.add(line);
				}
			}
			results = new int[rows][cols];
		}
	}

	private void getFieldSize(String firstline) {
		String[] vars = firstline.split(" ");
		rows = Integer.parseInt(vars[0]);
		cols = Integer.parseInt(vars[1]);
	}

	public String getResult() {
		if( rows == 0 ) {
			return "";
		}
		else {
			populateResult();
			return getResultString();
		}
	}

	private String getResultString() {
		String res = "";
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++ ) {
				if(content.get(i).charAt(j) == '*')
					res = res.concat("*");
				else
					res = res.concat(String.valueOf(results[i][j]));
			}
			res = res.concat("\n");
		}
		return res;
	}

	private void populateResult() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++ ) {
				if(content.get(i).charAt(j) == '*') {
					incrementAdjacents(i,j);
				}
			}
		}
	}

	private void incrementAdjacents(int row, int col) {
		for(int i = row - 1; i <= row + 1; i++) {
			for(int j = col - 1; j <= col + 1; j++ ) {
				if( i >= 0 && i < rows && j >= 0 && j < cols && content.get(i).charAt(j) != '*') {
					results[i][j]++;
				}
			}
		}
	}

}
