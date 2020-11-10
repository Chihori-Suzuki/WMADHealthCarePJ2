package ca.healthcare.pj;


import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment implements Comparable<Appointment> {
	private Patient patient;
	private LocalDate appointmentDate;
	private LocalTime appointmentTime;
	
	public Appointment(Patient patient, LocalDate appointmentDate, LocalTime appointmentTime) {
//		super();
		this.patient = patient;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
	}
	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}
	/**
	 * @return the appointmentDate
	 */
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	
	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}
	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	/**
	 * @param appointmentDate the appointmentDate to set
	 */
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public void setAppointmenTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	
	public String toString() {
		return "\nPatient: " + patient + ". Appointment date: " + appointmentDate;
	}
	
	@Override
	public int compareTo(Appointment o) {
		return this.getAppointmentDate().compareTo(o.getAppointmentDate());
	} 
	
	
}
