package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	// Configurações do banco de dados
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:FIAP"; // Ajuste "XE" ao SID ou serviço do banco
	private static final String USER = "rm558373";
	private static final String PASSWORD = "110206";

	/**
	 * Método para obter uma conexão com o banco de dados
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		try {
			// Carregar o driver JDBC do Oracle
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			throw new SQLException("Driver JDBC do Oracle não encontrado.", e);
		}
	}

	/**
	 * Método para fechar a conexão com o banco de dados
	 * 
	 * @param connection Conexão a ser fechada
	 */
	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println("Erro ao fechar a conexão: " + e.getMessage());
			}
		}
	}
}
