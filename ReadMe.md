<h2>Parental Control Service</h2>

Parental control service prevents access to movies based on preantal control level

<h4>System requirements</h4>

Java Version = 1.8


<h4>Build</h4>

Maven is used as a buuild tool. To perform build run following command.

mvn install


<h4>Tests</h4>

Test cases are written with Junits and Mockito framework. To run test cases run 

mvn test


<h4>Run </h4>

Application can be run using command line.<br/>

mvn exec:java

<h4>Design</h4>

ParentalControlService depends on MovieService and VerifyControlLevelService. VerifyControlLevelService verifies whether parental control is ok.
CallbackMessage is used to pass additional information about the service call. 	


<h4>Debugging</h4>

Log4j2 is used for logging and debugging purpose.


