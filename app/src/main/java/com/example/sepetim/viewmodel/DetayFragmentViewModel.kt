package com.example.sepetim.viewmodel

import androidx.lifecycle.ViewModel
import com.example.sepetim.repo.YemeklerDaoRepository

class DetayFragmentViewModel : ViewModel() {

    private val ydaor = YemeklerDaoRepository()


    fun ekle(yemek_adi: String, yemek_resim_adi: String, yemek_fiyat: Int, yemek_siparis_adet: Int){

        ydaor.yemekEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,"batuhanilbay")

    }




}