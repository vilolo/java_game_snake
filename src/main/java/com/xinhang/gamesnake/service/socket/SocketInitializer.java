package com.xinhang.gamesnake.service.socket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import org.springframework.stereotype.Component;

@Component
public class SocketInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
//        pipeline.addLast(new ByteArrayDecoder());
//        pipeline.addLast(new ByteArrayEncoder());
//        pipeline.addLast(new SocketHandler());
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(64*1024));
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws", "WebSocket", true, 65536 * 10));
        pipeline.addLast(new SocketHandler());
    }
}
