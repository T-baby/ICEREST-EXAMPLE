package com.cybermkd.component;

import com.cybermkd.kit.MongoValidate;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 创建人:T-baby
 * 创建日期: 16/8/11
 * 文件描述:
 */
public class ItemBean extends MongoValidate {

    @NotNull(message = "content can't be empty")
    @NotBlank(message = "content can't be empty")
    @Length(min = 1, max = 120, message = "content is too long or too short")
    private String content;

    private String creat_time;

    @NotNull(message = "id can't be empty")
    @NotBlank(message = "id can't be empty")
    private String id;

    public String getContent() {
        return content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(String creat_time) {
        this.creat_time = creat_time;
    }
}
