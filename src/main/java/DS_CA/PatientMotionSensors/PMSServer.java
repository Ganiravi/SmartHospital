	//Name of the package where all the generated files are present.
	package DS_CA.PatientMotionSensors;


		import java.io.FileInputStream;
//required java packages for the program. Depends on your logic.
		import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

//This is ImplBase class that was generated from the proto file.
		//You need to change this location for your projects. NOTICE: The class is in StringsServiceGrpc.java -> StringsServiceImplBase class (this Base class is generated from proto file option java_outer_classname)
		import DS_CA.PatientMotionSensors.PatientMotionSensorsGrpc.PatientMotionSensorsImplBase;
//required grpc package for the server side
		import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


		//Extend the ImplBase imported class here. It is an Interface file with required rpc methods
		public class PMSServer extends PatientMotionSensorsImplBase {

		//First we create a logger to show server side logs in the console. logger instance will be used to log different events at the server console.
			//private static final Logger logger = Logger.getLogger(PMSServer.class.getName());

		//Main method would contain the logic to start the server.	For throws keyword refer https://www.javatpoint.com/throw-keyword
		//NOTE: THIS LOGIC WILL BE SAME FOR ALL THE TYPES OF SERVICES
			 public static void main(String[] args) throws IOException, InterruptedException {
				    
				 // The StringServer is the current file name/ class name. Using an instance of this class different methods could be invoked by the client.
				 PMSServer pmsServer = new PMSServer();
				 Properties prop = pmsServer.getProperties();
				 pmsServer.registerServices(prop);

				 	// This is the port number where server will be listening to clients. Refer - https://en.wikipedia.org/wiki/Port_(computer_networking) 
				    int port = 50055;
				    
				    
				    // Here, we create a server on the port defined in in variable "port" and attach a service "SmartMedicalRecordsServer" (instance of the class) defined above.
				    Server server = ServerBuilder.forPort(port) // Port is defined in line 34
				        .addService(pmsServer) // Service is defined in line 31
				        .build() // Build the server
				        .start(); // Start the server and keep it running for clients to contact.
				    
				    // Giving a logging information on the server console that server has started
				    System.out.println("Server started, listening on patient record " + port);
				    server.awaitTermination(50055, TimeUnit.MILLISECONDS);
					
					System.out.println("Ganesan_CA, Thank you for visiting Smart Hospital service");
				    // Server will be running until externally terminated.
				    server.awaitTermination();
			 }
			 
				private void registerServices(Properties prop) {
					try {
			            // Create a JmDNS instance
			            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			            
			            String service_type = prop.getProperty("service_type") ;//"_http._tcp.local.";
			            String service_name = prop.getProperty("service_name")  ;// "example";
			           // int service_port = 1234;
			            int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50056;

			            
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
						System.out.println("Monitering the action in patient cabin.." +request.getAction());
					
						
						boolean flag  = request.getAction();
						 MonitorAlertResponse motion;
						if(flag)
						{
							motion=MonitorAlertResponse.newBuilder().setAlert("CAUTION: Immediate attention required").build();
						}
						else {
							motion=MonitorAlertResponse.newBuilder().setAlert("Normal: Continues monitering required").build();
						}
				        
				         // Preparing and sending the reply for the client. Here, response is build and with the value (input1.toString()) computed by above logic.
				           
			            MonitorAlertResponse reply = MonitorAlertResponse.newBuilder().setAlert(motion.toString()).build();
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
		
		
			public void operationSchedule(DoctorEntryRequest request, StreamObserver<ScheduledResponse> responseObserver) {
			 
				 System.out.println("Receiving priority:"+request.getData());
				// LOGIC of THE METHOD 
				 String dates  = request.getData();
				 ScheduledResponse reply1;
				
				
					if (dates.equals("Emergency")) {
						LocalDateTime time = LocalDateTime.ofEpochSecond(1537011000L, 0, ZoneOffset.UTC);
					   // DateTimeFormatter date = ISO_LOCAL_DATE_TIME;
						reply1 = ScheduledResponse.newBuilder().setBooking(time.toString()).build(); 
					
					}
					else {
						reply1 =ScheduledResponse.newBuilder().setBooking("Shedule is 1 week after").build();
					}
			
				
					// Preparing and sending the reply for the client. Here, response is build and with the value (c) computed by above logic.
					 // Here, a stream of response is sent using the for loop.
					 responseObserver.onNext(reply1);
					
			 
				 
				 responseObserver.onCompleted();
			
			 
	}
}

