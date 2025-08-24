import os
import re
import csv

def calculate_checksum(record):
    """Calculate checksum based on the characters in the record."""
    cap = len(re.findall(r'[A-Z]', record))
    low = len(re.findall(r'[a-z]', record))
    num = len(re.findall(r'[0-9.]', record))
    return cap + low + num

def generate_csv(items, filename="data/transactions/tax_file.csv"):
    """Generate CSV file with checksum at the end."""
    os.makedirs("data/transactions", exist_ok=True)
    with open(filename, "w", newline='') as f:
        writer = csv.writer(f)
        # Writing header for CSV
        writer.writerow(["item_code", "internal_price", "discount", "sale_price", "quantity", "checksum"])
        for item in items:
            # Create CSV line for each item
            line = [item["item_code"], item["internal_price"], item["discount"], item["sale_price"], item["quantity"]]
            # Calculate checksum for the line
            checksum = calculate_checksum(','.join(map(str, line)))
            # Append checksum to the line and write to CSV
            writer.writerow(line + [checksum])

def generate_tax_file(items):
    """Generates a tax file in CSV format."""
    generate_csv(items)
