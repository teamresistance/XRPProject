package frc.robot.io;

import edu.wpi.first.wpilibj.PS4Controller;

/**
 * Currently only set up to use a PS4 Controller set to be on port 0 (hardcoded)
 */
public class io {
    public static final PS4Controller controllerPS4 = new PS4Controller(0);
    public static double leftThumbstickX = 0;
    public static double leftThumbstickY = 0;
    public static double rightThumbstickX = 0;
    public static double rightThumbstickY = 0;
    public static boolean buttonCross = false;
    public static boolean buttonCircle = false;
    public static boolean buttonSquare = false;
    public static boolean buttonTriangle = false;
    public static boolean buttonL1 = false;
    public static boolean buttonR1 = false;
    public static boolean buttonCrossPressed = false;
    public static boolean buttonCirclePressed = false;
    public static boolean buttonSquarePressed = false;
    public static boolean buttonTrianglePressed = false;
    public static boolean buttonL1Pressed = false;
    public static boolean buttonR1Pressed = false;
    public static double triggerL2 = -1; // Not 0 as the default is -1 instead of the standard 0 on joysticks
    public static double triggerR2 = -1; // See triggerL2
    public static int dpad = -1; // No input has a value of -1, otherwise up is 0, increases clockwise (so straight right is 90)

    public static void updateController() {
        leftThumbstickX = controllerPS4.getLeftX();
        leftThumbstickY = controllerPS4.getLeftY();
        rightThumbstickX = controllerPS4.getRightX();
        rightThumbstickY = controllerPS4.getRightY();

        buttonCircle = controllerPS4.getCircleButton();
        buttonCross = controllerPS4.getCrossButton();
        buttonSquare = controllerPS4.getSquareButton();
        buttonTriangle = controllerPS4.getTriangleButton();

        buttonL1 = controllerPS4.getL1Button();
        buttonR1 = controllerPS4.getR1Button();

        buttonCirclePressed = controllerPS4.getCircleButtonPressed();
        buttonCrossPressed = controllerPS4.getCircleButtonPressed();
        buttonSquarePressed = controllerPS4.getCircleButtonPressed();
        buttonTrianglePressed = controllerPS4.getCircleButtonPressed();

        buttonL1Pressed = controllerPS4.getCircleButtonPressed();
        buttonR1Pressed = controllerPS4.getCircleButtonPressed();


        triggerL2 = controllerPS4.getL2Axis();
        triggerR2 = controllerPS4.getR2Axis();

        dpad = controllerPS4.getPOV();

        // Test print, preferable to use shuffleboard if you want to do any better testing
        // System.out.println(leftThumbstickX + " | " + leftThumbstickY  + " | " + rightThumbstickX + " | " + rightThumbstickY + " | " + buttonCross + " | " + buttonCircle + " | " + buttonTriangle + " | " + buttonSquare  + "\n" + buttonL1 + " | " + buttonR1 + " | " + triggerL2 + " | " +  triggerR2 + " | " + dpad);
        

    }
}
