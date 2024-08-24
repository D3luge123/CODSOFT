/*Created a student grade calculator in java. The core concepts implemented in this program are Scanner class, Arrays, Arraylist, Control flow statements(for and while loop),
 Conditional statements(if-else), Booleans and non-static methods.*/



//importing Scanner class and Arraylist class from java.util package.

import java.util.Scanner;
import java.util.ArrayList;
public class studentGrade {

//creating ArrayList marks to store student marks of all subjects, and creating an array subjects for storing subject names.

ArrayList<Integer>marks=new ArrayList<Integer>();
String[]subjects={"Maths", "Science", "English", "Computers", "History & Civics"};

//creating instance method subjectMarks for displaying subjects and taking user input as marks for each subject. These marks are stored in marks Arraylist.

public void subjectMarks(){

    Scanner scanner = new Scanner(System.in);
    

    for(int i=0;i<subjects.length;i++){

        //implementing boolean logic for positive marks input. If input marks are negative, the user is prompted to enter marks until a positive value is entered. 

        boolean positive=true;
        while(positive){
            System.out.println("Please enter " + subjects[i] + " marks(out of 100):");
            int mark=scanner.nextInt();
            if( mark>=0){
                marks.add(mark);
                positive=false;
            }
            else{
                System.out.print("Please enter a positive number(Marks cannot be negative!) \n");
            }
        }
    }
}

//creating instance method totalMark for calculating total marks of all subjects. It stores the total in totalmarks variable, and returns the total.
public int totalMark(){
     int totalmarks=0;
    for(int value:marks){
        totalmarks+=value;
    }
    return totalmarks;
}
//creating instance method averagePercentage. It fetches the total marks from the totalMark method and stores them in val variable. The average percent is then returned.

 public int averagePercentage(){
    int averagepercent=0;
    int val=totalMark();
     averagepercent=val/subjects.length;
     return averagepercent;
 }
//The instance method studentGrading is created to grade students according to their average percent.

public String studentGrading(){
int averageperc=averagePercentage();
String grade = "Undefined";
if(averageperc==0){
     grade="F";
     }
else if(averageperc>0 && averageperc<=20){
    grade="E";
}
else if(averageperc>20 && averageperc<=40){
    grade="D";
}
else if(averageperc>40 && averageperc<=60){
    grade="C";
}
else if(averageperc>60 && averageperc<=80){
    grade="B";
}
else if(averageperc>80 && averageperc<=100){
    grade="A";
}
return grade;
}
//instance method calculation for displaying if a student has passed or failed. Storing the total, average percent and grades in these variables for better readability.

public void calculation(){
    
    int percent=averagePercentage();
    int total=totalMark();
    String grade=studentGrading();
  
    if(percent<=40){
      System.out.print("You have failed! Your total score is: " + total + "\n Your average percentage is: " + percent);
      System.out.println("\n Your grade is: " + grade);
    }
    else if(percent>40 && percent<=100){
      System.out.println("Congrats, you have passed!");  
    System.out.print("Your average percentage is:" + percent+ " \n Your total score is: " + total + " \nYour grade is: " + grade);
    System.out.println();
    }
    else{
      System.out.println(percent + " is not within the range of 0-100! Grading cannot be performed.");
    }
}

public static void main(String[] args) {

    //exception handling for an input other than int.

    try{
        //creating an instance obj1 for calling all the instance methods. The exception block is run if an input other than int datatype is entered.

        studentGrade obj1=new studentGrade();
        obj1.subjectMarks();
        obj1.totalMark();
        obj1.averagePercentage();
        obj1.studentGrading();
        obj1.calculation();
    }
    catch(Exception e){
        System.out.println("Please enter a numerical input!");
    }
}
}

