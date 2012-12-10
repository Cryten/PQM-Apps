/**
 * 
 */
package de.pqm.app;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeMap;

import de.pqm.app.importer.MagicCSV;


/**
 * @author Erik Mautsch
 * @author Stephan Röder
 * @author Marcus Luzius
 * @ version 1.0
 */
public class StockManager {

	public static final InputStream in = null;
	
	/**
	 * 
	 */
	public StockManager() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Read in the path to the .csv file from command prompt
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Bitte geben Sie den Pfad zu Ihrer CSV-Datei ein: ");
		String path = null;
		//String newPath = null;
		try {
			path = console.readLine();
			//newPath = path.replace('\\', '/');
		} catch (IOException e) {
			// Sollte eigentlich nie passieren
			e.printStackTrace();
		}
		System.out.println("Ihre Eingabe war: " + path + "\n");
		
		MagicCSV csvImporter = new MagicCSV();

		ArrayList<String[]> stockList = new ArrayList<String[]>();
		stockList = csvImporter.getCompanyList(path);
		
		// All stock data
		TreeMap<Number, String[]> stockTree = new TreeMap<Number, String[]>();
		
		// To get comma value
		NumberFormat nf = NumberFormat.getInstance(Locale.GERMAN);
		Number pNumber = null;
		
		// Store element values
		String[] arr = null;
		
		// Iterate all stock entries
		for (int i = 0; i<stockList.size(); i++) {
			arr = stockList.get(i);
			
			for (int j = 0; j<arr.length; j++) {
			
				// Search for % and delete + and % sign
				if (arr[j].contains("%")) {
					StringBuffer sb = new StringBuffer();
					sb.append(arr[j]);
					sb.deleteCharAt(arr[j].indexOf("%"));
					
					if (arr[j].contains("+")) {
						sb.deleteCharAt(arr[j].indexOf("+"));
					}
					
					String percentageRevenue = new String();
					percentageRevenue = sb.toString();
					
					try {
						pNumber = nf.parse(percentageRevenue);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// Put key value and String array in a TreeMap to order the data
					// Key value has to be converted from String to Number/Double
					stockTree.put(pNumber, arr);
				}
			
		}
			
		}
	
		// Array to store keys, will be used to sort the data in reverse order
		Number[] key = new Number[stockTree.size()];
			
		// Flop 5
		int flop = 0;

		System.out.println("----------- Flop 5 -----------");
						
		for (Number elem : stockTree.keySet()) {
			if (flop<stockTree.size()){
				key[flop] = elem;				
			}
			
			if (flop <5) {
			System.out.print(elem + "% | ");
			
			for (int x = 0; x<stockTree.get(elem).length; x++) {
				if (x == 3) {
					// Ignore percent value because it's printed as key value
				}
				else
					System.out.print(stockTree.get(elem)[x] + " | ");
				
			}
			
			System.out.print("\n");
			}
			flop++;
		}
		
		// To seperate flop list and top list 
		System.out.print("\n");
		
		
		// Top 5
		int top = 0;
		System.out.println("----------- Top 5 -----------");
	
		for (int i = key.length-1; i>0; i--) {
			
			if (top < 5) {
				System.out.print(key[i] + "% | ");
			
				for (int x = 0; x<stockTree.get(key[i]).length; x++) {
					
					if (x == 3) {
						// Ignore percent value because it's printed as key value
					}
					else
						System.out.print(stockTree.get(key[i])[x] + " | ");
				}
			
				System.out.print("\n");
			}
			
			top++;
		}
		
		
	}
	
}
