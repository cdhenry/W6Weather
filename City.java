import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class City {
	/**
	 * name of the city
	 */
	private String name;
	/**
	 * months in a year on the Gregorian calendar
	 */
	private String[] months = new String[]{
		"january", "february", "march", "april", "may",
		"june", "july", "august", "september", "october",
		"november", "december"
	};
	/**
	 * hash map of max temperatures for each day in a year sorted by month as key
	 */
	public HashMap<String, double[]> maxTemps = new HashMap<>();
	
	/**
	 * Constructor for city, assigns name and creates
	 * hash map for months and day and empty max temperatures
	 * to be filled
	 * @param name
	 */
	public City(String name) {
		this.name = name;
		
		for(int arrayIndex = 0; arrayIndex < months.length; arrayIndex++) {
			int monthIndex = arrayIndex + 1;
			String month = months[arrayIndex];
			
			// calculate number of days in a month
			int days = (int) (28 + (monthIndex + Math.floor(monthIndex/8)) % 2 + 2 % monthIndex + 2 * Math.floor(1/monthIndex));
			
			// create array associated with month name and store in hash map
			maxTemps.put(month, new double[days]);
		}
	}

	/**
	 * Adds a temperature for a certain day
	 * @param month		String - month from the Gregorian calendar
	 * @param day		Integer - Day of the month
	 * @param temp		Double - Temperature
	 * @return
	 */
	public boolean addTempForDate(String monthInput, int day, double temp){
		String month = monthInput.toLowerCase();
		if(isRealMonthDay(month, day)) {
			maxTemps.get(month.toLowerCase())[day - 1] = temp;
			return true;
		}
		return false;
	}
	
	/**
	 * Checks to see if month and day inputs actually exist
	 * @param monthInput
	 * @return
	 */
	private boolean isRealMonthDay(String monthInput, int day) {
	    for (String month : months) {
	        if (month.equals(monthInput)) {
	        	if(day > 0 && day <= maxTemps.get(month).length) {
		            return true;
	        	}
	        }
	    }
	    return false;
	}
}
