package Day2_071121;

public class For_Loop_with_Array {
    public static void main(String[] args) {
       //  Iterate through diffrent countries value and print them out in for loop
        String[] countries = new String[5];
        countries[0] = "USA";
        countries[1] = "BANGLADESH";
        countries[2] = "PAKISTAN";
        countries[3] = "INDIA ";
        countries[4] = "RUSSIA";

        String[] placements = new String[5];
        placements[0] = "FIRST";
        placements[1] = "SECOND";
        placements[2] = "THIRD";
        placements[3] = "FOURTH";
        placements[4] = "FIFTH";

        // Using for loop to iterate through these values
        for (int i = 0; i< countries.length; i++){

            //print statement for only countries

            System.out.println("My country is "+ countries[i]);

            //print statement for  countries and placement at the same time.

            System.out.println("My country is "+ countries[i]+ " and placement is " + placements[i]);

            // to change incrementation to skip every other value on the list we need to redefine the i
            //i = i + 1;
        }//End of for loop.

    }// End of  main method.
}//End of Java class