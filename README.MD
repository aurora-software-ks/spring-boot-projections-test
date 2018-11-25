# Spring Boot Projections Test

## Requirements
1. Java 8
2. Lombok plugin

## Starting the project
Using gradle wrapper:

- `gradlew clean build bootRun`

## Running the experiment:
1. Initialize database data by calling: localhost:8080/sample/init
2. Test the projections by calling: localhost:8080/sample/test

The test may take around 1 minute to complete with the default settings (also depends on your machine).

To change the settings, navigate to SampleController and update `ITERATIONS` and `OBJECTS_PER_ITERATION` variables.