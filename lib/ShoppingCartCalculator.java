import java.util.ArrayList;

public class ShoppingCartCalculator {

    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        if(items==null ||items.isEmpty()){
            return 0.0;
        }
        double total =0.0;
        for(int i=0;i<items.size();i++){
        CartItem item = items.get(i);
        String sku=item.sku();
        double itemtotal=0.0;
        if(item.quantity()>0&&item.price()>0){
            switch(sku){
                case "BOGO":
                int product=(item.quantity()/2)+(item.quantity()%2);
                itemtotal=product*item.price();
                    break;
                case "BULK":
                if(item.quantity()>=10){
                    itemtotal=item.quantity()*item.price()*0.9;
                }else{
                    itemtotal=item.quantity()*item.price();
                }
                break;

                default:
                itemtotal=item.quantity()*item.price();
            }
        }else{
            continue;
        }
        total+=itemtotal;
        }
        return total;
    }
}