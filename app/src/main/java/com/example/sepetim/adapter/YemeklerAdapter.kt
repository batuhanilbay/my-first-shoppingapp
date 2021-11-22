package com.example.sepetim.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.sepetim.databinding.CardTasarimBinding
import com.example.sepetim.entity.Yemekler
import com.example.sepetim.fragment.MenuFragmentDirections
import com.squareup.picasso.Picasso

class YemeklerAdapter (var mContext: Context, var yemeklerListesi:List<Yemekler>) : RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu> (){



    inner class CardTasarimTutucu(var cardTasarimBinding: CardTasarimBinding)
        : RecyclerView.ViewHolder(cardTasarimBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemekler = yemeklerListesi.get(position)
        val temp = holder.cardTasarimBinding
        temp.yemekNesnesi= yemekler

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${yemekler.yemek_resim_adi}"
        Picasso.get().load(url).into(temp.imageViewYemek)

        temp.cardViewUrun.setOnClickListener {
            val gecis = MenuFragmentDirections.detayGecis(yemekler)
            Navigation.findNavController(it).navigate(gecis)

        }


    }

    override fun getItemCount(): Int {
        return yemeklerListesi.size
    }
}

