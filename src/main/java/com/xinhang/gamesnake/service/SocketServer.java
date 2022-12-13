package com.xinhang.gamesnake.service;

import com.xinhang.gamesnake.service.socket.SocketInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SocketServer {
    @Resource
    private SocketInitializer socketInitializer;

    @Value("${netty.port:9999}")
    private int port;

    @Value("${netty.bossThread:1}")
    private int bossThread;

    public void start(){
        System.out.println("SocketServer start");

        NioEventLoopGroup bossGroup = new NioEventLoopGroup(this.bossThread);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(this.socketInitializer);

        serverBootstrap.bind(this.port);
        System.out.println("Netty started on port: " + this.port + " (TCP) with boss thread " + this.bossThread);
    }
}
