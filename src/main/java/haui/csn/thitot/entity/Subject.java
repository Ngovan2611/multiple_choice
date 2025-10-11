package haui.csn.thitot.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;

    @Column(name = "subject_name")
    private String subjectName;

    private String description;

    private String imageUrl;

    @Column(name = "created_by")
    private int createdBy;

    @Column(name = "created_at")
    private Date createdAt;

    // Getter & Setter
    public int getSubjectId() {
        return subjectId;
    }
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

