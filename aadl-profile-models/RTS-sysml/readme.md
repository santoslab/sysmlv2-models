# RTS : SysMLv2 to AADL to SysMLv2 example

## SysMLv2 Model

[./sysml/RTS.sysml](./sysml/RTS.sysml)

It requires the AADL definitions contained in the [../../aadl.contributions](../../aadl.contributions/) project

The SysMLv2 model was translated from this [AADL model](https://gitlab.cs.ksu.edu/santos-lab-test-group/ksu-galois-collab/-/blob/main/hardens-aadl-hamr/aadl-seL4/packages/RTS.aadl), which was itself translated from the [HARDENS SysMLv2 model](https://github.com/GaloisInc/HARDENS/blob/main/specs/SysML/RTS_Static_Architecture.sysml)

## How to Setup a SysMLv2+HAMR Development Environment

Follow ``Installation for Developers`` section from the [Sireum SysMLv2 Plugin](https://github.com/santoslab/sysmlv2-plugin#installation-for-developers) project

## How to Run HAMR Codegen on RTS-sysml

1. Clone this repository

    ```
    git clone https://github.com/santoslab/sysmlv2-models.git
    ```

1. Perform the actions under SysMLv2's [Prototype SysML Implementation](https://github.com/Systems-Modeling/SysML-v2-Pilot-Implementation/tree/b08fdffb01b437a03c855c2b39b5ea69c286b02c#prototype-sysml-implementation) section (if you haven't already).

1. Inside the runtime workspace launched via the previous step:

    1. Import the [aadl.contributions](../../aadl.contributions/) project your workspace.
    
    1. Import the project contained in the [sysml](sysml) directory

    1. In the outline view, select the [rts](sysml/RTS.sysml#L9)  part
    
    1. Click the HAMR icon located in the toolbar to run Codegen and then choose the ``JVM`` platform. To regenerate the code that has been checked in use the following options:

        - ``Output Directory`` : &lt;path-to&gt;/[hamr/slang](hamr/slang/)
        - ``Base Package Name`` : RTS

## How to Build/Run the Slang Embedded Project

Follow the instructions in [./hamr/slang/bin/project.cmd](./hamr/slang/bin/project.cmd#L19-L50) in order to run the Demo app either from the command line or from within the IVE.

This will use the behavior code contained in the [./hamr/slang/src/main/component/RTS/](./hamr/slang/src/main/component/RTS/) subdirectories