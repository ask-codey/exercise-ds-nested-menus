using NestedMenus;

// Tries your methods on the dinner menu. Run it with: dotnet run --project NestedMenus
MenuSection menu = SampleMenu.Dinner();

Console.WriteLine("Dishes on the menu: " + Menus.CountItems(menu));
MenuItem? priciest = Menus.MostExpensive(menu);
Console.WriteLine("Most expensive: " + (priciest == null ? "none" : priciest.Name + " $" + priciest.Price));
foreach (string line in Menus.MenuLines(menu))
{
    Console.WriteLine(line);
}
