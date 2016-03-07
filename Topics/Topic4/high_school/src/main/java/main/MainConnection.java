package main;

import java.util.Scanner;

import business.User;
import data.ScheduleDAO;
import data.StudentDAO;
import util.ServiceLocator;

public class MainConnection {
	
	public static void main (String[]args){
		String name="", lastName="";
		User user = new User();
		user.setUser("root");
		user.setPasswd("123123");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Last name teacher");
		lastName = sc.nextLine();
		System.out.println("Name teacher");
		name = sc.nextLine();
		//Horario de un profesor
		TeachersManagement teacherManage = new TeachersManagement();
		teacherManage.showSchedule(name, lastName, user);
		
		
	}

}
