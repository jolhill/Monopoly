import java.util.Random;
import javax.swing.JOptionPane;	
	// 1:"Advance" to Illinois Ave. - If you pass Go, collect $200"
	// 2:"Advance" to nearest Utility, if you pass go collect 200$ if unowned you may buy from bank."
	// 3:"Go "directly" to jail"(Do no pass go,Do not collect 200$)
	// 4:"Make General Repairs on all property"(For each house pay $25, for each hotel pay $100)  
	// 5:"Take a walk on the boardwalk" (Advance "token" to boardwalk)
	// 6: "Advance" to ST.Charles Place - If you pass Go, collect $200"
	// 7:Bank Pays you a dividend of $50
	// 8:Your building and loan matures collect $150
	// 9:Take a trip on the reading railroad , if you pass go collect 200$
	// 10: Go back 3 "spaces"
	// 11:Pay poor tax of $15
	// 12:You have been elected chairman of the board! pay each player $50
	// 13:"Advance token to the nearest Railroad and pay owner twice the rental to which he/she is entitled. if Railroad is unowned you may buy it from the bank.
	
	public class Chance{
		
		private static Random oRandom = new Random();
		
		public static Players [] card(Players [] aPlayers, int iPlayerID, Properties [] oBoard){
			
			int iCard = (oRandom.nextInt(13) + 1);
			iPlayerID -= 1;
			if(iCard == 1)
				aPlayers[iPlayerID] = card1(aPlayers[iPlayerID]);
			else if(iCard == 2)
				aPlayers[iPlayerID] = card2(aPlayers[iPlayerID]);
			else if(iCard == 3)
				aPlayers[iPlayerID] = card3(aPlayers[iPlayerID]);
			else if(iCard == 4)
				aPlayers[iPlayerID] = card4(aPlayers[iPlayerID],oBoard);
			else if(iCard == 5)
				aPlayers[iPlayerID] = card5(aPlayers[iPlayerID]);
			else if(iCard == 6)
				aPlayers[iPlayerID] = card6(aPlayers[iPlayerID]);
			else if(iCard == 7)
				aPlayers[iPlayerID] = card7(aPlayers[iPlayerID]);
			else if(iCard == 8)
				aPlayers[iPlayerID] = card8(aPlayers[iPlayerID]);
			else if(iCard == 9)
				aPlayers[iPlayerID] = card9(aPlayers[iPlayerID]);
			else if(iCard == 10)
				aPlayers[iPlayerID] = card10(aPlayers[iPlayerID]);
			else if(iCard == 11)
				aPlayers[iPlayerID] = card11(aPlayers[iPlayerID]);
			else if(iCard == 12)
				aPlayers = card12(iPlayerID,aPlayers);
			else
				aPlayers[iPlayerID] = card13(aPlayers[iPlayerID]);
			
			return aPlayers;
		}
		// Card 1:Advance to Go, Collect 200
		private static Players card1(Players oPlayer){
			JOptionPane.showMessageDialog(null,"Advance to Go, Collect 200");
			oPlayer.setBoardPosition(0);
			oPlayer.setMoney(oPlayer.getPlayerMoney()+200);
			return oPlayer;
		}
		//Card 2:Advance to Illinois Ave , If you pass Go , collect 200$
		private static Players card2(Players oPlayer){
			if(oPlayer.getBoardPosition()>=24){
				oPlayer.setBoardPosition(24);
				oPlayer.setMoney(oPlayer.getPlayerMoney()+200);
				JOptionPane.showMessageDialog(null,"Advance to Illinois Ave , If you pass Go , collect 200$");
				JOptionPane.showMessageDialog(null,"You passed go, collect $200!");
				return(oPlayer);
			}
			else{
				oPlayer.setBoardPosition(24);
				JOptionPane.showMessageDialog(null,"Advance to Illinois Ave , If you pass Go , collect 200$");
				JOptionPane.showMessageDialog(null,"You did not pass go.");
				return(oPlayer);
			}
		}
		//Go Directly to jail do not pass go do not collect 200$
		private static Players card3(Players oPlayer){
			JOptionPane.showMessageDialog(null,"Go Directly to jail do not pass go do not collect 200$");
			oPlayer.setBoardPosition(30);
			return(oPlayer);
		}
		// 4:"Make General Repairs on all property"(For each house pay $25, for each hotel pay $100) 
		private static Players card4(Players oPlayer, Properties [] oBoard){
			JOptionPane.showMessageDialog(null,"Make General Repairs on all property(For each house pay $25, for each hotel pay $100) ");
			int [] aPropertiesOwned = oPlayer.getOwnedProperties();
			int iHotel = 0;
			int iHouses=0;
			for(int i = 0; i < aPropertiesOwned.length; i++){
				int Houses = oBoard[i].getNumHouses();
				if(Houses ==5)
					iHotel++;
				else{
					iHouses+=Houses;
				}
			}
				int iTotalCost = iHotel*100+iHouses*25;
				JOptionPane.showMessageDialog(null,("You paid: "+ iTotalCost));
				oPlayer.setMoney(oPlayer.getPlayerMoney()-iTotalCost);
			return(oPlayer);
		}
		// 5:"Take a walk on the boardwalk" (Advance "token" to boardwalk)
		private static Players card5(Players oPlayer){
			JOptionPane.showMessageDialog(null,"Advance token to boardwalk");
			oPlayer.setBoardPosition(39);
			return(oPlayer);
		}
		// 6: "Advance" to ST.Charles Place - If you pass Go, collect $200"
		private static Players card6(Players oPlayer){
			JOptionPane.showMessageDialog(null,"Advance to ST.Charles Place - If you pass Go, collect $200");
			if(oPlayer.getBoardPosition()>=11){
				oPlayer.setBoardPosition(11);
				oPlayer.setMoney(oPlayer.getPlayerMoney()+200);
				JOptionPane.showMessageDialog(null,"You passed go, collect $200!");
				return(oPlayer);
			}
			else{
				oPlayer.setBoardPosition(11);
				JOptionPane.showMessageDialog(null,"You did not pass go.");
				return(oPlayer);
			}
	
		}
		// 7:Bank Pays you a dividend of $50
		private static Players card7(Players oPlayer){
			JOptionPane.showMessageDialog(null,"Bank Pays you a dividend of $50");
			oPlayer.setMoney(oPlayer.getPlayerMoney()+50);
			return(oPlayer);
		}
		// 8:Your building and loan matures collect $150
		private static Players card8(Players oPlayer){
			oPlayer.setMoney(oPlayer.getPlayerMoney()+150);
			return(oPlayer);
		}
		// 9:Take a trip on the reading railroad , if you pass go collect 200$
		private static Players card9(Players oPlayer){
			JOptionPane.showMessageDialog(null,"Take a trip on the reading railroad , if you pass go collect 200$");
			if(oPlayer.getBoardPosition()>=5){	
				oPlayer.setBoardPosition(5);
				oPlayer.setMoney(oPlayer.getPlayerMoney()+200);
				JOptionPane.showMessageDialog(null,"You passed go, collect $200!");
				return(oPlayer);
			}
			else{
				JOptionPane.showMessageDialog(null,"You did not pass go.");
				oPlayer.setBoardPosition(5);
				return(oPlayer);
			}
		}
		// 10: Go back 3 "spaces"
		private static Players card10(Players oPlayer){
			JOptionPane.showMessageDialog(null, "Go back 3 spaces");
			oPlayer.setBoardPosition(oPlayer.getBoardPosition()-3);
			return(oPlayer);
		}
		// 11:Pay poor tax of $15
		private static Players card11(Players oPlayer){
			JOptionPane.showMessageDialog(null, "Pay poor tax of $15");
			oPlayer.setMoney(oPlayer.getPlayerMoney()-15);
			return(oPlayer);
		}
		// 12:You have been elected chairman of the board! pay each player $50
		private static Players [] card12(int iPlayerID,Players [] aPlayers){
			//aPlayers[i] is who you give to
			//aPlayers[iPlayerID] is the giver
			JOptionPane.showMessageDialog(null, "You have been elected chairman of the board! pay each player $50");
			for(int i = 0; i < aPlayers.length; i++){
				aPlayers[iPlayerID].setMoney(aPlayers[iPlayerID].getPlayerMoney()-50);
				aPlayers[i].setMoney(aPlayers[i].getPlayerMoney()+50);
			}
			JOptionPane.showMessageDialog(null, "You paid $" + ((aPlayers.length-1)*50));
			return(aPlayers);
		}
		// 13:"Advance token to the nearest Railroad and pay owner twice the rental to which he/she is entitled.
		//if Railroad is unowned you may buy it from the bank.
		private static Players card13(Players oPlayer){
			JOptionPane.showMessageDialog(null,"Advance token to the nearest Railroad");
			if(oPlayer.getBoardPosition()<5 && oPlayer.getBoardPosition()>=35){
				oPlayer.setBoardPosition(5);
			}
				else if(oPlayer.getBoardPosition()<15 && oPlayer.getBoardPosition() >=5){
					oPlayer.setBoardPosition(15);
				}
				else if(oPlayer.getBoardPosition()<25 && oPlayer.getBoardPosition() >=15){
					oPlayer.setBoardPosition(25);
				}
				else if(oPlayer.getBoardPosition()<35 && oPlayer.getBoardPosition() >=25){
					oPlayer.setBoardPosition(35);
				}
			return(oPlayer);
		}

	
}
