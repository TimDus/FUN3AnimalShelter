package AnimalsTest;

import Animals.Reservor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;

public class ReservorTest
{
    @Test
    void TestConstructor()
    {
        Reservor reservor = new Reservor("Jan", LocalDateTime.of(2020, 11, 11, 11, 0, 0));

        String name = "Jan";
        LocalDateTime date = LocalDateTime.of(2020, 11, 11, 11, 0, 0);

        boolean result = false;
        if(reservor.getName().equals(name) && reservor.getReservedAt().equals(date))
        {
            result = true;
        }

        Assertions.assertTrue(result);
    }

    @Test
    void TestPropertiesName() {
        //ARRANGE
        Reservor reservor = new Reservor("Jan", LocalDateTime.now());

        //ACT
        reservor.setName("Piet");

        String name = "Piet";
        Assertions.assertEquals(reservor.getName(), name);
    }

    @Test
    void TestPropertiesReservedDate() {
        Reservor reservor = new Reservor("Jan", LocalDateTime.now());

        reservor.setReservedAt(LocalDateTime.of(2020, 11, 11, 11, 0, 0));

        LocalDateTime date = LocalDateTime.of(2020, 11, 11, 11, 0, 0);
        Assertions.assertEquals(reservor.getReservedAt(), date);
    }
}

