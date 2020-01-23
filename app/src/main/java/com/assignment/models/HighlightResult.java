package com.assignment.models;

import com.google.gson.annotations.SerializedName;

public class HighlightResult{

	@SerializedName("author")
	private Author author;

	@SerializedName("title")
	private Title title;

	@SerializedName("url")
	private Url url;

	public void setAuthor(Author author){
		this.author = author;
	}

	public Author getAuthor(){
		return author;
	}

	public void setTitle(Title title){
		this.title = title;
	}

	public Title getTitle(){
		return title;
	}

	public void setUrl(Url url){
		this.url = url;
	}

	public Url getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"HighlightResult{" + 
			"author = '" + author + '\'' + 
			",title = '" + title + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}