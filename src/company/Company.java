package company;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * <p>
 * This class is responsible for data entry and handling all Company-related logic.
 * Course Name: CST8284 Object Oriented Programming (Computer Programmer).
 * Student name: Anton Hrytsyk.
 * Student number: 040938383
 *
 * Professor Jason M
 * Assignment title: Company Management Tool Prototype.
 * Assignment due date: Sunday April 14, 2019 by 11:59.
 *
 * @version Assignment 3
 * Company class.
 * @author Anton Hrytsyk
 * </p>
 *
 */
public class Company {



	/** employee File, stores employees. */
	public static File employeeFile = new File("CurrentEmployees.emp");					
	
	/** ArrayList of employees. Stores employees of different types. */
	private ArrayList<Employee> employees;

	/** Will act as a pointer to the current employee */
	private int currentEmployee = 0;

	/**
	 * This boolean variable is set to false by default.
	 * If isMaxEmployees = false - new employees can still be added.
	 * isMaxEmployees will be set to true once the OutOfMemoryError occurs.
	 */
	private static boolean isMaxEmployees = false;													// determines if new employees can still be added.


	/** 
	 * Company class default constructor.
	 * Initializes a new ArrayList instance, 
	 * and preloads 3 employees.
	 * 
	 */
	public Company() {
		// Initializing arrayList.
		employees = new ArrayList<>();
		// Preloading three employees.
//        employees.add(addEmployee("Syd Barrett", 14, new OurDate(12, 12, 2014), 150000, CompanyConsole.MANAGER));
//        employees.add(addEmployee("Syd Barrett", 14, new OurDate(18, 11, 2009), 400000, CompanyConsole.STAFF));
//        employees.add(addEmployee("Syd Barrett", 23, new OurDate(22, 11, 2010), 432699, CompanyConsole.TEMP));

    }

	/**
	 * This method is the mutator of isMaxEmployee.
	 *
	 * Sets isMaxEmployee to the specified value.
	 * @param expression - new isMaxEmployee value.
	 */
	private void setIsMaxEmployees(boolean expression) {
		isMaxEmployees = expression;
	}

	/**
	 * This method serves as a getter for isMaximumEmployees.
	 * This method is used throughout the program to determine whether new employees can be added.
	 * @return value of isMaxEmployees.
	 */
	public boolean isMaximumEmployees() {
		return isMaxEmployees;
	}

	/**
	 * This method is an accessor of the employee ArrayList.
	 *
	 * @return - a reference to the ArrayList of Employees
	 */
	public ArrayList<Employee> getEmployees() {
		return employees;
	}

    /**
     * This method is an accessor of the currentEmployee.
     *
     * @return - current employee, a pointer to the current employee in the arrayList of employees.
     */
    public int getCurrentEmployeeIndex() {
        return currentEmployee;
    }

    /**
     * This method is a mutator of the currentEmployee.
     *
     * Changes currentEmployee to the specified value.
     *
     * User is unable to set the value grater than or equals to the size of the array.
     * @param currentEmployee - new value of currentEmployee.
	 * @return true if the value was successfully changed.
     */
    public boolean setCurrentEmployee(int currentEmployee) {
        if (!(currentEmployee >= employees.size())) {
            this.currentEmployee = currentEmployee;
            return true;
        } else return false;
    }

    /**
     * Accessor to the current employee
     *
     * @return returns employee at the index pointed by currentEmployee
     */
    public Employee getCurrentEmployee() {
        return employees.get(getCurrentEmployeeIndex());
    }

    /**
	 * This method is responsible for determining the senior Employee.
	 *
	 * Searches for employee with the earliest start date.
	 * Uses <code>Calendar.before()</code> to compare start dates.
	 *
	 * @return employee with the earliest startDate.
	 *  	   <code> null </code> if no employees are available.
	 */
	public Employee findSeniorEmployee() {
			
		if (employees.isEmpty())
			return null;																		// return null if empty

		int index = 0;																		// default index will be 0
		Calendar earliestDate = (Calendar.getInstance());										// New Calendar instance
		OurDate odEarliestStartDate = employees.get(index).getStartDate();					// gets startdate at index
		earliestDate.set(odEarliestStartDate.getYear(), odEarliestStartDate.getMonth(), odEarliestStartDate.getDay());

		OurDate startDate;
		Calendar startCalendar;
		// search for employee with the oldest startDate.
		for (int empIndex = 1;  empIndex < employees.size(); empIndex++) {
		     startDate = employees.get(empIndex).getStartDate();								// Initializing startDate
		     startCalendar = Calendar.getInstance();  											// Initializing startCalendar
		     startCalendar.set(startDate.getYear(), startDate.getMonth(), startDate.getDay());
		     // Use calendar before() method to compare Calendar start dates
		     if (startCalendar.before(earliestDate)){
		    	 index = empIndex;  // set new oldest employee
		    	 earliestDate = startCalendar;
		     }
		}
		setCurrentEmployee(index);    // Sets the index of the current employee.
		return employees.get(index);  // return employee at index with earliest startdate
	}


