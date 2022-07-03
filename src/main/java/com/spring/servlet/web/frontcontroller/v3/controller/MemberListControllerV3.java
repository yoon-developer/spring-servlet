package com.spring.servlet.web.frontcontroller.v3.controller;

import com.spring.servlet.domain.member.MemberRepository;
import com.spring.servlet.web.frontcontroller.ModelView;
import com.spring.servlet.web.frontcontroller.v3.ControllerV3;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

  private MemberRepository memberRepository = MemberRepository.getInstance();

  @Override
  public ModelView process(Map<String, String> paramMap) {

    ModelView mv = new ModelView("members");
    mv.getModel().put("members", memberRepository.findAll());

    return mv;
  }
}
