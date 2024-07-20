package swing.book;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EditBookDialog extends JDialog {
	private JTextField bookIdField, bookNameFiled, publisherField, priceField;
	private JButton saveButton;
	private DefaultTableModel tableModel;
	
	public EditBookDialog(JFrame parent, DefaultTableModel tableModel, int rowIndex) {
		this.tableModel = tableModel;
		
		setSize(300, 200);
		setLayout(new GridLayout(5, 2));
		setLocationRelativeTo(parent); // 부모에 맞게
		
		// 선택된 row 의 각 항목의 값을 구하고 JTextFiled 객체를 생성하면서 이 값을 전달
		String bookId = (String) tableModel.getValueAt(rowIndex, 0);
		String bookName = (String) tableModel.getValueAt(rowIndex, 1);
		String publishser = (String) tableModel.getValueAt(rowIndex, 2);
		String price = (String) tableModel.getValueAt(rowIndex, 3);
		
		// field
		bookIdField = new JTextField(bookId);
		bookNameFiled = new JTextField(bookName);
		publisherField = new JTextField(publishser);
		priceField = new JTextField(price);
		
		// button
		saveButton = new JButton("Save");
		
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
		add(saveButton);
		
		// save button actionListener
		saveButton.addActionListener(e -> {
			tableModel.setValueAt(bookIdField.getText(), rowIndex, 0);
			tableModel.setValueAt(bookNameFiled.getText(), rowIndex, 1);
			tableModel.setValueAt(publisherField.getText(), rowIndex, 2);
			tableModel.setValueAt(priceField.getText(), rowIndex, 3);
			
			dispose(); // 닫기
		});
		
	}
}
