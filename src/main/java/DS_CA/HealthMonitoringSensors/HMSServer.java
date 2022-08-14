
	//Name of the package where all the generated files are present.
	package DS_CA.HealthMonitoringSensors;


		import java.io.FileInputStream;
	//required java packages for the program. Depends on your logic.
		import java.io.IOException;
	import java.io.InputStream;
	import java.net.InetAddress;
	import java.util.Scanner;
		import java.util.ArrayList;
		import java.util.Iterator;
import java.util.List;
import java.util.Properties;
	import java.util.concurrent.TimeUnit;
	import java.util.logging.Logger;

		import com.google.api.Service;
		import javax.jmdns.JmDNS;
		import javax.jmdns.ServiceInfo;

		//required grpc package for the server side
		import io.grpc.Server;
		import io.grpc.ServerBuilder;
		import io.grpc.Status;
		import io.grpc.StatusRuntimeException;
		import io.grpc.stub.StreamObserver;

	//This is ImplBase class that was generated from the proto file.
		//You need to change this location for your projects. NOTICE: The class is in StringsServiceGrpc.java -> StringsServiceImplBase class (this Base class is generated from proto file option java_outer_classname)
		import DS_CA.HealthMonitoringSensors.HealthMonitoringSensorsGrpc.HealthMonitoringSensorsImplBase;
