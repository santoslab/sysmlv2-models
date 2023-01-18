// #Sireum

package tc.ScalarValues

import org.sireum._
import tc._

// This file will not be overwritten so is safe to edit

// This is a type skeleton as HAMR doesn't know how to translate ScalarValues::Integer

object Integer {
  def example(): ScalarValues.Integer = {
    return ScalarValues.Integer()
  }
}

@datatype class Integer()

object Integer_Payload {
  def example(): Integer_Payload = {
    return Integer_Payload(ScalarValues.Integer.example())
  }
}

@datatype class Integer_Payload(value: ScalarValues.Integer) extends art.DataContent
