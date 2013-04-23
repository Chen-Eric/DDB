package domain;



/**
 * ActivityId entity. @author MyEclipse Persistence Tools
 */

public class ActivityId  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer activityDiaryId;
     private Integer activityDiarySubjectId;


    // Constructors

    /** default constructor */
    public ActivityId() {
    }

    
    /** full constructor */
    public ActivityId(Integer id, Integer activityDiaryId, Integer activityDiarySubjectId) {
        this.id = id;
        this.activityDiaryId = activityDiaryId;
        this.activityDiarySubjectId = activityDiarySubjectId;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityDiaryId() {
        return this.activityDiaryId;
    }
    
    public void setActivityDiaryId(Integer activityDiaryId) {
        this.activityDiaryId = activityDiaryId;
    }

    public Integer getActivityDiarySubjectId() {
        return this.activityDiarySubjectId;
    }
    
    public void setActivityDiarySubjectId(Integer activityDiarySubjectId) {
        this.activityDiarySubjectId = activityDiarySubjectId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ActivityId) ) return false;
		 ActivityId castOther = ( ActivityId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getActivityDiaryId()==castOther.getActivityDiaryId()) || ( this.getActivityDiaryId()!=null && castOther.getActivityDiaryId()!=null && this.getActivityDiaryId().equals(castOther.getActivityDiaryId()) ) )
 && ( (this.getActivityDiarySubjectId()==castOther.getActivityDiarySubjectId()) || ( this.getActivityDiarySubjectId()!=null && castOther.getActivityDiarySubjectId()!=null && this.getActivityDiarySubjectId().equals(castOther.getActivityDiarySubjectId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getActivityDiaryId() == null ? 0 : this.getActivityDiaryId().hashCode() );
         result = 37 * result + ( getActivityDiarySubjectId() == null ? 0 : this.getActivityDiarySubjectId().hashCode() );
         return result;
   }   





}