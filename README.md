# KWICObjectOrient

## Build
`mvn clean compile assembly:single`

## Usage
Either input the lines to run KWIC on into the terminal and specify EOF, or redirect input.

## Unit Tests
Wasn't sure if testing was required for this project, but better safe than sorry. Tests were written using JUnit 5 and run using Eclipse's built-in test runner (meaning that running it via your preferred Maven plugin may require some configuration). Unit tests were omitted for the MasterController as its only behavior was calling procedures on other objects (meaning it couldn't be meaningfully unit tested).

## Authors
Micah Schiewe and Michael Coffey
