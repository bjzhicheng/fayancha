package org.Util;

import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @Author: yanshilong
 * @Date: 18-8-31 下午1:35
 * @Version 1.0
 */
public class Message {

        FullHttpRequest fhr=null;
        private String url="";
        private String data="";
        private String cookies="";

        public FullHttpRequest getFhr() {
            return fhr;
        }

        public void setFhr(FullHttpRequest fhr) {
            this.fhr = fhr;
        }

        public String getCookies() {
            return cookies;
        }

        public void setCookies(String cookies) {
            this.cookies = cookies;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Message(String url, String data,String cookies) {
            this.url = url;
            this.data = data;
            this.cookies = cookies;
        }
        public Message(){}
    }


