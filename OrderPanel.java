import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * the OrderPanel class creates a panel that holds all of the Combo Boxes and sliders
 * that the user needs to make their order
 * @author John Hall
 * 2 November 2017
 */
public class OrderPanel extends JPanel
{
	//constants for the prices of the various foods/drinks
	public final double NO_BAGEL = 0.0;
	public final double WHITE_BAGEL = 1.25;
	public final double WHEAT_BAGEL = 1.50;
	public final double SESAME_BAGEL = 1.50;
	
	public final double NO_TOPPING = 0.0;
	public final double CREAM_CHEESE = 0.50;
	public final double BUTTER = 0.25;
	public final double PEACH_JELLY = 0.75;
	public final double BLUEBERRY_JAM = 0.75;

	public final double NO_COFFEE = 0.0;
	public final double REGULAR_COFFEE = 1.25;
	public final double DECAF_COFFEE = 1.25;
	public final double CAPPUCCINO = 2.00;
	public final double REDEYE = 1.50;
	public final double ESPRESSO_SHOT = 0.50;
	
	//Arrays for the 3 comboboxes, and parallel arrays for the prices of each item	
	private String[] bagels = {"No Bagel", "White Bagel","Wheat Bagel", "Sesame Bagel"};
	private double[] bagelPrices = {NO_BAGEL, WHITE_BAGEL, WHEAT_BAGEL, SESAME_BAGEL};
	
	private String[] toppings = {"No Topping", "Cream Cheese", "Butter", "Peach Jelly", "Blueberry Jam"};
	private double[] toppingPrices = {NO_TOPPING, CREAM_CHEESE, BUTTER, PEACH_JELLY, BLUEBERRY_JAM};
	
	private String[] coffee = {"No Coffee", "Regular", "Decaf", "Cappuccino", "Redeye"};
	private double[] coffeePrices = {NO_COFFEE, REGULAR_COFFEE, DECAF_COFFEE, CAPPUCCINO, REDEYE};
	
	//components of the panel
	private JLabel bagelLabel;
	private JLabel toppingLabel;
	private JLabel coffeeLabel;
	private JLabel shotsLabel;
	private JComboBox bagelBox;
	private JComboBox toppingBox;
	private JComboBox coffeeBox;
	private JSlider shotsSlider;
	
	private PricePanel pricePanel; //PricePanel that will be updated during actionEvents
	
	/**
	 * Constructor
	 * @param pricePanel -- PricePanel, the value to be put to the pricePanel field.
	 */
	public OrderPanel(PricePanel pricePanel)
	{
		//add the pricePanel as a field
		this.pricePanel = pricePanel;
		
		setLayout(new GridLayout(8,1));
		setBorder(BorderFactory.createTitledBorder("Order"));
		
		//create the labels
		bagelLabel = new JLabel("Bagel:");
		toppingLabel = new JLabel("Topping:");		
		coffeeLabel = new JLabel("Coffee:");	
		shotsLabel = new JLabel("Number of Shots:");
		
		//create the combo boxes
		bagelBox = new JComboBox(bagels);
		bagelBox.addActionListener(new ComboBoxListener());
		
		toppingBox = new JComboBox(toppings);
		toppingBox.addActionListener(new ComboBoxListener());
		
		coffeeBox = new JComboBox(coffee);
		coffeeBox.addActionListener(new ComboBoxListener());
		
		//create the slider
		shotsSlider = new JSlider(JSlider.HORIZONTAL, 0, 5, 0);
		shotsSlider.setMajorTickSpacing(1);
		shotsSlider.setPaintLabels(true);
		shotsSlider.setPaintTicks(true);
		shotsSlider.addChangeListener(new SliderListener());
		
		//hide the topping box/label and the shots slider/label at the start
		toppingLabel.setVisible(false);
		toppingBox.setVisible(false);
		shotsLabel.setVisible(false);
		shotsSlider.setVisible(false);
		
		//add all the components to the panel
		add(bagelLabel);
		add(bagelBox);
		add(toppingLabel);
		add(toppingBox);
		add(coffeeLabel);
		add(coffeeBox);
		add(shotsLabel);
		add(shotsSlider);
	}
	
	private class ComboBoxListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//determine the price from the selections in the combobox
			int bagelIndex = bagelBox.getSelectedIndex();
			double bagelPrice = bagelPrices[bagelIndex];
			
			//hide the topping panel and set the values to 'no topping' if no bagel is selected
			//otherwise make set the components to visible
			if(bagelIndex == 0)
			{
				toppingLabel.setVisible(false);
				toppingBox.setVisible(false);
				
				//set the toppingBox combo box to "No Topping"
				toppingBox.setSelectedIndex(0);
			}
			else
			{
				toppingLabel.setVisible(true);
				toppingBox.setVisible(true);
			}
			
			int toppingIndex = toppingBox.getSelectedIndex();
			double toppingPrice = toppingPrices[toppingIndex];
			
			int coffeeIndex = coffeeBox.getSelectedIndex();
			double coffeePrice = coffeePrices[coffeeIndex];
			
			//hide the slider and set numshots to 0 if coffee is not set to redeye
			//otherwise show the slider and leave the numshots unchanged
			if(coffeeIndex != 4)
			{
				shotsLabel.setVisible(false);
				shotsSlider.setVisible(false);
				
				//set the value of the slider to 0 and update the pricePanel
				shotsSlider.setValue(0);
				pricePanel.setNumShots(0);
			}
			else
			{
				shotsLabel.setVisible(true);
				shotsSlider.setVisible(true);
			}
			
			//set the fields in the pricePanel to the currently selected values
			pricePanel.setBagelOrder((String)bagelBox.getSelectedItem());
			pricePanel.setBagelPrice(bagelPrice);
			
			pricePanel.setToppingOrder((String)toppingBox.getSelectedItem());
			pricePanel.setToppingPrice(toppingPrice);
			
			pricePanel.setCoffeeOrder((String)coffeeBox.getSelectedItem());
			pricePanel.setCoffeePrice(coffeePrice);
			
			pricePanel.updateLabels();
		}
	}
	
	private class SliderListener implements ChangeListener
	{
		public void stateChanged(ChangeEvent e)
		{
			//set the fields in the price panel to reflect the current selection on the slider
			int numShots = shotsSlider.getValue();
			double shotsPrice = numShots * ESPRESSO_SHOT;
			
			pricePanel.setNumShots(numShots);
			pricePanel.setShotsPrice(shotsPrice);
			
			pricePanel.updateLabels();
			
		}
	}
}
