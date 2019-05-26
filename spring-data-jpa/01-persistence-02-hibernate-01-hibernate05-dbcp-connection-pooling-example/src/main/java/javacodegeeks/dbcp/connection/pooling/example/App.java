package javacodegeeks.dbcp.connection.pooling.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.h2.engine.Database;

import javacodegeeks.dbcp.connection.pooling.example.util.DataBaseUtility;

/**
 * Hello world!
 *
 */
public class App {

	public static String SQL = "SELECT * FROM ACCOUNT ";

	public static void main(String[] args) throws SQLException {
		BasicDataSource dataSource = DataBaseUtility.getBasicDataSsource();
		Connection connection = dataSource.getConnection();
		PreparedStatement statement = connection.prepareStatement(SQL);
		try {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + ", " + resultSet.getString(2) + ", " + resultSet.getString(3));
			}
		} catch (Exception e) {
			connection.rollback();
			
		}

		connection.close();
	}
}
