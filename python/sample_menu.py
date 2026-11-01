# The restaurant's dinner menu, used by the demo and the tests. You don't need to change this.
from menu import MenuItem, MenuSection


def dinner():
    return MenuSection("Dinner Menu", [], [
        MenuSection("Starters", [MenuItem("Garlic Bread", 6), MenuItem("Soup of the Day", 7)], []),
        MenuSection("Mains", [], [
            MenuSection("Pasta", [MenuItem("Spaghetti", 14), MenuItem("Lasagna", 16)], []),
            MenuSection("Grill", [MenuItem("Burger", 13), MenuItem("Grilled Salmon", 19)], []),
        ]),
        MenuSection("Desserts", [MenuItem("Apple Pie", 7), MenuItem("Ice Cream", 5)], []),
        MenuSection("Drinks", [], [
            MenuSection("Hot Drinks", [MenuItem("Coffee", 3), MenuItem("Tea", 3)], []),
            MenuSection("Cold Drinks", [MenuItem("Lemonade", 4)], []),
        ]),
    ])
