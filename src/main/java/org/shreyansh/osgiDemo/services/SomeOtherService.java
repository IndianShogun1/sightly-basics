package org.shreyansh.osgiDemo.services;

import java.util.List;
public interface SomeOtherService {
	
	public void addStudent(Student values);
	public void deleteStudent(int id);
	public boolean isStudentPassed(int id);
	public Student getStudent(int id);
	public List getStudentList();
}
