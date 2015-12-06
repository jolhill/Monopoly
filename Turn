
public class Turn {
	//Trade -- exchange prop for money
	//Buy/sell houses
	//mortgage
	//purchase or pay rent (financial stuff)

	private int iTurn;
	private int iNumPlayers;
	
	//Constructor
	public Turn(int iNumPlayers){
		iTurn = 0;
		this.iNumPlayers = iNumPlayers;
		
	}
	public void setTurn(int iNumPlayers,int turn){
		iTurn = turn;
		if(iTurn >= iNumPlayers){
			iTurn = 0;
		}
	}
	public void incrementTurn(){
		iTurn++;
		if(iTurn >= iNumPlayers){
			iTurn = 0;
		}
	}
	public int getTurn(){
		return iTurn;
	}
	
	public String toString(){
		return("It is currently player " + (iTurn+1)+ "'s turn.");
	}
	
	
	public Players [] transferMoney(int amount,int player1ID,int player2ID,Players [] aPlayers){
		aPlayers[player1ID].setMoney(aPlayers[player1ID].getPlayerMoney()-amount);
		aPlayers[player2ID].setMoney(aPlayers[player2ID].getPlayerMoney()+amount);
		return aPlayers;
	}
	
	public Players[] transferProperty(int iProp, int player1ID,int player2ID,Players [] aPlayers){
		aPlayers[player1ID].toggleOwnership(iProp);
		aPlayers[player2ID].toggleOwnership(iProp);
		return aPlayers;
	}

}
