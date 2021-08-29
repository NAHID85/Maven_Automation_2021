package Day2_071121;

public class Dynamic_Array_071121 {


    public static void main(String[] args) {
        //setup zipcode for dynamic array
        String[] zipcode, countries, cities, town;
        zipcode= new String[6];
        zipcode[0]= "11218";
        zipcode[1]= "11219";
        zipcode[2]= "11210";
        zipcode[3]= "11211";
        zipcode[4]= "11212";
        zipcode[5]= "11213";

        countries= new String[6];
        countries[0]= "USA";
        countries[1]= "BANGLADESH";
        countries[2]= "PAKISTAN";
        countries[3]= "INDIA";
        countries[4]= "MYANMAR";
        countries[5]= "NEPAL";

    System.out.println(" My zipcode is " + zipcode[0]);

    // Getting the length of the variable for zipcode
        System.out.println(" My zipcode lenght is "+ zipcode.length);

        System.out.println("My countries is " + countries[0]);
        // Getting the length of the variable for countries
        System.out.println("My countries length is "+ countries.length);

    }//End of Main method.
}//End of Java class