import DS_CA.HealthMonitoringSensors.Empty;
import DS_CA.HealthMonitoringSensors.Message;
import DS_CA.HealthMonitoringSensors.PatientBMIRequest;
import DS_CA.HealthMonitoringSensors.BMIResultResponse;
import DS_CA.HealthMonitoringSensors.VisitorEntryRequest;
import DS_CA.HealthMonitoringSensors.TempResponse;


		//Extend the ImplBase imported class here. It is an Interface file with required rpc methods
		public class HMSServer extends HealthMonitoringSensorsImplBase {

		//First we create a logger to show server side logs in the console. logger instance will be used to log different events at the server console.
			//private static final Logger logger = Logger.getLogger(SMRServer.class.getName());

		//Main method would contain the logic to start the server.	For throws keyword refer https://www.javatpoint.com/throw-keyword
		//NOTE: THIS LOGIC WILL BE SAME FOR ALL THE TYPES OF SERVICES
			 public static void main(String[] args) throws IOException, InterruptedException {
				    
				 // The StringServer is the current file name/ class name. Using an instance of this class different methods could be invoked by the client.
				 HMSServer hmsServer = new HMSServer();
				 Properties prop = hmsServer.getProperties();
				 hmsServer.registerServices(prop);
				 	// This is the port number where server will be listening to clients. Refer - https://en.wikipedia.org/wiki/Port_(computer_networking) 
				    int port = 50058;
				    
				    try {
				    // Here, we create a server on the port defined in in variable "port" and attach a service "SmartMedicalRecordsServer" (instance of the class) defined above.
				    Server server = ServerBuilder.forPort(port) // Port is defined in line 49
				        .addService(hmsServer) // Service is defined in line 31
				        .build() // Build the server
				        .start(); // Start the server and keep it running for clients to contact.
				    
				    // Giving a logging information on the server console that server has started
				    System.out.println("Server started, listening on patient record " + port);
				    server.awaitTermination(50055, TimeUnit.MILLISECONDS);
					
					System.out.println("Ganesan_CA, Thank you for visiting Smart Hospital service");
				    // Server will be running until externally terminated.
				    server.awaitTermination();
			 }
				    catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 }
		private void registerServices(Properties prop) {
			try {
	            // Create a JmDNS instance
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            
	            String service_type = prop.getProperty("service_type") ;//"_http._tcp.local.";
	            String service_name = prop.getProperty("service_name")  ;// "example";
	           // int service_port = 1234;
	            int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;

	            
	            String service_description_properties = prop.getProperty("service_description")  ;//"path=index.html";
	            
	            // Register a service
	            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
	            jmdns.registerService(serviceInfo);
	            
	            System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);
	            
	            // Wait a bit
	            Thread.sleep(1000);

	            // Unregister all services
	            jmdns.unregisterAllServices();

	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}

		private Properties getProperties() {
			Properties prop = null;		
			
			 try (InputStream input = new FileInputStream("src/main/resources/sm.properties")) {

		            prop = new Properties();

		            // load a properties file
		            prop.load(input);

		            // get the property value and print it out
		            System.out.println("Smart hospital properies ...");
		            System.out.println("\t service_type: " + prop.getProperty("service_type"));
		            System.out.println("\t service_name: " +prop.getProperty("service_name"));
		            System.out.println("\t service_description: " +prop.getProperty("service_description"));
			        System.out.println("\t service_port: " +prop.getProperty("service_port"));

		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
		
			 return prop;
				
		}

		
			
		//These RPC methods have been defined in the proto files. The interface is already present in the ImplBase File.
//			NOTE - YOU MAY NEED TO MODIFY THIS LOGIC FOR YOUR PROJECTS BASED ON TYPE OF THE RPC METHODS 
		//For override Refer - https://docs.oracle.com/javase/8/docs/api/java/lang/Override.html	 
			
			// This is the second RPC method defined in proto file. It accepts an argument and return one.
			
			// These RPC methods have been defined in the proto files. The interface is already present in the ImplBase File.
//			NOTE - YOU MAY NEED TO MODIFY THIS LOGIC FOR YOUR PROJECTS BASED ON TYPE OF THE RPC METHODS 
		// For override Refer - https://docs.oracle.com/javase/8/docs/api/java/lang/Override.html	 
		 
			
			@Override
		/**public StreamObserver<VisitorEntryRequest> tempScanner(
				StreamObserver<TempResponse> responseObserver) {
			
			// Retrieve the value from the stream of requests of the client. 
			return new StreamObserver<VisitorEntryRequest>() {
				
				ArrayList<Double> list = new ArrayList();
				
		
				
				// For each message in the stream, get one stream at a time.
				// NOTE: YOU MAY MODIFY THE LOGIC OF onNext, onError, onCompleted BASED ON YOUR PROJECT.
				@Override
				public void onNext(VisitorEntryRequest tempreq) {
					// Here, in this example we compute the value of string length for each message in the stream. 
					System.out.println("The observed Boday temperature is -> " + tempreq.getTempRange());
					// Keep on adding all the length values to compute the total length of strings sent by the client in the stream 
					list.add(tempreq.getTempRange());
					
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}

				// Once the complete stream is received this logic will be executed.
				@Override
				public void onCompleted() {
					// Preparing and sending the reply for the client. Here, response is build and with the value (length) computed by above logic.
					 // Here, response is sent once the client is done with sending the stream.
					
					System.out.printf("receiving body temperature range  \n" );
					
			        {
					double list1 = list.add(tempreq.getTemRange());


					TempResponse result;
					for (int i=0; i<list.size(); i++) {
					if(list1 >= 37.8) {
						result = TempResponse.newBuilder().setAccess("STOP: Your body temperature is hight and NO Access in to hospital.").build();
					}
					else {
						result = TempResponse.newBuilder().setAccess("Approved: Welcome and you access in approved, Thank you.").build();
					}
					
					
					// Preparing the reply for the client. Here, response is build and with the value (output) computed by above logic.  
							
					TempResponse entry = TempResponse.newBuilder().setAccess(result.toString()).build();
			          responseObserver.onNext(entry);
			          responseObserver.onCompleted();
				}
				
				
			};
				}**/
			
		
				
				public void empty(Message request, StreamObserver<Empty> responseObserver) {

					System.out.println("empty message "+ request.getOperation());
						
					//will generate an error CANCELLED: HTTP/2 error code: CANCEL
					Empty reply = Empty.newBuilder().build();
					
					// sending an empty response. No value is there.
					responseObserver.onNext(reply); 
					
					StatusRuntimeException er = new StatusRuntimeException(Status.ABORTED);
					responseObserver.onError(er);
				  
					responseObserver.onCompleted();
				}


				// This is the second RPC method defined in proto file. It accepts an argument and return one.
				public void bmi(PatientBMIRequest request, StreamObserver<BMIResultResponse> responseObserver) {
					
					System.out.println("receiving Boday Mass Index (BMI) inputes, Height (in meter) : "+ request.getHeight() + " Weight(in Kg): "+ request.getWeight());
					
						//String bmiStatus =  Double.toString(request.getHeight(), request.getWeight());
						 double bmi = (100*100*request.getWeight())/((request.getHeight())*(request.getHeight()));
					     
					        System.out.println("Your BMI is: "+bmi);
					        //printBMICategory(bmi);
					        BMIResultResponse bmiResponse; 
						
					        if(bmi < 18.5) {
							bmiResponse =BMIResultResponse.newBuilder().setBmiStatus("You are underweight").build(); 
				        }else if (bmi < 25) {
				        	bmiResponse =BMIResultResponse.newBuilder().setBmiStatus("You are normal").build(); 
				        	
				        }else if (bmi < 30) {
				        	bmiResponse =BMIResultResponse.newBuilder().setBmiStatus("You are overweight").build(); 

				        }else {
				        	bmiResponse =BMIResultResponse.newBuilder().setBmiStatus("You are obese").build(); 

			
				        }
						
						BMIResultResponse finalresult = BMIResultResponse.newBuilder().setBmiStatus(bmiResponse.toString()).build();
						
						responseObserver.onNext(finalresult);
						responseObserver.onCompleted();
			}
				/**
				public StreamObserver<PatientBMIRequest> bmi(StreamObserver<BMIResultResponse> responseObserver) {
				
				return new StreamObserver<PatientBMIRequest> () {

					@Override
					public void onNext(PatientBMIRequest bmiInput) {
						System.out.println("receiving Boday Mass Index (BMI) inputes, Height (in meter) : "+ bmiInput.getHeight() + " Weight(in Kg): "+ bmiInput.getWeight());
						
					//	String compute =  Double.toString(bmiInput.getHeight(),bmiInput.getHeight());
						 double bmi = (100*100*bmiInput.getWeight())/((bmiInput.getHeight())*(bmiInput.getHeight()));
					        
					        System.out.println("Your BMI is: "+bmi);
					        //printBMICategory(bmi);
					        BMIResultResponse bmiResponse; 
						if(bmi < 18.5) {
							bmiResponse =BMIResultResponse.newBuilder().setBmiStatus("You are underweight").build(); 
				        }else if (bmi < 25) {
				        	bmiResponse =BMIResultResponse.newBuilder().setBmiStatus("You are normal").build(); 
				        	
				        }else if (bmi < 30) {
				        	bmiResponse =BMIResultResponse.newBuilder().setBmiStatus("You are overweight").build(); 

				        }else {
				        	bmiResponse =BMIResultResponse.newBuilder().setBmiStatus("You are obese").build(); 

			
				        }
						
						BMIResultResponse finalresult = BMIResultResponse.newBuilder().setBmiStatus(bmiResponse.toString()).build();
						
						responseObserver.onNext(finalresult);
						
					}

					@Override
					public void onError(Throwable t) {
						
						t.printStackTrace();
						
					}

					@Override
					public void onCompleted() {
						System.out.println("receiving BMI completed ");
						
						//completed too
						responseObserver.onCompleted();
					}
					
				};**/
			
			
			
			
	}
			


	

