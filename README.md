[![][Build Status img]][Build Status]
[![][Dependency Status img]][Dependency Status]
[![][License img]][License]

<a href="http://lpsc.in2p3.fr/" target="_blank">
	<img src="http://www.cern.ch/ami/images/logo_lpsc.gif" alt="LPSC" height="62" />
</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="http://www.in2p3.fr/" target="_blank">
	<img src="http://www.cern.ch/ami/images/logo_in2p3.gif" alt="IN2P3" height="72" />
</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="http://www.univ-grenoble-alpes.fr/" target="_blank">
	<img src="http://www.cern.ch/ami/images/logo_uga.png" alt="UGA" height="72" />
</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="http://home.cern/" target="_blank">
	<img src="http://www.cern.ch/ami/images/logo_cern.png" alt="CERN" height="72" />
</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="http://atlas.cern/" target="_blank">
	<img src="http://www.cern.ch/ami/images/logo_atlas.png" alt="ATLAS" height="87" />
</a>

AMIExclusionServer
==================

The ATLAS Metadata Interface Exclusion Server (AMIExclusionServer) is used by the ATLAS Metadata Interface Task Server ([AMITaskServer](https://github.com/ami-team/AMITaskServer/)) for ... It was originally developed for the A Toroidal LHC ApparatuS (ATLAS) experiment, one of the two general-purpose detectors at the Large Hadron Collider (LHC).

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

[License]:http://www.cecill.info/licences/Licence_CeCILL_V2.1-en.txt
[License img]:https://img.shields.io/badge/license-CeCILL--C-blue.svg
