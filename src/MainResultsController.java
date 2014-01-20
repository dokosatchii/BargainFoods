import java.awt.event.*;

public class MainResultsController {

	private Main mainView;
	private Results resultsView;
	private DatabaseConnect db = new DatabaseConnect();

	public MainResultsController(Main mainView, Results resultsView) {
		this.mainView = mainView;
		this.resultsView = resultsView;
		this.mainView.submitListner(new SubmitListener());
		this.resultsView.backListner(new BackListener());
			
	}//End of Constructor
	
	class SubmitListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			//Double amount=0.0;
			//int time=0;
			
			
			try {
				//amount = mainView.getAmount();
				//time = mainView.getTime();
				resultsView.addToListB(db);
				resultsView.addToListL(db);
				resultsView.addToListD(db);
				
				resultsView.removeLists(mainView.breakfastChecked(), mainView.lunchedChecked(), mainView.dinnerChecked());
				mainView.setVisible(false);
				resultsView.setVisible(true);	
			}
			catch(NumberFormatException ex){
				mainView.displayErrorMessage("Type in a number please");
			}
			
		}
		
	}//End of class
class BackListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
				
				resultsView.setVisible(false);
				resultsView.clearList();
				mainView.setVisible(true);
				
		}
		
	}//End of class

}//End of code
