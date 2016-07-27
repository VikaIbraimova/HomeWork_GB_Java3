package orm.dao;

import java.sql.Connection;
import java.sql.SQLException;
import orm.Man;
/**
 * Created by Vladislav Gasanov on 13.07.2016.
 */
public interface IDaoFactory {
    Connection getConnection() throws SQLException;
    <T extends Man> IGenericDao<T> getManDao(Connection conn);
}
