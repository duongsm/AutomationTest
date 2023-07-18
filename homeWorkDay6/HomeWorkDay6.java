package homeWorkDay6;

import java.util.Scanner;


public class HomeWorkDay6 {

	public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int numberOfEmp = scanner.nextInt();

        String[] employeeNames = new String[numberOfEmp];    
        for (int i = 0; i < numberOfEmp; i++) {
            System.out.print("Enter employee's name " + (i + 1) + ": ");
            employeeNames[i] = scanner.next();
        }
        
        System.out.println("List of employee names:");
        for (String employeeName : employeeNames) {
            System.out.println(employeeName);
        }
    }
}

