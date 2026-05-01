# Swiss Re - Employee Analyzer

## Overview

This is a simple Java application that reads employee data from a CSV file and analyzes the organizational structure.

It checks:

* Whether managers are earning within the expected salary range based on their team
* Whether any employee has too many levels between them and the CEO

---

## Approach

The input CSV is first converted into a tree structure using manager relationships.
Once the hierarchy is built, I traverse it using a simple DFS approach to perform both salary and reporting checks.

I kept the logic modular:

* Services handle business logic
* Models represent data
* A separate utility prints results to the console

---

## Assumptions

* The input data is valid and well-formed
* There is only one CEO (no manager)
* Salary comparison is based on direct subordinates only
* Boundary values (20% and 50%) are considered valid

---

## How to Run

* Place `employees.csv` (already included) inside `src/main/resources`
* Run the application using Maven or directly from your IDE

---

## Notes

The focus was to keep the solution simple, readable, and easy to test.
Wherever something was not explicitly defined, I made reasonable assumptions and documented them above.

---

## Author

Aditya Kumar Behera
