package com.PRACTISE.main;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

public class Main {

    public static void main(String[] args) {
        Runtime rt = Runtime.instance();
        Profile profile = new ProfileImpl();
        profile.setParameter(Profile.GUI, "true");
        profile.setParameter(Profile.CONTAINER_NAME, "Main-Container");
        profile.setParameter(Profile.MAIN_HOST, "localhost");

        ContainerController mainContainer = rt.createMainContainer(profile);

        try {
            System.out.println("🚀 Deploying agents...");

            // Create and start the TrafficSignalAgent
            AgentController signalAgent = mainContainer.createNewAgent(
                    "Signal-Intersection-1",
                    "com.PRACTISE.agents.TrafficSignalAgent",
                    null
            );
            signalAgent.start();

            // Create and start 3 VehicleAgents
            for (int i = 1; i <= 3; i++) {
                AgentController vehicleAgent = mainContainer.createNewAgent(
                        "Car-" + i,
                        "com.PRACTISE.agents.VehicleAgent",
                        null
                );

                vehicleAgent.start();
            }

            System.out.println("✅ All agents deployed successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
