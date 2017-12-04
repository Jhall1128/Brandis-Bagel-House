# Brandis-Bagel-House

Brandi's Bagel House is a program that allows a user to choose an order from a fictitious bagel and coffee company. The result will include the summary and price of the order.

### BrandiLogo.jpg
Logo that is used for the splash screen of the program (not implemented yet).

### GreetingPanel.java
The GreetingPanel that serves as the header for the program. the information from this panel is displayed at the top of the program's window.

### OrderPanel.java
the OrderPanel contains all of the possible selections from the store. The user can select a bagel, a topping and a coffee from the Order Panel. All selections are made using JComboBox objects from java's Swing library, and the JComboBoxes will hide themselves if they are not necessary (eg. if no bagel is selected, then there is no reason to have a topping menu.)

### PricePanel.java
The PricePanel contains a summary of the user's order on the right hand side of the Screen. The Summary includes:
* A list of all items that the user ordered, along with their price.
* The subtotal, tax (at 6% tax rate) and grand total of the order.

This panel updates in real-time, and will change the moment that a change is made to the order.

### OrderCalculatorGUI
This File is used to start and execute the program. it contains the necessary code to combine each of the panels into a single window. NOTE: a splash screen needs to be added to this file, so that BrandiLogo.jpg can be viewed whiel the program is loading
