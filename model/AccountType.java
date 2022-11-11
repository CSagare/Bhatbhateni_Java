package model;

// import javax.print.DocFlavor.STRING;

public class AccountType {
    private int accTypeId;
    private String accType;


    public void setAccTypeId( int accTypeId){
        this.accTypeId=accTypeId;
    }
    public int getAccTypeId() {
        return accTypeId;
    }

    public void setAccType( String accType){
        this.accType=accType;
    }

    public String getAccType() {
        return accType;
    }


    // public AccountType(int custId,int accNum,int balance ){
    //     this.custId=custId;
    //     this.accNum=accNum;
    //     this.accTypeId=balance;
    // }
    public AccountType(int accTypeId, String accType){
        this.accType=accType;
        this.accType=accType;
    }

}
