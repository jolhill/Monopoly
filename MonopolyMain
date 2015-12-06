import javax.swing.JOptionPane;

public class MonopolyMain {

	//trade,buy/sell houses, morgage/unmorgage, roll, buy/pay rent for property/financial handling for debt (while inDebt:)
	//iTurn++ (iTurn modular for # of Players, whereas iTurnStep is modular for # of options per player turn)
	//iTurn corresponds with player ID

	
	public static void main(String[] args) {
		
		
		Players [] aPlayers = setup.playerSetup();
		Properties [] aBoard = setup.propertiesSetup();
		Turn turn = new Turn(aPlayers.length);
		boolean bDone = false;
		while(!bDone){
			System.out.println("\n\n----------------------------" +" "+aPlayers[turn.getTurn()].getPlayerName() + "'s turn " +"---------------------------");
			System.out.print(aPlayers[turn.getTurn()].statusReport() + aBoard[aPlayers[turn.getTurn()].getBoardPosition()].getsName()
					+ " and you own the following properties: ");
			System.out.print(aPlayers[turn.getTurn()].getStrListOfPropsOwned(aBoard));
			//Rolls dice + appropriate response to roll
			int iDoublesCount = 0;
			boolean bDoubles;
			do{
				bDoubles = false;
				//Menu.YesNoPrompt(aPlayers[turn.getTurn()].getPlayerName()+"'s roll");
				JOptionPane.showMessageDialog(null, "Roll");
				System.out.print(aPlayers[turn.getTurn()].getPlayerName());
				int [] aRoll = Randoms.RandomDice();
				if(aRoll[0]==aRoll[1]){
					bDoubles = true;
					iDoublesCount++;
				}
				if(iDoublesCount == 3){
					aPlayers[turn.getTurn()].setBoardPosition(30);
					break;
				}
				if(aPlayers[turn.getTurn()].getJailStatus()){
					if(bDoubles){
						aPlayers[turn.getTurn()].toggleJail();
					}
					else{
						aPlayers[turn.getTurn()].turnInJail();
					}
				}
				else{
				aPlayers[turn.getTurn()].moveForward(aRoll[2]);
				System.out.println("You landed on " + aBoard[aPlayers[turn.getTurn()].getBoardPosition()].getsName() + "!");
				}
				
				//Checks for ownership of what they landed on
				aPlayers[turn.getTurn()].getBoardPosition();
				boolean bOwned = false;
				//Possibly an issue, but probably fine, if I don't give it an initial value, 
				//later it says that it may not have been initialized
				int iOwnerID = 0;
				for(int i = 0; i < aPlayers.length; i ++){
					int [] aPropsOwned = aPlayers[i].getOwnedProperties();
					for(int j = 0; j < aPropsOwned.length; j++){
						if(aPropsOwned[j] == aPlayers[turn.getTurn()].getBoardPosition()){
							bOwned = true;
							iOwnerID = i;
						}
					}
				}
				if(bOwned){
					if(iOwnerID != turn.getTurn() ){
						int amount = 100;
						turn.transferMoney(amount, turn.getTurn(), iOwnerID, aPlayers);
					}
				}
				else if(aBoard[aPlayers[turn.getTurn()].getBoardPosition()].isBuyable()){
					boolean bAnswer = Menu.YesNoPrompt("Would you like to buy " 
							+ aBoard[aPlayers[turn.getTurn()].getBoardPosition()].getsName()+ " for $"
							+aBoard[aPlayers[turn.getTurn()].getBoardPosition()].getiCost() +"?");
					if(bAnswer){
						aPlayers[turn.getTurn()].toggleOwnership(aPlayers[turn.getTurn()].getBoardPosition());
						aPlayers[turn.getTurn()].setMoney(aPlayers[turn.getTurn()].getPlayerMoney()-aBoard[aPlayers[turn.getTurn()].getBoardPosition()].getiCost());
					}
				}
			}while(bDoubles);
			
			turn.incrementTurn();
		}
		
		
	}

}
