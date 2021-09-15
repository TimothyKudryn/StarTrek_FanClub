package lab1;

import java.io.FileNotFoundException;

public class CosPlayTrekkie extends Trekkie {

    /**
     * Creates a new instance of Trekkie - a nerd obsessed with Star Trek.
     * Precondition: name must not be null, nerdFactor must be between 1 & 10.
     * If the Trekkie speaks Klingon, nerdFactor must be 9 or 10 (only super
     * Trekkie nerds bother to learn Klingon.)
     * Postcondition: a new Trekkie object is created with the given name
     * and nerd factor with an indication of whether the Trekkie thinks Captain
     * Kirk is better than Captain Picard, and whether the Trekkie speaks Klingon.
     *
     * @param name           The name of this nerd.
     * @param nerdFactor     On a scale of 1 to 10, how nerdy this nerd is.
     * @param klingonSpeaker True if the new Trekkie can speak Klingon.
     * @param kirkBetter     True if The Trekkie prefers Captain Kirk to Captain Picard.
     */

    private String outfit = null;

    public CosPlayTrekkie(String name, int nerdFactor, boolean klingonSpeaker, boolean kirkBetter, String uiOutfit) throws FileNotFoundException {
        super(name, nerdFactor, klingonSpeaker, kirkBetter);

        setOutfit(uiOutfit);
    }

    /*
    Inherited function that is overwritten to better output the contents of the current cosplay object.
    List the geeks name, geekiness orientation, captain preference, klingon speaking abilities and
    cosplay outfit.
     */
    public String toString()
    {
        String trekkie = getName() + " is a level " + getNerdFactor() + " Star Trek nerd ";
        String klingon;
        if(klingonSpeaker())
            klingon = new String("who speaks Klingon ");
        else klingon = new String("who does not speak Klingon ");
        String captain;
        if(ThinksKirkIsBetter())
            captain = new String("and thinks Captain Kirk is better than Captain Picard.");
        else captain = new String("and thinks Captain Picard is better than Captain Kirk.");
        String currentOutfit = new String(" To top it off, " + getName() +
                " is dressed as " + outfit + ". "
        );
        return new String(trekkie + klingon + captain + currentOutfit);
    }
    /*
Custom String to File creates a properly syntaxed string to be exported into a file using the
PrintWriter class
 */
    public String customStringToFile()
    {
        String capPref = "Picard";
        if(ThinksKirkIsBetter()) capPref = "Kirk";
        String speaksKlingon = "No";
        if(klingonSpeaker()) speaksKlingon = "Yes";



        return new String("Nerd Type: CosplayTrekkie\n" +
                "Name: " + getName() +
                "\nNerd Level: " + getNerdFactor() +
                "\nSpeaks Klingon: " + speaksKlingon +
                "\nCaptain: " + capPref +
                "\nCostume: " + outfit +
                "\n----------------------------------");
    }
    //sets outfit
    public void setOutfit(String uiOutfit) { outfit = uiOutfit; }
    //return current object outfit
    public String getOutfit() {return outfit;}
    /*
    This harass function has a new feature of chaining insults.
    If the trekkie speaks klingon, and is dressed in a costume, than the insults multiplied.
    Not only will they be made fun of for knowing klingon, but they will also receive slack for their outfit.
     */
    public void harass()
    {
        //following code is the list of harassments based on outfits
        String KlingonOutfitHarassment = "then tell him that his Klingon eye brows make him look " +
                "like a defective owl!";
        String FedOfficerHarassment = "then tell him, that his federation officer costume makes him " +
                "look like a 1980's aerobics trainer ";
        String VulcanHarassment = "then tell him that his/hers Vulcan haircut makes him look like an " +
                "elegant ape! ";


        // following code is there for convenience. (saves a bit of typing)
        String currentInsult = null; //will be used for outputing the current insult.

        if(outfit == "Klingon") {currentInsult = KlingonOutfitHarassment;}
        else if (outfit == "Federation Officer") {currentInsult = FedOfficerHarassment;}
        else if (outfit == "Vulcan"){currentInsult = VulcanHarassment;}
        else
        {
            System.out.println("Non trekkie outfit was being worn");
        }

        if(klingonSpeaker())
        {
            System.out.println("You should ask cosplay trekkie " + getName() +
                    " if there is a word in Klingon for loneliness, " + currentInsult +
                    "(finally give him/her a " + getHarassment() + ")!");
            return;
        }
        if(ThinksKirkIsBetter())
        {
            System.out.println("You tell cosplay trekkie " + getName() +
                    " that Captian Kirk is better than Captain Picard " + currentInsult +
                    "(and then give him/her a " + getHarassment() + ")!");
            return;
        }
        System.out.println("You tell cosPlay trekkie " + getName() +
                " that Captian Picard is better than Captain Kirk " + currentInsult +
                "(and then give him/her a " + getHarassment() + ")!");
    }

}
