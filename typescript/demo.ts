// Tries your functions on the dinner menu. Run it with: node demo.ts
import { countItems, menuLines, mostExpensive } from "./menus.ts";
import { dinner } from "./sample-menu.ts";

const menu = dinner();

console.log(`Dishes on the menu: ${countItems(menu)}`);
const priciest = mostExpensive(menu);
console.log(`Most expensive: ${priciest === null ? "none" : `${priciest.name} $${priciest.price}`}`);
for (const line of menuLines(menu)) {
  console.log(line);
}
