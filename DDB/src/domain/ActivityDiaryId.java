package domain;

/**
 * ActivityDiaryId entity. @author MyEclipse Persistence Tools
 */

public class ActivityDiaryId implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer subjectId;

	// Constructors

	/** default constructor */
	public ActivityDiaryId() {
	}

	/** full constructor */
	public ActivityDiaryId(Integer id, Integer subjectId) {
		this.id = id;
		this.subjectId = subjectId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ActivityDiaryId))
			return false;
		ActivityDiaryId castOther = (ActivityDiaryId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getSubjectId() == castOther.getSubjectId()) || (this
						.getSubjectId() != null
						&& castOther.getSubjectId() != null && this
						.getSubjectId().equals(castOther.getSubjectId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getSubjectId() == null ? 0 : this.getSubjectId().hashCode());
		return result;
	}

}