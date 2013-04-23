/**
 * 
 */
package action;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import domain.FoodDiary;

/**
 * @author Chen
 * 
 */
public class FoodDiaryAction extends BaseAction {

	/**
	 * @serial auto
	 */
	private static final long serialVersionUID = -4304052760082386037L;
	private int subjectID;
	private String id; // fooddiaryID, for delete operation.

	private String starttime;
	private String endtime;
	private String name;
	private String note;
	private int accuracyId;

	// For Struts2-jquery-Gridtag
	private List<FoodDiary> FDGridModel;
	private int rows; // Get how many rows we want to have into the grid - rowNum attribute in the grid
	private int page; // Get the requested page. By default grid sets this to 1.
	private int total; // Totally how many page.
	private int records; // All record;
	private String sord; // Sorting order ? asc or desc.
	private String sidx; // Get index row which user cliked to sort.
	private String searchField; // The searching string.
	private String searchOperation; // The Search Operation ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
	private String oper; // indicator of add/edit/delete operations.

	/**
	 * @author Chen
	 * @return void
	 */
	public String showFoodDiaries() {

		this.records = foodDiaryService.listSubjectDiaries(subjectID).size();
		this.total = (int) Math.ceil((double) records / (double) rows);
		this.FDGridModel = foodDiaryService.listSubjectDiariesByPage(subjectID, page, rows);

		System.out.println("Page:" + this.page);
		System.out.println("Rows:" + this.rows);
		System.out.println("Totally how many pages:" + this.total);
		System.out.println("SubjectID:" + subjectID + " has How many FDs:" + this.total);

		return SUCCESS;
	}

	/**
	 * @return success
	 * @throws ParseException
	 */
	public void editFoodDiary() throws ParseException {

		System.out.println("FD_Operation:" + oper);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		switch (oper) {
		case "add":

			System.out.println("accuracyID:" + accuracyId);
			System.out.println(starttime);
			System.out.println(endtime);
			foodDiaryService.addFoodDiary(subjectID, name, note, accuracyId, new Timestamp(sdf.parse(starttime).getTime()),
					new Timestamp(sdf.parse(endtime).getTime()));
			break;
		case "edit":
			foodDiaryService.updateFoodDiary(Integer.parseInt(id), subjectID, name, note, accuracyId, new Timestamp(sdf.parse(starttime).getTime()),
					new Timestamp(sdf.parse(endtime).getTime()));
			break;
		case "del":
			System.out.println("Delete FoodDiaryID:" + id);
			foodDiaryService.deleteFoodDiary(subjectID, Integer.parseInt(id));
			break;
		}

	}

	// getters and setters
	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getAccuracyId() {
		return accuracyId;
	}

	public void setAccuracyId(int accuracyId) {
		this.accuracyId = accuracyId;
	}

	public List<FoodDiary> getFDGridModel() {
		return FDGridModel;
	}

	public void setFDGridModel(List<FoodDiary> fDGridModel) {
		FDGridModel = fDGridModel;
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
