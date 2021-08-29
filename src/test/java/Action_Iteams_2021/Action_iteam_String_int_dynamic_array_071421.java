package Action_Iteams_2021;

public class Action_iteam_String_int_dynamic_array_071421 {


    public static void main(String[] args) {
        //setup zipcode and streetNumber for dynamic array
        String[] zipcode, streetNumber;
        zipcode = new String[6];
        zipcode[0] = "11118";
        zipcode[1] = "11218";
        zipcode[2] = "11318";
        zipcode[3] = "11418";
        zipcode[4] = "11518";
        zipcode[5] = "11618";

        streetNumber = new String[6];
        streetNumber[0] = "555";
        streetNumber[1] = "666";
        streetNumber[2] = "777";
        streetNumber[3] = "888";
        streetNumber[4] = "999";
        streetNumber[5] = "333";

        // Using for loop to iterate through these values
        for (int i = 0; i < zipcode.length; i++) {

            //print statement for only zipcode

          //  System.out.println("My zipcode is " + zipcode[i]);

            //print statement for  zipcode and streetNumber at the same time.

            System.out.println("My zipcode is " + zipcode[i] + " and streetNumber is " + streetNumber[i]);


        }//End of for loop.

        // Getting the length of the variable for zipcode
        System.out.println(" My zipcode lenght is " + zipcode.length);

    }// End of main method

}// End of Java class
