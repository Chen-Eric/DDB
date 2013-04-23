package service;

import java.util.List;

import domain.FoodIngredient;

public interface IFoodIngredientService {
	
	public List<FoodIngredient> listAllFoodIngredients(int foodID, int ingredientID);
	
	public List<FoodIngredient> listFoodIngredientsByPage(int foodID, int ingredientID, int page, int pageSize);
	
	public void addFoodIngredient(int foodID, int ingredientID);
	
	public void deleteFoodIngredient();
	
}
