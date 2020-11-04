package Animals;

import java.time.LocalDateTime;

public class Reservor
{
    public String Name;
    public LocalDateTime ReservedAt;

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public LocalDateTime getReservedAt()
    {
        return ReservedAt;
    }

    public void setReservedAt(LocalDateTime reservedAt)
    {
        ReservedAt = reservedAt;
    }

    public Reservor(String name, LocalDateTime reservedAt)
    {
        this.Name = name;
        this.ReservedAt = reservedAt;
    }
}
