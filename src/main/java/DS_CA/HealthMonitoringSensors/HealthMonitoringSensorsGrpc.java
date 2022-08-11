package DS_CA.HealthMonitoringSensors;

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
    comments = "Source: HealthMonitoringSensors.proto")
public final class HealthMonitoringSensorsGrpc {

  private HealthMonitoringSensorsGrpc() {}

  public static final String SERVICE_NAME = "service3.HealthMonitoringSensors";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<DS_CA.HealthMonitoringSensors.VisitorEntryRequest,
      DS_CA.HealthMonitoringSensors.TempResponse> getTempScannerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "tempScanner",
      requestType = DS_CA.HealthMonitoringSensors.VisitorEntryRequest.class,
      responseType = DS_CA.HealthMonitoringSensors.TempResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<DS_CA.HealthMonitoringSensors.VisitorEntryRequest,
      DS_CA.HealthMonitoringSensors.TempResponse> getTempScannerMethod() {
    io.grpc.MethodDescriptor<DS_CA.HealthMonitoringSensors.VisitorEntryRequest, DS_CA.HealthMonitoringSensors.TempResponse> getTempScannerMethod;
    if ((getTempScannerMethod = HealthMonitoringSensorsGrpc.getTempScannerMethod) == null) {
      synchronized (HealthMonitoringSensorsGrpc.class) {
        if ((getTempScannerMethod = HealthMonitoringSensorsGrpc.getTempScannerMethod) == null) {
          HealthMonitoringSensorsGrpc.getTempScannerMethod = getTempScannerMethod = 
              io.grpc.MethodDescriptor.<DS_CA.HealthMonitoringSensors.VisitorEntryRequest, DS_CA.HealthMonitoringSensors.TempResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service3.HealthMonitoringSensors", "tempScanner"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DS_CA.HealthMonitoringSensors.VisitorEntryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DS_CA.HealthMonitoringSensors.TempResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HealthMonitoringSensorsMethodDescriptorSupplier("tempScanner"))
                  .build();
          }
        }
     }
     return getTempScannerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<DS_CA.HealthMonitoringSensors.PatientBMIRequest,
      DS_CA.HealthMonitoringSensors.BMIResultResponse> getBMIMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BMI",
      requestType = DS_CA.HealthMonitoringSensors.PatientBMIRequest.class,
      responseType = DS_CA.HealthMonitoringSensors.BMIResultResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<DS_CA.HealthMonitoringSensors.PatientBMIRequest,
      DS_CA.HealthMonitoringSensors.BMIResultResponse> getBMIMethod() {
    io.grpc.MethodDescriptor<DS_CA.HealthMonitoringSensors.PatientBMIRequest, DS_CA.HealthMonitoringSensors.BMIResultResponse> getBMIMethod;
    if ((getBMIMethod = HealthMonitoringSensorsGrpc.getBMIMethod) == null) {
      synchronized (HealthMonitoringSensorsGrpc.class) {
        if ((getBMIMethod = HealthMonitoringSensorsGrpc.getBMIMethod) == null) {
          HealthMonitoringSensorsGrpc.getBMIMethod = getBMIMethod = 
              io.grpc.MethodDescriptor.<DS_CA.HealthMonitoringSensors.PatientBMIRequest, DS_CA.HealthMonitoringSensors.BMIResultResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service3.HealthMonitoringSensors", "BMI"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DS_CA.HealthMonitoringSensors.PatientBMIRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DS_CA.HealthMonitoringSensors.BMIResultResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HealthMonitoringSensorsMethodDescriptorSupplier("BMI"))
                  .build();
          }
        }
     }
     return getBMIMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HealthMonitoringSensorsStub newStub(io.grpc.Channel channel) {
    return new HealthMonitoringSensorsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HealthMonitoringSensorsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HealthMonitoringSensorsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HealthMonitoringSensorsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HealthMonitoringSensorsFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class HealthMonitoringSensorsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * rpc method for client streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<DS_CA.HealthMonitoringSensors.VisitorEntryRequest> tempScanner(
        io.grpc.stub.StreamObserver<DS_CA.HealthMonitoringSensors.TempResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getTempScannerMethod(), responseObserver);
    }

    /**
     * <pre>
     * rpc method for bidirectional streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<DS_CA.HealthMonitoringSensors.PatientBMIRequest> bMI(
        io.grpc.stub.StreamObserver<DS_CA.HealthMonitoringSensors.BMIResultResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBMIMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTempScannerMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                DS_CA.HealthMonitoringSensors.VisitorEntryRequest,
                DS_CA.HealthMonitoringSensors.TempResponse>(
                  this, METHODID_TEMP_SCANNER)))
          .addMethod(
            getBMIMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                DS_CA.HealthMonitoringSensors.PatientBMIRequest,
                DS_CA.HealthMonitoringSensors.BMIResultResponse>(
                  this, METHODID_BMI)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class HealthMonitoringSensorsStub extends io.grpc.stub.AbstractStub<HealthMonitoringSensorsStub> {
    private HealthMonitoringSensorsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HealthMonitoringSensorsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthMonitoringSensorsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HealthMonitoringSensorsStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for client streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<DS_CA.HealthMonitoringSensors.VisitorEntryRequest> tempScanner(
        io.grpc.stub.StreamObserver<DS_CA.HealthMonitoringSensors.TempResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getTempScannerMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * rpc method for bidirectional streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<DS_CA.HealthMonitoringSensors.PatientBMIRequest> bMI(
        io.grpc.stub.StreamObserver<DS_CA.HealthMonitoringSensors.BMIResultResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getBMIMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class HealthMonitoringSensorsBlockingStub extends io.grpc.stub.AbstractStub<HealthMonitoringSensorsBlockingStub> {
    private HealthMonitoringSensorsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HealthMonitoringSensorsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthMonitoringSensorsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HealthMonitoringSensorsBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class HealthMonitoringSensorsFutureStub extends io.grpc.stub.AbstractStub<HealthMonitoringSensorsFutureStub> {
    private HealthMonitoringSensorsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HealthMonitoringSensorsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthMonitoringSensorsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HealthMonitoringSensorsFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_TEMP_SCANNER = 0;
  private static final int METHODID_BMI = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HealthMonitoringSensorsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HealthMonitoringSensorsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TEMP_SCANNER:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.tempScanner(
              (io.grpc.stub.StreamObserver<DS_CA.HealthMonitoringSensors.TempResponse>) responseObserver);
        case METHODID_BMI:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bMI(
              (io.grpc.stub.StreamObserver<DS_CA.HealthMonitoringSensors.BMIResultResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HealthMonitoringSensorsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HealthMonitoringSensorsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return DS_CA.HealthMonitoringSensors.HealthMonitoringSensorsImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HealthMonitoringSensors");
    }
  }

  private static final class HealthMonitoringSensorsFileDescriptorSupplier
      extends HealthMonitoringSensorsBaseDescriptorSupplier {
    HealthMonitoringSensorsFileDescriptorSupplier() {}
  }

  private static final class HealthMonitoringSensorsMethodDescriptorSupplier
      extends HealthMonitoringSensorsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HealthMonitoringSensorsMethodDescriptorSupplier(String methodName) {
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
      synchronized (HealthMonitoringSensorsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HealthMonitoringSensorsFileDescriptorSupplier())
              .addMethod(getTempScannerMethod())
              .addMethod(getBMIMethod())
              .build();
        }
      }
    }
    return result;
  }
}
