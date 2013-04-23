package dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.Activity;
import domain.Meal;
import domain.MealId;

/**
 * A data access object (DAO) providing persistence and search support for Meal entities. Transaction control of the save(), update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle user-managed Spring transactions. Each of these methods provides additional information for how to configure it for the desired
 * type of transaction control.
 * 
 * @see domain.Meal
 * @author MyEclipse Persistence Tools
 */
public class MealDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(MealDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Meal transientInstance) {
		log.debug("saving Meal instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Meal persistentInstance) {
		log.debug("deleting Meal instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Meal findById(domain.MealId id) {
		log.debug("getting Meal instance with id: " + id);
		try {
			Meal instance = (Meal) getHibernateTemplate().get("domain.Meal", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Meal> findByID(int subjectID, int fdID) {
		String queryString = "from domain.Meal as m where m.id.foodDiarySubjectId = ? and m.id.foodDiaryId =?";
		org.hibernate.Query query = this.getSession().createQuery(queryString);
		query.setParameter(0, subjectID);
		query.setParameter(1, fdID);
		return query.list();
	}

	public List findByExample(Meal instance) {
		log.debug("finding Meal instance by example");
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
		log.debug("finding Meal instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Meal as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Meal instances");
		try {
			String queryString = "from Meal";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/**
	 * @author Chen
	 * @param subjectID
	 * @param fdID
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Meal> findByPage(int subjectID, int fdID, int page, int pageSize) {

		List<Meal> lm = null;
		Session session = this.getSession();

		try {
			session.beginTransaction();
			String sql = "from domain.Meal as m where m.id.foodDiarySubjectId = ? and m.id.foodDiaryId =?";
			Query query = session.createQuery(sql).setFirstResult((page - 1) * pageSize).setMaxResults(pageSize);
			query.setParameter(0, subjectID);
			query.setParameter(1, fdID);
			lm = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

		return lm;

	}

	public Meal merge(Meal detachedInstance) {
		log.debug("merging Meal instance");
		try {
			Meal result = (Meal) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Meal instance) {
		log.debug("attaching dirty Meal instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Meal instance) {
		log.debug("attaching clean Meal instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MealDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MealDAO) ctx.getBean("MealDAO");
	}
}