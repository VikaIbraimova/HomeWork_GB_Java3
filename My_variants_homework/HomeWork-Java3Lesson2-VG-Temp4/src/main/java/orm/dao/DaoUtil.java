package orm.dao;

/**
 * Created by vika on 22.07.16.
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoUtil {
    /**
     * Перед созданием таблицы, удаляе старую
     * @param conn
     */
    public static void clearTableMAMBA_CATALOG (Connection conn) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "DROP TABLE IF EXISTS MAMBA_CATALOG ";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void createScheme(Connection conn){
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS MAMBA_CATALOG " +
                    "(ID    INT     PRIMARY KEY     NOT NULL, " +
                    "NAME   TEXT                    NOT NULL, " +
                    "SEX1   INT                    NOT NULL, " +
                    "SEX2   TEXT                    NOT NULL, " +
                    "AGE    INT                     NOT NULL)";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void clearTableBOY_CATALOG (Connection conn) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "DROP TABLE IF EXISTS BOY_CATALOG ";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Создание таблицы Boy
    public static void createScheme2(Connection conn){
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS BOY_CATALOG " +
                    "(ID    INT     PRIMARY KEY     NOT NULL, " +
                    "NAME   TEXT                    NOT NULL, " +
                    "SEX1   INT                    NOT NULL, " +
                    "SEX2   TEXT                    NOT NULL, " +
                    "AGE    INT                     NOT NULL)";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void clearTableGIRL_CATALOG (Connection conn) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "DROP TABLE IF EXISTS GIRL_CATALOG ";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Создание таблицы Girl
    public static void createScheme3(Connection conn){
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS GIRL_CATALOG " +
                    "(ID    INT     PRIMARY KEY     NOT NULL, " +
                    "NAME   TEXT                    NOT NULL, " +
                    "SEX1    INT                    NOT NULL, " +
                    "SEX2    TEXT                    NOT NULL, " +
                    "AGE    INT                     NOT NULL)";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}