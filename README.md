# Exercise: Menus Inside Menus

Exercise code for the lesson **Exercise: Menus Inside Menus** in the course *Data Structures and Big-O, Demystified* on [ask-codey.com](https://www.ask-codey.com).

A restaurant's menu has sections inside sections: *Mains* holds *Pasta* and *Grill*, and any section can hold more. You'll write three recursive functions that work on a menu of any depth:

- `countItems` (`CountItems` in C#, `count_items` in Python): how many dishes are on the menu, in every section at every level
- `mostExpensive` (`MostExpensive`, `most_expensive`): the priciest dish anywhere on the menu
- `menuLines` (`MenuLines`, `menu_lines`): the menu as lines of text, ready to print, indented two spaces for each level

Each dish is a `MenuItem` with a name and a price in whole dollars. Each section is a `MenuSection` with a name, its own items, and the sections inside it. The sample dinner menu is built in its own file. You don't need to change any of them.

## Pick your language

The same exercise is here in five languages. Work in the folder for the language you set up; you only need one.

| Folder | Your code | The tests | The menu |
|---|---|---|---|
| `csharp/` | `NestedMenus/Menus.cs` | `NestedMenus.Tests/MenusTests.cs` | `NestedMenus/Menu.cs`, `NestedMenus/SampleMenu.cs` |
| `java/` | `src/main/java/Menus.java` | `src/test/java/MenusTest.java` | `MenuItem.java`, `MenuSection.java`, `SampleMenu.java` |
| `python/` | `menus.py` | `test_menus.py` | `menu.py`, `sample_menu.py` |
| `javascript/` | `menus.js` | `menus.test.js` | `sample-menu.js` |
| `typescript/` | `menus.ts` | `menus.test.ts` | `menu.ts`, `sample-menu.ts` |

Each function returns `0`, nothing (`null`, or `None` in Python) or an empty list for now. The comment above it says what it should return, with examples. Replace the `return` line with your own code, and name the function's base case on its **Base case:** line.

Every folder also has a small demo program that tries your functions on the sample dinner menu. You don't need to change the tests or the demo.

## Run it and check your work

Open your language's folder in VS Code (**File > Open Folder**), then open its terminal (**Terminal > New Terminal**) and run these commands there.

**C#**

```bash
dotnet run --project NestedMenus
dotnet test
```

**Java** (the Maven Wrapper downloads Maven the first time, so the first run takes a minute)

```bash
java src/main/java/Demo.java
./mvnw test
```

On Windows in PowerShell, write `.\mvnw test` instead of `./mvnw test`.

**Python** (once: make a virtual environment and install pytest into it)

```bash
python -m venv .venv
```

Then turn it on: `.venv\Scripts\Activate.ps1` in PowerShell on Windows, or `source .venv/bin/activate` on macOS (where the command is `python3`, not `python`). Then:

```bash
pip install -r requirements.txt
python demo.py
python -m pytest
```

**JavaScript**

```bash
node demo.js
npm test
```

**TypeScript** (once: `npm install`, which installs TypeScript)

```bash
node demo.ts
npm test
```

At first every test fails: that is expected. Each function you finish turns its tests green. A failing test's message starts with **Not yet:** and says what it expected.

## Tips

- **One function, one level.** Handle this section's own items, then call the same function for each section inside it, and combine what comes back.
- **The base case hides in the loop.** A section with no sections inside runs its inner loop zero times, so you don't need an `if` for it.
- **`mostExpensive` keeps the first of a tie.** Replace your best dish only when another one costs strictly more, and check a section's own items before its inner sections.
- **For `menuLines`, indent what comes back.** Each line an inner section gives you gets two more spaces in front. (Or pass a `depth` to a helper function of your own: either works.)

## Hand it in

When it works, push your solution to a public repo of your own on GitHub, then paste that repo's address into **Submit your exercise** on the lesson page at [ask-codey.com](https://www.ask-codey.com). That's what completes the lesson. The lesson page shows the Git commands, step by step.

## What's next

You can now walk data of any depth with recursion. Module 4, *Searching and Sorting*, puts it to work: binary search halves a sorted list again and again, and merge sort and quicksort, two of the fastest sorts there are, sort a list by sorting its halves, recursively.
