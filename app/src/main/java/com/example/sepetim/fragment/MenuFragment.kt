package com.example.sepetim.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.sepetim.R
import com.example.sepetim.adapter.YemeklerAdapter
import com.example.sepetim.databinding.FragmentMenuBinding
import com.example.sepetim.viewmodel.MenuFragmentViewModel



class MenuFragment : Fragment() {

    private lateinit var tasarim:FragmentMenuBinding
    private lateinit var adapter: YemeklerAdapter
    //private lateinit var yemeklerListesi:ArrayList<Yemekler>

    //ViewModel Bağlantı
    private lateinit var viewModel:MenuFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        tasarim =DataBindingUtil.inflate(inflater,R.layout.fragment_menu,container,false)
        tasarim.menuToolbarBaslik ="Selam, Batuhan !"
        tasarim.hosgeldinizBaslik="HOŞGELDİNİZ"
        tasarim.urunlerBaslik ="ÜRÜNLER"
        tasarim.menuFragment=this



       viewModel.yemekYukle()

        viewModel.yemeklerListesi.observe(viewLifecycleOwner,{yemeklerListesi ->
            adapter = YemeklerAdapter(tasarim.root.context,yemeklerListesi)
            tasarim.yemeklerAdapter = adapter


        })
        return tasarim.root
    }

   fun buttonTikla(v:View){
        Navigation.findNavController(v).navigate(R.id.sepetGecis)
    }



    //Fragment ViewModel yapısını bağlama
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : MenuFragmentViewModel by viewModels()
        this.viewModel = tempViewModel
    }


    override fun onResume() {
        super.onResume()
        viewModel.yemekYukle()
    }

}