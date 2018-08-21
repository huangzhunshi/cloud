package com.zuul.bootc.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class EchoServer {

    public static void main(String[] args) throws InterruptedException {


        NioEventLoopGroup boss=new NioEventLoopGroup(1);
        NioEventLoopGroup works = new NioEventLoopGroup(6);
        ServerBootstrap b = new ServerBootstrap();
      //  b.group(group,group);
b.group(boss,works).channel(NioServerSocketChannel.class).localAddress(new InetSocketAddress(9001)).
        childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(
                        new EchoServerHandler());
            }
        });

        ChannelFuture f = b.bind().sync();            //8
        System.out.println(EchoServer.class.getName() + " started and listen on " + f.channel().localAddress());
        f.channel().closeFuture().sync();



    }
}
