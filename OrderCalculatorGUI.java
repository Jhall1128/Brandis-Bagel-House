import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The OrderCalculatorGUI class creates the GUI for the Brandi's Bagel House
 * application.
 * @author John Hall
 * 2 November 2017
 */

public class OrderCalculatorGUI extends JFrame
{
	private OrderPanel orderPanel; // Order Panel
	private GreetingPanel banner; // To display a greeting
	private PricePanel pricePanel; // Price Panel
	private JPanel buttonPanel; // To hold the buttons
	private JButton calcButton; // To calculate the cost
	private JButton exitButton; // To exit the application
	private final double TAX_RATE = 0.06; // Sales tax rate

	/**
      Constructor
   */

   public OrderCalculatorGUI()
   {
      // Display a title.
      setTitle("Order Calculator");

      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create a BorderLayout manager.
      setLayout(new BorderLayout());

      // Create the custom panels.
      banner = new GreetingPanel();
      pricePanel = new PricePanel();
      orderPanel = new OrderPanel(pricePanel);

      // Create the button panel.
      buildButtonPanel();

      // Add the components to the content pane.
      add(banner, BorderLayout.NORTH);
      add(pricePanel, BorderLayout.EAST);
      add(orderPanel, BorderLayout.WEST);
      add(buttonPanel, BorderLayout.SOUTH);

      // Pack the contents of the window and display it.
      pack();
      setVisible(true);
   }

	/**
	 * The buildButtonPanel method builds the button panel.
	 */

	private void buildButtonPanel()
	{
		// Create a panel for the buttons.
		buttonPanel = new JPanel();

		// Create the buttons.
		calcButton = new JButton("Calculate");
		exitButton = new JButton("Exit");

		// Register the action listeners.
		calcButton.addActionListener(new CalcButtonListener());
		exitButton.addActionListener(new ExitButtonListener());

		// Add the buttons to the button panel.
		buttonPanel.add(calcButton);
		buttonPanel.add(exitButton);
	}

	/**
	 * Private inner class that handles the event when the user clicks the Calculate
	 * button.
	 */

	private class CalcButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// Variables to hold the subtotal, tax, and total
			double subtotal, tax, total;
			
			// Calculate the subtotal.
			subtotal = pricePanel.getSubtotal();
			
			// Calculate the sales tax.
			tax = subtotal * TAX_RATE;

			// Calculate the total.
			total = subtotal + tax;

			// Display the charges.
			JOptionPane.showMessageDialog(null,
					String.format("Subtotal: $%,.2f\n" + "Tax: $%,.2f\n" + "Total: $%,.2f", subtotal, tax, total));
		}
	}

	/**
	 * Private inner class that handles the event when the user clicks the Exit
	 * button.
	 */

	private class ExitButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}

	/**
	 * main method
	 */

	public static void main(String[] args)
	{
		new OrderCalculatorGUI();
	}
}
