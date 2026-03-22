package com.telusko.JobApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data // getter/setter, toString 등 자동 생성
@NoArgsConstructor // 기본 생성자 생성
@AllArgsConstructor // 모든 필드 포함 생성자 생성
@Component // Spring이 관리하는 객체로 등록
public class JobPost {

    private int postId; // 공고 ID

    private String postProfile; // 직무 이름 (예: Backend Developer)

    private String postDesc; // 공고 설명

    private int reqExperience; // 요구 경력 (년수)

    private List<String> postTechStack; // 기술 스택 목록 (예: Java, Spring)
}