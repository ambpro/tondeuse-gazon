# Tondeuse Gazon Automatique

## About "La tondeuse"

The company MowItNow has decided to develop an automatic lawn mower, intended for rectangular surfaces.

### Objective
Design and write a program running on a JVM ≥ 1.7, a web browser or a node.js server, and implementing the above specification and passing the test below

TEST
The following file is provided as input:

5 5

1 2 N

GAGAGAGAA

3 3 E

AADAADADDA

We await the following result (final position of the mowers):

1 3 N

5 1 E

## Prerequisite for this application.

- JDK 1.8 
- Maven 3.x

## Set up Application

1. Clone the repository https://github.com/ambpro/tondeuse-gazon.git
2. Import as maven project in your IDE

## Configure Application Input/Output files
The configuration file is located on ‘tondeuse-gazon/src/main/resources‘ directory.
It's used to configure the relative path of the input / output of the application. 

```
file.path=src/main/resources/tondeuse.txt
fileOut.path=src/main/resources/tondeuseOut.txt
```

## Run Test cases
### Run from command prompt or Terminal

1. Clone the project by following the setup instructions
2. Open the command prompt / terminal from project repository
3. Run `mvn clean test`

### Run from IDE

1. Clone the project by following the setup instructions
2. Run as Maven test

## Run Application
From console,

1. Move to the project repository
2. Run `mvn clean install` to build the application
3. Launch the application using `mvn exec:java`
