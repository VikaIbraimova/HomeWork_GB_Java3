package orm.dao;

import java.util.List;
import java.util.Set;

/**
 * Created by Vladislav Gasanov on 13.07.2016.
 */
public interface IGenericDao<T> {
    void save(T man);
    void remove(T man);
    void update(T man);
    T findById(int id);
    List<T> getAll();
    Set<T> findBySex(String sex);
}
