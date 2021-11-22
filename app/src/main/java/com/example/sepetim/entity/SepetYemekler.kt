package com.example.sepetim.entity

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SepetYemekler(@SerializedName("sepet_yemek_id")@Expose var sepet_yemek_id:Int,
                         @SerializedName("yemek_adi")@Expose var yemek_adi:String,
                         @SerializedName("yemek_resim_adi")@Expose var yemek_resim_adi:String,
                         @SerializedName("yemek_fiyat")@Expose var yemek_fiyat:Int,
                         @SerializedName("yemek_siparis_adet")@Expose var yemek_siparis_adet:Int,
                         @SerializedName("kullanici_adi")@Expose var kullanici_adi:String) : Serializable{

                         }

    @BindingAdapter("intToString")
    fun intToString(view: TextView, text: Int) {
    view.setText(text.toString() + " Adet")

    }

    @BindingAdapter("adet","fiyat")
    fun sumFiyat(view: TextView, adet: Int,fiyat:Int) {
    var sum=adet*fiyat
    view.setText(sum.toString() + " ₺")

    }




