# Java Practice Code - Interview Coding Challenges

This repository contains basic Java programs and coding challenges designed for **interview preparation** and **programming practice**.

## Overview

This project serves as a collection of fundamental Java programs that cover essential concepts used in coding interviews, including:
- Stream API operations
- List manipulation and filtering
- Functional programming approaches
- String processing
- Data structure operations

## Project Structure

```
Practice code/
├── SquareOfEvenNumbers.java          # Calculate squares of even and odd numbers using Stream API
├── EvenOrOdd/
│   ├── EvenOrOdd.java                # Separate even and odd numbers (traditional approach)
│   └── EvenOrOddUsingStreamApi.java   # Separate even and odd numbers (Stream API approach)
├── interview/
│   └── LongestSubsequentNumberIncreasingOrder.java  # Find longest increasing subsequence
├── SeconHighestSalary/
│   ├── Emplyee.java                  # Employee class definition
│   └── SecondHighestSalary.java       # Find second highest salary using Stream API
└── README.md                           # This file
```

## Key Programs

### 1. **SquareOfEvenNumbers.java**
- **Concept**: Stream API, filter, map operations
- **Challenge**: Calculate squares of even and odd numbers from a list
- **Topics Covered**: Lambda expressions, functional programming

### 2. **EvenOrOdd Folder**
- **Traditional Approach**: Loop-based filtering
- **Stream API Approach**: Using `partitioningBy()` collector
- **Challenge**: Separate integers into even and odd categories
- **Topics Covered**: Collectors, partitioning, streams

### 3. **SecondHighestSalary Folder**
- **Concept**: Stream API sorting and limiting
- **Challenge**: Find the second highest salary from employee list
- **Topics Covered**: Comparators, sorting, distinct values

### 4. **Longest Subsequence Challenge**
- **Concept**: Algorithm optimization
- **Challenge**: Find longest increasing subsequence
- **Topics Covered**: Dynamic programming, problem-solving

## Interview Relevance

This collection of programs helps prepare for technical interviews by practicing:
- ✅ **Stream API** - Modern Java functional programming
- ✅ **Collections Framework** - Lists, Maps, sorting
- ✅ **Lambda Expressions** - Concise code writing
- ✅ **Filtering and Mapping** - Data transformation
- ✅ **Problem-Solving** - Algorithm development

## How to Use

1. **Compile**: Use `javac` to compile any Java file
   ```bash
   javac SquareOfEvenNumbers.java
   ```

2. **Run**: Execute the compiled class with `java`
   ```bash
   java SquareOfEvenNumbers
   ```

3. **Practice**: Try modifying these programs or writing variations to deepen understanding

## Getting Started

These are beginner to intermediate level programs. If you're preparing for interviews:
1. Study the Stream API implementations
2. Understand the collector patterns
3. Practice writing similar problems
4. Optimize code for readability and performance

## Recommended Interview Topics to Focus On

- Stream API operations (filter, map, collect)
- Collector patterns (groupingBy, partitioningBy, toList)
- Comparators and sorting
- List operations and transformations
- Functional programming concepts

---

**Level**: Beginner to Intermediate  
**Purpose**: Interview Preparation & Coding Practice  
**Language**: Java 8+

