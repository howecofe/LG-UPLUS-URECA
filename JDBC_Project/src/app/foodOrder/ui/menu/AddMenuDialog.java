package app.foodOrder.ui.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.foodOrder.dto.MenuDto;

public class AddMenuDialog extends JDialog {
	private JTextField storeIdField, menuIdField, menuNameField, priceField;
	private JButton addButton;
	private DefaultTableModel tableModel;
	
	public AddMenuDialog(MenuPage parent, DefaultTableModel tableModel, int storeId) {
		this.tableModel = tableModel;
		
		setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        // input panel using GroupLayout
        JPanel inputPanel = new JPanel();
        GroupLayout layout = new GroupLayout(inputPanel);
        inputPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // labels and fields
        JLabel storeIdLabel = new JLabel("Store Id");
        storeIdField = new JTextField(String.valueOf(storeId));
        storeIdField.setEditable(false);

        JLabel menuIdLabel = new JLabel("Menu Id");
        menuIdField = new JTextField();

        JLabel menuNameLabel = new JLabel("Menu Name");
        menuNameField = new JTextField();

        JLabel priceLabel = new JLabel("최소 주문금액");
        priceField = new JTextField();

        // set preferred size for text fields
        Dimension textFieldSize = new Dimension(200, 25);
        storeIdField.setPreferredSize(textFieldSize);
        menuIdField.setPreferredSize(textFieldSize);
        menuNameField.setPreferredSize(textFieldSize);
        priceField.setPreferredSize(textFieldSize);

        // horizontal layout
        layout.setHorizontalGroup(layout.createParallelGroup()
            .addGroup(layout.createSequentialGroup()
                .addComponent(storeIdLabel)
                .addComponent(storeIdField))
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuIdLabel)
                .addComponent(menuIdField))
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuNameLabel)
                .addComponent(menuNameField))
            .addGroup(layout.createSequentialGroup()
                .addComponent(priceLabel)
                .addComponent(priceField))
        );

        // vertical layout
        layout.setVerticalGroup(layout.createSequentialGroup()
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
		addButton = new JButton("등록");
		
		buttonPanel.add(addButton);
		
		// add inputPanel, buttonPanel to Dialog
		add(inputPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		// add button actionListener
		addButton.addActionListener(e -> {
			int menuId = Integer.parseInt(menuIdField.getText());
			String menuName = menuNameField.getText();
			int price = Integer.parseInt(priceField.getText());
			
			parent.insertMenu(new MenuDto(menuId, storeId, menuName, price));
			
			dispose();
		});
		
	}
}
