package com.cg.iter.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cg.iter.bean.Address;
import com.cg.iter.bean.Student;
import com.cg.iter.service.StudentService;

@Component
public class StudentMain {
	@Autowired
	private StudentService studService;

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("student.xml");
		StudentMain sm = ctx.getBean(StudentMain.class);
		sm.startApplication();
	}

	public void startApplication() {
		// System.out.println(studService);
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		while (true) {
			choice = getChoice(scan);
			switch (choice) {
			case 1:
				System.out.println("Create Student");
				System.out.println("Enter <houseId> <HouseName> <City>");
				Address addr = new Address(scan.nextInt(), scan.next(), scan.next());
				System.out.println("Enter <ID> <Name> <Mobile> <Subject>");
				Student stud = new Student(scan.nextInt(), scan.next(), scan.nextLong(), scan.next(), addr);
				boolean success = studService.create(stud);
				if (success) {
					System.out.println("Student saved");
				} else {
					System.out.println("Could not save student");
				}
				break;

			case 2:
				System.out.println("Find Student");
				System.out.println("Enter Student Id");
				Student stud1 = studService.findStudentById(scan.nextInt());
				if (stud1 == null) {
					System.out.println("Student not found");
				} else {
					System.out.println(stud1);
				}
				break;

			case 3:
				System.out.println("Update Student");

				System.out.println("Enter Student Id");

				Student Student = studService.findStudentById(scan.nextInt());
				if (Student != null) {
					System.out.println("Enter <Name> <Mobile> <Subject>");
					Student.setName(scan.next());
					Student.setMobile(scan.nextLong());
					Student.setSubject(scan.next());
					Address AddressUp = Student.getAddress();

					System.out.println("Enter<HouseName> <City>");
					AddressUp.setHouseName(scan.next());
					AddressUp.setCity(scan.next());

					Student.setAddress(AddressUp);

					if (studService.updateStudent(Student)) {
						System.out.println("Updated sucessfully");
					} else {
						System.out.println("Fail to update");
					}
				} else {
					System.out.println("Student not found");
				}
				break;
			case 4:
				System.out.println("Delete Student");
				System.out.println("Enter Student Id");
				if (studService.deleteStudent(scan.nextInt())) {
					System.out.println("Removed sucessfully");
				}
				break;
			case 5:
				System.out.println("Find Student Names");
				System.out.println("Enter Student Name");
				Student Stud2 = studService.findStudentByName(scan.next());
				if (Stud2 == null) {
					System.out.println("Student not found");
				} else {
					System.out.println(Stud2);
				}
				break;

			case 6:
				System.out.println("Exiting Program");
				System.exit(0);
				break;

			default:
				System.out.println("Enter 1 to 4 only");
				break;
			}
		}
	}

	private int getChoice(Scanner scan) {
		int choice = 0;
		System.out.println("STUDENT MANAGEMENT");
		System.out.println("1. Create Student");
		System.out.println("2. Find Student");
		System.out.println("3. Update Student");
		System.out.println("4. Delete Student");
		System.out.println("5. Find Student Names");
		System.out.println("6. Exit Program");
		System.out.println("Choose the option from above");
		try {
			choice = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please choose a number");
			scan.nextLine();
		}
		return choice;
	}
}
