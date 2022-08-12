//Name of the package where all the generated files are present.
package DS_CA.SmartMedicalRecords;


	import java.io.FileInputStream;
//required java packages for the program. Depends on your logic.
	import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Scanner;
	import java.util.ArrayList;
	import java.util.Iterator;
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
import DS_CA.SmartMedicalRecords.MedicineListResponse.Builder;
//This is ImplBase class that was generated from the proto file.
	//You need to change this location for your projects. NOTICE: The class is in StringsServiceGrpc.java -> StringsServiceImplBase class (this Base class is generated from proto file option java_outer_classname)
	import DS_CA.SmartMedicalRecords.SmartMedicalRecordsGrpc.SmartMedicalRecordsImplBase;


	//Extend the ImplBase imported class here. It is an Interface file with required rpc methods
	public class SMRServer extends SmartMedicalRecordsImplBase {

	//First we create a logger to show server side logs in the console. logger instance will be used to log different events at the server console.
		//private static final Logger logger = Logger.getLogger(SMRServer.class.getName());

	//Main method would contain the logic to start the server.	For throws keyword refer https://www.javatpoint.com/throw-keyword
	//NOTE: THIS LOGIC WILL BE SAME FOR ALL THE TYPES OF SERVICES
		 public static void main(String[] args) throws IOException, InterruptedException {
			    
			 // The StringServer is the current file name/ class name. Using an instance of this class different methods could be invoked by the client.
			 SMRServer smrServer = new SMRServer();
			 Properties prop = smrServer.getProperties();
			 smrServer.registerServices(prop);
			 	// This is the port number where server will be listening to clients. Refer - https://en.wikipedia.org/wiki/Port_(computer_networking) 
			    int port = 50055;
			    
			    try {
			    // Here, we create a server on the port defined in in variable "port" and attach a service "SmartMedicalRecordsServer" (instance of the class) defined above.
			    Server server = ServerBuilder.forPort(port) // Port is defined in line 34
			        .addService(smrServer) // Service is defined in line 31
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
//		NOTE - YOU MAY NEED TO MODIFY THIS LOGIC FOR YOUR PROJECTS BASED ON TYPE OF THE RPC METHODS 
	//For override Refer - https://docs.oracle.com/javase/8/docs/api/java/lang/Override.html	 
		@Override  
		public void empty(Message request, StreamObserver<Empty> responseObserver) {
			System.out.println("empty message "+ request.getDetail());
				
			//will generate an error CANCELLED: HTTP/2 error code: CANCEL
			Empty reply = Empty.newBuilder().build();
			
			// sending an empty response. No value is there.
			responseObserver.onNext(reply); 
			
			StatusRuntimeException er = new StatusRuntimeException(Status.ABORTED);
			responseObserver.onError(er);
		  
			responseObserver.onCompleted();
		}


		// This is the second RPC method defined in proto file. It accepts an argument and return one.
		@Override
		public void recordAccess(PatientIDRequest request, StreamObserver<PatientRecordResponse> responseObserver) {
			
			System.out.println("receiving record access message,");
			
			// Retrieve the value from the request of the client
			
			int pID = Integer.parseInt(request.getPID());
			// LOGIC of THE METHOD 
		
			if (pID < 1 || pID > 1000) {
	            System.out.println("Patient record in not available: "+request.getPID());
			}
			else {
				
				System.out.println("Patient record is available in system: "+request.getPID());
			}
			
			// Preparing the reply for the client. Here, response is build and with the value (output) computed by above logic.  
			PatientRecordResponse patRec = PatientRecordResponse.newBuilder().setVal("Thank you, Patient Record number is : " +request.getPID()).build();		
			
			// Sending the reply for each request.
			responseObserver.onNext(patRec);
			 
			responseObserver.onCompleted();
	}

		

		// These RPC methods have been defined in the proto files. The interface is already present in the ImplBase File.
//		NOTE - YOU MAY NEED TO MODIFY THIS LOGIC FOR YOUR PROJECTS BASED ON TYPE OF THE RPC METHODS 
	// For override Refer - https://docs.oracle.com/javase/8/docs/api/java/lang/Override.html	 
	 
		
		@Override
	public StreamObserver<ConsultIDRequest> accessPharmacy(StreamObserver<MedicineListResponse> responseObserver) {
		
		// Retrieve the value from the stream of requests of the client. 
		return new StreamObserver<ConsultIDRequest>() {
			
		
			
		
			StringBuffer sb = new StringBuffer();
			
			// For each message in the stream, get one stream at a time.
			// NOTE: YOU MAY MODIFY THE LOGIC OF onNext, onError, onCompleted BASED ON YOUR PROJECT.
			@Override
			public void onNext(ConsultIDRequest value) {
				// Here, in this example we compute the value of string length for each message in the stream. 
				System.out.println("Consulted ID is -> " + value.getCoulID()+ ", Refer the Respective prescription");
				// Keep on adding all the length values to compute the total length of strings sent by the client in the stream 
				//length += value.getCoulID().length();
				
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
				
				
				responseObserver.onNext(MedicineListResponse.newBuilder().setPrescription("prescription lists are: "+  sb.toString()).build());
				
				MedicineListResponseOrBuilder medList =MedicineListResponse.newBuilder();
				String pList = medList.toString();
				
				
				// Preparing the reply for the client. Here, response is build and with the value (output) computed by above logic.  
						
				MedicineListResponse presc = MedicineListResponse.newBuilder().setPrescription(pList).build();
		          responseObserver.onNext(presc);
		          responseObserver.onCompleted();
			}
			
			
		};
	}
	}
		

