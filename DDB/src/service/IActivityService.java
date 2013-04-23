/**
 * 
 */
package service;

import java.sql.Timestamp;
import java.util.List;

import domain.Activity;

/**
 * @author Chen
 *
 */
public interface IActivityService {
	
	public List<Activity> listADAllActivities(int subjectID, int adID);
	
	public List<Activity> listADActivitiesByPage(int subjectID, int adID, int page, int pageSize);
	
	public void addActivityForAD(int subjectID, int adID, int cpadbActivityID, String type, String specificActivity, String duration, Timestamp starttime, Timestamp endtime, Timestamp realtime, String note, int accuracyID);
	
	public void updateActivity(int id, int subjectID, int adID, int cpadbActivityID, String majorHeading, String specificActivity, String duration, Timestamp starttime, Timestamp endtime, Timestamp realtime, String note, int accuracyID);
	
	public void deleteADActivity(int id, int subjectID, int adID);
	
}
