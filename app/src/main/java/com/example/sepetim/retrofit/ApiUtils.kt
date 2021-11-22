package com.example.sepetim.retrofit

class ApiUtils {

    companion object{

        //  http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
        private val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getYemekDaoInterface() : YemekDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(YemekDaoInterface::class.java)

        }

    }


}