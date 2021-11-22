package com.example.sepetim.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.sepetim.R
import com.example.sepetim.databinding.FragmentAnaSayfaBinding


class AnaSayfaFragment : Fragment() {

    //Tasarim için DataBinding
    private lateinit var tasarim:FragmentAnaSayfaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_ana_sayfa, container, false)

        //DataBinding ile Görsel Nesne Üzerinde TextView Erişim
        tasarim.anaSayfaToolbarBaslik="SEPETİM"
        tasarim.goToMenu = "GO"

        buttonGecis()

        return tasarim.root
    }

    fun buttonGecis() {
        tasarim.buttonAnaSayfa.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.menuGecis)
        }
    }

}