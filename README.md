# Unit 5: Methods

## Introduction
**Methods**, or **functions**, are blocks of code that can be executed with a single statement. They typically perform a specific action, and allow us to define code once but easily use it many times. \
Programs **call** or **invoke** methods to run the code inside.

Methods may take in values called **arguments** as input, which assigns them to **parameters**, variables inside the method which get arguments. \
Methods may output, or **return**, a single value to the program at the end of the call. So when a method call is evaluated, the return value is the result.

### Table of Contents
- [Introduction](#introduction)
    - [Table of Contents](#table-of-contents)
- [Method Declaration](#method-declaration)
    - [The Main Method](#the-main-method)
- [Method Calls](#method-calls)
- [>Exercise: Book Finder](#exercise-book-finder)
- [Method Overloading](#method-overloading)
- [Debugging](#debugging)
    - [Types of Bugs](#types-of-bugs)
    - [The Debugging Process](#the-debugging-process)
    - [>Exercise: Gamblecore](#exercise-gamblecore)
    - [>Exercise: Factorial Sum](#exercise-factorial-sum)
- [Recap](#recap)
    - [Keyboard Shortcuts](#keyboard-shortcuts)

[Feedback](#feedback) \
[License](#license)

## Method Declaration
Once we declare a method, we can call it and run the code inside as many times as we want.

Declaring a method looks like this:
```
<modifiers> <return_type> <method_name>(<parameters>) {
    // code to be executed
}
```
- The **return type** of the method is the data type of the value the method returns as an output. If the method returns nothing, the return type is `void`.
- The **method name** is the name used to call the method in the program.
- **Modifiers** can be used to specify how the method is to be accessed and called.
- **Parameters** are special variables that take on values that we pass into the method, **arguments**.
- Modifiers and parameters are optional!

If a return type is specified, the method body *must* have **return statement**(s) that return a value of that type. \
```java
return <expression>;
```
The `return` statement also immediately exits the method, so code following it won't get executed. \
A complex `void` method may use bare `return;` statements to exit early before the end of the method block.

Examples!
```java
static int add(int a, int b) {
    return a + b;
}
```
In this example, we have a method called `add()` that returns an `int` value. `add()` takes in two int parameters, `a` and `b`. In the method body, there is a `return` statement that returns the int value `a + b`, matching the stated return type. \
The modifier `static` indicates that the method can be accessed without making an object of the class, which we will cover in the next two units (Object-Oriented Programming). For now, all of our methods will be `static`.

```java
static void greet() {
    System.out.println("Hello! :D");
}
```
In this example, we've declared a `static` method called `greeting` that returns nothing (the return type is `void`) and takes in no parameters (parentheses are empty). In the body of this method, we have a statement that prints `Hello! :D`. This method does *not* need a return statement because it has no specified return type.

```java
static boolean isPrime(int n) {
    for (int i = 2; i < n; i++) {
        if (n % i == 0) { // Number is divisible by a factor i
            return false; // Composite number
        }
    }
    return true; // No factors, so it's prime
}
```
This `static` method is called `isPrime()` and returns a `boolean` value. `isTriangle()` takes in one parameter, the `int` number. \
In the method body, it checks all of the integers less than the number. If any are found to be a factor of the number, the method returns `false`. If the loop completes without finding any factors, `true` is returned.

### The Main Method
You've seen from all of our exercises that we always write code inside a block with `public static void main(String[] args)` at the top. And after discussing how methods are declared, you may be able to recognize this as a method itself! We call this method the **main method**, which is the 'entrypoint' of the program, the first thing that is executed.

This is the main method:
```java
public static void main(String[] args) {
    // code to execute
}
```
This is a pretty complicated method! Let's take a closer look:
- **public** is an *access modifier* that we'll discuss later.
- **static** is the modifier that we've been using when declaring methods! We will also cover this later :)
- **void** declares that the main method doesn't return anything.
- **main** is the name of the method.
- **String[] args** is a parameter of the method that we'll talk about later.

## Method Calls
To use a method in our program, we *call* it like so:
```java
methodName(arg1, arg2)
```
Where `methodName` is the name given to the method when it's declared, and `arg1` and `arg2` are arguments to be passed in (there may be more or less arguments).

If the method's return type is not `void`, then the call expression also produces a value (the return value). Otherwise, the method call is usually an independent statement (like `System.out.println();`) as there is no output to receive.

Example:
```java
static void greet(String name) {
    System.out.println("Hello " + name + "! :D");
}

public static void main(String[] args) {
    System.out.println("Say hello!");
    greet("Mittens");
}
```
Output:
```
Say hello!
Hello Mittens! :D
```
In this example, the program first prints `Say hello!`, then *calls* the `greet()` method with argument `"Mittens"`. It then executes the code inside the `greet()` method, in this case printing `Hello Mittens! :D`. Once the method is finished, the program goes back to the code in the main method.

If the method is not from the enclosing class, then you put the object followed by a `.` and then the method call. \
Below are two examples you have seen before: \
`msg.equals("hello")` Call the `equals()` method of the `String` `msg` object \
`System.out.println("Hi");` Call the `println()` method of the `System.out` object \

By using methods, we can *abstract* away all of the fine details and turn the intention into a single, concise statement, rather than a long chunk of code. This makes your program more organized and very easy to understand. It also makes it much easier to update and replace code. \
Methods should be a single, discrete action that is describable in a single phrase. Ideally, another programmer can understand and use it without knowing the internal implementation (*how* the method does it).

## >Exercise: Book Finder
You're the sole librarian of a vast library with 4 whole shelves and a singular book on each shelf. In fact, visitors are having such a hard time finding the book they're looking for that you need a way for them to check which book is on what shelf through the library computer (or risk getting lost in your maze of a library!)

[`BookFinder.java`](BookFinder.java)
The four books you have are `The Three Body Problem` (Cixin Liu) on shelf 1, `The Dark Forest` (Cixin Liu) on shelf 2, `Death's End` (Cixin Liu) on shelf 3, and `The Wandering Earth` (Cixin Liu) on shelf 4.
1. Create a method that takes in the shelf number as a parameter and returns the title of the book on that shelf.
2. Declare the `main()` method and in it, call your method twice and print out each result; once for shelf 1, then for shelf 3.

<details><summary>Solution Code</summary>

```java
public class BookFinder {

    static String findBook(int shelfNumber) {
        switch (shelfNumber) {
            case 1:
                return "The Three Body Problem";
            case 2:
                return "The Dark Forest";
            case 3:
                return "Death's End";
            case 4:
                return "The Wandering Earth";
            default:
                return "Could not find your book!";
        }
    }
    public static void main(String[] args) {
        String titleOne = findBook(1);
        String titleThree = findBook(3);
        System.out.println("Shelf one has " + titleOne);
        System.out.println("Shelf three has " + titleThree);
    }
}
```
Output:
```
Shelf one has The Three Body Problem
Shelf three has Death's End
```
</details>

## Method Overloading
**Method overloading** in Java allows us to define multiple methods with the *same name* but *different parameters*. \

There are three ways we can do this:
- Changing the number of parameters.
- Changing the data types of arguments.
- Changing the order of parameters.
Note: you cannot overload two methods by changing the return type, only the parameters.

Example:
```java
// Original method
static void add(int a, int b) {
    System.out.println(a + b);
}

// Changing parameter data types
static void add(String a, String b) {
    System.out.println(a + b);
}

// Changing number of parameters
static void add(int a, int b, int c) {
    System.out.println(a + b + c);
}

public static void main(String[] args) {
    add(2, 3);
    add("hello ", "world");
    add(2, 3, 1);
}
```
Output:
```
5
hello world
6
```
While they look similar, all three `add` methods are different! The differences in the argument list of each call allows Java to automatically identify which method to run.

## Debugging
<sub>(Long detour)</sub>

A large portion of your time as a programmer will be spent **debugging**: finding and fixing bugs and errors in code. \
Debugging is a skill, and it often requires a ton of patience and perseverance. Bugs can take anywhere from a couple of seconds to a few hours to even multiple days to fix, and may be extremely frustrating to identify.

### Types of Bugs
There are three main categories of bugs/errors.

*Compile time errors* (also called syntax errors or build errors) are errors that prevent the computer from running the program at all; they happen when Java fails to compile (build) your program. \
Either, the syntax is off (bad punctuation), or a rule is broken (like assigning to a `final` variable). \
Common examples include forgetting a semicolon, having an unmatched parenthesis or curly brace, making a typo in a symbol (name), data type mismatch, and trying to access a member where it is illegal to. \
These errors are the easiest and quickest to find and fix. \
VS Code will even detect and warn about these errors (usually with a red underline) before you build your code. (Warnings, with orange underlines, are ignorable.)

*Runtime errors* (informally, crashes; formally, **exceptions**) happen while the program is running and force Java to immediately stop execution of the program. \
Examples include accessing methods on `null`, dividing an integer by `0`, or providing bad argument values to certain methods. \
Since these fatal errors are obvious and usually involve simple, straightforward mistakes, they are often easy to debug.

*Logic errors* are when the program does not crash, but it produces bad or unintended results. \
This is the broadest category, and can be caused by faulty algorithms, badly written conditionals, missing or absent code, inaccurate constants, or flawed understanding of the codebase or external packages. \
No error message accompanies them, they might not be obvious at first glance, and they often involve more complicated, deeper issues or mistakes. Therefore, this is the kind of error programmers spend the most time on.

Another term you might hear is **regression**, a bug where a feature that was working before is no longer working.

### Error Messages
For compile time and runtime errors, error messages are very useful in identifying the problem. It's important to get comfortable with reading them.

For compile time errors, VS Code highlights problems and provides a list of them on the *Problems* tab of the bottom panel. When trying to run the code, it will give a "Build failed" message, but you can hit `Continue` if you want to see the actual Java error message. \

There are a couple of parts to the error message. \
On the first (top) line, the type of exception is provided, followed by a brief description of the error. \
The description is often given in very technical terms, but can be useful. Though, it may sometimes be misleading or very hard to understand. \
Example:
```
Exception in thread "main" java.lang.ArithmeticException: / by zero
```

The second part is the **stack trace**, or traceback, which tells you the exact location of where the error occurred. \
Full error message:
```
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at Main.divide(Main.java:12)
        at Main.main(Main.java:5)
```
The top lines are closer to the error; the topmost line is the statement that directly caused the error. \
Every next line is for the method call of the method containing the previous line's statement. In this case, the `main()` method of the `Main` class called the `divide()` method of the `Main` class.

On the left, the class and method name (e.g. `Main.divide`) is given. \
Inside the parentheses, the file name is given, followed by a colon `:`, and then the exact line number of the statement. `Main.java:5` is in `Main.java` at line number 5.

You can `Ctrl`+`LeftClick` any line in the stack trace output to jump to the location in the *Editor* in VS Code. You should probably check out the top line first.

<!-- TODO: more error message examples -->

### The Debugging Process
Below are some guidelines and suggested procedures for debugging.

The three steps in debugging are finding the bug, diagnosing the bug, and fixing the bug.

Finding the bug may seem trivial, but programmers spend a lot of effort trying to discover them and detect them. This is the process of **testing**: checking that the program works as intended and that there are no problems with it. \
In general, the more frequently you test and the earlier you find bugs, the easier they are to diagnose and fix. The amount of changes you've made since the last test will be a lot less, so pinpointing the bad change is faster.

When testing a program, don't just try the common cases: try the extreme cases, the special cases, and the edge cases. Actively try to break the program: seek out problems rather than correct results. \
It helps to test often, ideally after every change, so that each testing is smaller and more targeted. Doing large amounts of changes without testing in between can make things more difficult.

Diagnosing the bug, or figuring out and understanding the origin/cause of the problem, is the hard part.

<details><summary>Comprehensive, detailed list of ways to approach a bug, in order.</summary>

- **Read the error message**, if applicable. For compile time and runtime errors, the error message points you to the exact location, and from there it is usually easy to trace it back to the cause.
- **Research**. If the bug is generic (not too specific to your program), searching up the problem often yields solutions.
    - **Reread documentation and information** if you are using code not written by you, as some bugs come from flawed assumptions or incomplete understanding of what something does.
- **Read the code**, especially recent changes. If the bug doesn't seem hard or a very recent change must have caused it, it can be quickest to simply go through the code or changes thoroughly and consider the steps one by one.
- **Reproduce the bug**. This means creating a procedure that reliably leads to the bug, which is necessary to be able to continue investigating it or share it to others. A *minimal reproducible example* (MRE) is a small program that demonstrates the bug, helpful in condensing and sharing the problem, if possible to create.
- **Narrow down the possibilities**. This is the primary method for diagnosing non-trivial bugs: verify different parts of the program or algorithm that could have been involved, until you either identify the step or isolate the problem enough to do more targeted analysis.
    - In many cases, the error is about a faulty value, where a single incorrect step in a 'pipeline' of calculations leads to a bad result. **Use `System.out.println()`** or other output to **log** and verify values at strategic points, and narrow down the specific part.
    - **Revert changes until the program works**. Using git version control or undo, you can go back a few changes to narrow down which change is the culprit. This is especially effective for regressions.
    - For quicker narrowing down, use binary search or bisection: check the step in the middle of the remaining possibilities, to eliminate more with each check. This can be faster than checking one-by-one in order, when there are many steps. (An analogy is the optimal strategy for a higher or lower game.)
- **Use a debugger**. A debugger is a tool that allows you to halt the program at specific points, track variable values, and go through the code line by line. For your Java programs, click `Debug` instead of `Run` to utilize the debugger; you'll have to learn how to use it, of course.
- **Ask others for help**. Another person can have previous experience or knowledge, provide different ideas, help investigate, or simply see stuff that you missed. Be sure to at least spend some time yourself diagnosing a bug, to improve your skills.
- **Take a break**. Do something else for a bit, to help you reset, and return with a fresh perspective. Sometimes, you can get an epiphany during the break. Or after the break, you might be able to spot something you missed before.
- **Analyze the bug's behavior**. Sometimes narrowing down doesn't work, such as when it involves opaque processes or algorithms from third party packages, or the bug is too bizarre. So for stubborn bugs, it may help to take a deeper look at how the bug behaves: the conditions it requires and the output it leads to. These can sometimes hint at a possible cause.
- **Start over**. Go back to a previously working state and abandon the buggy code. You can also try to write the code again, more carefully and at a slower pace.

</details>

Once you understand the bug, it shouldn't be too hard to implement a fix. \
One can try fixing a bug without understanding it first, but this is not recommended.

### >Exercise: Gamblecore
Your pet bird named Cat wrote a Java program for a simple gambling game, so he could gamble. Typical of Cat... \
[`Gambling.java`](Gambling.java)

**Game rules:**
- The player starts with $\$10$.
- Each turn, the player can either decide to bet, or leave the game with their current money.
- A bet consists of the player declaring a *stake*, an amount of money to bet (integer amount). Then, there is a "coin flip".
    - There is a 50% chance that the stake amount is *doubled*: they earn an amount equal to the stake.
    - The other 50% of the time, they *lose* the stake amount.
- The player cannot bet negative money, nor can they bet more money than they have.
- If the player's money reaches $\$0$, the game ends automatically.
- (There isn't a goal to the game other than allowing the player to gamble).

But Cat was impaired while programming it, so there are a couple of mistakes in the code. \
Help Cat fuel his crippling gambling addiction by fixing the program! \
Read the program, test it with the rules in mind, and debug the code. \
(Assume that the user always inputs an integer.)

There are 7 bugs, 2 of which are compile time errors.

**Bonus part:** \
At the end of the game, have the program tell the player the maximum amount of money they reached during the game.

<details><summary>Solution Code</summary>

```java
import java.util.Scanner;

public class GamblingSolution {
    public static void main(String[] args) {
        intro();
        Scanner scanner = new Scanner(System.in);
        int money = 10; // Start with $10
        // Fix 1: money > 0 instead of money >= 0
        while (money > 0) {
            System.out.println("MONEY: $" + money);
            System.out.print("Enter the stake, or 0 to quit: $");
            int stake = scanner.nextInt();
            // Check if the user wants to quit
            if (stake == 0) {
                // Fix 2: printed money instead of stake
                System.out.println("You ended with $" + money + ".");
                break;
            }
            // Check if the stake is valid
            // Fix 3: Changed && to ||
            if (stake < 0 || stake > money) {
                System.out.println("Invalid stake.");
                continue;
            }
            // User doubles their stake, or loses it
            boolean won = randomBoolean();
            if (won) {
                // Fix 4: Update money instead of making a new variable
                money += stake;
                System.out.println("You won! (+$" + stake + ")");
            } else {
                // Fix 4: Update money instead of making a new variable
                money -= stake;
                System.out.println("You lost! (-$" + stake + ")");
            }
        }
        
        // Fix 5: added this if statement
        if (money == 0) {
        System.out.println("You're out of money!");
        }
    }

    /** Returns true 50% of the time, false otherwise */
    public static boolean randomBoolean() {
        return Math.random() < 1.0 / 2; // Fix 6: changed 1 -> 1.0
    }

    public static void intro() {
        System.out.println("Welcome!");
        System.out.println("In this game, you start with $10.");
        System.out.println("Every turn, you can bet some of your money (a stake)."); // Fix 7: added a semicolon here
        System.out.println("There is a 50% it is doubled, and a 50% you lose it.");
        System.out.println("You can quit at any time. The game also ends if you reach $0.");
        System.out.println();
    }
}
```

Explanations:
    - Fix 1: Since the game ends once `money` reaches `0`, `0` should not be included in the while loop's conditional.
    - Fix 2: `stake` is what the user bets, not the amount of money they end with.
    - Fix 3: `stake` is invalid if it is negative *or* if it is more money than the user has. It cannot be both.
    - Fix 4: `stake` should be subtracted/added from our existing `money` variable. Declaring a new variable `money` is incorrect.
    - Fix 5: The user can end the game without running out of money, so the print statement is sometimes innacurate. We need to check if they're out of money first.
    - Fix 6: Remember integer division? `1 / 2` will evaluate to `0`, not `0.5`. This means `randomBoolean` will always return `false`, and the player will always lose.
    - Fix 7: The third print statement needs a semicolon.
</details>

### >Exercise: Factorial Sum
Your cat Floofles heard about a cool mathematical formula that results in the constant $e \approx 2.71828$ . \
Floofles wanted to test it out using a Java program. [`Formula.java`](Formula.java)

This formula involves the **factorial** function, mathematically denoted with $!$ after the number. \
The factorial function $n!$, where $n$ is a nonnegative integer ($n\ge0$), is defined as the *product of all integers from $1$ to $n$* . \
For example, $5! = 1 * 2 * 3 * 4 * 5 = 120$ . Also note that $0! = 1$ and $1! = 1$ . \
Note that the factorial function grows *massive* very quickly. For reference, $52!$ has 68 digits.

**Formula:** \
The constant $e$ can be expressed as the sum of the reciprocals ($1/x$) of all factorials (all nonnegative integers, $0$ to $\infty$):
```math
e = \frac{1}{0!} + \frac{1}{1!} + \frac{1}{2!} + \frac{1}{3!} + ...
```
```math
= \frac{1}{1} + \frac{1}{1} + \frac{1}{2} + \frac{1}{6} + ...
```
```math
= \sum\limits_{n = 0}^{\infty} \frac{1}{n!}
```
Floofles wrote [`Formula.java`](Formula.java) to try to calculate the formula with decent precision. \
But it was written in one go and is riddled with bugs! \
Fix the program so it calculates $e$ to a few digits accurately, and the output says `It works!`. \
(This one is tough, but give it a shot! You might encounter a few concepts that you haven't learned before.)

<details><summary>Hint: something to try</summary>

Try printing `1 / factorial(n)`!
</details>

<details><summary>Hint: a relevant concept</summary>

The max value for an `int` is $2,147,483,647 = 2^{31} - 1$ . When an integer exceeds this (or goes below the minimum value), an **overflow** happens, where the value wraps around to the other side (potentially becoming negative). \
For `double`s, they have a larger max value. Also, they do not overflow: when exceeding the max value, they turn into a special `Infinity` value instead. Note that `1.0 / Infinity` gives `0.0`.
</details>

**Bonus challenge:** \
Floofles wants even more accuracy with the formula result! \
Make the result of the formula be precisely `Math.E` for all digits except the last one.

<details><summary>Solution Code</summary>

```java
public class FormulaSolution {
    public static void main(String[] args) {
        // Upper limit of summation (can't calculate infinitely)
        // A higher limit -> more terms in sequence -> more accurate (up to a point)
        final int LIMIT = 10; // Fix 1: lower LIMIT

        System.out.println("True value:     e = " + Math.E);
        double calculated = formula(LIMIT);
        System.out.println("Formula result: e = " + calculated);

        double error = Math.abs(calculated - Math.E);
        if (error < 0.0001) {
            System.out.println("It works!");
        } else {
            System.out.println("It didn't work.");
        }
    }

    /** Returns n! = 1 * 2 * 3 * ... * n, for n >= 0 */
    public static int factorial(int n) {
        int product = 1;
        // Fixes 2 & 3: start i at 1 instead of 0; change i < n to i <= n
        for (int i = 1; i <= n; i++) {
            product *= i;
        }
        return product;
    }

    /** Returns the summation of 1 / 0! + 1 / 1! + 1 / 2! + ... + 1 / limit! */
    public static double formula(int limit) {
        double sum = 0.0;
        // Fix 4: change n = 1 to n = 0
        for (int n = 0; n <= limit; n++) {
            // Fix 5: change 1 / factorial(n) to 1.0 / factorial(n)
            sum += 1.0 / factorial(n);
        }
        return sum;
    }
}
```

Explanations:
    - Fix 1: `LIMIT = 100` is too high and results in integer overflow. We have to lower it to get an accurate `e` value
    - Fix 2: If we start `i` at `0`, it multiplies `product` by `0` and makes it `0` too. Starting at `1` lets `product` update correctly.
    - Fix 3: `product` should be multiplied by `n` too!
    - Fix 4: `1/0!` is also included in the calculation of `e`. Without it, our formula evaluates to `e - 1`.
    - Fix 5: `1 / factorial(n)` will evaluate to `0` for every value of `factorial(n)` except for `1` (pesky integer division!) Changing `1` to `1.0` gives us the correct values.
</details>

## Recap
- To declare a method, list its modifiers, return type, method name, and then (in parentheses) parameters
- The `return` statement immediately exits the method, and, for non-`void` methods, gives a value
- The `static` modifier is used for all methods in this unit
- The main method is called at the start of the program, and is written as `public static void main(String[] args) { ... }`
- Call a method with the method name following by parentheses, and any necessary arguments inside, e.g. `add(1, 2)`
- The method call produces a value if the return type isn't `void`
- To access a method from a specific object, use `.`, e.g. for `String`'s `equal()` method, `name.equals("Bob")`
- Method overloading is when multiple methods with the same name but a different set of parameters are declared
- The three types of bugs are compile time errors, runtime errors, and logic errors (in order of increasing difficulty)
- Error messages (compile time or runtime errors) consist of an exception type, short description, and a stack trace that pinpoints the origin
- Test the program as frequently as possible while developing, to make debugging easier
- To diagnose a bug, use all of the relevant information, check recent changes, and print critical values to narrow down the origin

### Keyboard Shortcuts
| Keybinding | Command |
| - | - |
| `Ctrl`+`LeftClick` | Follow link or path in *Terminal* |

## Feedback
Please provide feedback if you have any.
<details><summary>Possible feedback points</summary>

- Confusing explanations
- Knowledge, skills, or procedures that were required but weren't taught
- Too fast or too slow explanations; pacing
- Too hard or too easy exercises
- Step-by-step instructions that are not comprehensive/thorough enough, or didn't work
- Seemingly unnecessary or ineffective information or exercises
- Any improvements (e.g. wording) or more effective ways/formats to teach
</details>

___



## License
© 2025 @aatle, @spacepotatoes3, @gjgarson, @KaitoTLex

This work is licensed under a [Creative Commons Attribution 4.0 International License](https://creativecommons.org/licenses/by/4.0/).
