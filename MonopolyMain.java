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
		
		//EACH TIME THIS LOOPS IS A DIFFERENT PLAYER'S TURN
		while(!bDone){
			
			JOptionPane.showMessageDialog(null,(aPlayers[turn.getTurn()].getPlayerName()+ "'s Turn"));
			
			//Account Summary
			System.out.println("\n\n----------------------------" +" "+aPlayers[turn.getTurn()].getPlayerName() + "'s turn " +"---------------------------");
			System.out.print("Beginning: "+aPlayers[turn.getTurn()].statusReport() + aBoard[aPlayers[turn.getTurn()].getBoardPosition()].getsName()
					+ " and you own the following properties: \n");
			System.out.print(aPlayers[turn.getTurn()].getStrListOfPropsOwned(aBoard));
			
			//Rolls dice + appropriate response to roll
			int iDoublesCount = 0;
			boolean bDoubles;
			//Do While Doubles
			do{
				aBoard = aPlayers[turn.getTurn()].buyHouses(aBoard);
				
				bDoubles = false;
				JOptionPane.showMessageDialog(null,"Roll");
				
				int [] aRoll = Randoms.RandomDice();
				//IF DOUBLES ROLL AGAIN
				if(aRoll[0]==aRoll[1]){
					bDoubles = true;
					iDoublesCount++;
				}
				//IF 3 DOUBLES
				if(iDoublesCount == 3){
					aPlayers[turn.getTurn()].setBoardPosition(30);
					break;
				}
				//IF IN JAIL
				//FIX IF TWO ROLLS IN JAIL WILL COUNT AS TWO TURNS SPENT
				if(aPlayers[turn.getTurn()].getJailStatus()){
					if(bDoubles){
						aPlayers[turn.getTurn()].toggleJail();
					}
					else{
						aPlayers[turn.getTurn()].turnInJail();
					}
				}
				//IF NOT IN JAIL
				else{
					aPlayers[turn.getTurn()].moveForward(aRoll[2]);
					JOptionPane.showMessageDialog(null,("You landed on " + aBoard[aPlayers[turn.getTurn()].getBoardPosition()].getsName() + "!"));
				
				
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
					int iLandedOn = aPlayers[turn.getTurn()].getBoardPosition();
					//Special Places to land on
					if(iLandedOn == 2 ||iLandedOn == 17 ||iLandedOn == 33){
						aPlayers = CommunityChest.card(aPlayers, aPlayers[turn.getTurn()].getPlayerID(), aBoard);
					}
					else if(iLandedOn == 7 ||iLandedOn == 22 ||iLandedOn == 36){
						aPlayers = Chance.card(aPlayers, aPlayers[turn.getTurn()].getPlayerID(), aBoard);
					}
					else if(iLandedOn == 4){
						aPlayers[turn.getTurn()].setMoney(aPlayers[turn.getTurn()].getPlayerMoney()-200);
						JOptionPane.showMessageDialog(null,"You paid $200 for Income Tax!");
					}
					else if(iLandedOn == 38){
						aPlayers[turn.getTurn()].setMoney(aPlayers[turn.getTurn()].getPlayerMoney()-75);
						JOptionPane.showMessageDialog(null,"You paid $75 for Luxury Tax!");
					}
					else if(iLandedOn == 30){
						aPlayers[turn.getTurn()].setBoardPosition(10);
						aPlayers[turn.getTurn()].toggleJail();
						JOptionPane.showMessageDialog(null,"Go Directly to Jail, Do not pass go, Do not Collect 200!");
					}
					
					if(bOwned){
						if(iOwnerID != turn.getTurn() ){
							int amount = aBoard[aPlayers[turn.getTurn()].getBoardPosition()].landedOn();
							JOptionPane.showMessageDialog(null,"You landed on"+
							aBoard[aPlayers[turn.getTurn()].getBoardPosition()].getsName()+" with "+
							aBoard[aPlayers[turn.getTurn()].getBoardPosition()].getNumHouses()+ " house(s)"+
							" and paid "+ aPlayers[iOwnerID].getPlayerName()+ " $" + amount);
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
				}
			}while(bDoubles);
			//END OF TURN SUMMARY
			System.out.print("\nEnd: "+aPlayers[turn.getTurn()].statusReport() + aBoard[aPlayers[turn.getTurn()].getBoardPosition()].getsName()
					+ " and you own the following properties: \n");
			System.out.print(aPlayers[turn.getTurn()].getStrListOfPropsOwned(aBoard));
			
			//SWITCHES TURN TO THE NEXT PLAYER
			turn.incrementTurn();
		}
		
		
	}

}
