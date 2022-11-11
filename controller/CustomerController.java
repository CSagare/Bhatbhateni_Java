package controller;

import java.sql.ResultSet;

import database.DbConnection;
import model.Customer;

public class CustomerController {
    
    DbConnection db;

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
