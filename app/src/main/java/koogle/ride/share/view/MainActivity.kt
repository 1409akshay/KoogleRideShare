package koogle.ride.share.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import koogle.ride.share.viewmodel.MyViewModelFactory
import koogle.ride.share.R
import koogle.ride.share.data.Repository
import koogle.ride.share.data.NetworkBuilder
import koogle.ride.share.databinding.ActivityMainBinding
import koogle.ride.share.adapter.UserHelpListAdapter
import koogle.ride.share.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val retrofitService = NetworkBuilder.getInstance()
    private val adapter = UserHelpListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(
            this,
            MyViewModelFactory(Repository(retrofitService))
        )[MainViewModel::class.java]
        binding.helpListRecycler.adapter = adapter

        //Calling of API
        viewModel.getHelpUserList()
        viewModel.mutableHelpList.observe(this) {
            if (it.code() == 200)
                adapter.updateHelpList(it.body()?.body()?.helpList ?: listOf())
            else
                Toast.makeText(
                    this,
                    getString(R.string.something_went_wrong),
                    Toast.LENGTH_LONG
                ).show()
        }
        viewModel.errorMsg.observe(this) {
                Toast.makeText(
                    this,
                    it,
                    Toast.LENGTH_LONG
                ).show()
        }
    }
}