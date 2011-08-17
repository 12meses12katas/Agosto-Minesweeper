package com.docekatas.minesweeper;

import java.util.ArrayList;

public class Minesweeper {
	
	private ArrayList<Field> fields = new ArrayList<Field>();

	public Minesweeper(String string) {
		String field = "";
		String[] lines = string.split("\n");
		
		int i = 0;
		while(!lines[i].equalsIgnoreCase("0 0")) {
			field = "";
			do {
				field = field.concat(lines[i]).concat("\n");
				i++;
			} while(lines[i].matches("[\\*.]*"));
			fields.add(new Field(field));
		}
	}

	public String getResult() {
		String res = "";
		int i = 1;
		
		for(Field f : fields) {
			res = res.concat("Field #").concat(String.valueOf(i)).concat(":\n");
			res = res.concat(f.getResult()).concat("\n");
			i++;
		}
		return res;
	}

}
