# Linear-Programming-Project

Java coefficient-array exercise exploring linear-programming constraints and slack-variable conversion.

## Setup and repository reference

### Project structure

- [LinearProgramming.java](LinearProgramming.java)

### Getting started

```bash
git clone https://github.com/Raimal-Raja/Linear-Programming-Project.git
cd Linear-Programming-Project
```

Use a JDK and compile individual exercises separately; repeated class names may appear across folders. Example:

```bash
javac "LinearProgramming.java"
```

Java compilation was checked with the Eclipse compiler and Java 21 runtime. With a local JDK, run `javac LinearProgramming.java LinearProgrammingTest.java` and `java LinearProgrammingTest`.

### Configuration and limitations

The converter accepts explicit <=, >=, and = relations, adding a slack or surplus variable for each inequality. The original three-argument constructor assumes <= constraints. It converts equations and does not optimize an objective or implement simplex feasibility phases.

### Validation

Audit: 2026-10-08. Repository structure, setup instructions and description were reviewed. Syntax checks do not establish full runtime correctness. External APIs, live scraping, GUI interaction, notebook training and production deployment were not comprehensively exercised.

### Repository description

The short GitHub description is provided in [REPOSITORY_DESCRIPTION.md](REPOSITORY_DESCRIPTION.md).

### Contributions

Describe the issue, reproduction steps, environment, and expected behavior when proposing a change. Keep generated environments, credentials, and unnecessary build artifacts out of new commits.

### License

No top-level license file was found during this review.
