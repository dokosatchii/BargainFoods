import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class MainResultsController {
//Mediates between views and models
	private Main mainView;
	private Results resultsView;
	private HibernateConnect db = new HibernateConnect();

	public MainResultsController(Main mainView, Results resultsView) {
		this.mainView = mainView;
		this.resultsView = resultsView;
		this.mainView.submitListner(new SubmitListener());
		this.resultsView.backListner(new BackListener());
		this.resultsView.listSelectionListener(new ListListener());
		this.resultsView.addListner(new AddListener());
		this.resultsView.removeListener(new RemoveListener());
			
	}//End of Constructor

//Populates the Jlist with recipe names	
public void createLists() {
	ListIterator<Breakfast> counterb = db.getBreakfastRecipes().listIterator();
	while(counterb.hasNext()){
		resultsView.addToListB(counterb.next().getRecipeName());
	}
	ListIterator<Lunch> counterl = db.getLunchRecipes().listIterator();
	while(counterl.hasNext()){
		resultsView.addToListL(counterl.next().getRecipeName());
	}
	ListIterator<Dinner> counterd = db.getDinnerRecipes().listIterator();
	while(counterd.hasNext()){
		resultsView.addToListD(counterd.next().getRecipeName());
	}
}

class SubmitListener implements ActionListener{
		//Creates the lists for the next frame, removes deselected panels, moves on to results
		public void actionPerformed(ActionEvent e) {
			//Double amount=0.0;
			//int time=0;
			
			try {
				//amount = mainView.getAmount();
				//time = mainView.getTime();
				createLists();
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
		//Goes back to initial page
		public void actionPerformed(ActionEvent e) {
				
				resultsView.setVisible(false);
				resultsView.clearList();
				mainView.setVisible(true);
				
		}
	}

class AddListener implements ActionListener{
	//Goes back to initial page
	public void actionPerformed(ActionEvent e) {
		
		if(resultsView.getSelectedTab()==0 && !resultsView.editList().listContent(resultsView.getSelectedItem(0))){	
		resultsView.editList().addToList(resultsView.getSelectedItem(0));
		}
		else if(resultsView.getSelectedTab()==1 && !resultsView.editList().listContent(resultsView.getSelectedItem(1))){	
			resultsView.editList().addToList(resultsView.getSelectedItem(1));
			}
		else if(resultsView.getSelectedTab()==2 && !resultsView.editList().listContent(resultsView.getSelectedItem(2))){
			resultsView.editList().addToList(resultsView.getSelectedItem(2));
		}
		else JOptionPane.showMessageDialog(resultsView,"Already in the list!");
	}
}

class RemoveListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		resultsView.editList().removeFromList(resultsView.editList().getSelectedPosition());
		resultsView.editList().clearList();
	}
}

class ListListener implements MouseListener {
	//Displays object details when selected from JList
	public void mouseClicked(MouseEvent arg0) {
		if(resultsView.getSelectedTab()==0){
			for(Breakfast item: db.getBreakfastRecipes()){
				if(item.getRecipeName()==resultsView.getSelectedItem(0)){
					//display on panel
					String information = (item.getRecipeName() +"\n"+ item.getIngredients() + "\n"+item.getCost() +"\n"+ item.getPic());
					resultsView.setImage(0, getImage(item.getPic()));
					resultsView.setTextArea(0, information);
				}
			}
		}
		else if(resultsView.getSelectedTab()==1){
			for(Lunch item: db.getLunchRecipes()){
				if(item.getRecipeName()==resultsView.getSelectedItem(1)){
					//display on panel
					String information = (item.getRecipeName() +"\n"+ item.getIngredients() + "\n"+item.getCost() +"\n"+ item.getPic());
					resultsView.setImage(1, getImage(item.getPic()));
					resultsView.setTextArea(1, information);
				}
			}
		}
		else if(resultsView.getSelectedTab()==2) {
			for(Dinner item: db.getDinnerRecipes()){
				if(item.getRecipeName()==resultsView.getSelectedItem(2)){
					//display on panel
					String information = (item.getRecipeName() +"\n"+ item.getIngredients() + "\n"+item.getCost() +"\n"+ item.getPic());
					resultsView.setImage(2, getImage(item.getPic()));
					resultsView.setTextArea(2, information);
				}
			}
		}
		else {
			List<Object> templist = new ArrayList<Object>();
			templist.addAll(db.getBreakfastRecipes());
			templist.addAll(db.getLunchRecipes());
			templist.addAll(db.getDinnerRecipes());
			ListIterator<Object> counter = templist.listIterator();
			while(counter.hasNext()){
				Object temp = counter.next();
				if(temp.getClass().getName()=="Breakfast"){
				//display on panel
					  Breakfast temp1 = (Breakfast) temp;
					  if(((Breakfast) temp).getRecipeName()==resultsView.editList().getSelectedItem()){
					String information = ( temp1.getRecipeName() +"\n"+ temp1.getIngredients() + "\n"+temp1.getCost() +"\n"+ temp1.getPic());
					resultsView.editList().setImage(getImage(temp1.getPic()));
					resultsView.editList().setTextArea(information);
					  }
				  }
				  else if(temp.getClass().getName()=="Lunch"){
				//display on panel
					  Lunch temp1 = (Lunch) temp;
					  if(((Lunch) temp).getRecipeName()==resultsView.editList().getSelectedItem()){
					String information = ( temp1.getRecipeName() +"\n"+ temp1.getIngredients() + "\n"+temp1.getCost() +"\n"+ temp1.getPic());
					resultsView.editList().setImage(getImage(temp1.getPic()));
					resultsView.editList().setTextArea(information);
					  }
				  }
				  else if(temp.getClass().getName()=="Dinner"){
				//display on panel
					  Dinner temp1 = (Dinner) temp;
					  if(((Dinner) temp).getRecipeName()==resultsView.editList().getSelectedItem()){
					String information = ( temp1.getRecipeName() +"\n"+ temp1.getIngredients() + "\n"+temp1.getCost() +"\n"+ temp1.getPic());
					resultsView.editList().setImage(getImage(temp1.getPic()));
					resultsView.editList().setTextArea(information);
					  }
				  }
				}
			}
			
		}


	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}


public Image getImage(String link) { //grabs image from web site using the link

Image image = null;
File temp = new File("/Users/dokosatchii/Desktop/image003.jpg");
try {
	image = ImageIO.read(temp);
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
finally{
try{
	URL url = new URL(link);
	Image tempimage = ImageIO.read(url);
	image = tempimage;
}
catch(Exception e){
	
	}
}
return image;
}

}//End of code
