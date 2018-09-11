package service;

import java.sql.Connection;

import common.util.DBConn;

public class DAO {

	static final Connection CONN = DBConn.getconnection();
}
