/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author A.Valensky
 */
import javax.swing.JOptionPane;

public class MoneInventory {
    private String productName;
    private int productID;
    private int stockQuantity;

    public MoneInventory(String productName, int productID, int stockQuantity) {
        this.productName = productName;
        this.productID = productID;
        this.stockQuantity = stockQuantity;
    }

    public void addStock(int amount) {
        if (amount > 0) {
            stockQuantity += amount;
            JOptionPane.showMessageDialog(null, amount + " items added to " + productName + ". Total stock: " + stockQuantity);
        } else {
            JOptionPane.showMessageDialog(null, "Enter a positive number to add.");
        }
    }

    public void removeStock(int amount) {
        if (amount > 0) {
            if (amount <= stockQuantity) {
                stockQuantity -= amount;
                JOptionPane.showMessageDialog(null, amount + " items removed from " + productName + ". Remaining stock: " + stockQuantity);
            } else {
                JOptionPane.showMessageDialog(null, "Not enough stock to remove.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter a positive number to remove.");
        }
    }

    public void displayProductInfo() {
        String info = "Product Name: " + productName +
                      "\nProduct ID: " + productID +
                      "\nStock Quantity: " + stockQuantity;
        JOptionPane.showMessageDialog(null, info);
    }

    public String getProductName() {
        return productName;
    }
}

