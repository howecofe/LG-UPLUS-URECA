package app.foodOrder.ui.category;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.foodOrder.dto.StoreCategoryDto;

public class AddCategoryDialog extends JDialog {
	private JTextField categoryIdField, nameField;
	private JButton addButton;
	private DefaultTableModel tableModel;
	
	public AddCategoryDialog(StoreCategoryPage parent, DefaultTableModel tableModel) {
		this.tableModel = tableModel;
		
		setSize(300, 200);
        setLocationRelativeTo(parent);

        // input panel
        JPanel inputPanel = new JPanel();
        GroupLayout layout = new GroupLayout(inputPanel);
        inputPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // labels and fields
        JLabel categoryIdLabel = new JLabel("Category Id");
        categoryIdField = new JTextField();

        JLabel nameLabel = new JLabel("Category Name");
        nameField = new JTextField();

        // set preferred size for text fields
        Dimension textFieldSize = new Dimension(200, 25);
        categoryIdField.setPreferredSize(textFieldSize);
        nameField.setPreferredSize(textFieldSize);

        // set layout for inputPanel
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(categoryIdLabel)
                    .addComponent(nameLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(categoryIdField)
                    .addComponent(nameField)))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(categoryIdLabel)
                .addComponent(categoryIdField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(nameLabel)
                .addComponent(nameField))
        );
		
		// button panel
		JPanel buttonPanel = new JPanel();
		
		// button
		addButton = new JButton("등록");
		
		buttonPanel.add(addButton);
		
		// add inputPanel, buttonPanel to Dialog
		add(inputPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		// add button actionListener
		addButton.addActionListener(e -> {
			int categoryId = Integer.parseInt(categoryIdField.getText());
			String categoryName = nameField.getText();
			
			parent.insertCategory(new StoreCategoryDto(categoryId, categoryName));
			
			dispose();
		});
		
	}
}
