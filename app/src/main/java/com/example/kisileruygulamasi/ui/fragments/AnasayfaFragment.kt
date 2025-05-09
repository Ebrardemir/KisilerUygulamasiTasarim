package com.example.kisileruygulamasi.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi.ui.adapter.KisilerAdapter


class AnasayfaFragment : Fragment() {

    private lateinit var binding:FragmentAnasayfaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)

        }

        val kisilerListesi =ArrayList<Kisiler>()
        val k1 = Kisiler(1,"ebrar","61")
        val k2 = Kisiler(2,"ebrar","61")
        val k3 = Kisiler(3,"ebrar","61")
        val k4 = Kisiler(4,"ebrar","61")
        val k5 = Kisiler(5,"ebrar","61")
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)
        kisilerListesi.add(k4)
        kisilerListesi.add(k5)

        val KisilerAdapter=KisilerAdapter(requireContext(),kisilerListesi)
        binding.kisilerRV.adapter=KisilerAdapter

        binding.kisilerRV.layoutManager=LinearLayoutManager(requireContext())


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean { //harf girdikçe ve sildikçe çalışır
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean { //ara butonuna basılınca
                ara(query)
                return true
            }
        })
        return binding.root
        }
    fun ara(aramaKelimesi : String){
        Log.e("kisi ara", aramaKelimesi)
    }
    override fun onResume(){ //anasayfaya geri döndürüldüğünde çalışan fonk
        super.onResume()
        Log.e("kişi anasayfaya","donuldu")
    }
}