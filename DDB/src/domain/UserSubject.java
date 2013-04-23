package domain;

import java.sql.Timestamp;

/**
 * UserSubject entity. @author MyEclipse Persistence Tools
 */

public class UserSubject implements java.io.Serializable {

	// Fields

	private UserSubjectId id;
	private Timestamp createTime;
	private Timestamp removeTime;

	// Constructors

	/** default constructor */
	public UserSubject() {
	}

	/** minimal constructor */
	public UserSubject(UserSubjectId id, Timestamp createTime) {
		this.id = id;
		this.createTime = createTime;
	}

	/** full constructor */
	public UserSubject(UserSubjectId id, Timestamp createTime,
			Timestamp removeTime) {
		this.id = id;
		this.createTime = createTime;
		this.removeTime = removeTime;
	}

	// Property accessors

	public UserSubjectId getId() {
		return this.id;
	}

	public void setId(UserSubjectId id) {
		this.id = id;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getRemoveTime() {
		return this.removeTime;
	}

	public void setRemoveTime(Timestamp removeTime) {
		this.removeTime = removeTime;
	}

}