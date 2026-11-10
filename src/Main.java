/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author A.Valensky
 */
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        MoneInventory[] products = {
            new MoneInventory("Protein Powder", 101, 50),
            new MoneInventory("Yoga Mat", 102, 30),
            new MoneInventory("Running Shoes", 103, 20)
        };

        boolean running = true;

        while (running) {
            StringBuilder productList = new StringBuilder("Select a product:\n");
            for (int i = 0; i < products.length; i++) {
                productList.append(i).append(": ").append(products[i].getProductName()).append("\n");
            }

            String input = JOptionPane.showInputDialog(productList.toString());
            if (input == null) break;
            int selectedIndex;

            try {
                selectedIndex = Integer.parseInt(input);
                if (selectedIndex < 0 || selectedIndex >= products.length) {
                    JOptionPane.showMessageDialog(null, "Invalid selection.");
                    continue;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Enter a valid number.");
                continue;
            }

            MoneInventory selectedProduct = products[selectedIndex];

            String[] options = {"Add Stock", "Remove Stock", "Display Info", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an option",
                    "Mone's Inventory System", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    String addInput = JOptionPane.showInputDialog("Enter amount to add:");
                    try {
                        int amount = Integer.parseInt(addInput);
                        selectedProduct.addStock(amount);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Enter a valid number.");
                    }
                    break;

                case 1:
                    String removeInput = JOptionPane.showInputDialog("Enter amount to remove:");
                    try {
                        int amount = Integer.parseInt(removeInput);
                        selectedProduct.removeStock(amount);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Enter a valid number.");
                    }
                    break;

                case 2:
                    selectedProduct.displayProductInfo();
                    break;

                case 3:
                default:
                    running = false;
                    break;
            }
        }
    }
}

