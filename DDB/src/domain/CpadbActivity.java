package domain;



/**
 * CpadbActivity entity. @author MyEclipse Persistence Tools
 */

public class CpadbActivity  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String cpadbCode;
     private String cpadbMajorHeading;
     private String cpadbSpecificActivity;
     private Float cpadbMet;


    // Constructors

    /** default constructor */
    public CpadbActivity() {
    }

    
    /** full constructor */
    public CpadbActivity(String cpadbCode, String cpadbMajorHeading, String cpadbSpecificActivity, Float cpadbMet) {
        this.cpadbCode = cpadbCode;
        this.cpadbMajorHeading = cpadbMajorHeading;
        this.cpadbSpecificActivity = cpadbSpecificActivity;
        this.cpadbMet = cpadbMet;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpadbCode() {
        return this.cpadbCode;
    }
    
    public void setCpadbCode(String cpadbCode) {
        this.cpadbCode = cpadbCode;
    }

    public String getCpadbMajorHeading() {
        return this.cpadbMajorHeading;
    }
    
    public void setCpadbMajorHeading(String cpadbMajorHeading) {
        this.cpadbMajorHeading = cpadbMajorHeading;
    }

    public String getCpadbSpecificActivity() {
        return this.cpadbSpecificActivity;
    }
    
    public void setCpadbSpecificActivity(String cpadbSpecificActivity) {
        this.cpadbSpecificActivity = cpadbSpecificActivity;
    }

    public Float getCpadbMet() {
        return this.cpadbMet;
    }
    
    public void setCpadbMet(Float cpadbMet) {
        this.cpadbMet = cpadbMet;
    }
   

}