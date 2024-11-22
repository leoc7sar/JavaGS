package br.com.fiap.test;

import java.sql.Connection;

import br.com.fiap.dao.ConnectionFactory;

public class TestConnection {
    public static void main(String[] args) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            if (connection != null) {
                System.out.println("Conexão estabelecida com sucesso!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
