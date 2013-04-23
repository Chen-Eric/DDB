/**
 * 
 */
package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import domain.Accuracy;

/**
 * @author Chen
 * 
 */
public class AccuracyAction extends BaseAction {

	private List<Accuracy> la;
	private InputStream inputStream;

	public List<Accuracy> getLa() {
		return la;
	}

	public void setLa(List<Accuracy> la) {
		this.la = la;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	/**
	 * @serial generated
	 */
	private static final long serialVersionUID = -5956678183588943313L;

	public String showAllAccuracies() throws UnsupportedEncodingException {

		// old school, by using struts action as a trigger to load all data into session.
		la = accuracyService.listAllAccuracies();
		System.out.println("How many kinds of Accuracy:" + la.size());
		 String s = "<select>";
		 for (Accuracy a : la) {
		 s += "<option value='" + a.getId() + "'>" + a.getName() + "</option>";
		 }
		 s += "</select>";
		 inputStream = new ByteArrayInputStream(s.getBytes("UTF-8"));;


		return SUCCESS;
	}

}
