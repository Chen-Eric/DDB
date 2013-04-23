package dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.ActivityDiary;
import domain.ActivityDiaryId;

/**
 * A data access object (DAO) providing persistence and search support for ActivityDiary entities. Transaction control of the save(), update() and delete() operations can directly support Spring container-managed transactions or they can be augmented to handle user-managed Spring transactions. Each of these methods provides additional information for how to configure it for the desired type of transaction control.
 * 
 * @see domain.ActivityDiary
 * @author MyEclipse Persistence Tools
 */
public class ActivityDiaryDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ActivityDiaryDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(ActivityDiary transientInstance) {
		log.debug("saving ActivityDiary instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ActivityDiary persistentInstance) {
		log.debug("deleting ActivityDiary instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ActivityDiary findById(domain.ActivityDiaryId id) {
		log.debug("getting ActivityDiary instance with id: " + id);
		try {
			ActivityDiary instance = (ActivityDiary) getHibernateTemplate()
					.get("domain.ActivityDiary", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ActivityDiary instance) {
		log.debug("finding ActivityDiary instance by example");
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
		log.debug("finding ActivityDiary instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ActivityDiary as model where model."
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
	public List<ActivityDiary> findByPage(int subjectID, int page, int pageSize) {
		List<ActivityDiary> lad = null;
		Session session = this.getSession();

		try {
			session.beginTransaction();
			String sql = "from ActivityDiary as ad where ad.id.subjectId = ?";
			lad = session.createQuery(sql)
					.setFirstResult((page - 1) * pageSize)
					.setMaxResults(pageSize).setParameter(0, subjectID).list();
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return lad;
	}

	public List findAll() {
		log.debug("finding all ActivityDiary instances");
		try {
			String queryString = "from ActivityDiary";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List<ActivityDiary> listActivityDiariesBySubjectID(int subjectID) {
		String queryString = "from domain.ActivityDiary as ad where ad.id.subjectId = ?";
		Query query = this.getSession().createQuery(queryString);
		query.setParameter(0, subjectID);
		return query.list();
	}

	public ActivityDiary merge(ActivityDiary detachedInstance) {
		log.debug("merging ActivityDiary instance");
		try {
			ActivityDiary result = (ActivityDiary) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ActivityDiary instance) {
		log.debug("attaching dirty ActivityDiary instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ActivityDiary instance) {
		log.debug("attaching clean ActivityDiary instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ActivityDiaryDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ActivityDiaryDAO) ctx.getBean("ActivityDiaryDAO");
	}
}