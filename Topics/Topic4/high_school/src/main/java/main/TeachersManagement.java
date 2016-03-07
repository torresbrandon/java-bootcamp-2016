package main;

import business.User;
import data.ScheduleDAO;

public class TeachersManagement {
	ScheduleDAO schedule;
	
	public TeachersManagement(){
		schedule =  new ScheduleDAO();
		
	};
	
	public void showSchedule(String name, String lastName, User user){
		schedule.scheduleConsult(lastName, name, user);
	}
	
	
}
