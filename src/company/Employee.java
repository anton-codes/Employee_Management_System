package company;

import java.io.Serializable;

/**
 * Responsible for Employee-related logic, a superclass of Temp, Staff and Manager classes.
 * Course Name: CST8284 Object Oriented Programming (Computer Programmer).
 * Student name: Anton Hrytsyk.
 * Student number: 040938383
 *
 * Professor Jason M
 * Assignment title: Company Management Tool Prototype.
 * Assignment due date: Sunday April 14, 2019 by 11:59.
 *
 * @version Assignment 3
 * Employee class.
 *
 * 
 * @author Anton Hrytsyk
 */

public abstract class Employee  implements Serializable {

	/** 
	 * Used during deserialization to confirm that objects are compatible.
	 */
	public static final long serialVersionUID = 1L;

	// Variables
	/*** Stores Employee name. */
	private String  name;       
	/*** Stores Employee number. */
	private int employeeNumber;         
	/*** Stores Employee start date in a form of OurDate object.*/
	private OurDate startDate;                      
	/*** Stores Employee salary.*/
	private double  salary;                         

	/**
	 * Employee object default constructor.
	 * Initializes class variables to default values.
	 *
	 * Name             by  default = "unknown";
	 * EmployeeNumber   by  default = -9;
	 * startDate        by  default = new OurDate() - instance will be created from default constructor.
	 * salary           by  default = -1;
	 */
	public Employee() {
		this("Unknown", -9, new OurDate(), -1);
	}


	/**
	 * Employee object constructor.
	 *
	 * @param name will be assigned to class variable name.
	 * @param employeeNumber will be assigned to class variable employeeNumber.
	 * @param startDate will be assigned to class variable startDate.
	 * @param salary will be assigned to class variable salary.
	 */
	public Employee(String name, int employeeNumber,OurDate startDate, double salary) {
		setEmployeeNumber(employeeNumber);
		setStartDate(startDate);
		setName(name);
		setSalary(salary);
	}



	//Getters

	/**
	 * gets salary value.
	 * @return salary value
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * gets employeeNumber value.
	 * @return employeeNumber value
	 */
	public int getEmployeeNumber() {
		return employeeNumber;
	}

	/**
	 * gets startDate value.
	 * @return startDate as an object of OurClass
	 */
	public OurDate getStartDate() {
		return startDate;
	}

	/**
	 * returns name value.
	 * @return name value.
	 */
	public String getName() {
		return name;
	}


	//Setters

	/**
	 * sets employee number to a specific value.
	 * @param employeeNumber specific value that will be assigned to a class variable.
	 */
	private void setEmployeeNumber(int employeeNumber) {
		if (employeeNumber > 0)
			this.employeeNumber = employeeNumber;
		else throw new ConsoleException("This value is impossible for employee number: " + employeeNumber);
	}




	/**
	 * sets employee name to a specific value.
	 * @param name specific value that will be assigned to a class variable.
	 */
	private void setName(String name) {

		if ((name.length() > 0))
		this.name = name;
		else throw new ConsoleException("This value is not possible for name: " + name);
	}

	/**
	 * sets employee startDate to a specific value.
	 * @param startDate specific value that will be assigned to a class variable.
	 */
	private void setStartDate(OurDate startDate) {
		this.startDate = startDate;
	}

	/**
	 * sets employee salary to a specific value.
	 * @param salary specific value that will be assigned to a class variable.
	 */
	private void setSalary(double salary) {
		if (salary > 0)
		this.salary = salary;
		else throw new ConsoleException("this value is impossible for salary: " + salary);
	}


	//Other methods

    /**
     * Allows to display employee record in a string format.
     * @return String value containing:
     *                   Employee Name
     *                   Employee Number
     *                   Employee StartDate
     *                   Employee Salary
     *
     */
	@Override
	public String toString() {
		return  getName() + "\t\t\t\t" + getEmployeeNumber() + "\t\t\t\t" + getStartDate() + "\t\t\t\t" + getSalary();
	}

    /**
     * This method is used to determine if two instances of Employee are similar.
     * @param  obj object that will be compared with the caller object.
     *
     * @return false if obj is not an instance of Employee, true if object is compared with itself, true if all values are the same.
     */
	@Override
	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass())) return false;
		Employee other = (Employee) obj;
		return (this.getName().equals(other.getName()) &&
				this.getEmployeeNumber() == other.getEmployeeNumber() &&
				this.getStartDate().equals(other.getStartDate()));



	}//END EQUALS METHOD

    /**
     * This method ensures that all subclasses will be initialized properly.
     */
	public abstract void loadExtraInfo();

	public abstract String getExtraInfo ();
	public abstract void setExtraInfo (String s);


}//END CLASS EMPLOYEE



//
