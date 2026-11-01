import java.util.List;

// The restaurant's dinner menu, used by the demo and the tests. You don't need to change this.
public class SampleMenu {
    public static MenuSection dinner() {
        return new MenuSection("Dinner Menu", List.of(), List.of(
            new MenuSection("Starters", List.of(new MenuItem("Garlic Bread", 6), new MenuItem("Soup of the Day", 7)), List.of()),
            new MenuSection("Mains", List.of(), List.of(
                new MenuSection("Pasta", List.of(new MenuItem("Spaghetti", 14), new MenuItem("Lasagna", 16)), List.of()),
                new MenuSection("Grill", List.of(new MenuItem("Burger", 13), new MenuItem("Grilled Salmon", 19)), List.of()))),
            new MenuSection("Desserts", List.of(new MenuItem("Apple Pie", 7), new MenuItem("Ice Cream", 5)), List.of()),
            new MenuSection("Drinks", List.of(), List.of(
                new MenuSection("Hot Drinks", List.of(new MenuItem("Coffee", 3), new MenuItem("Tea", 3)), List.of()),
                new MenuSection("Cold Drinks", List.of(new MenuItem("Lemonade", 4)), List.of())))));
    }
}
