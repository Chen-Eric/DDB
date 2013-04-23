package service.impl;

import java.util.List;

import dao.impl.FoodDAO;
import domain.Food;
import domain.FoodId;
import service.IFoodService;

public class FoodService implements IFoodService {

	private FoodDAO foodDAO;
	
	public FoodDAO getFoodDAO() {
		return foodDAO;
	}

	public void setFoodDAO(FoodDAO foodDAO) {
		this.foodDAO = foodDAO;
	}

	@Override
	public List<Food> listMealAllFood(int subjectID, int fdID, int mealID) {
		return foodDAO.findByID(subjectID, fdID, mealID);
	}

	@Override
	public List<Food> listMealFoodByPage(int subjectID, int fdID, int mealID, int page, int pageSize) {
		return foodDAO.findByPage(subjectID, fdID, mealID, page, pageSize);
	}

	@Override
	public void addFoodForMeal(int subjectID, int fdID, int mealID, int fcdbFoodID, String foodChapter, String foodDescription, String recipe, String amount, String amountUnit,
			boolean hasIngredients) {
		
		FoodId foodId = new FoodId();
		foodId.setMealId(mealID);
		foodId.setMealFoodDiarySubjectId(subjectID);
		foodId.setMealFoodDiaryId(fdID);
		
		
		Food food = new Food();
		food.setId(foodId);
		food.setFcdbFoodId(fcdbFoodID);
		food.setFcdbFoodChapter(foodChapter);
		food.setFcdbFoodDescription(foodDescription);
		food.setRecipe(recipe);
		food.setAmount(amount);
		food.setAmountUnit(amountUnit);
		food.setHasIngredients(false);
		
		foodDAO.save(food);
		
	}

	@Override
	public void deleteMealFood(int id, int subjectID, int fdID, int mealID) {
		
		FoodId foodId = new FoodId();
		foodId.setId(id);
		foodId.setMealFoodDiarySubjectId(subjectID);
		foodId.setMealFoodDiaryId(fdID);
		foodId.setMealId(mealID);
		
		foodDAO.delete(foodDAO.findById(foodId));
		
	}

	@Override
	public void editFoodForMeal(int id, int subjectID, int fdID, int mealID, int fcdbFoodID, String foodChapter, String foodDescription,String recipe,
			String amount, String amountUnit, boolean hasIngredients) {
		FoodId foodId = new FoodId();
		foodId.setMealFoodDiarySubjectId(subjectID);
		foodId.setMealFoodDiaryId(fdID);
		foodId.setMealId(mealID);
		foodId.setId(id);
		
		Food food = foodDAO.findById(foodId);
		food.setId(foodId);
		food.setFcdbFoodId(fcdbFoodID);
		food.setRecipe(recipe);
		food.setAmount(amount);
		food.setAmountUnit(amountUnit);
		food.setHasIngredients(false);
		
		foodDAO.getHibernateTemplate().update(food);
		
	}

}
