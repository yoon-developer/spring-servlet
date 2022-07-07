package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV3 {

  private MemberRepository memberRepository = MemberRepository.getInstance();

  @GetMapping("/new-form")
  public String newForm() {

    return "new-form";
  }

  @GetMapping
  public String members(Model model) {

    model.addAttribute("members", memberRepository.findAll());

    return "members";
  }

  @PostMapping("/save")
  public String save(
      @RequestParam("username") String username,
      @RequestParam("age") int age,
      Model model) {

    Member member = new Member(username, age);
    System.out.println("member = " + member);

    memberRepository.save(member);

    model.addAttribute("member", member);

    return "save-result";
  }

}
