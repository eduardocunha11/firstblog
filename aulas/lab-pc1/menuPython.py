"""
1. Add a menu to a console application to manage activities.
2. Run a selected function.
3. Clear the output
4. Display the menu again or exit if done is selected
"""

import sys
from os import system


def display_menu(menu):
    """
    Display a menu where the key identifies the name of a function.
    :param menu: dictionary, key identifies a value which is a function name
    :return:
    """
    for k, function in menu.items():
        print(k, function.__name__)


def one():
    print("you have selected menu option one") # Simulate function output.
    input("Press Enter to Continue\n")
    system('cls')  # clears stdout


def two():
    print("you have selected menu option two") # Simulate function output.
    input("Press Enter to Continue\n")
    system('cls')  # clears stdout


def three():
    print("you have selected menu option three") # Simulate function output.
    input("Press Enter to Continue\n")
    system('cls')  # clears stdout


def done():
    system('cls')  # clears stdout
    print("Goodbye")
    sys.exit()


def main():
    # Create a menu dictionary where the key is an integer number and the
    # value is a function name.
    functions_names = [one, two, three, done]
    menu_items = dict(enumerate(functions_names, start=1))

    while True:
        display_menu(menu_items)
        selection = int(
            input("Please enter your selection number: "))  # Get function key
        selected_value = menu_items[selection]  # Gets the function name
        selected_value()  # add parentheses to call the function


if __name__ == "__main__":
    main()