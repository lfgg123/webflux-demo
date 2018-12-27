///*
// * @Copyright: 2005-2018 www.2345.com. All rights reserved.
// */
//package com.spring.demo.servlet;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author chentl
// * @version AsyncServlet, v0.1 2018/11/13 17:42
// */
//@WebServlet(asyncSupported = true, urlPatterns = { "/asyncServlet" },loadOnStartup =1)
//public class AsyncServlet extends HttpServlet{
//    private static final long serialVersionUID = -7866867916620854518L;
//
//    public AsyncServlet() {
//        super();
//    }
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//
//        System.out.println("servlet初始化...");
//    }
//
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        long t1 = System.currentTimeMillis();
//
//        // 开启异步
//        AsyncContext asyncContext = req.startAsync();
//
//        // 执行业务代码
//        CompletableFuture.runAsync(() -> doSomeThing(asyncContext,
//                asyncContext.getRequest(), asyncContext.getResponse()));
//
//        System.out.println("async use:" + (System.currentTimeMillis() - t1));
//    }
//
//    private void doSomeThing(AsyncContext asyncContext,
//                             ServletRequest servletRequest, ServletResponse servletResponse) {
//
//        // 模拟耗时操作
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//        }
//
//        //
//        try {
//            servletResponse.getWriter().append("done");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // 业务代码处理完毕, 通知结束
//        asyncContext.complete();
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
//
//
//}
