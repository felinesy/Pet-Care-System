import java.util.ArrayList;
import java.util.List;

public class MedicalRecord {

    private List<String> records = new ArrayList<>();

    public void addRecord(String petName, String diagnosis, String treatment) {
        records.add("Pet: " + petName +
                " | Diagnosis: " + diagnosis +
                " | Treatment: " + treatment);
    }

    public void viewRecords() {
        if (records.isEmpty()) {
            System.out.println("No medical records.");
            return;
        }

        System.out.println("\n===== MEDICAL RECORDS =====");

        for (String r : records) {
            System.out.println(r);
        }
    }
}