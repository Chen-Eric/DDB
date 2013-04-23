package dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.ActivityDiary;
import domain.FoodDiary;
import domain.FoodDiaryId;

/**
 * A data access object (DAO) providing persistence and search support for FoodDiary entities. Transaction control of the save(), update() and delete() operations can directly support Spring container-managed transactions or they can be augmented to handle user-managed Spring transactions. Each of these methods provides additional information for how to configure it for the desired type of transaction control.
 * 
 * @see domain.FoodDiary
 * @author MyEclipse Persistence Tools
 */
public class FoodDiaryDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(FoodDiaryDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(FoodDiary transientInstance) {
		log.debug("saving FoodDiary instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(FoodDiary persistentInstance) {
		log.debug("deleting FoodDiary instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FoodDiary findById(domain.FoodDiaryId id) {
		log.debug("getting FoodDiary instance with id: " + id);
		try {
			FoodDiary instance = (FoodDiary) getHibernateTemplate().get(
					"domain.FoodDiary", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(FoodDiary instance) {
		log.debug("finding FoodDiary instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding FoodDiary instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from FoodDiary as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	/**
	 * @author Chen
	 * @param subjectID
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<FoodDiary> findByPage(int subjectID, int page, int pageSize) {
		List<FoodDiary> lfd = null;
		Session session = this.getSession();

		try {
			session.beginTransaction();
			String sql = "from FoodDiary as fd where fd.id.subjectId = ?";
			lfd = session.createQuery(sql)
					.setFirstResult((page - 1) * pageSize)
					.setMaxResults(pageSize).setParameter(0, subjectID).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return lfd;
	}

	public List findAll() {
		log.debug("finding all FoodDiary instances");
		try {
			String queryString = "from FoodDiary";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List<FoodDiary> listFoodDiariesBySubjectID(int subjectID) {
		String queryString = "from domain.FoodDiary as fd where fd.id.subjectId = ?";
		org.hibernate.Query query = this.getSession().createQuery(queryString);
		query.setParameter(0, subjectID);
		return query.list();
	}

	public FoodDiary merge(FoodDiary detachedInstance) {
		log.debug("merging FoodDiary instance");
		try {
			FoodDiary result = (FoodDiary) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FoodDiary instance) {
		log.debug("attaching dirty FoodDiary instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FoodDiary instance) {
		log.debug("attaching clean FoodDiary instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FoodDiaryDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FoodDiaryDAO) ctx.getBean("FoodDiaryDAO");
	}
}