package com.example.mbti.controller;

import com.example.mbti.dto.AnswerRequest;
import com.example.mbti.dto.MbtiResult;
import com.example.mbti.service.MbtiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MbtiController {

    private final MbtiService mbtiService;

    public MbtiController(MbtiService mbtiService) {
        this.mbtiService = mbtiService;
    }

    // e, i, s, n, t, f, j, p
    @GetMapping("/mbti/test")
    public String showTestForm(Model model) {
        List<String> questions = List.of(
                "다양한 사람들과 어울리는 것을 즐긴다.",
                "혼자 시간을 보내는 것이 에너지를 회복하는 데 도움이 된다.",
                "구체적인 사실과 현실에 집중하는 편이다.",
                "새로운 아이디어나 가능성을 상상하는 것을 좋아한다.",
                "결정할 때 논리와 이성을 중시한다.",
                "다른 사람의 감정에 공감하며 배려하려 한다.",
                "계획을 세우고 체계적으로 움직이는 것을 선호한다.",
                "즉흥적으로 유연하게 행동하는 것을 선호한다."
        );
        model.addAttribute("questions", questions);
        return "test-form"; // templates/test-form.html
    }

    @PostMapping("/mbti/test")
    public String processTest(@RequestParam List<Integer> answers, Model model) {
        MbtiResult result = mbtiService.calculateMbti(answers);
        model.addAttribute("mbti", result);
        return "result";
    }


    @RestController
    @RequestMapping("/api/mbti")
    static class MbtiApiController {
        private final MbtiService mbtiService;

        public MbtiApiController(MbtiService mbtiService) {
            this.mbtiService = mbtiService;
        }

        @PostMapping("/test")
        public MbtiResult getMbtiResult(@RequestBody AnswerRequest request) {
            return mbtiService.calculateMbti(request.getAnswers());
        }
    }
}
