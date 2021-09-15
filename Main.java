
package lab1;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;


public class Main {
    //used for lab 2


    /** Creates a new instance of Main */
    public Main() throws FileNotFoundException {
    }


    /**
     Print a list of nerds.
     @param //A list containing GenericNerd objects.
     */
    public static void showNerdList(ArrayList<GenericNerd> list)
    {
        System.out.println();
        System.out.println("************************************************");
        System.out.println("*             List of Known Nerds              *");
        System.out.println("************************************************");
        System.out.println();

        if(list.size() == 0)
        {
            System.out.println("\tThere are no nerds.");
        }

        for(int i = 0; i < list.size(); i++)
        {
            GenericNerd nerd = list.get(i);
            // note implicit call to nerd.toString() below.
            System.out.println("\t" + nerd);
        }

        System.out.println();
        System.out.println("************************************************");
        System.out.println("*               End of Nerd List               *");
        System.out.println("************************************************");
        System.out.println();
    }

    /**
     Harass all of the nerds in the list.
     @param //A list containing GenericNerd objects.
     */
    public static void harassNerds(ArrayList<GenericNerd> list)
    {
        System.out.println();
        System.out.println("************************************************");
        System.out.println("*               Harassing Nerds                *");
        System.out.println("************************************************");
        System.out.println();

        if(list.size() == 0)
        {
            System.out.println("\tThere are no nerds to harass.");
        }

        for(int i = 0; i < list.size(); i++)
        {
            GenericNerd nerd = list.get(i);
            nerd.harass();
        }

        System.out.println();
        System.out.println("************************************************");
        System.out.println("*   Finished Harassing Nerds (that was fun!)   *");
        System.out.println("************************************************");
        System.out.println();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {

        System.out.println("<<< CS 420 Lab 1 Test Code. >>>");

        // List to keep a few nerds in
        ArrayList<GenericNerd> nerdList = new ArrayList<GenericNerd>();


        // create a few nerds and add them to the list
        GenericNerd nerd = new GenericNerd("Bugger McNosePicker", 9);
        nerdList.add(nerd);

        nerd = new GenericNerd("Lame-o Lamerson", 12);
        nerdList.add(nerd);

        // POLYMORPHISM IN ACTION!!!
        nerd = new Trekkie("Captain Spazz", 3,false,true);
        nerdList.add(nerd);
        nerd = new Trekkie("Lt. Commander Loser", 10,true,true);
        nerdList.add(nerd);
        // generate another warning (Klingon speaker of a low level)
        nerd = new Trekkie("Deanna Troi fanboy", 6,true,false);
        nerdList.add(nerd);
        // round out the list with a few more various nerds
        nerd = new GenericNerd("Baron Ron von Dorkenstein", 10);
        nerdList.add(nerd);
        nerd = new GenericNerd("Donnie Doofus", 8);
        nerdList.add(nerd);

        // Testing of the GamerGeek class.
        //PC gamer with valid entries
        nerd = new GamerGeek("Tyler Blevins", 5, "PC");
        nerdList.add(nerd);
        // PC gamer with invalid nerdFactor: My algorithm should catch this error and reset the nerdFactor
        // a valid level
        nerd = new GamerGeek("Jerry McSenderson", 1, "PC");
        nerdList.add(nerd);
        //xbox gamer with valid entries
        nerd = new GamerGeek("Stewie 2k", 2, "Xbox");
        nerdList.add(nerd);
        //ps4 gamers with valid entries
        nerd = new GamerGeek("Boxer McBriefson", 9, "PS4");
        nerdList.add(nerd);
        nerd = new GamerGeek("Doore Knob", 10, "PS4");
        nerdList.add(nerd);
        GamerGeek gamer = new GamerGeek("Joe Hiden", 10, "PC");
        nerdList.add(gamer);


        //Testing the CosPlayTrekkie class.
        nerd = new CosPlayTrekkie("Capt Dumbski", 14, true,
                true, "Federation Officer");
        nerdList.add(nerd);
        Trekkie t = new CosPlayTrekkie("PJ nightwalker", 8, true,
                false, "Vulcan");
        nerdList.add(t);
        nerd = new CosPlayTrekkie("Seth Mcfarlen", 2, false,
                false, "Klingon");
        nerdList.add(nerd);
        nerd = new CosPlayTrekkie("Weird Al Junior", 10, true,
                true, "Klingon");
        nerdList.add(nerd);
        // print out a list of the nerds:
        showNerdList(nerdList);

        // harass all of the nerds
        harassNerds(nerdList);

        /*
        Following code is testing of lab 2
         */
//        System.out.println("\n\n********************** LAB2 start ********************\n\n");
////**************** LAB 2 part 1 ******************
//
//
//        try {
//            FileWriter fwriter = new FileWriter("nerdRoster.txt", true);
//            PrintWriter outputFile = new PrintWriter(fwriter);
//
//            for (int i = 0; i < nerdList.size(); i++) {
//                GenericNerd newNerd = nerdList.get(i);
//                newNerd.writeNerd(outputFile);
//            }
//            outputFile.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Scanner keyboard = new Scanner(System.in);
////
//        System.out.println("Nerd Roster created, press return to continue...");
//        String s = keyboard.nextLine();
//

//
//
//        //************ Lab2 part2 ****************
//
//        String line;
//        ArrayList<GenericNerd> fileInputNerdList = new ArrayList();
//
//        File currentFile = new File("nerdRoster.txt");
//        Scanner inputFile = new Scanner(currentFile);
//        while(inputFile.hasNext())
//        {
//            //needed variables.
//            // reading file in one at a time.
//            line = inputFile.nextLine();
//
//            //skipping useless lines. In current text file they are identified with either being or consisting of dashes.
//            if (line.charAt(0) == '-') continue;
//            else
//            {
//                //predefining needed variables
//                String nerdtype = null, name = null, consolePref = null, costume = null;
//                int nerdiness = 0;
//                boolean klingon = false, KirkBetterPicard = false;
//                while (line.charAt(0) != '-')
//                {
//                    /*
//                    Following switch case determines and saves the details about each nerd into variables
//                     */
//                    String[] subStringArray = line.split(":");
//                    switch (subStringArray[0]) {
//                        case "Nerd Type":
//                            nerdtype = subStringArray[1];
//                        case "Name":
//                            name = subStringArray[1];
//                            break;
//                        case "Nerd Level":
//                            String temp = subStringArray[1];
//                            temp = temp.trim();
//                            nerdiness = Integer.parseInt(temp);
//                            break;
//                        case "Speaks Klingon":
//                            if(subStringArray[1].equals(" Yes")) klingon = true;
//                            else klingon = false;
//                            break;
//                        case "Captain":
//                            if(subStringArray[1].equals(" Kirk")) KirkBetterPicard = true;
//                            else KirkBetterPicard = false;
//                            break;
//                        case "Preferred Console":
//                            consolePref = subStringArray[1];
//                            break;
//                        case "Costume":
//                            costume = subStringArray[1];
//                            break;
//                        default:
//                            //System.out.println(subStringArray[0]);
//                            //System.out.println("unknown error");
//                            name = null;
//                            break;
//                    }
//                    line = inputFile.nextLine();
//                }
//                assert nerdtype != null;
//                switch(nerdtype)
//                {
//                    /*
//                    Following switch cases determines what type of ner will be taken in
//                     */
//                    case " GenericNerd":
//                        nerd = new GenericNerd(name, nerdiness);
//                        break;
//                    case " Trekkie":
//                        nerd = new Trekkie(name, nerdiness, klingon, KirkBetterPicard);
//                        break;
//                    case " Cosplay":
//                        nerd = new CosPlayTrekkie(name, nerdiness, klingon, KirkBetterPicard, costume);
//                        break;
//                    case " GamerGeek":
//                        nerd = new GamerGeek(name, nerdiness, consolePref);
//                        break;
//                    default:
//                        //System.out.println("unknown error occurred");
//                        break;
//                }
//                fileInputNerdList.add(nerd);
//            }
//
//        }
//        showNerdList(fileInputNerdList);
//        // remember to close the file
//        inputFile.close();
//
//        keyboard = new Scanner(System.in);
//        System.out.println("Nerd Roster created, press return to continue...");
//        s = keyboard.nextLine();
//
//        //*************LAB 2 Part 3****************
//
//        int counter = 1; // used to know what record I am dealing with
//        //accessing new file
//        FileWriter fwriter = new FileWriter("nerdRoster.txt", true);
//        PrintWriter outputFile1 = new PrintWriter(fwriter);
//        try {
//
//            //initiating Scanner
//            inputFile = new Scanner(currentFile);
//            while(inputFile.hasNext())
//            {
//                line = inputFile.nextLine();
//                //System.out.println(line);
//                // keeping track of what entry I am on
//                if(line.charAt(0) == '-') counter++;
//                //if i have reached 3rd or 7th entry
//                else if(counter == 3 || counter == 7)
//                {
//                    while(line.charAt(0) != '-') {
//                        //parsing the line into an array of substrings
//                        String[] subStringArray = line.split(":");
//                        if (subStringArray[0].equals("Name")) {
//                            if (counter == 3) subStringArray[1] = "Phineas Q. Arbuckle";
//                            else subStringArray[1] = "Booger McStickyfingers";
//                        }
//                        line = inputFile.nextLine();
//                        outputFile1.println(subStringArray[0] + ": " + subStringArray[1]);
//                    }
//                    counter++;
//                }
//                outputFile1.println(line);
//            }
//            outputFile1.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}

