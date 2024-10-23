import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PrescriptionTest {
    
    @Test
    public void testAddPrescription1() {
        Prescription prescription = new Prescription();
        prescription.setPrescID(1);
        //testing with name "Bob" should fail cause less than 4 letters
        prescription.setFirstName("Bob");
        prescription.setLastName("Simpson");
        prescription.setAddress("Melbourne 3000 Australia");
        prescription.setSphere(11.0f);
        prescription.setCylinder(2.0f);
        prescription.setAxis(150.0f);
        prescription.setDate(new Date());
        prescription.setOptometrist("Dr. George Bush");
        assertEquals(true, prescription.addPrescription());
    }

    @Test
    public void testAddPrescription1s() {
        Prescription prescription = new Prescription();
        prescription.setPrescID(1);
        prescription.setFirstName("Bob");
        //should fail cause last name too long
        prescription.setLastName("Simpson Jr the third");
        prescription.setAddress("Melbourne 3000 Australia");
        prescription.setSphere(11.0f);
        prescription.setCylinder(2.0f);
        prescription.setAxis(150.0f);
        prescription.setDate(new Date());
        prescription.setOptometrist("Dr. George Bush");
        assertEquals(true, prescription.addPrescription());
    }

    @Test
    public void testAddPrescription2() {
        Prescription prescription = new Prescription();
        prescription.setPrescID(1);
        prescription.setFirstName("Bobby");
        prescription.setLastName("Simpson");
        //should fail cause address is not a string
        prescription.setAddress(123);
        prescription.setSphere(11.0f);
        prescription.setCylinder(2.0f);
        prescription.setAxis(150.0f);
        prescription.setDate(new Date());
        prescription.setOptometrist("Dr. George Bush");
        assertEquals(true, prescription.addPrescription());
    }

    @Test
    public void testAddPrescription2s() {
        Prescription prescription = new Prescription();
        prescription.setPrescID(1);
        prescription.setFirstName("Bobby");
        prescription.setLastName("Simpson");
        //should fail cause address is too short
        prescription.setAddress("Sydney");
        prescription.setSphere(11.0f);
        prescription.setCylinder(2.0f);
        prescription.setAxis(150.0f);
        prescription.setDate(new Date());
        prescription.setOptometrist("Dr. George Bush");
        assertEquals(true, prescription.addPrescription());
    }

    @Test
    public void testAddPrescription3() {
        Prescription prescription = new Prescription();
        prescription.setPrescID(1);
        prescription.setFirstName("Bobby");
        prescription.setLastName("Simpson");
        prescription.setAddress("Melbourne 3000 Australia");
        prescription.setSphere(11.0f);
        prescription.setCylinder(2.0f);
        //should fail cause axis float value is above boundary
        prescription.setAxis(200.0f);
        prescription.setDate(new Date());
        prescription.setOptometrist("Dr. George Bush");
        assertEquals(true, prescription.addPrescription());
    }

    @Test
    public void testAddPrescription3s() {
        Prescription prescription = new Prescription();
        prescription.setPrescID(1);
        prescription.setFirstName("Bobby");
        prescription.setLastName("Simpson");
        prescription.setAddress("Melbourne 3000 Australia");
        //should fail because -24 is below boundary
        prescription.setSphere(-24.0f);
        prescription.setCylinder(2.0f);
        prescription.setAxis(150.0f);
        prescription.setDate(new Date());
        prescription.setOptometrist("Dr. George Bush");
        assertEquals(true, prescription.addPrescription());
    }

    @Test
    public void testAddPrescription4() {
        Prescription prescription = new Prescription();
        prescription.setPrescID(1);
        prescription.setFirstName("Bobby");
        prescription.setLastName("Simpson");
        prescription.setAddress("Melbourne 3000 Australia");
        prescription.setSphere(11.0f);
        prescription.setCylinder(2.0f);
        prescription.setAxis(150.0f);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            Date examinationDate = sdf.parse("11/12/2023"); 
            prescription.setDate(examinationDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        prescription.setOptometrist("Dr. George Bush");
        assertEquals(true, prescription.addPrescription());
    }
    
    @Test
    public void testAddPrescription4s() {
        Prescription prescription = new Prescription();
        prescription.setPrescID(1);
        prescription.setFirstName("Bobby");
        prescription.setLastName("Simpson");
        prescription.setAddress("Melbourne 3000 Australia");
        prescription.setSphere(11.0f);
        prescription.setCylinder(2.0f);
        prescription.setAxis(150.0f);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            Date examinationDate = sdf.parse("December 11th, 2024"); 
            prescription.setDate(examinationDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        prescription.setOptometrist("Dr. George Bush");
        assertEquals(true, prescription.addPrescription());
    }


    @Test
    public void testAddPrescription5() {
        Prescription prescription = new Prescription();
        prescription.setPrescID(1);
        prescription.setFirstName("Bobby");
        prescription.setLastName("Simpson");
        prescription.setAddress("Melbourne 3000 Australia");
        prescription.setSphere(11.0f);
        prescription.setCylinder(2.0f);
        prescription.setAxis(150.0f);
        prescription.setDate(new Date());
        //should fail because optometrist's name is too short
        prescription.setOptometrist("George");
        assertEquals(true, prescription.addPrescription());
    }

    @Test
    public void testAddPrescription5s() {
        Prescription prescription = new Prescription();
        prescription.setPrescID(1);
        prescription.setFirstName("Bobby");
        prescription.setLastName("Simpson");
        prescription.setAddress("Melbourne 3000 Australia");
        prescription.setSphere(11.0f);
        prescription.setCylinder(2.0f);
        prescription.setAxis(150.0f);
        prescription.setDate(new Date());
        //should fail because optometrist's name is too long
        prescription.setOptometrist("Dr. George Bushhhhhhhhhhhhhhhhhhhhhhhhhhh");
        assertEquals(true, prescription.addPrescription());
    }

    @Test
    public void testAddPrescription6() {
        Prescription prescription = new Prescription();
        prescription.setPrescID(1);
        prescription.setFirstName("Bobby");
        prescription.setLastName("Simpson");
        prescription.setAddress("Melbourne 3000 Australia");
        prescription.setSphere(11.0f);
        prescription.setCylinder(2.0f);
        prescription.setAxis(150.0f);
        prescription.setDate(new Date());
        prescription.setOptometrist("Dr. George Bush");
        assertEquals(true, prescription.addPrescription());
    }

    @Test
    public void testAddPrescription6s() {
        Prescription prescription = new Prescription();
        prescription.setPrescID(1);
        prescription.setFirstName("Stacy");
        prescription.setLastName("Smiths");
        prescription.setAddress("Collingwood 3066 Australia");
        prescription.setSphere(-18.0f);
        prescription.setCylinder(-3.0f);
        prescription.setAxis(120.0f);
        prescription.setDate(new Date());
        prescription.setOptometrist("Dr. George Bush");
        assertEquals(true, prescription.addPrescription());
    }


    //******************************************************************************


    @Test
    public void testAddRemark1() {
        Prescription prescription1 = new Prescription();
        boolean check = prescription1.addRemark("This is my first remark", "Client");
        assertEquals(true, check);
    }

    @Test
    public void testAddRemark1s() {
        Prescription prescription1s = new Prescription();
        boolean check = prescription1s.addRemark("The client is cool", "Optometrist");
        assertEquals(true, check);
    }

    @Test
    public void testAddRemark2() {
        Prescription prescription2 = new Prescription();
        boolean check = prescription2.addRemark("The store's sales are going up every day.", "Admin");
        assertEquals(true, check);
    }

    @Test
    public void testAddRemark2s() {
        Prescription prescription2s = new Prescription();
        boolean check = prescription2s.addRemark("My employees are doing well at their job", "Owner");
        assertEquals(true, check);
    }

    @Test
    public void testAddRemark3() {
        Prescription prescription3 = new Prescription();
        boolean check = prescription3.addRemark("this remark is for patient number 1 ", "Optometrist");
        assertEquals(true, check);
    }

    @Test
    public void testAddRemark3s() {
        Prescription prescription3s = new Prescription();
        boolean check = prescription3s.addRemark("my optometrist recommends this prescription for my glasses", "Client");
        assertEquals(true, check);
    }

    @Test
    public void testAddRemark4() {
        Prescription prescription4 = new Prescription();
        boolean check = prescription4.addRemark("", "Client");
        assertEquals(true, check);
    }

    @Test
    public void testAddRemark4s() {
        Prescription prescription4s = new Prescription();
        boolean check = prescription4s.addRemark("This is a remark by the optometrist", "");
        assertEquals(true, check);
    }

    @Test
    public void testAddRemark5() {
        Prescription prescription5 = new Prescription();
        prescription5.addRemark("This is a tester remark, remark number 1", "Client");
        prescription5.addRemark("This is a tester remark, remark number 2", "Client");
        boolean check = prescription5.addRemark("This is the third remark for the client.", "Client");
        assertEquals(true, check);
    }

    @Test
    public void testAddRemark6() {
        Prescription prescription6 = new Prescription();
        boolean check = prescription6.addRemark("This client needs to be rescheduled for an appointment", "Optometrist");
        assertEquals(true, check);
    }

    @Test
    public void testAddRemark6s() {
        Prescription prescription6s = new Prescription();
        boolean check = prescription6s.addRemark("My optometrist was very helpful and I am satisfied.", "Client");
        assertEquals(true, check);
    }



}
