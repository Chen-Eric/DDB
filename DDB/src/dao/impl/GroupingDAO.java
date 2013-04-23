package dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.Grouping;
import domain.GroupingId;

/**
 * A data access object (DAO) providing persistence and search support for Grouping entities. Transaction control of the save(), update() and delete() operations can directly support Spring container-managed transactions or they can be augmented to handle user-managed Spring transactions. Each of these methods provides additional information for how to configure it for the desired type of transaction control.
 * 
 * @see domain.Grouping
 * @author MyEclipse Persistence Tools
 */
public class GroupingDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(GroupingDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Grouping transientInstance) {
		log.debug("saving Grouping instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Grouping persistentInstance) {
		log.debug("deleting Grouping instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Grouping findById(domain.GroupingId id) {
		log.debug("getting Grouping instance with id: " + id);
		try {
			Grouping instance = (Grouping) getHibernateTemplate().get(
					"domain.Grouping", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Grouping instance) {
		log.debug("finding Grouping instance by example");
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
		log.debug("finding Grouping instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Grouping as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Grouping instances");
		try {
			String queryString = "from Grouping";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Grouping merge(Grouping detachedInstance) {
		log.debug("merging Grouping instance");
		try {
			Grouping result = (Grouping) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Grouping instance) {
		log.debug("attaching dirty Grouping instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Grouping instance) {
		log.debug("attaching clean Grouping instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static GroupingDAO getFromApplicationContext(ApplicationContext ctx) {
		return (GroupingDAO) ctx.getBean("GroupingDAO");
	}
}