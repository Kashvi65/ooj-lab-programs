import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  

class SwingDemo {  
    SwingDemo() {  
        // Create JFrame container  
        JFrame jfrm = new JFrame("Divider App");  
        jfrm.setSize(275, 200);  
        jfrm.setLayout(new FlowLayout());  

        // To terminate the program when the window closes  
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

        // Label prompting user  
        JLabel jlab = new JLabel("Enter the divisor and dividend:");  

        // Create text fields for input  
        JTextField ajtf = new JTextField(8);  
        JTextField bjtf = new JTextField(8);  

        // Create button to trigger calculation  
        JButton button = new JButton("Calculate");  

        // Labels to display output and errors  
        JLabel err = new JLabel();  
        JLabel alab = new JLabel();  
        JLabel blab = new JLabel();  
        JLabel anslab = new JLabel();  

        // Add components to the frame  
        jfrm.add(jlab);  
        jfrm.add(ajtf);  
        jfrm.add(bjtf);  
        jfrm.add(button);  
        jfrm.add(alab);  
        jfrm.add(blab);  
        jfrm.add(anslab);  
        jfrm.add(err);  

        // Action listener for button click  
        button.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent evt) {  
                try {  
                    // Parse integers from text fields  
                    int a = Integer.parseInt(ajtf.getText());  
                    int b = Integer.parseInt(bjtf.getText());  

                    // Perform division  
                    int ans = a / b;  

                    // Display results  
                    alab.setText("A = " + a);  
                    blab.setText("B = " + b);  
                    anslab.setText("Ans = " + ans);  
                    err.setText("");  // Clear error message  
                } catch (NumberFormatException e) {  
                    // Handle non-integer input  
                    alab.setText("");  
                    blab.setText("");  
                    anslab.setText("");  
                    err.setText("Enter Only Integers!");  
                } catch (ArithmeticException e) {  
                    // Handle division by zero  
                    alab.setText("");  
                    blab.setText("");  
                    anslab.setText("");  
                    err.setText("B should be NON-zero!");  
                }  
            }  
        });  

        // Display the frame  
        jfrm.setVisible(true);  
    }  

    public static void main(String[] args) {  
        // Create the frame on the Event Dispatch Thread  
        SwingUtilities.invokeLater(new Runnable() {  
            public void run() {  
                new SwingDemo();  
            }  
        });  
    }  
}
