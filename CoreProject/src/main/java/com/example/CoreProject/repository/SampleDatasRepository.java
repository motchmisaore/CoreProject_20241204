package com.example.CoreProject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CoreProject.entity.SampleDatas;

public interface SampleDatasRepository extends JpaRepository<SampleDatas, Integer> {
	//タイトルか検索用IDで検索
	public Page<SampleDatas> findByColumns1LikeOrIdForSearchLike(String Columns1Keyword, String idNumber, Pageable pageable);
	//貸し出し可能のみ表示
	public Page<SampleDatas> findByStatusTrue(Pageable pageable);
	//貸し出し中のみ表示
	public Page<SampleDatas> findByStatusFalse(Pageable pageable);
	
	//貸し出し可否とタイトル検索を両方指定した場合
	public Page<SampleDatas> findByColumns1LikeOrIdForSearchLikeAndStatusTrue(String keyword, String idNumber, Pageable pageable);
	public Page<SampleDatas> findByColumns1LikeOrIdForSearchLikeAndStatusFalse(String keyword, String idNumber, Pageable pageable);
	
	/****************
	  20241120北島追加 
	******************/
	public Page<SampleDatas> findByColumns1Like(String keyword, Pageable pageable);
}
/****************************************
*
*****************************************/