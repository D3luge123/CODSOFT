//importing various classes for implementing ArrayList, Collections class, Scanner Class, Timer Class and TimerTask.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class quizOptions{ //creating quizOptions class for displaying the start menu of the quiz game.
     static int chooseOption;
    public static void startMenu(){
      
        Scanner sc=new Scanner(System.in);
        ArrayList<String>topics=new ArrayList<String>();
        Collections.addAll(topics,"GK","Space","Technology","Quit");
        System.out.println("Hello and welcome to Guessmaster, our own quiz Guessing Trivia!\n");
        System.out.println("Please choose one of the options for the quiz topic(type in the number for the option):");
        for(int index=0;index<topics.size();index++){
            System.out.println(index + 1 + " => " + topics.get(index));
        }
          chooseOption=sc.nextInt();
    }
    }

interface quizMaterial{//created interface for storing all questions(gk,space and tech related) in Arraylist, displaying multiple options and prompting user to choose an answer.
static Scanner scanner=new Scanner(System.in);

    
        ArrayList<String>gkQuestions=new ArrayList<String>();
        ArrayList<String>gkOptions=new ArrayList<String>();
        ArrayList<Integer>gkAnswers=new ArrayList<Integer>();
        ArrayList<String>spaceQuestions=new ArrayList<String>();
        ArrayList<String>spaceOptions=new ArrayList<String>(); 
        ArrayList<Integer>spaceAnswers=new ArrayList<Integer>();
        ArrayList<String>techQuestions=new ArrayList<String>();
        ArrayList<String>techOptions=new ArrayList<String>();
        ArrayList<Integer>techAnswers=new ArrayList<Integer>();
        ArrayList<Integer>userAnswers=new ArrayList<Integer>();

        public static ArrayList<Integer> gkQuiz(){//this method displays the question and it's choices if user chooses gk quiz
            int answerGK;
            System.out.println("You have chosen GK Quiz, press 1 to start or 2 to quit");
            int userInput=scanner.nextInt();
            if(userInput==1){
        Collections.addAll(gkQuestions," What is the largest lake in the world?"," Which planet in the solar system is known as the Red Planet?","Which river is the longest in the world?","In what year was the first international modern Olympiad held?","Which county is the biggest grower of coffee?");
        Collections.addAll(gkOptions, "1)Caspian Sea\n  2)Baikal\n 3)Lake Superior\n 4)Ontario","1)Venus\n 2)Earth\n 3)Mars\n 4)Jupiter","1)Amazon\n 2)Mississippi \n 3)Nile \n 4)Yangtze","1)1896\n 2)1900\n 3)1912\n 4)1924","1)Spain\n 2)India\n 3)Ethiopia\n 4)Brazil");
        Collections.addAll(gkAnswers, 2,3,3,1,4);
        for(int index=0;index<gkQuestions.size();index++){
                System.out.println(index + 1 + ")" + gkQuestions.get(index) + "\n" + gkOptions.get(index));

                    quizImplementation.resetTimer();//resetting timer for each question.
                    quizImplementation.timerMethod();//starting the timer.
                   answerGK=scanner.nextInt();
                   userAnswers.add(answerGK);
                   gkCheck();//checking the user's answer to see if it's correct or not.
            }
            quizImplementation.timeStop=true;//as soon as all questions finish, the boolean variable timeStop becomes true, and timer is terminated.
            quizImplementation.timerMethod();
        }
            else if(userInput==2){
                System.out.println("Thank you for your time!");
                System.exit(0);
            }
            else{
                System.out.println("Incorrect Input!");
            }
           
                    return userAnswers;
        
    }
   
        public static void gkCheck(){//this method compares user's provided answer with the correct stored answer. 
            int score=0;
             for(int arrIndex=0;arrIndex<userAnswers.size();arrIndex++){
                if(userAnswers.get(arrIndex)==gkAnswers.get(arrIndex)){
                     score++; 
                }
            }
            System.out.println("Your score is: " + score );
        }
            
            public static ArrayList<Integer> spaceQuiz(){//method for space questions.
               
                Collections.addAll(spaceQuestions," Which of the following planets is not a gas giant?"," Which planet has the largest rings in our solar system?","Which planet is also called \"The Diamond Planet\"?","Which planet in our solar system does not have a moon?","How many galaxies have been recorded in the observable universe?");
                Collections.addAll(spaceOptions, "1)Mars\n 2)Jupiter\n 3)Saturn\n 4)Uranus","1)Venus\n 2)Saturn\n 3)Mars\n 4)Jupiter"," 1)Kepler-10b\n 2)Gliese 436 b\n 3)55 Cancri e\n 4)HD 219134 b"," 1)Mars\n 2)Venus\n 3)Jupiter\n  4)Earth", "1)123455444 galaxies\n 2)445545353535 galaxies\n 3)38999999999999 galaxies\n 4)2,000,000,000,000 galaxies");
                Collections.addAll(spaceAnswers, 1,2,3,2,4);
                int answerSpace;
                System.out.println("You have chosen Space Quiz, press 1 to start or 2 to quit");
                int userInput=scanner.nextInt();
                if(userInput==1){

                for(int index=0;index<spaceQuestions.size();index++){
                    System.out.println(index + 1 + ")" + spaceQuestions.get(index) + "\n" + spaceOptions.get(index));
    
                        quizImplementation.resetTimer();
                        quizImplementation.timerMethod();
                       answerSpace=scanner.nextInt();
                       userAnswers.add(answerSpace);
                       spaceCheck();
                }
                quizImplementation.timeStop=true;
                quizImplementation.timerMethod();
            }
            else if(userInput==2){
                System.out.println("Thank you for your time!");
                System.exit(0);
            }
            else{
                System.out.println("Incorrect Input!");
            }

                        return userAnswers;
            }

