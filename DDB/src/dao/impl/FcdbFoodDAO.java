package dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.FcdbFood;

/**
 * A data access object (DAO) providing persistence and search support for FcdbFood entities. Transaction control of the save(), update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle user-managed Spring transactions. Each of these methods provides additional information for how to configure it for the desired
 * type of transaction control.
 * 
 * @see domain.FcdbFood
 * @author MyEclipse Persistence Tools
 */
public class FcdbFoodDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(FcdbFoodDAO.class);
	// property constants
	public static final String FCDB_FOOD_ID = "fcdbFoodId";
	public static final String FCDB_FOOD_CHAPTER = "fcdbFoodChapter";
	public static final String FCDB_FOOD_DESCRIPTION = "fcdbFoodDescription";

	protected void initDao() {
		// do nothing
	}

	public void save(FcdbFood transientInstance) {
		log.debug("saving FcdbFood instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(FcdbFood persistentInstance) {
		log.debug("deleting FcdbFood instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FcdbFood findById(java.lang.Integer id) {
		log.debug("getting FcdbFood instance with id: " + id);
		try {
			FcdbFood instance = (FcdbFood) getHibernateTemplate().get("domain.FcdbFood", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(FcdbFood instance) {
		log.debug("finding FcdbFood instance by example");
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
		log.debug("finding FcdbFood instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from FcdbFood as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFcdbFoodId(Object fcdbFoodId) {
		return findByProperty(FCDB_FOOD_ID, fcdbFoodId);
	}

	public List findByFcdbFoodChapter(Object fcdbFoodChapter) {
		return findByProperty(FCDB_FOOD_CHAPTER, fcdbFoodChapter);
	}

	public List findByFcdbFoodDescription(Object fcdbFoodDescription) {
		return findByProperty(FCDB_FOOD_DESCRIPTION, fcdbFoodDescription);
	}

	public List findAll() {
		log.debug("finding all FcdbFood instances");
		try {
			String queryString = "from FcdbFood";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List listFoodChapters(){
		log.debug("finding all FcdbFood Distinct Column Names");
		Session session = this.getSession();
		List lfc = null;
		try {
			session.beginTransaction();
			
			String queryString = "SELECT distinct fcdb_food_chapter FROM DDB.FCDB_Food;";
			lfc = session.createSQLQuery(queryString).list();
			
			session.getTransaction().commit();
		} catch (RuntimeException re) {
			
		} finally {
			session.close();
		}
		return lfc;
	}

	public FcdbFood merge(FcdbFood detachedInstance) {
		log.debug("merging FcdbFood instance");
		try {
			FcdbFood result = (FcdbFood) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FcdbFood instance) {
		log.debug("attaching dirty FcdbFood instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FcdbFood instance) {
		log.debug("attaching clean FcdbFood instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FcdbFoodDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FcdbFoodDAO) ctx.getBean("FcdbFoodDAO");
	}
}