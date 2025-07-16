import java.util.ArrayList;

public class ShoppingCartManualTest {

    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));      // 15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }

        // Test 4: คำนวณแบบมีส่วนลด "BOGO" ซื้อ 1 แถม 1 เมื่อซื้อสินค้าเป็นจำนวนคู่
        ArrayList<CartItem> BOGOevenCart = new ArrayList<>();
        BOGOevenCart.add(new CartItem("BOGO", "snack", 20.0, 6));
        double total4 = ShoppingCartCalculator.calculateTotalPrice(BOGOevenCart);
        if (total4 == 60.0) {
            System.out.println("PASSED: BOGOevenCart total is correct (60.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: BOGOevenCart total expected 60.0 but got " + total4);
            failedCount++;
        }

        // Test 5: คำนวณแบบมีส่วนลด "BOGO" ซื้อ 1 แถม 1 เมื่อซื้อสินค้าเป็นจำนวนคี่
        ArrayList<CartItem> BOGOoddCart = new ArrayList<>();
        BOGOoddCart.add(new CartItem("BOGO", "snack", 30.0, 7));
        double total5 = ShoppingCartCalculator.calculateTotalPrice(BOGOoddCart);
        if (total5 == 120.0) {
            System.out.println("PASSED: BOGOoddCart total is correct (120.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: BOGOoddCart total expected 120.0 but got " + total5);
            failedCount++;
        }

        // Test 6: คำนวณแบบมีส่วนลดเมื่อซื้อเยอะขึ้น "BULK" เมื่อซื้อ 10 ชิ้นขึ้นไป ลด10%
        ArrayList<CartItem> BULKCart10 = new ArrayList<>();
        BULKCart10.add(new CartItem("BULK", "banana", 10.0, 10));
        double total6 = ShoppingCartCalculator.calculateTotalPrice(BULKCart10);
        if (total6 == 90.0) {
            System.out.println("PASSED: BULKCart10 total is correct (90.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: BULKCart10 total expected 90.0 but got " + total6);
            failedCount++;
        }

        // Test 7: คำนวณแบบ "BULK" เมื่อซื้อไม่ถึง 10 ชิ้น ไม่ลดราคา
        ArrayList<CartItem> BULKCart8 = new ArrayList<>();
        BULKCart8.add(new CartItem("BULK", "banana", 10.0, 8));
        double total7 = ShoppingCartCalculator.calculateTotalPrice(BULKCart8);
        if (total6 == 80.0) {
            System.out.println("PASSED: BULKCart8 total is correct (80.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: BULKCart8 total expected 80.0 but got " + total7);
            failedCount++;
        }
        System.out.println("Passed:"+ passedCount + ", Failed" + failedCount);
}
}