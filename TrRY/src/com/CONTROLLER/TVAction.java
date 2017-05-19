package com.CONTROLLER;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.BEAN.TVSeries;
import com.DAO.TVDao;
import com.DAO.DaoRun;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class TVAction extends ActionSupport implements ModelDriven<TVSeries> {

	private static final long serialVersionUID = -6659925652584240539L;

	private TVSeries tv = new TVSeries();
	private List<TVSeries> TVList = new ArrayList<TVSeries>();
	private TVDao tvDAO = new DaoRun();
	
	@Override
	public TVSeries getModel() {
		return tv;
	}
	
	/**
	 * To save or update tv.
	 * @return String
	 */
	public String saveOrUpdate()
	{	
		tvDAO.saveOrUpdateTV(tv);
		return SUCCESS;
	}
	
	/**
	 * To list all TVs.
	 * @return String
	 */
	public String list()
	{
		TVList = tvDAO.listTV();
		return SUCCESS;
	}
	
	/**
	 * To delete a tv.
	 * @return String
	 */
	public String delete()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		tvDAO.deleteTV(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	/**
	 * To list a single tv by Id.
	 * @return String
	 */
	public String edit()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		tv = tvDAO.listTVById(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public TVSeries getTV() {
		return tv;
	}

	public void setTV(TVSeries tv) {
		this.tv = tv;
	}

	public List<TVSeries> getTVList() {
		return TVList;
	}

	public void setTVList(List<TVSeries> TVList) {
		this.TVList = TVList;
	}

}
