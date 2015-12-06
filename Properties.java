public class Properties {
	
	private int iSpace;
	private String sName;
	private int iCost;
	private int iRent;
	private int iOneHouse;
	private int iTwoHouse;
	private int iThreeHouse;
	private int iFourHouse;
	private int iHotel;
	private int iMortgage;
	private int iHouseCost;
	private int iHotelCost;
	private int iMonopoly;
	private int iNumHouses;
	private boolean isBuyable;

	public Properties()
	{	
		iSpace = 0;
		sName = "";
		iCost = 0;
		iRent = 0;
		iOneHouse = 0;
		iTwoHouse = 0;
		iThreeHouse = 0;
		iFourHouse = 0;
		iHotel = 0;
		iMortgage = 0;
		iHouseCost = 0;
		iHotelCost = 0;
		iMonopoly = 0;
		iNumHouses = 0;
		isBuyable = false;
	}
	
	public Properties(int iSpace, String sName, int iCost, int iRent, int iOneHouse, 
			int iTwoHouse, int iThreeHouse, int iFourHouse, int iHotel, int iMortgage, 
			int iHouseCost, int iHotelCost, int iMonopoly,boolean isBuyable)
	{
		this.iSpace = iSpace;
		this.sName = sName;
		this.iCost = iCost;
		this.iRent = iRent;
		this.iOneHouse = iOneHouse;
		this.iTwoHouse = iTwoHouse;
		this.iThreeHouse = iThreeHouse;
		this.iFourHouse = iFourHouse;
		this.iHotel = iHotel;
		this.iMortgage = iMortgage;
		this.iHouseCost = iHouseCost;
		this.iHotelCost = iHotelCost;
		this.iMonopoly = iMonopoly;
		iNumHouses = 0;
		this.isBuyable = isBuyable;
	
	}
	public void setiSpace(int iSpace)
	{
		this.iSpace = iSpace;
	}
	
	public int getiSpace()
	{
		return iSpace;
	}
	public boolean isBuyable(){
		return isBuyable;
	}
	
	public void setsName(String sName)
	{
		this.sName = sName;
	}
	
	public String getsName()
	{
		return sName;
	}
	
	public void setiCost(int iCost)
	{
		this.iCost = iCost;
	}
	
	public int getiCost()
	{
		return iCost;
	}
	
	public void setRent(int iRent)
	{
		this.iRent = iRent;
	}
	
	public int getiRent()
	{
		return iRent;
	}
	
	public void setiOneHouse(int iOneHouse)
	{
		this.iOneHouse = iOneHouse;
	}
	
	public int getiOneHouse()
	{
		return iOneHouse;
	}
	
	public void setiTwoHouse(int iTwoHouse)
	{
		this.iTwoHouse = iTwoHouse;
	}
	
	public int getiTwoHouse()
	{
		return iTwoHouse;
	}
	
	public void setiThreeHouse(int iThreeHouse)
	{
		this.iThreeHouse = iThreeHouse;
	}
	
	public int getiThreeHouse()
	{
		return iThreeHouse;
	}
	
	public void setiFourHouse(int iFourHouse)
	{
		this.iFourHouse = iFourHouse;
	}
	
	public int getiFourHouse()
	{
		return iFourHouse;
	}
	
	public void setiHotel(int iHotel)
	{
		this.iHotel = iHotel;
	}
	
	public int getiHotel()
	{
		return iHotel;
	}
	
	public void setiMortgage(int iMortgage)
	{
		this.iMortgage = iMortgage;
	}
	
	public int getiMortgage()
	{
		return iMortgage;
	}
	
	public void setiHouseCost(int iHouseCost)
	{
		this.iHouseCost = iHouseCost;
	}
	
	public int getiHouseCost()
	{
		return iHouseCost;
	}
	
	public void setiHotelCost(int iHotelCost)
	{
		this.iHotelCost = iHotelCost;
	}
	
	public int getiHotelCost()
	{
		return iHotelCost;
	}
	public void setiMonopoly(int iMonopoly)
	{
		this.iMonopoly = iMonopoly;
	}
	
	public int getiMonopoly()
	{
		return iMonopoly;
	}
	public int getNumHouses(){
		return iNumHouses;
	}
	public void setNumHouses(int iNum){
		if (iNum<=5){
			iNumHouses=iNum;
		}
	}
	public void addHouse(){
		setNumHouses(getNumHouses()+1);
	}
}
