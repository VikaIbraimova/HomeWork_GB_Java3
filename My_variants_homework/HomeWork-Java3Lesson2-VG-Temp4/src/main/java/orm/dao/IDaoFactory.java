package orm.dao;

import orm.Man;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by vika on 22.07.16.
 */
public interface IDaoFactory {
    Connection getConnection() throws SQLException;
    <T extends Man> IGenericDao<T> getManDao(Connection conn);
}