            public static void spaceCheck(){//checking space answers.
                int score=0;
             for(int arrIndex=0;arrIndex<userAnswers.size();arrIndex++){
                if(userAnswers.get(arrIndex)==spaceAnswers.get(arrIndex)){
                     score++; 
                }
              }
              System.out.println("Your score is: " + score );
            }
             public static ArrayList<Integer> techQuiz(){//method for tech quiz.
           
            Collections.addAll(techQuestions," What is cybersecurity focused on protecting?"," What startup, acquired by Facebook for $1 billion in 2012, became the fourth most downloaded app in the 2010s and is known for the posting of pictures?", "What is the programming language developed by James Gosling at Sun Microsystems and named after the type of coffee from Indonesia?","What delicious computer term did web browser programmer Lou Montulli coin to refer to information that is sent from the browser to the web server?","What technology company, now mostly known as a telecommunications giant, gained mass market popularity with its release of the “RAZR” cell phone in 2004 which became the best-selling clamshell cell phone in the world?");
            Collections.addAll(techOptions, "1)Hardware\n  2)Software\n 3)Information\n 4)Electricity","1)Amazon\n 2)Twitter\n 3)Instagram\n 4)Google","1)Python\n 2)R\n 3)Haskell\n 4)Java","1)Cookie\n 2)Muffin\n 3)Pancake\n 4)Chocolate","1)Samsung\n 2)Motorola\n 3)Apple\n 4)Xiaomi");
            Collections.addAll(techAnswers, 3,3,4,1,2);
            int answerTech;
            System.out.println("You have chosen Tech Quiz, press 1 to start or 2 to quit");
            int userInput=scanner.nextInt();
            if(userInput==1){
            for(int index=0;index<techQuestions.size();index++){
                System.out.println(index + 1 + ")" + techQuestions.get(index) + "\n" + techOptions.get(index));

                    quizImplementation.resetTimer();
                    quizImplementation.timerMethod();
                   answerTech=scanner.nextInt();
                   userAnswers.add(answerTech);
                   techCheck();
            }
            quizImplementation.timeStop=true;
            quizImplementation.timerMethod();
        }
        else if(userInput==2){
            System.out.println("Thank you for your time!");
            System.exit(0);
        }
        else{
            System.out.println("Incorrect Input!");
        }


                    return userAnswers;
            }

            public static void techCheck(){//checking tech answers.
                int score=0;
             for(int arrIndex=0;arrIndex<userAnswers.size();arrIndex++){
                if(userAnswers.get(arrIndex)==techAnswers.get(arrIndex)){
                     score++; 
                }
            }
            System.out.println("Your score is: " + score );
            }
        }
//this class is used for directing the program towards the appropriate subject of quiz according to user choice. It also clears any previous timertask. 

     class quizImplementation extends quizOptions implements quizMaterial{
        
            
            public static void options(){
           if(chooseOption==1){
        quizMaterial.gkQuiz();
       }
       else if(chooseOption==2){
        quizMaterial.spaceQuiz();
       }
       else if(chooseOption==3){
        quizMaterial.techQuiz();
       }
       else if(chooseOption==4){
        System.out.println("Thank you for your time!");
        System.exit(0);
       }
       else{
        System.out.println("Error, invalid input!");
       }
            }
        static Timer timer=new Timer();//initialize timer class
        static TimerTask task;//declare timertask object
        static int seconds=20;
        static boolean timeStop=false;
        public static void timerMethod(){
                if (task != null) {
                    task.cancel();
                }
         task=new TimerTask(){//initialize Timertask, which is an abstract class used to perform a task for a particular timer.

            public void run(){//abstract class method for running task.

                if(timeStop==true){
                    System.out.println("You have successfully completed the quiz, thank you for your time!");
                    System.exit(0);
                }
                else if(seconds>0){
                    seconds--;
                    System.out.print("\rYou have " + seconds + " seconds left");
                    System.out.flush();  // Ensuring the output is updated immediately.
                }
                else{
                    System.out.println("Time's up!");
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);//initiates a countdown immediately when it is executed.
    }
    public static void resetTimer(){//used for resetting timer after every question.
        seconds=20;
    }
    }

public class quizapp {
   public static void main(String[] args) throws Exception {
    
    try{
    quizImplementation.startMenu();
    quizImplementation.options();
   } 
   catch(Exception e){
    System.out.println("Please enter a numerical input!");
   }
   }
}

