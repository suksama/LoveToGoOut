package com.ltgo.dao;

import java.util.List;

import com.ltgo.model.PlacePage;
import com.ltgo.model.PlacePrice;

public interface PageDao {
	int getPage(int pageSize,String searchcontent);
	PlacePage getPlaceBypage(int currentPage,int pageSize,String searchcontent);
	List<PlacePrice> showprice();
}
