package com.nytimes.articles.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.nytimes.articles.data.local.ArticleDatabase;
import com.nytimes.articles.data.local.entity.ArticleEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;


@RunWith(AndroidJUnit4.class)
public class ArticleDaosTest {

    private ArticleDatabase articleDatabase;

    @Before
    public void init(){
        articleDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().getContext(), ArticleDatabase.class).build();
    }

    @After
    public void uninit(){
        articleDatabase.close();
    }
    @Test
    public void testLoadPopularArticles(){
        List<ArticleEntity> articleEntities = new ArrayList<>();
        ArticleEntity entity = new ArticleEntity();
        entity.setId(1000);
        entity.setTitle("test");
        entity.setAuthors("test");
        entity.setPublishedDate("test");
        entity.setUrl("test");
        articleEntities.add(entity);
        articleDatabase.articleDao().saveArticles(articleEntities);
        LiveData<List<ArticleEntity>> articlesList =  articleDatabase.articleDao().loadPopularArticles();
        assertNotNull(articlesList);
    }

}
