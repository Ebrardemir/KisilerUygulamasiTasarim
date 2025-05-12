package com.example.kisileruygulamasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//butun viewmodellerde repository e erişmemiz lazım
class AnasayfaViewModel:ViewModel() {
    var kisilerRepository=KisilerRepository()
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        kisileriYukle()
    }

    fun sil(kisi_Id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepository.sil(kisi_Id)
            kisileriYukle()
        }
    }

    fun kisileriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value=kisilerRepository.kisileriYukle() //tetikleme,dinlediğimiz-gözlemlediğimiz yere veri iletmek anlamında
        }
    }

    fun ara(aramaKelimesi:String){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value=kisilerRepository.ara(aramaKelimesi)
        }
    }


}
