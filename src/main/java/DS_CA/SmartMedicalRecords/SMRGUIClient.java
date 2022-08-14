package DS_CA.SmartMedicalRecords;


	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.jmdns.JmDNS;
	import javax.jmdns.ServiceEvent;
	import javax.jmdns.ServiceInfo;
	import javax.jmdns.ServiceListener;
import javax.jmdns.impl.JmDNSImpl.Operation;
import javax.swing.BoxLayout;
	import javax.swing.JLabel;
	import javax.swing.JTextField;

import DS_CA.SmartMedicalRecords.SmartMedicalRecordsGrpc;

import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.DefaultComboBoxModel;
	import java.awt.FlowLayout;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTextArea;

	import DS_CA.SmartMedicalRecords.SmartMedicalRecordsGrpc.SmartMedicalRecordsImplBase;
	import io.grpc.ManagedChannel;
	import io.grpc.ManagedChannelBuilder;


	import java.awt.event.ActionListener;
	import java.io.IOException;
	import java.net.InetAddress;
	import java.net.UnknownHostException;
	import java.awt.event.ActionEvent;

	public class SMRGUIClient {

		private static SmartMedicalRecordsGrpc.SmartMedicalRecordsBlockingStub blockingStub;
		private static SmartMedicalRecordsGrpc.SmartMedicalRecordsStub asyncStub;
		
		private ServiceInfo SmrServiceInfo;
		
		
		private JFrame frame;
		private JTextField textNumber1;
		private JTextArea textResponse ;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						SMRGUIClient window = new SMRGUIClient();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public SMRGUIClient() {
			
			String smartHospital_service_type = "_smartHospital._http._tcp.local";
			discoverSmartHspitalService(smartHospital_service_type);
			
			String host = SmrServiceInfo.getHostAddresses()[0];
			int port = SmrServiceInfo.getPort();
			
			ManagedChannel channel = ManagedChannelBuilder
					.forAddress(host, port)
					.usePlaintext()
					.build();

			//stubs -- generate from proto
			blockingStub = SmartMedicalRecordsGrpc.newBlockingStub(channel);

			setAsyncStub(SmartMedicalRecordsGrpc.newStub(channel));

			
			initialize();
		}

		
		
		private void discoverSmartHspitalService(String service_type) {
			
			
			try {
				// Create a JmDNS instance
				JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

					
				jmdns.addServiceListener(service_type, new ServiceListener() {
					
					@Override
					public void serviceResolved(ServiceEvent event) {
						System.out.println("Smart Hospital service 1: " + event.getInfo());

						SmrServiceInfo = event.getInfo();

						int port = SmrServiceInfo.getPort();
						
						System.out.println("resolving " + service_type + " with properties ...");
						System.out.println("\t port: " + port);
						System.out.println("\t type:"+ event.getType());
						System.out.println("\t name: " + event.getName());
						System.out.println("\t description/properties: " + SmrServiceInfo.getNiceTextString());
						System.out.println("\t host: " + SmrServiceInfo.getHostAddresses()[0]);
					
						
					}
					
					@Override
					public void serviceRemoved(ServiceEvent event) {
						System.out.println("SMR Service removed: " + event.getInfo());

						
					}
					
					@Override
					public void serviceAdded(ServiceEvent event) {
						System.out.println("SMR Service added: " + event.getInfo());

						
					}
				});
				
				// Wait a bit
				Thread.sleep(2000);
				
				jmdns.close();

			} catch (UnknownHostException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.setTitle("Client - Service Controller");
			frame.setBounds(100, 100, 500, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
			
			frame.getContentPane().setLayout(bl);
			
			JPanel panel_service_1 = new JPanel();
			frame.getContentPane().add(panel_service_1);
			panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			JLabel lblNewLabel_1 = new JLabel("Consultant ID");
			panel_service_1.add(lblNewLabel_1);
			
			textNumber1 = new JTextField();
			panel_service_1.add(textNumber1);
			textNumber1.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Prescription list");
			panel_service_1.add(lblNewLabel_2);
			
		
			
			JButton generate = new JButton("Generate");
			generate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String id = (textNumber1.getText());

					PatientIDRequest req = PatientIDRequest.newBuilder().setPID(id).build();

					PatientRecordResponse response = blockingStub.recordAccess(req);

					textResponse.append("Patient Record number is: "+ response.getVal() +  "\n");
					
					System.out.println("Patient Record number is: " + response.getVal());

				}
			});
			panel_service_1.add(generate);
			
			textResponse = new JTextArea(3, 20);
			textResponse .setLineWrap(true);
			textResponse.setWrapStyleWord(true);
			
			JScrollPane scrollPane = new JScrollPane(textResponse);
			
			//textResponse.setSize(new Dimension(15, 30));
			panel_service_1.add(scrollPane);
			
			
			JPanel panel_service_2 = new JPanel();
			frame.getContentPane().add(panel_service_2);
			
			JPanel panel_service_3 = new JPanel();
			frame.getContentPane().add(panel_service_3);
			
			
			
		}

		public static SmartMedicalRecordsGrpc.SmartMedicalRecordsStub getAsyncStub() {
			return asyncStub;
		}

		public static void setAsyncStub(SmartMedicalRecordsGrpc.SmartMedicalRecordsStub asyncStub) {
			SMRGUIClient.asyncStub = asyncStub;
		}

	}




