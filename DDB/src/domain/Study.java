package domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Study entity. @author MyEclipse Persistence Tools
 */

public class Study implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer researcherId;
	private String name;
	private Timestamp startTime;
	private Date endTime;
	private String description;

	// Constructors

	/** default constructor */
	public Study() {
	}

	/** minimal constructor */
	public Study(Integer researcherId, String name, Timestamp startTime) {
		this.researcherId = researcherId;
		this.name = name;
		this.startTime = startTime;
	}

	/** full constructor */
	public Study(Integer researcherId, String name, Timestamp startTime,
			Date endTime, String description) {
		this.researcherId = researcherId;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getResearcherId() {
		return this.researcherId;
	}

	public void setResearcherId(Integer researcherId) {
		this.researcherId = researcherId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}