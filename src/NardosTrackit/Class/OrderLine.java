
package NardosTrackit.Class;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import NardosTrackit.Helpers.*;

/**
 *
 * @author Stephen-Jon Dixon, Roshane Roach, Jhanoi Samuels,Danielle Tulloch, Shenelle Turner,Victoria Whyte
 */
public class OrderLine {
    ItemService itemService = new ItemService();
    private String custName;
    private int orderID;
    private String name;
    private int quantity;
    private double price;

    public OrderLine(){
        
    }
    
    public OrderLine(String custName, int orderID, String name, int quantity, double price) {
        this.custName = custName;
        this.orderID = orderID;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getCustName(){
        return this.custName;
    }

    public void setCustName(String custName){
        this.custName = custName;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Order> getAll() {
        
        List<Order> orders = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("storage/order.txt"))) {
            while (scanner.hasNextLine()) {
                String itemLine = scanner.nextLine();

                String itemInfo[] = itemLine.split(",");

                Order order = new Order(Integer.parseInt(itemInfo[0]), Double.parseDouble(itemInfo[1]),itemInfo[2]);

                orders.add(order);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }
}
