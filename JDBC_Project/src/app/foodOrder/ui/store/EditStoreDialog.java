package app.foodOrder.ui.store;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.foodOrder.dto.StoreDto;

public class EditStoreDialog extends JDialog {
	private JTextField categoryIdField, storeIdField, storeNameField, minPriceField, telField;
	private JButton updateButton, deleteButton;
	private DefaultTableModel tableModel;
	
	public EditStoreDialog(StorePage parent, DefaultTableModel tableModel, int rowIndex) {
		this.tableModel = tableModel;
		
		setSize(400, 250);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        Integer storeId = (Integer) tableModel.getValueAt(rowIndex, 1);
        StoreDto store = parent.detailStore(storeId);

        // input panel
        JPanel inputPanel = new JPanel();
        GroupLayout layout = new GroupLayout(inputPanel);
        inputPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // labels and fields
        JLabel categoryIdLabel = new JLabel("Category Id");
        categoryIdField = new JTextField(String.valueOf(store.getCategoryId()));

        JLabel storeIdLabel = new JLabel("Store Id");
        storeIdField = new JTextField(String.valueOf(store.getStoreId()));
        storeIdField.setEditable(false);

        JLabel storeNameLabel = new JLabel("Store Name");
        storeNameField = new JTextField(store.getStoreName());

        JLabel minPriceLabel = new JLabel("최소 주문 금액");
        minPriceField = new JTextField(String.valueOf(store.getMinPrice()));

        JLabel telLabel = new JLabel("전화번호");
        telField = new JTextField(store.getTell());

        // set preferred size for text fields
        Dimension textFieldSize = new Dimension(200, 25);
        storeNameField.setPreferredSize(textFieldSize);
        minPriceField.setPreferredSize(textFieldSize);
        telField.setPreferredSize(textFieldSize);

        // set layout for inputPanel
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                .addComponent(categoryIdLabel)
                .addComponent(storeIdLabel)
                .addComponent(storeNameLabel)
                .addComponent(minPriceLabel)
                .addComponent(telLabel))
            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                .addComponent(categoryIdField)
                .addComponent(storeIdField)
                .addComponent(storeNameField)
                .addComponent(minPriceField)
                .addComponent(telField))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(categoryIdLabel)
                .addComponent(categoryIdField))
            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(storeIdLabel)
                .addComponent(storeIdField))
            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(storeNameLabel)
                .addComponent(storeNameField))
            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(minPriceLabel)
                .addComponent(minPriceField))
            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(telLabel)
                .addComponent(telField))
        );

		
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
            	int categoryId = Integer.parseInt(categoryIdField.getText());
    			String storeName = storeNameField.getText();
    			int minPrice = Integer.parseInt(minPriceField.getText());
    			String tel = telField.getText();
 
            	parent.updateStore(new StoreDto(storeId, categoryId, storeName, tel, minPrice));
            	
            	dispose();
            }
		});

		deleteButton.addActionListener(e -> {
			
			int ret = JOptionPane.showConfirmDialog(this, "삭제할까요?", "삭제 확인", JOptionPane.YES_NO_OPTION);
            if( ret == JOptionPane.YES_OPTION ) {
            	
            	parent.deleteStore(storeId);
            	
            	dispose();
            }
		});
		
	}
}
