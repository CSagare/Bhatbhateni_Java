package model;
public class Customer {

    private int accTypeId;
    private String accType;

    
    

    // 
    private int custId;
    private int accID;
    private String custFname;
    private String custLname;
    private char gender;
    private String phoneNo;
    private String  address;
    private String username;
    private String password;
    private int balance;
    // private int accNum;

    //1..for register
    public Customer(String custFname,String custLname,char gender,String phoneNo,String address,String username,String password,int accTypeId,int balance){
        this.custFname = custFname;
        this.custLname = custLname;         
        this.gender  = gender;
        this.phoneNo = phoneNo;
        this.address = address;
        this.username = username;
        this.password = password;
        this.accTypeId=accTypeId;
        this.balance=balance;
    
    }

    // public Customer(int custId,String custFname,String custLname,String dob ,char gender,String phoneNo,String address,String username,String password){
    //     this.custId = custId;
    //     this.custFname = custFname;
    //     this.custLname = custLname;
    //     this.gender  = gender;
    //     this.phoneNo = phoneNo;
    //     this.address = address;                        
    //     this.username = username;
    //     this.password = password;
    // }

    //2..... edit ko lagi 
    public Customer(int accNum, String fName, String lName, String address2, String phNumber, int accTypeId) {
        this.custId=accNum;
        this.custFname = fName;
        this.custLname = lName;
        this.address = address2;                       
        this.phoneNo = phNumber;
        this.accTypeId= accTypeId;
    }


    public Customer(int custId){
        this.custId=custId;
    }





    public Customer(int accNum, int balance) {
        this.custId=accNum;
        this.balance=balance;
    }


    

    public int getCustId() {
        return custId;
    }

   
    public void setCustId(int custId) {
        this.custId = custId;
    }

   
    public String getCustFname() {
        return custFname;
    }

   
    public void setCustFname(String custFname) {
        this.custFname = custFname;
    }

   
    public String getCustLname() {
        return custLname;
    }

    public void setCustLname(String custLname) {
        this.custLname = custLname;
    }
   
   
    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

   
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

  
    public String getAddress() {
        return address;
    }

   
    public void setAddress(String address) {
        this.address = address;
    }

    
        public String getUsername() {
            return username;
    }

    
    public void setUsername(String username) {
            this.username = username;
     }

  
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setAccNum(int accID) {
        this.accID=accID;    

    }
    public int getAccNum() {
        return accID;
    }
    public void setBalance(int balance) {
        this.balance=balance;
    }
    public int getbalance() {
        return balance;
    }

    
    public void setAccTypeId(int accTypeId) {
        this.accTypeId=accTypeId; 
    }
        
        public int getAccTypeId(){
            return accTypeId;
        }
        
}
