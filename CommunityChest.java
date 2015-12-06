/*takes a number in
 * that number is called for position in an array
 * returns the value stored in that array position
 * use for community chest
 */

import java.util.Random;
import javax.swing.JOptionPane;
	
public class CommunityChest {
	private static Random oRandom = new Random();
	
	public static Players [] card(Players [] aPlayers, int iPlayersID, Properties [] aBoard){
		
		int iCard = (oRandom.nextInt(14) + 1);
		iPlayersID -= 1;
		if(iCard == 1)
			aPlayers[iPlayersID] = card1(aPlayers[iPlayersID]);
		else if(iCard == 2)
			aPlayers[iPlayersID] = card2(aPlayers[iPlayersID]);
		else if(iCard == 3)
			aPlayers[iPlayersID] = card3(aPlayers[iPlayersID]);
		else if(iCard == 4)
			aPlayers[iPlayersID] = card4(aPlayers[iPlayersID]);
		else if(iCard == 5)
			aPlayers[iPlayersID] = card5(aPlayers[iPlayersID]);
		else if(iCard == 6)
			aPlayers[iPlayersID] = card6(aPlayers[iPlayersID]);
		else if(iCard == 7)
			aPlayers[iPlayersID] = card7(aPlayers[iPlayersID]);
		else if(iCard == 8)
			aPlayers[iPlayersID] = card8(aPlayers[iPlayersID]);
		else if(iCard == 9)
			aPlayers[iPlayersID] = card9(aPlayers[iPlayersID]);
		else if(iCard == 10)
			aPlayers[iPlayersID] = card10(aPlayers[iPlayersID]);
		else if(iCard == 11)
			aPlayers[iPlayersID] = card11(aPlayers[iPlayersID]);
		else if(iCard == 12)
			aPlayers[iPlayersID] = card12(aPlayers[iPlayersID]);
		else if(iCard == 13)
			aPlayers[iPlayersID] = card13(aPlayers[iPlayersID]);
		else
			aPlayers[iPlayersID] = card14(aPlayers[iPlayersID],aBoard);
		
		
		return aPlayers;
	}
	
	private static Players card1(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()+100);
		JOptionPane.showMessageDialog(null,"Inherit $100");
		return(oPlayer);
	}
	private static Players card2(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()+100);
		JOptionPane.showMessageDialog(null,"Life Insurance Matures Collect $100");
		return(oPlayer);
	}
	private static Players card3(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()+100);
		JOptionPane.showMessageDialog(null,"Xmas Funds Matures Collect $100");
		return(oPlayer);
	}
	private static Players card4(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()+200);
		JOptionPane.showMessageDialog(null,"Bank Error In Your Favor Collect $200");
		return(oPlayer);
	}
	private static Players card5(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()+10);
		JOptionPane.showMessageDialog(null,"You Have Won Second Prize In A Beauty Contest Collect $10");
		return(oPlayer);
	}
	private static Players card6(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()+20);
		JOptionPane.showMessageDialog(null,"Income Tax Refund Collect $20");
		return(oPlayer);
	}
	private static Players card7(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()+25);
		JOptionPane.showMessageDialog(null,"Receive For Services $25");
		return(oPlayer);
	}
	private static Players card8(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()+45);
		JOptionPane.showMessageDialog(null,"From Sale of Stock You Get $45");
		return(oPlayer);
	}
	private static Players card9(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()-150);
		JOptionPane.showMessageDialog(null,"Pay School Tax of $150");
		return(oPlayer);
	}
	private static Players card10(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()-50);
		JOptionPane.showMessageDialog(null,"Doctor's Fee Pay $50");
		return(oPlayer);
	}
	private static Players card11(Players oPlayer){
		oPlayer.setMoney(oPlayer.getPlayerMoney()-100);
		JOptionPane.showMessageDialog(null,"Pay Hospital $100");
		return(oPlayer);
	}
	private static Players card12(Players oPlayer){
		oPlayer.setBoardPosition(0);
		oPlayer.setMoney(oPlayer.getPlayerMoney()+200);
		JOptionPane.showMessageDialog(null,"Advance To GO (Collect $200)");
		return(oPlayer);
	}
	private static Players card13(Players oPlayer){
		oPlayer.setBoardPosition(30);
		JOptionPane.showMessageDialog(null,"Go To Jail");
		return(oPlayer);
	}

	private static Players card14(Players oPlayer,Properties [] aBoard){
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
		JOptionPane.showMessageDialog(null,"You Are Assessed For Street $40 Per House $115 per Hotel");
		return(oPlayer);
	}
	
}
