abstract class Animal {
    private static int counter = 1;
    private final int id;
    private final String name;
    private final int age;
    private final String breed;
    public Animal(String name, int age, String breed) {
        this.id = counter++;
        this.name = name;
        this.age = age;
        this.breed = breed;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getBreed() { return breed; }
    public abstract void makeSound();
    public abstract void eat();
    public abstract void sleep();
}