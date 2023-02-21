// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Package.proto

package com.jwjjgs.robotcenter.pojo.protoFile;

public final class Package {
  private Package() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ConnectSucOrBuilder extends
      // @@protoc_insertion_point(interface_extends:ConnectSuc)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional int32 ok = 1;</code>
     */
    int getOk();
  }
  /**
   * Protobuf type {@code ConnectSuc}
   */
  public  static final class ConnectSuc extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:ConnectSuc)
      ConnectSucOrBuilder {
    // Use ConnectSuc.newBuilder() to construct.
    private ConnectSuc(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ConnectSuc() {
      ok_ = 0;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private ConnectSuc(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              ok_ = input.readInt32();
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
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Package.internal_static_ConnectSuc_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Package.internal_static_ConnectSuc_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ConnectSuc.class, Builder.class);
    }

    public static final int OK_FIELD_NUMBER = 1;
    private int ok_;
    /**
     * <code>optional int32 ok = 1;</code>
     */
    public int getOk() {
      return ok_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (ok_ != 0) {
        output.writeInt32(1, ok_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (ok_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, ok_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof ConnectSuc)) {
        return super.equals(obj);
      }
      ConnectSuc other = (ConnectSuc) obj;

      boolean result = true;
      result = result && (getOk()
          == other.getOk());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + OK_FIELD_NUMBER;
      hash = (53 * hash) + getOk();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static ConnectSuc parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ConnectSuc parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ConnectSuc parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ConnectSuc parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ConnectSuc parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ConnectSuc parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static ConnectSuc parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static ConnectSuc parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static ConnectSuc parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ConnectSuc parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(ConnectSuc prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code ConnectSuc}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:ConnectSuc)
        ConnectSucOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Package.internal_static_ConnectSuc_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Package.internal_static_ConnectSuc_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                ConnectSuc.class, Builder.class);
      }

      // Construct using com.jwjjgs.robotcenter.pojo.protoFile.Package.ConnectSuc.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        ok_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Package.internal_static_ConnectSuc_descriptor;
      }

      public ConnectSuc getDefaultInstanceForType() {
        return ConnectSuc.getDefaultInstance();
      }

      public ConnectSuc build() {
        ConnectSuc result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public ConnectSuc buildPartial() {
        ConnectSuc result = new ConnectSuc(this);
        result.ok_ = ok_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof ConnectSuc) {
          return mergeFrom((ConnectSuc)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(ConnectSuc other) {
        if (other == ConnectSuc.getDefaultInstance()) return this;
        if (other.getOk() != 0) {
          setOk(other.getOk());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        ConnectSuc parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (ConnectSuc) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int ok_ ;
      /**
       * <code>optional int32 ok = 1;</code>
       */
      public int getOk() {
        return ok_;
      }
      /**
       * <code>optional int32 ok = 1;</code>
       */
      public Builder setOk(int value) {
        
        ok_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 ok = 1;</code>
       */
      public Builder clearOk() {
        
        ok_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:ConnectSuc)
    }

    // @@protoc_insertion_point(class_scope:ConnectSuc)
    private static final ConnectSuc DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new ConnectSuc();
    }

    public static ConnectSuc getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ConnectSuc>
        PARSER = new com.google.protobuf.AbstractParser<ConnectSuc>() {
      public ConnectSuc parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new ConnectSuc(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ConnectSuc> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<ConnectSuc> getParserForType() {
      return PARSER;
    }

    public ConnectSuc getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface RequestOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Request)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     *proto name
     * </pre>
     *
     * <code>optional string proto_name = 1;</code>
     */
    String getProtoName();
    /**
     * <pre>
     *proto name
     * </pre>
     *
     * <code>optional string proto_name = 1;</code>
     */
    com.google.protobuf.ByteString
        getProtoNameBytes();

    /**
     * <pre>
     *content
     * </pre>
     *
     * <code>optional bytes content = 2;</code>
     */
    com.google.protobuf.ByteString getContent();
  }
  /**
   * Protobuf type {@code Request}
   */
  public  static final class Request extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Request)
      RequestOrBuilder {
    // Use Request.newBuilder() to construct.
    private Request(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Request() {
      protoName_ = "";
      content_ = com.google.protobuf.ByteString.EMPTY;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Request(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              String s = input.readStringRequireUtf8();

              protoName_ = s;
              break;
            }
            case 18: {

              content_ = input.readBytes();
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
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Package.internal_static_Request_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Package.internal_static_Request_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Request.class, Builder.class);
    }

    public static final int PROTO_NAME_FIELD_NUMBER = 1;
    private volatile Object protoName_;
    /**
     * <pre>
     *proto name
     * </pre>
     *
     * <code>optional string proto_name = 1;</code>
     */
    public String getProtoName() {
      Object ref = protoName_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        protoName_ = s;
        return s;
      }
    }
    /**
     * <pre>
     *proto name
     * </pre>
     *
     * <code>optional string proto_name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getProtoNameBytes() {
      Object ref = protoName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        protoName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CONTENT_FIELD_NUMBER = 2;
    private com.google.protobuf.ByteString content_;
    /**
     * <pre>
     *content
     * </pre>
     *
     * <code>optional bytes content = 2;</code>
     */
    public com.google.protobuf.ByteString getContent() {
      return content_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getProtoNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, protoName_);
      }
      if (!content_.isEmpty()) {
        output.writeBytes(2, content_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getProtoNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, protoName_);
      }
      if (!content_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, content_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Request)) {
        return super.equals(obj);
      }
      Request other = (Request) obj;

      boolean result = true;
      result = result && getProtoName()
          .equals(other.getProtoName());
      result = result && getContent()
          .equals(other.getContent());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + PROTO_NAME_FIELD_NUMBER;
      hash = (53 * hash) + getProtoName().hashCode();
      hash = (37 * hash) + CONTENT_FIELD_NUMBER;
      hash = (53 * hash) + getContent().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Request parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Request parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Request parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Request parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Request parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Request parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Request parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Request parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Request parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Request parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Request prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Request}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Request)
        RequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Package.internal_static_Request_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Package.internal_static_Request_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Request.class, Builder.class);
      }

      // Construct using com.jwjjgs.robotcenter.pojo.protoFile.Package.Request.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        protoName_ = "";

        content_ = com.google.protobuf.ByteString.EMPTY;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Package.internal_static_Request_descriptor;
      }

      public Request getDefaultInstanceForType() {
        return Request.getDefaultInstance();
      }

      public Request build() {
        Request result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Request buildPartial() {
        Request result = new Request(this);
        result.protoName_ = protoName_;
        result.content_ = content_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Request) {
          return mergeFrom((Request)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Request other) {
        if (other == Request.getDefaultInstance()) return this;
        if (!other.getProtoName().isEmpty()) {
          protoName_ = other.protoName_;
          onChanged();
        }
        if (other.getContent() != com.google.protobuf.ByteString.EMPTY) {
          setContent(other.getContent());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Request parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Request) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private Object protoName_ = "";
      /**
       * <pre>
       *proto name
       * </pre>
       *
       * <code>optional string proto_name = 1;</code>
       */
      public String getProtoName() {
        Object ref = protoName_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          protoName_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <pre>
       *proto name
       * </pre>
       *
       * <code>optional string proto_name = 1;</code>
       */
      public com.google.protobuf.ByteString
          getProtoNameBytes() {
        Object ref = protoName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          protoName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       *proto name
       * </pre>
       *
       * <code>optional string proto_name = 1;</code>
       */
      public Builder setProtoName(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        protoName_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *proto name
       * </pre>
       *
       * <code>optional string proto_name = 1;</code>
       */
      public Builder clearProtoName() {
        
        protoName_ = getDefaultInstance().getProtoName();
        onChanged();
        return this;
      }
      /**
       * <pre>
       *proto name
       * </pre>
       *
       * <code>optional string proto_name = 1;</code>
       */
      public Builder setProtoNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        protoName_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString content_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <pre>
       *content
       * </pre>
       *
       * <code>optional bytes content = 2;</code>
       */
      public com.google.protobuf.ByteString getContent() {
        return content_;
      }
      /**
       * <pre>
       *content
       * </pre>
       *
       * <code>optional bytes content = 2;</code>
       */
      public Builder setContent(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        content_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *content
       * </pre>
       *
       * <code>optional bytes content = 2;</code>
       */
      public Builder clearContent() {
        
        content_ = getDefaultInstance().getContent();
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:Request)
    }

    // @@protoc_insertion_point(class_scope:Request)
    private static final Request DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Request();
    }

    public static Request getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Request>
        PARSER = new com.google.protobuf.AbstractParser<Request>() {
      public Request parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Request(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Request> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<Request> getParserForType() {
      return PARSER;
    }

    public Request getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ConnectSuc_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ConnectSuc_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Request_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Request_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\rPackage.proto\"\030\n\nConnectSuc\022\n\n\002ok\030\001 \001(" +
      "\005\".\n\007Request\022\022\n\nproto_name\030\001 \001(\t\022\017\n\007cont" +
      "ent\030\002 \001(\014B0\n%com.jwjjgs.robotcenter.pojo" +
      ".protoFileB\007Packageb\006proto3"
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
    internal_static_ConnectSuc_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ConnectSuc_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ConnectSuc_descriptor,
        new String[] { "Ok", });
    internal_static_Request_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Request_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Request_descriptor,
        new String[] { "ProtoName", "Content", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
