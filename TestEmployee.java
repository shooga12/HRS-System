import java.util.Scanner;
public class TestEmployee
{
static Scanner input = new Scanner(System.in);
static Employee hiringEmployees[] = new Employee[100];
static int counter;
public static void main(String []args)
{
   hiringEmployees[0] = new Employee("9876543222", "Driver", "15/12/2020", "16:00", "22:00", true, 1);
   hiringEmployees[1] = new Employee("9876543211", "Cleaning Worker", "15/12/2020", "08:00", "16:00", true, 4);
   hiringEmployees[2] = new Employee("1234567899", "Cleaning Worker", "N/A", "N/A", "N/A", false, 0);
   hiringEmployees[3] = new Employee("2234567891", "Cleaning Worker", "17/12/2020", "08:00", "13:00", true, 2);
   hiringEmployees[4] = new Employee("1334567892", "Driver", "11/12/2020", "10:00", "15:00", true , 1);
   hiringEmployees[5] = new Employee("4412356789", "Cleaning Worker", "05/12/2020", "12:00", "16:00", true, 10);
   hiringEmployees[6] = new Employee("3114567894", "Driver", "N/A", "N/A", "N/A", false, 2);
   hiringEmployees[7] = new Employee("8876543221", "Driver", "19/12/2020", "08:00", "14:00", true, 1);
   hiringEmployees[8] = new Employee("7776543267", "Cleaning Worker", "N/A", "N/A", "N/A", false, 3);
   hiringEmployees[9] = new Employee("1176543266", "Cleaning Worker", "02/12/2020", "17:00", "21:00", true, 12);
   counter = 10;
   int process;
   do
   {
   System.out.println("Please choose from the menu the number of process you want : ");
   System.out.println(" 1. Add a new employee \n 2. Start a hiring contract \n 3. End a hiring contract \n 4. Display employee info \n 5. Display HRS system status \n 6. Exit");
   process = input.nextInt();
   switch(process)
   {
   case 1 : 
   System.out.println("Please enter your ID number :");
   String id = input.next();
   int existence = findID(id);
   
   if (existence != -1)
      {
      System.out.println("This ID is already used.");
      break;
      }
      
   System.out.println("Please enter your jop title :");
   input.nextLine();
   String jobTitle = input.nextLine();
   hiringEmployees[counter] = new Employee(id, jobTitle, "N/A", "N/A", "N/A", false, 0);
   counter++;
   System.out.println("New employee has been added successfuly!");
   break;
   //End Case 1
   
   case 2 :
   System.out.println("Please enter the employee's ID number :");
   id = input.next();
   existence = findID(id);
   if (existence == -1)
   {
      System.out.println("This ID is not available please try again.");
      break;
   }
   
   if (hiringEmployees[existence].getHired())
   {
      System.out.println("This Employee is already hired.");
      break;
   }
   
   System.out.println("Please enter these contract’s information: ");
   System.out.println("contract date in this Format dd/mm/yyyy");
   String contractDate = input.next();
   System.out.println("Start time in this Format HH:00");
   String startTime = input.next();
   System.out.println("End time in this Format HH:00");
   String endTime = input.next();
   
   hiringEmployees[existence].setCase2n3(contractDate , startTime , endTime , true);
   hiringEmployees[existence].updateFrequency();
   System.out.println("Employee is now ready for starting the assigned job.2");
   hiringEmployees[existence].displayInfo();
   break;
   //End Case 2
   
   case 3 :
   System.out.println("Please enter your ID number :");
   id = input.next();
   existence = findID(id);
   if (existence == -1)
   {
      System.out.println("This ID is not available please try again.");
      break;
   }
   
   if (hiringEmployees[existence].getHired() == false)
   {
      System.out.println("This Employee is not hired.");
      break;
   }
   
   hiringEmployees[existence].displayInfo();
   System.out.println("The employee's total duration is: " + hiringEmployees[existence].calculateDuration());
   hiringEmployees[existence].setCase2n3("N/A" , "N/A" , "N/A" , false);
   System.out.println("Ending a hiring contract for the Employee successed!");
   break;
   //End Case 3
   
   case 4 :
   System.out.println("Please enter the employee's ID number :");
   id = input.next();
   existence = -1;
   for ( int i=0 ; i<counter ; i++)
      if (hiringEmployees[i].getID().equals(id))
      {
         existence = i;
         break;
      }
   
   if (existence == -1)
   {
      System.out.println("This ID is not available please try again.");
      break;
   }
   
   hiringEmployees[existence].displayInfo();
   break;
   //End Case 4
   
   case 5 :
   System.out.println("The total number of employees are: " + counter);
   int hired = 0;
   int available = 0;
   for (int i=0; i<counter; i++)
      {
      if(hiringEmployees[i].getHired())
         hired++;
      else
         available++;
      }
   System.out.println("The current number of hired employees are: " + hired);
   System.out.println("The current number of available employees are: " + available);
   
   int highest = 0;
   for(int i=1; i<counter; i++)
      {
         if (hiringEmployees[highest].getFrequency() < hiringEmployees[i].getFrequency())
         highest = i;
      }
   
   System.out.println("The Id of the employee with the highest hiring frequency: " + hiringEmployees[highest].getID());
   System.out.println("A list of all employees in system:");
   System.out.printf("|%-12s|%15s|%10s|%6s|%6s|%-4s|%-4s|\n", "id", "jobTitle", "Date", "start", "end", "hire", "freq");
   for(int i=0; i<counter; i++)
      hiringEmployees[i].displayInfo();
   break;
   //End Case 5
   
   case 6 :
   System.out.println("All info will be lost Are you sure you want to exit? (Yes/No)");
   String yon = input.next();
   if (yon.equalsIgnoreCase("Yes"))
      System.out.println("Thank you");
   else if (yon.equalsIgnoreCase("No"))
      process = 0;
   else
   {
      System.out.println("Please only (yes/no) is accepted!");
      process = 0;
   }
   break;
   //End Case 6
   
   default : 
   System.out.println("Not a valid selection!");
   }//End switch
   } while(process != 6);
}//end main

public static int findID(String id) //The same code has been used multiple times so we used a method for that.
{
   for (int i=0 ; i< counter ; i++)
      if (hiringEmployees[i].getID().equals(id))
         return i;
         
   return -1;
}

}//end class