/**
 * 
 */
package service.impl;

import java.sql.Timestamp;
import java.util.List;

import dao.impl.FoodDiaryDAO;
import dao.impl.SubjectDAO;
import domain.FoodDiary;
import domain.FoodDiaryId;
import service.IFoodDiaryService;

/**
 * @author Chen
 * 
 */
public class FoodDiaryService implements IFoodDiaryService {

	private FoodDiaryDAO foodDiaryDAO;

	public FoodDiaryDAO getFoodDiaryDAO() {
		return foodDiaryDAO;
	}

	public void setFoodDiaryDAO(FoodDiaryDAO foodDiaryDAO) {
		this.foodDiaryDAO = foodDiaryDAO;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IFoodDiaryService#showUserDiary(int)
	 */
	@Override
	public List<FoodDiary> listUserDiary(int userID) {
		// TODO
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IFoodDiaryService#showSubjectDiaries(int)
	 */
	@Override
	public List<FoodDiary> listSubjectDiaries(int subjectID) {
		return foodDiaryDAO.listFoodDiariesBySubjectID(subjectID);
	}
	
	@Override
	public List<FoodDiary> listSubjectDiariesByPage(int subjectID, int page,
			int pageSize) {
		List<FoodDiary> lfd = foodDiaryDAO.findByPage(subjectID, page, pageSize);
		return lfd;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IFoodDiaryService#addDiary(int, java.lang.Integer, java.sql.Timestamp, java.lang.String)
	 */
	@Override
	public void addFoodDiary(int subjectID, String name, String note, int accuracyID, Timestamp starttime, Timestamp endtime) {
		FoodDiaryId fdid = new FoodDiaryId();
		fdid.setSubjectId(subjectID);
		FoodDiary foodDiary = new FoodDiary();
		foodDiary.setId(fdid);
		foodDiary.setName(name);
		foodDiary.setStarttime(starttime);
		foodDiary.setEndtime(endtime);
		foodDiary.setAccuracyId(accuracyID);
		foodDiary.setNote(note);
		foodDiary.setAddtime(new Timestamp(System.currentTimeMillis()));
//		foodDiary.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		
		foodDiaryDAO.save(foodDiary);
	}

	@Override
	public void deleteFoodDiary(int subjectID, int fdID) {
		FoodDiaryId fdid = new FoodDiaryId();
		fdid.setSubjectId(subjectID);
		fdid.setId(fdID);
		
		foodDiaryDAO.delete(foodDiaryDAO.findById(fdid));
	}

	@Override
	public void updateFoodDiary(int id, int subjectID, String name, String note, int accuracyID, Timestamp starttime, Timestamp endtime) {
		FoodDiaryId fdid = new FoodDiaryId();
		fdid.setSubjectId(subjectID);
		fdid.setId(id);
		FoodDiary foodDiary = foodDiaryDAO.findById(fdid);
		
		foodDiary.setName(name);
		foodDiary.setNote(note);
		foodDiary.setStarttime(starttime);
		foodDiary.setEndtime(endtime);
		foodDiary.setAccuracyId(accuracyID);
		
		foodDiaryDAO.getHibernateTemplate().update(foodDiary);
	}

	
}
