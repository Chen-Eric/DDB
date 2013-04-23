/**
 * 
 */
package service.impl;

import java.sql.Timestamp;
import java.util.List;

import dao.impl.ActivityDAO;
import domain.Activity;
import domain.ActivityId;
import service.IActivityService;

/**
 * @author Chen
 * 
 */
public class ActivityService implements IActivityService {

	private ActivityDAO activityDAO;

	public ActivityDAO getActivityDAO() {
		return activityDAO;
	}

	public void setActivityDAO(ActivityDAO activityDAO) {
		this.activityDAO = activityDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IActivityService#listAllActivities(int, int)
	 */
	@Override
	public List<Activity> listADAllActivities(int subjectID, int adID) {
		return activityDAO.findByID(subjectID, adID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IActivityService#listADActivitiesByPage(int, int, int, int)
	 */
	@Override
	public List<Activity> listADActivitiesByPage(int subjectID, int adID, int page, int pageSize) {
		return activityDAO.findByPage(subjectID, adID, page, pageSize);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IActivityService#addActivityForAD(int, int, java.lang.String, java.lang.String, java.lang.String, java.sql.Timestamp, java.sql.Timestamp, java.sql.Timestamp, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void addActivityForAD(int subjectID, int adID, int cpadbActivityID, String majorHeading, String specificActivity, String duration, Timestamp starttime,
			Timestamp endtime, Timestamp realtime, String note, int accuracyID) {
		ActivityId aid = new ActivityId();
		aid.setActivityDiaryId(adID);
		aid.setActivityDiarySubjectId(subjectID);

		Activity activity = new Activity();
		activity.setId(aid);
		activity.setCpadbActivityId(cpadbActivityID);
		activity.setMajorHeading(majorHeading);
		activity.setSpecificActivity(specificActivity);
		activity.setAccuracyId(accuracyID);
		activity.setStarttime(starttime);
		activity.setEndtime(endtime);
		activity.setDuration(duration);
		activity.setRealtime(realtime);
		activity.setNote(note);
		activity.setAddtime(new Timestamp(System.currentTimeMillis()));

		activityDAO.save(activity);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IActivityService#deleteADActivity(int, int)
	 */
	@Override
	public void deleteADActivity(int id, int subjectID, int adID) {
		ActivityId aid = new ActivityId(id, adID, subjectID);
		activityDAO.delete(activityDAO.findById(aid));
	}

	@Override
	public void updateActivity(int id, int subjectID, int adID, int cpadbActivityID, String majorHeading, String specificActivity, String duration, Timestamp starttime,
			Timestamp endtime, Timestamp realtime, String note, int accuracyID) {
		ActivityId aid = new ActivityId();
		aid.setActivityDiaryId(adID);
		aid.setActivityDiarySubjectId(subjectID);
		aid.setId(id);

		Activity activity = activityDAO.findById(aid);
		activity.setCpadbActivityId(cpadbActivityID);
		activity.setMajorHeading(majorHeading);
		activity.setSpecificActivity(specificActivity);
		activity.setAccuracyId(accuracyID);
		activity.setStarttime(starttime);
		activity.setEndtime(endtime);
		activity.setDuration(duration);
		activity.setRealtime(realtime);
		activity.setNote(note);

		activityDAO.getHibernateTemplate().update(activity);
	}

}
