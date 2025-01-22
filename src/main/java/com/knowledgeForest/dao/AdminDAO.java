package com.knowledgeForest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.knowledgeForest.config.MyBatisConfig;
import com.knowledgeForest.dto.NoticeDTO;
import com.knowledgeForest.dto.StudyUserDTO;
import com.knowledgeForest.dto.UserDTO;

public class AdminDAO {
	
	public SqlSession sqlSession;

	public AdminDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

//	모든 유저 목록 조회
	public List<UserDTO> selectUserAll() {
		return sqlSession.selectList("AdminMapper.selectUserAll");
	}
	
//	모든 유저 목록 조회 - 검색
	public List<UserDTO> selectUserSearch(String keyword) {
		return sqlSession.selectList("AdminMapper.selectUserSearch", keyword);
	}
	
//	해당 유저 상세 조회
	public UserDTO selectUserOne(int userNum) {
		return sqlSession.selectOne("AdminMapper.selectUserOne", userNum);
	}
	
//	해당 유저가 작성한 스터디 개수 조회
	public int countStudy(int userNum) {
		return sqlSession.selectOne("AdminMapper.countStudy", userNum);
	}
	
//	해당 유저가 신청한 스터디 개수 조회
	public int countApply(int userNum) {
		return sqlSession.selectOne("AdminMapper.countApply", userNum);
	}
	
//	해당 유저가 작성한 스터디 댓글 개수 조회
	public int countStudyComment(int userNum) {
		return sqlSession.selectOne("AdminMapper.countStudyComment", userNum);
	}
	
//	해당 유저가 작성한 자유게시판 개수 조회
	public int countBoard(int userNum) {
		return sqlSession.selectOne("AdminMapper.countBoard", userNum);
	}
	
//	해당 유저가 작성한 자유게시판 댓글 개수 조회
	public int countBoardComment(int userNum) {
		return sqlSession.selectOne("AdminMapper.countBoardComment", userNum);
	}
	
//	해당 유저 탈퇴
	public void deleteUser(int userNum) {
		sqlSession.delete("AdminMapper.deleteUser", userNum);
	}
	
//	스터디 목록 조회
	public List<StudyUserDTO> selectStudyAll() {
		return sqlSession.selectList("AdminMapper.selectStudyAll");
	}
	
//	스터디 목록 조회 - 검색
	public List<StudyUserDTO> selectStudySearch(String keyword) {
		return sqlSession.selectList("AdminMapper.selectStudySearch", keyword);
	}
	
//	해당 스터디 삭제
	public void deleteStudy (int studyNum) {
		sqlSession.delete("AdminMapper.deleteStudy", studyNum);
	}
	
//	공지 목록 조회
	public List<NoticeDTO> selectNoticeAll() {
		return sqlSession.selectList("AdminMapper.selectNoticeAll");
	}
	
//	공지 목록 조회 - 검색
	public List<NoticeDTO> selectNoticeSearch(String keyword) {
		return sqlSession.selectList("AdminMapper.selectNoticeSearch", keyword);
	}
	
//	공지 상세 조회
	public NoticeDTO selectOneNotice(int noticeNum) {
		return sqlSession.selectOne("AdminMapper.selectOneNotice", noticeNum);
	}
	
//	해당 공지 삭제
	public void deleteNotice (int noticeNum) {
		sqlSession.delete("AdminMapper.deleteNotice", noticeNum);
	}
	
//	공지 등록
	public void insertNotice (NoticeDTO noticeDTO) {
		sqlSession.insert("AdminMapper.insertNotice", noticeDTO);
	}
	
}
