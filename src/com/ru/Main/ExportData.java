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
		parser = fr.getCSVParser();
		listExportersTwoProducts(parser, "gold", "diamonds");
	}

	private void listExportersTwoProducts(CSVParser parser, String string, String string2) {
		for(CSVRecord record : parser){
			if(record.get("Exports").contains(string) && record.get("Exports").contains(string2)){
				System.out.println(record.get("Country"));
			}
		}
		
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
