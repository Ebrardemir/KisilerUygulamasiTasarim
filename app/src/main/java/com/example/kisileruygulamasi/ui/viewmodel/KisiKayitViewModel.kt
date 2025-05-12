package com.example.kisileruygulamasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class KisiKayitViewModel:ViewModel() {
    var kisilerRepository= KisilerRepository()

    fun kaydet(kisi_ad:String , kisi_tel:String){ //arayüzle çalışma yapcaksak suspendi kaldırıyoz,suspend hatası vermesin diye de aşapıdaki kodu yazıyoz
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepository.kaydet(kisi_ad,kisi_tel)
        }//main arayüze yakın oln işlemlerde, IO veritbanına yakın işlemlerde kulalnılıyor
    }
}