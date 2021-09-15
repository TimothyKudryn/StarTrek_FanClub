
package lab1;

import java.io.FileNotFoundException;

/**
 Instances of the Trekkie class track represent nerds who are huge Star Trek
 fans (to the detriment of their social lives).  In addition to tracking the
 nerd's name and nerd factor (see the documentation for the GenericNerd class),
 a Trekkie prefers either Captain Kirk from the original series (TOS) or
 Captain Picard from Star Trek: The Next Generation (TNG).  No Trekkie is
 neutral on this issue.  It is always one captain or the other with these
 people!  The biggest Star Trek nerds may actually be fluent in Klingon.
 Rather than spending their time learning a useful language like Spanish or
 Japanese, they have spent years of their lives learning a fake language (sad
 but true fact, Klingon speakers now outnumber native Navajo speakers in our
 modern world)!  Due to the huge nerd level required to master Klingon,
 Trekkies who speak Klingon fluently must have a nerd factor of 9 or higher.
 When harassing a Trekkie, Klingon fluency and imaginary captain preference
 are considered along with the Trekkie's base nerd factor.
 @author Michael Peterson
 */
public class Trekkie extends GenericNerd {

    private boolean speaksKlingon;
    private boolean kirkBetterThanPicard;

    /** Creates a new instance of Trekkie - a nerd obsessed with Star Trek.
     Precondition: name must not be null, nerdFactor must be between 1 & 10.
     If the Trekkie speaks Klingon, nerdFactor must be 9 or 10 (only super
     Trekkie nerds bother to learn Klingon.)
     Postcondition: a new Trekkie object is created with the given name
     and nerd factor with an indication of whether the Trekkie thinks Captain
     Kirk is better than Captain Picard, and whether the Trekkie speaks Klingon.
     @param name The name of this nerd.
     @param nerdFactor On a scale of 1 to 10, how nerdy this nerd is.
     @param klingonSpeaker True if the new Trekkie can speak Klingon.
     @param kirkBetter True if The Trekkie prefers Captain Kirk to Captain Picard.
     */
    public Trekkie(String name, int nerdFactor, boolean klingonSpeaker, boolean kirkBetter) throws FileNotFoundException {
        /*
        the "super" constructor is used to access and set the name and nerdfactor, which are
        inherited form the super class.
         */

        super(name, nerdFactor);
        if(name == null)
        {
            System.out.println("Error: GenericNerd constructor - name is null!");
            System.exit(1);
        }

        // the setNerdFactor method handles parameter range checking
        setNerdFactor(nerdFactor);

        /*
        the super.name = name line is not needed. The super(name, nerdFactor) function takes care of
        setting the name field of the current object, hence I commented out the line below
         */
        //super.name = name;

        if(klingonSpeaker)
        {
            speaksKlingon = true;
            // make sure Klingon speakers have a high enough nerd factor!
            if(nerdFactor < 9)
            {
                System.out.println("Warning: " + name +
                        " speaks Klingon! (setting nerdFactor to 9).");
                setNerdFactor(9);
            }
        }
        kirkBetterThanPicard = kirkBetter;
    }

    /**
     Returns this nerd's nerd factor.
     @return This nerd's nerd factor.
     */
    public int getNerdFactor()
    {
        return super.getNerdFactor(); //changed to super so inheritance could work
    }

    /**
     Sets this nerd's factor to the provided value.
     Precondition: provided nerdFactor must be between 1 and 10.
     Postcondition: This nerd's nerdFactor is set to the provided value.
     @param nerdFactor On a scale of 1 to 10, how nerdy this nerd is.
     */

    public void setNerdFactor(int nerdFactor)
    {
        if((nerdFactor < 1) || (nerdFactor > 10))
        {
            System.out.println("Warning: Nerd factor must be between 1 & 10 (using default 1)!");
            this.setNerdFactor(1);
        }
        else super.setNerdFactor(nerdFactor); // set super to extend inheritence
    }

    final void doNothing(){
        System.out.println("nothing");
    }

    /**
     Indicates whether this Trekkie speaks Klingon.
     @return True if this Trekkie speaks Klingon, false otherwise.
     */
    public boolean klingonSpeaker()
    {
        return speaksKlingon;
    }

    /**
     Set this Trekkie's status as a Klingon speaker.
     Postcondition: This Trekkie's Klingon speaking status is updated to the
     provided value.
     @param klingonSpeaker The new status of this Trekkie's Klingon fluency.
     */
    public void setKlingonSpeaker(boolean klingonSpeaker)
    {
        speaksKlingon = klingonSpeaker;
    }



    /**
     Set this Trekkie's preference of Captain Kirk or Captain Picard
     Postcondition: this Trekkie's captain preference is updated
     @param kirkBetter True if this Trekkie prefers Kirk to Picard, false
     otherwise.
     */
    public void setCaptainPreference(boolean kirkBetter)
    {
        kirkBetterThanPicard = kirkBetter;
    }

    /**
     Indicates if this Trekkie prefers Captain Kirk over Captian Picard
     @return true if this Trekkie prefers Kirk to Picard, false otherwise.
     */
    public boolean ThinksKirkIsBetter()
    {
        return kirkBetterThanPicard;
    }

    /**
     Constructs and returns a String describing the various nerd qualities of
     this trekkie.
     @return a String indicating the nerd statistics of this Trekkie.
     */
    public String toString()
    {
        String trekkie = new String(getName() + " is a level " +
                getNerdFactor() + " Star Trek nerd ");
        String klingon;
        if(speaksKlingon)
            klingon = new String("who speaks Klingon ");
        else klingon = new String("who does not speak Klingon ");
        String captain;
        if(kirkBetterThanPicard)
            captain = new String("and thinks Captain Kirk is better than Captain Picard.");
        else captain = new String("and thinks Captain Picard is better than Captain Kirk.");

        return new String(trekkie + klingon + captain);
    }

/*
Custom String to File creates a properly syntaxed string to be exported into a file using the
PrintWriter class
 */
    public String customStringToFile()
    {
        String capPref = "Picard";
        if(this.kirkBetterThanPicard) capPref = "Kirk";
        String speaksKlingon = "No";
        if(klingonSpeaker()) speaksKlingon = "Yes";



        return new String("Nerd Type: Trekkie\n" +
                "Name: " + getName() +
                "\nNerd Level: " + getNerdFactor() +
                "\nSpeaks Klingon: " + speaksKlingon +
                "\nCaptain: " + capPref +
                "\n----------------------------------");
    }

    /**
     /**
     Harass this Trekkie.  Harassment is based upon the Trekkie's nerd factor,
     Star Trek captain preference, and Klingon fluency.
     Postcondition: A message indicating how to harass this nerd is printed.
     */
    public void harass()
    {
        if(speaksKlingon)
        {
            System.out.println("You ask trekkie " + getName() +
                    " if there is a word in Klingon for loneliness " +
                    "(and then give him/her a " + getHarassment() + ")!");
            return;
        }
        if(kirkBetterThanPicard)
        {
            System.out.println("You tell trekkie " + getName() +
                    " that Captian Kirk is better than Captain Picard " +
                    "(and then give him/her a " + getHarassment() + ")!");
            return;
        }
        System.out.println("You tell trekkie " + getName() +
                " that Captian Picard is better than Captain Kirk " +
                "(and then give him/her a " + getHarassment() + ")!");
    }
}