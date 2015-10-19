package fr.esiea.main.domain.articles;

import java.util.Date;

public class Coment {

	private long authorId;
	private long articleId;
	private long id;
	private String content;
	private Date creationDate;
	
	public Coment(){}

	public Coment(long authorId, long articleId, long id, String content,
			Date creationDate) {
		super();
		this.authorId = authorId;
		this.articleId = articleId;
		this.id = id;
		this.content = content;
		this.creationDate = creationDate;
	}

	public long getCreatorId() {
		return authorId;
	}

	public void setCreatorId(long creatorId) {
		this.authorId = creatorId;
	}

	public long getArticleId() {
		return articleId;
	}

	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Coment [creatorId=" + authorId + ", articleId=" + articleId
				+ ", id=" + id + ", content=" + content + ", creationDate="
				+ creationDate + "]";
	}
	
}
