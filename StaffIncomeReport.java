//Name : Chong Xhin Han
//Matric num : 271317

import java.util.Scanner;
public class StaffIncomeReport
{
   public static Scanner scan = new Scanner (System.in);
   
   public static void main ( String [] args )
   {
        //input details
        System.out.print("Enter staff's name\t\t\t: ");
        String name = scan.nextLine();
        System.out.print("Enter staff's id\t\t\t: ");
        String id = scan.nextLine();
        System.out.print("Enter staff's income type\t\t: ");
        String incomeType = scan.nextLine();
        System.out.print("Enter staff's income amount (RM)\t: ");
        double amount = scan.nextDouble();
        System.out.print("Enter staff's income tax percentage (%): ");
        double tax = scan.nextDouble();

      Income income = new Income(incomeType , amount , tax);
      Staff staff = new Staff ( name , id, income);
      
      //Display Info
      staff.displayStaffInfo();
      staff.displayIncomeInfo();
   }   
}

class Staff 
{
    private String name;
    private String id;
    double netIncome;
    Income Income;

    Staff (String name, String id ,Income Income) {
        this.name = name;
        this.id = id;
        this.Income = Income;
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public double calculateNetIncome(){
        netIncome = Income.getAmount() - Income.getTotalTax();
        return netIncome;
    }

    public void displayStaffInfo(){
        
        System.out.println ("----------------Staff Info------------------");
        System.out.println ("Staff Name \t: " + name);
        System.out.println("ID \t\t: " + id);
    }

   public void displayIncomeInfo(){
        System.out.println("\n-------------Income Info-----------------");
        System.out.println("Income type : " + Income.getIncomeType());
        System.out.printf("Income amount : RM%.2f%n" , Income.getAmount());
        System.out.println("Income tax percentage : " + Income.getTax() + "%" );
        System.out.printf("Total tax paid : RM%.2f%n" , Income.getTotalTax());
        System.out.printf("Total net income : RM%.2f%n" , calculateNetIncome());
    }

}

class Income
{
    String incomeType ;
    double incomeAmount , incomeTax ;
    double totalTax ;
    
    public Income(String incomeType, double amount, double tax){
       this.incomeType = incomeType;
       this.incomeAmount = amount;
       this.incomeTax = tax;
    }

    public String getIncomeType(){
        return incomeType;
    }

    public double getAmount() {
        return incomeAmount;
    }

    public double getTax() {
        return incomeTax;
    }

    public double getTotalTax() {
        totalTax = (incomeTax/100)*incomeAmount;
        return totalTax;
    }
}  