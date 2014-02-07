
class Start {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Main mainView = new Main(); //creates main view
		Results resultsView = new Results(); //creates results view
		MainResultsController theController = new MainResultsController(mainView, resultsView); //creates controller to handle data for main and results
		mainView.setVisible(true);
	}

}
