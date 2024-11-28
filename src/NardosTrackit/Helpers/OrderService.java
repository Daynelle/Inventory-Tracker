
package NardosTrackit.Helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import NardosTrackit.Class.Cart;
import NardosTrackit.Class.CartItem;
import NardosTrackit.Class.Order;

/**
 *
 * @author Stephen-Jon Dixon, Roshane Roach, Jhanoi Samuels,Danielle Tulloch, Shenelle Turner,Victoria Whyte
 */
public class OrderService {
    
    private Cart cart;
    
    public OrderService() {
        this.cart = new Cart(new ArrayList<>(), 0);
    }
    
    public void addToCart(CartItem cartItem) {
        this.cart.addItemToCart(cartItem);
    }
    
    public void clearCart() {
        this.cart = new Cart(new ArrayList<>(), 0);
    }
    
    public Cart getCart() {
        return this.cart;
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
