package com.cg.iter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.iter.bean.Student;
import com.cg.iter.dao.StudentDao;
import com.cg.iter.util.JpaUtil;
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
	public Student findStudentById(int id) {
		System.out.println("find");
		return studDao.findStudentById(id);
	}
	@Override
	public Student findStudentByName(String name) {
		// TODO Auto-generated method stub
		return studDao.findStudentByName(name);
	}
	@Override
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		return studDao.deleteStudent(id);
	}
	@Override
	public boolean updateStudent(Student stud) {
		// TODO Auto-generated method stub
		return studDao.updateStudent(stud);
	}
	@Override
	public void close() {
		JpaUtil.close();
		
	}
	
   
}
