package com.geektech.lesson6_1_class_work


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.URLUtil
import android.widget.Toast
import com.bumptech.glide.Glide
import com.geektech.lesson6_1_class_work.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var list = mutableListOf<String>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillList()
        initListener()
    }

    private fun initListener() {
        with(binding) {
            btnSubmit.setOnClickListener {
                if(URLUtil.isValidUrl(etInput.text.toString()) && etInput.text.isNotEmpty()) {
                    list.add(etInput.text.toString())
                    etInput.text.clear()
                }else{
                    Toast.makeText(this@MainActivity,"Добавьте ссылку картинки",Toast.LENGTH_SHORT).show()
                }
            }

            btnRandom.setOnClickListener {
                Glide.with(this@MainActivity).load(list.random()).into(ivImage)
            }
        }
    }

    private fun fillList() {
        list.add("https://pixabay.com/ru/photos/%d1%84%d0%b8%d0%b0%d1%82-500-%d0%b0%d0%b2%d1%82%d0%be%d0%bc%d0%be%d0%b1%d0%b8%d0%bb%d1%8c-%d0%b4%d0%b5%d1%80%d0%b5%d0%b2%d1%8c%d1%8f-4322521/")
        list.add("https://pixabay.com/ru/photos/%d0%bf%d0%be%d1%80%d1%88%d0%b5-%d0%bc%d0%b0%d1%88%d0%b8%d0%bd%d0%b0-%d1%82%d0%be%d1%80%d0%bc%d0%be%d0%b7%d0%bd%d1%8b%d0%b5-%d0%be%d0%b3%d0%bd%d0%b8-1851246/")
        list.add("https://pixabay.com/ru/photos/%d1%84%d0%be%d1%80%d0%b4-%d0%bc%d1%83%d1%81%d1%82%d0%b0%d0%bd%d0%b3-%d0%bc%d0%b0%d1%88%d0%b8%d0%bd%d0%b0-2705402/")
        list.add("https://pixabay.com/ru/photos/%d0%b0%d0%b2%d1%82%d0%be%d0%bc%d0%be%d0%b1%d0%b8%d0%bb%d1%8c%d0%bd%d1%8b%d0%b9-%d0%bc%d0%b0%d1%88%d0%b8%d0%bd%d0%b0-%d0%bf%d0%b0%d0%bd%d0%b5%d0%bb%d1%8c-%d0%bf%d1%80%d0%b8%d0%b1%d0%be%d1%80%d0%be%d0%b2-1866521/")
        list.add("https://pixabay.com/ru/photos/%d0%bf%d1%83%d1%81%d1%82%d1%8b%d0%bd%d1%8f-%d0%bf%d0%b5%d1%81%d0%be%d0%ba-%d1%80%d0%b0%d0%bb%d0%bb%d0%b8-%d0%b4%d1%8e%d0%bd%d1%8b-%d0%bf%d0%b5%d0%b9%d0%b7%d0%b0%d0%b6-123978/")
    }
}

