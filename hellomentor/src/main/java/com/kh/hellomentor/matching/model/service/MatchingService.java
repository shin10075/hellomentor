package com.kh.hellomentor.matching.model.service;

import java.util.List;
import java.util.Map;


import com.kh.hellomentor.matching.model.vo.Matching;
import com.kh.hellomentor.matching.model.vo.Mentoring;
import com.kh.hellomentor.member.model.vo.Member;
import com.kh.hellomentor.member.model.vo.Profile;

public interface MatchingService {



    List<Mentoring> selectList(int currentPage, Map<String, Object> paramMap);

    public int insertMentoring(Mentoring mt);

    int selectListCount(Map<String, Object> paramMap);

    List<Member> getMentorList(int userNo);

    List<Profile> getMentorProfileList(int userNo);

    List<Mentoring> getMentoringList(int userNo);

    List<Matching> getMatchingList(int userNo);

    List<Member> getMentorList2(int userNo);

    List<Profile> getMentorProfileList2(int userNo);

    List<Mentoring> getMentoringList2(int userNo);

    List<Matching> getMatchingList2(int userNo);

    void mentoring_cancel(int userNo, int regisNo);

    void mentoring_accept(int userNo, int regisNo, int loginuserNo);
}