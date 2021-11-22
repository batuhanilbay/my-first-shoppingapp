package com.example.sepetim.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sepetim.R
import com.example.sepetim.adapter.SepetAdapter
import com.example.sepetim.databinding.FragmentSepetBinding
import com.example.sepetim.entity.SepetYemekler
import com.example.sepetim.viewmodel.SepetFragmentViewModel



class SepetFragment : Fragment() {

    private lateinit var tasarim : FragmentSepetBinding
    private val viewModel : SepetFragmentViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_sepet,container,false)
        return tasarim.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeLiveData()

    }
    private fun observeLiveData(){
        viewModel.yemekleriGetir()
        viewModel.yemeklerListesi.observe(viewLifecycleOwner,{

            tasarim.rvSepet.apply {
                layoutManager = LinearLayoutManager(requireContext())
            }
            tasarim.rvSepet.adapter = SepetAdapter(requireContext(),viewModel,it)
            topla(it)
        })

    }
    private fun initView(){
        tasarim.sepetBaslik = "SEPETİM"
    }

    fun topla(sepetYemekListe:List<SepetYemekler>){
        var toplam = 0
        for(i in sepetYemekListe){
            toplam += (i.yemek_fiyat * i.yemek_siparis_adet)
        }
        tasarim.totalFiyat.text = "Toplam: " + toplam.toString() + "₺"

    }










}