package DS_CA.SmartMedicalRecords;

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
    comments = "Source: SmartMedicalRecords.proto")
public final class SmartMedicalRecordsGrpc {

  private SmartMedicalRecordsGrpc() {}

  public static final String SERVICE_NAME = "service1.SmartMedicalRecords";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<DS_CA.SmartMedicalRecords.PatientIDRequest,
      DS_CA.SmartMedicalRecords.PatientRecordResponse> getRecordAccessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "recordAccess",
      requestType = DS_CA.SmartMedicalRecords.PatientIDRequest.class,
      responseType = DS_CA.SmartMedicalRecords.PatientRecordResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<DS_CA.SmartMedicalRecords.PatientIDRequest,
      DS_CA.SmartMedicalRecords.PatientRecordResponse> getRecordAccessMethod() {
    io.grpc.MethodDescriptor<DS_CA.SmartMedicalRecords.PatientIDRequest, DS_CA.SmartMedicalRecords.PatientRecordResponse> getRecordAccessMethod;
    if ((getRecordAccessMethod = SmartMedicalRecordsGrpc.getRecordAccessMethod) == null) {
      synchronized (SmartMedicalRecordsGrpc.class) {
        if ((getRecordAccessMethod = SmartMedicalRecordsGrpc.getRecordAccessMethod) == null) {
          SmartMedicalRecordsGrpc.getRecordAccessMethod = getRecordAccessMethod = 
              io.grpc.MethodDescriptor.<DS_CA.SmartMedicalRecords.PatientIDRequest, DS_CA.SmartMedicalRecords.PatientRecordResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service1.SmartMedicalRecords", "recordAccess"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DS_CA.SmartMedicalRecords.PatientIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DS_CA.SmartMedicalRecords.PatientRecordResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartMedicalRecordsMethodDescriptorSupplier("recordAccess"))
                  .build();
          }
        }
     }
     return getRecordAccessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<DS_CA.SmartMedicalRecords.Message,
      DS_CA.SmartMedicalRecords.Empty> getEmptyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "empty",
      requestType = DS_CA.SmartMedicalRecords.Message.class,
      responseType = DS_CA.SmartMedicalRecords.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<DS_CA.SmartMedicalRecords.Message,
      DS_CA.SmartMedicalRecords.Empty> getEmptyMethod() {
    io.grpc.MethodDescriptor<DS_CA.SmartMedicalRecords.Message, DS_CA.SmartMedicalRecords.Empty> getEmptyMethod;
    if ((getEmptyMethod = SmartMedicalRecordsGrpc.getEmptyMethod) == null) {
      synchronized (SmartMedicalRecordsGrpc.class) {
        if ((getEmptyMethod = SmartMedicalRecordsGrpc.getEmptyMethod) == null) {
          SmartMedicalRecordsGrpc.getEmptyMethod = getEmptyMethod = 
              io.grpc.MethodDescriptor.<DS_CA.SmartMedicalRecords.Message, DS_CA.SmartMedicalRecords.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service1.SmartMedicalRecords", "empty"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DS_CA.SmartMedicalRecords.Message.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DS_CA.SmartMedicalRecords.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartMedicalRecordsMethodDescriptorSupplier("empty"))
                  .build();
          }
        }
     }
     return getEmptyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<DS_CA.SmartMedicalRecords.ConsultIDRequest,
      DS_CA.SmartMedicalRecords.MedicineListResponse> getAccessPharmacyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "accessPharmacy",
      requestType = DS_CA.SmartMedicalRecords.ConsultIDRequest.class,
      responseType = DS_CA.SmartMedicalRecords.MedicineListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<DS_CA.SmartMedicalRecords.ConsultIDRequest,
      DS_CA.SmartMedicalRecords.MedicineListResponse> getAccessPharmacyMethod() {
    io.grpc.MethodDescriptor<DS_CA.SmartMedicalRecords.ConsultIDRequest, DS_CA.SmartMedicalRecords.MedicineListResponse> getAccessPharmacyMethod;
    if ((getAccessPharmacyMethod = SmartMedicalRecordsGrpc.getAccessPharmacyMethod) == null) {
      synchronized (SmartMedicalRecordsGrpc.class) {
        if ((getAccessPharmacyMethod = SmartMedicalRecordsGrpc.getAccessPharmacyMethod) == null) {
          SmartMedicalRecordsGrpc.getAccessPharmacyMethod = getAccessPharmacyMethod = 
              io.grpc.MethodDescriptor.<DS_CA.SmartMedicalRecords.ConsultIDRequest, DS_CA.SmartMedicalRecords.MedicineListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service1.SmartMedicalRecords", "accessPharmacy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DS_CA.SmartMedicalRecords.ConsultIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DS_CA.SmartMedicalRecords.MedicineListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartMedicalRecordsMethodDescriptorSupplier("accessPharmacy"))
                  .build();
          }
        }
     }
     return getAccessPharmacyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmartMedicalRecordsStub newStub(io.grpc.Channel channel) {
    return new SmartMedicalRecordsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmartMedicalRecordsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SmartMedicalRecordsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmartMedicalRecordsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SmartMedicalRecordsFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class SmartMedicalRecordsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * rpc method for unary calls
     * </pre>
     */
    public void recordAccess(DS_CA.SmartMedicalRecords.PatientIDRequest request,
        io.grpc.stub.StreamObserver<DS_CA.SmartMedicalRecords.PatientRecordResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRecordAccessMethod(), responseObserver);
    }

    /**
     * <pre>
     * rpc method that does not return any response
     * </pre>
     */
    public void empty(DS_CA.SmartMedicalRecords.Message request,
        io.grpc.stub.StreamObserver<DS_CA.SmartMedicalRecords.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getEmptyMethod(), responseObserver);
    }

    /**
     * <pre>
     * rpc method for client streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<DS_CA.SmartMedicalRecords.ConsultIDRequest> accessPharmacy(
        io.grpc.stub.StreamObserver<DS_CA.SmartMedicalRecords.MedicineListResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAccessPharmacyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRecordAccessMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                DS_CA.SmartMedicalRecords.PatientIDRequest,
                DS_CA.SmartMedicalRecords.PatientRecordResponse>(
                  this, METHODID_RECORD_ACCESS)))
          .addMethod(
            getEmptyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                DS_CA.SmartMedicalRecords.Message,
                DS_CA.SmartMedicalRecords.Empty>(
                  this, METHODID_EMPTY)))
          .addMethod(
            getAccessPharmacyMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                DS_CA.SmartMedicalRecords.ConsultIDRequest,
                DS_CA.SmartMedicalRecords.MedicineListResponse>(
                  this, METHODID_ACCESS_PHARMACY)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SmartMedicalRecordsStub extends io.grpc.stub.AbstractStub<SmartMedicalRecordsStub> {
    private SmartMedicalRecordsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartMedicalRecordsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartMedicalRecordsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartMedicalRecordsStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for unary calls
     * </pre>
     */
    public void recordAccess(DS_CA.SmartMedicalRecords.PatientIDRequest request,
        io.grpc.stub.StreamObserver<DS_CA.SmartMedicalRecords.PatientRecordResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRecordAccessMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * rpc method that does not return any response
     * </pre>
     */
    public void empty(DS_CA.SmartMedicalRecords.Message request,
        io.grpc.stub.StreamObserver<DS_CA.SmartMedicalRecords.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEmptyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * rpc method for client streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<DS_CA.SmartMedicalRecords.ConsultIDRequest> accessPharmacy(
        io.grpc.stub.StreamObserver<DS_CA.SmartMedicalRecords.MedicineListResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getAccessPharmacyMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SmartMedicalRecordsBlockingStub extends io.grpc.stub.AbstractStub<SmartMedicalRecordsBlockingStub> {
    private SmartMedicalRecordsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartMedicalRecordsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartMedicalRecordsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartMedicalRecordsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for unary calls
     * </pre>
     */
    public DS_CA.SmartMedicalRecords.PatientRecordResponse recordAccess(DS_CA.SmartMedicalRecords.PatientIDRequest request) {
      return blockingUnaryCall(
          getChannel(), getRecordAccessMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * rpc method that does not return any response
     * </pre>
     */
    public DS_CA.SmartMedicalRecords.Empty empty(DS_CA.SmartMedicalRecords.Message request) {
      return blockingUnaryCall(
          getChannel(), getEmptyMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SmartMedicalRecordsFutureStub extends io.grpc.stub.AbstractStub<SmartMedicalRecordsFutureStub> {
    private SmartMedicalRecordsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartMedicalRecordsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartMedicalRecordsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartMedicalRecordsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for unary calls
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<DS_CA.SmartMedicalRecords.PatientRecordResponse> recordAccess(
        DS_CA.SmartMedicalRecords.PatientIDRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRecordAccessMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * rpc method that does not return any response
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<DS_CA.SmartMedicalRecords.Empty> empty(
        DS_CA.SmartMedicalRecords.Message request) {
      return futureUnaryCall(
          getChannel().newCall(getEmptyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RECORD_ACCESS = 0;
  private static final int METHODID_EMPTY = 1;
  private static final int METHODID_ACCESS_PHARMACY = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SmartMedicalRecordsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SmartMedicalRecordsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RECORD_ACCESS:
          serviceImpl.recordAccess((DS_CA.SmartMedicalRecords.PatientIDRequest) request,
              (io.grpc.stub.StreamObserver<DS_CA.SmartMedicalRecords.PatientRecordResponse>) responseObserver);
          break;
        case METHODID_EMPTY:
          serviceImpl.empty((DS_CA.SmartMedicalRecords.Message) request,
              (io.grpc.stub.StreamObserver<DS_CA.SmartMedicalRecords.Empty>) responseObserver);
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
        case METHODID_ACCESS_PHARMACY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.accessPharmacy(
              (io.grpc.stub.StreamObserver<DS_CA.SmartMedicalRecords.MedicineListResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SmartMedicalRecordsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmartMedicalRecordsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return DS_CA.SmartMedicalRecords.SmartMedicalRecordsImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmartMedicalRecords");
    }
  }

  private static final class SmartMedicalRecordsFileDescriptorSupplier
      extends SmartMedicalRecordsBaseDescriptorSupplier {
    SmartMedicalRecordsFileDescriptorSupplier() {}
  }

  private static final class SmartMedicalRecordsMethodDescriptorSupplier
      extends SmartMedicalRecordsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SmartMedicalRecordsMethodDescriptorSupplier(String methodName) {
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
      synchronized (SmartMedicalRecordsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmartMedicalRecordsFileDescriptorSupplier())
              .addMethod(getRecordAccessMethod())
              .addMethod(getEmptyMethod())
              .addMethod(getAccessPharmacyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
