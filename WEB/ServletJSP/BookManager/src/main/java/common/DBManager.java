package common;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Tomcat이 관리하는 Connection Pool (DataSource) 에서 connection 객체를 얻고 반납
public class DBManager {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/madangdb"); // Connection Pool
            con = ds.getConnection();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void releaseConnection(PreparedStatement pstmt, Connection con) {
        try {
            pstmt.close();
            con.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void releaseConnection(ResultSet rs, PreparedStatement pstmt, Connection con) {
        try {
            rs.close();
            pstmt.close();
            con.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
