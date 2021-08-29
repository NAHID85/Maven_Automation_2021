package Day2_071121;

public class While_loop_with_Array {
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

    // set the initializer first
        int i = 0;
    // call the while loop and define the end point

    while (i< countries.length){
        System.out.println(" My country is "+ countries[i]);

            System.out.println(" My placements is "+ placements[i]);

        // incrementation
       i= i+1; // same as i++
    }// end of while loop.
    }// end of main method.
}// end of java class.
