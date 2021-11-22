package com.example.sepetim.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.sepetim.R
import com.example.sepetim.databinding.FragmentDetayBinding
import com.example.sepetim.entity.Yemekler
import com.example.sepetim.viewmodel.DetayFragmentViewModel
import com.squareup.picasso.Picasso
import java.lang.Exception


class DetayFragment : Fragment() {

    private lateinit var tasarim : FragmentDetayBinding
    private lateinit var viewModel:DetayFragmentViewModel
    private lateinit var gelenYemek:Yemekler

    private var adet=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_detay,container,false)


        tasarim.detayFragment = this
        val bundle: DetayFragmentArgs by navArgs()
        gelenYemek = bundle.nesne
        tasarim.yemekDetayToolbarBaslik = "DETAYLAR"
        tasarim.yemekDetayNesnesi = gelenYemek
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${gelenYemek.yemek_resim_adi}"
        Picasso.get().load(url).into(tasarim.imageView4)


        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:DetayFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonSepeteEkle(){
        try {
            //var yemekadi=gelenYemek.yemek_adi
            viewModel.ekle(
                //gelenYemek.yemek_id.toInt(),
                gelenYemek.yemek_adi,
                gelenYemek.yemek_resim_adi,
                gelenYemek.yemek_fiyat.toInt(),
                adet
            )
            val action = DetayFragmentDirections.detaySepetGecis()
            Navigation.findNavController(tasarim.root).navigate(action)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }



    fun adetArttir(){
        adet++
        tasarim.textViewAdet.text = adet.toString()

    }
    fun adetEksilt(){
        if(adet>0){
            adet--
        }
        tasarim.textViewAdet.text = adet.toString()
    }







}


