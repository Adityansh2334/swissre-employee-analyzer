# Swiss Re - Employee Analyzer

## Overview

This is a simple Java application that reads employee data from a CSV file and analyzes the organizational structure.

It checks:

* Whether managers are earning within the expected salary range based on their team
* Whether any employee has too many levels between them and the CEO

---

## Approach

The input CSV is converted into a tree structure using manager relationships.
Once the hierarchy is built, I traverse it using a DFS approach to perform both salary and reporting checks.

The solution is kept modular:

* Services handle business logic
* Models represent data
* A utility class handles console output

Additionally, business rules like salary thresholds and maximum reporting depth are externalized into a separate `config.csv` file, so they can be updated without changing code.

---

## Assumptions

* The input data is valid and well-formed
* There is only one CEO (no manager)
* Salary comparison is based on direct subordinates only
* Boundary values (e.g., 20% and 50%) are considered valid
* Configuration values are provided via `config.csv`, with sensible defaults used if missing

---

## How to Run

* Place `employees.csv` and `config.csv` inside `src/main/resources`
* Run the application using Maven or directly from your IDE

---

## Notes

The focus was to keep the solution simple, readable, and easy to test.
I also made the design slightly flexible by moving key rules to a config file.

Wherever something was not explicitly defined, I made reasonable assumptions and documented them above.

---

## Author

Aditya Kumar Behera
