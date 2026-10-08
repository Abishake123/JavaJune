# Practice Set 2: Methods, Classes & Objects (Instances)

Finish [Practice Set 1](01-IfElse-Loops.md) first. This set teaches you to break code into **methods**
and to model real things with **classes** and **objects**.

**Quick refresher**
```java
class Student {                 // class = blueprint
    String name;                // field (data each object has)
    int marks;

    Student(String name, int marks) {   // constructor = runs when you do "new"
        this.name = name;
        this.marks = marks;
    }

    void display() {            // method = behaviour
        System.out.println(name + " scored " + marks);
    }
}

Student s1 = new Student("Ravi", 85);   // s1 is an object / instance
s1.display();
```

---

## Part A: Methods (static methods in the same class)

Write each as a **method** and call it from `main` with a few different values.

**A1. Greet**
`void greet(String name)` prints `Hello, <name>!`

**A2. Add Two Numbers**
`int add(int a, int b)` **returns** the sum. Print the result in `main`.
*Notice the difference: A1 prints, A2 returns.*

**A3. Square and Cube**
`int square(int n)` and `int cube(int n)`

**A4. Is Even**
`boolean isEven(int n)` returns `true`/`false`. Use it in `main` with an if-else.

**A5. Max of Three**
`int max(int a, int b, int c)`

**A6. Area Methods**
- `double circleArea(double r)` → πr² (use `Math.PI`)
- `int rectangleArea(int length, int width)`

**A7. Celsius to Fahrenheit**
`double toFahrenheit(double c)` → `c * 9 / 5 + 32`

**A8. Reuse Your Set 1 Answers as Methods**
Turn these into methods:
- `int factorial(int n)`
- `boolean isPrime(int n)`
- `int reverse(int n)`
- `void printTable(int n)`

Then in `main`, use `isPrime` inside a loop to print all primes from 1 to 50.
*See how much cleaner it looks?*

**A9. Array Methods**
- `int sum(int[] arr)`
- `double average(int[] arr)`, which **calls `sum` inside it**
- `int findMax(int[] arr)`

**A10. Method Overloading**
Write three methods all named `add`:
- `add(int a, int b)`
- `add(int a, int b, int c)`
- `add(double a, double b)`

Call all three and see how Java picks the right one.

---

## Part B: Classes & Objects

**B1. Student**
Create a class `Student` with `name`, `rollNo`, and `marks`.
- Create **3 student objects** in `main` and set their values
- Print each student's details

**B2. Add a Constructor**
Rewrite B1 so the values are set through a constructor:
`new Student("Ravi", 1, 85)`

**B3. Add a Method**
Add `void display()` to `Student`, which prints the details.
Add `String getGrade()`, which returns the grade (reuse your Set 1 grade logic!).

**B4. Rectangle**
Class `Rectangle` with `length` and `width`.
- Methods: `int area()` and `int perimeter()`
- Create 2 rectangles of different sizes and print both results for each

**B5. Bank Account** 🏦
Class `BankAccount` with `accountHolder` and `balance`.
- `void deposit(double amount)`
- `void withdraw(double amount)` prints `Insufficient balance` if amount > balance
- `void showBalance()`

Create an account, deposit 5000, withdraw 2000, then try to withdraw 10000.

**B6. Two Objects Are Independent**
Using `BankAccount`, create `acc1` and `acc2`. Deposit only into `acc1`.
Print both balances.
*Question:* why didn't `acc2` change? Write the answer as a comment in your code.

**B7. Car**
Class `Car` with `brand`, `model`, and `speed` (starts at 0).
- `void accelerate()` → speed += 10
- `void brake()` → speed -= 10, but never below 0
- `void showSpeed()`

**B8. Counter with `static`**
Class `Student` with a `static int count`. Increase `count` in the constructor.
Create 4 students and print `Student.count`.
*Question:* why is `count` shared, but `name` is not?

**B9. Array of Objects**
Create `Student[] students` with 5 students. Using a for loop:
- print all students
- find and print the **topper** (highest marks)
- print the class average

**B10. Library Book** 📚
Class `Book` with `title`, `author`, and `isIssued` (boolean).
- `void issue()` prints `Already issued` if it's already issued, else marks it issued
- `void returnBook()`
- `void display()` shows title, author, and `Available` / `Issued`

---

## Part C: Mini Projects (combine everything)

**C1. Shopping Cart** 🛒
- Class `Product` with `name`, `price`, and `quantity`
- Method `double total()` → price × quantity
- In `main`, create an array of 4 products and print a bill:
```
Pen        x 3   = 30.0
Notebook   x 2   = 120.0
...
Grand Total      = 450.0
```
- Bonus: if the grand total is above 500, apply a 10% discount

**C2. Employee Salary**
Class `Employee` with `name` and `basicSalary`.
- `double hra()` → 20% of basic
- `double da()` → 10% of basic
- `double grossSalary()` → basic + hra + da
- Create 3 employees and print a salary slip for each

**C3. Simple Quiz** ❓
Class `Question` with `text`, `answer` (String), and a method `boolean check(String userAnswer)`.
Create 5 questions in an array, ask each one with `Scanner`, and print the final score.

---

## Self-check: can you answer these in your own words?

1. What's the difference between a **class** and an **object**?
2. What does the `new` keyword do?
3. What's the difference between a method that **returns** a value and one that just **prints**?
4. What's a **constructor**? How is it different from a normal method?
5. What does `this.name = name;` mean?
6. What's the difference between a **static** field and an **instance** field?
7. Why do we use methods instead of writing everything in `main`?

Happy coding! 🚀