	/**
	 * This method returns the employee that will be added to the System.
	 *
	 * Based on user's choice one of the three subclasses will be instantiated.
	 * The object will be initialized with the base constructor in the subclass.
	 * <p>
	 * Handles <code> OutOfMemoryError with </code> setting the value of isMaxEmployee to true,
	 * and therefore preventing further addition of new employees.
	 *
	 * @param name 			 Name of the employee.
	 * @param employeeNumber employee number.
	 * @param date 			 hiring date.
	 * @param salary 		 employee salary.
	 * @param type 			 employee type - this parameter will determine the object of which class will be created.
	 *
	 * @return				 Object created from one of the Employee's subclasses. This object will later be added to the arrayList.
	 * 						 Returns <code> null </code> if OutOfMemory was thrown.
	 * </p>
	 */
	public Employee addEmployee(String name, int employeeNumber, OurDate date, double salary, int type) throws NullPointerException {
		try {


			switch (type) {

				case 1:

					employees.add( new Manager(name, employeeNumber, date, salary));
					setCurrentEmployee(employees.size() -1);
					return getCurrentEmployee();

				case 2:

					employees.add( new Staff(name, employeeNumber, date, salary));
                    setCurrentEmployee(employees.size() -1);
                    return getCurrentEmployee();

				case 3:

					employees.add( new Temp(name, employeeNumber, date, salary));
                    setCurrentEmployee(employees.size() -1);
                    return getCurrentEmployee();

				default:
					return null;

			}
		} catch (OutOfMemoryError e) {
			setIsMaxEmployees(true);
			return null;
		}
	}


	/**
	 * This method is responsible for finding employees( if exist).
	 *
	 * @param empNum employee number.
	 * @return employee whose employee number matches the parameter.
	 * 		   if employee does't exist - returns null.
	 */
	public Employee findEmployee(int empNum) {

            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getEmployeeNumber() == empNum) {
                    setCurrentEmployee(i);
                    return employees.get(i);
                }
            }
		return null;
	}

	/**
	 * This method is responsible for deleting employees( if exist).
	 * Only deletes the first employee that was found with the matching employee number.
	 *
	 * Uses findEmployee to find and determine if employee with the specified parameter exists.
	 *
	 * @param empNum employee number.
	 * @return Employee that will be deleted from the arrayList.
	 * 		   if employee wasn't found - returns null.
	 */
	public Employee deleteEmployee(int empNum) {

		Employee emp = findEmployee(empNum);
		if (emp != null) {
			employees.remove(emp);
			return emp;
		}
		return null;

	}

	/**
	 * This method is responsible for Employee object serialization.
	 * Employee Objects are being save to a file in binary.
	 * File name: CurrentEmployees.emp
	 *
	 * Employees are loaded using <code> FileOutputStream fOut = new FileOutputStream(employeeFile);
	 * ObjectOutputStream objOut = new ObjectOutputStream(fOut);</code>
	 *
	 * <i>If file doesn't exit it will be created.</i>
	 */
	public void saveEmployeesToFile() {

		try(
				FileOutputStream fOut = new FileOutputStream(employeeFile);
				ObjectOutputStream objOut = new ObjectOutputStream(fOut);
				) {

					for (Employee employee : getEmployees())
						objOut.writeObject(employee);


		} catch (IOException e) {
			System.out.println("Failed IO operation.");
		}
	}

	/**
	 * This method is responsible for loading employees from the file.
	 *
	 * Initiates employee deserialization,
	 * employee objects are being loaded into the employees ArrayList.
	 *
	 * Employees are loaded using <code> FileInputStream fIn = new FileInputStream(employeeFile);
	 * ObjectInputStream objIn = new ObjectInputStream(fIn);</code>
	 * If EOFException was thrown - all employees were successfully loaded.
	 *
	 * Handles FileNotFoundException by trying to create the file recursively.
	 * Handles classNotFound exception by printing out stacktrace.
	 *
	 * <i>if the file doesn't exist it will be created.</i>
	 * If for any reason cannot create a file - new ConsoleException is thrown.
	 *
	 * @throws IOException thrown if IO operation was somehow interrupted.
	 */
	public void loadEmployeesFromFile() throws IOException {
		try(
				FileInputStream fIn = new FileInputStream(employeeFile);
				ObjectInputStream objIn = new ObjectInputStream(fIn);
			) {
		            setCurrentEmployee(0);
					while (!isMaximumEmployees())
					getEmployees().add((Employee)objIn.readObject());

		} catch (EOFException e) {
			System.out.println("File was successfully loaded");

		} catch (FileNotFoundException e) {

			// If file was somehow deleted during execution.
			if (employeeFile.createNewFile())
				loadEmployeesFromFile();
			else throw new ConsoleException("Cannot create a file");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}










}// end class 
