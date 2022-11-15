package database;

import java.sql.*;

import com.mysql.cj.xdevapi.PreparableStatement;

public class DbConnection {

   public Connection con;
    Statement st;
    Statement stmt;
    ResultSet rows;
    PreparedStatement ps;
    int val;

    public DbConnection() {
        // register the driver class
        try {
            String username = "root";
            String password = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            // create the connection object
            // Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhatbhateni", username, password);
            if (con != null) {
                System.out.println("Connected to Database");
            } else {
                System.out.println("Error connecting Database");
            }

            // creating statement object
            st = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Simple query for insert update and delete
    public int insert(String query) {
        try {
            val = st.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return val;
    }

    public int insert(PreparedStatement st) {
        try {
            val = st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return val;
    }
 

    // Function for select statement
    public ResultSet select(String query) {
        try {
            rows = st.executeQuery(query);
           
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }

    public ResultSet select(PreparedStatement st2) {
        return null;
    }

    

    // public PreparableStatement PrepSelect(String query) {
    //     return null;
    // }

//     public static void main(String[] args) {
//         new DbConnection();
//     }
}
