//Name of the package where all the generated files are present.
package DS_CA.HealthMonitoringSensors;

//List of java packages/imports for the program. Depends on your logic.


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.net.InetAddress;
	import java.util.Iterator;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;
		
	import com.google.api.Service;
	import javax.jmdns.JmDNS;
	import javax.jmdns.ServiceInfo;
	import javax.jmdns.impl.JmDNSImpl.Operation;
	
	//required grpc package for the server side
	import io.grpc.Server;
	import io.grpc.ServerBuilder;
	import io.grpc.Status;
	import io.grpc.StatusRuntimeException;
	import io.grpc.stub.StreamObserver;

	//This is ImplBase class that was generated from the proto file.
	import DS_CA.HealthMonitoringSensors.HealthMonitoringSensorsGrpc.HealthMonitoringSensorsImplBase;
	import DS_CA.HealthMonitoringSensors.PatientBMIRequest;
	import DS_CA.HealthMonitoringSensors.PatientBMIRequest.Bmistat;
	import DS_CA.HealthMonitoringSensors.BMIResultResponse;
	import DS_CA.HealthMonitoringSensors.VisitorEntryRequest;
	import DS_CA.HealthMonitoringSensors.TempResponse;


	//The ImplBase imported class. It is an Interface file with required rpc methods
	public class HMSServer extends HealthMonitoringSensorsImplBase {

   
		//Main method which contain the logic to start the server.	For throws keyword refer https://www.javatpoint.com/throw-keyword

    public static void main(String[] args) throws IOException, InterruptedException {

        // The HMSServer is the current file name/ class name. Using an instance of this class different methods could be invoked by the client.
        HMSServer hmsServer = new HMSServer();
        Properties prop = hmsServer.getProperties();
        hmsServer.registerServices(prop);
        // This is the port number where server will be listening to clients. Refer - https://en.wikipedia.org/wiki/Port_(computer_networking) 
        int port = 50055;

        try {
            // Creating a server on the port defined in in variable "port" and attach a service "SmartMedicalRecordsServer" (instance of the class) defined above.
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
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    //service registor
    private void registerServices(Properties prop) {
        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            String service_type = prop.getProperty("service_type"); //"_http._tcp.local.";
            String service_name = prop.getProperty("service_name"); // "example";
           
            int service_port = Integer.valueOf(prop.getProperty("service_port")); // #.50051;


            String service_description_properties = prop.getProperty("service_description"); //"path=index.html";

            // Register a service
            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
            jmdns.registerService(serviceInfo);

            System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);

            // Wait a bit
            Thread.sleep(800);

            // Unregister all services
            jmdns.unregisterAllServices();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    //Getting the property from sm.properties
    private Properties getProperties() {
        Properties prop = null;

        try (InputStream input = new FileInputStream("src/main/resources/sm.properties")) {

            prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println("Smart hospital properies ...");
            System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " + prop.getProperty("service_name"));
            System.out.println("\t service_description: " + prop.getProperty("service_description"));
            System.out.println("\t service_port: " + prop.getProperty("service_port"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;
    }


  //These RPC methods have been defined in the proto files. The interface is already present in the ImplBase File.

  	//For override Refer - https://docs.oracle.com/javase/8/docs/api/java/lang/Override.html	 

    //rpc method for client streaming
    @Override
    public StreamObserver < VisitorEntryRequest > tempScanner(StreamObserver < TempResponse > responseObserver) {

        // Retrieve the value from the stream of requests of the client. 
        return new StreamObserver < VisitorEntryRequest > () {

            double temp = 0;

            // For each message in the stream, get one stream at a time.
            @Override
            public void onNext(VisitorEntryRequest tempreq) {
                // Here, in this example we compute the value of string length for each message in the stream. 
                System.out.println("The observed Boday temperature is -> " + tempreq.getTempRange());

                temp = tempreq.getTempRange();

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

                System.out.printf("receiving body temperature range  \n");
                //Logic for this methods to check the given temperature range wis within acceptatble level to allow access to hospital
                TempResponse result;
                if (temp >= 37.8) {//approved temp range
                    result = TempResponse.newBuilder().setAccess("STOP: Your body temperature is hight and NO Access in to hospital.").build();
                } else {
                    result = TempResponse.newBuilder().setAccess("Approved: Welcome and you access in approved, Thank you.").build();
                }


                // Preparing the reply for the client. 

                TempResponse entry = TempResponse.newBuilder().setAccess(result.toString()).build();
                responseObserver.onNext(entry);
                responseObserver.onCompleted();

            }
        };
    }

//Bidirection method for BMI
    public StreamObserver < PatientBMIRequest > bmi(StreamObserver < BMIResultResponse > responseObserver) {

        return new StreamObserver < PatientBMIRequest > () {

            @Override
            public void onNext(PatientBMIRequest bmiInput) {
                System.out.println("receiving Boday Mass Index (BMI) inputes, Height (in meter) : " + bmiInput.getHeight() + " Weight(in Kg): " + bmiInput.getWeight());

                //Logic method to calculate the BMI as per the given height and weight
                double bmi = (100 * 100 * bmiInput.getWeight()) / ((bmiInput.getHeight()) * (bmiInput.getHeight()));

                System.out.println("Your BMI is: " + bmi);
               
                BMIResultResponse bmiResponse;
                if (bmiInput.getOperation() == Bmistat.BMILEVEL) {
                if (bmi < 18.5) {
                    bmiResponse = BMIResultResponse.newBuilder().setBmiStatus("You are underweight").build();
                } else if (bmi < 25) {
                    bmiResponse = BMIResultResponse.newBuilder().setBmiStatus("You are normal").build();

                } else if (bmi < 30) {
                    bmiResponse = BMIResultResponse.newBuilder().setBmiStatus("You are overweight").build();

                } else {
                    bmiResponse = BMIResultResponse.newBuilder().setBmiStatus("You are obese").build();


                }
                // sending communication
                BMIResultResponse finalresult = BMIResultResponse.newBuilder().setBmiStatus(bmiResponse.toString()).build();

                responseObserver.onNext(finalresult);
                }
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

        };

    }
}