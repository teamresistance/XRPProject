package frc.robot.Subsystems;

public class autonomous {
    private static final double xLength = 3.0; //Length of the area horizontally in ft
    private static final double yLength = 3.0; //Length of the area vertically in ft
    /**
     * Current position on the X axis in ft
     */
    public static final double currentX = 0.0;
    /**
     * Current position on the Y axis in ft
     */
    public static final double currentY = 0.0;

    private static int targetAngle = 0;

    //These are constants that never change, because the field of play never changes! 

    //By definition of how I'm doing this autonomous, the robot is always in the bottom left of the auto zone.
    //The robot's starting angle is also facing the Y axis
    //Why? Because I said so. On our actual autonomous, we'd have a couple starting positions (usually 3)
    //and define our position based on those, and usually those starting positions are mandatory, so really
    //this isn't all that different.


    public static void updateAutonomous() {

    }


    /**
     * Does the work for you in order to go to a set position.
     * Neither value can be negative<p>
     * 
     * The robot only travels in straight lines in order to go to the set position
     * @param xPosition The X position for the robot to go to
     * @param yPosition The Y position for the robot to go to
     */
    public static void targetPosition(double xPosition, double yPosition) {

    }

    public static int[] currentPosition() {
        return new int[]{-1,-1};
    }
}
