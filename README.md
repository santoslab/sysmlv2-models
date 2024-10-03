# HAMR SysML v2 Models

## HAMR SysML v2 Quick Syntax References

HAMR's SysML v2 system architecture modeling language subset is
the AADL SysML v2 subset being defined by an OMG working group:

https://github.com/santoslab/sysml-aadl-libraries/tree/main

Below are some quick syntax references for some of HAMR's SysML v2 AADL subset.

### Package

```
package <id> {
  <import>*
  ⸨ <part>
  | <alias>
  ⸩*
}
```


### Import

```
<mod> import <id> ⸨ :: <id> )* ⸨ :: * ⸩?
```

`<mod> ::= private`

### Part

```
part def <id> :> <super> ⸨ <part-members> ⸩?  
```

```
<super> ::= ⸨ AADL :: ⸩? ⸨ System 
                         | Processor
                         | Process 
                         | Thread 
                         | Abstract
                         | Data 
                         ⸩ 
          | <name>
          
<name> ::= <id> ⸨ :: <id> ⸩*

<part-members> ::= { <part-member>* } 
```

`<part-member>`:

* A `System` can contain (sub) `System`, `Processor`, `Process`, and
  `Abstract` `<part-member>`, as well as ports and connections (described below).

* A `Processor` can contain attributes (described below).

* A `Process` can contain `Thread`, ports, and connections

* A `Thread` can contain ports, connections, and GUMBO contracts (described below).

* `Data`'s part member can contain field parts and attributes

   `<field-part> ::= part <id> : <name> ;`

   `<name>` should resolve to a `Data` or an enumeration.
   Attributes are described below.

* An enumeration (described below) 

### Port

* `DataPort`
 
  ```
  <mode> port <id> : DataPort { :> type : <name> ; }
  ```

* `EventPort`

  ```
  <mode> port <id> : EventPort ;
  ```

* `EventDataPort`

  ```
  <mode> port <id> : EventDataPort { :> type : <name> ; }
  ```

```
<mode> ::= in
         | out
```

`<name>` should resolve to a `Data` or an enumeration.

### Connection

```
connection <id>: ⸨ AADL :: ⸩? PortConnection connect <id> to <name> ⸨ . <id> ⸩* ;
```

### Enumeration

```
enum def <id> { ⸨ ⸨ enum ⸩? <id> ; ⸩* }
```

### Attribute

```
attribute :>> <name> = <attribute-rhs> ;
```

```
<attribute-rhs> ::= <name>
                  | <NUM> [ <id> ]
```

`<name>` should resolve to a `Data`, an enumeration, or an
`abstract` `attribute`.

### Alias

```
alias <id> for <name> ;
```

### GUMBO Contract

```
language "GUMBO" /*{

  ⸨ state ⸨ <id> : <name> ; ⸩* ⸩?
  
  ⸨ integration ⸨ <assume> 
                | <guarantee> 
                ⸩+ ⸩?
  
  ⸨ initialize ⸨ <modifies> ⸩? ⸨ <guarantee> ⸩* ⸩? 
  
  ⸨ functions ⸨ def <id> ( ⸨ <param> ⸨ , <param> ⸩* ⸩? ) : <name> := <exp> ; ⸩* ⸩?
  
  ⸨ compute ⸨ <modifies> ⸩?
            ⸨ <assume> ;
            | <guarantee> ;
            ⸩*
            ⸨ compute_cases ⸨ <compute-case> ⸩+ ⸩? 
            ⸨ <handle> ⸩* 
  ⸩?

}*/
```

```
<param> ::= <id> : <name>

<modifies> ::= <id> ⸨ , <id> ⸩* ;

<assume> ::= assume <id> ⸨ <MULTILINE_STRING> ⸩* : <exp> ;

<guarantee> ::= guarantee <id> ⸨ <MULTILINE_STRING> ⸩* : <exp> ;

<case> ::= case <id> ⸨ <MULTILINE_STRING> ⸩* : <case-assume>+ <case-guarantee>+

<case-assume> ::= assume ⸨ <MULTILINE_STRING> ⸩* : <exp> ;

<case-guarantee> ::= guarantee ⸨ <MULTILINE_STRING> ⸩* : <exp> ;
```
