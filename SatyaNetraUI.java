import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SatyaNetraUI extends JFrame {

    private JTextArea reviewArea;
    private JLabel resultLabel;
    private JButton checkButton, clearButton;

    public SatyaNetraUI() {
        setTitle("🕵️‍♂️ Satya Netra - Fake Review Detector");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null); // center
        setLayout(new BorderLayout(0, 0));

        // --------- HEADER PANEL ---------
        JPanel header = new JPanel();
        header.setBackground(new Color(25, 25, 112)); // dark navy blue
        header.setPreferredSize(new Dimension(700, 70));
        JLabel title = new JLabel("🕵️‍♂️ Satya Netra - Fake Review Detector");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        header.add(title);
        add(header, BorderLayout.NORTH);

        // --------- MAIN CONTENT PANEL ---------
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(245, 247, 255));
        mainPanel.setLayout(null);

        JLabel enterLabel = new JLabel("Enter Review Text:");
        enterLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        enterLabel.setBounds(50, 30, 300, 30);
        mainPanel.add(enterLabel);

        // Review Text Area
        reviewArea = new JTextArea();
        reviewArea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        reviewArea.setLineWrap(true);
        reviewArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(reviewArea);
        scrollPane.setBounds(50, 70, 580, 200);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2, true));
        mainPanel.add(scrollPane);

        // Buttons
        checkButton = new JButton("Check Review");
        clearButton = new JButton("Clear");

        checkButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        clearButton.setFont(new Font("Segoe UI", Font.BOLD, 16));

        checkButton.setBackground(new Color(65, 105, 225));
        checkButton.setForeground(Color.WHITE);
        checkButton.setFocusPainted(false);
        checkButton.setBounds(150, 300, 180, 45);
        checkButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        clearButton.setBackground(new Color(220, 20, 60));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFocusPainted(false);
        clearButton.setBounds(370, 300, 120, 45);
        clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        mainPanel.add(checkButton);
        mainPanel.add(clearButton);

        // Result Label
        resultLabel = new JLabel("Result: ", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        resultLabel.setForeground(new Color(25, 25, 112));
        resultLabel.setBounds(50, 370, 580, 50);
        mainPanel.add(resultLabel);

        add(mainPanel, BorderLayout.CENTER);

        // --------- FOOTER PANEL ---------
        JPanel footer = new JPanel();
        footer.setBackground(new Color(25, 25, 112));
        JLabel credit = new JLabel("© 2025 Satya Netra Project | Developed by Team");
        credit.setForeground(Color.WHITE);
        credit.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        footer.add(credit);
        add(footer, BorderLayout.SOUTH);

        // --------- BUTTON ACTIONS ---------
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String review = reviewArea.getText().trim();
                if (review.isEmpty()) {
                    JOptionPane.showMessageDialog(SatyaNetraUI.this, "Please enter a review first.", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Fake prediction logic (dummy for now)
                    simulatePrediction(review);
                }
            }
        });

        clearButton.addActionListener(e -> {
            reviewArea.setText("");
            resultLabel.setText("Result: ");
            resultLabel.setForeground(new Color(25, 25, 112));
        });

        setVisible(true);
    }

    // Dummy prediction simulation
    private void simulatePrediction(String review) {
        resultLabel.setText("Analyzing...");
        resultLabel.setForeground(Color.DARK_GRAY);

        // Fake delay for analysis effect
        new Timer(1200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = (review.length() % 2 == 0) ? " Genuine Review" : "Fake Review";

                if (result.contains("Fake")) {
                    resultLabel.setForeground(new Color(220, 20, 60)); // red
                } else {
                    resultLabel.setForeground(new Color(34, 139, 34)); // green
                }

                resultLabel.setText("Result: " + result);
                ((Timer) e.getSource()).stop();
            }
        }).start();
    }

    // --------- MAIN METHOD ---------
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SatyaNetraUI());
    }
}
