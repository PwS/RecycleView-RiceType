package com.example.ricetype

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity:AppCompatActivity() {

    companion object {
        // daftarkan variable extra agar bisa diakses dari class lain
        val NAMA = "extra_name"
        val DETAIL = "extra_detail"
        val PHOTO = "extra_photo"
    }

    //BackButton
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val intent = Intent(this@DetailActivity, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        val itemImage = getIntent().getIntExtra(PHOTO, 0) // ambil nilai yang dikirim dari adapter khusus untuk PHOTO gunakan int
        val layoutImage : ImageView= findViewById(R.id.imageitemPhoto) // ambil id lokasi tag xml yang akan di isi nilai
        Glide.with(this)
            .load(itemImage)
            .apply(RequestOptions().override(100, 100))
            .into(layoutImage) // gunakan glide untuk menampilkan gambar
        val DataDiterima : TextView = findViewById(R.id.itemName) // ambil id lokasi tag xml yang akan di isi nilai
        val itemName = "Nama : " + getIntent().getStringExtra(NAMA) // ambil nilai yang dikirim dari adapter
        DataDiterima.setText(itemName)
        val DataDiterima2 : TextView = findViewById(R.id.itemDetail) // ambil id lokasi tag xml yang akan di isi nilai
        val itemDetail = getIntent().getStringExtra(DETAIL) // ambil nilai yang dikirim dari adapter
        DataDiterima2.setText(itemDetail)
    }

}
