create database high_school;
use high_school;
DROP TABLE IF EXISTS course_schedule
;
DROP TABLE IF EXISTS schedule_time
;
DROP TABLE IF EXISTS student_course
;
DROP TABLE IF EXISTS teacher_course
;
DROP TABLE IF EXISTS course
;
DROP TABLE IF EXISTS teacher
;
DROP TABLE IF EXISTS student
;

CREATE TABLE course_schedule
(
	fk_course SMALLINT UNSIGNED NOT NULL,
	fk_stime SMALLINT UNSIGNED NOT NULL,
	yearCS year UNSIGNED NOT NULL,
	PRIMARY KEY (fk_course, fk_stime, yearCS)
	
) 
;


CREATE TABLE schedule_time
(
	k_stime SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
	day VARCHAR(9) NOT NULL,
	start_time TIME NOT NULL,
	end_time TIME NOT NULL,
	PRIMARY KEY (k_stime),
	CONSTRAINT check_day CHECK (day IN ('monday', 'tuesday', 'wednesady','thursday','friday','saturday'))
) 
;


CREATE TABLE student_course
(
	fk_student INTEGER UNSIGNED NOT NULL,
	fk_course SMALLINT UNSIGNED NOT NULL,
	note1 NUMERIC(2,1) UNSIGNED,
	note2 NUMERIC(2,1) UNSIGNED,
	note3 NUMERIC(2,1) UNSIGNED,
	final_note NUMERIC(2,1) UNSIGNED,
	yearC YEAR UNSIGNED NOT NULL,
	PRIMARY KEY (fk_student, fk_course, yearC)
	
) 
;

CREATE TABLE teacher_course
(
	fk_teacher INTEGER UNSIGNED NOT NULL,
	fk_course SMALLINT UNSIGNED NOT NULL,
	group_Course TINYINT NOT NULL,
	yearTC YEAR UNSIGNED NOT NULL,
	PRIMARY KEY (fk_teacher, fk_course, yearTC)
	
) 
;

CREATE TABLE course
(
	k_course SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
	name_course VARCHAR(15) NOT NULL,
	h_week TINYINT NOT NULL,
	state_course VARCHAR(8) NOT NULL,
	PRIMARY KEY (k_course) )
;


CREATE TABLE teacher
(
	k_teacher INTEGER UNSIGNED NOT NULL,
	name_teacher VARCHAR(10) NOT NULL,
	lname_teacher VARCHAR(10) NOT NULL,
	d_birth DATE NOT NULL,
	PRIMARY KEY (k_teacher)
) 
;


CREATE TABLE student
(
	k_register INTEGER UNSIGNED NOT NULL,
	name_student VARCHAR(10) NOT NULL,
	lname_student VARCHAR(10) NOT NULL,
	d_birth DATE NOT NULL,
	PRIMARY KEY (k_register)
) 
;


ALTER TABLE course_schedule ADD CONSTRAINT FK_course_schedule_course 
	FOREIGN KEY (fk_course) REFERENCES course (k_course)
;


ALTER TABLE course_schedule ADD CONSTRAINT FK_course_schedule_schedule_time 
	FOREIGN KEY (fk_stime) REFERENCES schedule_time (k_stime)
;

ALTER TABLE student_course ADD CONSTRAINT FK_student_course_course 
	FOREIGN KEY (fk_course) REFERENCES course (k_course)
;

ALTER TABLE student_course ADD CONSTRAINT FK_student_course_student 
	FOREIGN KEY (fk_student) REFERENCES student (k_register)
;

ALTER TABLE teacher_course ADD CONSTRAINT FK_teacher_course_course 
	FOREIGN KEY (fk_course) REFERENCES course (k_course)
;

ALTER TABLE teacher_course ADD CONSTRAINT FK_teacher_course_student 
	FOREIGN KEY (fk_teacher) REFERENCES teacher(k_teacher)
;



insert into student values (123456789, 'Brandon', 'Torres', '1993-06-08'),
(113456789, 'Jaime', 'Ramirez', '1993-02-01'),
(103456789, 'Pedro', 'Lopez', '1993-03-014'),
(133456789, 'Juana', 'Hernandez', '1994-06-07'),
(143456789, 'Lina', 'Sanchez', '1993-05-05'),
(153456789, 'Sofia', 'Gutierrez', '1997-06-03'),
(163456789, 'Andres', 'Arevalo', '1993-06-09'),
(173456789, 'Dario', 'Cruz', '1993-02-08'),
(183456789, 'Nicolas', 'Vanegas', '1991-06-09'),
(193456789, 'Maria', 'Chang', '1993-05-06'),
(110456789, 'Victoria', 'Sanabria', '1992-06-11'),
(121456789, 'Catalina', 'Florez', '1992-06-12'),
(122456789, 'Nicole', 'Toro', '1993-05-03'),
(124456789, 'Santiago', 'Rojas', '1993-04-12'),
(125456789, 'Kevin', 'Chaparro', '1993-02-18');

insert into teacher values (10123456, 'Gloria', 'Sepulveda', '1973-06-08'),
(20123456, 'Humberto', 'Garzon', '1963-06-08'),
(30123456, 'Sonia', 'Puerto', '1983-06-08');

