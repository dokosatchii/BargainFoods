import javax.swing.*;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;


@SuppressWarnings("serial")
public class Results extends JFrame{
	
	private JTabbedPane tabbedPane = new JTabbedPane();
	private CustomTab breakfast = new CustomTab();
	private CustomTab lunch = new CustomTab();
	private CustomTab dinner = new CustomTab();
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
	
		tabbedPane.add("Breakfast", breakfast);
		tabbedPane.add("Lunch", lunch);
		tabbedPane.add("Dinner", dinner);
		tabbedPane.add("My List", myList);
		
		this.add(tabbedPane);
			
	}//End of Constructor

//get Methods
public void clearList(){
	breakfast.clearList();
	lunch.clearList();
	dinner.clearList();
	myList.clearList();
	
}

public int getSelectedTab(){
	return tabbedPane.getSelectedIndex();
}

public String getSelectedItem(int tab){
	if(tab == 0){
		return breakfast.getSelectedItem();
	}
	else if(tab ==1){
		return lunch.getSelectedItem();
	}
	else{
		return dinner.getSelectedItem();
	}
}
public MyList editList(){
	return myList;
}
//set Methods
public void setTextArea(int tab,String information){
	if(tab == 0){
		breakfast.setTextArea(information);
	}
	else if(tab ==1){
		lunch.setTextArea(information);
	}
	else{
		dinner.setTextArea(information);
	}
}

public void addToListB(String recipe){
	breakfast.addToList(recipe);
}
public void addToListL(String recipe){
	lunch.addToList(recipe);
}
public void addToListD(String recipe){
	dinner.addToList(recipe);
}


public void removeLists(boolean breakfast, boolean lunch, boolean dinner) {
	this.breakfast.removeData(breakfast);
	this.lunch.removeData(lunch);
	this.dinner.removeData(dinner);
}

//Listeners
public void backListner(ActionListener listenForBackButton){
	breakfast.getBackButton().addActionListener(listenForBackButton);
	lunch.getBackButton().addActionListener(listenForBackButton);
	dinner.getBackButton().addActionListener(listenForBackButton);
	myList.getBackButton().addActionListener(listenForBackButton);
}	

public void removeListener(ActionListener listenForRemoveButton){
	myList.getRemoveButton().addActionListener(listenForRemoveButton);
}

public void addListner(ActionListener listenForAddButton){
	breakfast.getAddButton().addActionListener(listenForAddButton);
	lunch.getAddButton().addActionListener(listenForAddButton);
	dinner.getAddButton().addActionListener(listenForAddButton);
}	

public void listSelectionListener(MouseListener listenforlistselection) {
	breakfast.getList().addMouseListener(listenforlistselection);
	lunch.getList().addMouseListener(listenforlistselection);
	dinner.getList().addMouseListener(listenforlistselection);
	myList.getList().addMouseListener(listenforlistselection);
	
}

public void setImage(int tab, Image pic){
	if(tab == 0){
		breakfast.setImage(pic);
	}
	else if(tab ==1){
		lunch.setImage(pic);
	}
	else if(tab == 2){
		dinner.setImage(pic);
	}
	else {
		myList.setImage(pic);
	}
}

} //End of code
