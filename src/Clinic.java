public class Clinic {

    private final String name;
    private final String location;
    private final Schedule schedule;   // Clinic HAS Schedule

    public Clinic(String name, String location) {
        this.name = name;
        this.location = location;
        this.schedule = new Schedule();   // create Schedule object
    }

    // MUST match Main: clinic.schedule(appt)
    public void schedule(Appointment appt) {

        System.out.println("\nClinic: " + name + " (" + location + ")");
        schedule.addAppointment(appt);   // delegate to Schedule
        System.out.println("Appointment scheduled successfully.");
    }

    // Optional (not required by Main)
    public void viewClinicSchedule() {
        schedule.viewAppointments();
    }
}