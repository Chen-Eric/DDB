package service.impl;

import java.sql.Timestamp;
import java.util.List;

import dao.impl.MealDAO;
import domain.Meal;
import domain.MealId;
import service.IMealService;

public class MealService implements IMealService {

	private MealDAO mealDAO;
	
	public MealDAO getMealDAO() {
		return mealDAO;
	}

	public void setMealDAO(MealDAO mealDAO) {
		this.mealDAO = mealDAO;
	}

	@Override
	public List<Meal> listAllFDMeals(int subjectID, int fdID) {
		return mealDAO.findByID(subjectID, fdID);
	}

	@Override
	public List<Meal> listFDMealsByPage(int subjectID, int fdID, int page, int pageSize) {
		return mealDAO.findByPage(subjectID, fdID, page, pageSize);
	}

	@Override
	public void addMealforFD(int subjectID, int fdID, String name, String info, int accuracyID) {
		
		MealId mealId = new MealId();
		mealId.setFoodDiarySubjectId(subjectID);
		mealId.setFoodDiaryId(fdID);
		
		Meal meal = new Meal();
		meal.setId(mealId);
		meal.setAccuracyId(accuracyID);
		meal.setAddtime(new Timestamp(System.currentTimeMillis()));
		meal.setName(name);
		meal.setInfo(info);
		
		mealDAO.save(meal);

	}

	@Override
	public void deleteFDMeal(int id, int subjectID, int fdID) {
		MealId mealId = new MealId();
		mealId.setFoodDiarySubjectId(subjectID);
		mealId.setFoodDiaryId(fdID);
		mealId.setId(id);
		
		mealDAO.delete(mealDAO.findById(mealId));
	}

	@Override
	public void updateMeal(int id, int subjectID, int fdID, String name, String info, int accuracyID) {
		MealId mealId = new MealId();
		mealId.setFoodDiarySubjectId(subjectID);
		mealId.setFoodDiaryId(fdID);
		mealId.setId(id);
		
		Meal meal = mealDAO.findById(mealId);
		meal.setAccuracyId(accuracyID);
		meal.setName(name);
		meal.setInfo(info);
		
		mealDAO.getHibernateTemplate().update(meal);
	}

}
