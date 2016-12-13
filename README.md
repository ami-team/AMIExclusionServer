[![][Build Status img]][Build Status]
[![][Dependency Status img]][Dependency Status]
[![][license img]][license]

AMIExclusionServer
==================

The ATLAS Metadata Interface Exclusion Server (AMIExclusionServer) is TODO. It was originally developed for the A Toroidal LHC ApparatuS (ATLAS) experiment, one of the two general-purpose detectors at the Large Hadron Collider (LHC).

Compiling AMIExclusionServer
============================

1. Requirements

  Make sure that [Java 8](http://www.oracle.com/technetwork/java/javase/) and [Maven 3](http://maven.apache.org/) are installed:
	```bash
java -version
mvn -version
```

2. Compiling sources
	```bash
mvn package
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

[Build Status]:https://travis-ci.org/ami-team/AMIExclusionServer/
[Build Status img]:https://api.travis-ci.org/ami-team/AMIExclusionServer.svg?branch=master

[Dependency Status]:https://www.versioneye.com/user/projects/584f35a661ff4a003d3c3964/
[Dependency Status img]:https://www.versioneye.com/user/projects/584f35a661ff4a003d3c3964/badge.svg?style=flat

[license]:http://www.cecill.info/
[license img]:https://img.shields.io/badge/license-CeCILL-blue.svg
