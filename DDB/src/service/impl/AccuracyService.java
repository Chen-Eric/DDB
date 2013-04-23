/**
 * 
 */
package service.impl;

import java.util.List;

import dao.impl.AccuracyDAO;
import domain.Accuracy;
import service.IAccuracyService;

/**
 * @author Chen
 *
 */
public class AccuracyService implements IAccuracyService {

	private AccuracyDAO accuracyDAO;
	
	public AccuracyDAO getAccuracyDAO() {
		return accuracyDAO;
	}

	public void setAccuracyDAO(AccuracyDAO accuracyDAO) {
		this.accuracyDAO = accuracyDAO;
	}

	/* (non-Javadoc)
	 * @see service.IAccuracyService#listAllAccuracies()
	 */
	@Override
	public List<Accuracy> listAllAccuracies() {
		return accuracyDAO.findAll();
	}
	
	/* (non-Javadoc)
	 * @see service.IAccuracyService#findAccuracyByName()
	 */
	@Override
	public Accuracy findAccuracyByName(String accuracyName) {
		return (Accuracy) accuracyDAO.findByProperty("name", accuracyName).get(0);
	}

	/* (non-Javadoc)
	 * @see service.IAccuracyService#findAccuracyByID()
	 */
	@Override
	public Accuracy findAccuracyByID(int accuracyID) {
		Accuracy accuracy = new Accuracy();
		accuracy.setId(accuracyID);
		return (Accuracy) accuracyDAO.findByExample(accuracy);
	}

	@Override
	public List<Accuracy> listAccuracyByRowsPerPage(int page, int pageSize) {
		return this.accuracyDAO.findByPage(page, pageSize);
	}

	

}
