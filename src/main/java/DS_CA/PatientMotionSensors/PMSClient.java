
	// Name of the package where all the generated files are present.
	package DS_CA.PatientMotionSensors;


		import java.time.LocalDateTime;
import java.time.ZoneOffset;
//required java packages for the program. Depends on your logic.
		import java.util.ArrayList;
		import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
		import java.util.Random;
		import java.util.logging.Level;
		import java.util.logging.Logger;

	import com.google.protobuf.GeneratedMessageV3.Builder;

	//required grpc package for the client side
		import io.grpc.ManagedChannel;
		import io.grpc.ManagedChannelBuilder;
		import io.grpc.Status;
		import io.grpc.StatusRuntimeException;
		import io.grpc.stub.StreamObserver;

		//This is to include rpc method enum message
		import DS_CA.PatientMotionSensors.PatientMotionSensorsGrpc.PatientMotionSensorsImplBase;
		import DS_CA.PatientMotionSensors.PatientCabinRequest;
		import DS_CA.PatientMotionSensors.MonitorAlertResponse;
		import DS_CA.PatientMotionSensors.DoctorEntryRequest;
		import DS_CA.PatientMotionSensors.ScheduledResponse;
		


		// Client need not to extend any other class (GRPC related code) here 
		public class PMSClient  {
			// First we create a logger to show client side logs in the console. logger instance will be used to log different events at the client console.
			// This is optional. Could be used if needed.
			private static  Logger logger = Logger.getLogger(PMSClient .class.getName());

			// Creating stubs for establishing the connection with server.
			// Blocking stub
			private static PatientMotionSensorsGrpc.PatientMotionSensorsBlockingStub blockingStub;
			// Asynch stub
			private static PatientMotionSensorsGrpc.PatientMotionSensorsStub asyncStub;
			
			// The main method will have the logic for client.
			public static void main(String[] args) throws Exception {
			// First a channel is being created to the server from client. Here, we provide the server name (localhost) and port (50055).
				// As it is a local demo of GRPC, we can have non-secured channel (usePlaintext).
				ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50055).usePlaintext().build();

				//stubs -- generate from proto
				blockingStub = PatientMotionSensorsGrpc.newBlockingStub(channel);
				asyncStub = PatientMotionSensorsGrpc.newStub(channel);

				// Bi-Directional RPC call
				//motionMonit();
				//Server stream RPC
				// RPC call with Asynchronous stub
				operationScheduleAsync();
				
				// RPC call with Blocking stub
				operationScheduleBlocking();
				

				// Closing the channel once message has been passed.		
				channel.shutdown();

			}
			//Bi-Directional RPC
			public static void motionMonit() {

				// Handling the server stream for client using onNext (logic for handling each message in stream), onError, onCompleted (logic will be executed after the completion of stream)
				StreamObserver<MonitorAlertResponse> responseObserver = new StreamObserver<MonitorAlertResponse>() {
					int count =0;
					@Override
					public void onNext(MonitorAlertResponse value) {

						System.out.println("The motion status is: " + value.getAlert());
						count+=1;
					}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onCompleted() {
						// TODO Auto-generated method stub
						System.out.println("server completed" +count);
					}



				};
				

				// Here, we are calling the Remote reverseStream method. Using onNext, client sends a stream of messages.
				StreamObserver<PatientCabinRequest> requestObserver = asyncStub.motionMonit(responseObserver);
				//boolean action  = true;
				//MonitorAlertResponse reply;
				/**if(action)
				{
					//reply=MonitorAlertResponse.newBuilder().setAlert("CAUTION: Immediate attention required").build();
					System.out.println("CAUTION: Immediate attention required");
				}
				else {
					//reply=MonitorAlertResponse.newBuilder().setAlert("Normal: Continues monitering required").build();
					System.out.println("Normal: Continues monitering required");
				}**/
			try {

					requestObserver.onNext(PatientCabinRequest.newBuilder().setAction(true).build());
//					requestObserver.onNext(PatientCabinRequest.newBuilder().setAction(false).build());
//				

					//System.out.println("SENDING MESSAGES");

					// Mark the end of requests
					requestObserver.onCompleted();


					// Sleep for a bit before sending the next one.
					Thread.sleep(new Random().nextInt(1000) + 500);


				} catch (RuntimeException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}


			}
			
			// Server streaming in Async stub
			public static void operationScheduleAsync() {
				// First creating a request message. Here, the message contains a string in setData
			
				DoctorEntryRequest request = DoctorEntryRequest.newBuilder().setData("Emergency").build();

				// Handling the stream from server using onNext (logic for handling each message in stream), onError, onCompleted (logic will be executed after the completion of stream)
				StreamObserver<ScheduledResponse> responseObserver = new StreamObserver<ScheduledResponse>() {

					
					int count =0;

					@Override
					public void onNext(ScheduledResponse data) {
						System.out.println("receiving messages " + data.getBooking());
						count+=1;
					}

					@Override
					public void onError(Throwable t) {
						t.printStackTrace();

					}

					@Override
					public void onCompleted() {
						System.out.println("stream is completed ..." +count+" received schedule on ");
					}

				};

				// Here, we are calling the Remote split method. On receiving the message from server the onNext, onError, onCompleted will be called (as defined above). 
				asyncStub.operationSchedule (request, responseObserver);


				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}

			//blocking server-streaming
			public static void operationScheduleBlocking() {
				// First creating a request message. Here, the message contains a string in setData
				
				DoctorEntryRequest request = DoctorEntryRequest.newBuilder().setData("Emergency").build();
				
				
			    
			   
			    
				// as this call is blocking. The client will not proceed until all the messages in stream has been received. 
				try {
					// Iterating each message in response when calling remote split RPC method.
					Iterator<ScheduledResponse> responces = blockingStub.operationSchedule(request);
					//System.out.println(t);
				    //System.out.println(d);
					
					//Client keeps a check on the next message in stream.
			
					while (responces.hasNext()) {
				    
				    ScheduledResponse temp = responces.next();
						System.out.println(temp.getBooking());				
					}

				} catch (StatusRuntimeException e) {
					e.printStackTrace();
				}
				
			}


}
