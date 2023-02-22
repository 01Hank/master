package com.jwjjgs.robotcenter.grpcServer.rpcService;

import com.jwjjgs.robotcenter.pojo.protoFile.Package;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *-----------------grpc----------------------
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.11.0)",
    comments = "Source: Package.proto")
public final class LoginServiceGrpc {

  private LoginServiceGrpc() {}

  public static final String SERVICE_NAME = "LoginService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @Deprecated // Use {@link #getSearchUserMethod()} instead.
  public static final io.grpc.MethodDescriptor<Package.userSearch,
      Package.userReply> METHOD_SEARCH_USER = getSearchUserMethodHelper();

  private static volatile io.grpc.MethodDescriptor<Package.userSearch,
      Package.userReply> getSearchUserMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<Package.userSearch,
      Package.userReply> getSearchUserMethod() {
    return getSearchUserMethodHelper();
  }

  private static io.grpc.MethodDescriptor<Package.userSearch,
      Package.userReply> getSearchUserMethodHelper() {
    io.grpc.MethodDescriptor<Package.userSearch, Package.userReply> getSearchUserMethod;
    if ((getSearchUserMethod = LoginServiceGrpc.getSearchUserMethod) == null) {
      synchronized (LoginServiceGrpc.class) {
        if ((getSearchUserMethod = LoginServiceGrpc.getSearchUserMethod) == null) {
          LoginServiceGrpc.getSearchUserMethod = getSearchUserMethod = 
              io.grpc.MethodDescriptor.<Package.userSearch, Package.userReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "LoginService", "searchUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Package.userSearch.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Package.userReply.getDefaultInstance()))
                  .setSchemaDescriptor(new LoginServiceMethodDescriptorSupplier("searchUser"))
                  .build();
          }
        }
     }
     return getSearchUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LoginServiceStub newStub(io.grpc.Channel channel) {
    return new LoginServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LoginServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LoginServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LoginServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LoginServiceFutureStub(channel);
  }

  /**
   * <pre>
   *-----------------grpc----------------------
   * </pre>
   */
  public static abstract class LoginServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void searchUser(Package.userSearch request,
                           io.grpc.stub.StreamObserver<Package.userReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchUserMethodHelper(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSearchUserMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                Package.userSearch,
                Package.userReply>(
                  this, METHODID_SEARCH_USER)))
          .build();
    }
  }

  /**
   * <pre>
   *-----------------grpc----------------------
   * </pre>
   */
  public static final class LoginServiceStub extends io.grpc.stub.AbstractStub<LoginServiceStub> {
    private LoginServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected LoginServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginServiceStub(channel, callOptions);
    }

    /**
     */
    public void searchUser(Package.userSearch request,
                           io.grpc.stub.StreamObserver<Package.userReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchUserMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *-----------------grpc----------------------
   * </pre>
   */
  public static final class LoginServiceBlockingStub extends io.grpc.stub.AbstractStub<LoginServiceBlockingStub> {
    private LoginServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected LoginServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Package.userReply searchUser(Package.userSearch request) {
      return blockingUnaryCall(
          getChannel(), getSearchUserMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *-----------------grpc----------------------
   * </pre>
   */
  public static final class LoginServiceFutureStub extends io.grpc.stub.AbstractStub<LoginServiceFutureStub> {
    private LoginServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected LoginServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Package.userReply> searchUser(
        Package.userSearch request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchUserMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH_USER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LoginServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LoginServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEARCH_USER:
          serviceImpl.searchUser((Package.userSearch) request,
              (io.grpc.stub.StreamObserver<Package.userReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LoginServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LoginServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Package.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LoginService");
    }
  }

  private static final class LoginServiceFileDescriptorSupplier
      extends LoginServiceBaseDescriptorSupplier {
    LoginServiceFileDescriptorSupplier() {}
  }

  private static final class LoginServiceMethodDescriptorSupplier
      extends LoginServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LoginServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LoginServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LoginServiceFileDescriptorSupplier())
              .addMethod(getSearchUserMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
