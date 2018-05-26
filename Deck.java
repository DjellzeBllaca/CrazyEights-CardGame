import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
public class Deck {
   
   private static ArrayList<Card> deckArray = new ArrayList<Card>();

   private Card[] shuffleArray = new Card[52];
   
   public Deck(){
     int count=0;
      for(int i=1;i<14;i++){
         for(int j=1;j<5;j++){
         switch (j){
         case 1: shuffleArray[count] = new Card(i,"D"); break;
         case 2: shuffleArray[count] = new Card(i,"C");break;
         case 3: shuffleArray[count] = new Card(i,"H"); break;
         case 4: shuffleArray[count] = new Card(i,"S");break;
         }
         count++;
                  
         }
      }
			
		

      shuffle();
      for(int i=0;i<52;i++){
          getDeckArray().add(0,shuffleArray[i]);
      }
   }
   
   public void shuffle(){
       
      int swap1;
      int swap2;
      Card temp;
      for(int i=0;i<1000;i++){
         Random random = new Random();
         swap1 = random.nextInt(52);
         swap2 = random.nextInt(52);
         temp = shuffleArray[swap1];
         shuffleArray[swap1] = shuffleArray[swap2];
         shuffleArray[swap2] = temp;
      }
      
   }
   
   public void deal(Player a, Player b){
	   for(int i=0;i<8;i++){
		   a.playerHand.addCard(getDeckArray().remove(0)); 
		   b.playerHand.addCard(getDeckArray().remove(0));
	   }
   }
  
     public Card pop(){
	   if(deckArray.isEmpty()){
	   System.out.println("The deck is empty");
	  return null;
	  }
	   
	   return deckArray.remove(deckArray.size()-1);   ////////////////////
   }

   public static void setDeckArray(ArrayList<Card> deckArray) {
	Deck.deckArray = deckArray;
   }

	public static ArrayList<Card> getDeckArray() {
		return deckArray;
	} 
}