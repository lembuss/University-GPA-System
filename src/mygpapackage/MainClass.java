/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygpapackage;

import java.util.Scanner;

/**
 *
 * @author lembuss
 */
public class MainClass {
    static void studentInputMethod(){
            Scanner firstNameObj = new Scanner(System.in);
            System.out.println("Enter student first name:");
            String fname = firstNameObj.nextLine(); 

            Scanner lastNameObj = new Scanner(System.in);
            System.out.println("Enter student last name:");
            String lname = lastNameObj.nextLine(); 

            Scanner studentIDObj = new Scanner(System.in);
            System.out.println("Enter student ID:");
            int id = studentIDObj.nextInt();

            Scanner numberOfCoursesObj = new Scanner(System.in);
            System.out.println("How many credit courses have you taken this semester?");
            int number = numberOfCoursesObj.nextInt();

            StudentComponent firstStudent = new StudentComponent(fname, lname, id, number); 

            System.out.println("First Name: " + firstStudent.firstName);
            System.out.println("Last Name: " + firstStudent.lastName);
            System.out.println("Student ID: " + firstStudent.studentID);
            System.out.println("Number of courses: " + firstStudent.numberOfCourses);
    }

    static void courseInputMethod(){
            Scanner courseNameObj = new Scanner(System.in);
            System.out.println("What is the name of the course? ");
            String name = courseNameObj.nextLine();

            Scanner courseNumberObj = new Scanner(System.in);
            System.out.println("What is the number of the course? ");
            int number = courseNumberObj.nextInt();			

            Scanner creditHoursObj = new Scanner(System.in);
            System.out.println("How many credit hours? ");
            int hours = creditHoursObj.nextInt();

            CourseComponent course = new CourseComponent(name, hours, number); 

            System.out.println("Course Name: " + course.courseName);
            System.out.println("Credit Hours: " + course.creditHours);
            System.out.println("Course Number: " + course.courseNumber);			
    } 

    public static void main(String[] args){

            System.out.println("This program calculates the grade point average for ANU Students.");

            Scanner componentObj = new Scanner(System.in);
            System.out.println("For the student component, input 1, for the course component input 2");
            int component = componentObj.nextInt();

            switch(component){
                    case 1:
                            studentInputMethod();
                            break;
                    case 2: 
                            courseInputMethod();
                            break;
                    default:
                            System.out.println("Wrong Input! Try again");
            }
    // System.out.println("Your GPA for this semester is %.2f", gpa(courseload));
    }
}

class StudentComponent{

    // Create class attributes for the student component 

    String firstName;
    String lastName;
    int studentID;
    int numberOfCourses;

    // constructor for the student components
    public StudentComponent(String fname, String lname, int id, int number){
            firstName = fname;
            lastName = lname;
            studentID = id;
            numberOfCourses = number;

    }
}


class CourseComponent{

    // class attributes for the course component
    String courseName;
    float creditHours;
    int courseNumber;

    public CourseComponent(String name, float hours, int number){
            courseName = name;
            creditHours = hours;
            courseNumber = number;
    }
}
