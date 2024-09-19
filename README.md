# Flexible Calculator

- Welcome to my flexible calculator built with Java and Spring Boot!
    - Supports addition, subtraction, multiplication, and division.
    - Allows you to chain multiple operations starting from an initial value, just like a standard calculator.
    - Designed to be easily extendable by implementing each operation as a separate strategy class.
        - You can add new operations without modifying existing code.
    - Uses dependency injection to manage operation strategies.
        - Fully compatible with Inversion of Control (IoC) frameworks like Spring.

**Design Decisions and Assumptions:**

- Chose the Strategy Pattern for handling operations to enhance extensibility and maintainability.
- Operates on `Number` objects using double precision (`doubleValue()`), ensuring accurate calculations.
- Implemented error handling to gracefully manage:
    - Dividing by zero.
    - Unsupported operations.
- Assumed it's acceptable to modify the `Operation` enum to add new operations.
- Designed the calculator for single-threaded use.
- Included unit tests covering:
    - Typical scenarios.
    - Edge cases.
- Ensures the calculator runs smoothly.
# Calcuator
