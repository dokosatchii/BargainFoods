import java.awt.BorderLayout;
import java.awt.Image;



import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class MyList extends JPanel { //Created a separate class in case I wanted to add extended functionality to this view
	
	private DefaultListModel dlistmodel = new DefaultListModel();
	private JList list = new JList(dlistmodel);
	private JTextArea textArea = new JTextArea(10,20);
	private JScrollPane scroller1 = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JScrollPane scroller2 = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JLabel pic = new JLabel();
	private JButton remove = new JButton("Remove");
	private JButton back = new JButton("Back");
	
	public MyList(){
		
		this.setLayout(new BorderLayout());
		textArea.setLineWrap(true);
		list.setVisibleRowCount(4);
		this.add(scroller1, BorderLayout.NORTH);
		this.add(pic, BorderLayout.CENTER);
		pic.setHorizontalAlignment(JLabel.CENTER);
		pic.setVerticalAlignment(JLabel.CENTER);
		JPanel tempPanel = new JPanel();
		tempPanel.add(scroller2);
		tempPanel.add(back);
		tempPanel.add(remove);
		this.add(tempPanel,BorderLayout.SOUTH);
	}
	
	public void addToList(String recipe){
		dlistmodel.addElement(recipe);
	}

	public JButton getBackButton(){
		return back;
	}
	public JButton getRemoveButton(){
		return remove;
	}
	
	public String getSelectedItem(){
		return list.getSelectedValue().toString();
	}
	
	public void setImage(Image picture){
			pic.setIcon(new ImageIcon(picture)); 
			super.validate();
	}
	public void setTextArea(String information){
			textArea.setText(information);
		}
	public void clearList(){
		textArea.setText("");
		pic.setIcon(null);
	}
	public JList getList(){
		return list;
	}
	public int getSelectedPosition(){
		return list.getSelectedIndex();
	}
	public void removeFromList(int i){
		dlistmodel.removeElementAt(i);
	}
	public boolean listContent(String i){
		if (dlistmodel.isEmpty())
		return false;
		else if(dlistmodel.contains(i))
			return true;
		else
			return false;
	}
}//End of Code
