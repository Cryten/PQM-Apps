/**
 * 
 */
package de.pqm.app.importer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

/**
 * @author Erik Mautsch
 * @author Stephan Röder
 * @author Marcus Luzius
 * @ version 1.0
 */
public class MagicCSV {

	/**
	 * 
	 */
	public MagicCSV() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<String[]> getCompanyList(String filePath) {
		ArrayList<String[]> lines = null;
		
		try{
			// Read in all stock data.
			CSVReader reader = new CSVReader(new FileReader(filePath), ';');
			lines = (ArrayList<String[]>) reader.readAll();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return lines;
	}
	
//	public List<Outperformer[]> getCompanyList(String filePath) {
//	    // ...
//		List<Outperformer[]> stockEntries = new ArrayList()<Outperformer[]>();
//		
//		// ...
//		
//		return stockEntries;
//	}
//	
//	public void sortCompanyList(ArrayList<Outperformer[]> companyList) {
//		// ...
//		
//	}	

}
