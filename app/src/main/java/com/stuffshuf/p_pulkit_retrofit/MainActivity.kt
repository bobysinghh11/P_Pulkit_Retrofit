package com.stuffshuf.p_pulkit_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.user_list.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


      btnGet.setOnClickListener {

          val retrofit=Retrofit.Builder()
              .addConverterFactory(GsonConverterFactory.create())
              .baseUrl("https://api.github.com/")
              .build();

          val service=retrofit.create(UsersInterface::class.java)
          service.listRespo().enqueue(retrofitCallback { throwable, response ->

              response?.let {
                  if (it.isSuccessful)
                  {


                          Log.d("HH", "response ${it.body()}")

                          recycle.layoutManager=GridLayoutManager(
                              this,
                              1,
                              GridLayoutManager.VERTICAL,
                              false)

                         // Log.d("HAH", "response ${it?.body()?.items}")


                          recycle.adapter=UsersAdapter(it.body()!!.items)


                      }

              }
          })
      }

    }
}
