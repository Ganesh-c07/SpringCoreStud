package com.cg.iter.service;

import com.cg.iter.bean.Student;

public interface StudentService {

	boolean create(Student stud);

	Student findStudentById(int nextInt);

	Student findStudentByName(String next);

	boolean deleteStudent(int nextInt);

	boolean updateStudent(Student stud);

	

}
