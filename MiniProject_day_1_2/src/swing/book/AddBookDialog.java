package swing.book;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddBookDialog extends JDialog {
	private JTextField bookIdField, bookNameFiled, publisherField, priceField;
	private JButton addButton;
	private DefaultTableModel tableModel;
	
	public AddBookDialog(JFrame parent, DefaultTableModel tableModel) {
		this.tableModel = tableModel;
		
		setSize(300, 200);
		setLayout(new GridLayout(5, 2));
		setLocationRelativeTo(parent); // 부모에 맞게
		
		// field
		bookIdField = new JTextField();
		bookNameFiled = new JTextField();
		publisherField = new JTextField();
		priceField = new JTextField();
		
		// button
		addButton = new JButton("Add");
		
		// add field with label
		add(new JLabel("Book Id"));
		add(bookIdField);
		add(new JLabel("Book Name"));
		add(bookNameFiled);
		add(new JLabel("Publisher"));
		add(publisherField);
		add(new JLabel("Price"));
		add(priceField);
		add(new JLabel(""));
		add(addButton);
		
		// add button actionListener
		addButton.addActionListener(e -> {
			String bookId = bookIdField.getText();
			String bookName = bookNameFiled.getText();
			String publisher = publisherField.getText();
			String price = priceField.getText();
			
			tableModel.addRow(new Object[] {bookId, bookName, publisher, price});
			
			dispose(); // 닫기
		});
		
	}
}
