/*takes a number in
 * that number is called for position in an array
 * returns the value stored in that array position
 * use for community chest
 */

import java.util.Random;
	
public class CommunityChest {
	Random oRandom = new Random();
	
	public Players [] card(Players [] aPlayers, int iPlayersID, Properties [] aBoard){
		
		int iCard = (oRandom.nextInt(14) + 1);
		
		if(iCard == 1)
			card1(aPlayers[iPlayersID]);
		else if(iCard == 2)
			card2(aPlayers[iPlayersID]);
		else if(iCard == 3)
			card3(aPlayers[iPlayersID]);
		else if(iCard == 4)
			card4(aPlayers[iPlayersID]);
		else if(iCard == 5)
			card5(aPlayers[iPlayersID]);
		else if(iCard == 6)
			card6(aPlayers[iPlayersID]);
		else if(iCard == 7)
			card7(aPlayers[iPlayersID]);
		else if(iCard == 8)
			card8(aPlayers[iPlayersID]);
		else if(iCard == 9)
			card9(aPlayers[iPlayersID]);
		else if(iCard == 10)
			card10(aPlayers[iPlayersID]);
		else if(iCard == 11)
			card11(aPlayers[iPlayersID]);
		else if(iCard == 12)
			card12(aPlayers[iPlayersID]);
		else if(iCard == 13)
			card13(aPlayers[iPlayersID]);
		else
			card14(aPlayers[iPlayersID],aBoard);
		
		
		return aPlayers;
	}
	
	public Players card1(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()+100);
		System.out.println("Inherit $100");
		return(oPlayer);
	}
	public Players card2(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()+100);
		System.out.println("Life Insurance Matures Collect $100");
		return(oPlayer);
	}
	public Players card3(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()+100);
		System.out.println("Xmas Funds Matures Collect $100");
		return(oPlayer);
	}
	public Players card4(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()+200);
		System.out.println("Bank Error In Your Favor Collect $200");
		return(oPlayer);
	}
	public Players card5(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()+10);
		System.out.println("You Have Won Second Prize In A Beauty Contest Collect $10");
		return(oPlayer);
	}
	public Players card6(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()+20);
		System.out.println("Income Tax Refund Collect $20");
		return(oPlayer);
	}
	public Players card7(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()+25);
		System.out.println("Receive For Services $25");
		return(oPlayer);
	}
	public Players card8(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()+45);
		System.out.println("From Sale of Stock You Get $45");
		return(oPlayer);
	}
	public Players card9(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()-150);
		System.out.println("Pay School Tax of $150");
		return(oPlayer);
	}
	public Players card10(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()-50);
		System.out.println("Doctor's Fee Pay $50");
		return(oPlayer);
	}
	public Players card11(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()-100);
		System.out.println("Pay Hospital $100");
		return(oPlayer);
	}
	public Players card12(Players oPlayer){
		oPlayer.setBoardPosition(0);
		System.out.println("Advance To GO (Collect $200)");
		return(oPlayer);
	}
	public Players card13(Players oPlayer){
		oPlayer.setBoardPosition(30);
		System.out.println("Go To Jail");
		return(oPlayer);
	}

	public Players card14(Players oPlayer,Properties [] aBoard){
		int [] aOwned = oPlayer.getOwnedProperties();
		int iTotalHouses = 0;
		int iTotalHotels = 0;
		int iTotalCharge = 0;
		for(int i = 0; i < aOwned.length; i++){
			int iNumHouses = aBoard[aOwned[i]].getNumHouses();
			if(iNumHouses == 5){
				iTotalHotels++;
			}
			else{
				iTotalHouses += iNumHouses;
			}
		
		}
		iTotalCharge = (40 * iTotalHouses)+(115 * iTotalHotels);
		oPlayer.setMoney(oPlayer.getPlayerMoney()-iTotalCharge);
		System.out.println("You Are Assessed For Street $40 Per House $115 per Hotel");
		return(oPlayer);
	}
	
}
