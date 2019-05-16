package com.example.realprogrammers.platform.views

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.realprogrammers.R
import com.example.realprogrammers.platform.di.DetailActivityComponent
import com.example.realprogrammers.platform.di.ServerLocator
import com.example.realprogrammers.presentation.DetailView
import com.example.realprogrammers.presentation.presenters.DetailPresenter
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), DetailView {

    companion object Builder {
        fun getDetailIntent(context: Context): Intent = Intent(context, DetailActivity::class.java)
    }

    @Inject
    lateinit var presenter: DetailPresenter

    private val component: DetailActivityComponent by lazy {
        (application as ServerLocator).getDetailComponent(view = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        component.inject(activity = this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        firstNameListener()
        lastNameListener()
        emacsListener()
        caffeineListener()
        buttonListener()

        presenter.viewReady()
    }

    override fun activateButton(isEnabled: Boolean) {
        fabSave.isEnabled = isEnabled
    }

    fun buttonListener() {
        fabSave.setOnClickListener { presenter.saveButtonClicked() }
    }

    private fun firstNameListener() {
        etFirstName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                presenter.firstNameChanges(s.toString())
            }
        })
    }

    private fun lastNameListener() {
        etLastName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                presenter.lastNameChanges(s.toString())
            }
        })
    }

    private fun emacsListener() {
        sbEmac.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                presenter.emacsLevelChanges(emacsLevel = progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

    private fun caffeineListener() {
        sbCaffeine.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                presenter.caffeineLevelChanges(caffeineLevel = progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

    override fun setFirstName(firstName: String) {
        etFirstName.setText(firstName)
    }

    override fun setLastName(lastName: String) {
        etLastName.setText(lastName)
    }

    override fun setCaffeineValue(caffeineValue: Int) {
        sbCaffeine.progress = caffeineValue
    }

    override fun displayCaffeineLabel(caffeineLabel: String) {
        tvCaffeineLabel.text = caffeineLabel
    }

    override fun setEmacsValue(emacsValue: Int) {
        sbEmac.progress = emacsValue
    }

    override fun displayEmacsLabel(emacsLabel: String) {
        tvEmacLabel.text = emacsLabel
    }

    override fun setRating(rating: Int) {
        rbRating.rating = (rating.toFloat() + 1F)
    }
}
