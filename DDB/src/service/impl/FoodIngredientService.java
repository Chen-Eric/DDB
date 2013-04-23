package service.impl;

import java.util.List;

import dao.impl.FoodIngredientDAO;
import domain.FoodIngredient;
import service.IFoodIngredientService;

public class FoodIngredientService implements IFoodIngredientService {

	private FoodIngredientDAO foodIngredientDAO;
	
	public FoodIngredientDAO getFoodIngredientDAO() {
		return foodIngredientDAO;
	}

	public void setFoodIngredientDAO(FoodIngredientDAO foodIngredientDAO) {
		this.foodIngredientDAO = foodIngredientDAO;
	}

	@Override
	public List<FoodIngredient> listAllFoodIngredients(int foodID, int ingredientID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodIngredient> listFoodIngredientsByPage(int foodID, int ingredientID, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFoodIngredient(int foodID, int ingredientID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFoodIngredient() {
		// TODO Auto-generated method stub

	}

}
