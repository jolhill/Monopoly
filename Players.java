import javax.swing.JOptionPane;

import java.util.ArrayList;

public class Players {

	private String sPlayer;
	private int iPlayerID;
	private int iMoney;
	private int iBoardPosition;
	private boolean [] oPropOwnership = new boolean[40];
	private boolean inJail;
	private int iTimeInJail;

	//Property ownership under each individual property
	
	
	//The void is not in the example in the book, but it was needed to get the IDE to shut up
	public Players(String sPlayer,int iPlayerID)
	{
		//Need to verify inputs to not allow null for player name (pressed cancel)
		setPlayer(sPlayer);
		setMoney(1500);
		setBoardPosition(0);
		setPlayerID(iPlayerID);
		for(int i = 0;i < 40;i++){
			setOwnerShip(i,false);
		inJail = false;
		iTimeInJail = 0;
		}
		
	}
	//Mutators
	public void setPlayer(String player){
		sPlayer = player;
	}
	public void setMoney(int money){
		iMoney = money;
	}
	public void setBoardPosition(int position){
		iBoardPosition = position;
	}
	public void setPlayerID(int ID){
		iPlayerID = ID;
	}
	public void setOwnerShip(int iProp,boolean iStatus){
		oPropOwnership[iProp] = iStatus;
	}
	public void toggleOwnership(int iProp){
		if(oPropOwnership[iProp] == false){
			oPropOwnership[iProp] = true;
		}
		else{
			oPropOwnership[iProp] = false;
		}
	}
	public void toggleJail(){
		if(inJail == false)
			inJail = true;
		else
			inJail = false;
	}
	public boolean getJailStatus(){
		return inJail;
	}
	//Accessors
	public String getPlayerName(){
		return(sPlayer);
	}
	public int getPlayerID(){
		return(iPlayerID);
	}
	public int getPlayerMoney(){
		return(iMoney);
	}
	public int getBoardPosition(){
		return(iBoardPosition);
	}
	public boolean [] getOwnership(){
		return(oPropOwnership);
	}
	public boolean getOwnership(int iProp){
		return(oPropOwnership[iProp]);
	}
	
	public void turnInJail(){
		iTimeInJail++;
		if(iTimeInJail == 3){
			iTimeInJail = 0;
			toggleJail();
		}
	}
	
	public String toString(){
		return(getPlayerName()+" "+getPlayerID()+ " "+ getPlayerMoney()+ " "+getBoardPosition());
	}
	public String statusReport(){
		return("You have $" + getPlayerMoney() + " and are currently on ");
	}
	
	public int [] getOwnedProperties(){
		int iNumOwned = 0;
		for(int i = 0; i < oPropOwnership.length; i++){
			if(oPropOwnership[i]){
				iNumOwned++;
			}
		}
		int [] aOwned = new int[iNumOwned];
		int iIndex = 0;
		for(int i = 0; i < oPropOwnership.length; i++){
			if(oPropOwnership[i]){
				aOwned[iIndex] = i;
				iIndex++;
			}
		}
		return(aOwned);
	}
	public String [] getOwnedPropertiesStrArray(Properties [] aBoard){
		int [] aOwned = getOwnedProperties();
		String [] sOwned = new String[aOwned.length];
		for(int i = 0; i < aOwned.length; i ++){
			sOwned[i] = aBoard[aOwned[i]].getsName();
		}
		return(sOwned);
	}
	public String strArrayToString(String [] array){
		String out = "";
		for(int i = 0; i < array.length - 1; i++){
				out += (array[i] + ",");
		}
		if(array.length == 0){
			out += "No Properties\n";
		}
		else{
			out += (array[array.length-1]+ "\n");
		}
		
		return out;
	}
	public String getStrListOfPropsOwned(Properties [] aBoard){
		String out = (strArrayToString(getOwnedPropertiesStrArray(aBoard)));
		return(out);
	}
	public void moveForward(int iAmount){
		iBoardPosition += iAmount;
		if(iBoardPosition >= 40){
			iBoardPosition -= 40;
			iMoney += 200;
			JOptionPane.showMessageDialog(null,"You passed go and recieved $200!");
		}
	}
	
