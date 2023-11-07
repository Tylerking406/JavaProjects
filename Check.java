/*
This question concerns comparing a set of cards as part of a card game.

A card has three attributes: a shape (square or circle or triangle), a colour (blue or red or green) and a pattern (spot or solid or stripe).
Two cards are distinct if they do not have the same shape or colour or pattern i.e. none of their attributes match.
Two cards are the same if they have the same shape and colour and pattern i.e. all their attributes match.
A set of three cards is valid if it consists of (i) three distinct cards, or (ii) three of the same card.
'Check.java' accepts as input a text file where each line describes a set of cards. The program will determine whether each set is or is not valid.
 */
//
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Check {
    public static void main(String[] args) throws FileNotFoundException {
        // Read user file
        Scanner input = new Scanner(System.in), file;
        System.out.println("Enter the name of the cards file:");
        String filename = input.nextLine();
        File f = new File(filename);
        file = new Scanner(f);

        //processing
        while (file.hasNextLine()){
            String line = file.nextLine();  // square,blue,spot circle,red,solid triangle,green,stripe
            String[] cards = line.split(" "); // cards[0] = square,blue,spot cards[1]= circle,red,solid
            String  check= card(cards[0],cards[1],cards[2]);
            //method to compare
            System.out.println("Processing: "+line);

            System.out.println(card(cards[0],cards[1], cards[2]));

        }
        System.out.println("Done");
    }
    public static  String card(String card1, String card2, String card3 ){ //square,blue,spot
        String[] cardArr1 = card1.split(",");
        String shape1 = cardArr1[0];
        String colour1 = cardArr1[1];
        String pattern1 = cardArr1[2];

        String[] cardArr2 = card2.split(",");
        String shape2 = cardArr2[0];
        String colour2 = cardArr2[1];
        String pattern2 = cardArr2[2];

        String[] cardArr3 = card3.split(",");
        String shape3 = cardArr3[0];
        String colour3 = cardArr3[1];
        String pattern3 = cardArr3[2];

        boolean flagShape12 = compare2cards(shape1, shape2);
        boolean flagColour12 = compare2cards(colour1, colour2);
        boolean flagPattern12 = compare2cards(pattern1, pattern2);

        boolean flagShape13 = compare2cards(shape1, shape3);
        boolean flagColour13 = compare2cards(colour1, colour3);
        boolean flagPattern13 = compare2cards(pattern1, pattern3);

        boolean flagShape23 = compare2cards(shape2, shape3);
        boolean flagColour23 = compare2cards(colour2, colour3);
        boolean flagPattern23 = compare2cards(pattern2, pattern3);


        boolean yes = true;
        boolean no  = false;

//       if ((flagShape12 && flagShape23 && flagShape13) && (flagColour12 && flagColour23 && flagColour13) && (flagPattern12 && flagPattern23 && flagPattern13))
//           return  "Valid";
//       else if ((flagShape12 && flagShape23 && flagShape13) || (flagColour12 && flagColour23 && flagColour13) || (flagPattern12 && flagPattern13 && flagPattern23)) {
//           return  "Valid";

        if ((flagShape12 && flagShape23 && flagShape13) && (flagColour12 && flagColour23 && flagColour13) && (flagPattern12 && flagPattern23 && flagPattern13))
          return  "Valid";
        else if (!(flagShape12 == flagShape23 == flagShape13) && !(flagColour12 == flagColour23 == flagColour13) && !(flagPattern12 == flagPattern23 == flagPattern13) ) {
            return "Valid";
        } else
           return "Invalid";

    }

    public  static boolean compare2cards(String shape1, String shape2){
        return shape1.equals(shape2);
    }
}
