from basket import Basket
from bill_manager import BillManager
from tax_file_generator import generate_tax_file

basket = Basket()
manager = BillManager()

def print_items():
    items = basket.view_items()
    if not items:
        print("Basket is empty.")
    else:
        for item in items:
            print(item)

def main():
    while True:
        print("\n--- POS Menu ---")
        print("1. Add Item\n2. Delete Item\n3. Update Item\n4. View Basket")
        print("5. Generate Bill\n6. Search Bill\n7. Generate Tax File\n8. Exit")

        choice = input("Choose: ")

        if choice == "1":
            code = input("Item Code: ")
            ip = float(input("Internal Price: "))
            disc = float(input("Discount: "))
            sp = float(input("Sale Price: "))
            qty = int(input("Quantity: "))
            basket.add_item(code, ip, disc, sp, qty)
            print(f"Item added: {code}, Price: {sp}, Quantity: {qty}, Total: {sp * qty}")

        elif choice == "2":
            ln = int(input("Line Number to delete: "))
            basket.delete_item(ln)
            print(f"Item at line {ln} has been deleted.")

        elif choice == "3":
            ln = int(input("Line Number to update: "))
            sp = float(input("New Sale Price: "))
            disc = float(input("New Discount: "))
            qty = int(input("New Quantity: "))
            basket.update_item(ln, sp, disc, qty)
            print(f"Item at line {ln} updated: New Price: {sp}, New Discount: {disc}, New Quantity: {qty}")

        elif choice == "4":
            print_items()

        elif choice == "5":
            items = basket.view_items()
            if not items:
                print("Basket is empty.")
                continue
            bill_no = manager.save_bill(items)
            print(f"Bill Generated. Bill No: {bill_no}")
            basket.clear()

        elif choice == "6":
            bn = input("Enter Bill Number: ")
            bill = manager.search_bill(bn)
            if bill:
                for item in bill:
                    print(item)
            else:
                print("Bill not found.")

        elif choice == "7":
            items = basket.view_items()
            print(f"Items in basket: {items}")  # Debugging line
            if not items:
                print("No items to export.")
                continue
            generate_tax_file(items)
            print("Tax file generated in CSV format.")

        elif choice == "8":
            break

if __name__ == "__main__":
    main()
