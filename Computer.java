public class Computer extends Player{


	public Computer(String x){
		name = x;
	}


	public Card playCard(Card x){
		//check for null exception
		if(x==null)return null;
		
		playerHand.removeCard(x);
		return x;
	}

	public void drawCard(Card x){
		//check for null exception
		if(x==null) return;
		playerHand.addCard(x);

	}


	public boolean isHuman(){
		return false;
	}
}
