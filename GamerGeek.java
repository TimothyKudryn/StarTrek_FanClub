package lab1;

import java.io.FileNotFoundException;

public class GamerGeek extends GenericNerd {

    private String consolePref;

    /*
    GamerGeek extends the GenericNerd class and ihnerits the name and nerdFactor variables.
    The new consolePref variable holds the values "PC","PS4", or "Xbox"
    Their nerd factor is based off of their Console preferance. The following functions are
    overwritten to better suit the current class
     */
    public GamerGeek(String name, int nerdFactor, String uiConsolePref) throws FileNotFoundException {
        super(name, nerdFactor);
        consolePref = uiConsolePref;
        // makes sure that the current nerd has a name.
        if(name == null)
        {
            System.out.println("Error: GenericNerd constructor - name is null!");
            System.exit(1);
        }

        /*
        Following block of if statements checks if the given nerd levels are valid.
        If the nerd factors are not valid, the code assigns nerd levels based on console preference.
        PC gamer: nerd level [5-10]
        Xbox gamer: nerd level [1-6]
        PS4 gamer: nerd level [1-10]
         */

        if(consolePref == "PC" && (nerdFactor < 5 || nerdFactor > 10))
        {
            System.out.println("Careful, " + name + " is a PC gamer. Nerd factor must be at least 5.\n" +
                    "Nerdiness set to 7.");
            this.setNerdFactor(7);
        }
        else if(consolePref == "Xbox" && nerdFactor > 6)
        {
            System.out.println("Careful, " + name + " is a Xbox gamer. Nerd factor must be in the range [1-6].\n" +
                    "Nerdiness set to 3.");
            this.setNerdFactor(3);
        }

    }
    // getNerdFactor() simply returns teh NerdFactor of the current object.
    public int getNerdFactor()
    {
        return super.getNerdFactor();
    }

/*
toString() is an overwritten function that is used to output the information about a certain object
 */
    public String toString()
    {
        String Gamer = new String(getName() + " is a level " +
                getNerdFactor() + " gamer geek, ");

        String ConsolePreference = null;
        if(consolePref == "PC")
        {
            ConsolePreference = new String("who prefers the PC to and Xbox one or Playstation 4.");
        }
        else if(consolePref == "Xbox")
        {
            ConsolePreference = new String ("who prefers the Xbox one to a PC or a Playstation 4.");
        }
        else
        {
          ConsolePreference = new String("who prefers the PS4 to a PC or and Xbox one.");
        }
        return new String(Gamer + ConsolePreference);
    }

    /*
Custom String to File creates a properly syntaxed string to be exported into a file using the
PrintWriter class
 */
    public String customStringToFile()
    {

        return new String("Nerd Type: GamerGeek\n" +
                "Name: " + getName() +
                "\nNerd Level: " + getNerdFactor() +
                "\nPreferred Console: " + consolePref +
                "\n----------------------------------");
    }


    /*
    harass() is a inhereited function that was overwritten to better suit the current object
     */
    public void harass()
    {
        if(consolePref == "PC")
        {
            System.out.println("You Tell "+ consolePref + " gamer " + getName() +
                    " that PC's have way too many bugs!" +
                    " Then give him a " + getHarassment() + '!');
        }
        else if (consolePref == "Xbox")
        {
            System.out.println("You tell " + consolePref + " gamer " +  getName() +
                    " that you can’t even use the best Skyrim mods on the PS4!" +
                    " Then give him a " + getHarassment() + '!');
        }
        else
        {
            System.out.println("You Tell " + consolePref + " gamer " + getName() +
                    " that it must be fun seeing ads on your console!" +
                    " Then give him a " + getHarassment() + '!');
        }
    }

}
