package service;

import java.util.Date;
import java.util.List;

import domain.Subject;

public interface ISubjectService {
	
	public List<Subject> listSubjectsByUser(int userID);
	
	public List<Subject> listSubjectsByUserAndPage(int userID, int page, int pageSize);
	
	public void addSubject(int userID, String referenceID, String surename, String familyname, Date dob, String gender, float height, float weight, String email, String phone, String mobile, String special);
	
	public void updateSubject(int id, int userID, String referenceID, String surename, String familyname, Date dob, String gender, float height, float weight, String email, String phone, String mobile, String special);
	
	public void deleteSubject(int userID, int subjectID);
	
}
