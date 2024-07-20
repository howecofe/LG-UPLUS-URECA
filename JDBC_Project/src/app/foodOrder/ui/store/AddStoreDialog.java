package app.foodOrder.ui.store;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.foodOrder.dto.StoreDto;

public class AddStoreDialog extends JDialog {
	private JTextField categoryIdField, storeIdField, storeNameField, minPriceField, telField;
	private JButton addButton;
	private DefaultTableModel tableModel;
	
	public AddStoreDialog(StorePage parent, DefaultTableModel tableModel, int categoryId) {
		this.tableModel = tableModel;
		
		setSize(400, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(parent);
        
     // input panel
        JPanel inputPanel = new JPanel();
        GroupLayout layout = new GroupLayout(inputPanel);
        inputPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // labels and fields
        JLabel categoryIdLabel = new JLabel("Store Category Id");
        categoryIdField = new JTextField(String.valueOf(categoryId));
        categoryIdField.setEditable(false);

        JLabel storeIdLabel = new JLabel("Store Id");
        storeIdField = new JTextField();

        JLabel storeNameLabel = new JLabel("Store Name");
        storeNameField = new JTextField();

        JLabel minPriceLabel = new JLabel("최소 주문금액");
        minPriceField = new JTextField();

        JLabel telLabel = new JLabel("전화번호");
        telField = new JTextField();

        // set preferred size for text fields
        Dimension textFieldSize = new Dimension(200, 25);
        categoryIdField.setPreferredSize(textFieldSize);
        storeIdField.setPreferredSize(textFieldSize);
        storeNameField.setPreferredSize(textFieldSize);
        minPriceField.setPreferredSize(textFieldSize);
        telField.setPreferredSize(textFieldSize);

        // set layout for inputPanel
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(categoryIdLabel)
                .addComponent(storeIdLabel)
                .addComponent(storeNameLabel)
                .addComponent(minPriceLabel)
                .addComponent(telLabel))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(categoryIdField)
                .addComponent(storeIdField)
                .addComponent(storeNameField)
                .addComponent(minPriceField)
                .addComponent(telField))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(categoryIdLabel)
                .addComponent(categoryIdField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(storeIdLabel)
                .addComponent(storeIdField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(storeNameLabel)
                .addComponent(storeNameField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(minPriceLabel)
                .addComponent(minPriceField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(telLabel)
                .addComponent(telField))
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
			int storeId = Integer.parseInt(storeIdField.getText());
			String storeName = storeNameField.getText();
			int minPrice = Integer.parseInt(minPriceField.getText());
			String tel = telField.getText();
			
			parent.insertStore(new StoreDto(storeId, categoryId, storeName, tel, minPrice));
			
			dispose();
		});
		
	}
}
