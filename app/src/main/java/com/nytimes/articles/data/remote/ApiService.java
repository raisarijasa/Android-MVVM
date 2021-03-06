package com.nytimes.articles.data.remote;

import com.nytimes.articles.data.remote.model.PopularArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * The APIService interface which will contain the semantics of all the REST calls.
 * Author: Lajesh D
 * Email: lajeshds2007@gmail.com
 * Created: 7/24/2018
 * Modified: 7/24/2018
 */
public interface ApiService {
//    http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=FjGJqSf9YGAXXwdGGcBOipthLFMHjBur
//    http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/7.json?api_key=FjGJqSf9YGAXXwdGGcBOipthLFMHjBur
    @GET("svc/mostpopular/v2/mostviewed/all-sections/{index}.json")
    Call<PopularArticleResponse> loadPopularArticles(@Path("index") int index);
}
