package com.example.practiceproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practiceproject.models.ListData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()

    }

    private fun initRecyclerView(){
        recycleViewFinder.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = RecyclerViewAdapter()
        recycleViewFinder.adapter = recyclerViewAdapter
    }

    private fun initViewModel() {
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.getLiveDataObserver().observe(this,object :Observer<ListData>{
            override fun onChanged(t: ListData?) {
                if(t != null){
                    recyclerViewAdapter.setUpdatedData(t.items)
                    recyclerViewAdapter.notifyDataSetChanged()
                }
                else{
                    Toast.makeText(this@MainActivity,"error in getting data",Toast.LENGTH_SHORT).show()
                }
            }
        })

        mainActivityViewModel.makeApiCall()
    }

}



/*

// Private properties are not injected
    @Inject
    lateinit var car: Car

    @Inject
    lateinit var newCar: Car


// -------------------------- Using Constructor Injection ----------------------
        // This automatically allows to create the object of wheel and engine
        // and the car instance is created automatically

        // E.g below
        // car = DaggerCarComponent.create().getCar()
        // car.startEngine()

        // -------------------------- Field Injection ----------------------------------
        // Now After Field Injection we don't need to explicitly call the getCar()/startEngine() method
        // we just need to create the DaggerCar component and inject the main activity as parameter
        // E.g below
        // Used when there are multiple instances of the car

        var carComponent = DaggerCarComponent.create()
        carComponent.inject(this)

        car.startEngine()
        newCar.startEngine()


        // --------------------x------------------x------------------x------------------------
        // Manual dependency injection
        // creating wheels and engine manually and passing into the car

        /*

        var wheels = Wheels()
        var engine = Engine()

        */
        // Using Dagger we can automatically create objects of wheels and engine
        // and Car instance without manually.

        /*

        car = Car(wheels,engine)
        car.startEngine()

        */








 */