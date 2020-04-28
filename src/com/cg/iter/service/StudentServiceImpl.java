package com.cg.iter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.iter.bean.Student;
import com.cg.iter.dao.StudentDao;
@Component
public class StudentServiceImpl implements StudentService {
	@Autowired
    private StudentDao studDao;
	public StudentServiceImpl() {
		System.out.println("stud service constr");
	}
	@Override
	public boolean create(Student stud) {
		return studDao.create(stud);
	}
	@Override
	public Student findStudentById(int nextInt) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Student findStudentByName(String next) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean deleteStudent(int nextInt) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean updateStudent(Student stud) {
		// TODO Auto-generated method stub
		return false;
	}
	
   
}
