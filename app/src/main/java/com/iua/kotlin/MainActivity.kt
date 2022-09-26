package com.iua.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.iua.kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding:ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    binding.textView.setOnClickListener{
      val string:String = R.string.restore_password.toString() + binding.editTextTextEmailAddress.text
      generateToast(string, 1)
    }

    binding.logGin.setOnClickListener {
      if(!validation(campo = "Email", validate = binding.editTextTextEmailAddress.text.toString()) &&
      !validation(campo = "User", validate = binding.editTextTextPersonName.text.toString()) &&
      !validation(campo = "Password", validate = binding.editTextTextPassword.text.toString())
      ){
        //TODO: AGREGAR EL INTENT PARA CAMBIAR DE ACTIVITY

      }
    }

    binding.register.setOnClickListener {
      Snackbar.make(view,"Proximamente...",Snackbar.LENGTH_LONG).show()
    }

    binding.exit.setOnClickListener {
      //TODO: AGREGAR INTENT PARA SALIR DE LA APP

    }

  }

  private fun validation(validate:String, campo : String):Boolean{
    if(validate.isEmpty()){
      generateToast("El campo: " + campo + "esta vacio.",1)
      return true
    }
    return false
  }

  private fun generateToast(string:String, duration:Int){
    if (duration == 1)
      Toast.makeText(applicationContext, string, Toast.LENGTH_LONG).show()
    else
      Toast.makeText(applicationContext, string, Toast.LENGTH_SHORT).show()
  }

}