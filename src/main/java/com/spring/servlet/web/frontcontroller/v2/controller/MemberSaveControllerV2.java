package com.spring.servlet.web.frontcontroller.v2.controller;

import com.spring.servlet.domain.member.Member;
import com.spring.servlet.domain.member.MemberRepository;
import com.spring.servlet.web.frontcontroller.MyView;
import com.spring.servlet.web.frontcontroller.v2.ControllerV2;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberSaveControllerV2 implements ControllerV2 {

  private MemberRepository memberRepository = MemberRepository.getInstance();


  @Override
  public MyView process(HttpServletRequest request, HttpServletResponse response) {

    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
    request.setAttribute("member", member);

    return new MyView("/WEB-INF/views/save-result.jsp");
  }
}
