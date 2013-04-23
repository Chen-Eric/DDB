package domain;



/**
 * FoodId entity. @author MyEclipse Persistence Tools
 */

public class FoodId  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer mealId;
     private Integer mealFoodDiaryId;
     private Integer mealFoodDiarySubjectId;


    // Constructors

    /** default constructor */
    public FoodId() {
    }

    
    /** full constructor */
    public FoodId(Integer id, Integer mealId, Integer mealFoodDiaryId, Integer mealFoodDiarySubjectId) {
        this.id = id;
        this.mealId = mealId;
        this.mealFoodDiaryId = mealFoodDiaryId;
        this.mealFoodDiarySubjectId = mealFoodDiarySubjectId;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMealId() {
        return this.mealId;
    }
    
    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public Integer getMealFoodDiaryId() {
        return this.mealFoodDiaryId;
    }
    
    public void setMealFoodDiaryId(Integer mealFoodDiaryId) {
        this.mealFoodDiaryId = mealFoodDiaryId;
    }

    public Integer getMealFoodDiarySubjectId() {
        return this.mealFoodDiarySubjectId;
    }
    
    public void setMealFoodDiarySubjectId(Integer mealFoodDiarySubjectId) {
        this.mealFoodDiarySubjectId = mealFoodDiarySubjectId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FoodId) ) return false;
		 FoodId castOther = ( FoodId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getMealId()==castOther.getMealId()) || ( this.getMealId()!=null && castOther.getMealId()!=null && this.getMealId().equals(castOther.getMealId()) ) )
 && ( (this.getMealFoodDiaryId()==castOther.getMealFoodDiaryId()) || ( this.getMealFoodDiaryId()!=null && castOther.getMealFoodDiaryId()!=null && this.getMealFoodDiaryId().equals(castOther.getMealFoodDiaryId()) ) )
 && ( (this.getMealFoodDiarySubjectId()==castOther.getMealFoodDiarySubjectId()) || ( this.getMealFoodDiarySubjectId()!=null && castOther.getMealFoodDiarySubjectId()!=null && this.getMealFoodDiarySubjectId().equals(castOther.getMealFoodDiarySubjectId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getMealId() == null ? 0 : this.getMealId().hashCode() );
         result = 37 * result + ( getMealFoodDiaryId() == null ? 0 : this.getMealFoodDiaryId().hashCode() );
         result = 37 * result + ( getMealFoodDiarySubjectId() == null ? 0 : this.getMealFoodDiarySubjectId().hashCode() );
         return result;
   }   





}