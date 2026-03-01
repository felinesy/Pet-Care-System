class Dog extends Animal {
    public Dog(String name, int age, String breed) {
        super(name, age, breed);
    }
    public void makeSound() {
        System.out.println(getName() + "says: Woof");
    }
    public void eat() {
        System.out.println(getName() + "is eating.");
    }
    public void sleep() {
        System.out.println(getName() +  "is sleeping.");
    }
}