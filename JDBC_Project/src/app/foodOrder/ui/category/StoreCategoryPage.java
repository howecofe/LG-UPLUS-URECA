package app.foodOrder.ui.category;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import app.foodOrder.dao.StoreCategoryDao;
import app.foodOrder.dto.StoreCategoryDto;
import app.foodOrder.ui.common.NavigationPanel;
import app.foodOrder.ui.store.StorePage;

public class StoreCategoryPage extends JPanel {
	
	private JTable table; // grid ui component
	private DefaultTableModel tableModel; // grid data
	private JButton searchButton, addButton, editButton, listButton;
	private JTextField searchWordField;
	private StoreCategoryDao storeCategoryDao = new StoreCategoryDao();
	private static NavigationPanel navigationPanel;
	
	public StoreCategoryPage(NavigationPanel navigationPanel) {
		this.navigationPanel = navigationPanel;
		
		// table
		tableModel = new DefaultTableModel(new Object[] {"Store Category Id", "Store Category Name"}, 0 ) {
			@Override
            public boolean isCellEditable(int row, int column) {
                return false; // All cells are not editable
            }
		};
		
		table = new JTable(tableModel);
		
		// category list 조회
		listCategory();
	
		// button
		addButton = new JButton("카테고리 등록");
		editButton = new JButton("카테고리 수정 & 삭제");
		listButton = new JButton("새로고침");
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(addButton);
		buttonPanel.add(editButton);
		buttonPanel.add(listButton);
		
		// Add components to main content panel
		setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
		
		// button event
		addButton.addActionListener(e -> {
			AddCategoryDialog addDialog = new AddCategoryDialog(this, this.tableModel);
			addDialog.setVisible(true);
		});
		
		editButton.addActionListener(e -> {
			int selectedRow = table.getSelectedRow();
			
			if (selectedRow >= 0) {
				EditCategoryDialog editDialog = new EditCategoryDialog(this, this.tableModel, selectedRow);
				editDialog.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "카테고리를 선택하세요.");
			}
		});
		
		listButton.addActionListener(e -> listCategory());
		
		table.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
                // double click
                if (e.getClickCount() == 2) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                    	int categoryId = (int)tableModel.getValueAt(selectedRow, 0);
                    	showStorePage(categoryId);
                    }
                }
            }
		});
		
	}
	
	private void clearTable() {
		tableModel.setRowCount(0);
	}
	
	private void listCategory() {
		clearTable();
		
		List<StoreCategoryDto> categoryList = storeCategoryDao.listCategory();
		
		for (StoreCategoryDto category : categoryList) {
			tableModel.addRow(new Object[] {category.getCategoryId(), category.getName()});
		}
	}
	
	StoreCategoryDto detailCategory(int categoryId) {
		return storeCategoryDao.detailCategory(categoryId);
	}
	
	void updateCategory(StoreCategoryDto category) {
		int ret = storeCategoryDao.updateCategory(category);
		
		if (ret == 1) {
			listCategory();
		}
	}
	
	void insertCategory(StoreCategoryDto category) {
		int ret = storeCategoryDao.insertCategory(category);
		
		if (ret == 1) {
			listCategory();
		}
	}
	
	void deleteCategory(int categoryId) {
		int ret = storeCategoryDao.deleteCategory(categoryId);
		
		if (ret == 1) {
			listCategory();
		}
	}
	
	private void showStorePage(int categoryId) {
        StorePage storePage = new StorePage(navigationPanel, this, categoryId);
        navigationPanel.setMainContentPanel(storePage);
    }

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			
			JFrame frame = new JFrame("Store Manager");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);

            StoreCategoryPage storeCategoryPage = new StoreCategoryPage(new NavigationPanel());
            navigationPanel.setMainContentPanel(storeCategoryPage);

            frame.setContentPane(navigationPanel);
            frame.setVisible(true);
            
		});
		
	}

}
