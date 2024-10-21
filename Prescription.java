import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Prescription {
    private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float axis;
    private float cylinder;
    private Date examinationDate;
    private String optometrist;
    private String[] remarkTypes= {"Client", "Optometrist"};
    private ArrayList <String> postRemarks= new ArrayList<>();

    Scanner scnr = new Scanner(System.in);

    // DATE FORMAT CHEKCER AND FILE INPUT STREAM
    public boolean addPrescription() {
        boolean accepted = true;

        if (this.firstName.length() < 4 || this.firstName.length() > 15) {
            accepted = false;
        }
        if (this.lastName.length() < 4 || this.lastName.length() > 15) {
            accepted = false;
        }
        if (this.address.length() < 20) {
            accepted = false;
        }
        if (this.sphere > 20 || this.sphere < -20) {
            accepted = false;
        }
        if (this.cylinder > 4 || this.cylinder < -4) {
            accepted = false;
        }
        if (this.axis < 0 || this.axis > 180) {
            accepted = false;
        }
        if (this.optometrist.length() < 8 || this.optometrist.length() > 25) {
            accepted = false;
        }

        if (accepted) {
            try {

            FileWriter outFS = new FileWriter("presc.txt", true);

            outFS.write("Prescription ID: " + prescID + "\n");
            outFS.write("First Name: " + firstName + "\n");
            outFS.write("Last Name: " + lastName + "\n");
            outFS.write("Address: " + address + "\n");
            outFS.write("Sphere: " + sphere + "\n");
            outFS.write("Cylinder: " + cylinder + "\n");
            outFS.write("Axis: " + axis + "\n");
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
            String formattedDate = dateFormat.format(examinationDate);
            outFS.write("Examination Date: " + formattedDate);
            outFS.write("Optometrist: " + optometrist);
            
            outFS.close();
        } catch (IOException e) {
            System.out.println("An error occured while writing to the file.");
            e.printStackTrace();
            accepted = false;
        }
    }
    return accepted;
    }

    public boolean addRemark(String remarkText, String remarkType) {

        boolean valid = true;

        //Condition to split up the remarks into works and make sure that is is above 6 and less than 20 words. trim removes trailing, split at white spaces and any recurring
        String[] words = remarkText.trim().split("\\s+");
        if (words.length < 6 || words.length > 20 ) {
            valid = false;
        }

        //Condition to check whether the first letter of the remark of the first work is upper case or not
        if (!Character.isUpperCase(words[0].charAt(0))) {
            valid = false;
        }

        // Condition to check whether remark type is either client or optometrist and nothing outside of it.
        if (!remarkType.equalsIgnoreCase("Client") || !remarkType.equalsIgnoreCase("Optometrist")) {
            valid = false;
        }

        //Condition to check if there are alr 2 remarks
        if (postRemarks.size() >= 2) {
            valid = false;
        }

        // if conditions all passed and valid stays true, add remarks to post remarks
        if(valid) {
            postRemarks.add(remarkType + ": " + remarkText);
        }

        try (FileWriter reviewWriter = new FileWriter("review.txt", true)) {
            reviewWriter.write(remarkType + ": " + remarkText + "\n");
        } catch (IOException e){
            System.out.println("Error in writing remarks to file.");
            e.printStackTrace();
            valid = false;
        }

        return valid;
    }

    public void setPrescID(int id) {
        prescID = id;
    }

    public int getPrescID() {
        return this.prescID;
    }

    public void setFirstName(String name) {
        firstName = name;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setAddress(String add) {
        this.address = add;
    }

    public String getAddress() {
        return this.address;
    }

    public void setSphere(float num) {
        this.sphere = num;

    }

    public float getSphere() {
        return this.sphere;
    }

    public void setCylinder(float num) {
        this.cylinder = num;
    }

    public float getCylinder() {
        return this.cylinder;
    }

    public void setAxis(float num) {
        this.axis = num;
    }

    public float getAxis() {
        return this.axis;
    }

    public void setOptometrist(String opt) {
        this.optometrist = opt;
    }

    public String getOptometrist() {
        return this.optometrist;
    }
}
