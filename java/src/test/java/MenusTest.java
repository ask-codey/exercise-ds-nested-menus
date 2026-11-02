import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import org.junit.jupiter.api.Test;

// The tests for your three methods. You don't need to change this file.
// Each message says what was expected, so a failing test tells you what to look at.
class MenusTest {
    private static MenuSection empty(String name) {
        return new MenuSection(name, List.of(), List.of());
    }

    // A dish four sections down: Specials > Chef's Table > Tonight > Truffle Pasta $25.
    private static MenuSection deep() {
        return new MenuSection("Specials", List.of(new MenuItem("Soup", 8)), List.of(
            new MenuSection("Chef's Table", List.of(), List.of(
                new MenuSection("Tonight", List.of(new MenuItem("Truffle Pasta", 25)), List.of())))));
    }

    // A tasting menu ten sections deep: Course 1 holds Course 2, and so on down to Course 10. Course n serves Bite n at $n.
    private static MenuSection tenDeep() {
        MenuSection section = new MenuSection("Course 10", List.of(new MenuItem("Bite 10", 10)), List.of());
        for (int number = 9; number >= 1; number--) {
            section = new MenuSection("Course " + number, List.of(new MenuItem("Bite " + number, number)), List.of(section));
        }
        return section;
    }

    @Test
    void countItemsOnTheDinnerMenu() {
        assertEquals(11, Menus.countItems(SampleMenu.dinner()), "Not yet: the dinner menu has 11 dishes, counting every section inside it.");
    }

    @Test
    void countItemsInOneSection() {
        MenuSection menu = SampleMenu.dinner();
        assertEquals(4, Menus.countItems(menu.sections().get(1)), "Not yet: Mains holds Pasta and Grill, with 2 dishes each: 4.");
        assertEquals(3, Menus.countItems(menu.sections().get(3)), "Not yet: Drinks holds Hot Drinks (2 dishes) and Cold Drinks (1): 3.");
    }

    @Test
    void countItemsDeepDownAndInAnEmptySection() {
        assertEquals(2, Menus.countItems(deep()), "Not yet: Specials has Soup, and Truffle Pasta two sections further down: 2.");
        assertEquals(0, Menus.countItems(empty("Specials")), "Not yet: a section with nothing in it has 0 dishes.");
    }

    @Test
    void mostExpensiveOnTheDinnerMenu() {
        MenuItem priciest = Menus.mostExpensive(SampleMenu.dinner());
        assertNotNull(priciest, "Not yet: the dinner menu's most expensive dish is Grilled Salmon, $19.");
        assertEquals("Grilled Salmon", priciest.name(), "Not yet: the dinner menu's most expensive dish is Grilled Salmon, $19.");
        assertEquals(19, priciest.price(), "Not yet: Grilled Salmon costs $19.");
    }

    @Test
    void mostExpensiveFindsADishDeepDown() {
        MenuItem priciest = Menus.mostExpensive(deep());
        assertNotNull(priciest, "Not yet: Truffle Pasta, $25, is two sections down, and it's the priciest.");
        assertEquals("Truffle Pasta", priciest.name(), "Not yet: Truffle Pasta, $25, is two sections down, and it's the priciest.");
    }

    @Test
    void mostExpensiveKeepsTheFirstOfATie() {
        MenuItem priciest = Menus.mostExpensive(SampleMenu.dinner().sections().get(3).sections().get(0));
        assertNotNull(priciest, "Not yet: Coffee and Tea both cost $3, and Coffee comes first.");
        assertEquals("Coffee", priciest.name(), "Not yet: Coffee and Tea both cost $3, and Coffee comes first.");
    }

    @Test
    void mostExpensiveOfASectionAndOfAnEmptyMenu() {
        MenuItem priciest = Menus.mostExpensive(SampleMenu.dinner().sections().get(3));
        assertNotNull(priciest, "Not yet: in Drinks, Lemonade ($4) costs the most.");
        assertEquals("Lemonade", priciest.name(), "Not yet: in Drinks, Lemonade ($4) costs the most.");
        assertNull(Menus.mostExpensive(empty("Specials")), "Not yet: a section with no dishes has no most expensive one: return null.");
    }

    @Test
    void menuLinesForOneSection() {
        assertEquals(List.of("Drinks", "  Hot Drinks", "    Coffee $3", "    Tea $3", "  Cold Drinks", "    Lemonade $4"),
            Menus.menuLines(SampleMenu.dinner().sections().get(3)),
            "Not yet: Drinks, then its sections two spaces in, then their dishes two spaces further.");
    }

    @Test
    void menuLinesForTheDinnerMenu() {
        List<String> expected = List.of(
            "Dinner Menu",
            "  Starters",
            "    Garlic Bread $6",
            "    Soup of the Day $7",
            "  Mains",
            "    Pasta",
            "      Spaghetti $14",
            "      Lasagna $16",
            "    Grill",
            "      Burger $13",
            "      Grilled Salmon $19",
            "  Desserts",
            "    Apple Pie $7",
            "    Ice Cream $5",
            "  Drinks",
            "    Hot Drinks",
            "      Coffee $3",
            "      Tea $3",
            "    Cold Drinks",
            "      Lemonade $4");
        assertEquals(expected, Menus.menuLines(SampleMenu.dinner()),
            "Not yet: every section and dish, 20 lines, each level two spaces deeper.");
    }

    @Test
    void menuLinesForASectionWithNothingInside() {
        assertEquals(List.of("Specials"), Menus.menuLines(empty("Specials")),
            "Not yet: a section with nothing in it is one line: its name.");
    }

    @Test
    void aMenuTenSectionsDeep() {
        MenuSection menu = tenDeep();
        assertEquals(10, Menus.countItems(menu), "Not yet: the tasting menu is ten sections deep, with one dish in each: 10 dishes.");
        MenuItem priciest = Menus.mostExpensive(menu);
        assertNotNull(priciest, "Not yet: Bite 10, $10, is in Course 10, nine sections down, and it's the priciest.");
        assertEquals("Bite 10", priciest.name(), "Not yet: Bite 10, $10, is in Course 10, nine sections down, and it's the priciest.");
        List<String> lines = Menus.menuLines(menu);
        assertEquals(20, lines.size(), "Not yet: the tasting menu is 20 lines, and its last, Bite 10 $10, is 20 spaces in.");
        assertEquals(" ".repeat(20) + "Bite 10 $10", lines.get(lines.size() - 1), "Not yet: the tasting menu is 20 lines, and its last, Bite 10 $10, is 20 spaces in.");
    }
}
