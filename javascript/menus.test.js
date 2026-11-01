// The tests for your three functions. You don't need to change this file.
// Each message says what was expected, so a failing test tells you what to look at.
import assert from "node:assert/strict";
import { test } from "node:test";
import { countItems, menuLines, mostExpensive } from "./menus.js";
import { dinner } from "./sample-menu.js";

function empty(name) {
  return { name, items: [], sections: [] };
}

// A dish four sections down: Specials > Chef's Table > Tonight > Truffle Pasta $25.
function deep() {
  return {
    name: "Specials",
    items: [{ name: "Soup", price: 8 }],
    sections: [
      { name: "Chef's Table", items: [], sections: [
        { name: "Tonight", items: [{ name: "Truffle Pasta", price: 25 }], sections: [] },
      ] },
    ],
  };
}

test("count items on the dinner menu", () => {
  assert.equal(countItems(dinner()), 11, "Not yet: the dinner menu has 11 dishes, counting every section inside it.");
});

test("count items in one section", () => {
  const menu = dinner();
  assert.equal(countItems(menu.sections[1]), 4, "Not yet: Mains holds Pasta and Grill, with 2 dishes each: 4.");
  assert.equal(countItems(menu.sections[3]), 3, "Not yet: Drinks holds Hot Drinks (2 dishes) and Cold Drinks (1): 3.");
});

test("count items deep down and in an empty section", () => {
  assert.equal(countItems(deep()), 2, "Not yet: Specials has Soup, and Truffle Pasta two sections further down: 2.");
  assert.equal(countItems(empty("Specials")), 0, "Not yet: a section with nothing in it has 0 dishes.");
});

test("most expensive on the dinner menu", () => {
  const priciest = mostExpensive(dinner());
  assert.equal(priciest?.name, "Grilled Salmon", "Not yet: the dinner menu's most expensive dish is Grilled Salmon, $19.");
  assert.equal(priciest?.price, 19, "Not yet: Grilled Salmon costs $19.");
});

test("most expensive finds a dish deep down", () => {
  assert.equal(mostExpensive(deep())?.name, "Truffle Pasta", "Not yet: Truffle Pasta, $25, is two sections down, and it's the priciest.");
});

test("most expensive keeps the first of a tie", () => {
  assert.equal(mostExpensive(dinner().sections[3].sections[0])?.name, "Coffee", "Not yet: Coffee and Tea both cost $3, and Coffee comes first.");
});

test("most expensive of a section and of an empty menu", () => {
  assert.equal(mostExpensive(dinner().sections[3])?.name, "Lemonade", "Not yet: in Drinks, Lemonade ($4) costs the most.");
  assert.equal(mostExpensive(empty("Specials")), null, "Not yet: a section with no dishes has no most expensive one: return null.");
});

test("menu lines for one section", () => {
  assert.deepEqual(menuLines(dinner().sections[3]), ["Drinks", "  Hot Drinks", "    Coffee $3", "    Tea $3", "  Cold Drinks", "    Lemonade $4"],
    "Not yet: Drinks, then its sections two spaces in, then their dishes two spaces further.");
});

test("menu lines for the dinner menu", () => {
  const expected = [
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
  ];
  assert.deepEqual(menuLines(dinner()), expected, "Not yet: every section and dish, 20 lines, each level two spaces deeper.");
});

test("menu lines for a section with nothing inside", () => {
  assert.deepEqual(menuLines(empty("Specials")), ["Specials"], "Not yet: a section with nothing in it is one line: its name.");
});
