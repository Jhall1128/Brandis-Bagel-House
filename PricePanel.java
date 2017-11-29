import javax.swing.*;
import java.awt.*;

/**
 * the PricePanel class creates a panel that displays the sorder summary and prices
 * of the user's order.
 * @author John
 * 2 November 2017
 */
public class PricePanel extends JPanel
{
	public final double TAX_RATE = 0.06;
	
	private String bagelOrder = "No Bagel"; //the name of the selected bagel
	private double bagelPrice = 0; //the price of the selected bagel
	private String toppingOrder = "No Topping"; // the name of the selcted topping
	private double toppingPrice = 0; // the price of the selected topping
	private String coffeeOrder = "No Coffee"; // the name of the selected coffee
	private double coffeePrice = 0; //the price of the selected coffee
	private int numShots = 0; //the amount of espresso shots for the order
	private double shotsPrice = 0; // the total price for the espresso shots in the order
	
	private double subtotal; //the subtotal of the order
	private double tax; //the amt of tax
	private double total; //the total price of the order (subtotal + tax)
	
	//labels for the panel
	private JLabel bagelLabel;
	private JLabel toppingLabel;
	private JLabel coffeeLabel;
	private JLabel shotsLabel;
	
	private JLabel subtotalLabel;
	private JLabel taxLabel;
	private JLabel totalLabel;
	
	//subpanels to group the labels
	private JPanel orderSummaryPanel;
	private JPanel totalPanel;
	
	/**
	 * Constructor
	 */
	public PricePanel()
	{
		setLayout(new GridLayout(4,1));
		
		//create and add the labels for the orderSummaryPanel
		bagelLabel = new JLabel();
		toppingLabel = new JLabel();
		coffeeLabel = new JLabel();
		shotsLabel = new JLabel();
		
		orderSummaryPanel = new JPanel();
		orderSummaryPanel.setLayout(new GridLayout(5,1));
		orderSummaryPanel.add(bagelLabel);
		orderSummaryPanel.add(toppingLabel);
		orderSummaryPanel.add(coffeeLabel);
		orderSummaryPanel.add(shotsLabel);
		
		//create and add the labels to the totalPanel
		subtotalLabel = new JLabel();
		taxLabel = new JLabel ();
		totalLabel = new JLabel ();
		
		totalPanel = new JPanel();
		totalPanel.setLayout(new GridLayout(5,1));
		totalPanel.add(subtotalLabel);
		totalPanel.add(taxLabel);
		totalPanel.add(totalLabel);
		
		//set the text of the labels to the current information in the fields
		updateLabels();
		
		add(orderSummaryPanel);
		add(totalPanel);
		
	}
	
	/**
	 * updateLabels, method updates the JLabels in the panel to reflect 
	 * the current values in the class' fields.
	 */
	public void updateLabels()
	{
		
		//update the summaryPanel labels
		bagelLabel.setText(String.format("%s $%.2f", bagelOrder, bagelPrice));
		toppingLabel.setText(String.format("%s $%.2f", toppingOrder, toppingPrice));
		coffeeLabel.setText(String.format("%s $%.2f", coffeeOrder, coffeePrice));
		shotsLabel.setText(String.format("(Includes %d Shots) $%.2f  ", numShots, shotsPrice));
		
		//update the values for the total prices
		subtotal = bagelPrice + toppingPrice + coffeePrice + shotsPrice;
		tax = subtotal * TAX_RATE;
		total = subtotal + tax;
		
		//update the labels for the totalPanel
		subtotalLabel.setText(String.format("Subtotal: $%.2f", subtotal));
		taxLabel.setText(String.format("Tax: $%.2f", tax));
		totalLabel.setText(String.format("Total: $%.2f", total));
		
		if (total == 0)
		{
			totalPanel.setVisible(false);
		}
		else
		{
			totalPanel.setVisible(true);
		}
	}
	
	//MUTATORS
	
	/**
	 * setBagelOrder, bagelOrder mutator
	 * @param bagelOrder -- String, value to put in the bagelOrder field
	 */
	public void setBagelOrder(String bagelOrder)
	{
		this.bagelOrder = bagelOrder;
	}
	
	/**
	 * setBagelPrice, bagelPrice mutator
	 * @param price -- double, value to put in the bagelPrice field
	 */
	public void setBagelPrice(double price)
	{
		bagelPrice = price;
	}
	
	/**
	 * setToppingOrder, toppingOrder mutator
	 * @param toppingOrder -- String, value to put in the toppingOrder field
	 */
	public void setToppingOrder(String toppingOrder)
	{
		this.toppingOrder = toppingOrder;
	}
	
	/**
	 * setToppingPrice, toppingPrice mutator
	 * @param toppingPrice -- double, value to put in the toppingPrice field
	 */
	public void setToppingPrice(double toppingPrice)
	{
		this.toppingPrice = toppingPrice;
	}
	
	/**
	 * setCoffeeOrder, coffeeOrder mutator
	 * @param coffeeOrder -- String, value to put in the coffeeOrder field
	 */
	public void setCoffeeOrder(String coffeeOrder)
	{
		this.coffeeOrder = coffeeOrder;
	}
	
	/**
	 * setCoffeePrice, coffeePrice mutator
	 * @param coffeePrice -- double, value to put in the coffeePrice field
	 */
	public void setCoffeePrice(double coffeePrice)
	{
		this.coffeePrice = coffeePrice;
	}
	
	/**
	 * setNumShots, numShots mutator
	 * @param numShots -- int, value to put into the numShots field
	 */
	public void setNumShots(int numShots)
	{
		this.numShots = numShots;
	}
	
	/**
	 * setShotsPrice, shotsPrice mutator
	 * @param shotsPrice -- double, value to put into the shotsPrice field
	 */
	public void setShotsPrice(double shotsPrice)
	{
		this.shotsPrice = shotsPrice;
	}
	
	//ACCESSORS 
	
	/**
	 * getSubtotal, subtotal accessor
	 * @return the value in the subtotal field, double.
	 */
	public double getSubtotal()
	{
		return subtotal;
	}
	
	/**
	 * getTax, tax accessor
	 * @return the value in the tax field, double.
	 */
	public double getTax()
	{
		return tax;
	}
	
	/**
	 * getTotal, total accessor
	 * @return the value in the total field, double.
	 */
	public double getTotal()
	{
		return total;
	}
}
