package dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.Study;

/**
 * A data access object (DAO) providing persistence and search support for Study entities. Transaction control of the save(), update() and delete() operations can directly support Spring container-managed transactions or they can be augmented to handle user-managed Spring transactions. Each of these methods provides additional information for how to configure it for the desired type of transaction control.
 * 
 * @see domain.Study
 * @author MyEclipse Persistence Tools
 */
public class StudyDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(StudyDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Study transientInstance) {
		log.debug("saving Study instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Study persistentInstance) {
		log.debug("deleting Study instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Study findById(java.lang.Integer id) {
		log.debug("getting Study instance with id: " + id);
		try {
			Study instance = (Study) getHibernateTemplate().get("domain.Study",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Study instance) {
		log.debug("finding Study instance by example");
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
		log.debug("finding Study instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Study as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Study instances");
		try {
			String queryString = "from Study";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Study merge(Study detachedInstance) {
		log.debug("merging Study instance");
		try {
			Study result = (Study) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Study instance) {
		log.debug("attaching dirty Study instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Study instance) {
		log.debug("attaching clean Study instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StudyDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StudyDAO) ctx.getBean("StudyDAO");
	}
}