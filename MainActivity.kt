package com.epic.social

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

private val backgroundColor = Color.rgb(12, 12, 20)
private val accentColor = Color.rgb(100, 80, 255)
private val textColor = Color.WHITE

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    showWelcomeScreen()
}

private fun showWelcomeScreen() {
    val layout = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        gravity = Gravity.CENTER
        setPadding(32, 32, 32, 32)
        setBackgroundColor(backgroundColor)
    }

    val logo = TextView(this).apply {
        text = "EPIC"
        textSize = 48f
        setTextColor(accentColor)
        typeface = Typeface.DEFAULT_BOLD
        gravity = Gravity.CENTER
    }

    val subtitle = TextView(this).apply {
        text = "Connect. Share. Discover."
        textSize = 18f
        setTextColor(textColor)
        gravity = Gravity.CENTER
    }

    val description = TextView(this).apply {
        text = "Welcome to EPIC, your social world."
        textSize = 15f
        setTextColor(Color.LTGRAY)
        gravity = Gravity.CENTER
        setPadding(0, 24, 0, 32)
    }

    val signInButton = createButton("SIGN IN")
    val registerButton = createButton("CREATE ACCOUNT")

    signInButton.setOnClickListener {
        showMessage("Sign-in screen coming next!")
    }

    registerButton.setOnClickListener {
        showMessage("Account registration coming next!")
    }

    layout.addView(logo)
    layout.addView(subtitle)
    layout.addView(description)

    layout.addView(
        signInButton,
        LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, 56
        ).apply {
            bottomMargin = 16
        }
    )

    layout.addView(
        registerButton,
        LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, 56
        )
    )

    setContentView(layout)
}

private fun createButton(label: String): Button {
    return Button(this).apply {
        text = label
        textSize = 14f
        setTextColor(Color.WHITE)
        setBackgroundColor(accentColor)
        isAllCaps = false
    }
}

private fun showMessage(message: String) {
    android.widget.Toast.makeText(
        this,
        message,
        android.widget.Toast.LENGTH_SHORT
    ).show()
}

}
