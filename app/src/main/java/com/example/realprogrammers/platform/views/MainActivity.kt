package com.example.realprogrammers.platform.views

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.realprogrammers.R
import com.example.realprogrammers.platform.connectors.ProgrammerListConnector
import com.example.realprogrammers.platform.di.MainActivityComponent
import com.example.realprogrammers.platform.di.ServerLocator
import com.example.realprogrammers.presentation.MainView
import com.example.realprogrammers.presentation.presenters.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    private val component: MainActivityComponent by lazy {
        (application as ServerLocator).getMainComponent(view = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        component.inject(activity = this)

        fab.setOnClickListener {
            presenter.pressButton()
        }

        setUpRecyclerView()
        presenter.viewReady()
    }

    private fun setUpRecyclerView() {
        rvProgrammers.layoutManager = LinearLayoutManager(this)
        rvProgrammers.adapter = ProgrammerListAdapter(presenter = presenter)
    }

    override fun goToDetail() {
        startActivity(ProgrammerListConnector.navigateToEdit(this))
    }
}
