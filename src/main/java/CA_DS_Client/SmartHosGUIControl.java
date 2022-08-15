//GUI package
package CA_DS_Client;

//Imports from lib

	import java.awt.Dimension;
	import java.awt.Insets;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

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
	import io.grpc.ManagedChannel;
	import io.grpc.ManagedChannelBuilder;

	public class SmartHosGUIControl implements ActionListener{
		
		private JTextField entry1, reply1;
		private JTextField entry1A, reply1A;
		private JTextField entry2, reply2;
		private JTextField entry2A,entry2B, reply2A;
		private JTextField entry3, reply3;
		private JTextField entry3A, reply3A;
	
		
		
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

			JLabel label1 = new JLabel("Enter your height in cm:")	;
			panel.add(label1);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));
			entry2A = new JTextField("",10);
			panel.add(entry2A);
			panel.add(Box.createRigidArea(new Dimension(10, 0)));
			JLabel label2 = new JLabel("Enter your weight in kg:")	;
			panel.add(label2);
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
		
		public static void main(String[] args) {

			SmartHosGUIControl smGui = new SmartHosGUIControl();

			smGui.build();
		}
		
		
		private void build() { 

			JFrame frame = new JFrame("Smart Hospital Service System");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Set the panel to add buttons
			JPanel panel = new JPanel();

			// Set the BoxLayout to be X_AXIS: from left to right
			BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

			panel.setLayout(boxlayout);

			// Set border for the panel
			panel.setBorder(new EmptyBorder(new Insets(80, 150, 80, 150)));
		
			panel.add( getService1JPanel() );
			panel.add( getService2JPanel() );
			panel.add( getService3JPanel() );
		
			// Set size for the frame
			frame.setSize(500, 800);

			// Set the window to be visible as the default to be false
			frame.add(panel);
			frame.pack();
			frame.setVisible(true);
		}

		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource();
			String label = button.getActionCommand();  

			if (label.equals("Check patient ID availability")) {
				System.out.println("service 1 to be invoked ...");

			
				ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50055).usePlaintext().build();
				SmartMedicalRecordsGrpc.SmartMedicalRecordsBlockingStub blockingStub = SmartMedicalRecordsGrpc.newBlockingStub(channel);

				//preparing message to send
				DS_CA.SmartMedicalRecords.PatientIDRequest request = DS_CA.SmartMedicalRecords.PatientIDRequest.newBuilder().setPID(entry1.getText()).build();

				//retreving reply from service
				DS_CA.SmartMedicalRecords.PatientRecordResponse response = blockingStub.recordAccess(request);
			
				response.getUnknownFields().asMap().get(1);
				reply1.setText( response.getVal());
			
			}else if (label.equals("Get the prescription")) {
				System.out.println("service 1 A to be invoked ...");

			
			
				ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50055).usePlaintext().build();
				SmartMedicalRecordsGrpc.SmartMedicalRecordsBlockingStub blockingStub = SmartMedicalRecordsGrpc.newBlockingStub(channel);

				//preparing message to send
				DS_CA.SmartMedicalRecords.ConsultIDRequest request = DS_CA.SmartMedicalRecords.ConsultIDRequest.newBuilder().setCoulID(entry1A.getText()).build();

				//retreving reply from service
				DS_CA.SmartMedicalRecords.MedicineListResponse response = blockingStub.accessPharmacy(request);
			
				response.getUnknownFields().asMap().get(1);
				reply1A.setText( response.getPrescription());
				
			}
			
				if (label.equals("Check status")) {
				System.out.println("service 2 to be invoked ...");

				ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50055).usePlaintext().build();
				HealthMonitoringSensorsGrpc.HealthMonitoringSensorsBlockingStub blockingStub = HealthMonitoringSensorsGrpc.newBlockingStub(channel);

				//preparing message to send
				DS_CA.HealthMonitoringSensors.VisitorEntryRequest request = DS_CA.HealthMonitoringSensors.VisitorEntryRequest.newBuilder().setTempRange(entry2.getText()).build();

				//retreving reply from service
				DS_CA.HealthMonitoringSensors.TempResponse response = blockingStub.tempScanner(request);
			
				response.getUnknownFields().asMap().get(1);
				reply2.setText( response.getPrescription());
			
			}else if (label.equals("Check BMI status")) {
				System.out.println("service 2 A(BMI) to be invoked ...");

			
				
				ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50055).usePlaintext().build();
				HealthMonitoringSensorsGrpc.HealthMonitoringSensorsBlockingStub blockingStub = HealthMonitoringSensorsGrpc.newBlockingStub(channel);

				//preparing message to send
				DS_CA.HealthMonitoringSensors.PatientBMIRequest request = DS_CA.HealthMonitoringSensors.PatientBMIRequest.newBuilder().setHeight(entry2A.getText()).setWeight (entry2B.getText()).build();

				//retreving reply from service
				DS_CA.HealthMonitoringSensors.BMIResultResponse response = blockingStub.bmi(request);

				reply2A.setText( String.valueOf( response.getBmiStatus()) );
			
			}else if{
				(label.equals("Monitering status")) {
					System.out.println("service 3  to be invoked ...");

				
					ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50054).usePlaintext().build();
					PatientMotionSensorsGrpc.PatientMotionSensorsBlockingStub blockingStub = PatientMotionSensorsGrpc.newBlockingStub(channel);

					//preparing message to send
					DS_CA.PatientMotionSensors.PatientCabinRequest request = DS_CA.PatientMotionSensors.PatientCabinRequest.newBuilder().setAction(entry3.getText()).build();

					//retreving reply from service
					DS_CA.PatientMotionSensors.MonitorAlertResponse response = blockingStub.motionMonit(request);

					reply3.setText( String.valueOf( response.getAlert()) );
				
				}else{
					(label.equals("Get your operation schedule")) {
						System.out.println("service 3 A to be invoked ...");

					
						ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50054).usePlaintext().build();
						PatientMotionSensorsGrpc.PatientMotionSensorsBlockingStub blockingStub = PatientMotionSensorsGrpc.newBlockingStub(channel);

						//preparing message to send
						DS_CA.PatientMotionSensors.DoctorEntryRequest request = DS_CA.PatientMotionSensors.DoctorEntryRequest.newBuilder().setData(entry3A.getText()).build();

						//retreving reply from service
						DS_CA.PatientMotionSensors.ScheduledResponse response = blockingStub.operationSchedule(request);

						reply3A.setText( String.valueOf( response.getBooking()) );
					
					}
						
			}

		
		
}//class
	
