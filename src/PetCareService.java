Import java.util.*;
Class Owner extends Person implements PetCareService {
    Private final String password;
    Private final List<Animal> pets = new ArrayList<>();
    Public Owner(int id, String name, String contact, String password) {
        Super(id, name, contact);
        This.password = password;
    }
    Public boolean login(String pass) {
        Return password.equals(pass);
    }

    Public void adoptPet(Animal pet) {
        Pets.add(pet);
        System.out.println(getName() + “ adopted “ + pet.getName());
    }

    Public List<Animal> getPets() {
        Return pets;
    }

    Public void feedPet(Animal animal) {
        System.out.println(getName() + “ feeds “ + animal.getName());
    }

    Public void playWithPet(Animal animal) {
        System.out.println(getName() + “ plays with “ + animal.getName());
    }

    Public void groomPet(Animal animal) {
        System.out.println(getName() + “ grooms “ + animal.getName());
    }
}