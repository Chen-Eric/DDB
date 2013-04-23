package service;

import java.util.List;

import domain.Food;

public interface IFoodService {

	public List<Food> listMealAllFood(int subjectID, int fdID, int mealID);

	public List<Food> listMealFoodByPage(int subjectID, int fdID, int mealID, int page, int pageSize);

	public void addFoodForMeal(int subjectID, int fdID, int mealID, int fcdbFoodID, String fcdbFoodChapter, String fcdbFoodDescription, String recipe, String amount, String amountUnit, boolean hasIngredients);
	
	public void editFoodForMeal(int id, int subjectID, int fdID, int mealID, int fcdbFoodID, String fcdbFoodChapter, String fcdbFoodDescription, String recipe, String amount, String amountUnit, boolean hasIngredients);

	public void deleteMealFood(int id, int subjectID, int fdID, int mealID);
	
}
