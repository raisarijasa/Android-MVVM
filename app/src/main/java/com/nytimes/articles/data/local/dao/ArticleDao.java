package com.nytimes.articles.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.nytimes.articles.data.local.entity.ArticleEntity;

import java.util.List;

/**
 * File Description
 * <p>
 * Author: Lajesh D
 * Email: lajeshds2007@gmail.com
 * Created: 7/24/2018
 * Modified: 7/24/2018
 */
@Dao
public interface ArticleDao {
    @Query("SELECT * FROM articles")
    LiveData<List<ArticleEntity>> loadPopularArticles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveArticles(List<ArticleEntity> articleEntities);

}
