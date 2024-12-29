package com.Java;
import java.util.*;

//Main Hospital Management System Class
public class HospitalManagementSystem {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     PatientRegistration patientRegistration = new PatientRegistration();
     AppointmentScheduler appointmentScheduler = new AppointmentScheduler();
     EHR ehr = new EHR();
     Billing billing = new Billing();
     InventoryManagement inventoryManagement = new InventoryManagement();
     StaffManagement staffManagement = new StaffManagement();

     while (true) {
         System.out.println("\nHospital Management System");
         System.out.println("1. Patient Registration");
         System.out.println("2. Appointment Scheduling");
         System.out.println("3. Electronic Health Records");
         System.out.println("4. Billing and Invoicing");
         System.out.println("5. Inventory Management");
         System.out.println("6. Staff Management");
         System.out.println("7. Exit");
         System.out.print("Choose an option: ");
         int choice = scanner.nextInt();
         scanner.nextLine();

         switch (choice) {
             case 1:
                 patientRegistration.manage(scanner);
                 break;
             case 2:
                 appointmentScheduler.manage(scanner);
                 break;
             case 3:
                 ehr.manage(scanner);
                 break;
             case 4:
                 billing.manage(scanner);
                 break;
             case 5:
                 inventoryManagement.manage(scanner);
                 break;
             case 6:
                 staffManagement.manage(scanner);
                 break;
             case 7:
                 System.out.println("Exiting system. Goodbye!");
                 scanner.close();
                 return;
             default:
                 System.out.println("Invalid choice. Please try again.");
         }
     }
 }
}

//Patient Registration Module
class PatientRegistration {
 private List<Patient> patients = new ArrayList<>();

 public void manage(Scanner scanner) {
     System.out.println("\nPatient Registration Module");
     System.out.print("Enter patient ID: ");
     int id = scanner.nextInt();
     scanner.nextLine();
     System.out.print("Enter patient name: ");
     String name = scanner.nextLine();
     System.out.print("Enter patient age: ");
     int age = scanner.nextInt();
     scanner.nextLine();
     patients.add(new Patient(id, name, age));
     System.out.println("Patient registered successfully.");
 }
}

class Patient {
 private int id;
 private String name;
 private int age;

 public Patient(int id, String name, int age) {
     this.id = id;
     this.name = name;
     this.age = age;
 }

 @Override
 public String toString() {
     return "Patient ID: " + id + ", Name: " + name + ", Age: " + age;
 }
}

//Appointment Scheduling Module
class AppointmentScheduler {
 private List<Appointment> appointments = new ArrayList<>();

 public void manage(Scanner scanner) {
     System.out.println("\nAppointment Scheduling Module");
     System.out.print("Enter appointment ID: ");
     int id = scanner.nextInt();
     scanner.nextLine();
     System.out.print("Enter patient name: ");
     String patientName = scanner.nextLine();
     System.out.print("Enter appointment date (e.g., 2024-12-30): ");
     String date = scanner.nextLine();
     appointments.add(new Appointment(id, patientName, date));
     System.out.println("Appointment scheduled successfully.");
 }
}

class Appointment {
 private int id;
 private String patientName;
 private String date;

 public Appointment(int id, String patientName, String date) {
     this.id = id;
     this.patientName = patientName;
     this.date = date;
 }

 @Override
 public String toString() {
     return "Appointment ID: " + id + ", Patient Name: " + patientName + ", Date: " + date;
 }
}

//Electronic Health Records (EHR) Module
class EHR {
 private Map<Integer, String> records = new HashMap<>();

 public void manage(Scanner scanner) {
     System.out.println("\nEHR Module");
     System.out.print("Enter patient ID: ");
     int id = scanner.nextInt();
     scanner.nextLine();
     System.out.print("Enter health record details: ");
     String record = scanner.nextLine();
     records.put(id, record);
     System.out.println("EHR updated successfully.");
 }
}

//Billing and Invoicing Module
class Billing {
 private List<Invoice> invoices = new ArrayList<>();

 public void manage(Scanner scanner) {
     System.out.println("\nBilling and Invoicing Module");
     System.out.print("Enter invoice ID: ");
     int id = scanner.nextInt();
     scanner.nextLine();
     System.out.print("Enter patient name: ");
     String patientName = scanner.nextLine();
     System.out.print("Enter amount: ");
     double amount = scanner.nextDouble();
     scanner.nextLine();
     invoices.add(new Invoice(id, patientName, amount));
     System.out.println("Invoice generated successfully.");
 }
}

class Invoice {
 private int id;
 private String patientName;
 private double amount;

 public Invoice(int id, String patientName, double amount) {
     this.id = id;
     this.patientName = patientName;
     this.amount = amount;
 }

 @Override
 public String toString() {
     return "Invoice ID: " + id + ", Patient Name: " + patientName + ", Amount: $" + amount;
 }
}

//Inventory Management Module
class InventoryManagement {
 private Map<String, Integer> inventory = new HashMap<>();

 public void manage(Scanner scanner) {
     System.out.println("\nInventory Management Module");
     System.out.print("Enter item name: ");
     String item = scanner.nextLine();
     System.out.print("Enter quantity: ");
     int quantity = scanner.nextInt();
     scanner.nextLine();
     inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
     System.out.println("Inventory updated successfully.");
 }
}

//Staff Management Module
class StaffManagement {
 private List<Staff> staffList = new ArrayList<>();

 public void manage(Scanner scanner) {
     System.out.println("\nStaff Management Module");
     System.out.print("Enter staff ID: ");
     int id = scanner.nextInt();
     scanner.nextLine();
     System.out.print("Enter staff name: ");
     String name = scanner.nextLine();
     System.out.print("Enter staff role: ");
     String role = scanner.nextLine();
     staffList.add(new Staff(id, name, role));
     System.out.println("Staff added successfully.");
 }
}

class Staff {
 private int id;
 private String name;
 private String role;

 public Staff(int id, String name, String role) {
     this.id = id;
     this.name = name;
     this.role = role;
 }

 @Override
 public String toString() {
     return "Staff ID: " + id + ", Name: " + name + ", Role: " + role;
 }
}
