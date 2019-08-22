public class Hash{

    //TODO: create a user guess breakdown array
    userGuessBreakdown []  userGuesses ;

    public Hash()
    {
        //intialize userGuessBreakdown based on the array size for the game4
        userGuesses = new userGuessBreakdown[16];
    }

    //Tells you what to guess next if key exists!
    public int searchKey(String key)
    {
        //TODO convert Key to index by using the hashing function below

        //TODO: Returns 0 or 1 if the key has a value associated with it (0 for guess heads, 1 for guess tails)
        //returns -1 if no value associated with it (i.e, currently references null))
        //this indicates the computer should randomly guess at what the user will say next
        int index = this.hashingFunction(key);
        if(this.userGuesses[index]!=null){
            return this.userGuesses[index].predictedUserGuess();
        }
        return -1;
    }

    //puts a key like "1010" to a value like "1" (means thth hashes to t)
    public void insert(String key, int value)
    {

        //TODO use hashingFunction to determine the index
        //TODO if a userGuessBreakdown object exists-- update the value numHeads or numTails
        //TODO if a userGuessBreakdown object does not exist at this location-- create a userGuessBreakdown object,
        //update the numHeads and numTails in this object based on value, and insert it into the array.
        int index = this.hashingFunction(key);
        if(this.userGuesses[index]==null){this.userGuesses[index] = new userGuessBreakdown();}
        if(value==0){this.userGuesses[index].incrementHeads();}
        else {this.userGuesses[index].incrementTails();}
    }

    public int hashingFunction(String key)
    {
        //Converts the
        //Returns the index from the key by converting it to decimal (really converting the 4 digit binary number to decimal)
//        System.out.println("INput "+ key);
        char[] keys = key.toCharArray();
        char k;
        int val=0, temp=0;
        for(int i=keys.length-1,j=0; i>=0; i--,j++){
            k = keys[i];
            temp = 0;
            if (k=='t'){temp=1;}
            val = (int) (val + temp*Math.pow(2,j));
        }
//        System.out.println("Value "+val);
        return val;
    }




}