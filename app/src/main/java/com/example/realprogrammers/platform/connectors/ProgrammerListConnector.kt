package com.example.realprogrammers.platform.connectors

import android.content.Context
import android.content.Intent
import com.example.realprogrammers.platform.views.DetailActivity

class ProgrammerListConnector {

    companion object {

        fun navigateToEdit(context: Context): Intent =
            DetailActivity.getDetailIntent(context = context)

    }
}