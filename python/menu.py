# A dish on the menu, with its price in whole dollars, and a section of the
# menu: its name, its own dishes, and the sections inside it.
# You don't need to change these.
from dataclasses import dataclass


@dataclass
class MenuItem:
    name: str
    price: int


@dataclass
class MenuSection:
    name: str
    items: list
    sections: list
