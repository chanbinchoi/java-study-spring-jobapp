package com.telusko.JobApp.service;

import com.telusko.JobApp.model.JobPost;
import com.telusko.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Service 계층으로 등록 (비즈니스 로직 담당)
public class JobService {

    @Autowired // Spring이 JobRepo 객체를 자동으로 넣어줌 - 의존성 주입(DI, Dependency Injection)
    private JobRepo repo; // 데이터 저장/조회 담당 Repository 주입

    public void addJob(JobPost jobPost) {
        repo.addJob(jobPost); // 채용 공고를 저장소에 추가
    }

    public List<JobPost> getAllJobs() {
        return repo.getAllJobs(); // 전체 채용 공고 목록 반환
    }
}