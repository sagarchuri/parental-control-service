# Parental Control Service

Parental control service prevents access to movies based on parental control level

### System requirements

Java Version = 1.8

### Continuous Integration

[![Build Status](https://travis-ci.org/sagarchuri/parental-control-service.svg?branch=master)](https://travis-ci.org/sagarchuri/parental-control-service)

Continuous Integration is configured via Travis CI

### Build

Maven is used as a build tool. To perform build, run following command.

`mvn install`


### Tests

Test cases are written with Junits and Mockito framework. To run test cases run 

`mvn test`


### Run

Application can be run using command line.<br/>

`mvn exec:java`

### Design

ParentalControlService depends on MovieService and VerifyControlLevelService. VerifyControlLevelService verifies whether parental control level is withing acceptable limit. CallbackMessage is used to pass additional information about the service call. 	


### Debugging

Log4j2 is used for logging and debugging purpose.


