package test;

import model.Airplane;
import queues.BinaryHeap;

import java.util.PriorityQueue;

public class TestPriorityQueue
{
    public static void main(String[] args)
    {
        BinaryHeap<Airplane> airTrafficController = new BinaryHeap<>();

        //add a few planes
        Airplane chicagoFlight = new Airplane("CHI 222", 400.0);

        airTrafficController.add(new Airplane("SEA 101", 500.0));
        airTrafficController.add(new Airplane("SEA 202", 250.0));
        airTrafficController.add(new Airplane("TAC 303", 750.0));
        airTrafficController.add(new Airplane("LOS 198", 150.0));
        airTrafficController.add(new Airplane("LOS 199", 300.0));
        airTrafficController.add(chicagoFlight);
        airTrafficController.add(new Airplane("CHI 333", 500.0));
        airTrafficController.add(new Airplane("LAG 101", 110.0));
        airTrafficController.add(new Airplane("LAG 201", 220.0));
        airTrafficController.add(new Airplane("BOS 999", 300.0));

        //then land them one by one
        /*while (!airTrafficController.isEmpty())
        {
            //land a single plane
            Airplane plane = airTrafficController.poll();
            System.out.println("Plane landed: " + plane.getPlaneId());
        }*/

        //we have space to land three planes
        for (int i = 1; i <= 3; i++)
        {
            Airplane plane = airTrafficController.remove();
            System.out.println("Plane landed: " + plane.getPlaneId());
        }

        //a few more planes arrive
        airTrafficController.add(new Airplane("PORT 104", 90.0));
        airTrafficController.add(new Airplane("PORT 204", 190.0));

        //a plane dumps some of it's fuel
        /*airTrafficController.remove(chicagoFlight);
        chicagoFlight.setFuelRemaining(50.0);
        airTrafficController.add(chicagoFlight);*/

        //we have space to land two planes
        for (int i = 1; i <= 2; i++)
        {
            Airplane plane = airTrafficController.remove();
            System.out.println("Plane landed: " + plane.getPlaneId());
        }
    }
}
