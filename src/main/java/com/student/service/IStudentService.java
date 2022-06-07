package com.student.service;
import java.util.List;
import java.util.Optional;

import com.student.entity.StudentEntity;

public interface IStudentService {
	Integer saveStudent(StudentEntity student);
	
	Optional<StudentEntity> getStudent(Integer id);
	
	public List<StudentEntity> getAllStudents();
	
	public void deleteStudent( Integer id);

	Integer updateStudent(StudentEntity student, Integer id);
}
