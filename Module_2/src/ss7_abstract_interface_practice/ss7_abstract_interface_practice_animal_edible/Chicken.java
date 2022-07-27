package ss7_abstract_interface_practice.ss7_abstract_interface_practice_animal_edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "Could be fried";
    }
}
