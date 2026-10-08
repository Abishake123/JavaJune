# Practice Set 1: if-else, for loop, and both together

These questions are for **absolute beginners**. Do them in order, because each one builds on the one before.

**How to practise**
- Create one `.java` file per question (e.g. `Q1.java`) and write everything inside `main`.
- At first, just store the input in a variable (`int age = 20;`). Once you're comfortable, try reading it with `Scanner`.
- Run your program with different values to check every branch.
- Don't copy from the internet. Struggling a little is how you learn 💪

---

## Part A: if-else

**A1. Positive or Negative**
Given a number, print `Positive`, `Negative`, or `Zero`.
```
Input: -5   ->  Output: Negative
```

**A2. Even or Odd**
Given a number, print whether it is `Even` or `Odd`.
*Hint:* use `%` (remainder).
```
Input: 7    ->  Output: Odd
```

**A3. Voting Eligibility**
Given a person's age, print `Eligible to vote` if age is 18 or above, otherwise `Not eligible`.

**A4. Bigger of Two**
Given two numbers `a` and `b`, print the bigger one. If they are equal, print `Both are equal`.

**A5. Biggest of Three**
Given three numbers, print the biggest.
```
Input: 12, 45, 30  ->  Output: 45
```

**A6. Grade Calculator**
Given a mark (0–100), print the grade:

| Marks   | Grade |
|---------|-------|
| 90–100  | A     |
| 75–89   | B     |
| 50–74   | C     |
| 35–49   | D     |
| below 35| Fail  |

Bonus: print `Invalid mark` if the number is below 0 or above 100.

**A7. Leap Year**
A year is a leap year if it's divisible by 4, **except** years divisible by 100, which must also be divisible by 400.
```
2024 -> Leap year
1900 -> Not a leap year
2000 -> Leap year
```

**A8. Vowel or Consonant**
Given a `char`, print `Vowel` if it is a, e, i, o, u (small or capital), else `Consonant`.

**A9. Simple Calculator**
Given two numbers and an operator `char` (`+`, `-`, `*`, `/`), print the result.
Print `Cannot divide by zero` if the operator is `/` and the second number is 0.
*Try it with `switch` too.*

**A10. Electricity Bill**
Calculate the bill from the units used:
- First 100 units → ₹2 per unit
- Next 100 units (101–200) → ₹3 per unit
- Above 200 units → ₹5 per unit
```
Input: 250 units  ->  100*2 + 100*3 + 50*5 = ₹750
```

---

## Part B: for loop

**B1. Print 1 to 10**
Print the numbers from 1 to 10, one per line.

**B2. Print 10 to 1**
Print the numbers from 10 down to 1.

**B3. Multiplication Table**
Given `n`, print its table up to 10.
```
5 x 1 = 5
5 x 2 = 10
...
5 x 10 = 50
```

**B4. Sum of 1 to N**
Given `n`, print the sum `1 + 2 + ... + n`.
```
Input: 5  ->  Output: 15
```

**B5. Factorial**
Given `n`, print `n!` (`5! = 5 × 4 × 3 × 2 × 1 = 120`).

**B6. Print Your Name 5 Times**
Use a loop to print your name 5 times, with the count:
```
1. Abi
2. Abi
...
```

**B7. Sum of Array Elements**
Given `int[] nums = {4, 8, 15, 16, 23, 42};`, print the total.

**B8. Count Digits**
Given a number like `98765`, count how many digits it has (answer: 5).
*Hint:* keep dividing by 10.

**B9. Reverse a Number**
`1234` → `4321`

**B10. Fibonacci**
Print the first 10 Fibonacci numbers: `0 1 1 2 3 5 8 13 21 34`

---

## Part C: if-else + for loop together

**C1. Even Numbers from 1 to 20**
Loop from 1 to 20 and print only the even numbers.

**C2. Count Even and Odd**
From `int[] nums = {3, 8, 11, 20, 7, 14};`, count how many are even and how many are odd.
```
Even: 3, Odd: 3
```

**C3. FizzBuzz** ⭐ (a classic interview question)
Print 1 to 30. But:
- if divisible by 3 → print `Fizz`
- if divisible by 5 → print `Buzz`
- if divisible by both 3 and 5 → print `FizzBuzz`
- otherwise print the number

**C4. Largest in an Array**
Find the largest number in `int[] nums = {12, 45, 2, 67, 34};` **without** using any built-in sort.

**C5. Smallest and Largest**
Same array: print both the smallest and the largest in **one** loop.

**C6. Prime Check**
Given `n`, print `Prime` or `Not Prime`.
*A prime has exactly 2 factors: 1 and itself.*

**C7. All Primes from 1 to 50**
Print all prime numbers between 1 and 50.

**C8. Pass / Fail Report**
Given `int[] marks = {78, 32, 55, 90, 20, 66};`:
- print `Student 1: Pass` or `Student 1: Fail` for each mark (pass mark = 35)
- at the end, print the total number of students who passed and failed

**C9. Palindrome Number**
Check whether a number reads the same backwards: `121` → Palindrome, `123` → Not.

**C10. Armstrong Number**
`153 = 1³ + 5³ + 3³`, so 153 is an Armstrong number. Check whether a given 3-digit number is one.
Bonus: print all Armstrong numbers from 100 to 999.

**C11. Count Vowels in a Word**
Given `String word = "programming";`, count the vowels.
*Hint:* `word.charAt(i)` gives you each character.

**C12. Number Guessing (mini game)** 🎮
Store a secret number (e.g. 7). Give the user 3 chances, using `Scanner` inside a for loop.
- if guess is correct → print `You win!` and stop the loop (`break`)
- if guess is too high/low → print `Too high` / `Too low`
- after 3 wrong tries → print `Game over, the number was 7`

---

## Bonus: Patterns (nested for loops)

```
P1          P2          P3            P4
*           *****       1             *
**          ****        12           ***
***         ***         123         *****
****        **          1234       *******
*****       *           12345
```

---

✅ **Done with all of these?** Move on to [Practice Set 2: Methods, Classes & Objects](02-Methods-Classes-Objects.md).
