package company;

/**
 * This class is responsible for Manager related logic.
 * 
 * Course Name: CST8284 Object Oriented Programming (Computer Programmer).
 * Student name: Anton Hrytsyk.
 * Student number: 040938383
 *
 * Professor Jason M
 * Assignment title: Company Management Tool Prototype.
 * Assignment due date: Monday April 14, 2019 by 11:59.
 *
 * Assignment 3
 * Manager class.
 *
 * @author Anton Hrytsyk
 */
public class Manager extends Employee {
    // Variables
	/*** represents manager title */ 
    private String title;

    /*** Manager default constructor.*/
    public Manager() { this("Unknown", -9,new OurDate(), -1); }

    /**
     * Manager base constructor.
     * @param name              Manager Name
     * @param employeeNumber    Manager Employee Number
     * @param startDate         Manager Hiring Date
     * @param salary            Manager Salary
     */
    public Manager(String name, int employeeNumber,OurDate startDate, double salary) {
        super(name, employeeNumber, startDate, salary);
        setTitle("Unknown");
    }

    public Manager(String name, int employeeNumber,OurDate startDate, double salary, String title) {
        super(name, employeeNumber, startDate, salary);
        setTitle(title);

    }


    /**
     * this method allows access for Manager .title.
     * @return Manager Title value
     */
    public String getTitle() {
        return title;
    }


    /**
     * This method allows to set the Manager title to a specified value.
     * @param title - new manager title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method is responsible for initializing the Manager title to a user-specified value.
     * Uses Scanner API to ask user for input.
     */
    @Override
    public void loadExtraInfo() {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Enter manager title: ");
        setTitle(input.nextLine());
    }

    @Override
    public String getExtraInfo() {
        return getTitle();
    }

    @Override
    public void setExtraInfo(String s) {
        setTitle(s);
    }


    /**
     * Allows to return Manager employee as a String value.
     * @return calls Employee.toString() and appends the Manager title at the end.
     */
    @Override
    public String toString() {
        return super.toString() + "\t\t\tManager title: " + getTitle();
    }


    /**
     * This method is used to determine if two instances of Manager are similar.
     * @param  obj object that will be compared with the caller object.
     *
     * @return false if obj is not an instance of Manager, true if object is compared with itself, true if all values are the same.
     */
    @Override
    public boolean equals(Object obj) {
        if ((obj == null) || (this.getClass() != obj.getClass())) return false;
        Manager other = (Manager) obj;
        return super.equals(obj) && (this.getTitle().equals(other.getTitle()));
    }
}
