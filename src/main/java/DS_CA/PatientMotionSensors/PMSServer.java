	//Name of the package where all the generated files are present.
	package DS_CA.PatientMotionSensors;


		//required java packages for the program. Depends on your logic.
		import java.io.IOException;
		import java.util.Scanner;
		import java.util.ArrayList;
		import java.util.Iterator;
		import java.util.concurrent.TimeUnit;
		import java.util.logging.Logger;

		import com.google.api.Service;

		//required grpc package for the server side
		import io.grpc.Server;
		import io.grpc.ServerBuilder;
		import io.grpc.Status;
		import io.grpc.StatusRuntimeException;
		import io.grpc.stub.StreamObserver;

	//This is ImplBase class that was generated from the proto file.
		//You need to change this location for your projects. NOTICE: The class is in StringsServiceGrpc.java -> StringsServiceImplBase class (this Base class is generated from proto file option java_outer_classname)
		import DS_CA.PatientMotionSensors.PatientMotionSensorsGrpc.PatientMotionSensorsImplBase;

import DS_CA.PatientMotionSensors.PatientCabinRequest;
		import DS_CA.PatientMotionSensors.MonitorAlertResponse;
		import DS_CA.PatientMotionSensors.DoctorEntryRequest;
		import DS_CA.PatientMotionSensors.ScheduledResponse;


		//Extend the ImplBase imported class here. It is an Interface file with required rpc methods
		public class PMSServer extends PatientMotionSensorsImplBase {

		//First we create a logger to show server side logs in the console. logger instance will be used to log different events at the server console.
			private static final Logger logger = Logger.getLogger(PMSServer.class.getName());

		//Main method would contain the logic to start the server.	For throws keyword refer https://www.javatpoint.com/throw-keyword
		//NOTE: THIS LOGIC WILL BE SAME FOR ALL THE TYPES OF SERVICES
			 public static void main(String[] args) throws IOException, InterruptedException {
				    
				 // The StringServer is the current file name/ class name. Using an instance of this class different methods could be invoked by the client.
				 PMSServer pmsServer = new PMSServer();

				 	// This is the port number where server will be listening to clients. Refer - https://en.wikipedia.org/wiki/Port_(computer_networking) 
				    int port = 50056;
				    
				    
				    // Here, we create a server on the port defined in in variable "port" and attach a service "SmartMedicalRecordsServer" (instance of the class) defined above.
				    Server server = ServerBuilder.forPort(port) // Port is defined in line 34
				        .addService(pmsServer) // Service is defined in line 31
				        .build() // Build the server
				        .start(); // Start the server and keep it running for clients to contact.
				    
				    // Giving a logging information on the server console that server has started
				    logger.info("Server started, listening on patient record " + port);
				    server.awaitTermination(50056, TimeUnit.MILLISECONDS);
					
					System.out.println("Ganesan_CA, Thank you for visiting Smart Hospital service");
				    // Server will be running until externally terminated.
				    server.awaitTermination();
			 }
			 
				// These RPC methods have been defined in the proto files. The interface is already present in the ImplBase File.
//				NOTE - YOU MAY NEED TO MODIFY THIS LOGIC FOR YOUR PROJECTS BASED ON TYPE OF THE RPC METHODS 
			// For override Refer - https://docs.oracle.com/javase/8/docs/api/java/lang/Override.html	 

			@Override
			public StreamObserver<PatientCabinRequest> motionMonit(StreamObserver<MonitorAlertResponse> responseObserver) {
				return new StreamObserver<PatientCabinRequest>() {

					// For each message in the stream, get one stream at a time.
					// NOTE: YOU MAY MODIFY THE LOGIC OF onNext, onError, onCompleted BASED ON YOUR PROJECT.
					@Override
					public void onNext(PatientCabinRequest request) {
						// In bidirectional stream, both server and  client would be sending the stream of messages.
						// Here, for each message in stream from client, server is sending back one response.
						StringBuilder input1 = new StringBuilder(); 
						  
			            input1.append(request.getAction()); 
					/**	
						boolean flag  = request.getAction();
						 MonitorAlertResponse reply;
						if(flag)
						{
							reply=MonitorAlertResponse.newBuilder().setAlert("CAUTION: Immediate attention required").build();
						}
						else {
							reply=MonitorAlertResponse.newBuilder().setAlert("Normal: Continues monitering required").build();
						}**/
				        
				         // Preparing and sending the reply for the client. Here, response is build and with the value (input1.toString()) computed by above logic.
				           
			            MonitorAlertResponse reply = MonitorAlertResponse.newBuilder().setAlert(input1.toString()).build();
				            responseObserver.onNext(reply);
						
					}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stubal
						
					}

					@Override
					public void onCompleted() {
						System.out.println ("Receiving Monitoring alrt completed");						 
						responseObserver.onCompleted();
						
					}
					
				};
			}
		
		/**
			public void operationSchedule(DoctorEntryRequest request, StreamObserver<ScheduledResponse> responseObserver) {
			 
				 System.out.println("Receiving Schedule");
				// LOGIC of THE METHOD 
				 String data  = request.getData();
				 ScheduledResponse reply1;
				 
					if (data == "Emergency") {
						reply1 = ScheduledResponse.newBuilder().setBooking(data).build(); 
						//request = DoctorEntryRequest.newBuilder().setData(request.getData()).build();
					}
					else {
						reply1 =ScheduledResponse.newBuilder().setBooking("Shedule is 1 week after").build();
					}
				// Retrieve the value from the request of the client and convert it to array
				 
				// char[]characters = request.getData().toCharArray();
			
				 
				// System.out.println(characters.length);
				 
				 //for(char c: characters) {			
					// Preparing and sending the reply for the client. Here, response is build and with the value (c) computed by above logic.
					 // Here, a stream of response is sent using the for loop.
					 responseObserver.onNext(reply1);
					
			 
				 
				 responseObserver.onCompleted();
			
			 
	}**/
}

