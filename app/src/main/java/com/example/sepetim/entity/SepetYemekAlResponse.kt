package com.example.sepetim.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SepetYemekAlResponse (@SerializedName("sepet_yemekler")
                            @Expose
                            var sepet_yemekler:List<SepetYemekler>,
                            @SerializedName("success")
                            @Expose
                            var success:Int) : Serializable{
}