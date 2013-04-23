package domain;

/**
 * MealId entity. @author MyEclipse Persistence Tools
 */

public class MealId implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer foodDiaryId;
	private Integer foodDiarySubjectId;

	// Constructors

	/** default constructor */
	public MealId() {
	}

	/** full constructor */
	public MealId(Integer id, Integer foodDiaryId, Integer foodDiarySubjectId) {
		this.id = id;
		this.foodDiaryId = foodDiaryId;
		this.foodDiarySubjectId = foodDiarySubjectId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFoodDiaryId() {
		return this.foodDiaryId;
	}

	public void setFoodDiaryId(Integer foodDiaryId) {
		this.foodDiaryId = foodDiaryId;
	}

	public Integer getFoodDiarySubjectId() {
		return this.foodDiarySubjectId;
	}

	public void setFoodDiarySubjectId(Integer foodDiarySubjectId) {
		this.foodDiarySubjectId = foodDiarySubjectId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MealId))
			return false;
		MealId castOther = (MealId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getFoodDiaryId() == castOther.getFoodDiaryId()) || (this
						.getFoodDiaryId() != null
						&& castOther.getFoodDiaryId() != null && this
						.getFoodDiaryId().equals(castOther.getFoodDiaryId())))
				&& ((this.getFoodDiarySubjectId() == castOther
						.getFoodDiarySubjectId()) || (this
						.getFoodDiarySubjectId() != null
						&& castOther.getFoodDiarySubjectId() != null && this
						.getFoodDiarySubjectId().equals(
								castOther.getFoodDiarySubjectId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37
				* result
				+ (getFoodDiaryId() == null ? 0 : this.getFoodDiaryId()
						.hashCode());
		result = 37
				* result
				+ (getFoodDiarySubjectId() == null ? 0 : this
						.getFoodDiarySubjectId().hashCode());
		return result;
	}

}