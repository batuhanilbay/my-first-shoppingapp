package com.example.sepetim.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sepetim.entity.Yemekler
import com.example.sepetim.repo.YemeklerDaoRepository

class MenuFragmentViewModel : ViewModel(){

    var yemeklerListesi = MutableLiveData<List<Yemekler>>()
    private val ydaor = YemeklerDaoRepository()


    init {
        yemekYukle()
        yemeklerListesi = ydaor.yemekleriGetir()
    }

    fun yemekYukle(){
        ydaor.tumYemekleriAl()
    }

}