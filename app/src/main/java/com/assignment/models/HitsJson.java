package com.assignment.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HitsJson{

	@SerializedName("hits")
	private List<HitsItem> hits;

	@SerializedName("hitsPerPage")
	private int hitsPerPage;

	@SerializedName("processingTimeMS")
	private int processingTimeMS;

	@SerializedName("query")
	private String query;

	@SerializedName("nbHits")
	private int nbHits;

	@SerializedName("page")
	private int page;

	@SerializedName("params")
	private String params;

	@SerializedName("nbPages")
	private int nbPages;

	@SerializedName("exhaustiveNbHits")
	private boolean exhaustiveNbHits;

	public void setHits(List<HitsItem> hits){
		this.hits = hits;
	}

	public List<HitsItem> getHits(){
		return hits;
	}

	public void setHitsPerPage(int hitsPerPage){
		this.hitsPerPage = hitsPerPage;
	}

	public int getHitsPerPage(){
		return hitsPerPage;
	}

	public void setProcessingTimeMS(int processingTimeMS){
		this.processingTimeMS = processingTimeMS;
	}

	public int getProcessingTimeMS(){
		return processingTimeMS;
	}

	public void setQuery(String query){
		this.query = query;
	}

	public String getQuery(){
		return query;
	}

	public void setNbHits(int nbHits){
		this.nbHits = nbHits;
	}

	public int getNbHits(){
		return nbHits;
	}

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setParams(String params){
		this.params = params;
	}

	public String getParams(){
		return params;
	}

	public void setNbPages(int nbPages){
		this.nbPages = nbPages;
	}

	public int getNbPages(){
		return nbPages;
	}

	public void setExhaustiveNbHits(boolean exhaustiveNbHits){
		this.exhaustiveNbHits = exhaustiveNbHits;
	}

	public boolean isExhaustiveNbHits(){
		return exhaustiveNbHits;
	}

	@Override
 	public String toString(){
		return 
			"HitsJson{" + 
			"hits = '" + hits + '\'' + 
			",hitsPerPage = '" + hitsPerPage + '\'' + 
			",processingTimeMS = '" + processingTimeMS + '\'' + 
			",query = '" + query + '\'' + 
			",nbHits = '" + nbHits + '\'' + 
			",page = '" + page + '\'' + 
			",params = '" + params + '\'' + 
			",nbPages = '" + nbPages + '\'' + 
			",exhaustiveNbHits = '" + exhaustiveNbHits + '\'' + 
			"}";
		}
}