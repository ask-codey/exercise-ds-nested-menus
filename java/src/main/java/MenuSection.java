import java.util.List;

// A section of the menu: its name, its own dishes, and the sections inside it.
// You don't need to change this.
public record MenuSection(String name, List<MenuItem> items, List<MenuSection> sections) {
}
