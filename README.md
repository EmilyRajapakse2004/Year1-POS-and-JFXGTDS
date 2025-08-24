# Point of Sale (POS) & Government Tax Department System (JFXGTDS)

## 📌 Project Overview
This project implements two systems:  
1. A **Point of Sale (POS)** system in **Python** for a self-employed cake maker to manage sales and generate tax files.  
2. A **Government Tax Department System (JFXGTDS)** in **JavaFX**, which imports and validates tax files, calculates profit/loss, and computes final tax values.  

The systems are interoperable using **shared structured text files** (CSV, TSV, JSON, XML) with checksum validation.

---

## 🎯 Learning Outcomes Achieved
- Applied **fundamental programming concepts** in Python and Java.  
- Implemented **object-oriented principles** using class diagrams and modular design.  
- Developed **menu-driven command line applications** (Python, Java).  
- Enhanced a functionality with **JavaFX GUI (WIMP principles)**.  
- Achieved **interoperability** via shared structured text files.  
- Improved **source code version control** with Git & GitHub.  
- Designed and executed **test cases** (desk checking + JUnit tests).  
- Produced a **technical report** with flowcharts, class diagrams, and test cases.  

---

## ⚙️ System Requirements
- **Python** `>=3.9` (developed in PyCharm IDE)  
- **Java JDK** `>=17` (developed in IntelliJ IDEA)  
- **JavaFX SDK** (for GUI)  
- **JUnit 5** (for unit testing Java)  
- **GitHub (Private Repo)** for version control  

---

## 📂 Repository Structure
├── python_pos/ # Python POS system

├── java_jfxgtds/ # JavaFX Government Tax Department System

├── diagrams/ # Flowcharts and class diagrams

├── screenshots/ # Screenshots (included in report, not required in README)

├── testcases/ # Desk-checking and test cases

├── report.pdf # Technical Report

└── README.md

---

## 🛒 Python POS System Features
- Add, delete, update items in basket.  
- Generate bills with grand total and bill number.  
- Search bills by bill number.  
- Generate structured **tax transaction files** (CSV, TSV, JSON, XML).  
- Append **checksum** to each record.  

---

## 🏛 JFXGTDS Features
- Import tax transaction file.  
- Display imported records.  
- Validate checksum, detect invalid item codes/special characters, and negative values.  
- Edit or delete invalid records.  
- Calculate **profit/loss** per transaction.  
- Delete transactions with zero profit.  
- Calculate **final tax** with manager-defined rate.  

---

## 🔐 Version Control
- All source code was managed in a **private GitHub repository**.  
- Repository access was granted to module staff.  
- Git operations included branching, committing, and pushing code.  

---

## 🧪 Testing
- **POS System** → Desk-check test case documented in report.  
- **JFXGTDS** → Automated **JUnit tests** for checksum validation and profit calculations.  

---

## 📊 Diagrams
- **Flowchart (POS)** → Item addition to tax file generation.  
- **Flowchart (JFXGTDS)** → Import tax file to final tax calculation.  
- **Class Diagram (JFXGTDS)** → Shows OOP design principles.  

---

## 📑 References
- Newswire (2025). *Budget 2025: Live updates.*  
- Reuters (2025). *Sri Lanka scrambles to restore power after monkey causes island wide outage.*  
- Wikipedia (2020). *Checksum.*  

---

## 🤖 Generative AI Usage
- This project was primarily developed manually.  
- If any AI assistance was used, the **tool name, version, and useful prompts** are documented in the report.  

---

## 🚀 How to Run
### Python POS
```bash
cd python_pos
python pos_main.py
```

###JavaFX Government Tax Department System
```bash
cd java_jfxgtds
# Open in IntelliJ IDEA
# Configure JavaFX SDK path
# Run Main.java
```

Author: Lidiya Rajapakse

Module: Programming Coursework

Date Created: August 2025