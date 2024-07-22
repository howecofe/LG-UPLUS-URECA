package app.foodOrder.ui.store;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.foodOrder.dao.StoreDao;
import app.foodOrder.dto.StoreDto;
import app.foodOrder.ui.category.StoreCategoryPage;
import app.foodOrder.ui.common.NavigationPanel;
import app.foodOrder.ui.menu.MenuPage;

public class StorePage extends JPanel {
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton searchButton, addButton, editButton, listButton;
	private JTextField searchWordField;
	private StoreDao storeDao = new StoreDao();
	private static NavigationPanel navigationPanel;
	private static int categoryId;
	
	public StorePage(NavigationPanel navigationPanel, StoreCategoryPage parent, int categoryId) {
		this.navigationPanel = navigationPanel;
		this.categoryId = categoryId;
		
		// setting
        setLayout(new BorderLayout());
		
		// table
		tableModel = new DefaultTableModel(new Object[] {"Store Category", "Store Id", "Store Name", "최소 주문금액", "전화번호"}, 0 ) {
			@Override
            public boolean isCellEditable(int row, int column) {
                return false; // All cells are not editable
            }
		};
		
		table = new JTable(tableModel);
		
		// category 별 store list 조회
		listStore();
		
		// button
		addButton = new JButton("가게 등록");
		editButton = new JButton("가게 수정 & 삭제");
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
			AddStoreDialog addDialog = new AddStoreDialog(this, this.tableModel, categoryId);
			addDialog.setVisible(true);
		});
		
		editButton.addActionListener(e -> {
			int selectedRow = table.getSelectedRow();
			
			if (selectedRow >= 0) {
				EditStoreDialog editDialog = new EditStoreDialog(this, this.tableModel, selectedRow);
				editDialog.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "가게를 선택하세요.");
			}
		});
		
		listButton.addActionListener(e -> listStore());
		
		table.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
                // double click
                if (e.getClickCount() == 2) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                    	int storeId = (int)tableModel.getValueAt(selectedRow, 1);
                    	showMenuPage(storeId);
                    }
                }
            }
		});
	}
	
	private void clearTable() {
		tableModel.setRowCount(0);
	}
	
	private void listStore() {
		clearTable();
		
		List<StoreDto> storeList = storeDao.listStore(categoryId);
		
		for (StoreDto store : storeList) {
			tableModel.addRow(new Object[] {store.getCategoryName(), store.getStoreId(), store.getStoreName(), store.getMinPrice(), store.getTell()});
		}
	}
	
	StoreDto detailStore(int storeId) {
		return storeDao.detailStore(storeId);
	}
	
	void updateStore(StoreDto store) {
		int ret = storeDao.updateStore(store);
		
		if (ret == 1) {
			listStore();
		}
	}
	
	void insertStore(StoreDto store) {
		int ret = storeDao.insertStore(store);
		
		if (ret == 1) {
			listStore();
		}
	}
	
	void deleteStore(int storeId) {
		int ret = storeDao.deleteStore(storeId);
		
		if (ret == 1) {
			listStore();
		}
	}
	
	private void showMenuPage(int storeId) {
		MenuPage menuPage = new MenuPage(navigationPanel, this, storeId);
        navigationPanel.setMainContentPanel(menuPage);
    }
	
	
}
