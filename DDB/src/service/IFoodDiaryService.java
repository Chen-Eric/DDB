/**
 * 
 */
package service;

import java.sql.Timestamp;
import java.util.List;

import domain.FoodDiary;

/**
 * @author Chen
 *
 */
public interface IFoodDiaryService {
	
	public List<FoodDiary> listUserDiary(int userID);
	
	public List<FoodDiary> listSubjectDiaries(int subjectID);
	
	public List<FoodDiary> listSubjectDiariesByPage(int subjectID, int page, int pageSize);
	
	public void addFoodDiary(int subjectID, String name, String note, int accuracyID, Timestamp starttime, Timestamp endtime);
	
	public void updateFoodDiary(int id, int subjectID, String name, String note, int accuracyID, Timestamp starttime, Timestamp endtime);
	
	public void deleteFoodDiary(int subjectID, int fdID);
}
