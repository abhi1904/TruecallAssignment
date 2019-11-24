package com.truecaller.assignment.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.truecaller.assignment.Utility;
import com.truecaller.assignment.services.repository.TruecallerRepository;

public class TrueCallerViewModel extends AndroidViewModel {
    private MutableLiveData<StringBuilder> truecaller10thCharacterRequestLiveData;
    private MutableLiveData<StringBuilder> truecallerEvery10thCharacterRequestLiveData;
    private MutableLiveData<StringBuilder> truecallerWordCounterRequestLiveData;
    private TruecallerRepository truecallerRepository;
    private Application application;
    private Utility utility;

    public TrueCallerViewModel(@NonNull Application application) {

        super(application);
        this.application = application;
    }


    public void init() {
        if (truecaller10thCharacterRequestLiveData != null&&truecallerEvery10thCharacterRequestLiveData != null&&truecallerWordCounterRequestLiveData != null) {
            return;
        }
        truecallerRepository = TruecallerRepository.getInstance(application);
        utility = new Utility();
    }


    public MutableLiveData<StringBuilder> getTruecaller10thCharacterRequest() {
        truecaller10thCharacterRequestLiveData = truecallerRepository.getTCWebPage();


        return truecaller10thCharacterRequestLiveData;
    }

    public MutableLiveData<StringBuilder> getTruecallerEvery10thCharacterRequest() {
        truecallerEvery10thCharacterRequestLiveData = truecallerRepository.getTCWebPage();

        return truecallerEvery10thCharacterRequestLiveData;
    }
    public MutableLiveData<StringBuilder> getTruecallerWordCounterRequest() {
        truecallerWordCounterRequestLiveData = truecallerRepository.getTCWebPage();

        return truecallerWordCounterRequestLiveData;
    }

}