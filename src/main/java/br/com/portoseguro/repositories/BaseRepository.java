package br.com.portoseguro.repositories;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseRepository {

    private static final String DB_URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    protected static final String DB_USER = "rm550907";
    protected static final String DB_PASS = "220493";
    protected Connection getConnection() throws Exception {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}
