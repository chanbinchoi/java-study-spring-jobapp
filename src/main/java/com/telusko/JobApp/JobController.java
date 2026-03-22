package com.telusko.JobApp;

import com.telusko.JobApp.model.JobPost;
import com.telusko.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // 웹 요청을 처리하는 컨트롤러 클래스
public class JobController {

    @Autowired
    private JobService service; // 비즈니스 로직 처리용 Service 객체 주입

    @GetMapping({"/", "home"}) // "/" 또는 "/home" 요청이 오면 실행
    public String home() {
        return "home"; // home.jsp 화면 반환
    }

    @GetMapping("/addjob") // "/addjob" 요청이 오면 실행
    public String addJob() {
        return "addjob"; // addjob.jsp(채용공고 입력 폼) 화면 반환
    }

    @PostMapping("handleForm") // 폼이 POST 방식으로 제출되면 실행
    public String handleForm(JobPost jobPost) { // 폼에서 입력한 값들을 JobPost 객체로 자동 바인딩
        service.addJob(jobPost); // Service를 통해 채용공고 저장
        return "success"; // success.jsp 결과 화면 반환
    }

    @GetMapping("viewalljobs") // "/viewalljobs" 요청 처리
    public String viewJobs(Model m) {
        List<JobPost> jobs = service.getAllJobs(); // Service에서 모든 채용 공고 목록 가져오기
        m.addAttribute("jobPosts", jobs);  // View(JSP)로 데이터 전달 (이름: jobPosts)
        return "viewalljobs"; // viewalljobs.jsp 화면 반환
    }
}