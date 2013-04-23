package service.impl;

import java.util.List;

import dao.impl.CpadbActivityDAO;

import service.ICpadbActivityService;

public class CpadbActivityService implements ICpadbActivityService {

	private CpadbActivityDAO cpadbActivityDAO;
	
	public CpadbActivityDAO getCpadbActivityDAO() {
		return cpadbActivityDAO;
	}

	public void setCpadbActivityDAO(CpadbActivityDAO cpadbActivityDAO) {
		this.cpadbActivityDAO = cpadbActivityDAO;
	}

	@Override
	public List listMajorHeadings() {
		return cpadbActivityDAO.listMajorHeadings();
	}

	@Override
	public List findByProperty(String property, String value) {
		return cpadbActivityDAO.findByProperty(property, property);
	}

	@Override
	public List fingByMajorHeading(String majorHeading) {
		return cpadbActivityDAO.findByProperty("cpadbMajorHeading", majorHeading);
	}

}
