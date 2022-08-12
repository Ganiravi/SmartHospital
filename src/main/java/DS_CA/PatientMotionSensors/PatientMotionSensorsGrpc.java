package DS_CA.PatientMotionSensors;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: PatientMotionSensors.proto")
public final class PatientMotionSensorsGrpc {

  private PatientMotionSensorsGrpc() {}

  public static final String SERVICE_NAME = "service2.PatientMotionSensors";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<DS_CA.PatientMotionSensors.PatientCabinRequest,
      DS_CA.PatientMotionSensors.MonitorAlertResponse> getMotionMonitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "motionMonit",
      requestType = DS_CA.PatientMotionSensors.PatientCabinRequest.class,
      responseType = DS_CA.PatientMotionSensors.MonitorAlertResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<DS_CA.PatientMotionSensors.PatientCabinRequest,
      DS_CA.PatientMotionSensors.MonitorAlertResponse> getMotionMonitMethod() {
    io.grpc.MethodDescriptor<DS_CA.PatientMotionSensors.PatientCabinRequest, DS_CA.PatientMotionSensors.MonitorAlertResponse> getMotionMonitMethod;
    if ((getMotionMonitMethod = PatientMotionSensorsGrpc.getMotionMonitMethod) == null) {
      synchronized (PatientMotionSensorsGrpc.class) {
        if ((getMotionMonitMethod = PatientMotionSensorsGrpc.getMotionMonitMethod) == null) {
          PatientMotionSensorsGrpc.getMotionMonitMethod = getMotionMonitMethod = 
              io.grpc.MethodDescriptor.<DS_CA.PatientMotionSensors.PatientCabinRequest, DS_CA.PatientMotionSensors.MonitorAlertResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service2.PatientMotionSensors", "motionMonit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DS_CA.PatientMotionSensors.PatientCabinRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DS_CA.PatientMotionSensors.MonitorAlertResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PatientMotionSensorsMethodDescriptorSupplier("motionMonit"))
                  .build();
          }
        }
     }
     return getMotionMonitMethod;
  }

  private static volatile io.grpc.MethodDescriptor<DS_CA.PatientMotionSensors.DoctorEntryRequest,
      DS_CA.PatientMotionSensors.ScheduledResponse> getOperationScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "operationSchedule",
      requestType = DS_CA.PatientMotionSensors.DoctorEntryRequest.class,
      responseType = DS_CA.PatientMotionSensors.ScheduledResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<DS_CA.PatientMotionSensors.DoctorEntryRequest,
      DS_CA.PatientMotionSensors.ScheduledResponse> getOperationScheduleMethod() {
    io.grpc.MethodDescriptor<DS_CA.PatientMotionSensors.DoctorEntryRequest, DS_CA.PatientMotionSensors.ScheduledResponse> getOperationScheduleMethod;
    if ((getOperationScheduleMethod = PatientMotionSensorsGrpc.getOperationScheduleMethod) == null) {
      synchronized (PatientMotionSensorsGrpc.class) {
        if ((getOperationScheduleMethod = PatientMotionSensorsGrpc.getOperationScheduleMethod) == null) {
          PatientMotionSensorsGrpc.getOperationScheduleMethod = getOperationScheduleMethod = 
              io.grpc.MethodDescriptor.<DS_CA.PatientMotionSensors.DoctorEntryRequest, DS_CA.PatientMotionSensors.ScheduledResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service2.PatientMotionSensors", "operationSchedule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DS_CA.PatientMotionSensors.DoctorEntryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DS_CA.PatientMotionSensors.ScheduledResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PatientMotionSensorsMethodDescriptorSupplier("operationSchedule"))
                  .build();
          }
        }
     }
     return getOperationScheduleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PatientMotionSensorsStub newStub(io.grpc.Channel channel) {
    return new PatientMotionSensorsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PatientMotionSensorsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PatientMotionSensorsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PatientMotionSensorsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PatientMotionSensorsFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class PatientMotionSensorsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * rpc method for bidirectional streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<DS_CA.PatientMotionSensors.PatientCabinRequest> motionMonit(
        io.grpc.stub.StreamObserver<DS_CA.PatientMotionSensors.MonitorAlertResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getMotionMonitMethod(), responseObserver);
    }

    /**
     * <pre>
     * rpc method for server streaming calls
     * </pre>
     */
    public void operationSchedule(DS_CA.PatientMotionSensors.DoctorEntryRequest request,
        io.grpc.stub.StreamObserver<DS_CA.PatientMotionSensors.ScheduledResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getOperationScheduleMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMotionMonitMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                DS_CA.PatientMotionSensors.PatientCabinRequest,
                DS_CA.PatientMotionSensors.MonitorAlertResponse>(
                  this, METHODID_MOTION_MONIT)))
          .addMethod(
            getOperationScheduleMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                DS_CA.PatientMotionSensors.DoctorEntryRequest,
                DS_CA.PatientMotionSensors.ScheduledResponse>(
                  this, METHODID_OPERATION_SCHEDULE)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class PatientMotionSensorsStub extends io.grpc.stub.AbstractStub<PatientMotionSensorsStub> {
    private PatientMotionSensorsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientMotionSensorsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientMotionSensorsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientMotionSensorsStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for bidirectional streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<DS_CA.PatientMotionSensors.PatientCabinRequest> motionMonit(
        io.grpc.stub.StreamObserver<DS_CA.PatientMotionSensors.MonitorAlertResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getMotionMonitMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * rpc method for server streaming calls
     * </pre>
     */
    public void operationSchedule(DS_CA.PatientMotionSensors.DoctorEntryRequest request,
        io.grpc.stub.StreamObserver<DS_CA.PatientMotionSensors.ScheduledResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getOperationScheduleMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class PatientMotionSensorsBlockingStub extends io.grpc.stub.AbstractStub<PatientMotionSensorsBlockingStub> {
    private PatientMotionSensorsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientMotionSensorsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientMotionSensorsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientMotionSensorsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for server streaming calls
     * </pre>
     */
    public java.util.Iterator<DS_CA.PatientMotionSensors.ScheduledResponse> operationSchedule(
        DS_CA.PatientMotionSensors.DoctorEntryRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getOperationScheduleMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class PatientMotionSensorsFutureStub extends io.grpc.stub.AbstractStub<PatientMotionSensorsFutureStub> {
    private PatientMotionSensorsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientMotionSensorsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientMotionSensorsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientMotionSensorsFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_OPERATION_SCHEDULE = 0;
  private static final int METHODID_MOTION_MONIT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PatientMotionSensorsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PatientMotionSensorsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_OPERATION_SCHEDULE:
          serviceImpl.operationSchedule((DS_CA.PatientMotionSensors.DoctorEntryRequest) request,
              (io.grpc.stub.StreamObserver<DS_CA.PatientMotionSensors.ScheduledResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MOTION_MONIT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.motionMonit(
              (io.grpc.stub.StreamObserver<DS_CA.PatientMotionSensors.MonitorAlertResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PatientMotionSensorsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PatientMotionSensorsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return DS_CA.PatientMotionSensors.PatientMotionSensorsImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PatientMotionSensors");
    }
  }

  private static final class PatientMotionSensorsFileDescriptorSupplier
      extends PatientMotionSensorsBaseDescriptorSupplier {
    PatientMotionSensorsFileDescriptorSupplier() {}
  }

  private static final class PatientMotionSensorsMethodDescriptorSupplier
      extends PatientMotionSensorsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PatientMotionSensorsMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PatientMotionSensorsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PatientMotionSensorsFileDescriptorSupplier())
              .addMethod(getMotionMonitMethod())
              .addMethod(getOperationScheduleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
