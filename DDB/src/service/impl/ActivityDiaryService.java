package service.impl;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import dao.impl.ActivityDiaryDAO;
import domain.ActivityDiary;
import domain.ActivityDiaryId;
import service.IActivityDiaryService;

public class ActivityDiaryService implements IActivityDiaryService {

	private ActivityDiaryDAO activityDiaryDAO;
	
	public ActivityDiaryDAO getActivityDiaryDAO() {
		return activityDiaryDAO;
	}

	public void setActivityDiaryDAO(ActivityDiaryDAO activityDiaryDAO) {
		this.activityDiaryDAO = activityDiaryDAO;
	}

	@Override
	public List<ActivityDiary> showUserDiary(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActivityDiary> listSubjectDiaries(int subjectID) {
		return this.activityDiaryDAO.listActivityDiariesBySubjectID(subjectID);
	}
	
	@Override
	public List<ActivityDiary> listSubjectDiariesByPage(int subjectID,
			int page, int pageSize) {
		List<ActivityDiary> lad = activityDiaryDAO.findByPage(subjectID, page, pageSize);
		
		return lad;
	}

	@Override
	public void addActivityDiary(int subjectID, int accuracyID, String name, Timestamp starttime, Timestamp endtime, String note) {
		ActivityDiaryId adid = new ActivityDiaryId();
		adid.setSubjectId(subjectID);
		ActivityDiary activityDiary = new ActivityDiary();
		activityDiary.setId(adid);
		activityDiary.setName(name);
		activityDiary.setStarttime(starttime);
		activityDiary.setEndtime(endtime);
		activityDiary.setAccuracyId(accuracyID);
		activityDiary.setNote(note);
		activityDiary.setAddtime(new Timestamp(System.currentTimeMillis()));
		
		activityDiaryDAO.save(activityDiary);
	}

	@Override
	public void deleteActivityDiary(int subjectID, int adID) {
		ActivityDiaryId adid = new ActivityDiaryId();
		adid.setSubjectId(subjectID);
		adid.setId(adID);
		
		activityDiaryDAO.delete(activityDiaryDAO.findById(adid));
	}

	@Override
	public void updateActivityDiary(int id, int subjectID, int accuracyID, String name, Timestamp starttime, Timestamp endtime, String note) {
		ActivityDiaryId adid = new ActivityDiaryId();
		adid.setSubjectId(subjectID);
		adid.setId(id);
		
		ActivityDiary activityDiary = activityDiaryDAO.findById(adid);
		activityDiary.setId(adid);
		activityDiary.setName(name);
		activityDiary.setStarttime(starttime);
		activityDiary.setEndtime(endtime);
		activityDiary.setAccuracyId(accuracyID);
		activityDiary.setNote(note);
		
		activityDiaryDAO.getHibernateTemplate().update(activityDiary);
	}


}
