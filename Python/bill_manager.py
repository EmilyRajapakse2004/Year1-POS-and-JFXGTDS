import json
import os
import uuid

class BillManager:
    def __init__(self):
        os.makedirs("data", exist_ok=True)
        self.file_path = "data/bills.json"
        if not os.path.exists(self.file_path):
            with open(self.file_path, "w") as f:
                json.dump({}, f)

    def save_bill(self, items):
        bill_no = str(uuid.uuid4())[:8]
        with open(self.file_path, "r") as f:
            bills = json.load(f)
        bills[bill_no] = items
        with open(self.file_path, "w") as f:
            json.dump(bills, f, indent=2)
        return bill_no

    def search_bill(self, bill_no):
        with open(self.file_path, "r") as f:
            bills = json.load(f)
        return bills.get(bill_no, None)
