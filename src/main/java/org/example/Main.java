package org.example;

public class Main {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        shelter.enqueue(new Dog("Cabot"));
        shelter.enqueue(new Cat("Tibby"));
        shelter.enqueue(new Dog("Paddy"));
        shelter.enqueue(new Cat("Gus"));

        System.out.println("Adopting any animal: " + shelter.dequeueAny().getName());
        System.out.println("Adopting a dog: " + shelter.dequeueDog().getName());
        System.out.println("Adopting a cat: " + shelter.dequeueCat().getName());
    }
}
