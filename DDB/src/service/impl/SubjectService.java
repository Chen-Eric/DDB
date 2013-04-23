package service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.impl.SubjectDAO;
import dao.impl.UserSubjectDAO;
import domain.Subject;
import domain.UserSubject;
import domain.UserSubjectId;

import service.ISubjectService;

public class SubjectService implements ISubjectService {

	private SubjectDAO subjectDAO;
	private UserSubjectDAO usDAO;
	

	@Override
	public List<Subject> listSubjectsByUser(int userID) {

		UserSubjectId usID = new UserSubjectId();
		usID.setUserId(userID);	

		List<UserSubject> lus = usDAO.findUserSubjectsByUserID(usID);
		
		List<Subject> ls = new ArrayList<Subject>();
			
		for (UserSubject us : lus) {
			ls.add(subjectDAO.findById(us.getId().getSubjectId()));
		}
		
		return ls;
	}
	
	@Override
	public List<Subject> listSubjectsByUserAndPage(int userID, int page,
			int pageSize) {
		
		UserSubjectId usID = new UserSubjectId();
		usID.setUserId(userID);	

		List<UserSubject> lus = usDAO.findByPage(userID, page, pageSize);
		
		List<Subject> ls = new ArrayList<Subject>();
			
		for (UserSubject us : lus) {
			ls.add(subjectDAO.findById(us.getId().getSubjectId()));
		}
		
		return ls;
	}

	@Override
	public void addSubject(int userID, String referenceID, String surename, String familyname, Date dob,
			String gender, float height, float weight, String email, String phone,
			String mobile, String special) {
		Subject subject = new Subject();
		subject.setReferenceID(referenceID);
		subject.setSureName(surename);
		subject.setFamilyName(familyname);
		subject.setDob(dob);
		subject.setGender(gender);
		subject.setPhone(phone);
		subject.setMobile(mobile);
		subject.setHeight(height);
		subject.setWeight(weight);
		subject.setSpecial(special);
		Timestamp initialTime = new Timestamp(System.currentTimeMillis());
		subject.setAddtime(initialTime);
//		subject.setLastupdate(initialTime);
		
		subjectDAO.save(subject);
		
		System.out.println(subject.getId());
		
		UserSubjectId usid = new UserSubjectId();
		usid.setUserId(userID);
		usid.setSubjectId(subject.getId());
		
		UserSubject us = new UserSubject();
		us.setId(usid);
		us.setCreateTime(new Timestamp(System.currentTimeMillis()));
		
		usDAO.save(us);
	}
	
	@Override
	public void updateSubject(int id, int userID, String referenceID, String surename, String familyname, Date dob, String gender, float height,
			float weight, String email, String phone, String mobile, String special) {
		Subject subject = subjectDAO.findById(id);
		System.out.println("SubjectService_SubjectID:" + subject.getId());
		subject.setReferenceID(referenceID);
		subject.setSureName(surename);
		subject.setFamilyName(familyname);
		subject.setDob(dob);
		subject.setGender(gender);
		subject.setPhone(phone);
		subject.setMobile(mobile);
		subject.setHeight(height);
		subject.setWeight(weight);
		subject.setSpecial(special);
		subjectDAO.merge(subject);
	}

	@Override
	public void deleteSubject(int userID, int subjectID) {
		
		usDAO.delete(usDAO.findById(userID, subjectID));
		subjectDAO.delete(subjectDAO.findById(subjectID));
		
	}

	
	public SubjectDAO getSubjectDAO() {
		return subjectDAO;
	}

	public void setSubjectDAO(SubjectDAO subjectDAO) {
		this.subjectDAO = subjectDAO;
	}

	public UserSubjectDAO getUsDAO() {
		return usDAO;
	}

	public void setUsDAO(UserSubjectDAO usDAO) {
		this.usDAO = usDAO;
	}

}
