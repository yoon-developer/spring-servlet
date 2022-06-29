package com.spring.servlet.web.frontcontroller.v2.controller;

import com.spring.servlet.domain.member.MemberRepository;
import com.spring.servlet.web.frontcontroller.MyView;
import com.spring.servlet.web.frontcontroller.v2.ControllerV2;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberListControllerV2 implements ControllerV2 {

  private MemberRepository memberRepository = MemberRepository.getInstance();

  @Override
  public MyView process(HttpServletRequest request, HttpServletResponse response) {

    request.setAttribute("members", memberRepository.findAll());

    return new MyView("/WEB-INF/views/members.jsp");
  }
}
