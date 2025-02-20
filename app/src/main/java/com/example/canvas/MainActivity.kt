package com.example.canvas

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var signatureView: SignatureView
    private lateinit var clearButton: Button
    private lateinit var saveButton: Button
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        signatureView = findViewById(R.id.signature_view)
        clearButton = findViewById(R.id.clear_button)
        saveButton = findViewById(R.id.save_button)
        imageView = findViewById(R.id.image_view)

        clearButton.setOnClickListener {
            signatureView.clear()
            imageView.setImageBitmap(null)
        }

        saveButton.setOnClickListener {
            imageView.setImageBitmap(signatureView.getSignatureBitmap())
        }

        imageView.setOnClickListener {
            imageView.setImageBitmap(null)
        }
    }
}