package com.prologger.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prologger.dto.Log

class MainViewModel : ViewModel() {
    private var _logs: MutableLiveData<ArrayList<Log>> = MutableLiveData<ArrayList<Log>>()

}