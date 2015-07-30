package cn.yunquan.frameworkdemo.model;

import android.text.TextUtils;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.mime.TypedString;

/**
 * Created by Administrator on 2015-07-28.
 */
@Table(name="post")
public class Post extends Model {

    /**
     * content : Sharp's post
     * id : 1
     * author : 2
     * comments_count : 0
     * update_time : 2015-07-28T05:53:15.078650Z
     * create_time : 2015-07-28T05:53:15.078610Z
     * images : []
     * is_removed : false
     * circle : 1
     * like : 0
     * is_liked : false
     */
    @Column(name="post_id", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    private int postId;
    @Column(name="content")
    private String content;
    @Column(name="author")
    private int author;
    @Column(name="comments_count")
    private int comments_count;
    @Column(name="update_time")
    private String update_time;
    @Column(name="create_time")
    private String create_time;
    @Column(name="images")
    private List<String> images;
    @Column(name="is_removed")
    private boolean is_removed;
    @Column(name="circle")
    private int circle;
    @Column(name="like")
    private int like;
    @Column(name="is_liked")
    private boolean is_liked;

    public void setContent(String content) {
        this.content = content;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void setIs_removed(boolean is_removed) {
        this.is_removed = is_removed;
    }

    public void setCircle(int circle) {
        this.circle = circle;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public void setIs_liked(boolean is_liked) {
        this.is_liked = is_liked;
    }

    public String getContent() {
        return content;
    }

    public int getPostId() {
        return postId;
    }

    public int getAuthor() {
        return author;
    }

    public int getComments_count() {
        return comments_count;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public String getCreate_time() {
        return create_time;
    }

    public List<?> getImages() {
        return images;
    }

    public boolean isIs_removed() {
        return is_removed;
    }

    public int getCircle() {
        return circle;
    }

    public int getLike() {
        return like;
    }

    public boolean isIs_liked() {
        return is_liked;
    }

    public Map<String, TypedString> toHashMap() {
        Map<String,TypedString> map = new HashMap<>();
        if (author > 0 ){
            map.put("author", new TypedString(String.valueOf(author)));
        }
        if (!TextUtils.isEmpty(this.content)){}{
            map.put("author", new TypedString(String.valueOf(this.content)));
        }
        // TODO 其他参数设置
        return map;
    }

}
