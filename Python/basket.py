class Basket:
    def __init__(self):
        self.items = []
        self.counter = 1

    def add_item(self, item_code, internal_price, discount, sale_price, quantity):
        line_total = sale_price * quantity
        item = {
            "line_no": self.counter,
            "item_code": item_code,
            "internal_price": internal_price,
            "discount": discount,
            "sale_price": sale_price,
            "quantity": quantity,
            "line_total": line_total
        }
        self.items.append(item)
        self.counter += 1
        print(f"Item added: {item}")

    def delete_item(self, line_no):
        self.items = [i for i in self.items if i["line_no"] != line_no]

    def update_item(self, line_no, sale_price, discount, quantity):
        for item in self.items:
            if item["line_no"] == line_no:
                item["sale_price"] = sale_price
                item["discount"] = discount
                item["quantity"] = quantity
                item["line_total"] = sale_price * quantity
                break

    def view_items(self):
        return self.items

    def clear(self):
        self.items = []
        self.counter = 1
