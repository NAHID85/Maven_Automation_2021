package Day3_071721;

public class Loop_with_conditional_statement {
    public static void main(String[] args) {
        // define an array list, iterate through each array value but only print when
        //the city is queens or brooklyn
        String[]cities= new String[4];

        cities[0]= "Queens";
        cities[1]= "Manhattan";
        cities[2]= "Brooklyn";
        cities[3]= "Staten Island";
        //using for loop to iterate through cities and only print when it's brooklyn or queens
        for (int i = 0; i< cities.length; i++){
    //System.out.println(" My city is " + cities[i]);
            if (cities[i]== "Brooklyn"){
                System.out.println(" My citi is "+ cities[i]);
            } else if (cities[i]== "Queens"){
                System.out.println(" My city is " + cities[i]);
            }//end of conditions
        }//end of for loop




    }//end of main method
}//end of java class