
	// Name of the package where all the generated files are present.
	package DS_CA.HealthMonitoringSensors;

		//required java packages for the program. Depends on your logic.
		import java.util.ArrayList;
		import java.util.Arrays;
		import java.util.Iterator;
		import java.util.Random;
		
		import java.util.logging.Logger;

	import com.google.protobuf.GeneratedMessageV3.Builder;

import DS_CA.HealthMonitoringSensors.VisitorEntryRequest;
import DS_CA.HealthMonitoringSensors.PatientBMIRequest;
import DS_CA.HealthMonitoringSensors.BMIResultResponse;
import DS_CA.HealthMonitoringSensors.TempResponse;
//required grpc package for the client side
		import io.grpc.ManagedChannel;
		import io.grpc.ManagedChannelBuilder;
		import io.grpc.Status;
		import io.grpc.StatusRuntimeException;
		import io.grpc.stub.StreamObserver;

		//This is to include rpc method enum message
		//import DS_CA.SmartMedicalRecords.Message.Enum;
		import DS_CA.HealthMonitoringSensors.HealthMonitoringSensorsGrpc.HealthMonitoringSensorsBlockingStub;
		import DS_CA.HealthMonitoringSensors.HealthMonitoringSensorsGrpc.HealthMonitoringSensorsStub;
import DS_CA.HealthMonitoringSensors.Empty;
import DS_CA.HealthMonitoringSensors.Message;
import DS_CA.HealthMonitoringSensors.Message.Bmistat;
		


		// Client need not to extend any other class (GRPC related code) here 
		public class HMSClient {
			// First we create a logger to show client side logs in the console. logger instance will be used to log different events at the client console.
			// This is optional. Could be used if needed.
			//private static  Logger logger = Logger.getLogger(SMRClient.class.getName());

			// Creating stubs for establishing the connection with server.
			// Blocking stub
			private static HealthMonitoringSensorsGrpc.HealthMonitoringSensorsBlockingStub blockingStub;
			// Asynch stub
			private static HealthMonitoringSensorsGrpc.HealthMonitoringSensorsStub asyncStub;
			
			// The main method will have the logic for client.
			public static void main(String[] args) throws Exception {
			// First a channel is being created to the server from client. Here, we provide the server name (localhost) and port (50055).
				// As it is a local demo of GRPC, we can have non-secured channel (usePlaintext).
				ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50055).usePlaintext().build();

				//stubs -- generate from proto
				blockingStub = HealthMonitoringSensorsGrpc.newBlockingStub(channel);
				asyncStub = HealthMonitoringSensorsGrpc.newStub(channel);

				
				//client stream RPC
				//tempScanner();
				// Unary RPC call
				bmi();
				//empty(); 	//passing an empty message - no server reply, error message

				// Closing the channel once message has been passed.		
				channel.shutdown();

			}

			
	/**		public static void tempScanner() {

				StreamObserver<TempResponse> responseObserver = new StreamObserver<TempResponse>() {

					@Override
					public void onNext(TempResponse msg) {
						System.out.println("Scanning in progress " + msg.getAccess() );
					}

					@Override
					public void onError(Throwable t) {
						t.printStackTrace();
					}

					@Override
					public void onCompleted() {
						System.out.println("stream is completed ... receiveing Temperature scanner result");
					}

				};


				StreamObserver<VisitorEntryRequest> requestObserver = asyncStub.tempScanner(responseObserver);
				
				
				try {
					requestObserver.onNext(VisitorEntryRequest.newBuilder().setTempRange(37.6).build());
					// Mark the end of requests
					requestObserver.onCompleted();

					
					Thread.sleep(10000);
					
				} catch (RuntimeException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}

}**/
			
			//unary rpc
			public static void bmi() {
				// First creating a request message. Here, the message contains a string in setVal
				PatientBMIRequest req = PatientBMIRequest.newBuilder().setHeight(1.6).setWeight(89).build();
				//req=PatientRecordResponse.getDefaultInstance("1").build();
				//  Calling a remote RPC method using blocking stub defined in main method. req is the message we want to pass.
				BMIResultResponse response = blockingStub.bmi(req);
				
				//response contains the output from the server side. Here, we are printing the value contained by response. 
				System.out.println("BMI Status is " +response.getBmiStatus());
			}


			//unary rpc
		/**	public static void empty() {
				// First creating a request message. Here, the message contains emply message as defined in proto enum
				Message req = Message.newBuilder().setDetail(Enum.UNKNOWN).build();
				try {
					// Calling a remote RPC method using blocking stub defined in main method. req is the message we want to pass.
					Empty response = blockingStub.empty(req);
					//response contains the output from the server side. Here, we are printing the value contained by response.
					System.out.println("one response " + response.toString());

				}catch(StatusRuntimeException ex) {
					// Print if any error/exception is generated.
					System.out.println( ex.getMessage());
					//ex.printStackTrace();
				}

			}**/
			
			
		/**	public static void BMI() {


				StreamObserver<BMIResultResponse> responseObserver = new StreamObserver<BMIResultResponse>() {

					int bmiOutput =0 ;

					@Override
					public void onNext(BMIResultResponse inputBMI) {
						System.out.println("receiving BMI status " + inputBMI.getBmiStatus());
						bmiOutput += 1;
					}

					@Override
					public void onError(Throwable t) {
						t.printStackTrace();

					}

					@Override
					public void onCompleted() {
						System.out.println("stream is completed ... received "+ bmiOutput+ " converted numbers");
					}

				};



				StreamObserver<PatientBMIRequest> requestObserver = asyncStub.bmi(responseObserver);

				try {

					requestObserver.onNext(PatientBMIRequest.newBuilder().setHeight(1.6).setWeight(89).build());
									

					// Mark the end of requests
					requestObserver.onCompleted();


					// Sleep for a bit before sending the next one.
					Thread.sleep(new Random().nextInt(1000) + 500);


				} catch (RuntimeException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}



				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}	**/
			}
