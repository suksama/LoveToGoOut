package com.ltgo.dao;

import java.util.List;

import com.ltgo.model.Notes;
import com.ltgo.model.Place;
import com.ltgo.model.PlaceView;
import com.ltgo.model.User;

public interface UserDao {
	int  save(User user);
	boolean isSccuess(User user);
	int savenotes(Notes note);
	List<PlaceView> getplace();
	int deleteTourist(int id);
	List<PlaceView> showplace(int id);
	int addplace(String p_Name,String p_Ename,String p_Text,String c_Name);
}
