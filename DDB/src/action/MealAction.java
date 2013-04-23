package action;

import java.util.List;

import domain.Meal;

public class MealAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4020781669589658455L;
	private int subjectID;
	private int fdID;
	private String id; // the id of activity in DDB, for delete operation.

	private String name;
	private String info;
	private int accuracyId;

	// For Struts2-jquery-Gridtag
	private List<Meal> FDMealGridModel;
	private int rows; // Get how many rows we want to have into the grid - rowNum attribute in the grid
	private int page; // Get the requested page. By default grid sets this to 1.
	private int total; // Totally how many page.
	private int records; // All record;
	private String sord; // Sorting order ? asc or desc.
	private String sidx; // Get index row which user cliked to sort.
	private String searchField; // The searching string.
	private String searchOperation; // The Search Operation ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
	private String oper; // indicator of add/edit/delete operations.
	
	public String showFDMeals(){
		
		System.out.println("SelectedSubjectID:" + subjectID);
		
		this.records = mealService.listAllFDMeals(subjectID, fdID).size();
		this.total = (int) Math.ceil((double)records/(double)rows);
		this.FDMealGridModel = mealService.listFDMealsByPage(subjectID, fdID, page, rows);
		
		System.out.println("Page:" + this.page);
		System.out.println("Rows:" + this.rows);
		System.out.println("Totally how many pages:" + this.total);
		System.out.println("FoodDiaryID:" + fdID + " has How many Meals:" + this.records);
		
		return SUCCESS;
	}
	
	public void editFDMeal(){

		System.out.println("Meal_Operation:" + oper);
		
		switch (oper) {
		case "add":
			mealService.addMealforFD(subjectID, fdID, name, info, accuracyId);
			break;
		case "edit":
			mealService.updateMeal(Integer.parseInt(id), subjectID, fdID, name, info, accuracyId);
			break;
		case "del":
			System.out.println("Delete mealID:" + id);
			System.out.println("Delete subjectID:" + subjectID);
			System.out.println("Delete fdID:" + fdID);
			
			mealService.deleteFDMeal(Integer.parseInt(id), subjectID, fdID);
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getAccuracyId() {
		return accuracyId;
	}

	public void setAccuracyId(int accuracyId) {
		this.accuracyId = accuracyId;
	}

	public List<Meal> getFDMealGridModel() {
		return FDMealGridModel;
	}

	public void setFDMealGridModel(List<Meal> fDMealGridModel) {
		FDMealGridModel = fDMealGridModel;
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
