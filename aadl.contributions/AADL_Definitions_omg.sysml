library package AADL_Definitions_omg {

	import Connections::BinaryConnection;
	
	enum def ComponentCategory {
		enum Abstract; 
		enum Bus; 
		enum Data; 
		enum Device; 
		enum Memory;
		enum Process;
		enum Processor; 
		enum System; 
		enum Subprogram;
		enum SubprogramGroup; 
		enum Thread; 
		enum ThreadGroup;
		enum VirtualProcessor; 
		enum VirtualBus; 
	}

	abstract part def Component {
		attribute category : ComponentCategory; 
	}
	
	part def System :> Component {
		:>> category = ComponentCategory::System;
	}

	part def Process :> Component {
		:>> category = ComponentCategory::Process;
	}
	
	part def Thread :> Component {
		:>> category = ComponentCategory::Thread;
	}
	
	part def Data :> Component {
		:>> category = ComponentCategory::Data;
	}
	
	
	
	abstract port def Feature;
	
	port def AbstractFeature :> Feature { // AADL feature
		inout item type : Component;
	}
	
	port def DataPort :> Feature { 
	 	inout item valueType : Component;
	}

	port def EventPort :> Feature;
	
	port def EventDataPort :> Feature {
		inout item valueType: Component;
	}
	
	connection def PortConnection :> BinaryConnection {
		end source : AbstractFeature[0..*] :>> BinaryConnection::source;
		end target : AbstractFeature[0..*] :>> BinaryConnection::target; 
	}

}