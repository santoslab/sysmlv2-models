package GUMBO_Definitions {
  language "GUMBO" /*{
    library
        functions

          def inRange(temp: TempControlAadl::Temperature): Base_Types::Boolean :=
            temp.degrees >= f32(-50.0) and temp.degrees <= f32(150.0) and

            // can call spec defs from imported libraries
            temp.degrees >= TempSensor::gminTempDegrees() and temp.degrees <= TempSensor::gmaxTempDegrees();

          def toFahrenheit(temp: TempSensor::Temperature): TempSensor::Temperature :=
            TempSensor::Temperature (temp.degrees);
  }*/
}