package com.example.mbti.service;

import com.example.mbti.dto.MbtiResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MbtiService {

    public MbtiResult calculateMbti(List<Integer> answers) {
        if (answers == null || answers.size() != 8) {
            return new MbtiResult("Invalid", 0, 0, 0, 0, 0, 0, 0, 0);
        }

        int e = answers.get(0);
        int i = answers.get(1);
        int s = answers.get(2);
        int n = answers.get(3);
        int t = answers.get(4);
        int f = answers.get(5);
        int j = answers.get(6);
        int p = answers.get(7);

        StringBuilder mbti = new StringBuilder();
        mbti.append(e >= i ? "E" : "I");
        mbti.append(s >= n ? "S" : "N");
        mbti.append(t >= f ? "T" : "F");
        mbti.append(j >= p ? "J" : "P");

        return new MbtiResult(mbti.toString(), e, i, s, n, t, f, j, p);
    }
}
