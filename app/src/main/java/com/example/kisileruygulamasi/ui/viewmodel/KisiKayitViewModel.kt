package com.example.kisileruygulamasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiKayitViewModel @Inject constructor ( var kisilerRepository: KisilerRepository):ViewModel() {
   // var kisilerRepository= KisilerRepository() normalde bu şekilde tanımladıgın şeyi hiltle direkt alcan dışardan isteyerek

    fun kaydet(kisi_ad:String , kisi_tel:String){ //arayüzle çalışma yapcaksak suspendi kaldırıyoz,suspend hatası vermesin diye de aşapıdaki kodu yazıyoz
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepository.kaydet(kisi_ad,kisi_tel)
        }//main arayüze yakın oln işlemlerde, IO veritbanına yakın işlemlerde kulalnılıyor
    }
}