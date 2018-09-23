package org.mainServer;

import com.google.gson.Gson;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerInvoker;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderUtil;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder;
import io.netty.util.concurrent.EventExecutorGroup;
import org.Download.ChangeFile;
import org.Download.ChangePic;
import org.Download.HandlePic;
import org.ShenHe.ShenCha;
import org.ShenHe.UserDao;
import org.Util.Message;
import org.Util.State;

import java.util.List;

import static io.netty.handler.codec.http.HttpHeaderNames.*;
import static io.netty.handler.codec.http.HttpHeaderNames.KEEP_ALIVE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * @Author: yanshilong
 * @Date: 18-9-21 下午10:30
 * @Version 1.0
 */
public class CheckHandler extends ChannelInboundHandlerAdapter {
    private ChannelHandlerContext ctx=null;
    private Message message=null;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpRequest request= (FullHttpRequest) msg;
        String uri=request.uri();
        HttpPostRequestDecoder decoder=null;
        if (uri.equals("   ")){
            List<InterfaceHttpData> parmlist=null;
            decoder=new HttpPostRequestDecoder(request);
            InterfaceHttpPostRequestDecoder httdecoder=decoder.offer(request);
            parmlist=httdecoder.getBodyHttpDatas();

            HandlePic handlePic=new HandlePic();
            String path=handlePic.handle(parmlist);

            System.out.println(path);

            // String path="/home/syl/文档/Picture/1951070349.jpg";

            ChangePic changePic=new ChangePic();

            System.out.println(changePic.ChangePic(path));

            System.out.println(changePic.ChangePic(path));
            String aaa=changePic.ChangePic(path);

            UserDao newuser=new UserDao();
            newuser.setUserid(Integer.parseInt(String.valueOf(parmlist.get(0))));
            newuser.setMessage(aaa);


            State state=new State();
            ShenCha shenCha=new ShenCha();


            state= shenCha.DoShenCha(newuser);




            System.out.println(state.getState());

            String res=new Gson().toJson(state);
            System.out.println("return-----------"+res);

            FullHttpResponse response = null;
            response = new DefaultFullHttpResponse(HTTP_1_1,
                    OK, Unpooled.wrappedBuffer(res.getBytes("UTF-8")));




            response.headers().set(CONTENT_TYPE, "application/json");
            response.headers().setInt(CONTENT_LENGTH,
                    response.content().readableBytes());


           // response.headers().set(ACCESS_CONTROL_ALLOW_ORIGIN,"*");
            if (HttpHeaderUtil.isKeepAlive(this.message.getFhr())) {
                response.headers().set(CONNECTION, KEEP_ALIVE);
            }
//            if(state.getServer().equals("doRegister")){
//                response.headers().set(COOKIE,state.getCookies());
//            }


            this.ctx.write(response);
            this.ctx.flush();



        }
else if (uri.equals("11111")){

            List<InterfaceHttpData> parmlist=null;
            decoder=new HttpPostRequestDecoder(request);
            InterfaceHttpPostRequestDecoder httdecoder=decoder.offer(request);
            parmlist=httdecoder.getBodyHttpDatas();

            String []a = parmlist.get(0).toString().split("=");
            int id=Integer.parseInt(a[1]);
            String []b = parmlist.get(1).toString().split("=");
            String filename=b[1];

//            HandlePic handlePic=new HandlePic();
//            String path=handlePic.handle(parmlist);
//
//            System.out.println(path);


            ChangeFile changeFile=new ChangeFile();
            String re=null;


            re=changeFile.change(filename);



            UserDao newuser=new UserDao();
            newuser.setUserid(Integer.parseInt(String.valueOf(parmlist.get(0))));
            newuser.setMessage(re);


            State state=new State();
            ShenCha shenCha=new ShenCha();


            state= shenCha.DoShenCha(newuser);




            System.out.println(state.getState());

            String res=new Gson().toJson(state);
            System.out.println("return-----------"+res);



            FullHttpResponse response = null;
            response = new DefaultFullHttpResponse(HTTP_1_1,
                    OK, Unpooled.wrappedBuffer(res.getBytes("UTF-8")));




            response.headers().set(CONTENT_TYPE, "application/json");
            response.headers().setInt(CONTENT_LENGTH,
                    response.content().readableBytes());


            // response.headers().set(ACCESS_CONTROL_ALLOW_ORIGIN,"*");
            if (HttpHeaderUtil.isKeepAlive(this.message.getFhr())) {
                response.headers().set(CONNECTION, KEEP_ALIVE);
            }
//            if(state.getServer().equals("doRegister")){
//                response.headers().set(COOKIE,state.getCookies());
//            }


            this.ctx.write(response);
            this.ctx.flush();




        }

//        else  if(uri.equals("")){
//
//        }




        else {
            ctx.fireChannelRead(msg);
        }
    }
}
