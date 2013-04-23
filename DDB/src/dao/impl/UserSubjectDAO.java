package dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.Subject;
import domain.UserSubject;
import domain.UserSubjectId;

/**
 * A data access object (DAO) providing persistence and search support for UserSubject entities. Transaction control of the save(), update() and delete() operations can directly support Spring container-managed transactions or they can be augmented to handle user-managed Spring transactions. Each of these methods provides additional information for how to configure it for the desired type of transaction control.
 * 
 * @see domain.UserSubject
 * @author MyEclipse Persistence Tools
 */
public class UserSubjectDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(UserSubjectDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(UserSubject transientInstance) {
		log.debug("saving UserSubject instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserSubject persistentInstance) {
		log.debug("deleting UserSubject instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserSubject findById(domain.UserSubjectId id) {
		log.debug("getting UserSubject instance with id: " + id);
		try {
			UserSubject instance = (UserSubject) getHibernateTemplate().get(
					"domain.UserSubject", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public UserSubject findById(int userID, int subjectID) {
		String queryString = "from UserSubject as us where us.id.userId = ? and us.id.subjectId = ?";
		Query query = this.getSession().createQuery(queryString);
		query.setParameter(0, userID);
		query.setParameter(1, subjectID);
		return (UserSubject) query.uniqueResult();
	}

	public List findUserSubjectsByUserID(UserSubjectId usid) {
		String queryString = "from UserSubject as us where us.id.userId = ?";
		Query query = this.getSession().createQuery(queryString);
		query.setParameter(0, usid.getUserId());
		return query.list();
	}

	public List findByExample(UserSubject instance) {
		log.debug("finding UserSubject instance by example");
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
		log.debug("finding UserSubject instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserSubject as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/**
	 * @author Chen
	 * @param userID
	 * @param page
	 * @param pageSize
	 * @return pagination of list of UserSubject
	 */
	@SuppressWarnings("unchecked")
	public List<UserSubject> findByPage(int userID, int page, int pageSize) {

		List<UserSubject> lus = null;
		Session session = this.getSession();

		try {

			session.beginTransaction();
			String sql = "from UserSubject as us where us.id.userId = ?";
			lus = session.createQuery(sql)
					.setFirstResult((page - 1) * pageSize)
					.setMaxResults(pageSize).setParameter(0, userID).list();
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally{
			session.close();
		}

		return lus;
	}

	public List findAll() {
		log.debug("finding all UserSubject instances");
		try {
			String queryString = "from UserSubject";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserSubject merge(UserSubject detachedInstance) {
		log.debug("merging UserSubject instance");
		try {
			UserSubject result = (UserSubject) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserSubject instance) {
		log.debug("attaching dirty UserSubject instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserSubject instance) {
		log.debug("attaching clean UserSubject instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserSubjectDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UserSubjectDAO) ctx.getBean("UserSubjectDAO");
	}
}