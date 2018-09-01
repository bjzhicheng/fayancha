//package org.mainServer.epollserver;
//
//
//
//import io.netty.buffer.ByteBuf;
//import io.netty.buffer.Unpooled;
//import io.netty.channel.Channel;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.ChannelInboundHandlerAdapter;
//import io.netty.channel.SimpleChannelInboundHandler;
//
//
//import io.netty.handler.codec.http.*;
//import org.mysevlete.Servlet.MainServlet;
//import org.apache.log4j.Logger;
//
//import static io.netty.handler.codec.http.HttpHeaderNames.*;
//import static io.netty.handler.codec.http.HttpResponseStatus.OK;
//import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
//
///**
// * @Author: yanshilong
// * @Date: 18-8-10 下午6:46
// * @Version 1.0
// */
//public class InboundHandler  extends ChannelInboundHandlerAdapter {
//    private static Logger LOGGER=Logger.getLogger(InboundHandler.class);
//  //  @Override
////    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
////        System.out.println("inboundhandler is recive "+msg);
////        FullHttpRequest ful=(FullHttpRequest) msg;
////        String url=ful.uri();
////        System.out.println("请求我的URL是： "+ful);
////
////
////        ByteBuf bu=ful.content();//传入的体
////        HttpHeaders head=ful.headers();//传入的头
////        byte [] result=new byte[bu.readableBytes()];
////        bu.readBytes(result);
////        String data=new String(result,"utf8");
////        System.out.println("接受到体数据 ： "+data);
////        //===========================================这里调用cli 返回数据renpose
////      //  String r="这是模拟会给客户端的数据";
////        String sss=MainServlet.doserver(ful.uri(),data);//将客户端的数据体传入
////
////        FullHttpResponse response=new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK,Unpooled.wrappedBuffer(sss.getBytes("UTF-8")));
////        response.headers().set(CONTENT_TYPE, "application/json");
////        response.headers().setInt(CONTENT_LENGTH,
////                response.content().readableBytes());
////       // if (HttpHeaderUtil.isKeepAlive(ful)) {
////        if(HttpHeaders.isKeepAlive(ful)){
////            response.headers().set(CONNECTION, KEEP_ALIVE);
////        }
////        ctx.write(response);
////        ctx.flush();
////        System.out.println("write");
//////            int a=5/0;
////
////        //开发文档.debug("--------------------------------------");
////    }
////
////
////
////    @Override
////    public void channelActive(ChannelHandlerContext ctx) throws Exception {
////        System.out.println("server handler is Active");
////
////    }
////
////
////}
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg)
//            throws Exception {
//        LOGGER.info("InHandler :" + ctx);
//        System.out.println("read");
//        System.out.println("inboune recive"+msg);
//        try {
////            System.out.println(msg.toString());
//           FullHttpRequest fhr =(FullHttpRequest) msg;
//            String url=fhr.uri();
////            ByteBuf result = (ByteBuf) msg;
////            byte[] result1 = new byte[result.readableBytes()];
////            result.readBytes(result1);
//            System.out.println("请求的URL："+fhr);
//            ByteBuf buf = fhr.content();
//            HttpHeaders head=fhr.headers();
////            System.out.println( head.toString());
//            byte[] result1 = new byte[buf.readableBytes()];
//            buf.readBytes(result1);
//            String data=new String(result1,"utf8");
//            System.out.println("读取的数据："+data);
////            ServletTest.doServlet(fhr.uri(),new
////                    Gson().fromJson(data,Goods.class));
//
//
//
////            ByteBuf buf = fhr.content();
////            String message = buf.toString(io.netty.util.CharsetUtil.UTF_8);
////            buf.release();
//            String tt =MainServlet.doserver(fhr.uri(),data);
//            FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1,
//                    OK, Unpooled.wrappedBuffer(tt.getBytes("UTF-8")));
//            response.headers().set(CONTENT_TYPE, "application/json");
//            response.headers().setInt(CONTENT_LENGTH,
//                    response.content().readableBytes());
//            if (HttpHeaderUtil.isKeepAlive(fhr)) {
//                response.headers().set(CONNECTION, KEEP_ALIVE);
//            }
//            ctx.write(response);
//            ctx.flush();
//            System.out.println("write");
////            int a=5/0;
//        }catch (Exception e){
//            LOGGER.debug("",e);
//            e.printStackTrace();
//        }
//        //开发文档.debug("--------------------------------------");
//    }
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("*******************");
//    }
//
//
//}
