package com.example.sepetim.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SepetYemekSilBody (@SerializedName("sepet_yemek_id")
                              @Expose
                              var sepet_yemek_id:Int,
                              @SerializedName("kullanici_adi")
                              @Expose
                              var kullanici_adi:String) : Serializable {
}