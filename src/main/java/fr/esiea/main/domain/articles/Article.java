package fr.esiea.main.domain.articles;

import java.util.Date;

public class Article {

	private long creatorId;
	private long id;
	private String title;
	private String content;
	private Date creationDate;
	private Date lastModified;
	private long note;
	
	public Article() {}
	
	public Article(long idCreator, long id, String title, String content,
			Date dateCreation, Date lastModified, long note) {
		super();
		this.creatorId = idCreator;
		this.id = id;
		this.title = title;
		this.content = content;
		this.creationDate = dateCreation;
		this.lastModified = lastModified;
		this.note = note;
	}

	public long getIdCreator() {
		return creatorId;
	}

	public void setIdCreator(long idCreator) {
		this.creatorId = idCreator;
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

	public long getNote() {
		return note;
	}

	public void setNote(long note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Article [idCreator=" + creatorId + ", id=" + id + ", title="
				+ title + ", content=" + content + ", dateCreation="
				+ creationDate + ", lastModified=" + lastModified + "]";
	}

}
