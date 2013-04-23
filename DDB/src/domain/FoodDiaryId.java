package domain;

/**
 * FoodDiaryId entity. @author MyEclipse Persistence Tools
 */

public class FoodDiaryId implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer subjectId;

	// Constructors

	/** default constructor */
	public FoodDiaryId() {
	}

	/** full constructor */
	public FoodDiaryId(Integer id, Integer subjectId) {
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
		if (!(other instanceof FoodDiaryId))
			return false;
		FoodDiaryId castOther = (FoodDiaryId) other;

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