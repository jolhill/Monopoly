import javax.swing.JOptionPane;

public class Menu {
		public static void QuitPrompt(){ // Will prompt for player to quit Y/N. 
			int choice = JOptionPane.showConfirmDialog(
				    null, "Would you like to quit?",
				    "Quit?",
				    JOptionPane.YES_NO_OPTION);
			if (choice == 0){
				System.exit(0);
			}
			else if (choice == 1){
				return;
			}
			else{
				System.out.println("Error. Incorrect option chosen. Terminating :(");
				System.exit(0);
			}

		}
		
		public static boolean YesNoPrompt(String sMessage){
			int choice = JOptionPane.showConfirmDialog(
				    null, sMessage,
				    "",
				    JOptionPane.YES_NO_OPTION);
			if (choice == 0){
				return true;
			}
			else if (choice == 1){
				return false;
			}
			else{
				QuitPrompt();
				return false;
			}
			
			
//Restart
//prompt user to exit or restart when win condition is met (or if desired during game)
		}
}
