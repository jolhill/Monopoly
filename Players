
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
		}
	}

}
