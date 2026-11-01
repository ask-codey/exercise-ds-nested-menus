namespace NestedMenus;

// A dish on the menu, with its price in whole dollars. You don't need to change this.
public record MenuItem(string Name, int Price);

// A section of the menu: its name, its own dishes, and the sections inside it.
// You don't need to change this.
public record MenuSection(string Name, List<MenuItem> Items, List<MenuSection> Sections);
