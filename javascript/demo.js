// Tries your functions on the dinner menu. Run it with: node demo.js
import { countItems, menuLines, mostExpensive } from "./menus.js";
import { dinner } from "./sample-menu.js";

const menu = dinner();

console.log(`Dishes on the menu: ${countItems(menu)}`);
const priciest = mostExpensive(menu);
console.log(`Most expensive: ${priciest === null ? "none" : `${priciest.name} $${priciest.price}`}`);
for (const line of menuLines(menu)) {
  console.log(line);
}
