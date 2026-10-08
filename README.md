# Linear-Programming-Project

Java coefficient-array exercise exploring linear-programming constraints and slack-variable conversion.

## Repository guide

### Contents

- [LinearProgramming.java](LinearProgramming.java)
- [README.md](README.md)

### Getting started

```bash
git clone https://github.com/Raimal-Raja/Linear-Programming-Project.git
cd Linear-Programming-Project
```

Use a JDK and compile individual exercises separately; repeated class names may appear across folders. Example:

```bash
javac "LinearProgramming.java"
```

The JDK was unavailable for compilation checks in this review.

### Configuration and limitations

The current conversion infers slack directions from coefficient sums. Constraint directions must be represented explicitly before this can be treated as a correct LP converter. This is not a verified optimization solver.

### Validation

Reviewed on 2026-10-08. Repository structure and documentation were reviewed. No application runtime, training job, or platform-specific build was executed.

### Contributions

Describe the issue, reproduction steps, environment, and expected behavior when proposing a change. Keep generated environments, credentials, and unnecessary build artifacts out of new commits.

### License

No top-level license file was found during this review.
