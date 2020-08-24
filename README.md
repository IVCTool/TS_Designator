| Branch | Build status |
| ------ | ------------ |
| Master | [![Build Status master branch](https://travis-ci.org/IVCTool/TS_Designator.svg?branch=master)](https://travis-ci.org/IVCTool/TS_Designator) |
| Development | [![Build Status development branch](https://travis-ci.org/IVCTool/TS_Designator.svg?branch=development)](https://travis-ci.org/IVCTool/TS_Designator) |

# TS_Designator
The Test Suite Designator provides test cases for the RPR-FOM Designator object class.

## Introduction

The Designator object class is used to communicate information of a targeting system that uses illumination such as those used in laser-guided weapon engagement. This concerns information of the entity performing the designation (for example, entity identifier, output power, wavelength), as well as information of the entity being designated (i.e. entity identifier, spot location). This information can be used by other applications, for example to control designation-guided munition, simulate guidance, and simulate the detonation of the munition at or near the designator spot location.

### Purpose

The purpose of this test suite is to test the correct exchange of messages throughout the life time of the Designator.

### Scope

The scope of the test suite is the exchange of messages in relation to the Designator object class. The correct behaviour of the designating entity and the entity being designated are not in scope of this test suite.

## Overview

### Test cases

The test suite contains the following test cases:

- **Life cycle test case:** test if the SuT correctly generates lifecycle-related messages for a Designator (`TC0001_Lifecycle`). This concerns the testing of messages related to the creation, updating and deletion of Designator object instances.
- **Dead reckoning test case**: test if the SuT correctly generates dead reckoning-related messages for a Designator (`TC0002_Deadreckoning`). This concerns the testing of messages related to the dead-reckoning of the designator spot location.

Several test case parameters are available to control the behaviour of the test cases.

### Interoperability requirements

The interoperability requirements for the Designator Badge can be found both in the IVCT Framework repository, under the [Runtime Configuration directory](https://github.com/IVCTool/IVCT_Framework/tree/development/RuntimeConfig/Badges). The requirements are not repeated here.

The interoperability requirements are based on the following authoritative references:
- **SISO-STD-001-2015** (Standard for Guidance, Rationale, and Interoperability Modalities for the Real-time Platform Reference Federation Object Model Version 2.0 10 August 2015), in particular:
  - Section 7.5.1.2 EmbeddedSystem Object Class
  - Section 7.11.1.1 Designator Object Class
- **IEEE 1278.1-1995** (IEEE Standard for Distributed Interactive Simulation - Application Protocols), in particular:
  - Section 4.5.6.3 Designator PDU
  - Section 5.3.7.2 Designator PDU
- **SISO-REF-010-2018** (Reference for Enumerations for Simulation Interoperability Version 25 29 August 2018), in particular:
  - Section 11 Designator ([UID 80] and [UID 81])

The interoperability requirements attempt to strictly follow these references. However, at several points the references are not clear and the following assumptions have been made:
- **Dead-reckoning of spot-location**. The references allow that any of the defined dead reckoning algorithms can be used in the dead-reckoning of the spot location. However, on closer reading, only the algorithms `STATIC` and `FVW` make sense. In the Designator class there is no linear velocity vector, there are no rotational vectors; and body axis coordinates are not applicable. Only the current position and an acceleration vector is available for the dead reckoning of the spot location. Hence the mentioned two algorithms remain. The test cases will fail if another dead reckoning algorithm than these two is used.
- **Designator goes inactive**. In DIS this involves only one final PDU message where the power is set to zero. In HLA two messages are required: one where the power is set to zero and one where the object instance is deleted. SISO-STD-001-2015 does not define a time period in which these two messages must be transmitted by the SuT, and hence received by the IVCT. For the test cases this time period can be configured with a test case parameter, and should be set small enough to test the simultaneity of these messages to some degree.
- **Designator host system is deleted**. Similar to the previous point, the designator shall go inactive when its host system is deleted. SISO-STD-001-2015 does not define a time period in which the various messages related to this must be transmitted (i.e. deletion of the designator host object instance, setting designator power to zero, and deletion of the designator object instance itself). For the test case the time period in which these messages must be received can be configured with a test case parameter.
- **Timing of messages**. SISO-STD-001-2015 only requires a time stamp in the Update Attribute Values or Send Interaction calls. No time stamp is required in Object Instance deletion calls. This means that the time stamp cannot be used to measure the time between setting the power to zero and deleting the object instance, for example. The test case falls back on measuring the time when a message is received by the test case, not when it is sent by the SuT. In practice this will only be an issue if the configured time period (in the test case parameters) is too small and network load causes transmission delays.
- **D-SPOT_NO_ENTITY**. IEEE 1278.1-1995 uses D-SPOT_NO_ENTITY to indicate that no entity is being designated. However, the designator related sections in SISO-STD-001-2015 are not clear what `DesignatedObjectIdentifier` attribute value must be used to represent D-SPOT_NO_ENTITY, especially when an entity was being designated earlier and that value needs to be "cleared". Section 6.3 in SISO-STD-001-2015 appears to suggest that an empty string value should be used. The test cases therefore assume that an empty string value corresponds with D-SPOT_NO_ENTITY. Note that if no value for `DesignatedObjectIdentifier` is provided at all then the test cases will also assume D-SPOT_NO_ENTITY (as per SISO-STD-001-2015).
- **Designator System Name**. Several enumeration values are defined for the Designator System Name in SISO-REF-10-2018 [UID 80]. However, the RPR-FOM 2.0 only defines the enumerator `Other`. Strictly speaking, anything else than `Other` is not valid, if not defined in the FOM. The test case, however, will test if enumerator values are exchanged as defined in SISO-REF-010-2018 [UID 80].

## Test case details

This section provides more detailed information in relation to the test cases. 

### Test case parameters

The following test case parameters can be adapted in the IVCT GUI, before executing a test case:

- **alwaysReportWhenTestPassesAfterFail**: the test case generally tries to only report an error once. When this option is set to true, the test cases also reports when the error condition has disappeared, and when the error condition reappears.
- **initialWaitingTime** [s]: the time the test case will wait before starting to the execute test.
- **totalTestCaseTime** [s]: the total time the testcase will keep running.
- **maxTimeBetweenPowerZeroAndDesignatorRemoval** [s]: the maximum allowed time between first setting the Designator Output Power to zero and then removing the Designator.
- **maxTimeBetweenHostRemovalAndDesignatorRemoval** [s]: the maximum allowed time between first removing the Host entity and then removing the Designator.
- **heartbeatDrNonStatic** [s]: a spot location update shall be provided at least every `heartbeatDrNonStatic` seconds (valid for dead reckoning algorithm not Static).
- **distanceThresholdDrNonStatic** [m]: a spot location update shall be provided when the discrepancy between the actual position (as determined by its own internal model) and its dead reckoned position (as determined by using a specified dead reckoning algorithm) exceeds this threshold (valid for deadreckoning algorithm not Static).
- **heartbeatDrStatic** [s]: a spot location update shall be provided at least every `heartbeatDrStatic` seconds (valid for dead reckoning algorithm Static).
- **distanceThresholdDrStatic** [m]: a spot location update shall be provided when the discrepancy between the actual position (as determined by its own internal model) and its dead reckoned position (as determined by using a specified dead reckoning algorithm) exceeds this threshold (valid for dead reckoning algorithm Static).

### Test case supplementary information

- The test cases can handle any number of Designator object instances at the same time.

## Test suite developmental information

This section provides developmental information on the test suite.

The test suite software is organized in two projects: the **Test Suite Designator project** that holds the test suite software and a **Test Application project** that provides test application software for testing the test cases.

Other subsections provide information on building and running the test suite.

### Test Suite Designator project

This project includes all the test suite related software. This software is organized in two packages:  `tc_designator` and `tc_lib_designator`.

#### tc_designator

This package contains the test cases, supported by the classes in the `tc_lib_designator` package. Each test case is a subclass of the class `TC_BaseClass.`

##### TC_BaseClass

`TC_BaseClass` (derived from `AbstractTestCase`) functions as the base for the classes `TC0001_Lifecycle` and `TC0002_Deadreckoning`. Apart from the more obvious methods, it contains the following methods:

- `runDesignatorBaseModelAndEvaluateTests`: Using the times defined in the Test Case parameters, this method mainly sleeps and regularly calls `DesignatorBaseModel.timerCallback`. After the Test Case run time has finished, the method `handleResultsOfAllEnabledTests` is called.

- `handleResultsOfAllEnabledTests`: Gets all test results from `DesignatorBaseModel`, logs the errors and / or warnings. Throws Inconclusive or Failed if necessary.

##### TC0001_Lifecyle, TC0002_Deadreckoning and TC9999_AllTests

These test cases implement the method `performTest`, and enable the appropriate Test Items. Thereafter they call `TC_BaseClass.runDesignatorBaseModelAndEvaluateTests`.

#### tc_lib_designator

This package contains supporting functionality for the `tc_designator` package.

##### DesignatorBaseModel

`DesignatorBaseModel` contains a list of Test Items. Each Test Item has an indication of the Test Cases in which it will be used.

In the list `knownObjects` all encountered `Designator` and `BaseEntity` object instances are stored.

`DesignatorBaseModel` contains three callback methods that are called by the RTI ambassador: `discoverObjectInstance`, `removeObjectInstance` and `reflectAttributeValues`. In these callbacks all incoming information about a `BaseEntity` object instance and a `Designator` object instance are stored in `knownObjects`.

Another callback method, `timerCallback`, is called periodically from `TC_BaseClass`.

As a reaction to the callback methods, one or more of the following methods are called: `doTestsOnDesignatorUpdate`, `doTestsOnDesignatorRemoval`, `doTestsOnBaseEntityCreation`, `doTestsOnBaseEntityRemoval`, `doPeriodicTests`. Each of these methods calls one or more test... methods. Each of these test... methods corresponds to one Test Item. These test... methods will be executed only if the corresponding Test Item has been enabled. The result of the test is stored in the corresponding Test Item.

##### HlaDesignator and HlaBaseEntity

`HlaDesignator` is a local representation of the RPR-FOM Designator. It handles subscribing and publishing, encoding and decoding, and it keeps track of update times and states of attributes. Likewise, `HlaBaseEntity` is a local representation of the RPR-FOM BaseEntity.

### Test Application project

A test application is included in this repository for testing the test cases. This `TestApp` can be executed instead of the SuT. It generates a host entity with a designator and a target entity. By using command line options, the rti host, the federation name and the federate name can be set. Furthermore, various (error) conditions can be provoked; all provoke options are false by default.

The Test Application has only been tested against the Pitch RTI.

The command line options of `TestApp`:

- **-rtiHost <rti host>**, e.g. `-rtiHost localhost` or `-rtiHost localhost:8989`, default: localhost
- **-federationName <federation name>**, default: `MAK-RPR-2.0`
- **-federateName <federate name>**, default: `TestAppDesignator`
- **-pDE | -provokeDecodingError**: provokes a decoding error in attribute DesignatorCode
- **-pMOA | -provokeMissingOptionalAttribute**: does not set the optional attribute RelativeSpotLocation
- **-pMMA | -provokeMissingMandatoryAttribute**: does not set the mandatory attribute DesignatorOutputPower
- **-pHEIE | -provokeHostEntityIdError**: sets an invalid reference to a host entity by setting a wrong entity id
- **-pHONE | -provokeHostObjectNameError**: sets an invalid reference to a host entity by setting a wrong host object name
- **-pHEIAHONRTDE | -provokeHostEntityIdAndHostObjectNameReferToDifferentEntities**: the entity id refers to an existing entity, but not to the same entity as the host object name
- **-pDOE | -provokeDesignatedObjectError**: sets an invalid reference to a designated object by setting a wrong designated object name
- **-pOPN | -provokeOutputPowerNegative**: sets the DesignatorOutputPower to a negative value
- **-pEWN | -provokeEmissionWavelengthNegative**: sets the EmissionWavelength to a negative value
- **-pRSLSWNDO | -provokeRelSpotLocSetWhileNoDesignatedObject**: sets the RelativeSpotLocation while no designated object has been set
- **-pMSOSA | -provokeMultipleSettingOfStaticAttribute**: sets the value of a static attribute multiple times
- **-pAUWPZ | -provokeAttributeUpdatesWhilePowerZero**: updates the value of an attribute while DesignatorOutputPower is zero
- **-pNR | -provokeNoRemoval**: does not remove the Designator
- **-pPNZBR | -provokePowerNotZeroBeforeRemoval**: does not set the DesignatorOutputPower to zero before removing the Designator
- **-pSRAPZ | -provokeSlowRemovalAfterPowerZero**: does set the DesignatorOutputPower to zero before removing the Designator, but waits a long time between setting the DesignatorOutputPower and removing the Designator
- **-pSRAHR | -provokeSlowRemovalAfterHostRemoval**: waits a long time between removing the host entity and removing the Designator
- **-pASWDS | -provokeAccelerationSetWhileDrStatic**: sets a non-zero value in the SpotLinearAccelerationVector while the DeadReckoningAlgorithm is set to Static
- **-pANSWDNS | -provokeAccelerationNotSetWhileDrNonStatic**: does not set a non-zero value in the SpotLinearAccelerationVector while the DeadReckoningAlgorithm is set to another value than Static
- **-pDANSOF | -provokeDrAlgoNotStaticOrFvw**: sets the DeadReckoningAlgorithm to another value than Static or Fvw
- **-pNDUOH | -provokeNoDrUpdateOnHeartbeat**: does not update the DesignatorSpotLocation in time
- **-pIDPE | -provokeIllegalDrPositionExtrapolation**: does update the DesignatorSpotLocation while the discrepancy between location and deadreckoned location is too small

### Add test items and test cases

This subsection captures developer notes about adding test items and test cases.

#### How to add a Test Item

The only file that has to be changed is `DesignatorBaseModel.java`. The steps are:

- Add a test id to `DesignatorBaseModel.TestItemIds`, e.g. `MyNewTest`.
- Add a line in the `DesignatorBaseModel.TestItems` constructor.
- Add and implement a method `DesignatorBaseModel.testMyNewTest` (use the existing test... methods as example).
- Call method the`DesignatorBaseModel.testMyNewTest` from one or more of the following methods: `doTestsOnDesignatorUpdate`, `doTestsOnDesignatorRemoval`, `doTestsOnBaseEntityCreation`, `doTestsOnBaseEntityRemoval`, `doPeriodicTests`.
- Recompile.

#### How to add a Test Case
The steps are:

- Add a Test Case id to `DesignatorBaseModel.TC`, for example `TC_New`.
- Create a class `TC_New.java`, using `TC0001_Lifecycle` as an example, changing at least `TC.TC_Life` to `TC.TC_New`.
- Create on or more new Test Items, if necessary (see "How to add a Test Item").
- Add `TC.TC_New` to the appropriate lines in the `DesignatorBaseModel.TestItems` constructor.
- Recompile.

### Build and run the Test Suite

This subsection captures developer notes for building and running the test suite.

#### Create IVCT folder

The steps are:

- Create a folder with name `IVCT`, for example `C:/Projects/IVCT`.
- (Re)name the folder, containing this `README.md` file, to `TS_Designator_Base`
- Define the correct `IVCTFOLDER` in `IVCT/TS_Designator_Base/scripts/config.bat`.

#### Set environment variables
Set `IVCT_CONF` to for example `C:/Projects/IVCT/runtime/IVCT.properties` *(forward slashes!)*
Set `JAVA_HOME` to for example `C:\Program Files\Java\jdk1.8.0_112`
Set `LRC_CLASSPATH` to for example `C:\Program Files\prti1516e\lib\prti1516.jar`

#### Install activemq
- Download `activemq` classic from https://activemq.apache.org
- Copy `apache-activemq-x.x.x-bin.zip/apache-activemq-x.x.x` to `IVCT/activemq`

#### Download and build IVCT_Framework
- Download IVCT_Framework-development.zip from https://github.com/IVCTool/IVCT_Framework; store in `IVCT/TS_Designator_Base/scripts`
- Update the name of the downloaded zip file in `IVCT/TS_Designator_Base/scripts/buildIvctFramework.bat`
- Execute `IVCT/TS_Designator_Base/scripts/buildIvctFramework.bat`. This is always necessary, even when running the Test Suite standalone, because it generates the following maven repository entries:
  - `%USERPROFILE%/.m2/repository/io/github/msg134/IEEE1516e/x.x.x/IEEE1516e-x.x.x.jar` and
  - `%USERPROFILE%/.m2/repository/io/github/msg134/TC.lib/x.x.x/TC.lib-x.x.x.jar*`

#### Build TS_Designator
- Execute `IVCT/TS_Designator_Base/scripts/build.bat`
- Optionally first adapt `IVCT/TS_Designator_Base/TS_Designator/src/main/resources/logback.xml` to print e.g. DEBUG messages

#### Run Pitch RTI
- Run the Pitch RTI

#### Import in Eclipse
- Run Eclipse
  - File - Switch workspace - set workspace to `IVCT/eclipseWorkspace`
  - File - Import - General - Projects from folder or archive - directory `IVCT/IVCT_Framework` - Finish
  - File - Import - General - Projects from folder or archive - directory `IVCT/TS_Designator_Base` - Finish

#### Run activemq
- From command line, in folder `IVCT/activemq/bin`, type command *activemq start*

#### Copy IVCT_Framework properties file
- Execute `IVCT/TS_Designator_Base/scripts/copyIvctFrameworkPropertiesFile.bat`
  *Otherwise nato.ivct.gui.server.app.dev will crash immediately*

#### Run option 1: run IVCT GUI; IVCT loads Test Suite
- Eclipse

  - nato.ivct.gui.server.app.dev - [webapp] dev server.launch - run

    *(in case of error, you probably forgot to execute copyIvctFrameworkPropertiesFile.bat)*

  - nato.ivct.gui.ui.html.app.dev - [webapp] dev ui.launch - run

  - Optional: LogSink - src/main/java - de.fraunhofer.iosb.ivct.logsink - LogSink.java - run

  - TC.exec - src/main/java - de.fraunhofer.iosb.testrunner - TestEngine.java - run

- Web browser

  - Navigate to http://localhost:80 => IVCTool running in web browser
  - Indicator "TestEngine" should be green; indicator "LogSink" may still be gray
  - Click e.g. TC0001_Lifecycle under JFTES; execute the Test Case

#### Run option 2: run Test Suite standalone in Eclipse
In this case there is no need to import IVCT_Framework in Eclipse. Importing TS_Designator_Base is sufficient.

- Eclipse: TS_Designator - src/main/java - nl.tno.msg.tc_designator - Run.java - run

#### Run option 3: run Test Suite standalone from command line
In this case there is no need to use Eclipse.

- DOS window: `IVCT/runtime/TS_Designator-x.x.x/bin/TS_Designator.bat`
- Optionally adapt `IVCT/runtime/TS_Designator-x.x.x/lib/lib/logback-test.xml` to print e.g. DEBUG messages