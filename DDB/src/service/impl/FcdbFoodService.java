package service.impl;

import java.util.List;

import dao.impl.FcdbFoodDAO;

import service.IFcdbFoodService;

public class FcdbFoodService implements IFcdbFoodService{

	private FcdbFoodDAO fcdbFoodDAO;
	
	public FcdbFoodDAO getFcdbFoodDAO() {
		return fcdbFoodDAO;
	}

	public void setFcdbFoodDAO(FcdbFoodDAO fcdbFoodDAO) {
		this.fcdbFoodDAO = fcdbFoodDAO;
	}

	@Override
	public List listFoodChapters() {
		return fcdbFoodDAO.listFoodChapters();
	}

	@Override
	public List findByProperty(String property, String value) {
		return fcdbFoodDAO.findByProperty(property, value);
	}

	@Override
	public List fingByChapter(String chapter) {
		return fcdbFoodDAO.findByProperty("fcdbFoodChapter", chapter);
	}

}
