package action;

import java.text.SimpleDateFormat;
import java.util.List;

import domain.Food;

public class FoodAction extends BaseAction {

	/**
	 * @serial auto
	 */
	private static final long serialVersionUID = 3648584632468520227L;
	private int subjectID;
	private int fdID;
	private int mealID;
	private String id; // the id of food in DDB, for delete operation.

	private int fcdbFoodId; // food id from MONDB.
	private String fcdbFoodChapter;
	private String fcdbFoodDescription;
	private String recipe;
	private String amount; // the name of activity, comes from MONDB.
	private String amountUnit;
	private boolean hasIngredient;
	private int accuracyId;

	// For Struts2-jquery-Gridtag
	private List<Food> MealFoodGridModel;
	private int rows; // Get how many rows we want to have into the grid - rowNum attribute in the grid
	private int page; // Get the requested page. By default grid sets this to 1.
	private int total; // Totally how many page.
	private int records; // All record;
	private String sord; // Sorting order ? asc or desc.
	private String sidx; // Get index row which user cliked to sort.
	private String searchField; // The searching string.
	private String searchOperation; // The Search Operation
									// ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
	private String oper; // indicator of add/edit/delete operations.

	public String showMealFood() {

		System.out.println("SelectedSubjectID:" + subjectID);

		this.records = foodService.listMealAllFood(subjectID, fdID, mealID).size();
		this.total = (int) Math.ceil((double) records / (double) rows);
		this.MealFoodGridModel = foodService.listMealFoodByPage(subjectID, fdID, mealID, page, rows);

		System.out.println("Page:" + this.page);
		System.out.println("Rows:" + this.rows);
		System.out.println("Totally how many pages:" + this.total);
		System.out.println("MealID:" + mealID + " has How many Food:" + this.records);

		return SUCCESS;
	}

	public void editMealFood() {
		System.out.println("Food_Operation:" + oper);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		switch (oper) {
		case "add":
			System.out.println("fcdbFoodId:" + fcdbFoodId);
			System.out.println("MealID:" + mealID);

			foodService.addFoodForMeal(subjectID, fdID, mealID, fcdbFoodId, fcdbFoodChapter,
					fcdbFoodDescription, recipe, amount, amountUnit, false);

			break;
		case "edit":
			foodService.editFoodForMeal(Integer.parseInt(id), subjectID, fdID, mealID, fcdbFoodId,
					fcdbFoodChapter, fcdbFoodDescription, recipe, amount, amountUnit, false);
			break;
		case "del":
			foodService.deleteMealFood(Integer.parseInt(id), subjectID, fdID, mealID);
			break;
		}
	}

	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public int getFdID() {
		return fdID;
	}

	public void setFdID(int fdID) {
		this.fdID = fdID;
	}

	public int getMealID() {
		return mealID;
	}

	public void setMealID(int mealID) {
		this.mealID = mealID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getFcdbFoodId() {
		return fcdbFoodId;
	}

	public void setFcdbFoodId(int fcdbFoodId) {
		this.fcdbFoodId = fcdbFoodId;
	}

	public String getFcdbFoodChapter() {
		return fcdbFoodChapter;
	}

	public void setFcdbFoodChapter(String fcdbFoodChapter) {
		this.fcdbFoodChapter = fcdbFoodChapter;
	}

	public String getFcdbFoodDescription() {
		return fcdbFoodDescription;
	}

	public void setFcdbFoodDescription(String fcdbFoodDescription) {
		this.fcdbFoodDescription = fcdbFoodDescription;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAmountUnit() {
		return amountUnit;
	}

	public void setAmountUnit(String amountUnit) {
		this.amountUnit = amountUnit;
	}

	public boolean isHasIngredient() {
		return hasIngredient;
	}

	public void setHasIngredient(boolean hasIngredient) {
		this.hasIngredient = hasIngredient;
	}

	public int getAccuracyId() {
		return accuracyId;
	}

	public void setAccuracyId(int accuracyId) {
		this.accuracyId = accuracyId;
	}

	public List<Food> getMealFoodGridModel() {
		return MealFoodGridModel;
	}

	public void setMealFoodGridModel(List<Food> mealFoodGridModel) {
		MealFoodGridModel = mealFoodGridModel;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchOperation() {
		return searchOperation;
	}

	public void setSearchOperation(String searchOperation) {
		this.searchOperation = searchOperation;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

}
