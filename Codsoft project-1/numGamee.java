/*creating a number game using java programming language. The concepts used in this game include static variables, scanner class, static arrays, static methods, 
 control flow statements( for loop, while loop), conditional statements(if-else statements and nested if else), math class for random number generation and exception handling.*/


// importing the scanner class from java.util package
import java.util.Scanner;


public class numGamee {

    /* Creating a static Scanner object 'sc' of the Scanner class and declaring static variables 'choose', 'score' and 'choice'. The 'choose' variable is for selecting
       whether to play or quit, the 'score' variable is for keeping tabs on the score, and the 'choice' variable is for selecting the difficulty level. These variables are declared static because they are used by 
       static methods. They are declared outside any method to provide global scope, allowing consecutive use by different methods. */


    static Scanner sc=new Scanner(System.in);
    static int choose,choice;
    static int score = 0;
     
    // Declaring a static array 'difficulty' to store the difficulty levels. The elements (indexes) of this array are utilized by the 'chooseDifficulty' and 'playGame' methods.

    static String[]difficulty={"Easy","Medium", "Hard"};
   
    /*declaring a static method 'gameStart' which states the 'start' and 'quit' options by fetching them from the startMenu array , and prompting the user to choose an option 
    when called in the main method.*/

    public static void gameStart(){
        String[]startMenu={"Start", "Quit"};
        int index;
           System.out.println("Welcome to WildGuess, the number guessing game! Please choose an option(Type the number to choose the option):");
           for(index=0;index<startMenu.length;index++){
           System.out.println((index + 1) + " => " + startMenu[index]);
           }
            choose=sc.nextInt();
         }

         /*declaring a static method 'chooseDifficulty', which states three levels of difficulty: 'easy', 'medium' and 'hard'. The method fetches the difficulty levels from the 
           difficulty array declared above, and prompts the user to select a difficulty level.*/

     public static void chooseDifficulty(){
        int indices;
        System.out.println("Please type the number for the difficulty you want to select:");
        for(indices=0;indices<difficulty.length;indices++){
            System.out.println((indices+1) + " => " + difficulty[indices]);
        }
         choice=sc.nextInt();
     }

     /*declaring a static method playGame, which contains the entire logic of the game. If the user selects easy difficulty, they have to guess the number from the range 0-50. 
      Similarly, if the user chooses medium difficulty, they have to guess the number from the range 0-100, and if the user selects hard difficulty, they have to guess the number
      from the range 0-500. The Math class contains random function which generates a random number between 0.0 and 1.0(double datatype value, where 0 is inclusive and 1 is exclusive).
      */

