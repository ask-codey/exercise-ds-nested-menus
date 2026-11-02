# The tests for your three functions. You don't need to change this file.
# Each message says what was expected, so a failing test tells you what to look at.
from menu import MenuItem, MenuSection
from menus import count_items, menu_lines, most_expensive
from sample_menu import dinner


def empty(name):
    return MenuSection(name, [], [])


def deep():
    """A dish four sections down: Specials > Chef's Table > Tonight > Truffle Pasta $25."""
    return MenuSection("Specials", [MenuItem("Soup", 8)], [
        MenuSection("Chef's Table", [], [
            MenuSection("Tonight", [MenuItem("Truffle Pasta", 25)], []),
        ]),
    ])


def ten_deep():
    """A tasting menu ten sections deep: Course 1 holds Course 2, and so on down to Course 10. Course n serves Bite n at $n."""
    section = MenuSection("Course 10", [MenuItem("Bite 10", 10)], [])
    for number in range(9, 0, -1):
        section = MenuSection(f"Course {number}", [MenuItem(f"Bite {number}", number)], [section])
    return section


def test_count_items_on_the_dinner_menu():
    assert count_items(dinner()) == 11, "Not yet: the dinner menu has 11 dishes, counting every section inside it."


def test_count_items_in_one_section():
    menu = dinner()
    assert count_items(menu.sections[1]) == 4, "Not yet: Mains holds Pasta and Grill, with 2 dishes each: 4."
    assert count_items(menu.sections[3]) == 3, "Not yet: Drinks holds Hot Drinks (2 dishes) and Cold Drinks (1): 3."


def test_count_items_deep_down_and_in_an_empty_section():
    assert count_items(deep()) == 2, "Not yet: Specials has Soup, and Truffle Pasta two sections further down: 2."
    assert count_items(empty("Specials")) == 0, "Not yet: a section with nothing in it has 0 dishes."


def test_most_expensive_on_the_dinner_menu():
    priciest = most_expensive(dinner())
    assert priciest is not None, "Not yet: the dinner menu's most expensive dish is Grilled Salmon, $19."
    assert priciest.name == "Grilled Salmon", "Not yet: the dinner menu's most expensive dish is Grilled Salmon, $19."
    assert priciest.price == 19, "Not yet: Grilled Salmon costs $19."


def test_most_expensive_finds_a_dish_deep_down():
    priciest = most_expensive(deep())
    assert priciest is not None and priciest.name == "Truffle Pasta", \
        "Not yet: Truffle Pasta, $25, is two sections down, and it's the priciest."


def test_most_expensive_keeps_the_first_of_a_tie():
    priciest = most_expensive(dinner().sections[3].sections[0])
    assert priciest is not None and priciest.name == "Coffee", "Not yet: Coffee and Tea both cost $3, and Coffee comes first."


def test_most_expensive_of_a_section_and_of_an_empty_menu():
    priciest = most_expensive(dinner().sections[3])
    assert priciest is not None and priciest.name == "Lemonade", "Not yet: in Drinks, Lemonade ($4) costs the most."
    assert most_expensive(empty("Specials")) is None, "Not yet: a section with no dishes has no most expensive one: return None."


def test_menu_lines_for_one_section():
    assert menu_lines(dinner().sections[3]) == ["Drinks", "  Hot Drinks", "    Coffee $3", "    Tea $3", "  Cold Drinks", "    Lemonade $4"], \
        "Not yet: Drinks, then its sections two spaces in, then their dishes two spaces further."


def test_menu_lines_for_the_dinner_menu():
    expected = [
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
        "      Lemonade $4",
    ]
    assert menu_lines(dinner()) == expected, "Not yet: every section and dish, 20 lines, each level two spaces deeper."


def test_menu_lines_for_a_section_with_nothing_inside():
    assert menu_lines(empty("Specials")) == ["Specials"], "Not yet: a section with nothing in it is one line: its name."


def test_a_menu_ten_sections_deep():
    menu = ten_deep()
    assert count_items(menu) == 10, "Not yet: the tasting menu is ten sections deep, with one dish in each: 10 dishes."
    priciest = most_expensive(menu)
    assert priciest is not None and priciest.name == "Bite 10", "Not yet: Bite 10, $10, is in Course 10, nine sections down, and it's the priciest."
    lines = menu_lines(menu)
    assert len(lines) == 20 and lines[-1] == " " * 20 + "Bite 10 $10", "Not yet: the tasting menu is 20 lines, and its last, Bite 10 $10, is 20 spaces in."
