package javaCourse;
import java.util.*;

public class StudentEvaluation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student ID: ");
		int studentId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Student Name: ");
		String studentName = sc.nextLine();
		System.out.println("Enter the Marks (0 to 100): ");
		int marks = sc.nextInt();
		System.out.println("Enter Fee Paid Status (Yes/No or True/False): ");
		String feeInput = sc.next().toLowerCase();
		boolean feePaid = feeInput.equals("true") || feeInput.equals("yes");
		//Part 1: Pass / Fail Decision (if / else)
		String res;
		if(marks >= 40) {
			res = "Student Passed";
		} else {
			res = "Student Failed";
		}
		//Part 2: Grade Assignment (else-if ladder)
		char grade;
		if(marks >= 85) {
			grade = 'A';
		} else if(marks >= 70) {
			grade = 'B';
		} else if(marks >= 50) {
			grade = 'C';
		} else {
			grade = 'D';
		}
		//Part 3: Certificate Eligibility (boolean + if)
		String certStatus;
		if(marks >= 40 && feePaid) {
			certStatus = "Eligible for Certificate";
		} else {
			certStatus = "Not Eligible for Certificate";
		}
		//Part 4: Course Allocation (switch)
		String course;
		switch(grade) {
		case 'A':
			course = "Data Science";
			break;
		case 'B':
			course = "Java Full Stack";
			break;
		case 'C':
			course = "Web Development";
			break;
		case 'D':
			course = "Basic Programming";
			break;
		default:
			course = "Counseling";
		}
		//Final Output Requirement
		System.out.println("Student Evaulation Summary:");
		System.out.println("Student ID & Name: " + studentId + " " + studentName);
		System.out.println("Marks & Result: " + marks + " " + res);
		System.out.println("Grade: " + grade);
		System.out.println("Fee Paid Status: " + (feePaid ? "Yes" : "No"));
		System.out.println("Certificate Eligibility: " + certStatus);
		System.out.println("Allocated Course " + course);
		sc.close();
	}

}
