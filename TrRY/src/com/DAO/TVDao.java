package com.DAO;

import java.util.List;

import com.BEAN.TVSeries;


public interface TVDao {

	public void saveOrUpdateTV(TVSeries TV);
	public List<TVSeries> listTV();
	public TVSeries listTVById(Long TVId);
	public void deleteTV(Long TVId);
}
