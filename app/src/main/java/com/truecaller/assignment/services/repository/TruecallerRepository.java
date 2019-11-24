package com.truecaller.assignment.services.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.truecaller.assignment.services.RetrofitClientInstance;
import com.truecaller.assignment.services.TruecallerApi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TruecallerRepository {
    private static TruecallerRepository truecallerRepository;
    private TruecallerApi truecallerApi;
    private Application application;


    public TruecallerRepository(Application application) {
        this.application = application;
        truecallerApi = RetrofitClientInstance.getRetrofitInstance().create(TruecallerApi.class);
    }


    public static TruecallerRepository getInstance(Application application) {
        if (truecallerRepository == null) {
            truecallerRepository = new TruecallerRepository(application);
        }
        return truecallerRepository;
    }


    public MutableLiveData<StringBuilder> getTCWebPage() {
        final MutableLiveData<StringBuilder> data = new MutableLiveData<>();

        truecallerApi.getTCWebPage().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Document doc = Jsoup.parse(response.body());
                String replacedTags = doc.text().replaceAll("\\<.*?\\>", "");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(replacedTags);

                data.setValue(stringBuilder);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                data.setValue(null);
            }
        });


        return data;
    }


}