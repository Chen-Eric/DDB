package domain;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

/**
 * Subject entity. @author MyEclipse Persistence Tools
 */

public class Subject implements java.io.Serializable {

	// Fields

	private Integer id;
	private String referenceID;
	private String sureName;
	private String familyName;
	private Date dob;
	private String gender;
	private Float height;
	private Float weight;
	private String email;
	private String phone;
	private String mobile;
	private String special;
	private Timestamp addtime;
	private Timestamp lastupdate;

	// Constructors

	/** default constructor */
	public Subject() {
	}

	/** minimal constructor */
	public Subject(Date dob, String gender) {
		this.dob = dob;
		this.gender = gender;
	}

	/** full constructor */
	public Subject(String referenceID, String sureName, String familyName, Date dob, String gender,
			Float height, Float weight, String email, String phone,
			String mobile, String special, Timestamp addtime,
			Timestamp lastupdate) {
		this.referenceID = referenceID;
		this.sureName = sureName;
		this.familyName = familyName;
		this.dob = dob;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.email = email;
		this.phone = phone;
		this.mobile = mobile;
		this.special = special;
		this.addtime = addtime;
		this.lastupdate = lastupdate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReferenceID() {
		return referenceID;
	}

	public void setReferenceID(String referenceID) {
		this.referenceID = referenceID;
	}

	public String getSureName() {
		return this.sureName;
	}

	public void setSureName(String sureName) {
		this.sureName = sureName;
	}

	public String getFamilyName() {
		return this.familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Float getHeight() {
		return this.height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getWeight() {
		return this.weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSpecial() {
		return this.special;
	}
	
	public void setSpecial(String special) {
		this.special = special;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getLastupdate() {
		return this.lastupdate;
	}

	public void setLastupdate(Timestamp lastupdate) {
		this.lastupdate = lastupdate;
	}

}