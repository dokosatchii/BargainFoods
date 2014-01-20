
class Start {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Main mainView = new Main();
		Results resultsView = new Results();
		MainResultsController theController = new MainResultsController(mainView, resultsView);
		mainView.setVisible(true);
	}

}
