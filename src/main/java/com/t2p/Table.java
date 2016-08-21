package com.t2p;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Table {
	private Document document = null;
	private String str;
	int[] rowsMax;
	int[] rowsSpan;
	int[] colSpan;
	
	private Elements rows;

	public void Print() {
		int lineL = getMaxRowLength();
        printLine(lineL, "-");
    	System.out.println();	
		for (int i = 0; i < rows.size(); i++) {
			Elements e = rows.get(i).children();
			int j = 0;
			System.out.print("|");
			for (Element ee : e) {
				Integer lengColumn = rowsMax[j];
				if (rowsSpan[j] != 0) {
					printFine(" ", rowsMax[j]);
					rowsSpan[j]--;
					j++;
				}
				
				if (ee.hasAttr("rowspan")) {
					int rowSpan = Integer.parseInt(ee.attr("rowspan"));
					rowsSpan[j]= rowSpan;
				}
				if (ee.hasAttr("colspan")) {
					colSpan[j] = Integer.parseInt(ee.attr("colspan"));
					for (int colSpan = Integer.parseInt(ee.attr("colspan")); colSpan > 1 ; colSpan--)
					{
						j++;
						lengColumn = lengColumn + rowsMax[j]+1; // +1 because | 
					}
				}
				printFine(ee.text(), lengColumn);
				j++;
			}
			System.out.println();
			printLine();
		}
	}

	private void printLine() {
	    int i=0; 
		while(i<rowsSpan.length){
			if (rowsSpan[i] == 0){ 
				printLine (rowsMax[i]+ (i==0?2:1), "-");
				i++;
			}
			else{
				int j = i;
				int l = colSpan[i];
				for (int k = 0; k <= l; k++)  {
				printLine (rowsMax[i]+(i==0?2:1), " ");
				i++;
			}
			rowsSpan[j]--;

			}
		}
		System.out.println();
	}

	private void printLine(int lineL, String s) {
	for (int i =0; i<lineL; i++) System.out.print(s);
	}


	private void printFine(String text, int i) {
		for (int k=i-text.length();k>0; k--) System.out.print(" ");
		System.out.print(text + "|");
	}

	public int getMaxRowLength() {
		int size = getSizeColumns();
		rowsMax = new int[size];
		rowsSpan = new int[size];
		colSpan = new int[size];
		for (int i = 0; i < rows.size(); i++) {
			Elements e = rows.get(i).children();
			int j = 0;
			for (Element ee : e) {
				Integer leng = ee.text().length();
					if (rowsMax[j] < leng)
						rowsMax[j] = leng;
				j++;
			}
		}
		int max = 0;
		for (Integer k : rowsMax)
			max += k;
		max +=rowsMax.length;
		return max+1;

	}

	private int getSizeColumns() {
		int size = 0;
		for (int i = 0; i < rows.size(); i++) {
			Elements e = rows.get(i).children();
			if (e.size()> size) size=e.size();
		}
		return size;
	}

	public void init() throws IOException {
		document = Jsoup.parse(new File(str), "ISO-8859-1");
		rows = document.select("table > tbody > tr");
	}

	public Table(String str) {
		this.str = str;
	}
}
