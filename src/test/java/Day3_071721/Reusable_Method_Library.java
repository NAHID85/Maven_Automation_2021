package Day3_071721;

public class Reusable_Method_Library {

    //create a void method for adding two integer values
    public static void addTwoNumbers(int num1, int num2){
        System.out.println("My result is " + (num1+num2));
    }//end of add two numbers method

//creating a void method for subtracting two integer values
    public static void subtractTwoNumber(int num1, int num2){
        System.out.println("My result is " + (num1-num2));
    }//end of add two numbers method
    /*
        create a return method that will add two numbers and also you can
        return the result of the numbers
         */
    public static int addTwoNumbersForReturn(int num1, int num2){
        int result = num1 + num2;
        System.out.println("My result is " + result);
        return result;
    }//end of return add two numbers

    /*
        create a return method that will subtract two numbers and also you can
        return the result of the numbers
         */

   public static int subtractTwoNumbersForReturn(int num1,int num2){
        int result = num1- num2;
        System.out.println("My result "+ result);
        return result;
   }//end of return subtract two number


}//end of java class
