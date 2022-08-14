// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SmartMedicalRecords.proto

package DS_CA.SmartMedicalRecords;

/**
 * <pre>
 *message for recordaccess
 * </pre>
 *
 * Protobuf type {@code service1.PatientIDRequest}
 */
public  final class PatientIDRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:service1.PatientIDRequest)
    PatientIDRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PatientIDRequest.newBuilder() to construct.
  private PatientIDRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PatientIDRequest() {
    pID_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PatientIDRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            pID_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return DS_CA.SmartMedicalRecords.SmartMedicalRecordsImpl.internal_static_service1_PatientIDRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return DS_CA.SmartMedicalRecords.SmartMedicalRecordsImpl.internal_static_service1_PatientIDRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            DS_CA.SmartMedicalRecords.PatientIDRequest.class, DS_CA.SmartMedicalRecords.PatientIDRequest.Builder.class);
  }

  public static final int PID_FIELD_NUMBER = 1;
  private volatile java.lang.Object pID_;
  /**
   * <code>string pID = 1;</code>
   */
  public java.lang.String getPID() {
    java.lang.Object ref = pID_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      pID_ = s;
      return s;
    }
  }
  /**
   * <code>string pID = 1;</code>
   */
  public com.google.protobuf.ByteString
      getPIDBytes() {
    java.lang.Object ref = pID_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      pID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getPIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, pID_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getPIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, pID_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof DS_CA.SmartMedicalRecords.PatientIDRequest)) {
      return super.equals(obj);
    }
    DS_CA.SmartMedicalRecords.PatientIDRequest other = (DS_CA.SmartMedicalRecords.PatientIDRequest) obj;

    boolean result = true;
    result = result && getPID()
        .equals(other.getPID());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PID_FIELD_NUMBER;
    hash = (53 * hash) + getPID().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static DS_CA.SmartMedicalRecords.PatientIDRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static DS_CA.SmartMedicalRecords.PatientIDRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static DS_CA.SmartMedicalRecords.PatientIDRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static DS_CA.SmartMedicalRecords.PatientIDRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static DS_CA.SmartMedicalRecords.PatientIDRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static DS_CA.SmartMedicalRecords.PatientIDRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static DS_CA.SmartMedicalRecords.PatientIDRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static DS_CA.SmartMedicalRecords.PatientIDRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static DS_CA.SmartMedicalRecords.PatientIDRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static DS_CA.SmartMedicalRecords.PatientIDRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static DS_CA.SmartMedicalRecords.PatientIDRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static DS_CA.SmartMedicalRecords.PatientIDRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(DS_CA.SmartMedicalRecords.PatientIDRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   *message for recordaccess
   * </pre>
   *
   * Protobuf type {@code service1.PatientIDRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:service1.PatientIDRequest)
      DS_CA.SmartMedicalRecords.PatientIDRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return DS_CA.SmartMedicalRecords.SmartMedicalRecordsImpl.internal_static_service1_PatientIDRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return DS_CA.SmartMedicalRecords.SmartMedicalRecordsImpl.internal_static_service1_PatientIDRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              DS_CA.SmartMedicalRecords.PatientIDRequest.class, DS_CA.SmartMedicalRecords.PatientIDRequest.Builder.class);
    }

    // Construct using DS_CA.SmartMedicalRecords.PatientIDRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      pID_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return DS_CA.SmartMedicalRecords.SmartMedicalRecordsImpl.internal_static_service1_PatientIDRequest_descriptor;
    }

    @java.lang.Override
    public DS_CA.SmartMedicalRecords.PatientIDRequest getDefaultInstanceForType() {
      return DS_CA.SmartMedicalRecords.PatientIDRequest.getDefaultInstance();
    }

    @java.lang.Override
    public DS_CA.SmartMedicalRecords.PatientIDRequest build() {
      DS_CA.SmartMedicalRecords.PatientIDRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public DS_CA.SmartMedicalRecords.PatientIDRequest buildPartial() {
      DS_CA.SmartMedicalRecords.PatientIDRequest result = new DS_CA.SmartMedicalRecords.PatientIDRequest(this);
      result.pID_ = pID_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof DS_CA.SmartMedicalRecords.PatientIDRequest) {
        return mergeFrom((DS_CA.SmartMedicalRecords.PatientIDRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(DS_CA.SmartMedicalRecords.PatientIDRequest other) {
      if (other == DS_CA.SmartMedicalRecords.PatientIDRequest.getDefaultInstance()) return this;
      if (!other.getPID().isEmpty()) {
        pID_ = other.pID_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      DS_CA.SmartMedicalRecords.PatientIDRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (DS_CA.SmartMedicalRecords.PatientIDRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object pID_ = "";
    /**
     * <code>string pID = 1;</code>
     */
    public java.lang.String getPID() {
      java.lang.Object ref = pID_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        pID_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string pID = 1;</code>
     */
    public com.google.protobuf.ByteString
        getPIDBytes() {
      java.lang.Object ref = pID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        pID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string pID = 1;</code>
     */
    public Builder setPID(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      pID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string pID = 1;</code>
     */
    public Builder clearPID() {
      
      pID_ = getDefaultInstance().getPID();
      onChanged();
      return this;
    }
    /**
     * <code>string pID = 1;</code>
     */
    public Builder setPIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      pID_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:service1.PatientIDRequest)
  }

  // @@protoc_insertion_point(class_scope:service1.PatientIDRequest)
  private static final DS_CA.SmartMedicalRecords.PatientIDRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new DS_CA.SmartMedicalRecords.PatientIDRequest();
  }

  public static DS_CA.SmartMedicalRecords.PatientIDRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PatientIDRequest>
      PARSER = new com.google.protobuf.AbstractParser<PatientIDRequest>() {
    @java.lang.Override
    public PatientIDRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PatientIDRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PatientIDRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PatientIDRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public DS_CA.SmartMedicalRecords.PatientIDRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

