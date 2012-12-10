/**
 * 
 */
package de.pqm.app.importer;

/**
 * @author Marcus
 *
 */
public class StockList {
//	public class StockList implements Comparable<StockList> {

	 private String company;
	 private float percentage;
	
	/**
	 * 
	 */
	public StockList(String c, float p) {
		// TODO Auto-generated constructor stub
		 this.company = c;
	     this.percentage = p;
	}
	
	public float getPercentage() {    
		return this.percentage;
	}
	
	public String toString() {
        return this.company + " (" + this.percentage + ")";
    }

//	public float compareTo(StockList stock) {
//		// TODO Auto-generated method stub
//		return this.percentage.compareTo(stock.getPercentage());
//	}

}
