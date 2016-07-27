package orm.dao;

import java.util.List;

/**
 * Created by vika on 22.07.16.
 */
public interface IGenericDao<T> {
    void save(T man);
    void remove(T man);
    void update(T man);
    T findById(int id);
    List<T> getAll();
}