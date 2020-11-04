package Animals;

import java.util.ArrayList;
import java.util.List;

public class Reservation
{
    public List<Animal> Animals = new ArrayList<Animal>();

    public List<Animal> getAnimals()
    {
        return Animals;
    }

    public void setAnimals(ArrayList<Animal> animals){
        this.Animals = animals;
    }

    public void newCat(String name, Gender gender, String badHabits)
    {
        Double price = (double)Math.max(350 - badHabits.length() * 20, 35);
        this.Animals.add(new Cat(name, gender, badHabits, price));
    }

    public void newDog(String name, Gender gender)
    {
        int dogs = 0;
        for (Animal animal: Animals)
        {
            if(animal instanceof Dog){
                dogs++;
            }
        }

        Double price = (double)Math.max(500 - dogs * 50, 50);

        this.Animals.add(new Dog(name, gender, price));
    }

}
