package com.hospital.service;

import java.util.ArrayList;

import com.hospital.exception.PatientNotFoundException;
import com.hospital.model.Appointment;
import com.hospital.model.Doctor;
import com.hospital.model.Patient;

public class HospitalService {

    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();

    private int patientIdGenerator = 101;
    private int appointmentIdGenerator = 1001;

    public HospitalService() {
        doctors.add(new Doctor(1, "Dr. Rajesh", "Cardiologist", 500));
        doctors.add(new Doctor(2, "Dr. Priya", "Dermatologist", 400));
        doctors.add(new Doctor(3, "Dr. Kumar", "Neurologist", 600));
        doctors.add(new Doctor(4, "Dr. Anitha", "General Physician", 300));
    }

    public void addPatient(String name, int age, String disease) {
        Patient patient = new Patient(patientIdGenerator, name, age, disease);
        patients.add(patient);

        System.out.println("Patient added successfully!");
        System.out.println("Patient ID: " + patientIdGenerator);

        patientIdGenerator++;
    }

    public void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        System.out.println("\n========== PATIENT DETAILS ==========");

        for (Patient patient : patients) {
            System.out.println("Patient ID : " + patient.getPatientId());
            System.out.println("Name       : " + patient.getPatientName());
            System.out.println("Age        : " + patient.getAge());
            System.out.println("Disease    : " + patient.getDisease());
            System.out.println("------------------------------------");
        }
    }

    public void viewDoctors() {
        System.out.println("\n========== DOCTOR DETAILS ==========");

        for (Doctor doctor : doctors) {
            System.out.println("Doctor ID        : " + doctor.getDoctorId());
            System.out.println("Doctor Name      : " + doctor.getDoctorName());
            System.out.println("Specialization   : " + doctor.getSpecialization());
            System.out.println("Consultation Fee : ₹" + doctor.getConsultationFee());
            System.out.println("-----------------------------------");
        }
    }

    public Patient findPatientById(int patientId) throws PatientNotFoundException {
        for (Patient patient : patients) {
            if (patient.getPatientId() == patientId) {
                return patient;
            }
        }

        throw new PatientNotFoundException("Patient not found with ID: " + patientId);
    }

    public Doctor findDoctorById(int doctorId) {
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorId() == doctorId) {
                return doctor;
            }
        }

        return null;
    }

    public void bookAppointment(int patientId, int doctorId) throws PatientNotFoundException {
        Patient patient = findPatientById(patientId);
        Doctor doctor = findDoctorById(doctorId);

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        Appointment appointment = new Appointment(appointmentIdGenerator, patient, doctor);
        appointments.add(appointment);

        System.out.println("Appointment booked successfully!");
        System.out.println("Appointment ID: " + appointmentIdGenerator);
        System.out.println("Patient Name  : " + patient.getPatientName());
        System.out.println("Doctor Name   : " + doctor.getDoctorName());

        appointmentIdGenerator++;
    }

    public void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        System.out.println("\n========== APPOINTMENT DETAILS ==========");

        for (Appointment appointment : appointments) {
            System.out.println("Appointment ID : " + appointment.getAppointmentId());
            System.out.println("Patient Name   : " + appointment.getPatient().getPatientName());
            System.out.println("Doctor Name    : " + appointment.getDoctor().getDoctorName());
            System.out.println("Specialization : " + appointment.getDoctor().getSpecialization());
            System.out.println("----------------------------------------");
        }
    }

    public void generateBill(int patientId) throws PatientNotFoundException {
        Patient patient = findPatientById(patientId);

        double consultationFee = 300;
        double medicineFee = 500;
        double serviceCharge = 200;

        double totalBill = consultationFee + medicineFee + serviceCharge;

        System.out.println("\n========== HOSPITAL BILL ==========");
        System.out.println("Patient ID       : " + patient.getPatientId());
        System.out.println("Patient Name     : " + patient.getPatientName());
        System.out.println("Disease          : " + patient.getDisease());
        System.out.println("Consultation Fee : ₹" + consultationFee);
        System.out.println("Medicine Fee     : ₹" + medicineFee);
        System.out.println("Service Charge   : ₹" + serviceCharge);
        System.out.println("----------------------------------");
        System.out.println("Total Bill       : ₹" + totalBill);
        System.out.println("==================================");
    }
}