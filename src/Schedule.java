import java.util.*;

public class Schedule {

    private final List<Appointment> appointments = new ArrayList<>();

    public void addAppointment(Appointment appt) {
        appointments.add(appt);
        System.out.println("Appointment added to schedule.");
    }

    public void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
            return;
        }

        System.out.println("\n===== CLINIC SCHEDULE =====");
        for (Appointment appt : appointments) {
            System.out.println("Appointment ID: " + appt.getAppointmentId());
        }
    }
}