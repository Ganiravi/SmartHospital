// Name of the package where all the generated files are present.
package DS_CA.SmartMedicalRecords;


	//required java packages for the program. Depends on your logic.
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Iterator;
	import java.util.Random;
	
	import java.util.logging.Logger;

import com.google.protobuf.GeneratedMessageV3.Builder;

//required grpc package for the client side
	import io.grpc.ManagedChannel;
	import io.grpc.ManagedChannelBuilder;
	import io.grpc.Status;
	import io.grpc.StatusRuntimeException;
	import io.grpc.stub.StreamObserver;

	//This is to include rpc method enum message
	import DS_CA.SmartMedicalRecords.Message.Enum;
	//import DS_CA.SmartMedicalRecords.SmartMedicalRecordsGrpc.SmartMedicalRecordsBlockingStub;
	//import DS_CA.SmartMedicalRecords.SmartMedicalRecordsGrpc.SmartMedicalRecordsStub;
	


	// Client need not to extend any other class (GRPC related code) here 
	public class SMRClient {
		// First we create a logger to show client side logs in the console. logger instance will be used to log different events at the client console.
		// This is optional. Could be used if needed.
		//private static  Logger logger = Logger.getLogger(SMRClient.class.getName());

		// Creating stubs for establishing the connection with server.
		// Blocking stub
		private static SmartMedicalRecordsGrpc.SmartMedicalRecordsBlockingStub blockingStub;
		// Asynch stub
		private static SmartMedicalRecordsGrpc.SmartMedicalRecordsStub asyncStub;
		
		// The main method will have the logic for client.
		public static void main(String[] args) throws Exception {
		// First a channel is being created to the server from client. Here, we provide the server name (localhost) and port (50055).
			// As it is a local demo of GRPC, we can have non-secured channel (usePlaintext).
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50055).usePlaintext().build();

			//stubs -- generate from proto
			blockingStub = SmartMedicalRecordsGrpc.newBlockingStub(channel);
			asyncStub = SmartMedicalRecordsGrpc.newStub(channel);

			// Unary RPC call
			recordAccess();
			//client stream RPC
			accessPharmacy();

			//empty(); 	//passing an empty message - no server reply, error message

			// Closing the channel once message has been passed.		
			channel.shutdown();

		}


		//unary rpc
		public static void recordAccess() {
			// First creating a request message. Here, the message contains a string in setVal
			PatientIDRequest req = PatientIDRequest.newBuilder().setPID("545").build();
			//req=PatientRecordResponse.getDefaultInstance("1").build();
			//  Calling a remote RPC method using blocking stub defined in main method. req is the message we want to pass.
			PatientRecordResponse response = blockingStub.recordAccess(req);
			
			//response contains the output from the server side. Here, we are printing the value contained by response. 
			System.out.println(response.getVal());
		}


		//unary rpc
		public static void empty() {
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

		}
		//Client stream RPC
		static String getPrescription(){
			ArrayList<String> list = new ArrayList<String>();
		     
	        // Initialize an ArrayList with add()
	        list.add("Alendronic acid\r\n"
	        		+ "Allopurinol\r\n"
	        		+ "Alogliptin\r\n"
	        		+ "Benzoyl peroxide\r\n"
	        		+ "Benzydamine\r\n"
	        		+ "Betahistine\r\n"
	        		+ "Amitriptyline for depression\r\n"
	        		+ "Amitriptyline for pain and migraine\r\n"
	        		+ "Amlodipine\r\n"
	        		+ "Ciprofloxacin\r\n"
	        		+ "Citalopram\r\n"
	        		+ "Clobetasol");
	        list.add("Amoxicillin\r\n"
	        		+ "Anastrozole\r\n"
	        		+ "Apixaban\r\n"
	        		+ "Aspirin for pain relief\r\n"
	        		+ "Aspirin – low-dose, see Low-dose aspirin\r\n"
	        		+ "Diltiazem\r\n"
	        		+ "Diphenhydramine\r\n"
	        		+ "Dipyridamole\r\n"
	        		+ "Budesonide inhalers\r\n"
	        		+ "Budesonide nasal spray\r\n"
	        		+ "Budesonide rectal foam and enemas");
	        list.add("Aciclovir (Zovirax)"
	        		+ "Acrivastine\r\n"
	        		+ "Adalimumab\r\n"
	        		+ "Beclometasone skin creams\r\n"
	        		+ "Beclometasone tablets\r\n"
	        		+ "Bendroflumethiazide\r\n"
	        		+ "Calcipotriol\r\n"
	        		+ "Candesartan\r\n"
	        		+ "Carbamazepine\r\n"
	        		+ "Carbimazole\r\n"
	        		+ "Carbocisteine\r\n"
	        		+ "Amoxicillin\r\n"
	        		+ "Anastrozole\r\n"
	        		+ "Apixaban\r\n"
	        		+ "Aspirin for pain relief");
	        list.add("Carmellose sodium\r\n"
	        		+ "Carvedilol\r\n"
	        		+ "Cefalexin\r\n"
	        		+ "Cinnarizine\r\n"
	        		+ "Fluoxetine (Prozac)\r\n"
	        		+ "Fluticasone inhalers\r\n"
	        		+ "Clotrimazole\r\n"
	        		+ "Clotrimazole for thrush (Canesten)");
	        
	    	list.add("Dabigatran\r\n"
	    	        		+ "Dapagliflozin\r\n"
	    	        		+ "Docusate\r\n"
	    	        		+ "Domperidone\r\n"
	    	        		+ "Donepezil\r\n"
	    	        		+ "Edoxaban\r\n"
	    	        		+ "Empagliflozin\r\n"
	    	        		+ "Enalapril\r\n"
	    	        		+ "Ferrous fumarate\r\n"
	    	        		+ "Ferrous sulfate\r\n"
	    	        		+ "Esomeprazole\r\n"
	    	        		+ "Ezetimibe");
	        		list.add("Dabigatran\r\n"
	        		+ "Dapagliflozin\r\n"
	        		+ "Dexamethasone tablets and liquid\r\n"
	        		+ "Clobetasone\r\n"
	        		+ "Clonazepam\r\n"
	        		+ "Clopidogrel\r\n"
	           		+ "Edoxaban\r\n"
	        		+ "Empagliflozin\r\n"
	        		+ "Enalapril\r\n"
	        		+ "Eplerenone");
	        	
	        list.add("Felodipine\r\n"
	        		+ "Fentanyl\r\n"
	        		+ "Diclofenac\r\n"
	        		+ "Eplerenone\r\n"
	        		+ "Erythromycin\r\n"
	        		+ "Escitalopram\r\n"
	        		+ "Digoxin\r\n"
	        		+ "Dihydrocodeine\r\n"
	        		+ "Fexofenadine\r\n"
	        		+ "Finasteride\r\n"
	        		+ "Flucloxacillin\r\n"
	        		+ "Fluconazole\r\n"
	        		+ "Fybogel (ispaghula husk)");
	        list.add("Gabapentin\r\n"
	        		+ "Gaviscon (alginic acid)\r\n"
	        		+ "Gliclazide\r\n"
	        		+ "Glimepiride\r\n"
	        		+ "Glyceryl trinitrate (GTN)\r\n"
	        		+ "Heparinoid\r\n"
	        		+ "Hyoscine hydrobromide (Kwells and Joy-Rides)");
	        list.add("Letrozole\r\n"
	        		+ "Levetiracetam\r\n"
	        		+ "Levothyroxine\r\n"
	        		+ "Glyceryl trinitrate (GTN)\r\n"
	        		+ "Heparinoid\r\n"
	        		+ "Hydrocortisone\r\n"
	        		+ "Loratadine (Clarityn)\r\n"
	        		+ "Isotretinoin gel (Isotrex)");
	        list.add("Macrogol\r\n"
	        		+ "Mebendazole\r\n"
	        		+ "Mebeverine\r\n"
	        		+ "Melatonin\r\n"
	        		+ "Mesalazine");
	        list.add("Macrogol\r\n"
	        		+ "Mebendazole\r\n"
	        		+ "Mebeverine\r\n"
	        		+ "Melatonin\r\n"
	        		+ "Methotrexate\r\n"
	        		+ "Losartan\r\n"
	        		+ "Low-dose aspirin\r\n"
	        		+ "Lymecycline");
	        list.add("Irbesartan\r\n"
	        		+ "Isosorbide mononitrate and isosorbide dinitrate\r\n"
	        		+ "Isotretinoin capsules (Roaccutane)\r\n"
	        		+ "Labetalol\r\n"
	        		+ "Lactulose\r\n"
	        		+ "Lamotrigine\r\n"
	        		+ "Lansoprazole");
	        Random r = new Random();

	        int randomitem = r.nextInt(list.size());
	        String randomPrescrib = list.get(randomitem);
	        
			
	        return randomPrescrib;
	    }
		
		public static void accessPharmacy() {

			// Handling the stream for client using onNext (logic for handling each message in stream), onError, onCompleted (logic will be executed after the completion of stream)
			StreamObserver<MedicineListResponse> responseObserver = new StreamObserver<MedicineListResponse>() {

				@Override
				public void onNext(MedicineListResponse value) {
					System.out.println("receiving the Prescription list : " + getPrescription());
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onCompleted() {
					System.out.println("completed ");

				}

			};

			
			// Here, we are calling the Remote length method. Using onNext, client sends a stream of messages.
			StreamObserver<ConsultIDRequest> requestObserver = asyncStub.accessPharmacy(responseObserver);
			
			ArrayList<Integer>  lista = new ArrayList<Integer>();
			lista.add(159);
			lista.add(170);
			lista.add(256);
			lista.add(206);
			lista.add(356);
			lista.add(443);
			lista.add(678);
			lista.add(982);
			lista.add(550);
			

			Random r = new Random();
			
			int randomCID = r.nextInt(lista.size());
	        int randCoulID = lista.get(randomCID);
	       
	        
	       // return randCoulID;
			
			
			try {
				
				requestObserver.onNext(ConsultIDRequest.newBuilder().setCoulID(String.valueOf(randCoulID)).build());
//				requestObserver.onNext(ConsultIDRequest.newBuilder().setCoulID("233").build());

				System.out.println("SENDING MESSAGES");

				// Mark the end of requests
				requestObserver.onCompleted();


				// Sleep for a bit before sending the next one.
				Thread.sleep(new Random().nextInt(1000) + 200);


			} catch (RuntimeException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}


		}


	}


