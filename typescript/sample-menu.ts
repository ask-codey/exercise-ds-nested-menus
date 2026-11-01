import type { MenuSection } from "./menu.ts";

// The restaurant's dinner menu, used by the demo and the tests. You don't need to change this.
// Each dish is { name, price }; each section is { name, items, sections }.
export function dinner(): MenuSection {
  return {
    name: "Dinner Menu",
    items: [],
    sections: [
      { name: "Starters", items: [{ name: "Garlic Bread", price: 6 }, { name: "Soup of the Day", price: 7 }], sections: [] },
      {
        name: "Mains",
        items: [],
        sections: [
          { name: "Pasta", items: [{ name: "Spaghetti", price: 14 }, { name: "Lasagna", price: 16 }], sections: [] },
          { name: "Grill", items: [{ name: "Burger", price: 13 }, { name: "Grilled Salmon", price: 19 }], sections: [] },
        ],
      },
      { name: "Desserts", items: [{ name: "Apple Pie", price: 7 }, { name: "Ice Cream", price: 5 }], sections: [] },
      {
        name: "Drinks",
        items: [],
        sections: [
          { name: "Hot Drinks", items: [{ name: "Coffee", price: 3 }, { name: "Tea", price: 3 }], sections: [] },
          { name: "Cold Drinks", items: [{ name: "Lemonade", price: 4 }], sections: [] },
        ],
      },
    ],
  };
}
