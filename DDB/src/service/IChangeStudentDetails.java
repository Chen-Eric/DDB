package service;

import javax.jws.WebService;

import formulare.Student;

@WebService
public interface IChangeStudentDetails {
	Student changeName(Student student);
}