     public static void playGame(){

        //implementing 'if' conditional statement for easy difficulty selected by user. The difficulty level is fetched from the difficulty array and shown here.

        if(choice==1){
            System.out.println(" You have chosen " + difficulty[0] + " level");

            //generating random number between 0-50 and taking user guess.

            int randomNum=(int)(Math.random()*51);
                System.out.println("As you have chosen " + difficulty[0] + " difficulty, a random number has been chosen between 0-50. Guess the number to win the game!");
                System.out.println("Please type in your guess number:");
                int guessNum=sc.nextInt();

                /* Implementing a while loop for guessing the number. The loop prompts the user to enter a value until it matches the system-generated random value. If the
                 guessed value is too high, it notifies the user accordingly. Similarly, if the value is too low, it notifies the user. The while loop terminates as soon as the
                  user's guessed number matches the random number, and the user's score is displayed.*/

                while(guessNum!=randomNum){
                    if(guessNum>randomNum){
                        System.out.print("Too high! The number is lower than " + guessNum + " .Please guess the number again:");
                        guessNum=sc.nextInt();
                    }
                    else if(guessNum<randomNum){
                        System.out.print("Too low! The number is higher than " + guessNum + " .Please guess the number again:");
                        guessNum=sc.nextInt();
                    }
                    
                }
                    if(guessNum==randomNum){
                        System.out.println(" Bravo! You have guessed the correct number!");
                        score++;
                        System.out.println("Your score is now " + score);
                    }
         }

         // implementing else if conditional statement for medium difficulty.

            else if(choice==2){
            System.out.println(" You have chosen " + difficulty[1] + " level");
            System.out.println("As you have chosen " + difficulty[1] + " level, a random number has been chosen between 1-100. Guess the number to win the game!");

            //Math.random function for generating a random number between the range 0-100, and taking user's guess.

            int randomNum=(int)(Math.random()*101);
            System.out.print("Please type in your guess number:");
            int guessNum=sc.nextInt();

            //while loop for checking if user's guessed number matches with the random generated number.

            while(guessNum!=randomNum){
                if(guessNum>randomNum){
                    System.out.print("Too high! The number is lower than " + guessNum + ".Please enter the number again:");
                    guessNum=sc.nextInt();
                }
                else if(guessNum<randomNum){
                    System.out.print("Too low! The number is higher than " + guessNum + ". Please enter the number again:" );
                    guessNum=sc.nextInt();
                }
            }
            if(guessNum==randomNum){
                System.out.println("Bravo!you have guessed the correct number!");
                score++;
                System.out.println("Your score is now " + score);
            }
        }

            //implementing else if conditional statement for hard difficulty.

            else if(choice==3){
            System.out.println(" You have chosen " + difficulty[2] + " level");
            System.out.println("As you have chosen " + difficulty[2] + " level, a random number has been chosen between 1-500. Guess the number to win the game!");

            //generating a random number between the range 0-500, while taking user's guess number.

            int randomNum=(int)(Math.random()*501);
            System.out.print("Please type in your guess number:");
            int guessNum=sc.nextInt();

            //while loop for checking matching condition.

            while(guessNum!=randomNum){
                if(guessNum>randomNum){
                    System.out.print("Too high! The number is lower than " + guessNum + ".Please enter the number again:");
                    guessNum=sc.nextInt();
                }

                else if(guessNum<randomNum){
                    System.out.print("Too low! The number is higher than " + guessNum + ". Please enter the number again:" );
                    guessNum=sc.nextInt();
                }
            }

            if(guessNum==randomNum){
                System.out.println("Bravo!you have guessed the correct number!");
                score++;
                System.out.println("Your score is now " + score);
            }

            //else condition if user inputs a number than 1,2, or 3 for selecting the difficulty.
            else{
                System.out.println("Incorrect input!");
            }
        }
    }

            //declaring static method playAgain for implementing the play again logic. If user types in 1(yes), the chooseDifficulty and playGame methods are called.
            public static void playAgain(){
                System.out.println("Do you want to play the game again?(Type 1 for yes and 2 for no)");
                int userPrompt=sc.nextInt();

                /*implementing boolean logic for playing again. The user can play again as long has playyAgain remains true. As soon as user chooses quit option, the variable
                 playyAgain becomes false and the while loop terminates, hence exiting the game.*/

                boolean playyAgain=true;
                while(playyAgain){
                    if(userPrompt==1){
                        chooseDifficulty();
                        playGame();
                        System.out.println("Do you want to play the game again?(Type 1 for yes and 2 for no)");
                        userPrompt=sc.nextInt();
                    }

                   else if(userPrompt==2){
                    playyAgain=false;
                    System.out.println("Thank you for playing the game. Hope you enjoyed!");
                   }
                }
            }


     
        public static void main(String[] args) {
           
           //implementing exception handling for the entire code, so that a normal error message is generated if user enters a different datatype input, other than int.

            try{
              
             //calling gameStart method for start and quit options

            gameStart();

            //if user chooses to start the game, call chooseDifficulty to select difficulty, playGame for playing the game and playAgain to check if user wants to play again.

            if(choose==1){
                System.out.println("Let's begin!");
                chooseDifficulty();
                playGame();
                playAgain();
            }

            //if user chooses to quit, display the corresponding message.

            else if(choose==2){
                System.out.println("Thank you for your time");

            }

            //else block displays the corresponding message when user selects an input other than start or play.

            else{
                System.out.println("Error, wrong input");
        }
    }

        //catch block throws this exception for input other than int datatype.
        
        catch(Exception e){
            System.out.println("Please enter a numerical input!");
        }
    }
}
        
        