public class userGuessBreakdown
{
  int numHeads;
  int numTails;
  
  public userGuessBreakdown()
  {
    numHeads=0;
    numTails=0;
  }
  
  public void incrementHeads()
  {
    numHeads++;
  }
  
  public void incrementTails()
  {
    numTails++;
  }
  
  //returns 0 for heads and 1 for tails
  public int predictedUserGuess()
  {
    if(numHeads>numTails)
    {
      return 0;
    }
    else
    {
      return 1;
    }
  }
  
}