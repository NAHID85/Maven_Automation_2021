package Day3_071721;

public class Switch_Statement071721 {
    public static void main(String[] args) {

        // define an array list, iterate through each array value but only print when
        //the city is queens or brooklyn
        String[] cities = new String[4];

        cities[0] = "Queens";
        cities[1] = "Manhattan";
        cities[2] = "Brooklyn";
        cities[3] = "Staten Island";
        //using for loop to iterate through cities and only print when it's brooklyn or queens
        for (int i = 0; i < cities.length; i++) {
            switch (cities[i]) {
                case "Queens":
                case "Manhattan":
                    //if you want to hardcode your cities as brooklyn,manhattan etc then you have to
                    //  System.out.println("My city is" + brooklyn);
                case "Brooklyn":
                    System.out.println("My city is " + cities[i]);
                    break;
            }//end of switch
        }//end of conditions
    }//end of main method

}// end of java class

