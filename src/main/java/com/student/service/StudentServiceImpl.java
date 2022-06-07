package com.student.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.StudentEntity;
import com.student.exception.ResourceNotFoundException;

@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	IStudentRepository studentRepository;
	@Override
	public Integer saveStudent(StudentEntity student) {
		StudentEntity savedStudent = studentRepository.save(student);
		return savedStudent.getId();
	}
	@Override
	public Optional<StudentEntity> getStudent(Integer id) {
		
		return studentRepository.findById(id);
	}
	@Override
	public List<StudentEntity> getAllStudents() {
		return studentRepository.findAll();
	}
	@Override
	public void deleteStudent(Integer id) {
		studentRepository.deleteById(id);
		
	}
	@Override
	public Integer updateStudent(StudentEntity student, Integer id) {
		StudentEntity existingStudent = studentRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("student", "id", id) );
		existingStudent.setFirstname(student.getFirstname());
		existingStudent.setLastname(student.getLastname());
		studentRepository.save(existingStudent);
		return existingStudent.getId();
	}
	
	

}
