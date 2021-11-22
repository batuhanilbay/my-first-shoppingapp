package com.example.sepetim.retrofit

import com.example.sepetim.entity.CRUDResponse
import com.example.sepetim.entity.SepetYemekAlResponse
import com.example.sepetim.entity.YemeklerResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface YemekDaoInterface {

    // http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    @GET("yemekler/tumYemekleriGetir.php")
    fun tumYemekler() : Call<YemeklerResponse>

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    fun yemekSil(@Field("sepet_yemek_id") sepet_yemek_id:Int,
                 @Field("kullanici_adi") kullanici_adi: String) : Call<CRUDResponse>


    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    fun sepetYemekGetir(@Field("kullanici_adi") kullanici_adi: String) : Call<SepetYemekAlResponse>


    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    fun yemekEkle(
                  @Field("yemek_adi") yemek_adi:String,
                  @Field("yemek_resim_adi") yemek_resim_adi:String,
                  @Field("yemek_fiyat") yemek_fiyat:Int,
                  @Field("yemek_siparis_adet") yemek_siparis_adet:Int,
                  @Field("kullanici_adi") kullanici_adi:String) : Call<SepetYemekAlResponse>


}