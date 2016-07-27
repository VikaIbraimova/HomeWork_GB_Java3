package orm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sun.istack.internal.Nullable;
import orm.Man;
/**
 * Created by Vladislav Gasanov on 13.07.2016.
 */
public class ManDaoImpl implements IGenericDao<Man> {
    private Connection conn;

    public ManDaoImpl(Connection conn) {
        this.conn = conn;
    }

    public void save(Man man) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO MAMBA_CATALOG (SEX,NAME,AGE) " +
                    "VALUES('" + man.getSex() + "', '" + man.getName() +"', " + man.getAge() + " )";
            //FIXMED: сделать сохранение информации о классе ( девочка или мальчик )
            //added: SEX column, AUTOINCREMENT, findBySex method.
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(Man man) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM MAMBA_CATALOG WHERE ID=" + man.getUid() ;
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Man man) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE MAMBA_CATALOG SET SEX='" + man.getSex() +"', NAME='" + man.getName()+"', AGE=" + man.getAge() + " WHERE ID=" + man.getUid() ;
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Set<Man> findBySex(String sex) {
        Set<Man> manSet = new HashSet<>();
        try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM MAMBA_CATALOG WHERE SEX='" + sex+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                manSet.add(new Man(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getString("sex")) {
                    @Override
                    public boolean think() {
                        return false;
                    }
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manSet;
    }

    public @Nullable Man findById(int id) {
        Man man = null;
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM MAMBA_CATALOG WHERE ID=" + id;

            ResultSet rs = stmt.executeQuery(sql);
            man = new Man(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("sex")) {
                @Override
                public boolean think() {
                    return false;
                }
            };
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return man;
    }

    public List<Man> getAll() {
        List<Man> people = new ArrayList<Man>();
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM MAMBA_CATALOG";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Man man = new Man(rs.getInt("ID"), rs.getString("name"), rs.getInt("age"), rs.getString("sex")) {
                    @Override
                    public boolean think() {
                        return false;
                    }
                };
                people.add(man);
            }
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return people;
    }
}
