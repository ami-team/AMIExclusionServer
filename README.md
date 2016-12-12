[![][Build Status img]][Build Status]
[![][Dependency Status img]][Dependency Status]
[![][license img]][license]
[![][Maven Central img]][Maven Central]

AMIExclusionServer
==================

The ATLAS Metadata Interface Exclusion Server (AMIExclusionServer) is TODO. It was originally developed for the A Toroidal LHC ApparatuS (ATLAS) experiment, one of the two general-purpose detectors at the Large Hadron Collider (LHC).

Compiling AMIExclusionServer
============================

1. Requirements

  Make sure that [Java 8](http://www.oracle.com/technetwork/java/javase/) and [Maven 3](http://maven.apache.org/)are installed:
	```bash
java -version
mvn -version
```

2. Compiling sources
	```bash
mvn assembly:assembly
```

Generated standalone bundle: *target/AMIExclusionServer-X.X.X-bundle.zip*

Using AMIExclusionServer
===================

	./AMIExclusionServer start
	./AMIExclusionServer stop
	./AMIExclusionServer status
	./AMIExclusionServer --help

Install as Linux service
========================

	./installAMIExclusionServer.sh

	service AMIExclusionServer start
	service AMIExclusionServer stop
	service AMIExclusionServer status
