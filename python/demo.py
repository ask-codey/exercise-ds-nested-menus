# Tries your functions on the dinner menu. Run it with: python demo.py
from menus import count_items, menu_lines, most_expensive
from sample_menu import dinner

menu = dinner()

print(f"Dishes on the menu: {count_items(menu)}")
priciest = most_expensive(menu)
print("Most expensive: " + ("none" if priciest is None else f"{priciest.name} ${priciest.price}"))
for line in menu_lines(menu):
    print(line)
