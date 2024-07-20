package app.foodOrder.ui.category;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.print.Book;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.foodOrder.dto.StoreCategoryDto;

public class EditCategoryDialog extends JDialog {
	private JTextField categoryIdField, nameFiled;
	private JButton updateButton, deleteButton;
	private DefaultTableModel tableModel;
	
	public EditCategoryDialog(StoreCategoryPage parent, DefaultTableModel tableModel, int rowIndex) {
		this.tableModel = tableModel;
		
		setSize(300, 200);
		setLayout(new BorderLayout(5, 2));
		setLocationRelativeTo(parent);
		
		Integer categoryId = (Integer) tableModel.getValueAt(rowIndex, 0);
		StoreCategoryDto category = parent.detailCategory(categoryId);
		
		// input panel
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(4, 2));
		
		// field
		categoryIdField = new JTextField(String.valueOf(categoryId));
		categoryIdField.setEditable(false);
		nameFiled = new JTextField(category.getName());
		
		// add field with label
		inputPanel.add(new JLabel("Category Id"));
		inputPanel.add(categoryIdField);
		inputPanel.add(new JLabel("Category Name"));
		inputPanel.add(nameFiled);
		
		// button panel
		JPanel buttonPanel = new JPanel();
		
		// button
		updateButton = new JButton("수정");
		deleteButton = new JButton("삭제");
		
		buttonPanel.add(updateButton);
		buttonPanel.add(deleteButton);
		
		// add inputPanel, buttonPanel to Dialog
		add(inputPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		// add button actionListener
		updateButton.addActionListener(e -> {
			
			int ret = JOptionPane.showConfirmDialog(this, "수정할까요?", "수정 확인", JOptionPane.YES_NO_OPTION);
            if( ret == JOptionPane.YES_OPTION ) {
            	String cateogryName = nameFiled.getText();
 
            	parent.updateCategory(new StoreCategoryDto(categoryId, cateogryName));
            	
            	dispose();
            }
		});

		deleteButton.addActionListener(e -> {
			
			int ret = JOptionPane.showConfirmDialog(this, "삭제할까요?", "삭제 확인", JOptionPane.YES_NO_OPTION);
            if( ret == JOptionPane.YES_OPTION ) {
            	
            	parent.deleteCategory(categoryId);
            	
            	dispose();
            }
		});
		
	}
}
