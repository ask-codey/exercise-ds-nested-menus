import java.util.ArrayList;
import java.util.List;

// Your three methods. The comment above each one says what it should
// return, with examples. Replace each return line with your own code,
// and name the method's base case in its comment. Each one handles one
// section and calls itself for the sections inside it.
public class Menus {
    /*
     * Count every dish on the menu: this section's own items, plus the
     * items in every section inside it, at every level.
     *
     * the dinner menu -> 11
     * its Mains section (Pasta and Grill, two dishes each) -> 4
     * a section with nothing in it -> 0
     *
     * Base case: (write it here)
     */
    public static int countItems(MenuSection section) {
        return 0;
    }

    /*
     * Find the most expensive dish anywhere on the menu. When two dishes
     * cost the same, keep the first one found, checking a section's own
     * items before the sections inside it. A menu with no dishes at all
     * has no most expensive one: return null.
     *
     * the dinner menu -> Grilled Salmon, $19
     * its Hot Drinks section (Coffee $3, Tea $3) -> Coffee, $3
     * a section with nothing in it -> null
     *
     * Base case: (write it here)
     */
    public static MenuItem mostExpensive(MenuSection section) {
        return null;
    }

    /*
     * Write the menu as lines of text: the section's name; then each of
     * its own dishes as "Name $price", indented two spaces; then the lines
     * of each section inside it, indented two more spaces than this
     * section's.
     *
     * the Hot Drinks section -> ["Hot Drinks", "  Coffee $3", "  Tea $3"]
     * a section with nothing in it, named Specials -> ["Specials"]
     *
     * Base case: (write it here)
     */
    public static List<String> menuLines(MenuSection section) {
        return new ArrayList<>();
    }
}
