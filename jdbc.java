import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SatyaNetraUI {

    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Satya Netra - Fake Review Detector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(240, 248, 255)); // light background

        // Title Label
        JLabel title = new JLabel("🕵️‍♂️ Satya Netra - Fake Review Detector", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(50, 20, 500, 40);
        frame.add(title);

        // Review Label
        JLabel reviewLabel = new JLabel("Enter Review:");
        reviewLabel.setFont(new Font("Arial", Font.BOLD, 16));
        reviewLabel.setBounds(50, 80, 150, 30);
        frame.add(reviewLabel);

        // Text Area for review input
        JTextArea reviewArea = new JTextArea();
        reviewArea.setFont(new Font("Arial", Font.PLAIN, 14));
        reviewArea.setLineWrap(true);
        reviewArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(reviewArea);
        scrollPane.setBounds(50, 120, 480, 150);
        frame.add(scrollPane);

        // Button to check review
        JButton checkButton = new JButton("Check Review");
        checkButton.setFont(new Font("Arial", Font.BOLD, 16));
        checkButton.setBackground(new Color(100, 149, 237));
        checkButton.setForeground(Color.WHITE);
        checkButton.setFocusPainted(false);
        checkButton.setBounds(220, 290, 160, 40);
        frame.add(checkButton);

        // Result Label
        JLabel resultLabel = new JLabel("Result: ", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        resultLabel.setBounds(50, 350, 480, 40);
        frame.add(resultLabel);

        // Button Action (Dummy for now)
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String review = reviewArea.getText().trim();
                if (review.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a review first.");
                } else {
                    // Placeholder logic (you can connect backend later)
                    String result = (review.length() % 2 == 0) ? "Genuine Review ✅" : "Fake Review ❌";
                    if (result.contains("Fake")) {
                        resultLabel.setForeground(Color.RED);
                    } else {
                        resultLabel.setForeground(new Color(34, 139, 34)); // green
                    }
                    resultLabel.setText("Result: " + result);
                }
            }
        });

        // Show frame
        frame.setVisible(true);
    }
}
