package com.jwjjgs.robotcenter.rpcTest;

import com.jwjjgs.robotcenter.grpcServer.rpcService.LoginServiceGrpc;
import com.jwjjgs.robotcenter.pojo.protoFile.Package;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class LoginGrpcService {
    private final ManagedChannel channel;

    private final LoginServiceGrpc.LoginServiceBlockingStub stub;

    public LoginGrpcService(ManagedChannel channel) {
        this.channel = channel;
        this.stub = LoginServiceGrpc.newBlockingStub(channel);
    }

    public LoginGrpcService(String host, int port){
        this(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build());
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public String search(int userid){
        Package.userSearch.Builder request = Package.userSearch.newBuilder();
        Package.userReply reply = stub.searchUser(request.setUserid(userid).build());
        return  reply.toString();
    }

    public static void main(String[] args) {
        try {
            LoginGrpcService service = new LoginGrpcService("localhost", 8082);
            System.out.println(service.search(1234));
            service.shutdown();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
