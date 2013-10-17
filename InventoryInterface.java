import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class InventoryInterface implements ItemListener {

	static JPanel cards;
	
	public InventoryInterface() {
		
		JFrame frame = new JFrame("Inventory");
		
		//final JPanel cards;
		final String ADD = "Add Item";
		final String REMOVE = "Remove Item";
		final String EDIT = "Edit Item";
		final String FIND = "Find Item";
		final String FINDMAX = "Find Max";
		final String DISPLAY = "Display";
		
		JPanel card1 = new JPanel();
		card1.add(new JLabel("ID: "));
		card1.add(new JTextField(5));
		card1.add(new JLabel("Cost: "));
		card1.add(new JTextField(5));
		card1.add(new JButton("ADD"));
		
		JPanel card2 = new JPanel();
		card2.add(new JLabel("ID: "));
		card2.add(new JTextField(10));
		card2.add(new JButton("REMOVE"));
		
		JPanel card3 = new JPanel();
		card3.add(new JLabel("ID: "));
		card3.add(new JTextField(5));
		card3.add(new JLabel("Cost: "));
		card3.add(new JTextField(5));
		card3.add(new JButton("EDIT"));
		
		JPanel card4 = new JPanel();
		card4.add(new JLabel("ID: "));
		card4.add(new JTextField(10));
		card4.add(new JButton("FIND"));
		
		JPanel card5 = new JPanel();
		card5.add(new JButton("FIND MAX"));
		
		JPanel card6 = new JPanel();
		card6.add(new JButton("DISPLAY"));
		
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
		comboBoxPane.add(cb);
		
		frame.add(comboBoxPane, BorderLayout.PAGE_START);
		frame.add(cards, BorderLayout.CENTER);
		
		frame.setVisible(true);
		frame.setSize(400, 100);
	
	}
	
	public static void main(String[] args) {
		new InventoryInterface();
	}
	public void itemStateChanged(ItemEvent e) {			
		CardLayout cl = (CardLayout)(cards.getLayout());
	    cl.show(cards, (String)e.getItem());
	}
}
