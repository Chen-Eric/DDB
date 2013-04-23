package domain;

import java.sql.Timestamp;

/**
 * Grouping entity. @author MyEclipse Persistence Tools
 */

public class Grouping implements java.io.Serializable {

	// Fields

	private GroupingId id;
	private Timestamp addTime;
	private Timestamp removeTime;

	// Constructors

	/** default constructor */
	public Grouping() {
	}

	/** minimal constructor */
	public Grouping(GroupingId id, Timestamp addTime) {
		this.id = id;
		this.addTime = addTime;
	}

	/** full constructor */
	public Grouping(GroupingId id, Timestamp addTime, Timestamp removeTime) {
		this.id = id;
		this.addTime = addTime;
		this.removeTime = removeTime;
	}

	// Property accessors

	public GroupingId getId() {
		return this.id;
	}

	public void setId(GroupingId id) {
		this.id = id;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Timestamp getRemoveTime() {
		return this.removeTime;
	}

	public void setRemoveTime(Timestamp removeTime) {
		this.removeTime = removeTime;
	}

}