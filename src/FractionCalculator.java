import java.util.Scanner;
public class FractionCalculator {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        intro();

        while(true) {
            String opChoice = getOperation(input);

            Fraction fraction1 = getFraction(input);
            Fraction fraction2 = getFraction(input);

            if (opChoice.equals("=")){
                System.out.println("Fraction1 and Fraction2 equal?:" + fraction1.equals(fraction2));

            }

        }


    }//end main

    public static Fraction getFraction(Scanner input){
        System.out.println("Enter a fraction: ");
        String entry = input.next();

        while (!validFraction(entry)){
            System.out.println("Please enter a VALID fraction: ");
            entry = input.next();
        }

        //once past while loop create the new fraction object

        int newNumer = 0;
        int newDenom = 0;
        if (entry.contains("/")){
            int splitIndex = entry.indexOf("/");

            String numerStr = entry.substring(0, splitIndex);
            String denomStr = entry.substring(splitIndex + 1);

            newNumer = Integer.parseInt(numerStr);
            newDenom = Integer.parseInt(denomStr);


        }
        else if (!entry.contains("/")){
            newNumer = Integer.parseInt(entry);
            newDenom = 1;
        }

        Fraction newFrac = new Fraction(newNumer, newDenom);
        return newFrac;

    }


    public static boolean validFraction(String entry){
        boolean isValid = false;

        Scanner input = new Scanner(System.in);
        //System.out.println("Enter (A/B) or (A), where A and B are integers and B is NOT ZERO: ");
        //entry = input.next();
        while (isValid == false) {
            if (entry.startsWith("-")) {
                entry = entry.substring(1);
            }


            if (entry.contains("/")) {
                int splitIndex = entry.indexOf("/");

                String a = entry.substring(0, splitIndex);
                String b = entry.substring(splitIndex + 1);

                if (isNumber(a) && isNumber(b) && !b.contains("0")) {
                    isValid = true;
                } else {
                    System.out.println("Error! Enter (A/B) or (A), where A and B are ONLY integers and B is NOT ZERO: ");
                    entry = input.next();
                }

            }//end if contains /

            else if (!entry.contains("/")) {
                if (entry.matches("[0-9]+")) {
                    isValid = true;
                } else {
                    System.out.println("Error! Enter (A/B) or (A), where A and B are ONLY integers and B is NOT ZERO: ");
                    entry = input.next();
                }

            }//end else-if doesnt contain /

        }//end while isvalid is false

        System.out.println(entry + " is: " + isValid);
        return isValid;

    }//end validFraction tester


    public static boolean isNumber(String num){
        boolean isNum;

        if (num.matches("[0-9]+")){
            isNum = true;
        }
        else{ isNum = false;}

        return isNum;
    }//end isNumber helper method

    public static String getOperation(Scanner input){

        System.out.println("Please enter an operation (+, -, *, /, = or Q to quit");
        String opChoice = input.next();

        int exitSentinel = 0;

        while(exitSentinel == 0) {
            if (opChoice.toLowerCase().equals("Q".toLowerCase())) {
                System.exit(0);
            }
            else if (opChoice.equals("+") || opChoice.equals("-") || opChoice.equals("*") || opChoice.equals("/") ||
                    opChoice.equals("="))
            {
                exitSentinel++;
            }
            else {
                System.out.println("Invalid entry - Please enter an operation (+, -, *, /, = or Q to quit)");
                opChoice = input.next();
            }
        }//end while after correct entry has been given and sentinel has been updated

        return opChoice;

    }//end getOperation method


    public static void intro(){
        System.out.println("\t\tThis Program Will Be Your One-Stop Source for Fraction Calculations!");
        System.out.println("\tIt will add, subtract, multiply & divide fractions until you type Q to quit");
        System.out.println("\tPlease enter your fractions in the form of a/b, where a and b are integers\n");

    }//end intro prints



}//end driver class
