package com.max.practice.excercise;

import java.util.*;

//https://leetcode.com/problems/smallest-sufficient-team/
public class SmallestSufficientTeam {

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

        Map<String, Integer> skillIndex = new HashMap<>();
        for (int i = 0; i < req_skills.length; i++) skillIndex.put(req_skills[i], i);

        int[] peopleSkills = new int[people.size()];
        for (int i = 0; i < peopleSkills.length; i++) {
            for (String personSkill : people.get(i)) {
                int skillIdx = skillIndex.get(personSkill);
                peopleSkills[i] |= 1 << skillIdx;
            }
        }

        List<Integer> ans = new ArrayList<>();
        search(0, new ArrayList<>(), peopleSkills, req_skills.length, ans);

        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) res[i] = ans.get(i);
        return res;
    }

    void search(int teamSkills, List<Integer> team, int[] peopleSkills, int reqSkillSize, List<Integer> ans) {
        if (teamSkills == (1 << reqSkillSize) - 1) {
            if (ans.isEmpty() || ans.size() > team.size()) {
                ans.clear();
                ans.addAll(team);
            }
            return;
        }

        if (!ans.isEmpty() && team.size() > ans.size()) return;

        int zeroBit = 0;
        while (((teamSkills >> zeroBit) & 1) == 1) zeroBit++;

        for (int i = 0; i < peopleSkills.length; i++) {
            if (((peopleSkills[i] >> zeroBit) & 1) == 1) {
                team.add(i);
                search(teamSkills | peopleSkills[i], team, peopleSkills, reqSkillSize, ans);
                team.remove(team.size() - 1);
            }
        }
    }
}
