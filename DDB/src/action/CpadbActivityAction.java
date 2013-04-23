package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import domain.CpadbActivity;

public class CpadbActivityAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6063601471012305782L;
	private List lmh;
	private List<CpadbActivity> lca;
	private InputStream inputStream;
	private String majorHeading;

	public String showAllMajorHeadings() throws UnsupportedEncodingException {

		lmh = cpadbActivityService.listMajorHeadings();

		String s = "<select'>";
		s += "<option>--Select MajorHeading--</option>";
		for (Object mh : lmh) {
			s += "<option value='" + mh.toString() + "'>" + mh.toString() + "</option>";
		}
		s += "</select>";

		inputStream = new ByteArrayInputStream(s.getBytes("UTF-8"));

		return SUCCESS;
	}

	public String showSelectSpecificActivities() throws UnsupportedEncodingException {

		lca = cpadbActivityService.fingByMajorHeading(majorHeading);

		String s = "<select'>";
		s += "<option>--Select Activity--</option>";
		for (CpadbActivity ca : lca) {
			s += "<option value='" + ca.getCpadbSpecificActivity() + "' id='" + ca.getId() + "'>"
					+ ca.getCpadbSpecificActivity() + "</option>";
		}
		s += "</select>";

		inputStream = new ByteArrayInputStream(s.getBytes("UTF-8"));

		return SUCCESS;
	}

	public List getLmh() {
		return lmh;
	}

	public void setLmh(List lmh) {
		this.lmh = lmh;
	}

	public List<CpadbActivity> getLca() {
		return lca;
	}

	public void setLca(List<CpadbActivity> lca) {
		this.lca = lca;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getMajorHeading() {
		return majorHeading;
	}

	public void setMajorHeading(String majorHeading) {
		this.majorHeading = majorHeading;
	}
}
