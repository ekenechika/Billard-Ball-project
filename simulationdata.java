package simulationdata.csv;

import java.io.FileWriter;
import java.io.IOException;

public class simulationdata {
    public static void main(String[] args) {
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
			// Prompt the user for the initial height
			System.out.print("Please enter simulation parameters...\nInitial Height (in meters): ");
			double initialHeight = scanner.nextDouble();

			// Define constants
			final double gravity = 9.81;
			double time = 0;  // Initialize time to 0
			double velocity = 0;  // Initialize velocity to 0

			// Open a CSV file for writing
			try (FileWriter csvFile = new FileWriter("simulationdata.csv")) {
			    // Write the CSV header
			    csvFile.write("time,height,velocity\n");

			    // Simulate the ball's descent and write data to the CSV file at each second interval
			    while (initialHeight > 0) {
			        // Calculate the height and velocity at the current time
			        double height = initialHeight - 0.5 * gravity * time * time;
			        velocity = gravity * time;

			        // Write the data to the CSV file
			        csvFile.write(time + "," + height + "," + velocity + "\n");

			        // Print progress to the console
			        System.out.println("t = " + time);

			        // Increment time by 1 second
			        time += 1;

			        // Break the loop when the ball reaches the ground (height becomes negative)
			        if (height < 0) {
			            height = 0;
			            break;
			        }
			    }
			    System.out.println("Writing to simulationdata.csv...\nDone");
			} catch (IOException e) {
			    e.printStackTrace();
			}
		}
    }
}
