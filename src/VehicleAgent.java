package com.PRACTISE.agents;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class VehicleAgent extends Agent {

    private int distanceTravelled = 0;

    @Override
    protected void setup() {
        System.out.println("🚗 Vehicle Agent " + getAID().getName() + " is starting its journey.");

        // Add a TickerBehaviour to simulate the vehicle moving every 2 seconds
        addBehaviour(new TickerBehaviour(this, 2000) {
            @Override
            protected void onTick() {
                distanceTravelled += 10; // Move 10 meters every 2 seconds
                System.out.println("🚗 " + myAgent.getLocalName() + ": ...moving... Distance travelled: " + distanceTravelled + "m.");
            }
        });
    }
}
