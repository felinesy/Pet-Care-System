import java.util.Random;

public class Veterinarian {

    private int id;
    private String name;
    private String contact;

    public Veterinarian(int id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void treatPet(Animal pet) {
        System.out.println("Treating " + pet.getName());
    }

    public String[] diagnose() {
        String[] problems = {
                "Fever", "Infection", "Skin Allergy", "Stomach Pain", "Minor Injury"
        };

        String[] treatments = {
                "Medicine", "Antibiotics", "Ointment", "Diet Plan", "Rest"
        };

        Random r = new Random();

        String diagnosis = problems[r.nextInt(problems.length)];
        String treatment = treatments[r.nextInt(treatments.length)];

        return new String[]{diagnosis, treatment};
    }

    public void feedPet(Animal pet) {
        System.out.println("Feeding " + pet.getName());
    }

    public void playWithPet(Animal pet) {
        System.out.println("Playing with " + pet.getName());
    }

    public void groomPet(Animal pet) {
        System.out.println("Grooming " + pet.getName());
    }
}