package backup;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.Food;
import domain.FoodId;
import domain.Meal;

/**
 * A data access object (DAO) providing persistence and search support for Food entities. Transaction control of the save(), update() and delete() operations can directly support Spring container-managed transactions or they can be augmented to handle user-managed Spring transactions. Each of these methods provides additional information for how to configure it for the desired type of transaction control.
 * 
 * @see domain.Food
 * @author MyEclipse Persistence Tools
 */
public class FoodDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(FoodDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Food transientInstance) {
		log.debug("saving Food instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Food persistentInstance) {
		log.debug("deleting Food instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Food findById(domain.FoodId id) {
		log.debug("getting Food instance with id: " + id);
		try {
			Food instance = (Food) getHibernateTemplate()
					.get("domain.Food", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Food> findByID(int subjectID, int fdID, int mealID){
		String queryString = "from domain.Food as f where f.id.mealFoodDiarySubjectId = ? and f.id.mealFoodDiaryId =? and f.id.mealId =?";
		org.hibernate.Query query = this.getSession().createQuery(queryString);
		query.setParameter(0, subjectID);
		query.setParameter(1, fdID);
		query.setParameter(2, mealID);
		return query.list();
	}
	
	public List findByExample(Food instance) {
		log.debug("finding Food instance by example");
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
		log.debug("finding Food instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Food as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Food instances");
		try {
			String queryString = "from Food";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List<Food> findByPage(int subjectID, int fdID, int mealID, int page, int pageSize){
		
		List<Food> lf = null;
		Session session = this.getSession();
		
		try {
			session.beginTransaction();
			String sql = "from domain.Food as f where f.id.mealFoodDiarySubjectId = ? and f.id.mealFoodDiaryId =? and f.id.mealId =?";
			Query query = session.createQuery(sql).setFirstResult((page - 1) * pageSize).setMaxResults(pageSize);
			query.setParameter(0, subjectID);
			query.setParameter(1, fdID);
			query.setParameter(2, mealID);
			lf = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

		return lf;

	}

	public Food merge(Food detachedInstance) {
		log.debug("merging Food instance");
		try {
			Food result = (Food) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Food instance) {
		log.debug("attaching dirty Food instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Food instance) {
		log.debug("attaching clean Food instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FoodDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FoodDAO) ctx.getBean("FoodDAO");
	}
}