package Day3_071721;

public class Execution_Method071721 {
    public static void main(String[] args) {
        //process of calling a static method to another class is known as inheritance
        //adding two numbers
        Reusable_Method_Library.addTwoNumbers(15, 25);

        //subtracting two numbers
        Reusable_Method_Library.subtractTwoNumber(45, 65);

        //adding two number and return the result using return method
        int result = Reusable_Method_Library.addTwoNumbersForReturn(10,20);
        int newResult = result + 5;

       // System.out.println("New result is "+ (result+5));
        System.out.println(" New result is "+ newResult);


    }//end of main method
}//end of java class
