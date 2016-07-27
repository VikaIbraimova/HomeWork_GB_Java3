package orm.dao;

import com.sun.istack.internal.Nullable;
import orm.Boy;
import orm.Girl;
import orm.Man;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vika on 22.07.16.
 */
public class ManDaoImpl implements IGenericDao<Man> {
    private Connection conn;

    public ManDaoImpl(Connection conn) {
        this.conn = conn;
    }

    public void save(Man man) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO MAMBA_CATALOG (ID,NAME,SEX1,SEX2,AGE) " +
                    //String sql = "INSERT INTO MAMBA_CATALOG (NAME,AGE) " +
                    "VALUES(" + man.getUid() + ", '" + man.getName() +"', " + man.getSex1() + ",'" + man.getSex2() + "'," + man.getAge() + " )";
            //"VALUES('" + man.getName() +"', " + man.getAge() + " )";
            //FIXME: сделать сохранение информации о классе ( девочка или мальчик )
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
            String sql = "UPDATE MAMBA_CATALOG SET NAME='" + man.getName()+"',SEX1=" + man.getSex1()+ ",SEX2='" + man.getSex2()+"', AGE=" + man.getAge() + " WHERE ID=" + man.getUid() ;
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public @Nullable
    Man findById(int id) {
        Man man = null;
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM MAMBA_CATALOG WHERE ID=" + id;
            //FIXME: сделать сохранение информации о классе ( девочка или мальчик )
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.getInt("sex1") > 0){
                man = new Boy(rs.getInt("id"), rs.getString("name"),rs.getInt("sex1"),rs.getString("sex2"),rs.getInt("age"));
            }else {
                man = new Girl(rs.getInt("id"), rs.getString("name"),rs.getInt("sex1"),rs.getString("sex2"),rs.getInt("age"));
            }
          /*  man = new Man(rs.getInt("id"),rs.getSex("sex"), rs.getString("name"), rs.getInt("age")) {
                @Override
                public boolean think() {
                    return false;
                }
            };*/
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return man;
        //return null;
    }

    public List<Man> getAll() {
        List<Man> people = new ArrayList<Man>();
        Man man = null;
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM MAMBA_CATALOG";
            //FIXME: сделать сохранение информации о классе ( девочка или мальчик )
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
              /*  Man man = new Man(rs.getInt("id"),rs.getSex("sex"), rs.getString("name"), rs.getInt("age")) {
                    @Override
                    public boolean think() {
                        return false;
                    }
                };*/
                if (rs.getInt("sex1") > 0){
                    man = new Boy(rs.getInt("id"), rs.getString("name"),rs.getInt("sex1"),rs.getString("sex2"),rs.getInt("age"));
                }else {
                    man = new Girl(rs.getInt("id"), rs.getString("name"),rs.getInt("sex1"),rs.getString("sex2"),rs.getInt("age"));
                }
                people.add(man);
            }
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return people;
        //return null;
    }
}
