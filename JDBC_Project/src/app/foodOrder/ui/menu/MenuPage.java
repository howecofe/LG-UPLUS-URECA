package app.foodOrder.ui.menu;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.foodOrder.dao.MenuDao;
import app.foodOrder.dto.MenuDto;
import app.foodOrder.dto.StoreDto;
import app.foodOrder.ui.common.NavigationPanel;
import app.foodOrder.ui.store.StorePage;

public class MenuPage extends JPanel {
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton searchButton, addButton, editButton, listButton;
	private JTextField searchWordField;
	private MenuDao menuDao = new MenuDao();
	private static NavigationPanel navigationPanel;
	private static int storeId;
	
	public MenuPage(NavigationPanel navigationPanel, StorePage parent, int storeId) {
		this.navigationPanel = navigationPanel;
		this.storeId = storeId;
		
		// setting
        setLayout(new BorderLayout());
		
		// table
		tableModel = new DefaultTableModel(new Object[] {"Store Name", "Menu Id", "메뉴 이름", "가격"}, 0 ) {
			@Override
            public boolean isCellEditable(int row, int column) {
                return false; // All cells are not editable
            }
		};
		
		table = new JTable(tableModel);
		
		// store 별 menu list 조회
		listMenu();
		
		// button
		addButton = new JButton("메뉴 등록");
		editButton = new JButton("메뉴 수정 & 삭제");
		listButton = new JButton("새로고침");
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(addButton);
		buttonPanel.add(editButton);
		buttonPanel.add(listButton);
		
		// layout
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		// button event
		// 뒤로가기 버튼
		navigationPanel.setBackButtonListener(e -> navigationPanel.setMainContentPanel(parent));
		
		addButton.addActionListener(e -> {
			AddMenuDialog addDialog = new AddMenuDialog(this, this.tableModel, storeId);
			addDialog.setVisible(true);
		});
		
		editButton.addActionListener(e -> {
			int selectedRow = table.getSelectedRow();
			
			if (selectedRow >= 0) {
				EditMenuDialog editDialog = new EditMenuDialog(this, this.tableModel, selectedRow);
				editDialog.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "메뉴를 선택하세요.");
			}
		});
		
		listButton.addActionListener(e -> listMenu());
	}
	
	private void clearTable() {
		tableModel.setRowCount(0);
	}
	
	private void listMenu() {
		clearTable();
		
		List<MenuDto> menuList = menuDao.listMenu(storeId);
		
		for (MenuDto menu : menuList) {
			tableModel.addRow(new Object[] {menu.getStoreName(), menu.getMenuId(), menu.getMenuName(), menu.getPrice()});
		}
	}
	
	MenuDto detailMenu(int menuId) {
		return menuDao.detailMenu(menuId);
	}
	
	void updateMenu(MenuDto menu) {
		int ret = menuDao.updateMenu(menu);
		
		if (ret == 1) {
			listMenu();
		}
	}
	
	void insertMenu(MenuDto menu) {
		int ret = menuDao.insertMenu(menu);
		
		if (ret == 1) {
			listMenu();
		}
	}
	
	void deleteMenu(int menuId) {
		int ret = menuDao.deleteMenu(menuId);
		
		if (ret == 1) {
			listMenu();
		}
	}
	
}
