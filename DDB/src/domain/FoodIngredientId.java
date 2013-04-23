package domain;

/**
 * FoodIngredientId entity. @author MyEclipse Persistence Tools
 */

public class FoodIngredientId implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer foodId;
	private Integer ingredientId;

	// Constructors

	/** default constructor */
	public FoodIngredientId() {
	}

	/** full constructor */
	public FoodIngredientId(Integer id, Integer foodId, Integer ingredientId) {
		this.id = id;
		this.foodId = foodId;
		this.ingredientId = ingredientId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFoodId() {
		return this.foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public Integer getIngredientId() {
		return this.ingredientId;
	}

	public void setIngredientId(Integer ingredientId) {
		this.ingredientId = ingredientId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FoodIngredientId))
			return false;
		FoodIngredientId castOther = (FoodIngredientId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getFoodId() == castOther.getFoodId()) || (this
						.getFoodId() != null && castOther.getFoodId() != null && this
						.getFoodId().equals(castOther.getFoodId())))
				&& ((this.getIngredientId() == castOther.getIngredientId()) || (this
						.getIngredientId() != null
						&& castOther.getIngredientId() != null && this
						.getIngredientId().equals(castOther.getIngredientId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getFoodId() == null ? 0 : this.getFoodId().hashCode());
		result = 37
				* result
				+ (getIngredientId() == null ? 0 : this.getIngredientId()
						.hashCode());
		return result;
	}

}