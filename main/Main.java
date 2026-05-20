package com.hospital.main;

import java.util.Scanner;

import com.hospital.exception.PatientNotFoundException;
import com.hospital.service.HospitalService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HospitalService hospitalService = new HospitalService();

        int choice;

        do {
            System.out.println("\n========== HOSPITAL MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. View Doctor Details");
            System.out.println("4. Book Appointment");
            System.out.println("5. View Appointments");
            System.out.println("6. Generate Bill");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Patient Age: ");
                    int age = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Disease: ");
                    String disease = sc.nextLine();

                    hospitalService.addPatient(name, age, disease);
                    break;

                case 2:
                    hospitalService.viewPatients();
                    break;

                case 3:
                    hospitalService.viewDoctors();
                    break;

                case 4:
                    try {
                        System.out.print("Enter Patient ID: ");
                        int patientId = sc.nextInt();

                        hospitalService.viewDoctors();

                        System.out.print("Enter Doctor ID: ");
                        int doctorId = sc.nextInt();

                        hospitalService.bookAppointment(patientId, doctorId);

                    } catch (PatientNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    hospitalService.viewAppointments();
                    break;

                case 6:
                    try {
                        System.out.print("Enter Patient ID: ");
                        int billPatientId = sc.nextInt();

                        hospitalService.generateBill(billPatientId);

                    } catch (PatientNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:
                    System.out.println("Thank you for using Hospital Management System.");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}