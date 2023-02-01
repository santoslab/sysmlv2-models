# SysMLv2 + Temp Control + Firmata4j + Uno example

## SysMLv2 Model

[sysml/TempControlAadl.sysml](sysml/TempControlAadl.sysml)

It requires the AADL definitions contained in the [../../aadl.contributions](../../aadl.contributions) project

## How to Build/Run the Slang Embedded Project

### Using Mocked-Up Devices

Follow the instructions in [hamr/slang/bin/project.cmd](hamr/slang/bin/project.cmd#L19-L50) in order to run the Demo app either from the command line or from within the IVE.

This will use the mocked-up devices implemented in the Slang extensions (e.g. [mocked-up temperature sensor](hamr/slang/src/main/component/tc/TempControlAadl/TempSensorNative_Ext.scala#L14-L20))


### Using Firmata4j + Uno

#### Circuit Diagram
![circuit_diagram.jpg](circuit_diagram.jpg)

This uses the DeviceBridge interface (e.g. [getting the current temperature](hamr/slang/src/main/component/tc/TempControlAadl/TempSensorNative_Ext.scala#L11-L12)) in order to communicate with the board.That code is located under [hamr/slang/src/main/component/tc/TempControlAadl/device](hamr/slang/src/main/component/tc/TempControlAadl/device)

- Potentiometer simulates a temp sensor.  It's range is set to be b/w 70 F and 100 F.

- Row 9 LED uses PWM to display the current temperature.  It's off at 70 F
and fully bright at 100 F.

- Row 1 LED shows fan state, either on or off.  If should turn on if
the temperature rises above 90 F and should turn off when temperature
drops below 80 F.

#### Build Steps
1. Install [Arduino IDE 2.0](https://docs.arduino.cc/software/ide-v2/tutorials/getting-started/ide-v2-downloading-and-installing)

1. Plugin in the Uno, launch the IDE, and then select the board making
note of its port (e.g. it will look something like ``/dev/cu.usbmodem14301``)

1. Select ``File >> Examples >> Firmata >> StandardFirmata`` and upload
that to the board

1. Open the slang embedded project in IVE by following the instructions in [hamr/slang/bin/project.cmd](hamr/slang/bin/project.cmd) 

1. Change [DeviceBridge.port](hamr/slang/src/main/component/tc/TempControlAadl/device/DeviceBridge.scala#L8) so that it matches the board's port

1. Run the [Demo](hamr/slang/src/main/architecture/tc/Demo.scala) app
