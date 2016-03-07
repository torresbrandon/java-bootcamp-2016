package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.Student;
import business.Teacher;
import business.User;
import util.ServiceLocator;

public class ScheduleDAO {
	
	Teacher teacher;

	public void scheduleConsult(String lastName, String name, User user) {
		teacher = new Teacher();
		String error = "";
		try {
			
			// Instancia el objeto para retornar los datos del empleado
			String strSQL = "select t.lname_teacher, t.name_teacher, st.day, st.start_time, st.end_time  from teacher t "
					+"left join teacher_course tc on tc.fk_teacher = t.k_teacher "  
					+"left join course c on c.k_course = tc.fk_course "
					+"left join course_schedule cs on cs.fk_course = c.k_course "
					+"left join schedule_time st on st.k_stime = cs.fk_stime "
					+ "where t.lname_teacher=? and t.name_teacher=? "
					+ "ORDER BY FIELD(day, 'monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday')";
			Connection conexion = ServiceLocator.getInstance(user).takeConnection();
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			
			prepStmt.setString(1, lastName);
			prepStmt.setString(2, name);
			ResultSet rs = prepStmt.executeQuery();
			int i =0;
			
			while (rs.next()) {
				 
				
				if(i==0){
				teacher.setLast_name(rs.getString(1));
				teacher.setName(rs.getString(2));
				System.out.println("Last Name: "+ teacher.getLast_name());
				System.out.println("Name: "+ teacher.getName());
				System.out.println("-------------Schedule ------------ ");
				}
				
				String day=rs.getString(3);
				String begin_time=rs.getString(4);
				String end_time=rs.getString(5);
				
				
				System.out.println("      "+day+" "+begin_time+"-"+end_time );
				
				
				
				i=i+1;
			}
			
			prepStmt.close();
			ServiceLocator.getInstance(user).commit();

		} catch (SQLException e) {
			error = "Schedule DAO " + "Consult schedule " + e.getMessage();

		} finally {
			ServiceLocator.getInstance(user).breakFreeConnection();
		}

	}

}
