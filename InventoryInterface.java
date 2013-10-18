import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
public class InventoryInterface implements ItemListener{
	
	Inventory inventory = new Inventory();
	JPanel cards;
	JButton add = new JButton("ADD");
	JButton remove = new JButton("REMOVE");
	JButton edit = new JButton("EDIT");
	JButton find = new JButton("FIND");
	JButton findMax = new JButton("FINDMAX");
	JButton display = new JButton("DISPLAY");
	
	JTextField five1 = new JTextField(5);
	JTextField five2 = new JTextField(5);
	JTextField ten1 = new JTextField(10);
	JTextField ten2 = new JTextField(10);
	JTextField count1 = new JTextField(5);
	JTextField count2 = new JTextField(5);
	public InventoryInterface() {
		
		JFrame frame = new JFrame("Inventory");
		
		final String ADD = "Add Item";
		final String REMOVE = "Remove Item";
		final String EDIT = "Edit Item";
		final String FIND = "Find Item";
		final String FINDMAX = "Find Max";
		final String DISPLAY = "Display";
		
		JPanel card1 = new JPanel();
		card1.add(new JLabel("ID: "));
		card1.add(five1);
		card1.add(new JLabel("Count: "));
		card1.add(count1);
		card1.add(add);
		
		JPanel card2 = new JPanel();
		card2.add(new JLabel("ID: "));
		card2.add(ten1);
		card2.add(remove);
		
		JPanel card3 = new JPanel();
		card3.add(new JLabel("ID: "));
		card3.add(five2);
		card3.add(new JLabel("Count: "));
		card3.add(count2);
		card3.add(edit);
		
		JPanel card4 = new JPanel();
		card4.add(new JLabel("ID: "));
		card4.add(ten2);
		card4.add(find);
		
		JPanel card5 = new JPanel();
		card5.add(findMax);
		
		JPanel card6 = new JPanel();
		card6.add(display);
		
		cards = new JPanel(new CardLayout());
		cards.add(card1, ADD);
		cards.add(card2, REMOVE);
		cards.add(card3, EDIT);
		cards.add(card4, FIND);
		cards.add(card5, FINDMAX);
		cards.add(card6, DISPLAY);
		
		JPanel comboBoxPane = new JPanel();
		String comboBoxItems[] = {ADD, REMOVE, EDIT, FIND, FINDMAX, DISPLAY};
		JComboBox cb = new JComboBox(comboBoxItems);
		
		cb.setEditable(false);
		cb.addItemListener(this);
		add.addActionListener(new MyActionListener());
		remove.addActionListener(new MyActionListener());
		edit.addActionListener(new MyActionListener());
		find.addActionListener(new MyActionListener());
		findMax.addActionListener(new MyActionListener());
		display.addActionListener(new MyActionListener());
		
		comboBoxPane.add(cb);
		
		frame.add(comboBoxPane, BorderLayout.PAGE_START);
		frame.add(cards, BorderLayout.CENTER);
		
		frame.setVisible(true);
		frame.setSize(400, 150);
	
	}
	
	public static void main(String[] args) {
		new InventoryInterface();
	}
	public void itemStateChanged(ItemEvent e) {			
		CardLayout cl = (CardLayout)(cards.getLayout());
	    cl.show(cards, (String)e.getItem());
	}
	
	private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == add){
				int newID = Integer.parseInt(five1.getText());
				int newCount = Integer.parseInt(count1.getText());
				inventory.addNew(newID, newCount);
				try {
					inventory.update();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(e.getSource() == remove){
				int id = Integer.parseInt(ten1.getText());
				inventory.removeItem(id);
				try {
					inventory.update();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(e.getSource() == edit){
				int newID = Integer.parseInt(five2.getText());
				int newCount = Integer.parseInt(count2.getText());
				inventory.edit(newID, newCount);	
				try {
					inventory.update();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(e.getSource() == find){
				int id = Integer.parseInt(ten2.getText());
				//display stuff
			}
			else if(e.getSource() == findMax){
				inventory.printMax();
				//display stuff
			}
			else if(e.getSource() == display){
				try {
					inventory.display();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
	}
	
}
