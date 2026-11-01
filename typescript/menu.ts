// A dish on the menu, with its price in whole dollars, and a section of the
// menu: its name, its own dishes, and the sections inside it.
// You don't need to change these.
export type MenuItem = { name: string; price: number };
export type MenuSection = { name: string; items: MenuItem[]; sections: MenuSection[] };
