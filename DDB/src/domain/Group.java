package domain;

import java.sql.Timestamp;

/**
 * Group entity. @author MyEclipse Persistence Tools
 */

public class Group implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer studyId;
	private String name;
	private Timestamp createtime;
	private Timestamp dismisstime;
	private String description;

	// Constructors

	/** default constructor */
	public Group() {
	}

	/** minimal constructor */
	public Group(Integer studyId, String name, Timestamp createtime) {
		this.studyId = studyId;
		this.name = name;
		this.createtime = createtime;
	}

	/** full constructor */
	public Group(Integer studyId, String name, Timestamp createtime,
			Timestamp dismisstime, String description) {
		this.studyId = studyId;
		this.name = name;
		this.createtime = createtime;
		this.dismisstime = dismisstime;
		this.description = description;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudyId() {
		return this.studyId;
	}

	public void setStudyId(Integer studyId) {
		this.studyId = studyId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getDismisstime() {
		return this.dismisstime;
	}

	public void setDismisstime(Timestamp dismisstime) {
		this.dismisstime = dismisstime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}