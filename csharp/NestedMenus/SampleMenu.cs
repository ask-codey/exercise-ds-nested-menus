namespace NestedMenus;

// The restaurant's dinner menu, used by the demo and the tests. You don't need to change this.
public static class SampleMenu
{
    public static MenuSection Dinner()
    {
        return new MenuSection("Dinner Menu", [], [
            new MenuSection("Starters", [new MenuItem("Garlic Bread", 6), new MenuItem("Soup of the Day", 7)], []),
            new MenuSection("Mains", [], [
                new MenuSection("Pasta", [new MenuItem("Spaghetti", 14), new MenuItem("Lasagna", 16)], []),
                new MenuSection("Grill", [new MenuItem("Burger", 13), new MenuItem("Grilled Salmon", 19)], [])
            ]),
            new MenuSection("Desserts", [new MenuItem("Apple Pie", 7), new MenuItem("Ice Cream", 5)], []),
            new MenuSection("Drinks", [], [
                new MenuSection("Hot Drinks", [new MenuItem("Coffee", 3), new MenuItem("Tea", 3)], []),
                new MenuSection("Cold Drinks", [new MenuItem("Lemonade", 4)], [])
            ])
        ]);
    }
}
