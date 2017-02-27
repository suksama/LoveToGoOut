package com.ltgo.dao;

import java.util.List;

import com.ltgo.model.PlacePrice;

public interface PriceDao {
	List<PlacePrice> showprice(String p_Name);
	PlacePrice toupdate (String pp_WebName);
}
