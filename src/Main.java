import java.util.*;

public class Main {

    static void line() {
        System.out.println("-------------------------------------");
    }

    static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                int val = sc.nextInt();
                sc.nextLine();
                return val;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Veterinarian vet = new Veterinarian(1, "Santos", "0999");
        Clinic clinic = new Clinic("Pet Care Clinic", "City");
        MedicalRecord record = new MedicalRecord();

        List<Owner> owners = new ArrayList<>();
        Owner currentOwner = null;

        while (true) {

            if (currentOwner == null) {

                System.out.println("\n===========================");
                System.out.println("      1PET CARE SYSTEM");
                System.out.println("===========================");

                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");

                int choice = readInt(sc, "Choice: ");

                switch (choice) {

                    case 1:

                        System.out.print("Owner Name: ");
                        String name = sc.nextLine();

                        System.out.print("Contact Number: ");
                        String contact = sc.nextLine();

                        System.out.print("Password: ");
                        String pass = sc.nextLine();

                        Owner owner = new Owner(
                                owners.size() + 1,
                                name,
                                contact,
                                pass
                        );

                        owners.add(owner);

                        System.out.println("Registration successful!");
                        break;

                    case 2:

                        System.out.print("Enter Owner Name: ");
                        String loginName = sc.nextLine();

                        System.out.print("Password: ");
                        String loginPass = sc.nextLine();

                        currentOwner = null;

                        for (Owner o : owners) {
                            if (o.getName().equalsIgnoreCase(loginName)
                                    && o.login(loginPass)) {
                                currentOwner = o;
                                break;
                            }
                        }

                        if (currentOwner == null)
                            System.out.println("Login failed.");
                        else
                            System.out.println("Login successful! Welcome, " + currentOwner.getName() + "!");

                        break;

                    case 3:
                        System.out.println("Exiting system...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }

            else {

                System.out.println("\n===========================");
                System.out.println("        OWNER MENU");
                System.out.println("===========================");
                System.out.println("Logged in as: " + currentOwner.getName());

                System.out.println("1. Add Pets");
                System.out.println("2. Veterinary Checkup");
                System.out.println("3. Owner Dashboard");
                System.out.println("4. View Medical Records");
                System.out.println("5. View Appointment History");
                System.out.println("6. Logout");

                int choice = readInt(sc, "Choice: ");

                switch (choice) {

                    case 1:

                        int count = readInt(sc, "How many pets? ");

                        for (int i = 0; i < count; i++) {

                            System.out.print("Pet Name: ");
                            String petName = sc.nextLine();

                            int age = readInt(sc, "Age: ");

                            System.out.print("Breed: ");
                            String breed = sc.nextLine();

                            int type = readInt(sc, "Type (1 Cat / 2 Dog): ");

                            Animal pet;

                            if (type == 1)
                                pet = new Cat(petName, age, breed);
                            else
                                pet = new Dog(petName, age, breed);

                            currentOwner.adoptPet(pet);

                            // UTILIZE PetProfile
                            PetProfile profile = new PetProfile(
                                    pet.getName(),
                                    currentOwner.getName(),
                                    pet.getBreed()
                            );

                            profile.displayProfile();
                        }

                        break;

                    case 2:

                        if (currentOwner.getPets().isEmpty()) {
                            System.out.println("No pets available.");
                            break;
                        }

                        System.out.print("Enter Appointment Date: ");
                        String date = sc.nextLine();

                        System.out.print("Enter Appointment Time: ");
                        String time = sc.nextLine();

                        int session = 1;

                        for (Animal pet : currentOwner.getPets()) {

                            System.out.println("\nCHECKUP SESSION #" + session++);
                            line();

                            Appointment appt = new Appointment(date, time);

                            appt.createAppointment(currentOwner, pet);

                            clinic.schedule(appt);

                            vet.treatPet(pet);

                            System.out.println("\nDr. " + vet.getName() +
                                    " is examining " + pet.getName());

                            String[] result = vet.diagnose();

                            System.out.println("\nDiagnosis: " + result[0]);
                            System.out.println("Treatment: " + result[1]);

                            record.addRecord(
                                    pet.getName(),
                                    result[0],
                                    result[1]
                            );

                            System.out.println("\nCare Procedures:");

                            vet.feedPet(pet);
                            vet.playWithPet(pet);
                            vet.groomPet(pet);

                            System.out.println("\nPet Activity:");

                            pet.makeSound();
                            pet.eat();
                            pet.sleep();

                            line();
                        }

                        break;

                    case 3:

                        System.out.println("\n===== OWNER DASHBOARD =====");

                        System.out.println("Owner: " + currentOwner.getName());
                        System.out.println("Contact: " + currentOwner.getContact());
                        System.out.println("Total Pets: " + currentOwner.getPets().size());

                        for (Animal pet : currentOwner.getPets()) {

                            System.out.println(
                                    "ID: " + pet.getId()
                                            + " | " + pet.getName()
                                            + " | Age: " + pet.getAge()
                                            + " | Breed: " + pet.getBreed()
                            );
                        }

                        break;

                    case 4:

                        record.viewRecords();
                        break;

                    case 5:

                        Appointment.viewAppointments();
                        break;

                    case 6:

                        System.out.println("Logged out successfully!");
                        currentOwner = null;
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }
}
