# AGENTS: How to work with this codebase

Purpose: quick, actionable guide to help an AI coding agent (and a human) become productive with this repository of Java practice programs.

1) Big picture
- This repository is a flat collection of small Java example programs (interview/practice problems). There is no framework, no build tool, and no tests. Expect each file to be a self-contained runnable example.
- Common focus: Stream API and Collections usage (groupingBy, partitioningBy, toMap, mapping, maxBy, counting), plus simple algorithms (factorial, subsequence, duplicate detection).

2) Key files & where to look
- `EmployeeOperation.java` — canonical examples of grouping, sorting, converting List->Map and other Stream/Collector patterns.
- `EvenOrOdd/EvenOrOddUsingStreamApi.java` and `EvenOrOdd/SquareOfEvenNumbers.java` — interactive example (Scanner) and simple Stream transforms.
- `SeconHighestSalary/SecondHighestSalary.java` and `SeconHighestSalary/Emplyee.java` — second-highest salary examples; note package name `SeconHighestSalary` and typo `Emplyee.java`.
- `default_program_practice.DuplicateCharactersInString.java`, `default_program_practice.ConvertListToMapUsingStreamAPI.java`, `default_program_practice.DuplicateElementsInArray.java` — more Stream idioms.
- `README.md` — project-level overview and basic run examples (uses `javac`/`java`).

3) Project-specific conventions & gotchas
- Mixed packaging: some classes declare packages (e.g. `package EvenOrOdd;`), while many top-level examples live in the default package. When compiling/running, respect package-qualified class names for packaged files.
- Java API usage mismatch: several files use Stream.collectors and the instance method `Stream.toList()` (e.g. `SquareOfEvenNumbers.java`, `EvenOrOddUsingStreamApi.java`). `Stream.toList()` requires newer JDK (Java 16+). However README claims Java 8+. Confirm JDK >= 16 before bulk-compiling or replace `.toList()` with `collect(Collectors.toList())` for Java 8 compatibility.
- Duplicate/overlapping types: there are multiple `Object_to_test.Employee` definitions in different locations (`Object_to_test.Employee.java` at repo root and `SeconHighestSalary/Emplyee.java`). Be explicit about packages and source paths to avoid confusion.
- Filename quirks: some file or folder names contain typos or nonstandard capitalization (e.g. `SeconHighestSalary`, `Emplyee.java`). Refer to exact paths when editing or compiling.

4) Build / run / debug (PowerShell examples)
- Quick check Java version (required to match code):
```powershell
java -version
javac -version
```
- Compile a single example (works for both default-package and packaged classes):
```powershell
javac "H:\Java development\Practice code\EvenOrOdd\SquareOfEvenNumbers.java"
```
- Compile the entire repository into an output folder (PowerShell expands file lists):
```powershell
javac -d out (Get-ChildItem -Path . -Recurse -Filter *.java | ForEach-Object -ExpandProperty FullName)
```
- Run a default-package class compiled into `out`:
```powershell
java -cp out EmployeeOperation
```
- Run a packaged class (use fully qualified name):
```powershell
java -cp out EvenOrOdd.EvenOrOddUsingStreamApi
```
- Debugging: no launch configurations exist. Use your IDE (IntelliJ/IDEA or VS Code) — import as a simple Java project (no build tool). Set breakpoints and run classes by their fully-qualified names.

5) Common code patterns to reuse or search for
- Grouping and counting: see `EmployeeOperation.java` lines around groupingBy + counting.
- Partitioning into two buckets: `EvenOrOddUsingStreamApi.java` uses `Collectors.partitioningBy`.
- Convert List -> Map: `default_program_practice.ConvertListToMapUsingStreamAPI.java` and `EmployeeOperation.java` examples use `Collectors.toMap` with merge function / Function.identity().
- Stream primitive conversions: `.chars().mapToObj(ch -> (char) ch)` in `default_program_practice.DuplicateCharactersInString.java`.

6) How an agent should edit/extend code here
- Small, self-contained changes are expected. When adding new examples, prefer creating a new file under a descriptive folder (e.g. `examples/` or `algorithm/`) and include a package if you intend to group multiple files.
- When modifying many files or adding a CI/build step, add a short README or a top-level `build.bat`/`build.ps1` explaining the commands and required JDK version.

7) Limitations / Not present
- No unit tests, no CI, no dependency management (Maven/Gradle). Any automated changes should be conservative and include a manual test/run instruction in the commit message or PR body.

8) Quick checklist for performing a change
- Identify whether the target file is packaged or default-package.
- Ensure local JDK is compatible with `Stream.toList()` or replace with `collect(Collectors.toList())`.
- Compile changed files with `javac -d out <files>` (PowerShell example above).
- Run the example using `java -cp out <fully.qualified.ClassName>` and verify output.

---
If you want, I can (A) add a small PowerShell build script in the repo, (B) normalize `.toList()` usage for Java 8 compatibility, or (C) create a short CONTRIBUTING.md describing how to add new examples. Tell me which and I'll implement it.

