// Tries your methods on the dinner menu. Run it with: java src/main/java/Demo.java
public class Demo {
    public static void main(String[] args) {
        MenuSection menu = SampleMenu.dinner();

        System.out.println("Dishes on the menu: " + Menus.countItems(menu));
        MenuItem priciest = Menus.mostExpensive(menu);
        System.out.println("Most expensive: " + (priciest == null ? "none" : priciest.name() + " $" + priciest.price()));
        for (String line : Menus.menuLines(menu)) {
            System.out.println(line);
        }
    }
}
