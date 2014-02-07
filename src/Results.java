import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;


@SuppressWarnings("serial")
public class Results extends JFrame{
	
	private DefaultListModel dlistmodelb = new DefaultListModel();
	private DefaultListModel dlistmodell = new DefaultListModel();
	private DefaultListModel dlistmodeld = new DefaultListModel();
	private JList breakfastList = new JList(dlistmodelb);
	private JList lunchList = new JList(dlistmodell);
	private JList dinnerList = new JList(dlistmodeld);
	private JTextArea textArea1 = new JTextArea(10,20);
	private JTextArea textArea2 = new JTextArea(10,20);
	private JTextArea textArea3 = new JTextArea(10,20);
	private JScrollPane scroller1 = new JScrollPane(breakfastList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JScrollPane scroller2 = new JScrollPane(lunchList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JScrollPane scroller3 = new JScrollPane(dinnerList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JScrollPane scroller4 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JScrollPane scroller5 = new JScrollPane(textArea2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JScrollPane scroller6 = new JScrollPane(textArea3, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JButton back1 = new JButton("Back");
	private JButton back2 = new JButton("Back");
	private JButton back3 = new JButton("Back");
	private JTabbedPane tabbedPane = new JTabbedPane();
	private JPanel breakfastPanel = new JPanel();
	private JPanel lunchPanel = new JPanel(); 
	private JPanel dinnerPanel = new JPanel();
	private JLabel breakfastPic = new JLabel();
	private JLabel lunchPic = new JLabel();
	private JLabel dinnerPic = new JLabel();
	private JButton add1 = new JButton("Add");
	private JButton add2 = new JButton("Add");
	private JButton add3 = new JButton("Add");
	private MyList myList = new MyList();
	
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
		
		//Set Layout for Panels
		breakfastPanel.setLayout(new BorderLayout());
		
		
		
		//Populate Panels
		textArea1.setLineWrap(true);
		breakfastList.setVisibleRowCount(4);
		breakfastPanel.add(scroller1, BorderLayout.NORTH);
		breakfastPanel.add(breakfastPic, BorderLayout.CENTER);
		breakfastPic.setHorizontalAlignment(JLabel.CENTER);
		breakfastPic.setVerticalAlignment(JLabel.CENTER);
		JPanel tempBPanel = new JPanel();
		tempBPanel.add(scroller4);
		tempBPanel.add(back1);
		tempBPanel.add(add1);
		breakfastPanel.add(tempBPanel,BorderLayout.SOUTH);
		
		textArea2.setLineWrap(true);
		lunchList.setVisibleRowCount(4);
		lunchPanel.add(scroller2, BorderLayout.NORTH);
		lunchPanel.add(lunchPic, BorderLayout.CENTER);
		lunchPic.setHorizontalAlignment(JLabel.CENTER);
		lunchPic.setVerticalAlignment(JLabel.CENTER);
		JPanel tempLPanel = new JPanel();
		tempLPanel.add(scroller5);
		tempLPanel.add(back2);
		tempLPanel.add(add2);
		lunchPanel.add(tempLPanel,BorderLayout.SOUTH);
		
		textArea3.setLineWrap(true);
		dinnerList.setVisibleRowCount(4);
		dinnerPanel.add(scroller3, BorderLayout.NORTH);
		dinnerPanel.add(dinnerPic, BorderLayout.CENTER);
		lunchPic.setHorizontalAlignment(JLabel.CENTER);
		lunchPic.setVerticalAlignment(JLabel.CENTER);
		JPanel tempDPanel = new JPanel();
		tempDPanel.add(scroller6);
		tempDPanel.add(back3);
		tempDPanel.add(add3);
		dinnerPanel.add(tempDPanel,BorderLayout.SOUTH);
		
		//Tab Pane properties
		tabbedPane.add("Breakfast", breakfastPanel);
		tabbedPane.add("Lunch", lunchPanel);
		tabbedPane.add("Dinner", dinnerPanel);
		tabbedPane.add("My List", myList);
		
		this.add(tabbedPane);
			
	}//End of Constructor

//get Methods
public void clearList(){
	dlistmodelb.clear();
	dlistmodell.clear();
	dlistmodeld.clear();
	textArea1.setText("");
	textArea2.setText("");
	textArea3.setText("");
	breakfastPic.setIcon(null);
	lunchPic.setIcon(null);
	dinnerPic.setIcon(null);
	myList.clearList();
	
}

public int getSelectedTab(){
	return tabbedPane.getSelectedIndex();
}

public String getSelectedItem(int tab){
	if(tab == 0){
		return breakfastList.getSelectedValue().toString();
	}
	else if(tab ==1){
		return lunchList.getSelectedValue().toString();
	}
	else{
		return dinnerList.getSelectedValue().toString();
	}
}
public MyList editList(){
	return myList;
}
//set Methods
public void setTextArea(int tab,String information){
	if(tab == 0){
		textArea1.setText(information);
	}
	else if(tab ==1){
		textArea2.setText(information);
	}
	else{
		textArea3.setText(information);
	}
}

public void addToListB(String recipe){
	dlistmodelb.addElement(recipe);
}
public void addToListL(String recipe){
	dlistmodell.addElement(recipe);
}
public void addToListD(String recipe){
	dlistmodeld.addElement(recipe);
}


public void removeLists(boolean breakfast, boolean lunch, boolean dinner) {
	if(!breakfast) {
		breakfastList.setVisible(false);
		}
	else {
		breakfastList.setVisible(true);
	}
	if(!lunch) {
		lunchList.setVisible(false);
		}
	else {
		lunchList.setVisible(true);
	}
	if(!dinner) {
		dinnerList.setVisible(false);
		}
	else {
		dinnerList.setVisible(true);
	}
}

//Listeners
public void backListner(ActionListener listenForBackButton){
	back1.addActionListener(listenForBackButton);
	back2.addActionListener(listenForBackButton);
	back3.addActionListener(listenForBackButton);
	editList().getBackButton().addActionListener(listenForBackButton);
}	

public void removeListener(ActionListener listenForRemoveButton){
	editList().getRemoveButton().addActionListener(listenForRemoveButton);
}

public void addListner(ActionListener listenForAddButton){
	add1.addActionListener(listenForAddButton);
	add2.addActionListener(listenForAddButton);
	add3.addActionListener(listenForAddButton);
}	

public void listSelectionListener(MouseListener listenforlistselection) {
	breakfastList.addMouseListener(listenforlistselection);
	lunchList.addMouseListener(listenforlistselection);
	dinnerList.addMouseListener(listenforlistselection);
	editList().getList().addMouseListener(listenforlistselection);
}

public void setImage(int tab, Image pic){
	if(tab == 0){
		breakfastPic.setIcon(new ImageIcon(pic)); 
		super.validate();
	}
	else if(tab ==1){
		lunchPic.setIcon(new ImageIcon(pic));
		super.validate();
	}
	else if(tab == 2){
		dinnerPic.setIcon(new ImageIcon(pic));
		super.validate();
	}
	else {
		myList.setImage(pic);
	}
}



} //End of code
