<div align="center">

# 🎓 Campus-Barter
**A Virtual Credit-Based Campus Marketplace (CLI)**

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen?style=for-the-badge)
![Platform](https://img.shields.io/badge/Platform-Windows%20%7C%20macOS%20%7C%20Linux-lightgrey?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

*A "Bring Your Own Project" (BYOP) Submission for Programming in JAVA*

</div>

---

## 📖 About The Project
**Campus-Barter** is a lightweight, pure-Java command-line application designed to serve as a localized, peer-to-peer marketplace for university students. 

Instead of spending real money, users trade academic resources (textbooks, reference materials, handwritten notes) using a self-contained virtual economy. Users start with a base balance of "credits" and earn more by selling their old materials, which they can then spend to acquire what they need for the current semester.

## 🤔 The Problem & Our Solution
**The Need:** Acquiring textbooks and quality notes every semester is a massive financial burden for students. Traditional buying/selling is inefficient, and coordinating direct 1-to-1 trades is nearly impossible because it requires finding someone who wants *exactly* what you have.

**The Solution:** Campus-Barter abstracts the trading process using a centralized virtual credit system. 
* **Benefits for Sellers:** Easily offload unneeded study materials and gain campus credits.
* **Benefits for Buyers:** Acquire necessary materials instantly without spending out-of-pocket cash.
* **Benefits for the Campus:** Promotes a circular, sustainable economy and equalizes access to educational resources.

---

## ✨ Key Features
* **Virtual Credit System:** Frictionless trading using an internal economy (prevents negative balances).
* **Dynamic Marketplace:** Instantly list items, browse available inventory, and execute purchases.
* **Data Persistence:** Automatic saving and loading of user balances and marketplace listings via CSV files—no database required.
* **Resilient CLI:** Built-in exception handling to prevent crashes from accidental keystrokes.

---

## 🧠 Java Concepts Applied (BYOP Alignment)
This project was built to actively demonstrate core concepts learned in the "Programming in JAVA" course:

1.  **Object-Oriented Programming (OOP):** Deep use of Encapsulation (protecting user credit balances with `private` modifiers) and class modeling (`User`, `Item`).
2.  **Java Collections Framework:** Utilizes `HashMap<String, User>` for instant O(1) user lookups and `ArrayList<Item>` for managing dynamic marketplace inventory.
3.  **File I/O:** Uses `BufferedReader`, `PrintWriter`, `FileReader`, and `FileWriter` to serialize object states into `.csv` files for persistent storage.
4.  **Exception Handling:** Employs `try-catch` blocks to gracefully handle `InputMismatchException` and `IOException` during user input and file generation.

---

## 🏗️ Project Architecture & File Structure
The system is highly modular, split across four interconnected Java classes:

```text
📦 Campus-Barter
 ┣ 📜 Main.java           # Entry point: Handles the Scanner loop, CLI menu, and Exception catching.
 ┣ 📜 Marketplace.java    # The Engine: Manages the HashMaps/ArrayLists, transaction logic, and File I/O.
 ┣ 📜 User.java           # Data Model: Encapsulates user credentials and credit deduction/addition math.
 ┣ 📜 Item.java           # Data Model: Encapsulates item ID, title, price, and seller information.
 ┣ 📜 users.csv           # (Auto-generated) Stores persistent user data and balances.
 ┣ 📜 items.csv           # (Auto-generated) Stores persistent marketplace listings.
 ┗ 📜 README.md           # Project documentation.
```

### How It Ties Together:
* The user launches `Main.java`, which immediately instantiates the `Marketplace` object.
* `Marketplace` attempts to read `users.csv` and `items.csv`, populating its internal HashMap and ArrayList with `User` and `Item` objects.
* When a transaction occurs in the CLI, `Main` calls `market.buyItem()`.
* The `Marketplace` validates the logic, interacts with the specific `User` object to deduct credits, and removes the `Item` from the list.
* Upon exiting, `Marketplace.saveData()` writes the updated memory states back to the CSV files.

---

## 🚀 Getting Started
To run this project locally, ensure you have the Java Development Kit (JDK) installed on your machine.

### Prerequisites
* Java JDK 8 or higher.
* A terminal / command prompt.

### Installation & Compilation

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/yourusername/Campus-Barter.git](https://github.com/yourusername/Campus-Barter.git)
    cd Campus-Barter
    ```

2.  **Compile the Java files:**
    ```bash
    javac *.java
    ```

3.  **Run the application:**
    ```bash
    java Main
    ```
    *(Note: On your very first run, the system will inform you that no existing data was found. It will automatically generate `users.csv` and `items.csv` upon a safe exit).*

---

## 💻 Usage Guide
* **Login/Registration:** Upon launching, enter a username. If you are a new user, the system will automatically register you and grant you 100 starting credits.
* **Browsing:** Select `1` from the main menu to view all active items currently for sale by other students.
* **Selling:** Select `2`, provide a title (e.g., "Data Structures Textbook") and set a credit price. The item is now live.
* **Buying:** Select `3` and type the exact `ITEM_ID` you wish to purchase. If you have enough credits, the item is transferred, and your balance updates.
* **Safe Exit:** Always exit the application using option `5` to ensure your transactions are safely written to the local CSV files.

---

## 📜 License & Acknowledgments
* **Author:** Manav Tiwari
* **Course:** Programming in JAVA
* **Institution:** VIT Bhopal University

