///*
// * @Copyright: 2005-2018 www.2345.com. All rights reserved.
// */
//package com.spring.demo.servlet;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author chentl
// * @version See, v0.1 2018/11/14 13:28
// */
//@WebServlet("/SSE")
//public class Sse extends HttpServlet {
//
//
//    private static final long serialVersionUID = 2109343371310877266L;
//
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Sse() {
//        super();
//    }
//
//    /**
//     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//     *      response)
//     */
//    @Override
//    protected void doGet(HttpServletRequest request,
//                         HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/event-stream");
//        response.setCharacterEncoding("utf-8");
//
//        for (int i = 0; i < 5; i++) {
//            // 指定事件标识
//            response.getWriter().write("event:me\n");
//            // 格式: data: + 数据 + 2个回车
//            response.getWriter().write("data:" + i + "\n\n");
//            response.getWriter().flush();
//
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//            }
//        }
//
//    }
//
//    /**
//     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//     *      response)
//     */
//    @Override
//    protected void doPost(HttpServletRequest request,
//                          HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
//}
