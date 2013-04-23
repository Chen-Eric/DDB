package domain;

import java.sql.Timestamp;


/**
 * Food entity. @author MyEclipse Persistence Tools
 */

public class Food  implements java.io.Serializable {


    // Fields    

     private FoodId id;
     private Integer fcdbFoodId;
     private String fcdbFoodChapter;
     private String fcdbFoodDescription;
     private String recipe;
     private String amount;
     private String amountUnit;
     private Timestamp addtime;
     private Timestamp lastUpdateTime;
     private Boolean hasIngredients;
     


    // Constructors

    /** default constructor */
    public Food() {
    }

	/** minimal constructor */
    public Food(FoodId id, String foodId, Integer fcdbFoodId) {
        this.id = id;
        this.fcdbFoodId = fcdbFoodId;
    }
    
    /** full constructor */
    public Food(FoodId id, String fcdbFoodChapter, String fcdbFoodDescription, String recipe, String amount, String amountUnit, Timestamp addtime, Timestamp lastUpdateTime, Boolean hasIngredients, Integer fcdbFoodId) {
        this.id = id;
        this.fcdbFoodChapter = fcdbFoodChapter;
        this.fcdbFoodDescription = fcdbFoodDescription;
        this.recipe = recipe;
        this.amount = amount;
        this.amountUnit = amountUnit;
        this.addtime = addtime;
        this.lastUpdateTime = lastUpdateTime;
        this.hasIngredients = hasIngredients;
        this.fcdbFoodId = fcdbFoodId;
    }

   
    // Property accessors

    public FoodId getId() {
        return this.id;
    }
    
    public void setId(FoodId id) {
        this.id = id;
    }

    public String getFcdbFoodChapter() {
		return fcdbFoodChapter;
	}

	public void setFcdbFoodChapter(String fcdbFoodChapter) {
		this.fcdbFoodChapter = fcdbFoodChapter;
	}

	public String getFcdbFoodDescription() {
		return fcdbFoodDescription;
	}

	public void setFcdbFoodDescription(String fcdbFoodDescription) {
		this.fcdbFoodDescription = fcdbFoodDescription;
	}

	public String getRecipe() {
        return this.recipe;
    }
    
    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getAmount() {
        return this.amount;
    }
    
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmountUnit() {
        return this.amountUnit;
    }
    
    public void setAmountUnit(String amountUnit) {
        this.amountUnit = amountUnit;
    }

    public Timestamp getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
    }

    public Timestamp getLastUpdateTime() {
        return this.lastUpdateTime;
    }
    
    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Boolean getHasIngredients() {
        return this.hasIngredients;
    }
    
    public void setHasIngredients(Boolean hasIngredients) {
        this.hasIngredients = hasIngredients;
    }

    public Integer getFcdbFoodId() {
        return this.fcdbFoodId;
    }
    
    public void setFcdbFoodId(Integer fcdbFoodId) {
        this.fcdbFoodId = fcdbFoodId;
    }
   








}