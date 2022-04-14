package model;

public class Airplane implements Comparable<Airplane>
{
    private String planeId;
    private double fuelRemaining; //gallons

    public Airplane(String planeId, double fuelRemaining)
    {
        this.planeId = planeId;
        this.fuelRemaining = fuelRemaining;
    }

    @Override
    public int compareTo(Airplane other)
    {
        if (this.fuelRemaining < other.fuelRemaining)
        {
            return -1;
        }
        else if (this.fuelRemaining > other.fuelRemaining)
        {
            return 1;
        }
        else
        {
            return 0;
        }
        /*return this.planeId.compareTo(other.planeId);*/
    }

    public String getPlaneId()
    {
        return planeId;
    }

    public double getFuelRemaining()
    {
        return fuelRemaining;
    }

    public void setPlaneId(String planeId)
    {
        this.planeId = planeId;
    }

    public void setFuelRemaining(double fuelRemaining)
    {
        this.fuelRemaining = fuelRemaining;
    }

    @Override
    public String toString()
    {
        return String.valueOf(fuelRemaining);
    }
}
