package in.rrapps.mvpdaggertesting.api;

import in.rrapps.mvpdaggertesting.models.response.ResultEntity;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService
{

   /* @GET("discover/movie")
    Observable<DiscoverResponse> getMoviesList(@QueryMap Map<String, Object> params);*/

    @GET("https://stark-spire-93433.herokuapp.com/json")
    Observable<ResultEntity> getCategoryAndProductDetails();


}
