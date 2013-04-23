package dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.CpadbActivity;

/**
 	* A data access object (DAO) providing persistence and search support for CpadbActivity entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see domain.CpadbActivity
  * @author MyEclipse Persistence Tools 
 */
public class CpadbActivityDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(CpadbActivityDAO.class);
		//property constants
	public static final String CPADB_CODE = "cpadbCode";
	public static final String CPADB_MAJOR_HEADING = "cpadbMajorHeading";
	public static final String CPADB_SPECIFIC_ACTIVITY = "cpadbSpecificActivity";
	public static final String CPADB_MET = "cpadbMet";



	protected void initDao() {
		//do nothing
	}
    
    public void save(CpadbActivity transientInstance) {
        log.debug("saving CpadbActivity instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(CpadbActivity persistentInstance) {
        log.debug("deleting CpadbActivity instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public CpadbActivity findById( java.lang.Integer id) {
        log.debug("getting CpadbActivity instance with id: " + id);
        try {
            CpadbActivity instance = (CpadbActivity) getHibernateTemplate()
                    .get("domain.CpadbActivity", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(CpadbActivity instance) {
        log.debug("finding CpadbActivity instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding CpadbActivity instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from CpadbActivity as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByCpadbCode(Object cpadbCode
	) {
		return findByProperty(CPADB_CODE, cpadbCode
		);
	}
	
	public List findByCpadbMajorHeading(Object cpadbMajorHeading
	) {
		return findByProperty(CPADB_MAJOR_HEADING, cpadbMajorHeading
		);
	}
	
	public List findByCpadbSpecificActivity(Object cpadbSpecificActivity
	) {
		return findByProperty(CPADB_SPECIFIC_ACTIVITY, cpadbSpecificActivity
		);
	}
	
	public List findByCpadbMet(Object cpadbMet
	) {
		return findByProperty(CPADB_MET, cpadbMet
		);
	}

	public List findAll() {
		log.debug("finding all CpadbActivity instances");
		try {
			String queryString = "from CpadbActivity";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List listMajorHeadings(){
		log.debug("finging all CpadbActivity Distinct Column Names");
		Session session = this.getSession();
		List lmh = null;
		
		try {
			session.beginTransaction();
			
			String queryString = "SELECT distinct cpadb_major_heading FROM DDB.CPADB_Activity;";
			lmh = session.createSQLQuery(queryString).list();
			
			session.getTransaction().commit();
		} catch (RuntimeException re) {
			log.error("find all distinct failed", re);
			throw re;
		} finally {
			session.close();
		}
		
		return lmh;
	}
	
    public CpadbActivity merge(CpadbActivity detachedInstance) {
        log.debug("merging CpadbActivity instance");
        try {
            CpadbActivity result = (CpadbActivity) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(CpadbActivity instance) {
        log.debug("attaching dirty CpadbActivity instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(CpadbActivity instance) {
        log.debug("attaching clean CpadbActivity instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static CpadbActivityDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (CpadbActivityDAO) ctx.getBean("CpadbActivityDAO");
	}
}