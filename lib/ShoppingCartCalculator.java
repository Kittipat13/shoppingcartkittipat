import java.util.ArrayList;

public class ShoppingCartCalculator {

    /** 
     * คำนวณราคาของรายการสินค้าในตะกร้า โดยพิจารณาจาก ราคาต่อชิ้น ปริมาณ และโปรโมชั่น
     * การซื้อสินค้าแบบมีส่วนลด(BOGO)เป็นการซื้อแบบ 1 แถม 1 เช่น ซื้อของ 10 ชิ้น จะต้องจ่ายเงินแค่ 5 ชิ้น
     * การซื้อสินค้าแบบมีส่วนลด(BULK)เป็นการซื้อสินค้าตั้งแต่ 10 ชิ้นขึ้นไปจะลดราคา 10% แต่ถ้าซื้อไม่ถึง 10 ชิ้นจะคิดตามราคาปกติ
     * @param items รายการสินค้าในตะกร้า
     * @return ราคารวมหลังจากคิดโปรโมชั่นทั้งหมดแล้ว หากรายการว่างหรือเป็น null จะคืนค่า 0.0
    */
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