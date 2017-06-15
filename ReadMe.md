Parental Control Service

Parental control service prevents access to movies based on preantal control level

System requirements

Java Version = 1.8


Build

Maven is used as a buuild tool. To perform build run following command.

mvn install


Tests

Test cases are written with Junits and Mockito framework. To run test cases run 

mvn test


Run 
Application can be run using command line.

mvn exec:java

Design
ParentalControlService depends on MovieService and VerifyControlLevelService. VerifyControlLevelService verifies whether parental control is ok.
CallbackMessage is used to pass additional information about the service call. 	


