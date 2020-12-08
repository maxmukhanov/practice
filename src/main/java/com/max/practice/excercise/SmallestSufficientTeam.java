package com.max.practice.excercise;

import java.util.*;

//https://leetcode.com/problems/smallest-sufficient-team/
public class SmallestSufficientTeam {
    List<Integer> sol = new ArrayList<>();

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

        Map<String, Integer> idx = new HashMap<>();
        int n = 0;
        for (String skill : req_skills) idx.put(skill, n++);
        int[] pe = new int[people.size()];
        for (int i = 0; i < pe.length; i++) {
            for (String skill : people.get(i)) {
                int skillInx = idx.get(skill);
                pe[i] += 1 << skillInx;
            }
        }

        search(0, pe, new ArrayList<>(), n);
        int[] res = new int[sol.size()];
        for (int i = 0; i < sol.size(); i++) res[i] = sol.get(i);
        return res;
    }

    private void search(int teamSkills, int[] pe, List<Integer> team, int n) {
        if (teamSkills == (1 << n) - 1) {
            if (sol.isEmpty() || sol.size() > team.size()) {
                sol.clear();
                sol.addAll(team);
            }
            return;
        }

        if (!sol.isEmpty() && team.size() >= sol.size()) return; //current team size is bigger than we have so far

        int zeroBits = 0;
        while (((teamSkills >> zeroBits) & 1) == 1) zeroBits++;

        for (int i = 0; i < pe.length; i++) {
            int personSkills = pe[i];
            if (((personSkills >> zeroBits) & 1) == 1) {
                team.add(i);
                search(teamSkills | personSkills, pe, team, n);
                team.remove(team.size() - 1);
            }
        }

    }


}
