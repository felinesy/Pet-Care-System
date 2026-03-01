public class Clinic {

    private final String name;
    private final String location;

    public Clinic(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void schedule(Appointment appt) {
        System.out.println("\nClinic: " + name + " (" + location + ")");
        System.out.println("Appointment ID: " + appt.getAppointmentId());
        System.out.println("Appointment scheduled successfully.");
    }
}