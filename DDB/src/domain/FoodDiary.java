package domain;

import java.sql.Timestamp;

/**
 * FoodDiary entity. @author MyEclipse Persistence Tools
 */

public class FoodDiary implements java.io.Serializable {

	// Fields

	private FoodDiaryId id;
	private String name;
	private Timestamp addtime;
	private Timestamp lastUpdate;
	private Timestamp starttime;
	private Timestamp endtime;
	private String note;
	private Integer accuracyId;

	// Constructors

	/** default constructor */
	public FoodDiary() {
	}

	/** minimal constructor */
	public FoodDiary(FoodDiaryId id, String name, Integer accuracyId) {
		this.id = id;
		this.name = name;
		this.accuracyId = accuracyId;
	}

	/** full constructor */
	public FoodDiary(FoodDiaryId id, String name, Timestamp addtime,
			Timestamp lastUpdate, Timestamp starttime, Timestamp endtime,
			String note, Integer accuracyId) {
		this.id = id;
		this.name = name;
		this.addtime = addtime;
		this.lastUpdate = lastUpdate;
		this.starttime = starttime;
		this.endtime = endtime;
		this.note = note;
		this.accuracyId = accuracyId;
	}

	// Property accessors

	public FoodDiaryId getId() {
		return this.id;
	}

	public void setId(FoodDiaryId id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getAccuracyId() {
		return this.accuracyId;
	}

	public void setAccuracyId(Integer accuracyId) {
		this.accuracyId = accuracyId;
	}

}