	public int [] getOwnedSets(Properties [] aBoard){
		int [] aPropsOwned = getOwnedProperties();
		int [] aSetsOwned = {0,0,0,0,0,0,0,0,0,0};
		
		for(int i = 0; i < aPropsOwned.length; i++){
			int iSet = aBoard[aPropsOwned[i]].getiMonopoly();
			aSetsOwned[iSet]++;
		}
		if(aSetsOwned[0] != 2)
			aSetsOwned[0] = 0;
		if(aSetsOwned[1] != 3)
			aSetsOwned[1] = 0;
		if(aSetsOwned[2] != 3)
			aSetsOwned[2] = 0;
		if(aSetsOwned[3] != 3)
			aSetsOwned[3] = 0;
		if(aSetsOwned[4] != 3)
			aSetsOwned[4] = 0;
		if(aSetsOwned[5] != 3)
			aSetsOwned[5] = 0;
		if(aSetsOwned[6] != 3)
			aSetsOwned[6] = 0;
		if(aSetsOwned[7] != 2)
			aSetsOwned[7] = 0;
		if(aSetsOwned[8] != 4)
			aSetsOwned[8] = 0;
		if(aSetsOwned[9] != 2)
			aSetsOwned[9] = 0;
		
		return(aSetsOwned);
	}
	private String [] aPropertySets = {"dark purple","light blue","purple","orange","red","yellow","green","blue","rail-roads","utilities"};
	
	public Properties [] buyHouse(int iHouseCount, int iProp,Properties [] aBoard){
		
		int iNumHouses = aBoard[iProp].getNumHouses();
		if((iNumHouses + iHouseCount) <= 5){
			aBoard[iProp].setNumHouses(iNumHouses + iHouseCount);
			setMoney(getPlayerMoney()-((iNumHouses)*aBoard[iProp].getiHouseCost()));
		}
		//ELSE INPUT VERIFICATION!!!!!!!!!!
		
		return aBoard;
		
	}
	public Properties [] buyHouses(Properties [] aBoard){
		int [] aSetsOwned = getOwnedSets(aBoard);
		boolean bBuy = Menu.YesNoPrompt("Would you like to buy houses?");
		if(bBuy){
			for(int i = 0; i < aSetsOwned.length-2; i++){
				String sOptionMessage = "You can buy houses on the following sets: \n";
				String sOptions = "";
				ArrayList<Integer> aIntOptions = new ArrayList<Integer>(); 
				if(aSetsOwned[i] != 0){
					sOptions += (aPropertySets[i]);
					aIntOptions.add((Integer)i);
				}
				if(sOptions.length()==0){
					sOptions+="no sets";
				}
				sOptionMessage += sOptions;
				JOptionPane.showMessageDialog(null,sOptionMessage);
				for(Integer aSet:aIntOptions){
					boolean bBuyFromSet = Menu.YesNoPrompt("Would you like to buy houses for "+ aPropertySets[aSet.intValue()]);
					if(bBuyFromSet){
						ArrayList<Integer> aIntPropOpts = new ArrayList<Integer>();
						for(int j = 0; j < aBoard.length; j++){
							if(aBoard[j].getiMonopoly()== aSet.intValue()){
								aIntPropOpts.add(j);
							}
						}
						for(Integer iProp:aIntPropOpts){
							boolean bBuyProp = Menu.YesNoPrompt("Would you like to buy houses for "+ aBoard[iProp.intValue()].getsName());
							if(bBuyProp){
								boolean bStarted = false;
								do{
								int iHouseCount = 0;
								Object[] lOptions = {"1","2","3","4","Hotel"};
								String sHouseCount = (String)JOptionPane.showInputDialog(null, "Select Number houses", "Houses", JOptionPane.PLAIN_MESSAGE, null, lOptions, null);
									if (sHouseCount == "Hotel"){
										iHouseCount = 5;
									}
									else if(sHouseCount != null){
									iHouseCount=Integer.parseInt(sHouseCount);
									}
									aBoard = buyHouse(iHouseCount,iProp,aBoard);
									bStarted = true;
								}while(!bStarted);
							}
						}
					}
				}
			}
		}	
		return aBoard;
	}

	
}
