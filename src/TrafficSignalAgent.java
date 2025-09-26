package com.PRACTISE.agents;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class TrafficSignalAgent extends Agent {

    private String currentState = "RED";
    private int cycleCount = 0;

    @Override
    protected void setup() {
        System.out.println("🚦 Traffic Signal Agent " + getAID().getName() + " is ready and initialized to RED.");

        // Add a TickerBehaviour to simulate the light changing every 5 seconds
        addBehaviour(new TickerBehaviour(this, 5000) {
            @Override
            protected void onTick() {
                // Alternate between RED and GREEN
                if (currentState.equals("RED")) {
                    currentState = "GREEN";
                } else {
                    currentState = "RED";
                }
                cycleCount++;
                System.out.println("🚦 " + myAgent.getLocalName() + ": Light is now " + currentState + ". (Cycle: " + cycleCount + ")");
            }
        });
    }
}
