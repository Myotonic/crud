package com.crud.requestdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.crud.dbmanager.DBManager;

public class ViewDao {
	DBManager db;
	Connection conn;
	PreparedStatement pstm;
	ResultSet rset;
	
	public ViewDao() {
		db = new DBManager();
		conn = db.getConnection();
	}
	
	
	
}
