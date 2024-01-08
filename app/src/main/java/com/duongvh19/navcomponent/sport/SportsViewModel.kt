package com.duongvh19.navcomponent.sport

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.duongvh19.navcomponent.data.SportsData
import com.duongvh19.navcomponent.model.Sport

class SportsViewModel : ViewModel() {

    private var _currentSport = MutableLiveData<Sport>()
    val currentSport : LiveData<Sport>
        get() = _currentSport

    private var _sportsData : ArrayList<Sport> = ArrayList()
    val sportsData : ArrayList<Sport>
        get() = _sportsData

    init {
        _sportsData = SportsData.getSportsData()
        _currentSport.value = _sportsData[0]
    }

    fun updateCurrentSport(sport : Sport) {
        _currentSport.value = sport
    }
}