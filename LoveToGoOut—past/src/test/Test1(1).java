package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.ltgo.util.DBHelper;

public class Test1 {
	@Test
	public void testInsert() {

		/**
		 * user insert
		 */
		/*
		 * String account = "asd00"; String name = "Ajax"; String password =
		 * "123456"; String male = "男"; String female = "女"; int age = 18;
		 * String pic = "photo3"; String email = "123456789@66.com"; String sql1
		 * = "insert into user values(?,?,?,?,?,?,?,?,?)"; Connection conn =
		 * DBHelper.getConnection(); try { PreparedStatement pst =
		 * conn.prepareStatement(sql1); for (int i = 3; i < 20; i++) { if(i % 2
		 * == 0){ pst.setInt(1, i); pst.setString(2, account+i);
		 * pst.setString(3, name+i); pst.setString(5, male); pst.setInt(6,
		 * age+1); }else{ pst.setInt(1, i); pst.setString(2, account+i);
		 * pst.setString(3, name+i); pst.setString(5, female); pst.setInt(6,
		 * age+2); } pst.setString(4, password); pst.setString(7, pic);
		 * pst.setString(8, email); pst.setString(9, null); pst.executeUpdate();
		 * 
		 * } } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		/**
		 * like insert
		 */

		/*
		 * String sql2 = "insert into ts_like values(?,?,?)"; Connection conn =
		 * DBHelper.getConnection(); try { PreparedStatement pst =
		 * conn.prepareStatement(sql2); for (int i = 14; i < 30; i++) { if (i %
		 * 2 == 0) { pst.setInt(1, i); pst.setInt(2, i -11); pst.setInt(3, 2); }
		 * else { pst.setInt(1, i); pst.setInt(2, i-11); pst.setInt(3, 3); }
		 * pst.executeUpdate();
		 * 
		 * } } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		/**
		 * chat insert
		 */
		/*
		 * String sql3 = "insert into chat values(?,?,?,?,?)";
		 * 
		 * Connection conn = DBHelper.getConnection(); try { PreparedStatement
		 * pst = conn.prepareStatement(sql3); for (int i = 0; i < 10; i++) {
		 * pst.setInt(1, i + 1); pst.setString(2, "评论。。。。。。。。。。。。。" + i);
		 * pst.setDate(3, null); pst.setInt(4, i + 1); if (i % 2 == 0) {
		 * pst.setString(5, String.valueOf(1)); } else { pst.setString(5,
		 * String.valueOf(0)); } pst.executeUpdate();
		 * 
		 * } } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}
}
