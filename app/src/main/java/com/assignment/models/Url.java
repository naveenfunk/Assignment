package com.assignment.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Url{

	@SerializedName("matchLevel")
	private String matchLevel;

	@SerializedName("value")
	private String value;

	@SerializedName("matchedWords")
	private List<Object> matchedWords;

	public void setMatchLevel(String matchLevel){
		this.matchLevel = matchLevel;
	}

	public String getMatchLevel(){
		return matchLevel;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	public void setMatchedWords(List<Object> matchedWords){
		this.matchedWords = matchedWords;
	}

	public List<Object> getMatchedWords(){
		return matchedWords;
	}

	@Override
 	public String toString(){
		return 
			"Url{" + 
			"matchLevel = '" + matchLevel + '\'' + 
			",value = '" + value + '\'' + 
			",matchedWords = '" + matchedWords + '\'' + 
			"}";
		}
}