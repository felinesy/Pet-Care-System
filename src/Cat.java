class Cat extends Animal {
    public Cat(String name, int age, String breed) {
        super(name, age, breed);
    }
    public void makeSound() {
        System.out.println(getName() + " says: Meow");
    }
    public void eat() {
        System.out.println(getName() + " is eating.");
        System.out.println(getName() + " is requesting for Treats.");
        
    }
    public void sleep() {
        System.out.println(getName() + " is sleeping.");
        System.out.println("Do Not Disturb!");
    }
}
