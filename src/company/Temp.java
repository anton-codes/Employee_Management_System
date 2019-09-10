package company;

/**
 * This class is responsible for Temp related logic.
 * 
 * Course Name: CST8284 Object Oriented Programming (Computer Programmer).
 * Student name: Anton Hrytsyk.
 * Student number: 040938383
 *
 * Assignment title: Company Management Tool Prototype.
 * Assignment due date: Sunday April 14, 2019 by 11:59.
 *
 * Professor Jason M
 * @version Assignment 3
 * Temp class.
 *
 * @author Anton Hrytsyk
 */

public class Temp extends Employee {


	/** Represents the date when contract with this employee is terminated. */
    private OurDate endContractDate;

    /**
     *  Default Constructor of Temp Object.
     *  Chained to the base constructor and loads default values:
     *  
     *  Name: unknown
     *  EmpNumber: -9
     *  HireDate: <code> new OurDate() </code> - default ourDate instance, represents current date.
     *  Salary: -1
     */
    public Temp() { this("Unknown", -9,new OurDate(), -1); }


    /**
     * Temp object base constructor.
     * @param name              temp employee name.
     * @param employeeNumber    temp employee employee number.
     * @param startDate         temp employee startDate.
     * @param salary            temp employee salary.
     */
    public Temp(String name, int employeeNumber,OurDate startDate, double salary) {
        super(name, employeeNumber, startDate, salary);
        setEndContractDate(new OurDate());
    }


    public Temp(String name, int employeeNumber,OurDate startDate, double salary, String date) {
        super(name, employeeNumber, startDate, salary);
        setEndContractDate(new OurDate(date));
    }

    /**
     * This method returns end-of-contract date of the Temp employee.
     * @return endOfContract value.
     */
    public OurDate getEndContractDate() {
        return endContractDate;
    }

    /**
     * Sets endContractDate to a specific value.
     * Uses OurDate class to create the OurDate object.
     * @param endContractDate OurDate object - employee end-of-contract date will be set to this value.
     */
    public void setEndContractDate(OurDate endContractDate) {
        this.endContractDate = endContractDate;
    }

    /**
     * Overloaded endOfContractDate setter.
     * Simplifies Data Entry.
     * @param day       Day Of the Month
     * @param month     Month of the Year
     * @param year      Year
     */
    public void setEndContractDate(int day, int month, int year) {
        endContractDate = new OurDate(day, month, year);
    }


    /**
     * This method is responsible for initializing the End Of Contract Date title to a user-specified value.
     * Uses Scanner API to ask user for input.
     */
    @Override
    public void loadExtraInfo() {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println("Enter end date: \n" +
                "**********************************************");
        System.out.print("Enter Day: ");
        int day = input.nextInt();
        System.out.print("Enter Month: ");
        int month = input.nextInt();
        System.out.print("Enter Year: ");
        int year = input.nextInt();
        setEndContractDate(new OurDate(day, month, year));
    }

    @Override
    public String getExtraInfo() {
        return getEndContractDate().toString();
    }

    @Override
    public void setExtraInfo(String s) {
        setEndContractDate(new OurDate(s));
    }


    /**
     * Allows to return Manager employee as a String value.
     * @return calls Employee.toString() and appends the End of Contract Date at the end.
     */
    @Override
    public String toString() {
        return super.toString() + "\t\t\tEnd of contract date: " + getEndContractDate();
    }



    /**
     * This method is used to determine if two instances of Temp are similar.
     * @param  obj object that will be compared with the caller object.
     *
     * @return false if obj is not an instance of Temp, true if object is compared with itself, true if all values are the same.
     */
    @Override
    public boolean equals(Object obj) {
        if ((obj == null) || (this.getClass() != obj.getClass())) return false;
        Temp other = (Temp)obj;
        return super.equals(obj) && ( this.getEndContractDate().equals(other.getEndContractDate()));
    }




}
