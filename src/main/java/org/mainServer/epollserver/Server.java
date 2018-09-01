//package org.mainServer.epollserver;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.buffer.PooledByteBufAllocator;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.epoll.EpollEventLoopGroup;
//import io.netty.channel.epoll.EpollServerSocketChannel;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.handler.codec.http.HttpObjectAggregator;
//import io.netty.handler.codec.http.HttpRequestDecoder;
//import io.netty.handler.codec.http.HttpResponseDecoder;
//import io.netty.handler.stream.ChunkedWriteHandler;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
//
//import java.util.concurrent.Executors;
//
///**
// * @Author: yanshilong
// * @Date: 18-8-10 下午5:12
// * @Version 1.0
// *
// * 今天是18-08-11
// * 吃了boss一顿饭 Flag flag=new Flag;
// *                    flag="九月初上线version-01";`
// *
// */
//public class Server {
//    private int port;
//
//    private static Logger LOGGER=Logger.getLogger(Server.class);
//    public void inboundServer(int port){
//      //  EventLoopGroup bossgroup=new EpollEventLoopGroup(0x1,Executors.newCachedThreadPool());
//
//        EventLoopGroup bossgroup=new EpollEventLoopGroup(0x1,Executors.newCachedThreadPool());
//
//
//        EventLoopGroup workgroup=new EpollEventLoopGroup(Runtime.getRuntime().availableProcessors()*4,Executors.newCachedThreadPool());
//        //返回数为虚拟机的最大可用的处理器数量-1,并创建缓存线程池;
//
//        ServerBootstrap bootstrap=new ServerBootstrap();
//        //ServerBootstrap负责初始化netty服务器，并且开始监听端口的socket请求//
//        bootstrap.group(bossgroup,workgroup).channel(EpollServerSocketChannel.class).
//                childHandler(new ChannelInitializer<SocketChannel>() {
//
//                    public  void initChannel(SocketChannel ch) throws Exception {
//                        ch.pipeline().addLast(new HttpResponseDecoder());
//                        //server发送的是httpResponse,所以用HttpResponseDecoder()进行编码
//                        ch.pipeline().addLast(new HttpRequestDecoder());
//                        //SERVER接受httpreq 用ttpRequestDecoder()进行解码
//                        ch.pipeline().addLast(new HttpObjectAggregator(655500));
//                        ch.pipeline().addLast(new ChunkedWriteHandler());//信息报文返回
//                        ch.pipeline().addLast(new InboundHandler());//如果上两句不写
//                    }
//
//
//
//                }).option(ChannelOption.SO_BACKLOG, 128)
//                .childOption(ChannelOption.SO_KEEPALIVE,true)
//                .childOption(ChannelOption.CONNECT_TIMEOUT_MILLIS,10000)
//                .childOption(ChannelOption.TCP_NODELAY, true)
//                .childOption(ChannelOption.SO_REUSEADDR, true)     //重用地址
//                .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)// heap buf 's better
//                .childOption(ChannelOption.SO_RCVBUF, 1048576)
//                .childOption(ChannelOption.SO_SNDBUF, 1048576);
//
//
//
//        try {
//            ChannelFuture channelFuture=bootstrap.bind(port).sync();
//            System.out.println("服务器启动成功，绑定了 "+port+"端口");
//            channelFuture.channel().closeFuture().sync();
//
//
//        } catch (InterruptedException e) {
//            LOGGER.warn("this is binging----"+e);
//        }finally {
//
//            workgroup.shutdownGracefully();
//            bossgroup.shutdownGracefully();
//        }
//
//
//    }
//
//    public static void main(String[] args) {
//        PropertyConfigurator.configure("/home/syl/Law/src/main/java/org/log4j.properties");
//        Thread inbund=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Server server=new Server();
//                System.out.println("线程已经绑定端口号，server启动中");
//                server.inboundServer(8806);
//                //server.inboundServer(8006);
//
//            }
//        });
//        inbund.start();
//
//
//    }
//}
