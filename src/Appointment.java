import java.util.*;

public class Appointment {

    private static int counter = 1;
    private static final Map<String, List<String>> appointmentHistory = new HashMap<>();

    private final int appointmentId;
    private final String date;
    private final String time;

    public Appointment(String date, String time) {
        this.appointmentId = counter++;
        this.date = date;
        this.time = time;
    }

    public void createAppointment(Owner owner, Animal pet) {

        String entry = "ID#" + appointmentId + " | " + date + " " + time;

        appointmentHistory
                .computeIfAbsent(pet.getName(), k -> new ArrayList<>())
                .add(entry);

        System.out.println("\nAppointment Created");
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Owner: " + owner.getName());
        System.out.println("Pet: " + pet.getName());
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
    }

    public static void viewAppointments() {

        System.out.println("\n========== APPOINTMENT HISTORY ==========");

        if (appointmentHistory.isEmpty()) {
            System.out.println("No appointment history.");
            return;
        }

        for (String pet : appointmentHistory.keySet()) {
            System.out.println("\nPet: " + pet);
            for (String appt : appointmentHistory.get(pet)) {
                System.out.println(appt);
            }
        }
    }

    public int getAppointmentId() {
        return appointmentId;
    }
}