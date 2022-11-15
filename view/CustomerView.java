package view;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;

// import com.mysql.jdbc.ResultSet;
// import com.mysql.jdbc.Statement;

import controller.CustomerController;
import model.Customer;

public class CustomerView {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        int ch;
        do {
            System.out.println("\n ***Banking System Application***");
            System.out.println(
                    "1. Create Account in SCB \n 2. Edit by Account number\n 3. Deposit the amount \n 4. Withdraw the amount \n 5.Check Balance \n 6.Exit ");
            System.out.println("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                // create account
                case 1:
                    System.out.println("You have selected to create account in SCB");
                    System.out.println("Enter fname : ");
                    String custFname = sc.next();
                    System.out.println("Enter lname : ");
                    String custLname = sc.next();
                    System.out.println("Enter gender(M/F) : ");
                    char gender = sc.next().charAt(0);

                    System.out.println("Enter phone : ");
                    String phoneNo = sc.next();
                    System.out.println("Enter address : ");
                    String address = sc.next();
                    System.out.println("Enter username : ");
                    String username = sc.next();
                    System.out.println("Enter password : ");
                    String password = sc.next();
                    System.out.println("choose type of account(1.saving" +
                            " 2.fixed)");
                    int accType = sc.nextInt();
                    // Create customer object and pass to CUSTOMER CONTROLLER
                    Customer customer = new Customer(custFname, custLname, gender, phoneNo, address, username, password,
                            accType, 0);
                    // Create customer controller object and pass customer object
                    CustomerController controller = new CustomerController();
                    int insert = controller.registerAcc(customer);
                    // insert == 1 : Sucessfully inserted
                    // insert == 0 : Error while inserting record
                    if (insert > 0) {
                        System.out.println("Customer added successfully");
                    } 
                    else {
                        System.out.println("Error registering customer");
                    }

                    sc.close();
                    break;

                // edit the Account details
                case 2:
                    try {
                        System.out.println("enter your account number:");
                        int accNum = sc.nextInt();
                        System.out.println("enter your first name:");
                        String fName = sc.next();

                        System.out.println("enter your last name:");
                        String lName = sc.next();
                        System.out.println("enter your address:");
                        String Address = sc.next();
                        System.out.println("enter your phone number:");
                        String phNumber = sc.next();
                        System.out.println("choose type of account(1.saving" +
                                "2.fixed)");
                        int accTypeId = sc.nextInt();

                        Customer customer1= new Customer(accNum, fName, lName, Address, phNumber, accTypeId);
                        controller = new CustomerController();
                        insert = controller.updateAccount(customer1);

                        if (insert > 0) {
                            System.out.println("account updated successfully");

                        } else {
                            System.out.println("account update failed");
                        }
                    } catch (Exception e) {
                        System.out.println(
                                " ERR : Enter Valid Data::Insertion Failed!\n");
                    }
                    sc.close();
                    break;
                // Deposit the amount in the account
                case 3:
                    try {
                        System.out.println("enter your account number");
                        int accNum = sc.nextInt();
                        System.out.println("enter the deposite amount");
                        int balance = sc.nextInt();
                        Customer customer1 = new Customer(accNum, balance);
                        controller = new CustomerController();
                        insert = controller.depo(customer1);
                        if (insert > 0) {
                            System.out.println("account Depost successfully");

                        } else {
                            System.out.println("account Depost failed");
                        }
                    } catch (Exception e) {
                        System.out.println(
                                " ERR : Enter Valid Data::Insertion Failed!\n");
                    }
                    sc.close();
                    break;

                // Withdraw the amount from the account

                case 4:
                try{
                System.out.println("enter your account number");
                int accNum = sc.nextInt();
                System.out.println("enter the Withdraw amount");
                int balance = sc.nextInt();
                Customer customer1 = new Customer(accNum, balance);
                controller = new CustomerController();
                insert = controller.WithDraaw(customer1);
                if (insert > 0) {
                    System.out.println("account withdraw successfully");

                } else {
                    System.out.println("account withdraw failed");
                }
            } catch (Exception e) {
                System.out.println(
                        " ERR : Enter Valid Data::Insertion Failed!\n");
            }
            sc.close();
            break;

// Working checking balance for resultset and printing the resultset using while loop
                case 5:
                try{
                    System.out.println("Enter account number to check balance");
                    int acc = sc.nextInt();
                    customer = new Customer(acc);
                    // Create customer controller5 object and pass customer object
                    controller = new CustomerController();
                    ResultSet rs = controller.checkBalance(customer);
			        while (rs.next()) {
				    Integer bal = rs.getInt(1);
				    System.out.println("balance is: " + bal);
                    }
                    rs.close();
                    } catch (Exception e) {
                    e.printStackTrace();
                    }
                    sc.close();
                    break;

                    case 11:
                    try{
                        System.out.println("Enter account number to check balance");
                        int acc = sc.nextInt();
                        customer = new Customer(acc);
                        // Create customer controller5 object and pass customer object
                        controller = new CustomerController();
                        ResultSet rs = controller.Checkbal(customer);
                        while (rs.next()) {
                        Integer bal = rs.getInt(1);
                        System.out.println("balance is: " + bal);
                        }
                        rs.close();
                        } catch (Exception e) {
                        e.printStackTrace();
                        }
                        sc.close();
                        break;

                   
                   
                case 6:
                    System.out.println("See you soon...");
                    sc.close();
                    break;

                }
        } 
        while (ch != 5);
    }
    }
// }
    
 