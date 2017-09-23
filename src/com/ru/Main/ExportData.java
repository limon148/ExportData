package com.ru.Main;
import edu.duke.*;
import org.apache.commons.csv.*;

public class ExportData {

	public static void main(String[] args) {
		ExportData ob = new ExportData();
		ob.tester();
	}

	private void tester() {
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		String info = countryinfo(parser, "Germany");
		System.out.println(info);
	}

	private String countryinfo(CSVParser parser, String string) {
		for(CSVRecord record : parser){
			if(record.get("Country").contains(string)){
				String country = record.get("Country") + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
				return country;
			}
		}
		return "NOT FOUND";
	}

}
