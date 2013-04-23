package domain;

import java.sql.Timestamp;


/**
 * Activity entity. @author MyEclipse Persistence Tools
 */

public class Activity  implements java.io.Serializable {


    // Fields    

     private ActivityId id;
     private Integer accuracyId;
     private Integer cpadbActivityId;
     private String majorHeading;
     private String specificActivity;
     private String duration;
     private Timestamp starttime;
     private Timestamp endtime;
     private Timestamp realtime;
     private Timestamp addtime;
     private Timestamp lastUpdateTime;
     private String note;



    // Constructors

    /** default constructor */
    public Activity() {
    }

	/** minimal constructor */
    public Activity(ActivityId id, Integer accuracyId, Integer cpadbActivityId) {
        this.id = id;
        this.accuracyId = accuracyId;
        this.cpadbActivityId = cpadbActivityId;
    }
    
    /** full constructor */
    public Activity(ActivityId id, String majorHeading, String duration, Timestamp starttime, Timestamp endtime, Timestamp realtime, Timestamp addtime, Timestamp lastUpdateTime, String note, Integer accuracyId, Integer cpadbActivityId) {
        this.id = id;
        this.majorHeading = majorHeading;
        this.duration = duration;
        this.starttime = starttime;
        this.endtime = endtime;
        this.realtime = realtime;
        this.addtime = addtime;
        this.lastUpdateTime = lastUpdateTime;
        this.note = note;
        this.accuracyId = accuracyId;
        this.cpadbActivityId = cpadbActivityId;
    }

   
    // Property accessors

    public ActivityId getId() {
        return this.id;
    }
    
    public void setId(ActivityId id) {
        this.id = id;
    }

    public String getMajorHeading() {
		return majorHeading;
	}

	public void setMajorHeading(String majorHeading) {
		this.majorHeading = majorHeading;
	}

	public String getSpecificActivity() {
		return specificActivity;
	}

	public void setSpecificActivity(String specificActivity) {
		this.specificActivity = specificActivity;
	}

	public String getDuration() {
        return this.duration;
    }
    
    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Timestamp getStarttime() {
        return this.starttime;
    }
    
    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public Timestamp getEndtime() {
        return this.endtime;
    }
    
    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    public Timestamp getRealtime() {
        return this.realtime;
    }
    
    public void setRealtime(Timestamp realtime) {
        this.realtime = realtime;
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

    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }

    public Integer getAccuracyId() {
        return this.accuracyId;
    }
    
    public void setAccuracyId(Integer accuracyId) {
        this.accuracyId = accuracyId;
    }

    public Integer getCpadbActivityId() {
        return this.cpadbActivityId;
    }
    
    public void setCpadbActivityId(Integer cpadbActivityId) {
        this.cpadbActivityId = cpadbActivityId;
    }
   








}