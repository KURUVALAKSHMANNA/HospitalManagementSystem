package com.hospital.model;

public class Appointment {
    private int appointmentId;
    private Patient patient;
    private Doctor doctor;

    public Appointment(int appointmentId, Patient patient, Doctor doctor) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}