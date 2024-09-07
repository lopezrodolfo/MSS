# Maximum Subsequence Sum (MSS) Algorithms

This repository contains two Java programs that implement and demonstrate various algorithms for solving the Maximum Subsequence Sum (MSS) problem.

## Authors

- Rodolfo Lopez
- Russell Gokemeijer

## Date

March 24, 2021

## Files

1. `mssTime.java`: A program that allows users to run and time different MSS algorithms.
2. `mss.java`: A simpler implementation that demonstrates the four MSS algorithms with a fixed input array.

## mssTime.java

This program provides an interactive interface for users to:

- Input arrays from files or generate random arrays
- Choose which MSS algorithm(s) to run
- Measure and display the execution time for each algorithm

### Features

- Supports multiple input methods (file input, random array generation)
- Implements four MSS algorithms with different time complexities:
  1. O(n^3)
  2. O(n^2)
  3. O(n\*log(n))
  4. O(n)
- Allows running individual algorithms or all of them at once
- Measures execution time in nanoseconds

### Usage

1. Compile the program: `javac mssTime.java`
2. Run the program: `java mss_Time`
3. Follow the prompts to input arrays and select algorithms to run

## mss.java

This program demonstrates the four MSS algorithms using a fixed input array.

### Features

- Implements the same four MSS algorithms as `mssTime.java`
- Uses a predefined array to showcase the algorithms
- Prints the maximum sum found by each algorithm

### Usage

1. Compile the program: `javac mss.java`
2. Run the program: `java mss`

## Algorithms

Both programs implement the following MSS algorithms:

1. Cubic time complexity (O(n^3))
2. Quadratic time complexity (O(n^2))
3. Log-linear time complexity (O(n\*log(n)))
4. Linear time complexity (O(n))
