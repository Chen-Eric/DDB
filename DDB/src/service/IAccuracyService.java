/**
 * 
 */
package service;

import java.util.List;

import domain.Accuracy;

/**
 * @author Chen
 *
 */
public interface IAccuracyService {
	
	
	public List<Accuracy> listAllAccuracies();
	
	public List<Accuracy> listAccuracyByRowsPerPage(int page, int rowsPerPage);
	
	public Accuracy findAccuracyByName(String accuracyName);
	
	public Accuracy findAccuracyByID(int accuracyID);
	
	
}
