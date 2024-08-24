//Created an ATM interface using OOPS concepts. All of the 4 pillars(Abstraction, Encapsulation, Polymorphism and Inheritance) are utilized in this program.

import java.util.Scanner;
abstract class ATMmachine{ //creating abstract class with abstract methods, implementing Abstraction.


abstract void depositAmount();
abstract void withdrawAmount();

}
class userAccount extends ATMmachine{ //Creating child class, implementing Inheritance, Encapsulation and Rumtime Polymorphism through method overriding.

    Scanner sc=new Scanner(System.in);
private double withdraw,deposit;
private double balance=15000;

public void withdrawAmount(){ //method for withdrawing amount.

boolean positiveAmount=true;
while (positiveAmount) { //for checking only positive values
    System.out.print("Please enter withdrawal amount:");
withdraw=sc.nextDouble();
if (withdraw<0){
    System.out.println("Please enter a positive number!");
}
    else if(withdraw>=0){
        positiveAmount=false;
    }
}

if(withdraw<=balance){
    balance-=withdraw;
    System.out.println("An amount of " + withdraw + " has been withdrawn. Remaining balance: " + balance);
    positiveAmount=false;
}
 else if( withdraw > balance){
    System.out.println("Error, insufficent funds!");
}
}
public void depositAmount(){ //method for depositing amount
    boolean positiveDeposit=true;
    while (positiveDeposit) {
System.out.print("Please enter deposit amount:");
deposit=sc.nextDouble();
if(deposit>0){
balance += deposit;
System.out.println("You made a deposit of " + deposit + " your balance now is : " + balance);
positiveDeposit=false;
}
else{
    System.out.println("Error, balance cannot be negative!");
}
}
}
public double getBalance(){ //method for displaying balance.
    return balance;
}
}


public class atmsystem {
    public static void main(String[] args) throws Exception { //exception handling.
        try{
String[]options={"Withdraw amount","Deposit amount","Check your balance"};


Scanner scanner=new Scanner(System.in);
userAccount obj1=new userAccount();

System.out.print("Welcome to Platino bank, please select an option: \n");
for(int index=0; index<options.length;index++){ //displaying all options.
System.out.println(index+1 + " => " + options[index] );
}
int select=scanner.nextInt();
if(select==1){
    obj1.withdrawAmount();
}
else if(select==2){
    obj1.depositAmount();
}
else if(select==3){
    obj1.getBalance();
    System.out.println(obj1.getBalance());
}
else{ //if any other option is selected.
    System.out.println("Error, no such option exists!");
}
scanner.close();
        }
        catch(Exception e){
            System.out.println("Please enter an integer value!");
        }

}
}
    

