package app.foodOrder.ui.common;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import app.foodOrder.ui.category.StoreCategoryPage;

public class NavigationPanel extends JPanel {
    private JButton backButton;
    private JButton homeButton;
    private JPanel mainContentPanel;
    private StoreCategoryPage mainPage;

    public NavigationPanel() {
        setLayout(new BorderLayout());

        // Navigation buttons
        JPanel navigationPanel = new JPanel();
        backButton = new JButton("뒤로가기");
        homeButton = new JButton("홈으로 가기");
        navigationPanel.add(backButton);
        navigationPanel.add(homeButton);

        mainContentPanel = new JPanel(new BorderLayout());

        add(navigationPanel, BorderLayout.NORTH);
        add(mainContentPanel, BorderLayout.CENTER);
        
        mainPage = new StoreCategoryPage(this); // 초기화
        setMainContentPanel(mainPage); // 기본 페이지로 설정
        
        homeButton.addActionListener(e -> setMainContentPanel(mainPage));
    }

    public void setMainContentPanel(JPanel panel) {
        mainContentPanel.removeAll();
        mainContentPanel.add(panel, BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }

    public void setBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}