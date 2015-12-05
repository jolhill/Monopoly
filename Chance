import java.util.Random;
	
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
		Random oRandom = new Random();
		
		public Players [] card(Players [] aPlayers, int iPlayerID, Properties [] oBoard){
			
			int iCard = (oRandom.nextInt(13) + 1);
			
			if(iCard == 1)
				card1(aPlayers[iPlayerID]);
			else if(iCard == 2)
				card2(aPlayers[iPlayerID]);
			else if(iCard == 3)
				card3(aPlayers[iPlayerID]);
			else if(iCard == 4)
				card4(aPlayers[iPlayerID]);
			else if(iCard == 5)
				card5(aPlayers[iPlayerID]);
			else if(iCard == 6)
				card6(aPlayers[iPlayerID]);
			else if(iCard == 7)
				card7(aPlayers[iPlayerID]);
			else if(iCard == 8)
				card8(aPlayers[iPlayerID]);
			else if(iCard == 9)
				card9(aPlayers[iPlayerID]);
			else if(iCard == 10)
				card10(aPlayers[iPlayerID]);
			else if(iCard == 11)
				card11(aPlayers[iPlayerID]);
			else if(iCard == 12)
				card12(aPlayers[iPlayerID]);
			else
				card13(aPlayers[iPlayerID]);
			
			return aPlayers;
		}
		// Card 1:Advance to Go, Collect 200
		public Players card1(Players oPlayer){
			oPlayer.setBoardPosition(0);
			oPlayer.setMoney(oPlayer.getPlayerMoney()+200);
			return oPlayer;
		}
		//Card 2:Advance to Illinois Ave , If you pass Go , collect 200$
		public Players card2(Players oPlayer){
			if(oPlayer.getBoardPosition()>=24){
				oPlayer.setBoardPosition(24);
				oPlayer.setMoney(oPlayer.getPlayerMoney()+200);
				return(oPlayer);
			}
				oPlayer.setBoardPosition(24);
				return(oPlayer);
		}
		//Go Directly to jail do not pass go do not collect 200$
		public Players card3(Players oPlayer){
			oPlayer.setBoardPosition(10);
			return(oPlayer);
		}
		// 4:"Make General Repairs on all property"(For each house pay $25, for each hotel pay $100) 
		public Players card4(Players oPlayer, Properties [] oBoard){
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
				oPlayer.setMoney(oPlayer.getPlayerMoney()-iTotalCost);
			return(oPlayer);
		}
		// 5:"Take a walk on the boardwalk" (Advance "token" to boardwalk)
		public Players card5(Players oPlayer){
			oPlayer.setBoardPosition(39);
			return(oPlayer);
		}
		// 6: "Advance" to ST.Charles Place - If you pass Go, collect $200"
		public Players card6(Players oPlayer){
			if(oPlayer.getBoardPosition()>=11){
				oPlayer.setBoardPosition(11);
				oPlayer.setMoney(oPlayer.getPlayerMoney()+200);
				return(oPlayer);
			}
				oPlayer.setBoardPosition(11);
				return(oPlayer);
	
		}
		// 7:Bank Pays you a dividend of $50
		public Players card7(Players oPlayer){
			oPlayer.setMoney(oPlayer.getPlayerMoney()+50);
			return(oPlayer);
		}
		// 8:Your building and loan matures collect $150
		public Players card8(Players oPlayer){
			oPlayer.setMoney(oPlayer.getPlayerMoney()+150);
			return(oPlayer);
		}
		// 9:Take a trip on the reading railroad , if you pass go collect 200$
		public Players card9(Players oPlayer){
			while(oPlayer.)
			if(oPlayer.getBoardPosition()>=5){	
				oPlayer.setBoardPosition(5);
				oPlayer.setMoney(oPlayer.getPlayerMoney()+200);
				return(oPlayer);
			}
				oPlayer.setBoardPosition(5);
				return(oPlayer);
		}
		public Players card10(Players oPlayer){
			//WRITE CARD HERE(it should modify the player, and then return the player)
			return(oPlayer);
		}
		public Players card11(Players oPlayer){
			//WRITE CARD HERE(it should modify the player, and then return the player)
			return(oPlayer);
		}
		public Players card12(Players oPlayer){
			//WRITE CARD HERE(it should modify the player, and then return the player)
			return(oPlayer);
		}
		public Players card13(Players oPlayer){
			//WRITE CARD HERE(it should modify the player, and then return the player)
			return(oPlayer);
		}

	
}
