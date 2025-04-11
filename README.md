# HAMR SysMLv2/AADL Models

<table>
<tr>
<td> 
  <a href="https://github.com/santoslab/sysmlv2-models/actions/workflows/CI-macOS.yml?query=branch%3Amain"><img src="https://github.com/santoslab/sysmlv2-models/actions/workflows/CI-macOS.yml/badge.svg" alt="macOS"></a>
  <a href="https://github.com/santoslab/sysmlv2-models/actions/workflows/CI-linux.yml?query=branch%3Amain"><img src="https://github.com/santoslab/sysmlv2-models/actions/workflows/CI-linux.yml/badge.svg" alt="Linux"></a>
  <a href="https://github.com/santoslab/sysmlv2-models/actions/workflows/CI-windows.yml?query=branch%3Amain"><img src="https://github.com/santoslab/sysmlv2-models/actions/workflows/CI-windows.yml/badge.svg" alt="Windows"></a>
  <a href="https://github.com/santoslab/sysmlv2-models/actions/workflows/CI-camkes.yml?query=branch%3Amain"><img src="https://github.com/santoslab/sysmlv2-models/actions/workflows/CI-camkes.yml/badge.svg" alt="CAmkES"></a>
</td>
</tr>
</table>

This repository supports the exploration and development of SysMLv2-based
representations of AADL models (SysMLv2/AADL). It provides library definitions for AADL
concepts, developed by the Real-Time Embedded Safety-Critical (RTESC) working
group, along with example SysMLv2 models that demonstrate how these definitions
can be applied in practice.

* [RTESC AADL definition in SysMLv2](sysml-aadl-libraries)
* [Example SysMLv2 models using AADL concepts](models)

## Toolchain Installation

Visit the [Sireum Getting Started](https://sireum.org/getting-started) page. In
  the section [Both VSCodium-based and Intellij-based
  IVEs](https://sireum.org/getting-started/#latest-release-bin-ives), run the
  script that is appropriate for your platform. This will install:
 
 - Sireum: A research platform for developing high-assurance systems. It
   includes HAMR (High-Assurance Modeling and Rapid engineering), which
   translates SysMLv2 and AADL models into AIR (an intermediate representation)
   and performs semantic analysis and code generation targeting safety-critical
   platforms.
 
 - CodeIVE:  A fully configured VS Code environment with Sireum/HAMR extensions
   and SysIDE, which provides editing, validation, and navigation support for
   SysMLv2/AADL models.
  
 - IVE (Integrated Verification Environment): An IntelliJ-based IDE tailored for
   working with Slang, Sireum’s modeling and programming language. Slang
   supports formal contracts, which can be verified using the Logika
   verification engine to reason about functional correctness through contracts
   and proofs.

After installation, you can open and edit the example models in CodeIVE,
validate them against the RTESC SysMLv2 library definitions, and perform
downstream processing such as code generation using HAMR.  Each example model in
this repository includes its own set of instructions to guide you through
validation, analysis, and tool usage.

## Quick Reference

- [SysMLv2/AADL Quick Syntax Guide](syntax-reference.md)

  A concise summary of how AADL concepts are expressed using SysMLv2 and the RTESC definitions.

## Demonstration Videos

[Isolette model and well-formedness checking in the HAMR (SysIDE) VSCode extension for SysMLv2](
https://drive.google.com/file/d/1NkNHdvwJ-GHN2C9zpt2HgMpuLdC303T4/view?usp=sharing)

[Isolette model-level GUMBO integration constraint checking with error reporting in VSCode](
https://drive.google.com/file/d/17IjDBFzjx1WtYSNRimzbVOj_nnMf8qN8/view?usp=sharing)

[Isolette Manage Heat Source (MHS) Slang component implementation automated property-based testing and Logika verification](
https://drive.google.com/file/d/1LAWtQpiTjdac1STDqzgvIMmJrB1bTyDd/view?usp=sharing)

[Isolette HAMR code generation for JVM and seL4 microkit](
https://drive.google.com/file/d/1a5GJqx94ySi-l-MCX1vqjWc76njNArkO/view?usp=sharing)

[Isolette HAMR Rust code development, verification, testing, and deployment on seL4](
https://drive.google.com/file/d/19WgWayynoNIgUTvpN0LOGIvRYhbx-aoU/view?usp=sharing)
