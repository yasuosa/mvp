package admin.com.example.administrator.mvp.http;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public class RetrofigFactory {

    private static RetrofigFactory factory;
    private Retrofit retrofit;
    private static final String BASE_URl="https://www.wanandroid.com/";


    private RetrofigFactory(){
        init();
    }

    private void init() {
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public synchronized static RetrofigFactory getInstance(){
        if(factory==null){
            factory=new RetrofigFactory();
        }
        return factory;
    }

    public ApiService api(){
        return retrofit.create(ApiService.class);
    }
}
