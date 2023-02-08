# RTS : SysMLv2 to AADL to SysMLv2 example

## SysMLv2 Model

[./sysml/RTS.sysml](./sysml/RTS.sysml)

It requires the AADL definitions contained in the [../../aadl.contributions](../../aadl.contributions/) project

The SysMLv2 model was translated from this [AADL model](https://gitlab.cs.ksu.edu/santos-lab-test-group/ksu-galois-collab/-/blob/main/hardens-aadl-hamr/aadl-seL4/packages/RTS.aadl), which was itself translated from the [HARDENS SysMLv2 model](https://github.com/GaloisInc/HARDENS/blob/main/specs/SysML/RTS_Static_Architecture.sysml)

## How to Build/Run the Slang Embedded Project

Follow the instructions in [./hamr/slang/bin/project.cmd](./hamr/slang/bin/project.cmd#L19-L50) in order to run the Demo app either from the command line or from within the IVE.

This will use the behavior code contained in the [./hamr/slang/src/main/component/RTS/](./hamr/slang/src/main/component/RTS/) subdirectories