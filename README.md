# LeetCode Playground

![Java CI with Gradle](https://github.com/spencercjh/leetcode-playground/workflows/Java%20CI%20with%20Gradle/badge.svg)

Due to my limited ability to solve LeetCode problems, I hope to use TDD that I am familiar with to help me find problems
in the code. At this stage, I think it is more important to write code and debug quickly with IDEA than mock the
whiteboard environment of actual interviews.

Hopefully I can stick with it and finish the daily problem of LeetCode every day.

After trying for 2 days, I think the advantage of using unit tests to run the problem is that it saves time. The
execution of the program on the LeetCode webpage is too slow.

## Features

### CI

There is a [github action](.github/workflows/gradle.yml) to run `gradle test` after every push and PR.

### Sync Today Record

There is a [github action](.github/workflows/sync-leetcode-today-record.yml) to create a Java source and test file
about _Today Record_(每日一题) at 00:01 UTC+8 every day.

References:

- API: https://www.getpostman.com/collections/ffe2b6a457f7baf67764
- related github action: https://github.com/joshcai/leetcode-sync

TODO: More detail of the question in the Java source file or a new markdown file.

## Contribution

Welcome to submit new issues or contribute code to make solving LeetCode more enjoyable
