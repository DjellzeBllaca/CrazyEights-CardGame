import javax.swing.*;
public class Game {
	
	public static int totalPlayers=2;
	public static int humanPlayers=1;
   public static int computerPlayers=1;
	private static Card discardPile;
	
	private Player currentPlayer;
	
	private Player p1;
	private Player p2;

	private String name;

	public static void setDiscardPile(Card playedCard)
   {discardPile=playedCard;}
   
	public void setCurPlayer(Player p)
   {currentPlayer= p;}
	 
	public String getName(){return name;}
	public Player getPlayer1(){return p1;}
	public Player getPlayer2(){return p2;}
	public Card getDiscardPile(){return discardPile;}
	public Player getCurPlayer(){return currentPlayer;}


	public void setPlayer(){		
	name=JOptionPane.showInputDialog("Please enter your name:");
		}
      
	public void createPlayers(int tp, int hp, String n1){
		
			p1 = new Human(n1);
			p2 = new Computer("Computer");
	}
	public boolean isValid(Card a, Card b){
		
		if((a.getSuit().equals(b.getSuit())))return true;
		
		else if((a.getValue()==b.getValue())||a.getValue()==8)return true;
		
		else{ 
			System.out.println("Invalid Card, Please try again.");
			return false;
		}
	}
	
	public void nextPlayer(){
		
				if(currentPlayer.name==name){
					p1=currentPlayer;
					currentPlayer=p2;
				}
				else{
					p2=currentPlayer;
					currentPlayer=p1;
				}
			}	
	}
