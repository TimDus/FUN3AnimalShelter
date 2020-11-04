package Animals;

import java.time.Duration;
import java.time.LocalDateTime;

public class Dog extends Animal
{
    private LocalDateTime lastWalk;

    public LocalDateTime getLastWalk()
    {
        return lastWalk;
    }

    private void setLastWalk(LocalDateTime lastWalk)
    {
        this.lastWalk = lastWalk;
    }

    public Boolean needsWalk()
    {
        return Duration.between(LocalDateTime.now(), this.lastWalk).toDays() > 0;
    }

    public Dog(String name, Gender gender, Double price)
    {
        super(name, gender, price);
        this.lastWalk = LocalDateTime.now();
    }

    @Override
    public String toString()
    {
        return ", LastWalk: " + lastWalk.toString();
    }

}
