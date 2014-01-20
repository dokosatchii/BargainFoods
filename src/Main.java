import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private JLabel amount = new JLabel("Enter how much money you want to spend on Groceries");
	private JTextField textField1 = new JTextField("$", 5);
	private JLabel timeFrame = new JLabel("How long do you want these groceries to last? (in weeks)");
	private SpinnerNumberModel spinnerFormat = new SpinnerNumberModel(1,1,4,1);
	private JSpinner spinner1 = new JSpinner(spinnerFormat);
	private JCheckBox breakfast = new JCheckBox("Breakfast");
	private JCheckBox lunch = new JCheckBox("Lunch");
	private JCheckBox dinner = new JCheckBox("Dinner");
	private JButton submit = new JButton("Submit");
	
	
	public Main() {
		
		//Setting screen size and location on screen
		this.setSize(400,400);
		Dimension screeninfo = new Dimension();
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		screeninfo = tk.getScreenSize();
		int xPos = screeninfo.width;
		int yPos = screeninfo.height;
		
		
		this.setLocation((xPos/2)-(this.getWidth()/2), (yPos/2)-(this.getHeight()/2));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Bargain Foods");
		this.setResizable(false);
		
		//Adding buttons components to panels
		
		JPanel mainView = new JPanel();
		mainView.add(amount);
		mainView.add(textField1);
		mainView.add(timeFrame);
		mainView.add(spinner1);
		mainView.add(breakfast);
		mainView.add(lunch);
		mainView.add(dinner);
		mainView.add(submit);
		
		//Adding panels to frame
		this.add(mainView);
		
	}//End of Constructor

//Methods	
public double getAmount() {
	return Double.parseDouble(textField1.getText());
}

public int getTime() {
	return (Integer) spinner1.getValue();
}

public boolean breakfastChecked(){
	if(breakfast.isSelected()){
		return true;
	}
	else return false;
}

public boolean lunchedChecked(){
	if(lunch.isSelected()){
		return true;
	}
	else return false;
}

public boolean dinnerChecked(){
	if(dinner.isSelected()){
		return true;
	}
	else return false;
}


//ActionListeners and Error messages
void submitListner(ActionListener listenForSubmitButton){
	submit.addActionListener(listenForSubmitButton);
}

void displayErrorMessage(String errorMessage){
	JOptionPane.showMessageDialog(this, errorMessage);
}


}//End of Code
