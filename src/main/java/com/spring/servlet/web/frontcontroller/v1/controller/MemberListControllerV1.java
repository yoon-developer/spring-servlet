package com.spring.servlet.web.frontcontroller.v1.controller;

import com.spring.servlet.domain.member.MemberRepository;
import com.spring.servlet.web.frontcontroller.v1.ControllerV1;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberListControllerV1 implements ControllerV1 {

  private MemberRepository memberRepository = MemberRepository.getInstance();

  @Override
  public void process(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    request.setAttribute("members", memberRepository.findAll());

    String viewPath = "/WEB-INF/views/members.jsp";
    RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
    dispatcher.forward(request, response);
  }
}
