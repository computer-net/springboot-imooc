package com.imooc.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@ToString
public class DbStuBO {
    private String id;
    @NotBlank
    private String name;
    @NotNull
    private Integer sex;

    @Min(value = 1, message = "学生的年纪最小为一年级")
    @Max(value = 6)
    private Integer grade;

    @Range(min = 1, max = 18, message = "班级号范围为1~18")
    private Integer classroom;

    @Size(min = 2, max = 5, message = "学生的技能至少两个，至多五个")
    private List<String> skills;

    @Length(min = 5, max = 20, message = "学生的英文名长度区间为5~20")
    private String englishName;

    @Email(message = "邮箱格式不正确")
    private String email;
}