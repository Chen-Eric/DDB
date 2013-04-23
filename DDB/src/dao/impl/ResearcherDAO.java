package dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.Researcher;

/**
 * A data access object (DAO) providing persistence and search support for Researcher entities. Transaction control of the save(), update() and delete() operations can directly support Spring container-managed transactions or they can be augmented to handle user-managed Spring transactions. Each of these methods provides additional information for how to configure it for the desired type of transaction control.
 * 
 * @see domain.Researcher
 * @author MyEclipse Persistence Tools
 */
public class ResearcherDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ResearcherDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Researcher transientInstance) {
		log.debug("saving Researcher instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Researcher persistentInstance) {
		log.debug("deleting Researcher instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Researcher findById(java.lang.Integer id) {
		log.debug("getting Researcher instance with id: " + id);
		try {
			Researcher instance = (Researcher) getHibernateTemplate().get(
					"domain.Researcher", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Researcher instance) {
		log.debug("finding Researcher instance by example");
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
		log.debug("finding Researcher instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Researcher as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Researcher instances");
		try {
			String queryString = "from Researcher";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Researcher merge(Researcher detachedInstance) {
		log.debug("merging Researcher instance");
		try {
			Researcher result = (Researcher) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Researcher instance) {
		log.debug("attaching dirty Researcher instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Researcher instance) {
		log.debug("attaching clean Researcher instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ResearcherDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ResearcherDAO) ctx.getBean("ResearcherDAO");
	}
}