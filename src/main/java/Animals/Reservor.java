package Animals;

import java.time.LocalDateTime;

public class Reservor
{
    private String name;
    private LocalDateTime reservedAt;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        name = name;
    }

    public LocalDateTime getReservedAt()
    {
        return reservedAt;
    }

    public void setReservedAt(LocalDateTime reservedAt)
    {
        reservedAt = reservedAt;
    }

    public Reservor(String name, LocalDateTime reservedAt)
    {
        this.name = name;
        this.reservedAt = reservedAt;
    }
}
