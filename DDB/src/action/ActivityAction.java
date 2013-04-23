package action;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import domain.Activity;
import domain.FoodDiary;

public class ActivityAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8597306721998228641L;

	private int subjectID;
	private int adID;
	private String id; // the id of activity in DDB, for delete operation.
	private int accuracyId;

	private String starttime;
	private String endtime;
	private int cpadbActivityId; // the name of activity, comes from MONDB.
	private String majorHeading;
	private String specificActivity;
	private String realtime;
	private String note;
	private String duration;

	// For Struts2-jquery-Gridtag
	private List<Activity> ADActivityGridModel;
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

	public String showADActivities() {

		System.out.println("SelectedSubjectID:" + subjectID);
		System.out.println("cpadbActivityID:" + cpadbActivityId);
		this.records = activityService.listADAllActivities(subjectID, adID).size();
		this.total = (int) Math.ceil((double) records / (double) rows);
		this.ADActivityGridModel = activityService.listADActivitiesByPage(subjectID, adID, page, rows);

		System.out.println("Page:" + this.page);
		System.out.println("Rows:" + this.rows);
		System.out.println("Totally how many pages:" + this.total);
		System.out.println("ActivityDiaryID:" + adID + " has How many Activities:" + this.records);

		return SUCCESS;
	}

	public void editADActivity() throws ParseException {
		System.out.println("Activity_Operation:" + oper);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		switch (oper) {
		case "add":
			System.out.println(subjectID);
			System.out.println(adID);
			System.out.println("1:" + starttime);
			System.out.println("2:" + endtime);
			System.out.println("3:" + realtime);
			activityService.addActivityForAD(subjectID, adID, cpadbActivityId,
					majorHeading, specificActivity, "temp Null",
					new Timestamp(sdf.parse(starttime).getTime()),
					new Timestamp(sdf.parse(endtime).getTime()),
					new Timestamp(sdf.parse(realtime).getTime()), note, accuracyId);
			break;
		case "edit":
			activityService.updateActivity(Integer.parseInt(id), subjectID, adID, cpadbActivityId, majorHeading,
					specificActivity, duration, new Timestamp(sdf.parse(starttime).getTime()), new Timestamp(
							sdf.parse(endtime).getTime()), new Timestamp(sdf.parse(realtime).getTime()),
					note, accuracyId);
			break;
		case "del":
			System.out.println("Delete FoodDiaryID:" + id);
			activityService.deleteADActivity(Integer.parseInt(id), subjectID, adID);
			break;
		}

	}

	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public int getAdID() {
		return adID;
	}

	public void setAdID(int adID) {
		this.adID = adID;
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

	public int getCpadbActivityId() {
		return cpadbActivityId;
	}

	public void setCpadbActivityId(int cpadbActivityId) {
		this.cpadbActivityId = cpadbActivityId;
	}

	public String getMajorHeading() {
		return majorHeading;
	}

	public void setMajorHeading(String majorHeading) {
		this.majorHeading = majorHeading;
	}

	public String getSpecificActivity() {
		return specificActivity;
	}

	public void setSpecificActivity(String specificActivity) {
		this.specificActivity = specificActivity;
	}

	public String getRealtime() {
		return realtime;
	}

	public void setRealtime(String realtime) {
		this.realtime = realtime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getAccuracyId() {
		return accuracyId;
	}

	public void setAccuracyId(int accuracyId) {
		this.accuracyId = accuracyId;
	}

	public List<Activity> getADActivityGridModel() {
		return ADActivityGridModel;
	}

	public void setADActivityGridModel(List<Activity> aDActivityGridModel) {
		ADActivityGridModel = aDActivityGridModel;
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
