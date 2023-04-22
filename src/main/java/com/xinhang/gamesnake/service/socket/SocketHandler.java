package com.xinhang.gamesnake.service.socket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.GlobalEventExecutor;

public class SocketHandler extends ChannelInboundHandlerAdapter {
    private static final ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
//        byte[] data = (byte[]) msg;
//        System.out.println("收到消息：" + new String(data));

            TextWebSocketFrame data = (TextWebSocketFrame)msg;
            System.out.println("收到消息：" + data.text());

            for (Channel client : clients){
                System.out.println("channel_id:" + ctx.channel().id());

                if (ctx.channel().isActive()){
                    client.writeAndFlush(new TextWebSocketFrame(data.text()));
                }
            }
        } finally {
            ctx.flush();
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception{
        System.out.println("新的客户端链接：" + ctx.toString());
        clients.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception{
        System.out.println("移除客户端链接：" + ctx.toString());
//        clients.remove(ctx.channel());
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("into exceptionCaught:" + cause.getMessage());
        cause.printStackTrace();
        ctx.close();
    }
}
