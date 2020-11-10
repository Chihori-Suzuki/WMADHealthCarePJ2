package ca.healthcare.pj;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HealthCareCenter {
	
	public static User checkId(int Id, ArrayList<User> users) {
		for(User u : users) {
			if(u.getId() == Id) {
				return u;
			}
		}
		System.out.println("It's an incorrect doctor ID");
		return null;
	}
	
	public static void main(String[] args) {
		//In the driver class, create the ArrayList of User and add all the patient and doctor objects to this arrayList. 
		ArrayList<User> users = new ArrayList<User>();
		Patient p1 = new Patient(1001, "Woody", "Woodpecker", "798 156 99855", "woodytoon@msn.com", LocalDate.of(1975, 12, 12), 'M');
		Patient p2 = new Patient(1002, "Lightnin", "McQueen", "744 456 2891", "mcQueen@msn.com", LocalDate.of(2000, 03, 14), 'M');
		Patient p3 = new Patient(1003, "Sailor", "Mars", "", "sailormoon@msn.com", LocalDate.of(1955, 01, 21), 'W');
		Patient p4 = new Patient(1004, "Minnie", "Mouse", "964 114 7654", "miniemouse@msn.com", LocalDate.of(1929, 11, 30), 'W');
		Patient p5 = new Patient(1005, "Bruce", "Wayne", "778 512 0129", "brucewayne@msn.com", LocalDate.of(2018, 01, 29), 'M');
		Patient p6 = new Patient(1006, "Shrek", "Charming", "546 879 1456", "shrekcharming@msn.com", LocalDate.of(1989, 03, 14), 'M');
		Patient p7 = new Patient(1007, "Clint", "Eastwood", "798 545 5462", "clinteastwood@msn.com", LocalDate.of(1900, 1, 2), 'M');
		Patient p8 = new Patient(1008, "Sarah", "Connor", "666 666 6666", "judgementday@msn.com", LocalDate.of(1975, 5, 5), 'w');
		Patient p9 = new Patient(1009, "Pepper", "Pots", "975 685 5671", "mrsstark@msn.com", LocalDate.of(1965, 8, 21), 'W');
		Patient p10 = new Patient(1010, "He", "Man", "951 314 5576", "skull@msn.com", LocalDate.of(1949, 9, 28), 'M');
		users.add(p1);
		users.add(p2);
		users.add(p3);
		users.add(p4);
		users.add(p5);
		users.add(p6);
		users.add(p7);
		users.add(p8);
		users.add(p9);
		users.add(p10);
		
		Appointment app1 = new Appointment(p1, LocalDate.of(1975, 12, 12), LocalTime.of(12, 00, 00));
		Appointment app2 = new Appointment(p2, LocalDate.of(1975, 12, 12), LocalTime.of(12, 00, 00));
		ArrayList<Appointment> appList = new ArrayList<Appointment>();
		appList.add(app1);
		appList.add(app2);
		Appointment app3 = new Appointment(p1, LocalDate.of(2020, 12, 12), LocalTime.of(13, 00, 00));
		Appointment app4 = new Appointment(p2, LocalDate.of(2020, 12, 12), LocalTime.of(13, 00, 00));
		ArrayList<Appointment> appList2 = new ArrayList<Appointment>();
		appList2.add(app3);
		appList2.add(app4);
		
		Doctor d1 = new Doctor(1010, "Junayd", "Bevan", "111-222-3333", "AAA@gmail.com", "Specialty1", appList);
		Doctor d2 = new Doctor(1020, "Darryl", "Humphries", "110-222-3333", "BBB@gmail.com", "Specialty2", appList2);
		Doctor d3 = new Doctor(1030, "Kaylen", "Carrillo", "111-111-3333", "CCC@gmail.com", "Specialty3", appList);
		Doctor d4 = new Doctor(1040, "Jadon", "Glover", "111-999-3333", "DDD@gmail.com", "Specialty4", appList2);
		users.add(d1);
		users.add(d2);
		users.add(d3);
		users.add(d4);
		
		//Then Class sort in users ArrayList to sort the users by last name and print the users.
		Collections.sort(users, new UserSorter.CompareByLastName());
		System.out.println("Printing Users after sorting");
		for(User s : users) {
			System.out.println(s);
		}
		System.out.println("\n");
		//Then Ask for id . 
		Scanner input = new Scanner(System.in); //Scanner class cleate
		System.out.println("Please enter your ID.");
		int Id = input.nextInt();
		//Check the object that has this id
		User u = checkId(Id, users);
		if (!u.equals(null)) {
			if(u instanceof Doctor) {   //If it is Doctor  ———————-> print the appointments of doctor sorted by date
				System.out.println("Doctor is using.");
				Doctor d = (Doctor)u;
				Collections.sort(d.getAppointment());
				for(Appointment a : d.getAppointment()) {
					System.out.println(a);
				}
			} else if(u instanceof Patient){  //If it is Patient ———————> Do what ever you did in last exercise
				System.out.println("Patient is using.");
				System.out.println("Pleare enter the time and date");
				System.out.print("Year : ");
				int year = input.nextInt();
				System.out.print("Month : ");
				int month = input.nextInt();
				System.out.print("Day : ");
				int day = input.nextInt();
				System.out.print("time : ");
				int time = input.nextInt();
				System.out.print("minutes : ");
				int min = input.nextInt();
				
				LocalDate appointDay = LocalDate.of(year, month, day);
				LocalTime appointTime = LocalTime.of(time, min, 00);
				Patient p = (Patient)u;
				Appointment patientApp = new Appointment(p, appointDay, appointTime);
				
				int doctorId;
				User d; //create Doctor
				while(true){
					System.out.println("Please enter your doctor ID.");
					doctorId = input.nextInt();
					d = checkId(doctorId, users);
					if (!d.equals(null)) {
						if(d instanceof Doctor) break;// Check the Doctor ID
					} 
				}
				Doctor doc = (Doctor)d;
				doc.getAppointment().add(patientApp); //add the Appointment
				
//				System.out.println(d.getAppointment()); //test
				
				//Sysout the detail of appointment
				System.out.println("Your appointment : " + appointDay + " " + appointTime +
						"\nName : " + p.getFirstName() + " " + p.getLastName() +
						"\nDoctor name : " + d.getFirstName() + " " + d.getLastName()); 
			}else {
				System.err.println("It's incorrect user.");
			}
			
		}
		
	}
}
