class Cat extends Animal {
    public Cat(String name, int age, String breed) {
        super(name, age, breed);
    }
    public void makeSound() {
        System.out.println(getName() + “ says: Meow”);
    }
    public void eat() {
        System.out.println(getName() + “ is eating.”);
    }
    public void sleep() {
        System.out.println(getName() + “ is sleeping.”);
    }
}