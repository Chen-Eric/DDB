package service;

import java.util.List;

import domain.Meal;

public interface IMealService {
	
	public List<Meal> listAllFDMeals(int subjectID, int fdID);
	
	public List<Meal> listFDMealsByPage(int subjectID, int fdID, int page, int pageSize);
	
	public void addMealforFD(int subjectID, int fdID, String name, String info, int accuracyID);
	
	public void updateMeal(int id, int subjectID, int fdID, String name, String info, int accuracyID);
	
	public void deleteFDMeal(int mealID, int subjectID, int fdID);
	
}
