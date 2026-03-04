public class PetProfile {

    private String petName;
    private String ownerName;
    private String breed;

    public PetProfile(String petName, String ownerName, String breed) {
        this.petName = petName;
        this.ownerName = ownerName;
        this.breed = breed;
    }

    public void displayProfile() {
        System.out.println("\n===== PET PROFILE =====");
        System.out.println("Pet Name: " + petName);
        System.out.println("Owner: " + ownerName);
        System.out.println("Breed: " + breed);
    }
}