#!/bin/bash
set -e

# Compile everything normally.
./gradlew assemble

# Riddle Solution should not be referenced.
numberOfSolutionCalls=$(grep -onr "Riddle[0-9]*Solution\.solve*" src/test/kotlin | wc -l)

if [ $numberOfSolutionCalls -gt 0 ] ; then
  echo "Calling the solution of a riddle from the test. Please remove it:"
  grep -r "Riddle[0-9]*Solution\.solve*" src/test/kotlin
  exit 1
else
  # Replace all riddles with their solutions and run the tests.
  find src/test/kotlin/com/vanniktech/rxriddles -type f -name "Riddle[0-9]*Test.kt" -exec sed -i "s/Riddle\([0-9]*\)\.solve/Riddle\1Solution\.solve/" {} \;
  ./gradlew test

  # Build the rest.
  ./gradlew build

  # Reset changes.
  git reset --hard
fi