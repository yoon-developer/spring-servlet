package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.request.HelloData;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

  private ObjectMapper objectMapper = new ObjectMapper();

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

//    response.setHeader("Content-Type", "application/json");
    response.setContentType("application/json");

    //application/json 은 기본 적으로 utf-8 형식을 사용 
    response.setCharacterEncoding("utf-8");

    HelloData helloData = new HelloData();
    helloData.setUsername("yoondev");
    helloData.setAge(30);

    String result = objectMapper.writeValueAsString(helloData);

    response.getWriter().write(result);

  }
}
