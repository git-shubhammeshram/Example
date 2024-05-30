package Lounch;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import HBNConnection.HBNConnection;
import Model.Employee;

public class DataInsertion {

	public static void main(String[] args) {

		Session session = HBNConnection.getSession();
		System.out.println(session);

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("Press\n 1.Insert Data\n 2.Read Data\n 3.Exit");
			int choice = scan.nextInt();

			if (choice == 3)
				break;

			switch (choice) {
			case 1:
				insertData(scan, session);
				break;

			case 2:
				readData(scan,session);
				break;

			default:
				break;
			}
		}
	}

	private static void readData(Scanner scan, Session session) {
		// TODO Auto-generated method stub
		
		Query namedQuery = session.getNamedQuery("read");
		List<Employee> list = namedQuery.list();
		
		for(Employee emp:list) {
			System.out.println(emp.toString());
		}
		
		
	}

	private static void insertData(Scanner scan, Session session) {
		// TODO Auto-generated method stub
		
		Transaction xn = session.beginTransaction();
		
		int i = 1;
		while(true) {
			
			System.out.println("Enter The Employee Name: - ");
			String name = scan.next();
			System.out.println("Enter The Employee Sallary:- ");
			int sallary = scan.nextInt();
			
			Employee emp = new Employee(name, sallary);
			session.save(emp);
			
			System.out.println("Do You Want To Added More Employee Data:- (Y/N) ");
			char choice = scan.next().charAt(0);
			if(choice=='n' || choice=='N')break;
			
			
			
			
		}
		
		xn.commit();
	}

}