insert into course (name_course, h_week, state_course) values ('Programacion I', 6, 'Active'),
('Caluculo I', 4, 'Active'),
('Fisica I', 4, 'Active');


insert into student_course values (123456789, 1, 5, 4.1, 4.2, 4.3, 2014),
(113456789, 1, 3, 4.1, 4.2, 4.3, 2014),
(103456789, 1, 2, 4.1, 4.2, 2.3, 2014),
(133456789, 1, 5, 4.1, 4.2, 4.3, 2014),
(143456789, 1, 3, 4.1, 4.2, 3.3, 2014),
(153456789,1, 2.3, 4.1, 4.2, 2.1, 2014),
(163456789,1, 1.4, 4.1, 4.2, 4.4, 2014),
(173456789, 1, 1.8, 4.1, 4.2, 4.5, 2014),
(183456789, 1, 2.4, 4.1, 4.2, 4.6, 2014),
(193456789, 1, 3.7, 4.1, 4.2, 4.7, 2014);

insert into student_course values 

(153456789,2, 2.3, 4.1, 4.2, 2.1, 2014),
(163456789,2, 1.4, 4.7, 4.4, 4.4, 2014),
(173456789, 2, 1.2, 4.6, 4.2, 4.5, 2014),
(183456789, 2, 2.4, 4.6, 4.5, 4.6, 2014),
(193456789, 2, 3.7, 4.5, 4.2, 4.7, 2014),
(110456789, 2, 2.3, 4.4, 4.6, 3.0, 2014),
(121456789, 2, 2.4, 4.3, 4.2, 2.1, 2014),
(122456789, 2, 2.5, 4.2, 3.2, 4.1, 2014),
(124456789, 2, 2.6, 4.1, 2.2, 2.1, 2014),
(125456789, 2, 2.7, 4.0, 1.2, 1.3, 2014);

insert into student_course values 
(123456789, 3, 5, 4.1, 4.2, 3.3, 2014),
(113456789, 3, 3, 3.1, 4.2, 4.3, 2014),
(103456789, 3, 2, 2.1, 4.2, 2.3, 2014),
(133456789, 3, 5, 1.1, 4.2, 1.3, 2014),
(143456789, 3, 3, 4.1, 4.2, 3.3, 2014),
(110456789, 3, 2.3, 3.4, 4.6, 2.0, 2014),
(121456789, 3, 2.4, 2.3, 4.2, 3.1, 2014),
(122456789, 3, 2.5, 4.2, 3.2, 3.1, 2014),
(124456789, 3, 2.6, 4.1, 2.2, 2.1, 2014),
(125456789, 3, 2.7, 4.0, 1.2, 1.3, 2014);

insert into teacher_course values 
(10123456, 1, 1, 2014),
(20123456, 2, 1, 2014),
(30123456, 3, 1, 2014);


insert into schedule_time (day, start_time, end_time)
values('monday','06:00:00','08:00:00' ),
('tuesday','08:00:00','10:00:00' ),
('wednesday','06:00:00','08:00:00' ),
('monday','08:00:00','10:00:00' ),
('friday','06:00:00','08:00:00' ),
('monday','10:00:00','12:00:00' );

insert into course_schedule values(1,1, 2014), (1,2,2014), (1,3,2014), (2,4,2014), (2,2,2014), (3, 6,2014), (3,5,2014);

--List students and teachers for a given course.
select  c.name_course as course, concat(t.lname_teacher,' ', t.name_teacher) as teacher, concat(s.lname_student,' ',name_student) as student from student  s
left join student_course  sc on sc.fk_student=s.k_register
left join course c on c.k_course = sc.fk_course
left join teacher_course tc on c.k_course = tc.fk_course
left join teacher t on t.k_teacher = tc.fk_teacher
where c.name_course ='Fisica I'  order by s.lname_student;



--Percentage of students that passed/failed a given course.
use high_school;
set @idCurso =3;
select  count(fk_student) as 'Student Passed', 
 (select  count(fk_student)   from student_course  sc where sc.fk_course =@idCurso and sc.final_note >=3)*100 / (select  count(fk_student)  from student_course  sc where sc.fk_course =@idCurso)  as '% Students Passed',
 (select  count(fk_student)   from  student_course  sc where sc.fk_course =@idCurso and sc.final_note <3 )  as 'Students Failed', 
 (select  count(fk_student)   from student_course  sc where sc.fk_course =@idCurso and sc.final_note <3)*100 / (select  count(fk_student)  from student_course  sc where sc.fk_course =@idCurso)  as '% Students Failed'
 from student_course  sc where sc.fk_course =@idCurso and   sc.final_note >=3 ;
 

 -- With the name and last name of teacher, returns the schedule 
 use high_school;
set @teacherName ='Sepulveda';
set @nameTeacher ='Gloria';
select t.lname_teacher, t.name_teacher, st.day, st.start_time, st.end_time  from teacher t
left join teacher_course tc on tc.fk_teacher = t.k_teacher  
left join course c on c.k_course = tc.fk_course 
left join course_schedule cs on cs.fk_course = c.k_course
left join schedule_time st on st.k_stime = cs.fk_stime 
where t.lname_teacher=@teacherName and t.name_teacher=@nameTeacher
ORDER BY FIELD(day, 'monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday');




