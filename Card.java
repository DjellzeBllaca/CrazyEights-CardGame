public class Card {
   
   private int value;
   private String suit;

   public Card (int a, String b){
      value=a;
      suit=b;
   }
   
   public void setValue(int a){
	   value=a;
   }
   
   public void setSuit(String b){
	   suit=b;
   }
   
   public int getValue(){
      return value;
   }
   
   public String getSuit(){
      return suit;
   }
   
   public String toString(){
  
	   if (value==1){
		   return ("Ace "+suit);
	   }
	   else if (value==11){
		   return ("Jack "+suit);
	   }
	   else if (value==12){
		   return ("Queen "+suit);
	   }
	   else if (value==13){
		   return ("King "+suit);
	   }
	   else {
		   return (value+suit);
	   }
	     
   }
   
}