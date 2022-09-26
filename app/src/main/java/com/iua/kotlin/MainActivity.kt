package com.iua.kotlin

import android.content.Intent
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
      val email = binding.editTextTextEmailAddress.text.toString()
      val user = binding.editTextTextPersonName.text.toString()
      val password = binding.editTextTextPassword.text.toString()
      if(!validation(campo = "Email", validate =email) &&
      !validation(campo = "User", validate = user) &&
      !validation(campo = "Password", validate = password)
      ){
        if(email == R.string.admin_email.toString() && user == R.string.admin_user.toString() && password == R.string.admin_password.toString()){
          val intent:Intent = Intent(this,SecondActivity::class.java)
          intent.putExtra("user",user)
          startActivity(intent)
        }
        else{
          generateToast(R.string.usuario_no_registrado.toString(),0)
        }
      }

    }

    binding.register.setOnClickListener {
      Snackbar.make(view,R.string.proximamente.toString(),Snackbar.LENGTH_LONG).show()
    }

    binding.exit.setOnClickListener {
      onBackPressed()
    }

    binding.floatingActionButton.setOnClickListener{
      generateToast(R.string.datos_incompletos.toString(),1)
    }
  }

  private fun validation(validate:String, campo : String):Boolean{
    if(validate.isEmpty()){
      generateToast("El campo: $campo esta vacio.",1)
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