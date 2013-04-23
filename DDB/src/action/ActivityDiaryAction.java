/**
 * 
 */
package action;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import domain.ActivityDiary;

/**
 * @author Chen
 * 
 */
public class ActivityDiaryAction extends BaseAction {

	/**
	 * @serial auto
	 */
	private static final long serialVersionUID = -7738667379552343343L;
	private int subjectID;
	private int id; // activitydiaryID, for delete operation.
	private int accuracyId;

	private String name;
	private String note;
	private String starttime;
	private String endtime;

	// For Struts2-jquery-Gridtag
	private List<ActivityDiary> ADGridModel;
	private int rows; // Get how many rows we want to have into the grid - rowNum attribute in the grid
	private int page; // Get the requested page. By default grid sets this to 1.
	private int total; // Totally how many page.
	private int records; // All record;
	private String sord; // Sorting order ? asc or desc.
	private String sidx; // Get index row which user cliked to sort.
	private String searchField; // The searching string.
	private String searchOperation; // The Search Operation ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
	private String oper; // indicator of add/edit/delete operations.

	// GsonBuilder gsonBuilder = new GsonBuilder();
	// Gson gson = gsonBuilder.registerTypeHierarchyAdapter(HibernateProxy.class, new HibernateProxySerializer()).create();

	public String showActivityDiaries() {

		System.out.println("ActivityDiaryAction_subjectID: " + subjectID);

		this.records = activityDiaryService.listSubjectDiaries(subjectID).size();
		this.total = (int) Math.ceil((double) records / (double) rows);
		this.ADGridModel = activityDiaryService.listSubjectDiariesByPage(subjectID, page, rows);

		System.out.println("Page:" + this.page);
		System.out.println("Rows:" + this.rows);
		System.out.println("Totally how many pages:" + this.total);
		System.out.println("SubjectID:" + subjectID + " has How many ADs:" + this.total);

		return SUCCESS;
	}

	/**
	 * @return success
	 * @throws ParseException
	 */
	public void editActivityDiary() throws ParseException {

		System.out.println("Subject_Operation:" + oper);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		switch (oper) {
		case "add":
			activityDiaryService.addActivityDiary(subjectID, 1, name, new Timestamp(sdf.parse(starttime).getTime()), new Timestamp(sdf.parse(endtime)
					.getTime()), note);
			break;
		case "edit":
			activityDiaryService.updateActivityDiary(id, subjectID, accuracyId, name, new Timestamp(sdf.parse(starttime).getTime()), new Timestamp(
					sdf.parse(endtime).getTime()), note);
			break;
		case "del":
			System.out.println("Delete FoodDiaryID:" + id);
			foodDiaryService.deleteFoodDiary(subjectID, id);
			break;
		}
	}

	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccuracyId() {
		return accuracyId;
	}

	public void setAccuracyId(int accuracyId) {
		this.accuracyId = accuracyId;
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

	public List<ActivityDiary> getADGridModel() {
		return ADGridModel;
	}

	public void setADGridModel(List<ActivityDiary> aDGridModel) {
		ADGridModel = aDGridModel;
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
