package app.foodOrder.ui.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import app.foodOrder.dto.MenuDto;

public class EditMenuDialog extends JDialog {
	private JTextField storeIdField, menuIdField, menuNameField, priceField;
	private JButton updateButton, deleteButton;
	private DefaultTableModel tableModel;
	
	public EditMenuDialog(MenuPage parent, DefaultTableModel tableModel, int rowIndex) {
		this.tableModel = tableModel;
		
		setSize(400, 250);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        Integer menuId = (Integer) tableModel.getValueAt(rowIndex, 1);
        MenuDto menu = parent.detailMenu(menuId);

        // input panel
        JPanel inputPanel = new JPanel();
        GroupLayout layout = new GroupLayout(inputPanel);
        inputPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // labels and fields
        JLabel storeIdLabel = new JLabel("Store Id");
        storeIdField = new JTextField(String.valueOf(menu.getStoreId()));
        storeIdField.setEditable(false);

        JLabel menuIdLabel = new JLabel("Menu Id");
        menuIdField = new JTextField(String.valueOf(menu.getMenuId()));
        menuIdField.setEditable(false);

        JLabel menuNameLabel = new JLabel("Menu Name");
        menuNameField = new JTextField(menu.getMenuName());

        JLabel priceLabel = new JLabel("Price");
        priceField = new JTextField(String.valueOf(menu.getPrice()));

        // set preferred size for text fields
        Dimension textFieldSize = new Dimension(200, 25);
        storeIdField.setPreferredSize(textFieldSize);
        menuIdField.setPreferredSize(textFieldSize);
        menuNameField.setPreferredSize(textFieldSize);
        priceField.setPreferredSize(textFieldSize);

        // set layout for inputPanel using GroupLayout
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(storeIdLabel)
                        .addComponent(menuIdLabel)
                        .addComponent(menuNameLabel)
                        .addComponent(priceLabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(storeIdField)
                        .addComponent(menuIdField)
                        .addComponent(menuNameField)
                        .addComponent(priceField)))
        );
        
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(storeIdLabel)
                    .addComponent(storeIdField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(menuIdLabel)
                    .addComponent(menuIdField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(menuNameLabel)
                    .addComponent(menuNameField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel)
                    .addComponent(priceField))
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
            	int storeId = Integer.parseInt(storeIdField.getText());
    			String menuName = menuNameField.getText();
    			int price = Integer.parseInt(priceField.getText());
 
            	parent.updateMenu(new MenuDto(menuId, storeId, menuName, price));
            	
            	dispose();
            }
		});

		deleteButton.addActionListener(e -> {
			
			int ret = JOptionPane.showConfirmDialog(this, "삭제할까요?", "삭제 확인", JOptionPane.YES_NO_OPTION);
            if( ret == JOptionPane.YES_OPTION ) {
            	
            	parent.deleteMenu(menuId);
            	
            	dispose();
            }
		});
		
	}
}
