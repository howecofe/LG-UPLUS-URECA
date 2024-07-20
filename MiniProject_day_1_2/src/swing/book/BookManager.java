package swing.book;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame; // application
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class BookManager extends JFrame {
	
	private JTable table; // grid ui component
	private DefaultTableModel tableModel; // grid data
	private JButton addButton, editButton;
	
	
	public BookManager() {
		// 화면 UI와 관련된 설정
		setTitle("Book Manager");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x 버튼 누르면 종료
		setLocationRelativeTo(null);
		
		// table
		// DefaultTableModel(Object[] columnNames, int rowCount)
		tableModel = new DefaultTableModel(new Object[] {"Book ID", "Book Name", "Publisher", "Price"}, 0);
		table = new JTable(tableModel);
		
		// button
		addButton = new JButton("Add Book");
		editButton = new JButton("Edit Book");
		
		// button 2개를 담는 JPanel 객체를 만들고 그 객체를 BookManager 에 담는다.
		JPanel buttonPanel = new JPanel(); // default layout: Flow Layout
		buttonPanel.add(addButton);
		buttonPanel.add(editButton);
		
		// table 을 BookManager 에 붙인다.
		// BookManager layout 에 따라 결정 (Grid Layout, Border Layout, Card Layout ...)
		
		// BookManager 의 layout 설정
		setLayout(new BorderLayout());
//		add(table, BorderLayout.CENTER);
		add(new JScrollPane(table), BorderLayout.CENTER); // table < scroll pane < jframe (테이블 안에 데이터가 많아지면 스크롤)
		add(buttonPanel, BorderLayout.SOUTH);
		
		// button action event 처리
		// addActionListener: event 객체를 받아서 처리하는 로직을 가진 객체 <= ActionListener interface 를 구현해야 한다.
		addButton.addActionListener(e -> { // lambda
			// AddBookDialog 를 띄운다.
			AddBookDialog addDialog = new AddBookDialog(this, this.tableModel);
			addDialog.setVisible(true);
		});
		
		editButton.addActionListener(e -> {
			// table 에 선택된 row 가 있으면 EditBookDialog 를 띄운다.
			int selectedRow = table.getSelectedRow(); // 선택된 row 인덱스
			
			if (selectedRow >= 0) {
				EditBookDialog editDialog = new EditBookDialog(this, this.tableModel, selectedRow);
				editDialog.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "도서를 선택하세요.");
			}
		}); 
		
	}

	public static void main(String[] args) {
		// main() thread 와 별개로 별도의 thread 로 화면을 띄운다.
		// thread 처리를 간단히 해주는 utility method 제공
		// invokeLater (thread 객체 <- runnable interface 를 구현한 <- runnable interface 가 functional interface)
		// 결과적으로 invokeLater 는 lambda 식 표현 객
		SwingUtilities.invokeLater(() -> {
			new BookManager().setVisible(true);
		});
		
	}

}
