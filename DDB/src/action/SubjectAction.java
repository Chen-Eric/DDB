/**
 * 
 */
package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.struts2.json.annotations.JSON;
import org.apache.struts2.json.annotations.JSONParameter;
import org.hibernate.proxy.HibernateProxy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import common.HibernateProxySerializer;

import domain.Subject;

/**
 * @author Chen
 * @version 1.1
 */
public class SubjectAction extends BaseAction {

	/**
	 * @serial auto
	 */
	private static final long serialVersionUID = -9100384687883454158L;

	private int userID;
	private String id; // subject ID, for delete operation.

	private String referenceID;
	private String sureName;
	private String familyName;
	private String gender;
	private String dob;
	private float height;
	private float weight;
	private String email;
	private String phone;
	private String mobile;
	private String special;

	// For Struts2-jquery-Gridtag
	private List<Subject> SubjectGridModel;
	private int rows; // Get how many rows we want to have into the grid - rowNum attribute in the grid
	private int page; // Get the requested page. By default grid sets this to 1.
	private int total; // Totally how many page.
	private int records; // All record;
	private String sord; // Sorting order ? asc or desc.
	private String sidx; // Get index row which user cliked to sort.
	private String searchField; // The searching string.
	private String searchOperation; // The Search Operation ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
	private String oper; // indicator of add/edit/delete operations.

//	GsonBuilder gsonBuilder = new GsonBuilder();
//	Gson gson = gsonBuilder.registerTypeHierarchyAdapter(HibernateProxy.class, new HibernateProxySerializer()).create();

	/**
	 * @return String success while find the correct Subjects for the UserID. put Subjects in session.
	 */
	public String showUserSubjects() {

		userID = (Integer) this.session.get("loginUserID");// should come from session.
		System.out.println("loginUserID:" + userID);
		
		this.records = subjectService.listSubjectsByUser(userID).size();
		this.total = (int) Math.ceil((double)records/(double)rows);
		this.SubjectGridModel = subjectService.listSubjectsByUserAndPage(userID, this.page, this.rows);
		
		System.out.println("Page:" + this.page);
		System.out.println("Rows:" + this.rows);
		System.out.println("Totally how many pages:" + this.total);
		System.out.println("How many subjects: " + this.records);

		return SUCCESS;
	}

	/**
	 * @return success
	 * @throws ParseException 
	 */
	public void editUserSubject() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		System.out.println("Subject_Operation:" + oper);

		switch (oper) {
		case "add":
			
			subjectService.addSubject(userID, referenceID, sureName, familyName, sdf.parse(dob), gender, 
					height, weight, email, phone, mobile, special);
			System.out.println("Edit_Action_done");
			break;
		case "edit":
			System.out.println("Edit_SubjectID:" + id);
			System.out.println(dob);
			subjectService.updateSubject(Integer.parseInt(id), userID, referenceID, sureName, familyName, sdf.parse(dob), gender, 
					height, weight, email, phone, mobile, special);
			System.out.println("Why it doesnt work?");
			break;
		case "del":
			System.out.println("Delete_SubjectID:" + id);
			subjectService.deleteSubject(userID, Integer.parseInt(id));
			break;
		}
		
	}

	public void deleteSubject() {
		userID = (Integer) this.session.get("loginUserID");
		subjectService.deleteSubject(userID, Integer.parseInt(id));
	}

	// getters and setters
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReferenceID() {
		return referenceID;
	}

	public void setReferenceID(String referenceID) {
		this.referenceID = referenceID;
	}

	public String getSureName() {
		return sureName;
	}

	public void setSureName(String sureName) {
		this.sureName = sureName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public List<Subject> getSubjectGridModel() {
		return SubjectGridModel;
	}

	public void setSubjectGridModel(List<Subject> subjectGridModel) {
		SubjectGridModel = subjectGridModel;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
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

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

}
