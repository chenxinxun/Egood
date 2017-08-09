package com.tapcash.egood.base;

import android.support.compat.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求
 */
public class RetrofitService {

    /**单例*/
    private static RetrofitService Instance = null;

    /**
     * 获取单例
     *
     * @return RetrofitService
     */
    public static RetrofitService getInstance() {
        if (Instance == null) {
            Instance = new RetrofitService();
        }

        return Instance;
    }

    private String Tag = RetrofitService.class.getSimpleName();
    private OkHttpClient okHttpClient;
    private Retrofit retrofit;

    private RetrofitService() {
        //debug 模式
        if (BuildConfig.DEBUG) {
            okHttpClient = new OkHttpClient();
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient = new OkHttpClient.Builder().addInterceptor(logging).build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(UrlConstant.ITE_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        } else {
            okHttpClient = new OkHttpClient();
            retrofit = new Retrofit.Builder()
                    .baseUrl(UrlConstant.ITE_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
    }

    public <T> T createApi(Class<T> clazz) {
        return retrofit.create(clazz);
    }

}
