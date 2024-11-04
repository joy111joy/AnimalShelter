package org.example;


import java.util.LinkedList;

class AnimalShelter {
    private LinkedList<Dog> dogs;
    private LinkedList<Cat> cats;
    private int order;

    public AnimalShelter() {
        this.dogs = new LinkedList<>();
        this.cats = new LinkedList<>();
        this.order = 0;
    }

    public void enqueue(Animal animal) {
        animal.setTimestamp(order++);
        if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        }
        System.out.println(animal.getName() + " added to the shelter.");
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty() && cats.isEmpty()) {
            System.out.println("No animals available for adoption");
            return null;
        }
        if (dogs.isEmpty()) return dequeueCat();
        if (cats.isEmpty()) return dequeueDog();

        Dog oldestDog = dogs.peek();
        Cat oldestCat = cats.peek();
        if (oldestDog.getTimestamp() < oldestCat.getTimestamp()) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Dog dequeueDog() {
        if (dogs.isEmpty()) {
            System.out.println("No dogs available for adoption");
            return null;
        }
        return dogs.poll();
    }

    public Cat dequeueCat() {
        if (cats.isEmpty()) {
            System.out.println("No cats available for adoption");
            return null;
        }
        return cats.poll();
    }
}
