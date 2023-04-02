# MarsRover
A squad of robotic rovers are to be landed by NASA on a plateau on Mars.

This plateau, which is curiously rectangular, must be navigated by the rovers so that their
on-board cameras can get a complete view of the surrounding terrain to send back to
Earth.

A rover's position and location is represented by a combination of x and y co-ordinates and
a letter representing one of the four cardinal compass points.

The plateau is divided up into a grid to simplify navigation.

An example position might be 0, 0, N, which means the rover is in the bottom left corner
and facing North. In order to control a rover, NASA sends a simple string of letters.

The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or
right respectively, without moving from its current spot. 'M' means move forward one grid
point, and maintain the same heading.

Assume that the square directly North from (x, y) is (x, y+1)

## Input
The frst line of input is the upper-right coordinates of the plateau, the lower-left
coordinates are assumed to be 0,0.

The rest of the input is information pertaining to the rovers that have been deployed. Each
rover has two lines of input. The frst line gives the rover's position, and the second line is
a series of instructions telling the rover how to explore the plateau. The position is made
up of two integers and a letter separated by spaces, corresponding to the x and y coordinates and the rover's orientation.

Each rover will be fnished sequentially, which means that the second rover won't start to
move until the frst one has fnished moving

## Output
The output for each rover should be its fnal co-ordinates and heading

## Sample Input and Output
## Test Input
5 5<br/>
1 2 N<br/>
LMLMLMLMM<br/>
3 3 E<br/>
MMRMMRMRRM<br/>

## Expected Output
1 3 N<br/>
5 1 E

# Environment and Dependencies
- JDK 1.8
- IntelliJ IDEA
- Maven 8
- junit 5.9.2

# Usage
#### 1. Import project into IntelliJ IDEA IDE and run Main and follow the prompts in the console.
#### 2. OR If you prefer to not import it into an IDE:
1. cd to the MarsRover dir
2. Build the project and run all tests: ```mvn clean package```
3. Run the jar built with: ```java -jar target\MarsRover-1.0-SNAPSHOT.jar```
