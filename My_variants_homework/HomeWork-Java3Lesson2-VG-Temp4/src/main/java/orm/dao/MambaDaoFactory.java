package orm.dao;

import orm.Man;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by vika on 22.07.16.
 */
public class MambaDaoFactory implements IDaoFactory {
    private final String URL = "jdbc:sqlite:database.db";
    private final String DRIVER = "org.sqlite.JDBC";

    public MambaDaoFactory() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public <T extends Man> IGenericDao<T> getManDao(Connection conn) {
        return ((IGenericDao<T>) new ManDaoImpl(conn));
    }
}

