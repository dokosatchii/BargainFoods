import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class Results extends JFrame{
	
	private DefaultListModel dlistmodelb = new DefaultListModel();
	private DefaultListModel dlistmodell = new DefaultListModel();
	private DefaultListModel dlistmodeld = new DefaultListModel();
	private JList breakfastList = new JList(dlistmodelb);
	private JList lunchList = new JList(dlistmodell);
	private JList dinnerList = new JList(dlistmodeld);
	private JScrollPane scroller1 = new JScrollPane(breakfastList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JScrollPane scroller2 = new JScrollPane(lunchList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JScrollPane scroller3 = new JScrollPane(dinnerList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JButton back1 = new JButton("Back");
	private JButton back2 = new JButton("Back");
	private JButton back3 = new JButton("Back");
	private JTabbedPane tabbedPane = new JTabbedPane();
	
	
	public Results() {
		
		Toolkit screen = Toolkit.getDefaultToolkit();
		Dimension d = new Dimension();
		this.setSize(500,500);

		d = screen.getScreenSize();
		int xPos = (d.width/2)-(this.getWidth()/2);
		int yPos = (d.height/2)-(this.getHeight()/2);

		this.setLocation(xPos, yPos);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Bargain Foods");
		this.setResizable(false);
		
		//Create Panels
		JPanel breakfastPanel = new JPanel();
		breakfastList.setVisibleRowCount(4);
		breakfastPanel.add(scroller1);
		breakfastPanel.add(back1);
		
		JPanel lunchPanel = new JPanel();
		lunchList.setVisibleRowCount(4);
		lunchPanel.add(scroller2);
		lunchPanel.add(back2);
		
		JPanel dinnerPanel = new JPanel();
		dinnerList.setVisibleRowCount(4);
		dinnerPanel.add(scroller3);
		dinnerPanel.add(back3);
		
		//Tab Pane properties
		tabbedPane.add("Breakfast", breakfastPanel);
		tabbedPane.add("Lunch", lunchPanel);
		tabbedPane.add("Dinner", dinnerPanel);
		
		this.add(tabbedPane);
			
	}//End of Constructor

//Methods
public void addToListB(DatabaseConnect database){
	for(String recipe: database.breakfastArrayItems()){
		dlistmodelb.addElement(recipe);
	}
}

public void addToListL(DatabaseConnect database){
		for(String recipe: database.lunchArrayItems()){
			dlistmodell.addElement(recipe);
		}
}

public void addToListD(DatabaseConnect database){
			for(String recipe: database.dinnerArrayItems()){
				dlistmodeld.addElement(recipe);
			}
}

public void removeLists(boolean breakfast, boolean lunch, boolean dinner) {
	if(!breakfast) {
		scroller1.setVisible(false);
		}
	else {
		scroller1.setVisible(true);
	}
	if(!lunch) {
		scroller2.setVisible(false);
		}
	else {
		scroller2.setVisible(true);
	}
	if(!dinner) {
		scroller3.setVisible(false);
		}
	else {
		scroller3.setVisible(true);
	}
}

public void clearList(){
	dlistmodelb.clear();
	dlistmodell.clear();
	dlistmodeld.clear();

}
public void backListner(ActionListener listenForBackButton){
	back1.addActionListener(listenForBackButton);
	back2.addActionListener(listenForBackButton);
	back3.addActionListener(listenForBackButton);
}	
	
} //End of code
