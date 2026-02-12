# Personal Budget Manager 

![Java](https://img.shields.io/badge/Java-JDK%2017-orange)
![Type](https://img.shields.io/badge/type-Console-lightgrey)
![Persistence](https://img.shields.io/badge/storage-CSV%20file-blue)
![OOP](https://img.shields.io/badge/design-OOP-informational)
![Status](https://img.shields.io/badge/status-learning%20project-lightgrey)


A learning-focused console application that manages income and expense records with CSV-based persistence.


A console-based Java application developed as part of my learning process while improving my understanding of fundamental Java concepts, Object-Oriented Programming, file handling, and modular program structure.

This project is not designed to be a production-level budgeting tool.  
Instead, it serves as a practical exercise to help me connect theoretical Java knowledge with real implementation and develop confidence in writing structured code.

---

## Features

- Add income records  
- Add expense records  
- List all stored transactions  
- Display financial summary (total income, total expenses, balance)  
- Persist data in a CSV file  
- Clear or reset all saved data  
- Automatic date assignment for each transaction  
- Clear separation of responsibilities using multiple classes  

---

## Project Structure

The application is organized into three main components:

### 1. Transaction.java  
Represents a single financial entry, containing:  
- ID  
- Date  
- Amount  
- Category  
- Description  
- Income/expense indicator  

Includes formatting and CSV conversion methods.

### 2. BudgetManager.java  
Handles application logic, including:  
- Managing the list of transactions  
- Adding and loading entries  
- Saving data to CSV  
- Clearing all records  
- Providing summary calculations  

### 3. Main.java  
Controls the console-based user interface, menu navigation, and interactive flow.

---

## Case Study: Learning Java Through a Practical Mini-Project

### Overview
This project was developed as a hands-on exercise while learning Java.  
Rather than aiming to introduce a new solution to financial tracking, my goal was simply to understand how different Java concepts work together inside a small application.

It became a simple but meaningful step in my learning journey.

### Why I Built This
As I progressed through Java fundamentals, I wanted a project that would allow me to:

- Apply Object-Oriented Programming concepts  
- Practice splitting responsibilities across multiple classes  
- Learn file I/O and data per
