using NestedMenus;

namespace NestedMenus.Tests;

// The tests for your three methods. You don't need to change this file.
// Each message says what was expected, so a failing test tells you what to look at.

[TestClass]
public class MenusTests
{
    private static MenuSection Empty(string name) => new MenuSection(name, [], []);

    // A dish four sections down: Specials > Chef's Table > Tonight > Truffle Pasta $25.
    private static MenuSection Deep() => new MenuSection("Specials", [new MenuItem("Soup", 8)], [
        new MenuSection("Chef's Table", [], [
            new MenuSection("Tonight", [new MenuItem("Truffle Pasta", 25)], []),
        ]),
    ]);

    [TestMethod]
    public void CountItemsOnTheDinnerMenu()
    {
        Assert.AreEqual(11, Menus.CountItems(SampleMenu.Dinner()), "Not yet: the dinner menu has 11 dishes, counting every section inside it.");
    }

    [TestMethod]
    public void CountItemsInOneSection()
    {
        MenuSection menu = SampleMenu.Dinner();
        Assert.AreEqual(4, Menus.CountItems(menu.Sections[1]), "Not yet: Mains holds Pasta and Grill, with 2 dishes each: 4.");
        Assert.AreEqual(3, Menus.CountItems(menu.Sections[3]), "Not yet: Drinks holds Hot Drinks (2 dishes) and Cold Drinks (1): 3.");
    }

    [TestMethod]
    public void CountItemsDeepDownAndInAnEmptySection()
    {
        Assert.AreEqual(2, Menus.CountItems(Deep()), "Not yet: Specials has Soup, and Truffle Pasta two sections further down: 2.");
        Assert.AreEqual(0, Menus.CountItems(Empty("Specials")), "Not yet: a section with nothing in it has 0 dishes.");
    }

    [TestMethod]
    public void MostExpensiveOnTheDinnerMenu()
    {
        MenuItem? priciest = Menus.MostExpensive(SampleMenu.Dinner());
        Assert.IsNotNull(priciest, "Not yet: the dinner menu's most expensive dish is Grilled Salmon, $19.");
        Assert.AreEqual("Grilled Salmon", priciest.Name, "Not yet: the dinner menu's most expensive dish is Grilled Salmon, $19.");
        Assert.AreEqual(19, priciest.Price, "Not yet: Grilled Salmon costs $19.");
    }

    [TestMethod]
    public void MostExpensiveFindsADishDeepDown()
    {
        MenuItem? priciest = Menus.MostExpensive(Deep());
        Assert.IsNotNull(priciest, "Not yet: Truffle Pasta, $25, is two sections down, and it's the priciest.");
        Assert.AreEqual("Truffle Pasta", priciest.Name, "Not yet: Truffle Pasta, $25, is two sections down, and it's the priciest.");
    }

    [TestMethod]
    public void MostExpensiveKeepsTheFirstOfATie()
    {
        MenuItem? priciest = Menus.MostExpensive(SampleMenu.Dinner().Sections[3].Sections[0]);
        Assert.IsNotNull(priciest, "Not yet: Coffee and Tea both cost $3, and Coffee comes first.");
        Assert.AreEqual("Coffee", priciest.Name, "Not yet: Coffee and Tea both cost $3, and Coffee comes first.");
    }

    [TestMethod]
    public void MostExpensiveOfASectionAndOfAnEmptyMenu()
    {
        MenuItem? priciest = Menus.MostExpensive(SampleMenu.Dinner().Sections[3]);
        Assert.IsNotNull(priciest, "Not yet: in Drinks, Lemonade ($4) costs the most.");
        Assert.AreEqual("Lemonade", priciest.Name, "Not yet: in Drinks, Lemonade ($4) costs the most.");
        Assert.IsNull(Menus.MostExpensive(Empty("Specials")), "Not yet: a section with no dishes has no most expensive one: return null.");
    }

    [TestMethod]
    public void MenuLinesForOneSection()
    {
        CollectionAssert.AreEqual(new List<string> { "Drinks", "  Hot Drinks", "    Coffee $3", "    Tea $3", "  Cold Drinks", "    Lemonade $4" },
            Menus.MenuLines(SampleMenu.Dinner().Sections[3]),
            "Not yet: Drinks, then its sections two spaces in, then their dishes two spaces further.");
    }

    [TestMethod]
    public void MenuLinesForTheDinnerMenu()
    {
        List<string> expected = new List<string>
        {
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
            "      Lemonade $4"
        };
        CollectionAssert.AreEqual(expected, Menus.MenuLines(SampleMenu.Dinner()),
            "Not yet: every section and dish, 20 lines, each level two spaces deeper.");
    }

    [TestMethod]
    public void MenuLinesForASectionWithNothingInside()
    {
        CollectionAssert.AreEqual(new List<string> { "Specials" }, Menus.MenuLines(Empty("Specials")),
            "Not yet: a section with nothing in it is one line: its name.");
    }
}
