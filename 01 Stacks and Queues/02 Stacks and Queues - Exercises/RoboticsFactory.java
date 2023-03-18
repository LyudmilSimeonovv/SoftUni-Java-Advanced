package com.company.Stekove_Opashki._exersises;

import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RoboticsFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Parse robots and their processing times
        Map<String, Integer> robots = new HashMap<>();
        String[] robotTokens = scanner.nextLine().split(";");
        for (String robotToken : robotTokens) {
            String[] parts = robotToken.split("-");
            robots.put(parts[0], Integer.parseInt(parts[1]));
        }

        // Parse starting time
        LocalTime startTime = LocalTime.parse(scanner.nextLine());

        // Create queues for the robots and products
        Deque<String> robotQueue = new ArrayDeque<>(robots.keySet());
        Deque<String> productQueue = new ArrayDeque<>();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("End")) {
                break;
            }
            productQueue.add(line);
        }

        // Simulate the assembly line
        LocalTime currentTime = startTime;
        Map<String, LocalTime> robotStatus = new HashMap<>();
        while (!productQueue.isEmpty()) {
            // Check if any robot is free
            while (!robotQueue.isEmpty() && !productQueue.isEmpty()) {
                String robotName = robotQueue.poll();
                String product = productQueue.poll();
                int processingTime = robots.get(robotName);
                robotStatus.put(robotName, currentTime.plusSeconds(processingTime));
                System.out.printf("%s - %s [%s]%n", robotName, product, currentTime.plusSeconds(1));
            }

            // Check if any robot has finished processing
            for (String robotName : robots.keySet()) {
                if (currentTime.equals(robotStatus.get(robotName))) {
                    robotQueue.add(robotName);
                }
            }

            // Move to the next second
            currentTime = currentTime.plusSeconds(1);
        }

        scanner.close();
    }
}
