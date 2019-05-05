package com.hsj.servier;

import com.hsj.bean.GetBlog;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 黄仕杰 on 2019/5/3.
 */
@Service
public interface IGetservier {
    /**
     * <p>添加博客<p/>
     * @param getBlog
     */
    void add(GetBlog getBlog);

    /**
     * <p>更新，这里的只是更新标题<p/>
     * @param getBlog
     */
    void updata(GetBlog getBlog);

    /**
     * <p>删除，全部删除<p/>
     * @param getBlog
     */
    void delete(GetBlog getBlog);

    /**
     * <p>全部查出来<p/>
     * @param author
     * @return
     */
    List<GetBlog> select(String author);
}
