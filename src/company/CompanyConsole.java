package company;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

    /**
     *
     * <b>This class is responsible for data entry and handling all user interactions when running in console mode</b>
     *
     * Course Name: CST8284 Object Oriented Programming (Computer Programmer).
     * <h2> Student name: Anton Hrytsyk.
     *      Student number: 040938383
     *      Professor: Jason M
     * </h2>
     *
     * <h1>Assignment title: Company Management Tool Prototype.</h1>
     * Assignment due date: Sunday April 14, 2019 by 11:59.
     *
     * @version Assignment 3
     * <h1> CompanyConsole class. </h1>
     *
     *
     * @author Anton Hrytsyk
     */
    public class CompanyConsole {


        // constants (Used in menu method)
        /**
         * Display senior employee selection.
         * {@value} 3
         */
        private static final int DISPLAYSENIOREMPLOYEE     = 3;     // Display senior employee selection.
        /**
         * Display all employees selection
         * {@value} 2
         */
        private static final int DISPLAYEMPLOYEES          = 2;     // Display all employees selection.
        /**
         * Add new employee selection.
         * {@value} 1
         */
        private static final int ADDEMPLOYEES              = 1;     // Add new employee selection.
        /**
         * Exit selection.
         * {@value} 9
         */
        private static final int EXIT                      = 9;     // Exit selection.
        /**
         * Find Employee selection.
         * {@value} 4
         */
        private static final int FIND_EMPLOYEE             = 4;     // Find Employee selection.
        /**
         * Delete Employee selection.
         * {@value} 5
         */
        private static final int DELETE_EMPLOYEE           = 5;     // Delete Employee selection.
        /**
         * Add manager selection.
         * {@value} 1
         */
        public static final int MANAGER                    = 1;     // add manager selection.
        /**
         * Add staff member selection.
         * {@value} 2
         */
        public static final int STAFF                      = 2;     // add staff member selection.
        /**
         * Add temp selection.
         * {@value} 3
         */
        public static final int TEMP                       = 3;     // add temp selection.
        /**
         * save employees to file selection.
         * {@value} 6
         */
        public static final int SAVE_EMPLOYEES_TO_FILE 	   = 6;		// save employees to file selection.
        /**
         * load employees from file selection.
         * {@value} 7
         */
        public static final int LOAD_EMPLOYEE_FROM_FILE    = 7;		// load employees from file selection.

        // variables
        /** * Company Object Used to run application. */
        private Company startUp;
        /** * Responsible for all inputs */
        private Scanner in;


        /**
         * CompanyConsole object Constructor.
         * Creates an instance of Company class.
         */
        public CompanyConsole() {
            startUp = new Company();

        }


        /**
         * Saves all employees to the file.
         *
         * Triggers employee serialization.
         * All employees are being saved to the CurrentEmployees.emp file.
         *
         * <i>if the doesn't exist it will be created.</i>
         */
        private void saveEmployees() {
            startUp.saveEmployeesToFile();
            System.out.println("Employees in the system were successfully saved");
        }

        /**
         * Loads employees from the file.
         *
         * Triggers employee deserialization.
         * Loads employees from CurrentEmployees.emp into the code.
         *
         * <i>if the doesn't exist it will be created.</i>
         */
        private void loadEmployees() {
            try {
                startUp.loadEmployeesFromFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        /**
         * Adds employees using addEmployee method from Company class.
         * Asks user to enter EMPLOYEE NAME, EMPLOYEE NUMBER, SALARY and HIRING DATE information.
         * Method is called when user enter 1 (ADDEMPLOYEES) in the menu.
         *
         * This function is also responsible for prompting user to select employee type.
         *
         * Employee type Selection:
         *
         * MANAGER  = 1;
         * STAFF    = 2;
         * TEMP     = 3;
         *
         */
        private void addEmployee() {

            boolean correctInputs;								  // This local variable is used to exit the loop when all inputs are correct.
            do {
                in = new Scanner(System.in);                            // Redefining Scanner object to fix "scanner waiting for new line" bug
                System.out.print("EMPLOYEE NAME: ");
                String name = in.nextLine();

                System.out.print("EMPLOYEE NUMBER: ");
                int employeeNumber = in.nextInt();

                System.out.print("SALARY: ");
                double salary = in.nextDouble();

                System.out.println("HIRING DATE");
                System.out.print("YEAR: ");
                int year = in.nextInt();

                System.out.print("MONTH: ");
                int month = in.nextInt();

                System.out.print("DAY: ");
                int day = in.nextInt();



                System.out.println("********************************************** \n" +
                        "SELECT EMPLOYEE POSITION   	\n" +
                        "1. MANAGER  					\n" +
                        "2. REGULAR STAFF        		\n" +
                        "3. TEMPORARY EMPLOYEE          \n" +
                        "********************************************** \n");
                correctInputs = false;
                in = new Scanner(System.in);                                                                     // Handles data entry
                try {
                    int type = in.nextInt();

                    Employee tempObj = startUp.addEmployee(name, employeeNumber, new OurDate(day, month, year), salary, type );

                    if (tempObj != null) {
                        tempObj.loadExtraInfo();
                        startUp.getEmployees().add(tempObj);
                    }

                    correctInputs = true;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input, try again \n\n");
                } catch (ConsoleException e) {
                    System.out.println(e.getMessage()+ " please try again. \n\n");

                }
            } while (!correctInputs);																		// runs until correct inputs are entered.

        }

        /**
         * Displays list of all employees.
         * Also displays their NAME, EMPLOYEE NUMBER, SALARY and hiring date information.
         * Method is called when user enters 2 (DISPLAYEMPLOYEES) in the menu.
         */
        private void displayEmployees() {

            for (int i = 0; i < startUp.getEmployees().size(); i++) {
                System.out.println(startUp.getEmployees().get(i).toString());
            }
        }

        /**
         * Methods is used to display senior employee.
         * method displays NAME, EMPLOYEE NUMBER, SALARY and hiring date information.
         * Method is called when user enters 3 (DISPLAYSENIOREMPLOYEE) in the menu.
         */
        private void displaySeniorEmployee() {

            System.out.println( "SENIOR EMPLOYEE: 			  \n" +
                    "NAME\t\t\t\tEMPLOYEE.NO\t\t\t\t" +
                    "START DATE\t\t\t\tSALARY\n"
            );
            System.out.println();
            try {
                System.out.println(startUp.findSeniorEmployee().toString());
            } catch (NullPointerException e) {
                System.out.println("Employee database is empty");
            }


        }

        /**
         * Prints menu interface and allows user to interact with the application.
         * Method is called when user first launches the application.
         */
        private void printInterface() {
            System.out.println( "********************************************** \n" +
                    "1. ADD EMPLOYEE \n" +
                    "2. DISPLAY EMPLOYEE \n" +
                    "3. DISPLAY SENIOR EMPLOYEE \n" +
                    "4. FIND EMPLOYEE \n" +
                    "5. DELETE EMPLOYEE \n" +
                    "6. SAVE_EMPLOYEES_TO_FILE EMPLOYEES TO A FILE \n" +
                    "7. LOAD_EMPLOYEE_FROM_FILE EMPLOYEES FROM A FILE \n" +
                    "9. EXIT \n" +
                    "**********************************************"
            );
        }

        /**
         * Method contains menu related logic, handles user interaction and ensures correct input.
         * This method is also responsible for displaying requested data.
         * User is expected to give input that matches one of the following constants:
         *
         * ADD_EMPLOYEE               = 1;
         * DISPLAY_EMPLOYEES          = 2;
         * DISPLAY_SENIOR_EMPLOYEE    = 3;
         * FIND_Employee			      = 4;
         * DELETE_EMPLOYEE			  = 5;
         * SAVE_EMPLOYEE_TO_FILE	      = 6;
         * LOAD_EMPLOYEES_FROM_FILE	  = 7;
         * EXIT                       = 9;
         *
         *
         * If user enters non-numeric character - {@link InputMismatchException} will be thrown,
         * If user enters numeric value that doesen't match any of the constants - ConsoleException will be thrown.
         *
         * Exceptions are handled by printing out "Invalid Input, try again!" and prompting user to go again.
         *
         */
        public void menu() {

            boolean correctInputs;																				// Used to exit the loop when inputs are correct		                                                                               // Used to exit the loop when inputs are correct
            do {
                printInterface();                                                                                // Prints menu interface
                correctInputs = false;
                in = new Scanner(System.in);                                                                     // Handles data entry
                try {
                    int userAction = in.nextInt();

                    switch (userAction) {

                        case ADDEMPLOYEES :
                            if (!startUp.isMaximumEmployees())
                                addEmployee();
                            else System.out.println("Maximum number of employees is reached");
                            break;

                        case DISPLAYEMPLOYEES :
                            System.out.println("NAME\t\t\t\tEMPLOYEE.NO\t\t\t\tSTART DATE\t\t\t\tSALARY\t\t\t\tADDITIONAL INFO\n");
                            displayEmployees();
                            break;

                        case DISPLAYSENIOREMPLOYEE :
                            displaySeniorEmployee();
                            break;

                        case FIND_EMPLOYEE :
                            findEmployee();
                            break;

                        case DELETE_EMPLOYEE :
                            deleteEmployee();
                            break;

                        case SAVE_EMPLOYEES_TO_FILE:
                            saveEmployees();
                            break;

                        case LOAD_EMPLOYEE_FROM_FILE:
                            loadEmployees();
                            break;

                        case EXIT :
                            System.out.println("Thank you, good bye!");
                            correctInputs = true;
                            break;

                        default:
                            throw new ConsoleException("Invalid Input");                                                  // Throws exception
                    }

                } catch (InputMismatchException | ConsoleException e) {
                    System.out.println("Invalid Input, try again \n\n");
                }
            } while (!correctInputs);                                                                            // Exits when inputs are correct
        }


        /**
         * This function is responsible for removing employees (if they exist).
         *
         * Uses findEmployee method in company.Company to find the employee (if exists).
         * Stores results of findEmployee call in a temporary Employee object.
         * Passes temporary object to the deleteEmployee function in company.Company to remove the employee.
         */
        private void deleteEmployee() {
            System.out.print("Enter employee number: ");

            Employee tempObj = startUp.findEmployee(in.nextInt());
            if (tempObj != null) {
                startUp.getEmployees().remove(tempObj);
                System.out.println("Employee record [" + tempObj.getName() +" ; number: #" + tempObj.getEmployeeNumber()+ "] " + "was deleted");
            } else System.out.println("Employee record with this number is not present in the database.");
        }

        /**
         * This function is responsible for finding employees (if exist).
         *
         * Calls findEmployee function in company.Company to get the Employee object (or null if Employee wasn't found).
         * If the employee was found - results are displayed to the console.
         */
        private void findEmployee() {
            System.out.println("Enter employee Number: ");
            Employee obj = startUp.findEmployee(in.nextInt());

            if (obj != null)
                System.out.println("Employee record [" + obj.toString() +"]");
            else System.out.println("Employee record with this number is not present in the database");
        }


        /**
         * Main method.
         * Creates an instance of CompanyConsole and launches the menu.
         * @param args (When running from terminal) array of strings that can store values specified after CompanyConsole java
         */
        public static void main(String... args) {
            CompanyConsole console = new CompanyConsole();                                                         // Starts the application
            console.menu();
        }

    } //END CLASS CompanyConsole

