package com.spring.servlet.web.frontcontroller.v4.controller;

import com.spring.servlet.domain.member.MemberRepository;
import com.spring.servlet.web.frontcontroller.v4.ControllerV4;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

  private MemberRepository memberRepository = MemberRepository.getInstance();

  @Override
  public String process(Map<String, String> paramMap, Map<String, Object> model) {

    model.put("members", memberRepository.findAll());

    return "members";
  }
}
