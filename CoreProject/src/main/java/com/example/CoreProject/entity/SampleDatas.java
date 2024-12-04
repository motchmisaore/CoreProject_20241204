package com.example.CoreProject.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.PrePersist;
import jakarta.persistence.PostPersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class SampleDatas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	//Integerだと、頭に0が付いたとき自動で消されてしまうので String型にすること
	@Column(name = "id_for_search")
	private String idForSearch;
	
	//@PrePersistをメソッドに付与すると、データベースに新しいEntityが挿入する際に自動で実行される動作になる
	//@PrePersist
	//20241122北島修正 書籍登録機能実装時。
	//@PrePsersistだと登録時ID番号がnullになってしまうため、データベースに保存された後に番号付与するようにした
	@PostPersist
	//自動で実行されるメソッド(generateIdForSearch:検索用の4桁IDを、主キーのIDを元に生成する)
	public void generateIdForSearch() {
		//idが4桁になるよう(idが1なら0001に整形)に整形し、idForSearchに代入
		this.idForSearch = String.format("%04d", id);
    }
	
	@Column(name = "columns1")
	private String columns1;
	
	@Column(name = "columns2")
	private String columns2;
	
	@Column(name = "columns3")
	private String columns3;
	
	@Column(name = "columns4")
	private String columns4;
	
	@Column(name = "columns5")
	private String columns5;
	
	@Column(name = "resistered_date", insertable = false, updatable = false)
	private Timestamp resisteredDate;
	
	@Column(name = "status")
	private Boolean status=true;
}
/****************************************
*
*****************************************/
