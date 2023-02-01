package AADLComponentTypes {

	abstract part def System;

	abstract part def Process;

	abstract part def Thread;

	// We may not need Data as we can instead require
	// that the datatype flowing through data ports 
	// must extends Base::DataValue
	//abstract part def Data :> Base::DataValue;

}