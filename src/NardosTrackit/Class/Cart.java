
package NardosTrackit.Class;

import java.util.List;

/**
 *
 * @author Stephen-Jon Dixon, Roshane Roach, Jhanoi Samuels,Danielle Tulloch, Shenelle Turner,Victoria Whyte
 */
public class Cart {
    
   private List<CartItem> cartItems;
   private double totalPrice;

    public Cart(List<CartItem> cartItems, double totalPrice) {
        this.cartItems = cartItems;
        this.totalPrice = totalPrice;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
    
    public void addItemToCart(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }

    public double getTotalPrice() {
        totalPrice = 0;
        cartItems.forEach((cartItem) -> {
            totalPrice += cartItem.getPrice();
        });
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    } 
}
