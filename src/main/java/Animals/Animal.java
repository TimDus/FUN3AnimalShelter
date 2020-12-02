package Animals;

import Interfaces.ISellable;

import java.time.LocalDateTime;

public class Animal implements ISellable
{
    private String name;
    private Gender gender;
    private Double price;
    private Reservor reservedBy;

    public Animal(String name, Gender gender, Double price)
    {
        this.name = name;
        this.gender = gender;
        this.price = price;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    private void setName(String name)
    {
        this.name = name;
    }

    public Gender getGender()
    {
        return gender;
    }

    private void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public Reservor getReservedBy()
    {
        return reservedBy;
    }

    private void setReservedBy(Reservor reservedBy)
    {
        this.reservedBy = reservedBy;
    }

    public Boolean Reserve(String reservedBy)
    {
        if (this.reservedBy == null) {
            this.reservedBy = new Reservor(reservedBy, LocalDateTime.now());
            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        String reserved = "not reserved";
        if (this.reservedBy != null)
        {
            reserved = "Reserved by= " + this.reservedBy.Name;
        }
        return "Name= " + Name + ", Gender= " + gender + reserved;
    }

}
