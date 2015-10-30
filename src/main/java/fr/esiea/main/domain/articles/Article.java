package fr.esiea.main.domain.articles;

import java.util.Date;

public class Article {

	private long authorId;
	private String authorName;
	private long id;
	private String title;
	private String content;
	private Date creationDate;
	private Date lastModified;
	
	public Article() {}
	
	public Article(long idCreator,String authorName, long id, String title, String content,
			Date dateCreation, Date lastModified) {
		super();
		this.authorId = idCreator;
		this.authorName = authorName;
		this.id = id;
		this.title = title;
		this.content = content;
		this.creationDate = dateCreation;
		this.lastModified = lastModified;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long idCreator) {
		this.authorId = idCreator;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDateCreation() {
		return creationDate;
	}

	public void setDateCreation(Date dateCreation) {
		this.creationDate = dateCreation;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "Article [idCreator=" + authorId + ", id=" + id + ", title="
				+ title + ", content=" + content + ", dateCreation="
				+ creationDate + ", lastModified=" + lastModified + "]";
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}
