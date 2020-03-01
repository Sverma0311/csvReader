package com.utility;

import java.io.*;
import java.util.ArrayList;

public class CsvReader {
	
	private CsvReader(){}
	
	public static ArrayList<Object[]> read(String filePath){
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<Object[]> data = new ArrayList<>();
		try {
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String s =br.readLine();
			while((s=br.readLine())!=null){
				String arr[] = s.split(",");
				data.add(arr);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(fr!=null)
				br.close();
				if(br!=null)
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return data;
	}
	
	public String readValue(String filePath, int row, int column){
		FileReader fr = null;
		BufferedReader br = null;
		String value ="";
		if(filePath==null){
			System.out.println("invalid file path ");
			return null;
		}
		if(row<=0){
			System.out.println("invalid row ");
			return null;
		}
		if(column<=0){
			System.out.println("invalid column ");
			return null;
		}
			
		
		
		try {
			if(filePath != null){
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			}
			else{
				System.out.println("invalid file path");
			}
			String s ="";
			int i=0;
			while((s=br.readLine())!=null){
				String arr[] = s.split(",");
				i++;
				if(i==row){
					try{
					value = arr[column-1];
					break;
					}
					catch(Exception e){
						e.printStackTrace();
						System.out.println("invalid column");
						return null;
					
					}
				}
				
			}
			if(row>i){
				System.out.println("invalid row");
				return null;
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally{
			try {
				if(fr!=null)
				br.close();
				if(br!=null)
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return value;
	}

	
}
