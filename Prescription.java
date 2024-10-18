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

        if (accepted) {
            try {

            FileWriter outFS = new FileWriter("presc.txt", true);

            outFS.write("Prescription ID: " + prescID);
            outFS.write("First Name: " + firstName);
            outFS.write("Last Name: " + lastName);
            outFS.write("Address: " + address);
            outFS.write("Sphere: " + sphere);
            outFS.write("Cylinder: " + cylinder);
            outFS.write("Axis: " + axis);
            outFS.write("Optometrist: " + optometrist);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
            String formattedDate = dateFormat.format(examinationDate);
            outFS.write("Examination Date: " + formattedDate);

            outFS.close();
        } catch (IOException e) {
            System.out.println("An error occured while writing to the file.");
            e.printStackTrace();
            accepted = false;
        }
    }
    return accepted;
    }



    public boolean addRemark() {
        return true;
    }

    public void setPrescID() {
        System.out.println("Enter the prescription ID:");
        prescID = scnr.nextInt();
    }

    public int getPrescID() {
        return this.prescID;
    }

    public void setFirstName() {
        System.out.println("Enter your first name:");
        firstName = scnr.nextLine();
        //Pre-condition checks before the variable is accepted to avoid invalid inputs overall
        // while (firstName.length() < 4 || firstName.length() > 15) {
        //     System.out.println("Please re-enter your first name:");
        //     firstName = scnr.nextLine();
        // }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName() {
        System.out.println("Enter your last name:");
        lastName = scnr.nextLine();
        //Pre-condition checks before the variable is accepted to avoid invalid inputs overall
        // while (lastName.length() < 4 || lastName.length() > 15) {
        //     System.out.println("Please re-enter your last name:");
        //     lastName = scnr.nextLine();
        // }
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setAddress() {
        System.out.println("Enter your address:");
        address = scnr.nextLine();
        //Pre-condition checks before the variable is accepted to avoid invalid inputs overall
        // while (address.length() < 20) {
        //     System.out.println("Please re-enter your address:");
        //     address = scnr.nextLine();
        // }
    }

    public String getAddress() {
        return this.address;
    }

    public void setSphere() {
        System.out.println("Enter the sphere value:");
        sphere = scnr.nextFloat();
        // while(sphere > 20 || sphere < -20) {
        //     System.out.println("Please re-enter the sphere value:");
        //     sphere = scnr.nextFloat();
        // }
    }

    public float getSphere() {
        return this.sphere;
    }

    public void setCylinder() {
        System.out.println("Enter the cylinder value");
        cylinder = scnr.nextFloat();
        // while (cylinder > 4 || cylinder < -4) {
        //     System.out.println("Please re-enter the cylinder value:");
        //     cylinder = scnr.nextFloat();
        // }
    }

    public float getCylinder() {
        return this.cylinder;
    }

    public void setAxis() {
        System.out.println("Enter the axis value:");
        axis = scnr.nextFloat();
        // while (axis > 180 || axis < 0) {
        //     System.out.println("Please re-enter the axis value:");
        //     axis = scnr.nextFloat();
        // }
    }

    public float getAxis() {
        return this.axis;
    }

    public void setOptometrist() {
        System.out.println("Enter the optometrist's name");
        optometrist = scnr.nextLine();
        // while (optometrist.length() < 8 || optometrist.length() > 25) {
        //     System.out.println("Please re-enter the optometrist's name:");
        //     optometrist = scnr.nextLine();
        // }
    }

    public String getOptometrist() {
        return this.optometrist;
    }
}
