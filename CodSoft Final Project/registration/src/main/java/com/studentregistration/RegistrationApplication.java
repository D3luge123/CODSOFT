package com.studentregistration;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.*;

@SpringBootApplication
public class RegistrationApplication {//application class, which is used to create beans and run the main program.
	
	
	
	public static void main(String[] args) {

		//container which creates beans and provides beans by constructor and dependency injection.
		ConfigurableApplicationContext context=SpringApplication.run(RegistrationApplication.class, args);
		
			courseService courseservice=context.getBean(courseService.class);//creating beans of student and course service classes and student repository class.
			studentService studentservice=context.getBean(studentService.class);

			studentRepo studentrepo=context.getBean(studentRepo.class);

		Scanner sc=new Scanner(System.in);
		int choice=0;//for performing registration, viewing or deletion.
		ArrayList<String>options=new ArrayList<>();
		
		Collections.addAll(options, "View and Register courses", "View Registered Courses","Drop Courses","Exit");
		int index=0;
		
		System.out.println("Hello and welcome to Smartlearn! Please choose an option from below(type in the number to select the option(1-4)):");
		for(String values:options){//iterating over the options
			index++;
			System.out.println(index + ")" + values);
		}
		choice=sc.nextInt();
		
		if(choice==1){
			int numofcourses=0;
			courseservice.fetchallCourses();//fetches list of all courses.
			System.out.print("Please choose the number of courses you want to enroll into(max-4):");
			 numofcourses=sc.nextInt();
			sc.nextLine();
			
			boolean maxcourses=true;
			while(maxcourses){//while loop continues until value of numberofcourses between 0-5 is entered.
			if(numofcourses>4){
				System.out.print("You cannot register into more than 4 courses! Please enter a value till 4:");
				numofcourses=sc.nextInt();
				sc.nextLine();
				
			}
			else if(numofcourses<0){
				System.out.print("The number of courses cannot be negative! Please enter a positive value:");
				numofcourses=sc.nextInt();
				sc.nextLine();
			}
			else if(numofcourses>0 && numofcourses<5){//exit condition.
				maxcourses=false;
			}
			else if(numofcourses==0){
				System.out.print("There should be atleast one course registration:");
				numofcourses=sc.nextInt();
				sc.nextLine();
			}
			else{
				System.out.println("Please enter a valid input!");
				numofcourses=sc.nextInt();
				sc.nextLine();
			}
			}
			Set<String> coursenamesSet = new HashSet<>();//creating set to store course names entered by student.
			for(int i=1;i<=numofcourses;i++){
				System.out.print("Please enter course " + i + " name: ");
				String coursenames=sc.nextLine();
				boolean correctsub=true;
				while (correctsub) {//this while loop prompts the user to enter the correct course name, irrespective of casing.
					
				
				if (coursenames.equalsIgnoreCase("Java Programming") ||//if coursename matches either of these, it is added to the set. Else, wrong subject message is displayed.
				coursenames.equalsIgnoreCase("Python Programming") ||
				coursenames.equalsIgnoreCase("Data analysis for beginners") ||
				coursenames.equalsIgnoreCase("Cybersecurity")) {
				coursenamesSet.add(coursenames);
					correctsub=false;
				}
				else{
					System.out.print("You have entered wrong subject, please enter correct subject name:");
					coursenames=sc.nextLine();
				}
			}
			}
			System.out.print("Please enter your student id:");
			int studentid=sc.nextInt();
			sc.nextLine();

			System.out.print("Please enter your Name: ");
			String student_name=sc.nextLine();
			
			System.out.print("Please enter your timeslot(type in the format x-y pm):");
			String timeslot=sc.nextLine();

			//calls the registerStudent method from the service class to transfer these values to the repo class, which is responsible for crud operations on the db.
			studentservice.registerStudent(studentid, student_name, timeslot, coursenamesSet);

			System.out.println("All inputs taken, thank you for your time!");
		
	}
		else if(choice==2){
			
			System.out.print("Please enter your student ID: ");
    int studentId = sc.nextInt();
    sc.nextLine();

    student stu = studentrepo.findBystudentid(studentId); //Fetch student by ID

    if (stu != null) {//if student exists in the db, print out their registered courses.
        System.out.println("Currently registered courses: " + stu.getRegistered_Courses());
		}
			else{
				System.out.println("User does not exist!");
			}
			}
		else if(choice==3){
			System.out.print("Please enter your student ID: ");
    int studentId = sc.nextInt();
    sc.nextLine();

    student stu = studentrepo.findBystudentid(studentId); 
			if(stu==null){
				System.out.println("Student does not exist. Please create your profile and register for courses first!");
			}
    		else if (stu != null) {
        System.out.println("Currently registered courses: " + stu.getRegistered_Courses());
		
		//retrieve courses string separated by comma from the db. They are a single value inside the array, spearated by commas.
		ArrayList<String> registeredCoursesArray = new ArrayList<>();
		String[] coursesArray = stu.getRegistered_Courses().split(","); //using split method to split all courses into individual values.
		Collections.addAll(registeredCoursesArray,coursesArray);//adding array values into arraylist.
		ArrayList<String>removeCourses=new ArrayList<>();//creating a removecourses array to add the unwanted courses, which will later be removed.
		for(String ind:registeredCoursesArray){
		System.out.println("Do you want to drop " + ind + " ? (Type 1 for yes and 2 for no)" );
		int dropCourse=sc.nextInt();
		if(dropCourse==1){
			removeCourses.add(ind);
			System.out.println("Course removed!");
		}
		else if(dropCourse==2){
			System.out.println("Course retained!");
		}
		else{
			System.out.println("Invalid option!  Please choose 1 or 2");
			dropCourse=sc.nextInt();
		}
		}
	
			registeredCoursesArray.removeAll(removeCourses);//removing all unwanted courses.
			String updatedCourses = String.join(",", registeredCoursesArray);//creating them as a single entity again to be able to be stored in the db.
       		 stu.setRegistered_Courses(updatedCourses);
       	 	studentrepo.save(stu);//saving the updated courses in the db.
	}
	}
		else if(choice==4){
			System.out.println("Thank you for accessing our portal. We wish you happy learning!");
		}
		else{
			System.out.println("Error, invalid input!");
		}
		sc.close();
}
}
