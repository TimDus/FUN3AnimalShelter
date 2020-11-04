package Animals;

public class Cat extends Animal
{
    private String badHabits;

    public String getBadHabits()
    {
        return badHabits;
    }

    private void setBadHabits(String badHabits)
    {
        this.badHabits = badHabits;
    }

    public Cat(String name, Gender gender, String badHabits, Double price)
    {
        super(name, gender, price);
        this.badHabits = badHabits;
    }

    @Override
    public String toString()
    {
        return ", Bad Habits= " + badHabits.toLowerCase();
    }

}
