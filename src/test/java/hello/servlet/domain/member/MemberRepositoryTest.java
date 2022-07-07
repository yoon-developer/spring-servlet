package hello.servlet.domain.member;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {

  MemberRepository memberRepository = MemberRepository.getInstance();

  @AfterEach
  public void afterEach() {
    memberRepository.clearStore();
  }

  @Test
  @DisplayName("저장")
  public void save() throws Exception {
    //given
    Member member = new Member("yoondev", 30);

    //when
    Member saveMember = memberRepository.save(member);

    //then
    Member findMember = memberRepository.findById(saveMember.getId());
    assertThat(findMember).isEqualTo(saveMember);

  }

  @Test
  @DisplayName("전체 조회")
  public void findAll() throws Exception {
    //given
    Member member1 = new Member("yoondev", 20);
    Member member2 = new Member("yoondev", 30);

    memberRepository.save(member1);
    memberRepository.save(member2);

    //when
    List<Member> result = memberRepository.findAll();

    //then
    assertThat(result.size()).isEqualTo(2);
    assertThat(result).contains(member1, member2);
  }

}