package ru.phoenixit.educationadarinapi.models;

import lombok.*;

import java.util.Date;

@Getter
@NoArgsConstructor
@Setter
@ToString
public class ModelResponse {

    private String id;

    private String name;

    private String comment;

    private Date createAt;

    private Date updateAt;

    private String creator;

    private String updater;
}
