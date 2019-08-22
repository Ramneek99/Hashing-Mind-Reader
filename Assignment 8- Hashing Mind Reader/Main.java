import java.util.Random;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int userScore=0;
        int compScore=0;
        int counter = 0, temp =0;
        String compGuess="t";
        String userCurrentGuess;
        String pastFourUserGuesses="";
        int roundNumber=0;
        System.out.println("** User Score 0, Computer Score 0 **");
        Hash myHash= new Hash();
        while(userScore!=20 && compScore!=20)
        {
            do
            {
                System.out.println("Type in your choice, h or t followed by enter");
                userCurrentGuess=sc.next();
            }while(!(userCurrentGuess.equals("t") || userCurrentGuess.equals("h")));
            counter++;
            if(userCurrentGuess.equals(compGuess))
            {
                compScore++;
                //TODO: Update the hash based on the user Response
                System.out.println("Comp guessed correct!");
                temp=0;
                if(userCurrentGuess.equals("t")){temp=1;}
                myHash.insert(pastFourUserGuesses,temp);
            }
            else
            {
                userScore++;
                //TODO Update the Hash based on the user Response
                temp=0;
                if(userCurrentGuess.equals("t")){temp=1;}
                myHash.insert(pastFourUserGuesses,temp);
                System.out.println("Comp guessed wrong!");
            }

            System.out.println("** User Score:"+userScore+" Computer Score:"+compScore+ "**");


            //TODO update past4UserGuesses
            pastFourUserGuesses = pastFourUserGuesses + userCurrentGuess;
            if (pastFourUserGuesses.length() > 4){
                pastFourUserGuesses = pastFourUserGuesses.substring(1);
            }

            temp =myHash.searchKey(pastFourUserGuesses) ;
            if(temp != -1){
                // computer guessed
                temp = myHash.searchKey(pastFourUserGuesses);
                compGuess = "h";
                if (temp ==1){compGuess = "t";}
            }else{
                // do random
                temp = rand.nextInt(2);
                compGuess = "h";
                if (temp ==1){compGuess = "t";}
            }

            //TODO use as key to the Hash
            //TODO: if key hashes to value, that is your next guess (invoke searchKey)
            //if key does not hash to value Make a random guess between heads and tails

        }
        //TODO add a message outlining who won and lost

    }
}