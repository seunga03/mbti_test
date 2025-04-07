package com.example.mbti.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MbtiResult {
    private String type;
    private int e, i, s, n, t, f, j, p;

    public int getEPercent() {
        return calculatePercent(e, i);
    }

    public int getIPercent() {
        return 100 - getEPercent();
    }

    public int getNPercent() {
        return calculatePercent(n, s);
    }

    public int getSPercent() {
        return 100 - getNPercent();
    }

    public int getFPercent() {
        return calculatePercent(f, t);
    }

    public int getTPercent() {
        return 100 - getFPercent();
    }

    public int getPPercent() {
        return calculatePercent(p, j);
    }

    public int getJPercent() {
        return 100 - getPPercent();
    }
    private int calculatePercent(int first, int second) {
        int total = first + second;
        return total == 0 ? 0 : (int) ((first * 100.0) / total);
    }
}
