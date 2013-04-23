package domain;

import java.sql.Timestamp;

/**
 * FoodIngredient entity. @author MyEclipse Persistence Tools
 */

public class FoodIngredient implements java.io.Serializable {

	// Fields

	private FoodIngredientId id;
	private Timestamp addtime;
	private Timestamp lastupdate;

	// Constructors

	/** default constructor */
	public FoodIngredient() {
	}

	/** minimal constructor */
	public FoodIngredient(FoodIngredientId id) {
		this.id = id;
	}

	/** full constructor */
	public FoodIngredient(FoodIngredientId id, Timestamp addtime,
			Timestamp lastupdate) {
		this.id = id;
		this.addtime = addtime;
		this.lastupdate = lastupdate;
	}

	// Property accessors

	public FoodIngredientId getId() {
		return this.id;
	}

	public void setId(FoodIngredientId id) {
		this.id = id;
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

}