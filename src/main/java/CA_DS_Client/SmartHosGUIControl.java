//GUI package
package CA_DS_Client;

//Imports from lib

	import java.awt.Dimension;
	import java.awt.EventQueue;
	import java.awt.Insets;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.IOException;
	import java.net.InetAddress;
	import java.net.UnknownHostException;
	import java.util.Iterator;

	import javax.jmdns.JmDNS;
	import javax.jmdns.ServiceEvent;
	import javax.jmdns.ServiceInfo;
	import javax.jmdns.ServiceListener;
	import javax.swing.Box;
	import javax.swing.BoxLayout;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	import javax.swing.border.EmptyBorder;
//imports from service 
	import DS_CA.HealthMonitoringSensors.HealthMonitoringSensorsGrpc;
	import DS_CA.SmartMedicalRecords.SmartMedicalRecordsGrpc;
	import DS_CA.PatientMotionSensors.PatientMotionSensorsGrpc;
	import DS_CA.SmartMedicalRecords.SmartMedicalRecordsGrpc.SmartMedicalRecordsBlockingStub;
	import DS_CA.SmartMedicalRecords.SmartMedicalRecordsGrpc.SmartMedicalRecordsStub;
	import DS_CA.HealthMonitoringSensors.HealthMonitoringSensorsGrpc.HealthMonitoringSensorsBlockingStub;
	import DS_CA.HealthMonitoringSensors.HealthMonitoringSensorsGrpc.HealthMonitoringSensorsStub;
	import DS_CA.PatientMotionSensors.PatientMotionSensorsGrpc.PatientMotionSensorsBlockingStub;
	import DS_CA.PatientMotionSensors.PatientMotionSensorsGrpc.PatientMotionSensorsStub;
	import DS_CA.HealthMonitoringSensors.VisitorEntryRequest;
	import DS_CA.HealthMonitoringSensors.PatientBMIRequest;
	import DS_CA.HealthMonitoringSensors.BMIResultResponse;
	import DS_CA.HealthMonitoringSensors.TempResponse;
	import DS_CA.PatientMotionSensors.PatientCabinRequest;
	import DS_CA.PatientMotionSensors.MonitorAlertResponse;
	import DS_CA.PatientMotionSensors.DoctorEntryRequest;
	import DS_CA.PatientMotionSensors.ScheduledResponse;
	import io.grpc.ManagedChannel;
	import io.grpc.ManagedChannelBuilder;

	public class SmartHosGUIControl implements ActionListener{
		
		
		private ServiceInfo serviceInfo;
		
		private static SmartMedicalRecordsBlockingStub blockingStub;
		private static SmartMedicalRecordsStub asyncStub;
		private static HealthMonitoringSensorsBlockingStub blockingStub1;
		private static HealthMonitoringSensorsStub asyncStub1;
		private static PatientMotionSensorsBlockingStub blockingStub2;
		private static PatientMotionSensorsStub asyncStub2;
		
		// my test field deceleration for entry and reply
		private JFrame frame;
		private JTextField entry1, reply1;
		private JTextField entry1A, reply1A;
		private JTextField entry2, reply2;
		private JTextField entry2A,entry2B, reply2A;
		private JTextField entry3, reply3;
		private JTextField entry3A, reply3A;
	
		//creating my JFrame panel for each methods in the services
		
		private JPanel getService1JPanel() {

			JPanel panel = new JPanel();

			BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

			JLabel label = new JLabel("Enter patient ID from 1 to 1000")	;
			panel.add(label);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));
			entry1 = new JTextField("",10);
			panel.add(entry1);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));

			JButton button = new JButton("Check patient ID availability");
			button.addActionListener(this);
			panel.add(button);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));

			reply1 = new JTextField("", 10);
			reply1 .setEditable(false);
			panel.add(reply1 );

			panel.setLayout(boxlayout);

			return panel;

		}
		
		private JPanel getService1AJPanel() {

			JPanel panel = new JPanel();

			BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

			JLabel label = new JLabel("Enter Consult ID:")	;
			panel.add(label);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));
			entry1A = new JTextField("",10);
			panel.add(entry1A);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));

			JButton button = new JButton("Get the prescription");
			button.addActionListener(this);
			panel.add(button);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));

			reply1A = new JTextField("", 100);
			reply1A .setEditable(false);
			panel.add(reply1A );

			panel.setLayout(boxlayout);

			return panel;

		}
		
		private JPanel getService2JPanel() {

			JPanel panel = new JPanel();

			BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

			JLabel label = new JLabel("Enter your scanned Temperature:")	;
			panel.add(label);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));
			entry2 = new JTextField("",10);
			panel.add(entry2);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));

			JButton button = new JButton("Check status");
			button.addActionListener(this);
			panel.add(button);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));

			reply2 = new JTextField("", 10);
			reply2 .setEditable(false);
			panel.add(reply2 );

			panel.setLayout(boxlayout);

			return panel;

		}
		
		private JPanel getService2AJPanel() {

			JPanel panel = new JPanel();

			BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

			JLabel labelA = new JLabel("Enter your height in cm:")	;
			panel.add(labelA);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));
			entry2A = new JTextField("",10);
			panel.add(entry2A);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));
			
			JLabel labelB = new JLabel("Enter your weight in kg:")	;
			panel.add(labelB);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));
			entry2B = new JTextField("",10);
			panel.add(entry2B);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));
			JButton button = new JButton("Check BMI status");
			button.addActionListener(this);
			panel.add(button);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));

			reply2A = new JTextField("", 10);
			reply2A .setEditable(false);
			panel.add(reply2A );

			panel.setLayout(boxlayout);

			return panel;

		}
		
		private JPanel getService3JPanel() {

			JPanel panel = new JPanel();

			BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

			JLabel label = new JLabel("Enter true if motion, else enter false:")	;
			panel.add(label);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));
			entry3 = new JTextField("",10);
			panel.add(entry2);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));

			JButton button = new JButton("Monitering status");
			button.addActionListener(this);
			panel.add(button);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));

			reply3 = new JTextField("", 10);
			reply3 .setEditable(false);
			panel.add(reply3);

			panel.setLayout(boxlayout);

			return panel;

		}
		private JPanel getService3AJPanel() {

			JPanel panel = new JPanel();

			BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

			JLabel label = new JLabel("Enter priority either Emergency or Normal:")	;
			panel.add(label);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));
			entry3A = new JTextField("",10);
			panel.add(entry2);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));

			JButton button = new JButton("Get your operation schedule");
			button.addActionListener(this);
			panel.add(button);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));

			reply3A = new JTextField("", 10);
			reply3A.setEditable(false);
			panel.add(reply3A);

			panel.setLayout(boxlayout);

			return panel;

		}
		
		//My main method for SmartHosGUIControl
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						SmartHosGUIControl smGui = new SmartHosGUIControl();
						smGui.frame.setVisible(true);
						smGui.initialize();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			
		}
		

		/**
		 * Create the application.
		 */
		public SmartHosGUIControl() {
			
			String sh_service_type = "_smartHospital._http._tcp.local.";
			discoverMathService(sh_service_type);
			
			String host = serviceInfo.getHostAddresses()[0];
			int port = serviceInfo.getPort();
			
			ManagedChannel channel = ManagedChannelBuilder
					.forAddress(host, port)
					.usePlaintext()
					.build();

			//stubs -- generate from proto
			
				
			
			blockingStub = SmartMedicalRecordsGrpc.newBlockingStub(channel);

			asyncStub = SmartMedicalRecordsGrpc.newStub(channel);
			
			blockingStub1 = HealthMonitoringSensorsGrpc.newBlockingStub(channel);

			asyncStub1 = HealthMonitoringSensorsGrpc.newStub(channel);
			
			blockingStub2 = PatientMotionSensorsGrpc.newBlockingStub(channel);

			asyncStub2 = PatientMotionSensorsGrpc.newStub(channel);

			
			initialize();
		}
		
		
		private void discoverMathService(String service_type) {
			
			
			try {
				// Create a JmDNS instance
				JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

					
				jmdns.addServiceListener(service_type, new ServiceListener() {
					
					@Override
					public void serviceResolved(ServiceEvent event) {
						System.out.println("Smart Hospital Service resolved: " + event.getInfo());

						serviceInfo = event.getInfo();

						int port = serviceInfo.getPort();
						
						System.out.println("resolving " + service_type + " with properties ...");
						System.out.println("\t port: " + port);
						System.out.println("\t type:"+ event.getType());
						System.out.println("\t name: " + event.getName());
						System.out.println("\t description/properties: " + serviceInfo.getNiceTextString());
						System.out.println("\t host: " + serviceInfo.getHostAddresses()[0]);
					
						
					
				}
					@Override
					public void serviceRemoved(ServiceEvent event) {
						System.out.println("Math Service removed: " + event.getInfo());

						
					}
					
					@Override
					public void serviceAdded(ServiceEvent event) {
						System.out.println("Math Service added: " + event.getInfo());
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
				
				
		private void initialize() { 

			frame = new JFrame();
			frame.setTitle("Smart Hospital Service System");
			frame.setBounds(200, 200, 500, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Set the panel to add buttons
			JPanel panel = new JPanel();

			// Set the BoxLayout to be X_AXIS: from left to right
			BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

			panel.setLayout(boxlayout);

			// Set border for the panel
			panel.setBorder(new EmptyBorder(new Insets(80, 150, 80, 150)));
		
			panel.add( getService1JPanel() );
			panel.add( getService1AJPanel() );
			panel.add( getService2JPanel() );
			panel.add( getService2AJPanel() );
			panel.add( getService3JPanel() );
			panel.add( getService3AJPanel() );
		
			// Set size for the frame
			frame.setSize(500, 800);

			// Set the window to be visible as the default to be false
			frame.add(panel);
			frame.pack();
			frame.setVisible(true);
		}
	
	
		//Action implementation upon input and selection in entry text field and passing upon clicking the Jbutton function
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource();
			String label = button.getActionCommand();  

			if (label.equals("Check patient ID availability")) {
				System.out.println("service 1 to be invoked ...");

			
				ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50056).usePlaintext().build();

				//preparing message to send
				DS_CA.SmartMedicalRecords.PatientIDRequest request = DS_CA.SmartMedicalRecords.PatientIDRequest.newBuilder().setPID(entry1.getText()).build();

				//retreving reply from service
				DS_CA.SmartMedicalRecords.PatientRecordResponse response = blockingStub.recordAccess(request);
			
				response.getUnknownFields().asMap().get(1);
				reply1.setText( response.getVal());
			
			}else if (label.equals("Get the prescription")) {
				System.out.println("service 1 A to be invoked ...");

			
			
				ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50056).usePlaintext().build();

				//preparing message to send
				DS_CA.SmartMedicalRecords.ConsultIDRequest request = DS_CA.SmartMedicalRecords.ConsultIDRequest.newBuilder().setCoulID(entry1A.getText()).build();

				//retreving reply from service
				DS_CA.SmartMedicalRecords.MedicineListResponse response = blockingStub.accessPharmacy(request);
			
				response.getUnknownFields().asMap().get(1);
				reply1A.setText( response.getPrescription());
				
			}
			
				if (label.equals("Check status")) {
				System.out.println("service 2 to be invoked ...");

				ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50058).usePlaintext().build();

				//preparing message to send
				DS_CA.HealthMonitoringSensors.VisitorEntryRequest request = DS_CA.HealthMonitoringSensors.VisitorEntryRequest.newBuilder().setTempRange(Double.valueOf(entry2.getText())).build();

				//retreving reply from service
				DS_CA.HealthMonitoringSensors.TempResponse response = blockingStub1.tempScanner(request);
			
				response.getUnknownFields().asMap().get(1);
				reply2.setText(response.getAccess());
			
			}else if (label.equals("Check BMI status")) {
				System.out.println("service 2 A(BMI) to be invoked ...");

			
				
				ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50058).usePlaintext().build();

				//preparing message to send
				DS_CA.HealthMonitoringSensors.PatientBMIRequest request = DS_CA.HealthMonitoringSensors.PatientBMIRequest.newBuilder().setHeight(Double.valueOf(entry2A.getText())).setWeight (Double.valueOf(entry2B.getText())).build();

				//retreving reply from service
				DS_CA.HealthMonitoringSensors.BMIResultResponse response = blockingStub1.bmi(request);

				reply2A.setText( String.valueOf( response.getBmiStatus()) );
			
			}
				if
				
				(label.equals("Monitering status")) {
					System.out.println("service 3  to be invoked ...");

				
					ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50057).usePlaintext().build();

					//preparing message to send
					DS_CA.PatientMotionSensors.PatientCabinRequest request = DS_CA.PatientMotionSensors.PatientCabinRequest.newBuilder().setAction(Boolean.valueOf(entry3.getText())).build();

					//retreving reply from service
					DS_CA.PatientMotionSensors.MonitorAlertResponse response = blockingStub2.motionMonit(request);

					reply3.setText( String.valueOf( response.getAlert()) );
				
				}else if
					
					(label.equals("Get your operation schedule")) {
						System.out.println("service 3 A to be invoked ...");

					
						ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50057).usePlaintext().build();

						//preparing message to send
						DS_CA.PatientMotionSensors.DoctorEntryRequest request = DS_CA.PatientMotionSensors.DoctorEntryRequest.newBuilder().setData(entry3A.getText()).build();

						//retreving reply from service
						Iterator<ScheduledResponse> response = blockingStub2.operationSchedule(request);

						reply3A.setText(response.getBooking());
					
					}
						
			}

			
		
}//class
	
