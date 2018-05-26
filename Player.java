public  class Player {
	
	public String name;
	public Hand playerHand = new Hand();
	
	public Card playCard(Card a){
		return a;
	}

	
	public void drawCard(Card a){
		
	}

	
	public boolean isHuman(){
		return true;
	}
	
	public Hand getPlayerHand(){return playerHand;} 
	
	public String getName(){return name;}

}