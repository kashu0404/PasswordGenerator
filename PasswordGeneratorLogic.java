import java.util.Random;

public class PasswordGeneratorLogic {

    //variables

    public static final String Lowercase = "abcdefghijklmnopqrstuvwxyz";

    public static final String Uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String numbers = "0123456789";

    public static final String symbols = "!@#$%^&*()_-+=[]{}~?<>.,:;'/|";

    //we need to generate a Random password with the toggles the user chooses

    private final Random rand;



    PasswordGeneratorLogic(){
        rand = new Random();
    }

    public String generatePassword(int length, boolean includeNumbers, boolean includeSymbols, boolean includeUppercase, boolean includeLowercase) {


        StringBuilder passwordResult = new StringBuilder();

        String selectedChars = "";

        if (includeNumbers) {
            selectedChars+=numbers;
        }

        if (includeSymbols) {
            selectedChars+=symbols;
        }

        if (includeUppercase) {
            selectedChars+=Uppercase;
        }

        if (includeLowercase) {
            selectedChars+=Lowercase;
        }


        for (int x=0; x<length;x++) { //length from user
            int randIndex = rand.nextInt(selectedChars.length()); //finds index between length 0 and length-1

            char randChar = selectedChars.charAt(randIndex);

            passwordResult.append(randChar);

        }

        

        return passwordResult.toString();
    }
}
