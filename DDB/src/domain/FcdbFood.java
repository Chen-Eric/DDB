package domain;



/**
 * FcdbFood entity. @author MyEclipse Persistence Tools
 */

public class FcdbFood  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String fcdbFoodId;
     private String fcdbFoodChapter;
     private String fcdbFoodDescription;


    // Constructors

    /** default constructor */
    public FcdbFood() {
    }

    
    /** full constructor */
    public FcdbFood(String fcdbFoodId, String fcdbFoodChapter, String fcdbFoodDescription) {
        this.fcdbFoodId = fcdbFoodId;
        this.fcdbFoodChapter = fcdbFoodChapter;
        this.fcdbFoodDescription = fcdbFoodDescription;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFcdbFoodId() {
        return this.fcdbFoodId;
    }
    
    public void setFcdbFoodId(String fcdbFoodId) {
        this.fcdbFoodId = fcdbFoodId;
    }

    public String getFcdbFoodChapter() {
        return this.fcdbFoodChapter;
    }
    
    public void setFcdbFoodChapter(String fcdbFoodChapter) {
        this.fcdbFoodChapter = fcdbFoodChapter;
    }

    public String getFcdbFoodDescription() {
        return this.fcdbFoodDescription;
    }
    
    public void setFcdbFoodDescription(String fcdbFoodDescription) {
        this.fcdbFoodDescription = fcdbFoodDescription;
    }
   








}