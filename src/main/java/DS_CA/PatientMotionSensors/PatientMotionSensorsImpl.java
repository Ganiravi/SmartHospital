// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PatientMotionSensors.proto

package DS_CA.PatientMotionSensors;

public final class PatientMotionSensorsImpl {
  private PatientMotionSensorsImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service2_PatientCabinRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service2_PatientCabinRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service2_MonitorAlertResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service2_MonitorAlertResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service2_DoctorEntryRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service2_DoctorEntryRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service2_ScheduledResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service2_ScheduledResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\032PatientMotionSensors.proto\022\010service2\"%" +
      "\n\023PatientCabinRequest\022\016\n\006action\030\001 \001(\010\"%\n" +
      "\024MonitorAlertResponse\022\r\n\005alert\030\001 \001(\t\"\"\n\022" +
      "DoctorEntryRequest\022\014\n\004data\030\002 \001(\t\"$\n\021Sche" +
      "duledResponse\022\017\n\007booking\030\002 \001(\t2\272\001\n\024Patie" +
      "ntMotionSensors\022P\n\013motionMonit\022\035.service" +
      "2.PatientCabinRequest\032\036.service2.Monitor" +
      "AlertResponse\"\000(\001\022P\n\021operationSchedule\022\034" +
      ".service2.DoctorEntryRequest\032\033.service2." +
      "ScheduledResponse\"\000B8\n\032DS_CA.PatientMoti" +
      "onSensorsB\030PatientMotionSensorsImplP\001b\006p" +
      "roto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_service2_PatientCabinRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_service2_PatientCabinRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service2_PatientCabinRequest_descriptor,
        new java.lang.String[] { "Action", });
    internal_static_service2_MonitorAlertResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_service2_MonitorAlertResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service2_MonitorAlertResponse_descriptor,
        new java.lang.String[] { "Alert", });
    internal_static_service2_DoctorEntryRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_service2_DoctorEntryRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service2_DoctorEntryRequest_descriptor,
        new java.lang.String[] { "Data", });
    internal_static_service2_ScheduledResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_service2_ScheduledResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service2_ScheduledResponse_descriptor,
        new java.lang.String[] { "Booking", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}