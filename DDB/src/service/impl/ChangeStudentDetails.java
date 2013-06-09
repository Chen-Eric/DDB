package service.impl;

import formulare.Student;
import service.IChangeStudentDetails;

public class ChangeStudentDetails implements IChangeStudentDetails {

	@Override
	public Student changeName(Student student) {
		student.setName("Hello " + student.getName());
		return null;
	}

}
