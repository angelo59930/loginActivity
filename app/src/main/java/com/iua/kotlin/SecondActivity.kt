package com.iua.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iua.kotlin.databinding.ActivityMainBinding
import com.iua.kotlin.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
  private lateinit var binding: ActivitySecondBinding


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivitySecondBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    val user = intent.getStringExtra("user")

    binding.bienvenida.apply {
      text = "Bienvenido " + user
    }

    binding.goBack.setOnClickListener {
      val intent:Intent = Intent(this,MainActivity::class.java)
      startActivity(intent)
    }

  }
}