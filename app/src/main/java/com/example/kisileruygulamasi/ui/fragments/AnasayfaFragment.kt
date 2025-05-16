package com.example.kisileruygulamasi.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi.ui.adapter.KisilerAdapter
import com.example.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasi.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
//fragment üzerinden de viewmodele erişmek istiyorum
class AnasayfaFragment : Fragment(){

    private lateinit var binding:FragmentAnasayfaBinding
    private lateinit var viewModel:AnasayfaViewModel //boş nesne daha sonra oluşturcam anlamında

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener {
            //Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
            Navigation.gecisYap(it,R.id.kisiKayitGecis) //yaptıgım şey uzun kodu bi yerde tanımlayıp her şeyde ordan erişmek

        }

        viewModel.kisilerListesi.observe(viewLifecycleOwner){ //dinleme kısmı!!
            val KisilerAdapter=KisilerAdapter(requireContext(),it,viewModel) //bizim listeyi veriyo
            binding.kisilerRV.adapter=KisilerAdapter
        }



        binding.kisilerRV.layoutManager=LinearLayoutManager(requireContext())


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean { //harf girdikçe ve sildikçe çalışır
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean { //ara butonuna basılınca
                viewModel.ara(query)
                return true
            }
        })
        return binding.root
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temViewModel:AnasayfaViewModel by viewModels()
        viewModel=temViewModel

    }

    override fun onResume(){ //anasayfaya geri döndürüldüğünde çalışan fonk, kisileriyukle()çalışmazsa kişiler gelmez kaydetme sasyfasından geri dönünce
        super.onResume()
        viewModel.kisileriYukle()
    }
}