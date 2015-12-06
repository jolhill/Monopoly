/*Random class
 * 
 */
 import javax.swing.JOptionPane;
import java.util.Random; 
public class Randoms {
	public static int [] RandomDice(){
		Random oRandNbr = new Random();
		int iDie1 = oRandNbr.nextInt(6)+1;
		int iDie2 = oRandNbr.nextInt(6)+1;
		int iMove = iDie1 + iDie2;
		JOptionPane.showMessageDialog(null,("You rolled a "+iDie1+" and a "+ iDie2+ " and moved " + iMove + " spaces"));
		if (iDie1 == 1 && iDie2 == 1){
			JOptionPane.showMessageDialog(null,"Snake Eyes");
		}
		//roll again
		int [] aOut = {iDie1,iDie2,iMove}; // array[0..1] ==  each die and array[2] == move amount
		return aOut;
	}
}
