package AnimalsTest;

import Animals.Cat;
import Animals.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CatTest
{
    @Test
    void TestConstructor()
    {
        Cat cat = new Cat("kattie", Gender.Male, "Luiheid", 19.99);

        String name = "kattie";
        Gender gender = Gender.Male;
        String badHabits = "Luiheid";
        Double price = 19.99;

        boolean result = false;
        if(cat.getName().equals(name) && cat.getGender().equals(gender) && cat.getBadHabits().equals(badHabits) &&  cat.getPrice().equals(price))
        {
            result = true;
        }

        Assertions.assertTrue(result);
    }
}
