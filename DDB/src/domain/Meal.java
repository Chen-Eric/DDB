package domain;

import java.sql.Timestamp;

/**
 * Meal entity. @author MyEclipse Persistence Tools
 */

public class Meal implements java.io.Serializable {

	// Fields

	private MealId id;
	private String name;
	private String info;
	private Timestamp addtime;
	private Timestamp lastupdate;
	private Integer accuracyId;

	// Constructors

	/** default constructor */
	public Meal() {
	}

	/** minimal constructor */
	public Meal(MealId id, String name, Integer accuracyId) {
		this.id = id;
		this.name = name;
		this.accuracyId = accuracyId;
	}

	/** full constructor */
	public Meal(MealId id, String name, String info, Timestamp addtime,
			Timestamp lastupdate, Integer accuracyId) {
		this.id = id;
		this.name = name;
		this.info = info;
		this.addtime = addtime;
		this.lastupdate = lastupdate;
		this.accuracyId = accuracyId;
	}

	// Property accessors

	public MealId getId() {
		return this.id;
	}

	public void setId(MealId id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
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

	public Integer getAccuracyId() {
		return this.accuracyId;
	}

	public void setAccuracyId(Integer accuracyId) {
		this.accuracyId = accuracyId;
	}

}