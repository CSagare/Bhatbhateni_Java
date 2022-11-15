package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

import database.DbConnection;
import database.DbConnection;
import model.Customer;

public class CustomerController {
    
    DbConnection db;
 
                 //  PreapaedStatement st use for insert update and delete  
  public int registerAcc(Customer customer) throws SQLException{
    try {
      
      String query;
      query = "insert into Customer(custFname,custLname,gender,phoneNo,address,username,password,accType,balance) values(?,?,?,?,?,?,?,?,?)" ;
      db = new DbConnection();
        
      PreparedStatement st=db.con.prepareStatement(query);
        st.setString(1,customer.getCustFname()); 
        st.setString(2,customer.getCustLname());  
        st.setString(3,String.valueOf(customer.getGender())); 
        st.setString(4,customer.getPhoneNo());
        st.setString(5,customer.getAddress());
        st.setString(6,customer.getUsername());
        st.setString(7,customer.getPassword());
        st.setLong(8,customer.getAccTypeId()); 
        st.setLong(9,customer.getbalance());
        return db.insert(st);
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
        return 0;
      }
}


    public int depo(Customer customer){
      try {
      String query="update Customer"+
      " set balance=balance+"+"?"+" where AccID="+"?"+";";
      db = new DbConnection();

        PreparedStatement st=db.con.prepareStatement(query);
        st.setInt(1,customer.getCustId());
        st.setInt(2,customer.getbalance());
        
        return db.insert(st);
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return 0;
      }
      }  

      public int WithDraaw(Customer customer){
        try {
        String query="update Customer"+
        " set balance=balance-"+"?"+" where AccID="+"?"+";";
         db = new DbConnection();
          PreparedStatement st=db.con.prepareStatement(query);
          st.setInt(1,customer.getCustId());
          st.setInt(2,customer.getbalance());
          
          return db.insert(st);
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          return 0;
        }
        }  
  
        
      public ResultSet Checkbal(Customer customer){
        try {
         String query="select balance from Customer WHERE accID="+"?"+";";
         db = new DbConnection();
          PreparedStatement st=db.con.prepareStatement(query);
          st.setInt(1,customer.getCustId());
          ResultSet myRs = st.executeQuery();

          // st.get(2,customer.getbalance());

          // db.insert(st);
        // return db.select(query);
        return myRs;

          
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        return null;
        
        }  















    
    public int registerCustomer(Customer customer){
      String query;
      query = "insert into Customer(custFname,custLname,gender,phoneNo,address,username,password,accType,balance) values('" + 
          customer.getCustFname() + "','" + 
          customer.getCustLname() + "','" + 
          customer.getGender() + "','" +
          customer.getPhoneNo() + "','" +
          customer.getAddress() + "','" +
          customer.getUsername() + "','" +
          customer.getPassword() + "','" +
          customer.getAccTypeId() + "','" +
          customer.getbalance() + "');" ;
      db = new DbConnection();
      return db.insert(query);

  }  


public int updateAccount(Customer customer1){
    String query;
    // "UPDATE Registration " +
    query="update Customer"+
          " set custFname='"+customer1.getCustFname()+"',"+
            " custLname='"+customer1.getCustLname()+"',"+
            " address='"+customer1.getAddress()+"',"+
            " phoneNo='"+customer1.getPhoneNo()+"',"+
            " accType='"+customer1.getAccTypeId()+ "'"+
            " where AccID='"+customer1.getCustId()+"';";

    db=new DbConnection();
    return db.insert(query);
  }

  public int depositBalance(Customer customer){
    String query;
    // "UPDATE Registration " +
    query="update Customer"+
    " set balance=balance+"+customer.getbalance()+
            " where AccID='"+customer.getCustId()+"';";
    // query="select accNum,balance from customer "+
    db=new DbConnection(); 
  
    return db.insert(query);
  }


  public int withdraw(Customer customer){
    String query;
    // query="update Customer"+
    // " set balance=balance-"+customer.getbalance()+
    //         " where AccID='"+customer.getCustId()+"';";

            query="update Customer"+
    " set balance=balance-"+customer.getbalance()+
            " where AccID='"+customer.getCustId()+"';";
    // query="select accNum,balance from Customer "+
    // customer.getbalance()+";";


    db=new DbConnection();
    return db.insert(query);
  }
  public ResultSet checkBalance(Customer customer){
    String query;
    query="select balance from Customer WHERE accID='"+
    customer.getCustId()+"';";


    db=new DbConnection();
return db.select(query);
  }
}
