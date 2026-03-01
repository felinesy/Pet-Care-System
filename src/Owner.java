import java.util.*;

class Owner extends Person implements PetCareService {

    private final String password;
    private final List<Animal> pets = new ArrayList<>();

    public Owner(int id, String name, String contact, String password) {
        super(id, name, contact);
        this.password = password;
    }

    public boolean login(String pass) {
        return password.equals(pass);
    }

    public void adoptPet(Animal pet) {
        pets.add(pet);
        System.out.println(getName() + " adopted " + pet.getName());
    }

    public List<Animal> getPets() {
        return pets;
    }

    public void feedPet(Animal animal) {
        System.out.println(getName() + " feeds " + animal.getName());
    }

    public void playWithPet(Animal animal) {
        System.out.println(getName() + " plays with " + animal.getName());
    }

    public void groomPet(Animal animal) {
        System.out.println(getName() + " grooms " + animal.getName());
    }
}