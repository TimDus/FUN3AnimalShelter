package AnimalsTest;

import Animals.Animal;
import Animals.Gender;
import Animals.Reservor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;

public class AnimalTest
{
    @Test
    void TestConstructor()
    {
        Animal animal = new Animal("Hondje", Gender.Female, 19.99);

        String name = "Hondje";
        Gender gender = Gender.Female;
        Double price = 19.99;

        boolean result = false;
        if(animal.getName().equals(name) && animal.getGender().equals(gender) && animal.getPrice().equals(price))
        {
            result = true;
        }

        Assertions.assertTrue(result);
    }
}
