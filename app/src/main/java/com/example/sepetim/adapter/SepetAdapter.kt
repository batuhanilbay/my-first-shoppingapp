package com.example.sepetim.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sepetim.databinding.CardSepetTasarimBinding
import com.example.sepetim.entity.SepetYemekler
import com.example.sepetim.viewmodel.SepetFragmentViewModel
import com.squareup.picasso.Picasso

class SepetAdapter (var mContext: Context,var viewModel : SepetFragmentViewModel, var sepetYemekListe :List<SepetYemekler>) : RecyclerView.Adapter<SepetAdapter.CardTasarimTut> (){



    inner class CardTasarimTut(var cardSepetTasarimBinding: CardSepetTasarimBinding)
        : RecyclerView.ViewHolder(cardSepetTasarimBinding.root){

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTut {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardSepetTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTut(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTut, position: Int) {
        val yemekler = sepetYemekListe.get(position)
        val temp = holder.cardSepetTasarimBinding
        temp.sepetNesnesi = yemekler


        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${yemekler.yemek_resim_adi}"
        Picasso.get().load(url).into(temp.imageViewSepetResim)

        temp.imageView3.setOnClickListener{

                viewModel.yemekSil(yemekler.sepet_yemek_id,yemekler.kullanici_adi)

        }
    }

    override fun getItemCount(): Int {
        return sepetYemekListe.size
    }
}
