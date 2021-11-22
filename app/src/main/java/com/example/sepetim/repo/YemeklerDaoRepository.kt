package com.example.sepetim.repo

import androidx.lifecycle.MutableLiveData
import com.example.sepetim.entity.*
import com.example.sepetim.retrofit.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YemeklerDaoRepository {

    private val yemeklerListesi:MutableLiveData<List<Yemekler>> = MutableLiveData()
    val yemeklerDaoInterface = ApiUtils.getYemekDaoInterface()

    fun yemekleriGetir() : MutableLiveData<List<Yemekler>>{
        return yemeklerListesi
    }

    fun tumYemekleriAl(){
        yemeklerDaoInterface.tumYemekler().enqueue(object : Callback<YemeklerResponse>{
            override fun onResponse(
                call: Call<YemeklerResponse>,
                response: Response<YemeklerResponse>) {
                val liste = response.body().yemekler
                yemeklerListesi.value = liste
            }

            override fun onFailure(call: Call<YemeklerResponse>, t: Throwable) {}
        })

    }

    fun yemekEkle(yemek_adi:String,
                   yemek_resim_adi:String,
                   yemek_fiyat:Int,
                   yemek_siparis_adet:Int,
                   kullanici_adi:String){

        yemeklerDaoInterface.yemekEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
            .enqueue(object : Callback<SepetYemekAlResponse>{
                override fun onResponse(call: Call<SepetYemekAlResponse>, response: Response<SepetYemekAlResponse>) {}
                override fun onFailure(call: Call<SepetYemekAlResponse>?, t: Throwable?) {}
            })

    }


}