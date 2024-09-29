# LinearProgramming Java Program

## Overview

This Java program implements a basic **Linear Programming** (LP) solver that converts a given problem into **Standard Form**. It processes objective functions and constraints, adding **slack variables** where needed, to create a new equivalent LP problem that can be used for solving with standard linear programming algorithms (like the Simplex method).

### Key Components:
1. **Objective Function:** Represents the function to be maximized or minimized (e.g., profit, cost).
2. **Constraints:** Linear inequalities or equations that restrict the values of the decision variables.
3. **Slack Variables:** Introduced to convert inequalities into equalities, allowing the constraints to be handled in standard form.

## How It Works

### 1. Input
- **Objective Function Coefficients:** A vector of coefficients that represent the objective function.
- **Constraint Coefficients:** A matrix where each row represents a constraint, with the last element in each row being the right-hand side of the constraint.
- **Constraint Bounds:** The right-hand side values of the constraints (these are extracted from the input matrix).

### 2. Conversion to Standard Form
The program performs the following:
- **Count Slack Variables:** Determines how many slack variables are needed to transform inequality constraints into equalities.
- **Initialize New Coefficients:** Sets up new arrays for the objective function and constraints, expanding them to accommodate slack variables.
- **Add Slack Variables:** Adds slack variables to the constraints to ensure that each constraint can be represented as an equation.

### 3. Output
The program outputs:
- The new **Objective Function Coefficients**.
- The new **Constraint Coefficients** after slack variables have been added.
- The original **Constraint Bounds**.

## Code Usage

### How to Use:
1. **Initialize Input Values:** Provide the coefficients for the objective function, the constraint matrix, and the constraint bounds.
2. **Invoke Standard Form Conversion:** Call the `convertToStandardForm()` method, which will transform the problem into its standard form by adding slack variables.
3. **Access the Results:** Use `getNewObjectiveCoefficients()` and `getNewConstraintCoefficients()` to retrieve the modified problem structure.

### Example Usage:
```java
double[] objectiveCoefficients = {3, 4};
double[][] constraintCoefficients = {
    {1, 2, 10},
    {2, 1, 8},
    {1, -1, 2}
};
double[] constraintBounds = {10, 8, 2};

LinearProgramming lp = new LinearProgramming(objectiveCoefficients, constraintCoefficients, constraintBounds);
lp.convertToStandardForm();

double[] newObjectiveCoefficients = lp.getNewObjectiveCoefficients();
double[][] newConstraintCoefficients = lp.getNewConstraintCoefficients();

System.out.println("New Objective Coefficients: " + Arrays.toString(newObjectiveCoefficients));
System.out.println("New Constraint Coefficients:");
for (double[] row : newConstraintCoefficients) {
    System.out.println(Arrays.toString(row));
}
```

### Output Example:
```
New Objective Coefficients: [3.0, 4.0, 0.0, 0.0]
New Constraint Coefficients:
[1.0, 2.0, 1.0, 0.0]
[2.0, 1.0, 0.0, 1.0]
[1.0, -1.0, 0.0, 1.0]
Constraint Bounds: [10.0, 8.0, 2.0]
```

## Requirements

- **Java SDK**: The program is written in Java, so you'll need the Java Development Kit (JDK) installed to compile and run the program.
  
### Compilation and Execution
To compile and run the program:

```bash
javac LinearProgramming.java
java LinearProgramming
```

## Sources and References

1. **Linear Programming Concepts:**
   - [Linear Programming on Wikipedia](https://en.wikipedia.org/wiki/Linear_programming)
   - [Standard Form in Linear Programming](https://math.libretexts.org/Bookshelves/Applied_Mathematics/Linear_Programming)
  
2. **Slack Variables:**
   - [Slack and Surplus Variables in Linear Programming](https://www.studysmarter.co.uk/explanations/math/linear-programming/slack-and-surplus-variables/)

3. **Java Array Handling:**
   - [Java Arrays Documentation](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)

## License
This project is free and open-source software. You can redistribute it and/or modify it under the terms of the MIT License. For more details, see the LICENSE file.

--- 
This README provides an overview of the project, usage instructions, code examples, and references to help you understand and extend the code.
