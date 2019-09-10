package company;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;  // Note: OurDate wraps Calendar

/**
 * This class is responsible for Date logic and calculation.
 * 
 * Course Name: CST8284 Object Oriented Programming (Computer Programmer).
 * Student name: Anton Hrytsyk.
 * Student number: 040938383
 *
 * Professor Jason M
 * Assignment title: Company Management Tool Prototype.
 * Assignment due date: Sunday April 14, 2019 by 11:59.
 *
 * @version Assignment 3
 * OurDate class.
 *
 * @author Anton Hrytsyk
 */

public class OurDate implements Serializable {

// Variables
	/*** Stores day value. */
	private int day;                                                        
	/*** Stores month value. */
	private int month;                                                      
	/*** Stores year value. */
	private int year;                                                       

	// Constants
	/**
	 *  Default calendar value set for current date.
	 *  {@value }Calendar.getInstance()
	 */
	private static final Calendar CALENDAR = Calendar.getInstance();       


	/**
	 * OurDate default constructor.
	 * Initializes fields with the current date values.
	 */
    public OurDate() {
    	this(CALENDAR.get( Calendar.DATE     ),
		     CALENDAR.get( Calendar.MONTH 	 )+1,							// Note: +1 because Calendar API numbers month from 0
		     CALENDAR.get( Calendar.YEAR)    );
    }

	/**
	 * OurDate constructor.
	 *
	 * @param day 		day of month.
	 * @param month 	month of the year
	 * @param year		year value.
	 */
	public OurDate(int day, int month, int year) {	
		setDay(day);
		setMonth(month);
		setYear(year);	
	}


	public OurDate(String startDate) throws ConsoleException {
		setOurDate(startDate);
	}

	public boolean setOurDate(String s) throws ConsoleException {
		boolean result = true;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		dateFormat.setLenient(false);
		try {
			String[] dmy = s.split("/");
			setYear(Integer.parseInt(dmy[2]));
			setMonth(Integer.parseInt(dmy[1]));
			setDay(Integer.parseInt(dmy[0]));
			CALENDAR.setTime(dateFormat.parse(s));

		} catch (NumberFormatException e) {
			throw new ConsoleException ("Bad input value; date " + s + " contains non-numeric value");
		} catch (IllegalArgumentException e) {
			throw new ConsoleException ("Bad data type passed to an internal method");
		} catch (RuntimeException e) {
			throw new ConsoleException ("General runtime exception thrown setting start date");
		} catch (ParseException e) {
			throw new ConsoleException ("Date " + s + " not possible");
		}
		return result;
	}



	//Getters
	/**
	 * Gets the value of the day field of OurDate object.
	 * @return returns day value.
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Gets the value of the month field of OurDate object.
	 * @return returns month value.
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Gets the value of the year field of OurDate object.
	 * @return returns year value.
	 */
	public int getYear() {
		return year;
	}


	/**
	 * Sets the day parameter of OurDate object to a specific value
	 *
	 * If day is not in the range [1 - 31] ConsoleException will be thrown,
	 * indicating that there was an attempt to assign impossible value.
	 *
	 * @param day integer value of the day
	 */
	private void setDay(int day) {
		if (day <= 31 && day >= 1)
		this.day = day;
		else throw new ConsoleException("This value is impossible for day : " + day);
	}

	/**
	 * Sets the month parameter of OurDate object to a specific value
	 *
	 * If month is not in the range [1 - 12] ConsoleException will be thrown,
	 * indicating that there was an attempt to assign impossible value.
	 *
	 *
	 * @param month integer value of the month
	 */
	private void setMonth(int month) {
		if (month <= 12 && month >=1)
		this.month = month;
		else throw new ConsoleException("This value is impossible for month : " + month);
	}
	/**
	 * Sets the year parameter of OurDate object to a specific value.
	 *
	 * If day is not in the range [1 - 31] ConsoleException will be thrown,
	 * indicating that there was an attemp to assign impossible value.
	 * @param year integer value of the year.
	 */
	private void setYear(int year) {
		if (year > 0)
		this.year = year;
		else throw new ConsoleException("This value is impossible for year: " + year);
	}

	/**
	 * Allows to print data fields in a specific string format.
	 *
	 * @return Returns a string that is used to display dates in dd/mm/yyyy format.
	 */
	@Override
	public String toString() {  return this.day +"/" +this.month + "/" + this.year; }


	/**
	 * This method is used to determine if two instances of OurDate are similar.
	 * @param  obj object that will be compared with the caller object.
	 *
	 * @return false if obj is not an instance of OurDate, true if object is compared with itself, true if date values are the same.
	 */
	@Override
	public boolean equals(Object obj) {

		if ((obj == null) || (this.getClass() != obj.getClass())) return false;
		OurDate other = (OurDate) obj;
	    return (this.getDay() == other.getDay() && 
	    		this.getMonth() == other.getMonth() && 
	    		this.getYear() == other.getYear() ) ; 
			
	}//END EQUALS METHOD 
	
}//END CLASS OurDate





