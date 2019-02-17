package bloglaptrinh.com.web.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

import bloglaptrinh.com.common.utils.StringUtil;
import bloglaptrinh.com.domain.Post;
import org.springframework.core.convert.converter.Converter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateForm implements Converter<PostCreateForm, Post> {

    @NotBlank(message = "Tiêu đề bài viết không được để trống!")
    private String title;

    private String language;

    private String status;

    private String views;

    private String createdAt;

    private String updatedAt;

    @NotBlank(message = "Nội dung bài viết không được để trống!")
    private String body;

    public enum Status {
        DRAFT, SCHEDULED, PUBLISHED
    }

    @Override
    public Post convert(PostCreateForm postCreateForm) {
        return new Post(getTitle(), getLanguage(), Post.Status.PUBLISHED,StringUtil.covertStringToURL(getTitle()), Long.valueOf(getViews()), getCreatedAt(), getUpdatedAt(), getBody());
    }
}
