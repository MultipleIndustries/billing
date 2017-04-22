package  com.multiple.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.JoinColumn;

@Entity
@Audited
public class ImageMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long imageId;
	
	@Column(nullable = false,length = 75)
	private String imageName;
	
	@Column(unique = true, nullable = false,length = 100)
	private String imagePath;
	
	@Column(nullable = false,length = 75)
	private String extension;
	
	@Column(nullable = false,length = 75,name="size_")
	private long size;
	
	@Type(type= "org.hibernate.type.NumericBooleanType")
	@Column(nullable = false,name="active_")
	private boolean active=true;
	
	@Column(unique = true,nullable = true,length = 100)
	private String thumbImagePath;
	
	@CreatedDate
	private DateTime createdOn;
	
	@LastModifiedDate
	private DateTime lastModifiedOn;
	
	@JsonIgnore
	@CreatedBy
	@ManyToOne(fetch = FetchType.LAZY)
	private User createdBy;
	
	@JsonIgnore
	@LastModifiedBy
	@ManyToOne(fetch = FetchType.LAZY)
	private User lastModifiedBy;

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}


	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public DateTime getCreatedOn() {
		return createdOn;
	}
	
	public void setCreatedOn(DateTime createdOn) {
		this.createdOn = createdOn;
	}
	
	public DateTime getLastModifiedOn() {
		return lastModifiedOn;
	}
	
	public void setLastModifiedOn(DateTime lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}
	@JsonIgnore
	public User getCreatedBy() {
		return createdBy;
	}
	@JsonIgnore
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	@JsonIgnore
	public User getLastModifiedBy() {
		return lastModifiedBy;
	}
	@JsonIgnore
	public void setLastModifiedBy(User lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getThumbImagePath() {
		return thumbImagePath;
	}

	public void setThumbImagePath(String thumbImagePath) {
		this.thumbImagePath = thumbImagePath;
	}
	
}
