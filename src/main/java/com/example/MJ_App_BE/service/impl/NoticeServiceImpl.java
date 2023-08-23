package com.example.MJ_App_BE.service.impl;

import com.example.MJ_App_BE.data.dao.*;
import com.example.MJ_App_BE.data.dto.noticedto.NoticeResponseDto;
import com.example.MJ_App_BE.data.entity.*;
import com.example.MJ_App_BE.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeDao noticeDao;
    private final Festival_NoticeDao festival_noticeDao;
    private final School_NoticeDao school_noticeDao;
    private final Edu_NoticeDao edu_noticeDao;
    private final Work_NoticeDao work_noticeDao;
    private final St_Work_NoticeDao st_work_noticeDao;
    private final Hum_NoticeDao hum_noticeDao;
    private final Business_NoticeDao business_noticeDao;
    private final Ict_NoticeDao ict_noticeDao;
    private final Law_NoticeDao law_noticeDao;

    @Autowired
    public NoticeServiceImpl(@Qualifier("noticeDaoImpl") NoticeDao noticeDao, Festival_NoticeDao festival_noticeDao, School_NoticeDao school_noticeDao,
                             Edu_NoticeDao edu_noticeDao, Work_NoticeDao work_noticeDao, St_Work_NoticeDao st_work_noticeDao, Ict_NoticeDao ict_noticeDao,
                             Hum_NoticeDao hum_noticeDao, Law_NoticeDao law_noticeDao, Business_NoticeDao business_noticeDao) {
        this.noticeDao = noticeDao; //일반공지
        this.festival_noticeDao = festival_noticeDao; //행사공지
        this.school_noticeDao = school_noticeDao; //학사공지
        this.edu_noticeDao = edu_noticeDao; //장학학자금공지
        this.work_noticeDao = work_noticeDao; //진로취업창업공지
        this.st_work_noticeDao = st_work_noticeDao; //학생활동공지

        this.ict_noticeDao = ict_noticeDao; //ICT공지
        this.hum_noticeDao = hum_noticeDao; //인문대공지
        this.law_noticeDao = law_noticeDao; //법대공지
        this.business_noticeDao = business_noticeDao; //경영대공지
    }

    @Override //카테고리 별 공지 받아오기
    public List<NoticeResponseDto> getCategoricalNotices(String category) {
        List<NoticeResponseDto> noticeResponseDtos = new ArrayList<NoticeResponseDto>();
        switch (category) {
            case "일반공지":
                List<Notice> notices = noticeDao.getAllNotices();
                for (int i = 0; i < notices.size(); i++) {
                    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
                    noticeResponseDto.setNoticeId(notices.get(i).getNoticeId());
                    noticeResponseDto.setNum(notices.get(i).getNum());
                    noticeResponseDto.setCategory(notices.get(i).getCategory());
                    noticeResponseDto.setTitle(notices.get(i).getTitle());
                    noticeResponseDto.setPubDate(notices.get(i).getPubDate());
                    noticeResponseDto.setLink(notices.get(i).getLink());
//                  noticeResponseDto.setUniv(notices.get(i).getUniv());
                    noticeResponseDtos.add(noticeResponseDto);
                }
                break;
            case "행사공지":
                List<Festival_Notice> festival_notices = festival_noticeDao.getAllNotices();
                for (int i = 0; i < festival_notices.size(); i++) {
                    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
                    noticeResponseDto.setNoticeId(festival_notices.get(i).getNoticeId());
                    noticeResponseDto.setNum(festival_notices.get(i).getNum());
                    noticeResponseDto.setCategory(festival_notices.get(i).getCategory());
                    noticeResponseDto.setTitle(festival_notices.get(i).getTitle());
                    noticeResponseDto.setPubDate(festival_notices.get(i).getPubDate());
                    noticeResponseDto.setLink(festival_notices.get(i).getLink());
//                  noticeResponseDto.setUniv(festival_notices.get(i).getUniv());
                    noticeResponseDtos.add(noticeResponseDto);
                }
                break;
            case "학사공지":
                List<School_Notice> school_notices = school_noticeDao.getAllNotices();
                for (int i = 0; i < school_notices.size(); i++) {
                    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
                    noticeResponseDto.setNoticeId(school_notices.get(i).getNoticeId());
                    noticeResponseDto.setNum(school_notices.get(i).getNum());
                    noticeResponseDto.setCategory(school_notices.get(i).getCategory());
                    noticeResponseDto.setTitle(school_notices.get(i).getTitle());
                    noticeResponseDto.setPubDate(school_notices.get(i).getPubDate());
                    noticeResponseDto.setLink(school_notices.get(i).getLink());
//                  noticeResponseDto.setUniv(school_notices.get(i).getUniv());
                    noticeResponseDtos.add(noticeResponseDto);
                }
                break;
            case "장학학자금공지":
                List<Edu_Notice> edu_notices = edu_noticeDao.getAllNotices();
                for (int i = 0; i < edu_notices.size(); i++) {
                    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
                    noticeResponseDto.setNoticeId(edu_notices.get(i).getNoticeId());
                    noticeResponseDto.setNum(edu_notices.get(i).getNum());
                    noticeResponseDto.setCategory(edu_notices.get(i).getCategory());
                    noticeResponseDto.setTitle(edu_notices.get(i).getTitle());
                    noticeResponseDto.setPubDate(edu_notices.get(i).getPubDate());
                    noticeResponseDto.setLink(edu_notices.get(i).getLink());
//                  noticeResponseDto.setUniv(edu_notices.get(i).getUniv());
                    noticeResponseDtos.add(noticeResponseDto);
                }
                break;
            case "진로취업창업공지":
                List<Work_Notice> work_notices = work_noticeDao.getAllNotices();
                for (int i = 0; i < work_notices.size(); i++) {
                    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
                    noticeResponseDto.setNoticeId(work_notices.get(i).getNoticeId());
                    noticeResponseDto.setNum(work_notices.get(i).getNum());
                    noticeResponseDto.setCategory(work_notices.get(i).getCategory());
                    noticeResponseDto.setTitle(work_notices.get(i).getTitle());
                    noticeResponseDto.setPubDate(work_notices.get(i).getPubDate());
                    noticeResponseDto.setLink(work_notices.get(i).getLink());
//                  noticeResponseDto.setUniv(work_notices.get(i).getUniv());
                    noticeResponseDtos.add(noticeResponseDto);
                }
                break;
            case "학생활동공지":
                List<St_Work_Notice> st_work_notices = st_work_noticeDao.getAllNotices();
                for (int i = 0; i < st_work_notices.size(); i++) {
                    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
                    noticeResponseDto.setNoticeId(st_work_notices.get(i).getNoticeId());
                    noticeResponseDto.setNum(st_work_notices.get(i).getNum());
                    noticeResponseDto.setCategory(st_work_notices.get(i).getCategory());
                    noticeResponseDto.setTitle(st_work_notices.get(i).getTitle());
                    noticeResponseDto.setPubDate(st_work_notices.get(i).getPubDate());
                    noticeResponseDto.setLink(st_work_notices.get(i).getLink());
//                  noticeResponseDto.setUniv(st_work_notices.get(i).getUniv());
                    noticeResponseDtos.add(noticeResponseDto);
                }
                break;
            case "인문대공지":
                List<Hum_Notice> hum_notices = hum_noticeDao.getAllNotices();
                for (int i = 0; i < hum_notices.size(); i++) {
                    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
                    noticeResponseDto.setNoticeId(hum_notices.get(i).getNoticeId());
                    noticeResponseDto.setNum(hum_notices.get(i).getNum());
                    noticeResponseDto.setCategory(hum_notices.get(i).getCategory());
                    noticeResponseDto.setTitle(hum_notices.get(i).getTitle());
                    noticeResponseDto.setPubDate(hum_notices.get(i).getPubDate());
                    noticeResponseDto.setLink(hum_notices.get(i).getLink());
//                  noticeResponseDto.setUniv(hum_notices.get(i).getUniv());
                    noticeResponseDtos.add(noticeResponseDto);
                }
                break;
            case "경영대공지":
                List<Business_Notice> business_notices = business_noticeDao.getAllNotices();
                for (int i = 0; i < business_notices.size(); i++) {
                    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
                    noticeResponseDto.setNoticeId(business_notices.get(i).getNoticeId());
                    noticeResponseDto.setNum(business_notices.get(i).getNum());
                    noticeResponseDto.setCategory(business_notices.get(i).getCategory());
                    noticeResponseDto.setTitle(business_notices.get(i).getTitle());
                    noticeResponseDto.setPubDate(business_notices.get(i).getPubDate());
                    noticeResponseDto.setLink(business_notices.get(i).getLink());
//                  noticeResponseDto.setUniv(business_notices.get(i).getUniv());
                    noticeResponseDtos.add(noticeResponseDto);
                }
                break;
            case "법대공지":
                List<Law_Notice> law_notices = law_noticeDao.getAllNotices();
                for (int i = 0; i < law_notices.size(); i++) {
                    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
                    noticeResponseDto.setNoticeId(law_notices.get(i).getNoticeId());
                    noticeResponseDto.setNum(law_notices.get(i).getNum());
                    noticeResponseDto.setCategory(law_notices.get(i).getCategory());
                    noticeResponseDto.setTitle(law_notices.get(i).getTitle());
                    noticeResponseDto.setPubDate(law_notices.get(i).getPubDate());
                    noticeResponseDto.setLink(law_notices.get(i).getLink());
//                  noticeResponseDto.setUniv(law_notices.get(i).getUniv());
                    noticeResponseDtos.add(noticeResponseDto);
                }
                break;
            case "ICT공지":
                List<Ict_Notice> ict_notices = ict_noticeDao.getAllNotices();
                for (int i = 0; i < ict_notices.size(); i++) {
                    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
                    noticeResponseDto.setNoticeId(ict_notices.get(i).getNoticeId());
                    noticeResponseDto.setNum(ict_notices.get(i).getNum());
                    noticeResponseDto.setCategory(ict_notices.get(i).getCategory());
                    noticeResponseDto.setTitle(ict_notices.get(i).getTitle());
                    noticeResponseDto.setPubDate(ict_notices.get(i).getPubDate());
                    noticeResponseDto.setLink(ict_notices.get(i).getLink());
//                  noticeResponseDto.setUniv(ict_notices.get(i).getUniv());
                    noticeResponseDtos.add(noticeResponseDto);
                }
                break;
            default: break;
        }
        return noticeResponseDtos;
    }
    @Override //카테고리 별 공지 검색
    public List<NoticeResponseDto> getCategoricalNoticesbyKeyword(String category, String keyword) {
        List<NoticeResponseDto> noticeResponseDtos = new ArrayList<NoticeResponseDto>();
        switch (category) {
            case "일반공지":
                List<Notice> notices = noticeDao.getNoticesbyKeyword(keyword);
                for (int i = 0; i < notices.size(); i++) {
                    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
                    noticeResponseDto.setNoticeId(notices.get(i).getNoticeId());
                    noticeResponseDto.setNum(notices.get(i).getNum());
                    noticeResponseDto.setCategory(notices.get(i).getCategory());
                    noticeResponseDto.setTitle(notices.get(i).getTitle());
                    noticeResponseDto.setPubDate(notices.get(i).getPubDate());
                    noticeResponseDto.setLink(notices.get(i).getLink());
//                  noticeResponseDto.setUniv(notices.get(i).getUniv());
                    noticeResponseDtos.add(noticeResponseDto);
                }
                break;
            case "행사공지":
                List<Festival_Notice> festival_notices = festival_noticeDao.getNoticesbyKeyword(keyword);
                for (int i = 0; i < festival_notices.size(); i++) {
                    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
                    noticeResponseDto.setNoticeId(festival_notices.get(i).getNoticeId());
                    noticeResponseDto.setNum(festival_notices.get(i).getNum());
                    noticeResponseDto.setCategory(festival_notices.get(i).getCategory());
                    noticeResponseDto.setTitle(festival_notices.get(i).getTitle());
                    noticeResponseDto.setPubDate(festival_notices.get(i).getPubDate());
                    noticeResponseDto.setLink(festival_notices.get(i).getLink());
//                  noticeResponseDto.setUniv(festival_notices.get(i).getUniv());
                    noticeResponseDtos.add(noticeResponseDto);
                }
                break;
            case "학사공지":
                List<School_Notice> school_notices = school_noticeDao.getNoticesbyKeyword(keyword);
                for (int i = 0; i < school_notices.size(); i++) {
                    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
                    noticeResponseDto.setNoticeId(school_notices.get(i).getNoticeId());
                    noticeResponseDto.setNum(school_notices.get(i).getNum());
                    noticeResponseDto.setCategory(school_notices.get(i).getCategory());
                    noticeResponseDto.setTitle(school_notices.get(i).getTitle());
                    noticeResponseDto.setPubDate(school_notices.get(i).getPubDate());
                    noticeResponseDto.setLink(school_notices.get(i).getLink());
//                  noticeResponseDto.setUniv(school_notices.get(i).getUniv());
                    noticeResponseDtos.add(noticeResponseDto);
                }
                break;
            case "장학학자금공지":
                List<Edu_Notice> edu_notices = edu_noticeDao.getNoticesbyKeyword(keyword);
                for (int i = 0; i < edu_notices.size(); i++) {
                    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
                    noticeResponseDto.setNoticeId(edu_notices.get(i).getNoticeId());
                    noticeResponseDto.setNum(edu_notices.get(i).getNum());
                    noticeResponseDto.setCategory(edu_notices.get(i).getCategory());
                    noticeResponseDto.setTitle(edu_notices.get(i).getTitle());
                    noticeResponseDto.setPubDate(edu_notices.get(i).getPubDate());
                    noticeResponseDto.setLink(edu_notices.get(i).getLink());
//                  noticeResponseDto.setUniv(edu_notices.get(i).getUniv());
                    noticeResponseDtos.add(noticeResponseDto);
                }
                break;
            case "진로취업창업공지":
                List<Work_Notice> work_notices = work_noticeDao.getNoticesbyKeyword(keyword);
                for (int i = 0; i < work_notices.size(); i++) {
                    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
                    noticeResponseDto.setNoticeId(work_notices.get(i).getNoticeId());
                    noticeResponseDto.setNum(work_notices.get(i).getNum());
                    noticeResponseDto.setCategory(work_notices.get(i).getCategory());
                    noticeResponseDto.setTitle(work_notices.get(i).getTitle());
                    noticeResponseDto.setPubDate(work_notices.get(i).getPubDate());
                    noticeResponseDto.setLink(work_notices.get(i).getLink());
//                  noticeResponseDto.setUniv(work_notices.get(i).getUniv());
                    noticeResponseDtos.add(noticeResponseDto);
                }
                break;
            case "학생활동공지":
                List<St_Work_Notice> st_work_notices = st_work_noticeDao.getNoticesbyKeyword(keyword);
                for (int i = 0; i < st_work_notices.size(); i++) {
                    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
                    noticeResponseDto.setNoticeId(st_work_notices.get(i).getNoticeId());
                    noticeResponseDto.setNum(st_work_notices.get(i).getNum());
                    noticeResponseDto.setCategory(st_work_notices.get(i).getCategory());
                    noticeResponseDto.setTitle(st_work_notices.get(i).getTitle());
                    noticeResponseDto.setPubDate(st_work_notices.get(i).getPubDate());
                    noticeResponseDto.setLink(st_work_notices.get(i).getLink());
//                  noticeResponseDto.setUniv(st_work_notices.get(i).getUniv());
                    noticeResponseDtos.add(noticeResponseDto);
                }
                break;
            case "인문대공지":
                List<Hum_Notice> hum_notices = hum_noticeDao.getNoticesbyKeyword(keyword);
                for (int i = 0; i < hum_notices.size(); i++) {
                    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
                    noticeResponseDto.setNoticeId(hum_notices.get(i).getNoticeId());
                    noticeResponseDto.setNum(hum_notices.get(i).getNum());
                    noticeResponseDto.setCategory(hum_notices.get(i).getCategory());
                    noticeResponseDto.setTitle(hum_notices.get(i).getTitle());
                    noticeResponseDto.setPubDate(hum_notices.get(i).getPubDate());
                    noticeResponseDto.setLink(hum_notices.get(i).getLink());
//                  noticeResponseDto.setUniv(hum_notices.get(i).getUniv());
                    noticeResponseDtos.add(noticeResponseDto);
                }
                break;
            case "경영대공지":
                List<Business_Notice> business_notices = business_noticeDao.getNoticesbyKeyword(keyword);
                for (int i = 0; i < business_notices.size(); i++) {
                    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
                    noticeResponseDto.setNoticeId(business_notices.get(i).getNoticeId());
                    noticeResponseDto.setNum(business_notices.get(i).getNum());
                    noticeResponseDto.setCategory(business_notices.get(i).getCategory());
                    noticeResponseDto.setTitle(business_notices.get(i).getTitle());
                    noticeResponseDto.setPubDate(business_notices.get(i).getPubDate());
                    noticeResponseDto.setLink(business_notices.get(i).getLink());
//                  noticeResponseDto.setUniv(business_notices.get(i).getUniv());
                    noticeResponseDtos.add(noticeResponseDto);
                }
                break;
            case "법대공지":
                List<Law_Notice> law_notices = law_noticeDao.getNoticesbyKeyword(keyword);
                for (int i = 0; i < law_notices.size(); i++) {
                    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
                    noticeResponseDto.setNoticeId(law_notices.get(i).getNoticeId());
                    noticeResponseDto.setNum(law_notices.get(i).getNum());
                    noticeResponseDto.setCategory(law_notices.get(i).getCategory());
                    noticeResponseDto.setTitle(law_notices.get(i).getTitle());
                    noticeResponseDto.setPubDate(law_notices.get(i).getPubDate());
                    noticeResponseDto.setLink(law_notices.get(i).getLink());
//                  noticeResponseDto.setUniv(law_notices.get(i).getUniv());
                    noticeResponseDtos.add(noticeResponseDto);
                }
                break;
            case "ICT공지":
                List<Ict_Notice> ict_notices = ict_noticeDao.getNoticesbyKeyword(keyword);
                for (int i = 0; i < ict_notices.size(); i++) {
                    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
                    noticeResponseDto.setNoticeId(ict_notices.get(i).getNoticeId());
                    noticeResponseDto.setNum(ict_notices.get(i).getNum());
                    noticeResponseDto.setCategory(ict_notices.get(i).getCategory());
                    noticeResponseDto.setTitle(ict_notices.get(i).getTitle());
                    noticeResponseDto.setPubDate(ict_notices.get(i).getPubDate());
                    noticeResponseDto.setLink(ict_notices.get(i).getLink());
//                  noticeResponseDto.setUniv(ict_notices.get(i).getUniv());
                    noticeResponseDtos.add(noticeResponseDto);
                }
                break;
            default: break;
        }
        return noticeResponseDtos;
    }

    @Override
    public NoticeResponseDto getRecent() {
        Notice notice = noticeDao.getRecent();

        NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
        noticeResponseDto.setNoticeId(notice.getNoticeId());
        noticeResponseDto.setNum(notice.getNum());
        noticeResponseDto.setCategory(notice.getCategory());
        noticeResponseDto.setTitle(notice.getTitle());
        noticeResponseDto.setPubDate(notice.getPubDate());
        noticeResponseDto.setLink(notice.getLink());
//            noticeResponseDto.setUniv(notice.getUniv());
        return noticeResponseDto;

    }

}
