package org.example;
import java.util.Objects;
import java.util.Scanner;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Main {
    public static void main(String[] args) {
        boolean canContinue = true;
        while (canContinue) {
            //Set up
            Scanner userInputScanner = new Scanner(System.in);
            String userInputEquation;

            // Input equation:
            System.out.println("Enter equation");
            userInputEquation = userInputScanner.nextLine();

            userInputEquation = userInputEquation.trim().toLowerCase().replaceAll("\\s+", "");
            if (Objects.equals(userInputEquation, "shutdown")) {
                canContinue = false;
            }

            // Calculate
            CalculateEquationClick(userInputEquation);
        }
    }

    private static void CalculateEquationClick(String userInputEquation) {
        CalculateMemeResponse(userInputEquation);
    }

    private static void DisplayEquationResult(String equation, String result) {
        System.out.println(equation + " = "+ result);
    }

    private static void CalculateMemeResponse(String equation) {
        String equationTrimmedLowered =
                equation.replaceAll("[^a-zA-Z0-9/*+\\-(),.]", "").trim().toLowerCase();

        String result = switch (equationTrimmedLowered) {
            case "0/0" -> "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
//                TerminateSession();
            case "1" -> "You're my number 1 ♥";
            case "1+1"-> "11";
            case "2+2" -> "Oh we are taking it safe today, aren't we?";
            case "4+4" -> "Double checking everything today?";
            case "6+7" -> "If 7+7 is 14, then one lower would be 13";
            case "9+10" -> "21";
            case "lxix" -> "Optime, amice ;)";
            case "69+69" -> "Double Nice!";
            case "69+420" -> "Nice, blaze it!";
            case "420+69" -> "42069";
            case "7+(-1/2+5)*20" -> "Seven-and-a-half-fives. Or 97 if you don't have a potato in your mouth";
            case "77+33" -> "100";
            case "gay" -> "Giiiiirl, shut uppppp";
            case "fuckyou" -> "Look at the maidenless, who got beef with a calculator. Touch grass";
            case "nice" -> "69";
            case "shrek" -> "Shrek is love, Shrek is life";
            case "whyis6afraidof7" -> "Because 7 8 9";
            case "whoneedtheynumbussyate" -> "Omg me";
            default -> CalculateRealResponse(equationTrimmedLowered);
        };
        DisplayEquationResult(equation, result);
    }

    private static String CalculateRealResponse(String equation)
    {
        try
        {
            double computedEquation = new ExpressionBuilder(equation).build().evaluate();
            return switch ((int) computedEquation) {
                case 13 -> "Ouch, unlucky";
                case 42 -> "The answer to life, the universe, and everything";
                case 69 -> "Nice";
                case 333 -> "Only half as scary as 666";
                case 360 -> "360 NO SCOPE!";
                case 420 -> "Grow up";
                case 666 -> "Hello demons, it's me, ya boy";
                case 911 -> "911, what's your emergency?";
                case 1111 -> "Eleventeenth eleventy one";
                case 1337 -> "Leet";
                case 80085 -> "Focus on your homework!!!";
                case 8008135 -> "Oh you need to focus on your homework";
                default -> String.valueOf(computedEquation);
            };
        }
        catch(Exception e)
        {
            return "ey yo hold up that didn't make any sense. Try again.";
        }
    }
}