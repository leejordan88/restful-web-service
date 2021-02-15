package com.example.restfulwebservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;

    @Size(min = 2, max = 50, message = "name은 2이상 50 이하로 입력하여 주세요.")
    private String name;

    @Past
    private Date joinDate;
}
