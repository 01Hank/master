package com.jwjjgs.robotcenter.grpcServer;

import com.jwjjgs.robotcenter.context.CenterContextAware;
import com.jwjjgs.robotcenter.grpcServer.rpcService.LoginServiceGrpc;
import com.jwjjgs.robotcenter.pojo.protoFile.Package;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService(LoginServiceGrpc.class)
public class LoginServiceGrpcImpl extends LoginServiceGrpc.LoginServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(LoginServiceGrpcImpl.class);

    @Override
    public void searchUser(Package.userSearch request, StreamObserver<Package.userReply> responseObserver) {
        log.info("------------接受到rpc请求:{}", request.getUserid());

        Package.userReply.Builder response = Package.userReply.newBuilder();
        response.setUserid(request.getUserid())
                .setUsername("测试");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
