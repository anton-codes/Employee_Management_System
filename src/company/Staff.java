package company;


/**
 * This class is responsible for staff related logic.
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
 * Staff class.
 *
 * @author Anton Hrytsyk
 */
public class Staff extends Employee {

	/** represents employee department */
    private String department;

    /** Staff default constructor */
    public Staff() { this("Unknown", -9,new OurDate(), -1); }

    /**
     * Staff employee default constructor.
     *
     * @param name              Staff employee name.
     * @param employeeNumber    Staff employee employee number.
     * @param startDate         Staff employee startDate.
     * @param salary            Staff employee salary.
     */
    public Staff(String name, int employeeNumber,OurDate startDate, double salary) {
        super(name, employeeNumber, startDate, salary);
        setDepartment("Unknown");
    }


    public Staff(String name, int employeeNumber,OurDate startDate, double salary, String dept) {
        super(name, employeeNumber, startDate, salary);
        setDepartment(dept);
    }

    /**
     * Accesses department value.
     * @return department value
     */
    public String getDepartment() {
        return department;
    }

    /**
     * sets department variable to a specified value
     * @param department department value
     */
    public void setDepartment(String department) {
        this.department = department;
    }


    /**
     * This method is responsible for initializing the department title to a user-specified value.
     * Uses Scanner API to ask user for input.
     */
    @Override
    public void loadExtraInfo() {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Enter department title: ");
        setDepartment(input.nextLine());
    }

    @Override
    public String getExtraInfo() {
        return null;
    }

    @Override
    public void setExtraInfo(String s) {

    }


    /**
     * Allows to return Staff employee as a String value.
     * @return calls Employee.toString() and appends the Department at the end.
     */
    @Override
    public String toString() {
        return super.toString() + "\t\t\tEmployee department: " + getDepartment();
    }


    /**
     * This method is used to determine if two instances of Staff are similar.
     * @param  obj object that will be compared with the caller object.
     *
     * @return false if obj is not an instance of Staff, true if object is compared with itself, true if all values are the same.
     */
    @Override
    public boolean equals(Object obj) {
        if ((obj == null) || (this.getClass() != obj.getClass())) return false;
        Staff other = (Staff) obj;
        return super.equals(obj) && (this.getDepartment().equals(other.getDepartment()));
    }
}
