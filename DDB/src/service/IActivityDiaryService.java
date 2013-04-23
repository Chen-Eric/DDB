/**
 * 
 */
package service;

import java.sql.Timestamp;
import java.util.List;

import domain.ActivityDiary;

/**
 * @author Chen
 *
 */
public interface IActivityDiaryService {
	
	public List<ActivityDiary> showUserDiary(int userID);
	
	public List<ActivityDiary> listSubjectDiaries(int subjectID);
	
	public List<ActivityDiary> listSubjectDiariesByPage(int subjectID, int page, int pageSize);
	
	public void addActivityDiary(int subjectID, int accuracyID, String name, Timestamp starttime, Timestamp endtime, String note);
	
	public void updateActivityDiary(int id, int subjectID, int accuracyID, String name, Timestamp starttime, Timestamp endtime, String note);
	
	public void deleteActivityDiary(int subjectID, int adID);
	
}
