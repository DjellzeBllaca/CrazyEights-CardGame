import javax.swing.*;
public class StartGame {
	private static void StartGame(){
		int value=0;
		String suit;
      String tempS; 
      String tempTemp="not pass";
      
		Game gameObj= new Game();	
            
		Deck deck = new Deck();
      
		Card playedCard=null; // current played card
      
		Player prevPlayer= null;// hold the previous player turn
		
		System.out.println("Welcome to the Game of CRAZY EIGHTS!");
      System.out.println("There are going to be 2 players in this game");
      System.out.println("Please enter your name:");
		gameObj.setPlayer();
		
   	gameObj.createPlayers(gameObj.totalPlayers, gameObj.humanPlayers, gameObj.getName());
		deck.deal(gameObj.getPlayer1(), gameObj.getPlayer2());
		
		//create discard pile and the start of the first discarded of the deck 
		gameObj.setDiscardPile(deck.pop());
		
		//The first player is always first 
		gameObj.setCurPlayer(gameObj.getPlayer1());	
		
		//Game play start here
		while(!(gameObj.getCurPlayer().getPlayerHand().isEmpty())){

			System.out.println("["+gameObj.getCurPlayer().getName()+"]: It's your turn now.");
			System.out.println("["+gameObj.getCurPlayer().getName()+"]'s Hand: "+ gameObj.getCurPlayer().getPlayerHand().getList()+".");
			System.out.println("The top card on the discard pile is "+ gameObj.getDiscardPile()+".");
			
			prevPlayer=gameObj.getCurPlayer();		// hold current player
			
			if(gameObj.getCurPlayer().isHuman()){
				do{
					value=Integer.parseInt(JOptionPane.showInputDialog(gameObj.getCurPlayer().getName()+", please enter a value: \n'0' to pass turn, \n'1' for Ace, \n'2' for 2,\n... \n'11' for Jack, \n'12' for Queen, \n'13' for King:"));
					suit= (JOptionPane.showInputDialog(gameObj.getCurPlayer().getName()+", please enter a suit: \n'p' to pass turn \n'c' for Clubs \n'h' for Hearts \n's' for Spades \n'd' for Diamonds ")).toUpperCase();
					
					if(value==0 && suit.equalsIgnoreCase("p")){
						gameObj.getCurPlayer().drawCard(deck.pop());
						tempTemp= "pass";
						break;
					}
					playedCard= new Card(value,suit);
					
				}while((!gameObj.getCurPlayer().getPlayerHand().isInHand(playedCard)) || (!gameObj.isValid(playedCard, gameObj.getDiscardPile())));
				
				if(!tempTemp.equalsIgnoreCase("pass"))
					gameObj.setDiscardPile(gameObj.getCurPlayer().playCard(playedCard));//play CARD
			}
			else if( !gameObj.getCurPlayer().isHuman()){
				
				Card temp=gameObj.getCurPlayer().getPlayerHand().isValidInHand((gameObj.getDiscardPile()));
				
				if(temp==null){
					System.out.println("No valid move, please draw a card or pass your turn , "+ gameObj.getCurPlayer().name);
					gameObj.getCurPlayer().drawCard(deck.pop());
					tempTemp="pass";
				}
				else{
					gameObj.setDiscardPile(gameObj.getCurPlayer().playCard(temp));//play CARD
				}
			}//end of else-if cpu move
			else{
				//add new type of player later
			}
			
			
			if(!tempTemp.equalsIgnoreCase("pass")){
				System.out.println("["+gameObj.getCurPlayer().getName()+"]: You played "+gameObj.getDiscardPile()+". Smart move.");

				//Special cases: draw 2 and crazy eights
				if(gameObj.getDiscardPile().getValue()==2){
					System.out.println("["+gameObj.getCurPlayer().getName()+"] has played a 2. The next player will draw 2 cards.");
					gameObj.nextPlayer();		//switch to next player turn
	
					gameObj.getCurPlayer().drawCard(deck.pop());
					gameObj.getCurPlayer().drawCard(deck.pop());
					System.out.println("["+gameObj.getCurPlayer().getName()+"] has drawn 2 cards.");
		
					gameObj.setCurPlayer(prevPlayer);//back to the current player
				}
				
				if(gameObj.getDiscardPile().getValue()==8){
					
					System.out.println(gameObj.getCurPlayer().getName()+", you played a crazy card.");
					
					if(gameObj.getCurPlayer().isHuman()){
						tempS=JOptionPane.showInputDialog("Would you like to change the suit of the card? yes or no");
						if(tempS.equalsIgnoreCase("yes")){
							tempS=JOptionPane.showInputDialog("Please enter the suit;\nc for Club, \nh for Hearts, \ns for Spades, \nd for Diamonds");
							gameObj.getDiscardPile().setSuit(tempS);
						}

						
					}
					
					else{
						System.out.println("The Computer has modified the suit of the last card played.");
						gameObj.getDiscardPile().setSuit(gameObj.getCurPlayer().getPlayerHand().searchForSuit());
							
					}
	
				}
			}//end of temp
								
			//check to see if the game has ended
			if((gameObj.getCurPlayer().getPlayerHand().isEmpty())){
				System.out.println("Congratulations "+ gameObj.getCurPlayer().getName() + "!. You have won!");
				System.exit(0);
			}
			
	         System.out.println("\n\n\n");

			tempTemp="not pass";
			gameObj.nextPlayer();//switch to next player turn
		}
	}
	
	public static void main(String []args){
		StartGame();
	}

}