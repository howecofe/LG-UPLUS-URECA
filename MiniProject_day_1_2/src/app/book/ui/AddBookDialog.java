package app.book.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.book.dto.Book;

public class AddBookDialog extends JDialog {
	private JTextField bookIdField, bookNameFiled, publisherField, priceField;
	private JButton addButton;
	private DefaultTableModel tableModel;
	
	public AddBookDialog(BookManager parent, DefaultTableModel tableModel) {
		this.tableModel = tableModel;
		
		setSize(300, 200);
		setLayout(new GridLayout(5, 2));
		setLocationRelativeTo(parent); // 부모에 맞게
		
		// input panel
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(4, 2));
		
		// field
		bookIdField = new JTextField();
		bookNameFiled = new JTextField();
		publisherField = new JTextField();
		priceField = new JTextField();
		
		// add field with label
		inputPanel.add(new JLabel("Book Id"));
		inputPanel.add(bookIdField);
		inputPanel.add(new JLabel("Book Name"));
		inputPanel.add(bookNameFiled);
		inputPanel.add(new JLabel("Publisher"));
		inputPanel.add(publisherField);
		inputPanel.add(new JLabel("Price"));
		inputPanel.add(priceField);
		
		// button panel
		JPanel buttonPanel = new JPanel();
		
		// button
		addButton = new JButton("Add");
		
		buttonPanel.add(addButton);
		
		// add inputPanel, buttonPanel to Dialog
		add(inputPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		// add button actionListener
		addButton.addActionListener(e -> {
			int bookId = Integer.parseInt(bookIdField.getText());
			String bookName = bookNameFiled.getText();
        	String publisher = publisherField.getText();
        	int price = Integer.parseInt(priceField.getText());
			
			parent.insertBook(new Book(bookId, bookName, publisher, price));
			
			dispose(); // 닫기
		});
		
	}
}
