package com.castrejon.ramiro.hwk6;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

/**
 * Triangle App!
 *
 */
public class App 
{
    public static Scanner sc = new Scanner(System.in);
    public static void main( String[] args ) throws IOException
    {
        boolean validTriangle = false;
        while(validTriangle == false) {

            //Asks the user for three lengths
            System.out.println("Enter length of side 1: ");
            double side1 = inputValidation();
            System.out.println("Enter length of side 2: ");
            double side2 = inputValidation();
            System.out.println("Enter length of side 3: ");
            double side3 = inputValidation();
            validTriangle = isItValid(side1,side2,side3);
            //if the given lengths create a valid triangle, then call triangle constructor
            if(validTriangle == true) {
                Triangle triangle = new Triangle(side1, side2, side3);
                System.out.println("This triangle is: ");
                if(triangle.isEquilateral())
                    System.out.println("Equilateral");
                if(triangle.isIsosceles())
                    System.out.println("Isosceles");
                if(triangle.isScalene())
                    System.out.println("Scalene");
                if(triangle.isRight())
                    System.out.println("Right");
                System.out.println("Area of Triangle is " + triangle.getArea());
            }
            else
                System.out.println("Cannot create a triangle with the given lengths. Please try again.");
        }

        boolean validPoints = false;
        while(validPoints ==false) {
            System.out.println("Enter x1: ");
            double x1 = inputValidation();
            System.out.println("Enter y1: ");
            double y1 = inputValidation();
            System.out.println("Enter x2: ");
            double x2 = inputValidation();
            System.out.println("Enter y2: ");
            double y2 = inputValidation();
            System.out.println("Enter x3: ");
            double x3 = inputValidation();
            System.out.println("Enter y3: ");
            double y3 = inputValidation();

            Point point1 = new Point(x1, y1);
            Point point2 = new Point(x2, y2);
            Point point3 = new Point(x3, y3);
            double distance1 = point1.distance(point2);
            double distance2 = point1.distance(point3);
            double distance3 = point2.distance(point3);
            validPoints= isItValid(distance1,distance2,distance3);
            if(validPoints==true) {
                Triangle triPoints = new Triangle(distance1, distance2, distance3);
                System.out.println("The area of this triangle with points: " + point1 + point2 + point3 + " is "
                        + triPoints.getArea());
            }
            else
                System.out.println("Cannot create a triangle with the given points "
                        + point1 + point2 + point3 + " Please try again.");
        }
    }
    //validates user input
    public static double inputValidation(){
        while(true){
            String input = sc.nextLine();
            try{
                double n = Double.parseDouble(input);
                if (n >0)
                    return n;
            }
            catch(Exception e) {

            }
            System.out.println("Please enter a positive value");
        }
    }
    //checks if the triangle is valid given the side lengths
    public static boolean isItValid(double side1, double side2, double side3){
        if((side1+side2>side3)&&(side1+side3>side2)&&(side3+side2>side1))
            return true;
        else
            return false;
    }
}
class Triangle{
    //stores triangle lengths
    private double side1, side2,side3;

    //constructor for sides
    public Triangle(double side1, double side2, double side3){
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
    }



    // Method that checks for an equilateral triangle.
    public boolean isEquilateral () {
        if ((side1 == side2) && (side1 == side3))
            return true;
        else
            return false;
    }
    // Method that checks for an isosceles triangle.
    public boolean isIsosceles () {
        if (((side1 == side2) && (side1 != side3)) ||
                ((side1 == side3) && (side1 != side2)) ||
                ((side2 == side3) && (side2 != side1)))
            return true;
        else
            return false;
    }
    // Method that checks for a scalene triangle.
    public boolean isScalene () {
        if ((side1 != side2) && (side2 != side3) && (side1 != side3))
            return true;
        else
            return false;
    }
    // Method that checks if the triangle is a right triangle.
    public boolean isRight () {
        if (((side1*side1) == ((side2*side2) + (side3*side3))) ||
                ((side2*side2) == ((side1*side1) + (side3*side3))) ||
                ((side3*side3) == ((side1*side1) + (side2*side2))))
            return true;
        else
            return false;
    }

    //Method to get the Area
    public double getArea(){
        double s = (side1 + side2 +side3) /2;
        double area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
        return area;
    }

}

class Point{
    private double x, y;
    //constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //default constructor
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    // Return the distance between two points
    public double distance(Point other) {
        double xDif = this.x - other.x;
        double yDif = this.y - other.y;

        return Math.sqrt(xDif*xDif + yDif*yDif);
    }

    // Return the coordinates of this point "(x,y)"
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
