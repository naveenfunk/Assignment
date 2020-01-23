package com.assignment.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class HitsItem{

	@SerializedName("comment_text")
	private Object commentText;

	@SerializedName("story_text")
	private Object storyText;

	@SerializedName("author")
	private String author;

	@SerializedName("story_id")
	private Object storyId;

	@SerializedName("_tags")
	private List<String> tags;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("created_at_i")
	private int createdAtI;

	@SerializedName("title")
	private String title;

	@SerializedName("url")
	private String url;

	@SerializedName("points")
	private int points;

	@SerializedName("_highlightResult")
	private HighlightResult highlightResult;

	@SerializedName("num_comments")
	private int numComments;

	@SerializedName("story_title")
	private Object storyTitle;

	@SerializedName("parent_id")
	private Object parentId;

	@SerializedName("story_url")
	private Object storyUrl;

	@SerializedName("objectID")
	private String objectID;

	private boolean isOn;

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean on) {
		isOn = on;
	}

	public void setCommentText(Object commentText){
		this.commentText = commentText;
	}

	public Object getCommentText(){
		return commentText;
	}

	public void setStoryText(Object storyText){
		this.storyText = storyText;
	}

	public Object getStoryText(){
		return storyText;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setStoryId(Object storyId){
		this.storyId = storyId;
	}

	public Object getStoryId(){
		return storyId;
	}

	public void setTags(List<String> tags){
		this.tags = tags;
	}

	public List<String> getTags(){
		return tags;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setCreatedAtI(int createdAtI){
		this.createdAtI = createdAtI;
	}

	public int getCreatedAtI(){
		return createdAtI;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setPoints(int points){
		this.points = points;
	}

	public int getPoints(){
		return points;
	}

	public void setHighlightResult(HighlightResult highlightResult){
		this.highlightResult = highlightResult;
	}

	public HighlightResult getHighlightResult(){
		return highlightResult;
	}

	public void setNumComments(int numComments){
		this.numComments = numComments;
	}

	public int getNumComments(){
		return numComments;
	}

	public void setStoryTitle(Object storyTitle){
		this.storyTitle = storyTitle;
	}

	public Object getStoryTitle(){
		return storyTitle;
	}

	public void setParentId(Object parentId){
		this.parentId = parentId;
	}

	public Object getParentId(){
		return parentId;
	}

	public void setStoryUrl(Object storyUrl){
		this.storyUrl = storyUrl;
	}

	public Object getStoryUrl(){
		return storyUrl;
	}

	public void setObjectID(String objectID){
		this.objectID = objectID;
	}

	public String getObjectID(){
		return objectID;
	}

	@Override
 	public String toString(){
		return 
			"HitsItem{" + 
			"comment_text = '" + commentText + '\'' + 
			",story_text = '" + storyText + '\'' + 
			",author = '" + author + '\'' + 
			",story_id = '" + storyId + '\'' + 
			",_tags = '" + tags + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",created_at_i = '" + createdAtI + '\'' + 
			",title = '" + title + '\'' + 
			",url = '" + url + '\'' + 
			",points = '" + points + '\'' + 
			",_highlightResult = '" + highlightResult + '\'' + 
			",num_comments = '" + numComments + '\'' + 
			",story_title = '" + storyTitle + '\'' + 
			",parent_id = '" + parentId + '\'' + 
			",story_url = '" + storyUrl + '\'' + 
			",objectID = '" + objectID + '\'' + 
			"}";
		}
}