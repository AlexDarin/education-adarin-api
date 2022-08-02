package ru.phoenixit.educationadarinapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Document(collection = "model")
@Getter
@NoArgsConstructor
@Setter
public class Model {

    @Id
    private String id;

    private String name;

    private String comment;

    @CreatedDate
    private Date createAt;

    @LastModifiedDate
    private Date updateAt;

    @CreatedBy
    private String creator;

    @LastModifiedBy
    private String updater;
}
