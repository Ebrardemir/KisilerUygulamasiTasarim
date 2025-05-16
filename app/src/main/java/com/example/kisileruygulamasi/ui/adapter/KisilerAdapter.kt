package com.example.kisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.databinding.CardTasarimBinding
import com.example.kisileruygulamasi.ui.fragments.AnasayfaFragmentDirections
import com.example.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasi.utils.gecisYap
import com.google.android.material.snackbar.Snackbar

//viewmodel burada olmadıgı için ust sınıftan ıstıyoruz
class KisilerAdapter(var mContext: Context, var kisilerListesi : List<Kisiler>,var viewModel: AnasayfaViewModel) :
RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>()//2 sınıfı(cardtasarımbinding) adaptera ekliyon
{
    inner class CardTasarimTutucu(var tasarim :CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root) //1.tasarımı temsil eden bi sınıf oluşturcan

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu { //3 viewlara erişme
        val tasarim =CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int { //listedeki ürün sayısı
        return kisilerListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) { // yapılacak tüm işkemler, viewları yerleştirme vs
        val kisi=kisilerListesi.get(position) //position=kişilerlistesi.size, o kadar dönüyor, 0 - 1 -2
        val t=holder.tasarim //bu şekilde card tasarım xml e direkt erişebiliyorum
        t.textViewKisiAd.text=kisi.kisi_ad
        t.textViewKisiTel.text=kisi.kisi_tel

        t.cardViewSatir.setOnClickListener(){
            val gecis=AnasayfaFragmentDirections.kisiDetayGecis(kisi = kisi)
            //Navigation.findNavController(it).navigate(gecis)
            Navigation.gecisYap(it,gecis)
        }

        t.imageViewSil.setOnClickListener(){
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi?",Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                    viewModel.sil(kisi.kisi_id)
                }.show()
        }

    }
}