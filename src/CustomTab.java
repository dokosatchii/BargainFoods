import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class CustomTab extends JPanel {

	private DefaultListModel dlistmodel = new DefaultListModel();
	private JList list = new JList(dlistmodel);
	private JTextArea textArea = new JTextArea(10,20);
	private JScrollPane scroller1 = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JScrollPane scroller2 = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JLabel pic = new JLabel();
	private JButton add = new JButton("Add");
	private JButton back = new JButton("Back");
	
	public CustomTab(){
		
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
		tempPanel.add(add);
		this.add(tempPanel,BorderLayout.SOUTH);
		
		this.add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
	}

	
	public JButton getAddButton(){
		return add;
	}
	
	public JButton getBackButton() {
		return back;
	}
	
	public void addToList(String recipe){
		dlistmodel.addElement(recipe);
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
	
	public void removeData(Boolean yes) {
		if(yes==false){
			list.setVisible(false);
			}
		else 
			list.setVisible(true);
	}

}
