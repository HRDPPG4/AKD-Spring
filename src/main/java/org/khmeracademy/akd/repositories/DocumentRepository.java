package org.khmeracademy.akd.repositories;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.akd.entities.Category;
import org.khmeracademy.akd.entities.Comment;
import org.khmeracademy.akd.entities.Document;
import org.khmeracademy.akd.entities.User;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;

@Repository
public interface DocumentRepository {
	
	@Delete("DELETE FROM akd_documents WHERE doc_id=#{docID}")
	boolean delete(String id);
	@Update("UPDATE akd_documents SET title=#{title},des=#{des},embed_link=#{embedLink},thumbnail_url=#{thumbnailURL},export_link=#{exportLink},view=#{view},share=#{share},created_date=#{createdDate},doc_type_num=#{docTypeNum},user_id=#{userID},cat_id=#{catID},status=#{status} WHERE doc_id=#{docID}")
	boolean update(Document doc);
	
	@Insert("INSERT INTO akd_documents VALUES(#{docID},#{title},#{des},#{embedLink},#{thumbnailURL},#{exportLink},#{view},#{share},#{createdDate},#{docTypeNum},#{userID},#{catID},#{status})")
	boolean insert(Document doc);
	
	
	/*@Select("SELECT * from akd_documents")
	@Results({
		@Result(property="docID", column="doc_id"),
		@Result(property="title", column="title"),
		@Result(property="des", column="des"),
		@Result(property="embedLink", column="embed_link"),
		@Result(property="thumbnailURL", column="thumbnail_url"),
		@Result(property="exportLink", column="export_link"),
		@Result(property="view", column="view"),
		@Result(property="share", column="share"),		
		@Result(property="createdDate", column="created_date"),
		@Result(property="docTypeNum", column="doc_type_num"),
		@Result(property="userID", column="user_id"),
		@Result(property="catID", column="cat_id"),
		@Result(property="status", column="status")		
	})
	ArrayList<Document> findAll();*/
	
	@Select("SELECT * from akd_documents WHERE cat_id=#{catID}")
	@Results({
		@Result(property="docID", column="doc_id"),
		@Result(property="title", column="title"),
		@Result(property="des", column="des"),
		@Result(property="embedLink", column="embed_link"),
		@Result(property="thumbnailURL", column="thumbnail_url"),
		@Result(property="exportLink", column="export_link"),
		@Result(property="view", column="view"),
		@Result(property="share", column="share"),		
		@Result(property="createdDate", column="created_date"),
		@Result(property="docTypeNum", column="doc_type_num"),
		@Result(property="userID", column="user_id"),
		@Result(property="catID", column="cat_id"),
		@Result(property="status", column="status")		
	})
	ArrayList<Document> getDocumentByCatID(String CatID);
	
	@Select("SELECT * from akd_documents WHERE doc_id=#{docID}")
	@Results({
		@Result(property="docID", column="doc_id"),
		@Result(property="title", column="title"),
		@Result(property="des", column="des"),
		@Result(property="embedLink", column="embed_link"),
		@Result(property="thumbnailURL", column="thumbnail_url"),
		@Result(property="exportLink", column="export_link"),
		@Result(property="view", column="view"),
		@Result(property="share", column="share"),		
		@Result(property="createdDate", column="created_date"),
		@Result(property="docTypeNum", column="doc_type_num"),
		@Result(property="userID", column="user_id"),
		@Result(property="catID", column="cat_id"),
		@Result(property="status", column="status")	
	})
	Document findOne(String id);
	
	@Select("SELECT * from akd_documents")
	@Results({
		@Result(property="docID", column="doc_id"),
		@Result(property="title", column="title"),
		@Result(property="des", column="des"),
		@Result(property="embedLink", column="embed_link"),
		@Result(property="thumbnailURL", column="thumbnail_url"),
		@Result(property="exportLink", column="export_link"),
		@Result(property="view", column="view"),
		@Result(property="share", column="share"),		
		@Result(property="createdDate", column="created_date"),
		@Result(property="docTypeNum", column="doc_type_num"),
		@Result(property="userID", column="user_id"),
		@Result(property="catID", column="cat_id"),
		@Result(property="status", column="status"),
		@Result(property="users", column="user_id", one = @One(select = "getUser")),
		@Result(property="category", column="cat_id", one = @One(select = "getCategory"))		
	})
	ArrayList<Document> getDocumentAndUserAndCategory();
	
	@Select("SELECT * from akd_documents")
	@Results({
		@Result(property="docID", column="doc_id"),
		@Result(property="title", column="title"),
		@Result(property="des", column="des"),
		@Result(property="embedLink", column="embed_link"),
		@Result(property="thumbnailURL", column="thumbnail_url"),
		@Result(property="exportLink", column="export_link"),
		@Result(property="view", column="view"),
		@Result(property="share", column="share"),		
		@Result(property="createdDate", column="created_date"),
		@Result(property="docTypeNum", column="doc_type_num"),
		@Result(property="userID", column="user_id"),
		@Result(property="catID", column="cat_id"),
		@Result(property="status", column="status"),
		@Result(property="users", column="user_id", one = @One(select = "getUser")),
		@Result(property="category", column="cat_id", one = @One(select = "getCategory")),
		@Result(property="comment", column="doc_id", many = @Many(select = "getComments"))
	})
	ArrayList<Document> getDocumentAndUserAndCategoryAndComment();
	
	@Select("SELECT * FROM akd_users WHERE user_id=#{userID}")
	@Results({
		@Result(property="userID", column="user_id"),
		@Result(property="name", column="name"),
		@Result(property="password", column="password"),
		@Result(property="email", column="email"),
		@Result(property="phone", column="phone"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="remark", column="remark"),
		@Result(property="status", column="status"),		
		@Result(property="role", column="role")		
	})
	ArrayList<User> getUser();
	
	@Select("SELECT * FROM akd_categories WHERE cat_id=#{catID}")
	@Results({
		@Result(property="catID", column="cat_id"),
		@Result(property="catName", column="name"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="remark", column="remark"),
		@Result(property="parentID", column="parent_id"),
		@Result(property="status", column="status"),
		@Result(property="icon", column="icon")
	})
	ArrayList<Category>getCategory();
	
	@Select("SELECT * from akd_comments WHERE doc_id=#{docID}")
	@Results({
		@Result(property="commentID", column="comment_id"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="remark", column="remark"),
		@Result(property="userID", column="user_id"),
		@Result(property="docID", column="doc_id"),
		@Result(property="status", column="status")
			
	})
	ArrayList<Comment>getComments();
	
}

