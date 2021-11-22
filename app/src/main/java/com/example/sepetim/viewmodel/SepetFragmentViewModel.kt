package com.example.sepetim.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sepetim.entity.CRUDResponse
import com.example.sepetim.entity.SepetYemekAlResponse
import com.example.sepetim.entity.SepetYemekler
import com.example.sepetim.repo.YemeklerDaoRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SepetFragmentViewModel: ViewModel() {

    var yemeklerListesi = MutableLiveData<List<SepetYemekler>>()
    val ydaor = YemeklerDaoRepository()


    fun yemekleriGetir(){

        ydaor.yemeklerDaoInterface.sepetYemekGetir("batuhanilbay").enqueue(object :
            Callback<SepetYemekAlResponse> {
            override fun onResponse(
                call: Call<SepetYemekAlResponse>,
                response: Response<SepetYemekAlResponse>
            ) {
                yemeklerListesi.value = response.body().sepet_yemekler }

            override fun onFailure(call: Call<SepetYemekAlResponse>?, t: Throwable?) {

            }
        })
    }

    fun yemekSil(sepet_yemek_id:Int,kullanici_adi:String){
        ydaor.yemeklerDaoInterface.yemekSil(sepet_yemek_id,kullanici_adi).enqueue(object : Callback<CRUDResponse>{
            override fun onResponse(call: Call<CRUDResponse>, response: Response<CRUDResponse>) {
                yemekleriGetir()

            }
            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {}
        })
    }





}