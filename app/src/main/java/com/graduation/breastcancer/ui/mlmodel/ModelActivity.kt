package com.graduation.breastcancer.ui.mlmodel

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.gson.Gson
import com.graduation.breastcancer.R
import com.graduation.breastcancer.data.ModelResults
import com.graduation.breastcancer.databinding.ActivityModelBinding
import com.graduation.breastcancer.ml.Final
import com.graduation.breastcancer.ui.protocols.aftersergurycycle.AfterSurgeryProtocol
import com.graduation.breastcancer.ui.protocols.nonsergurycycle.SelectExcActivity
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer


class ModelActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityModelBinding
    private lateinit var uri: Uri
    private val gson = Gson()
    var resultTV: String? = null
    private var protocolResult: Boolean = false
    val list = mutableListOf<String>()
    private lateinit var bitMap: Bitmap

    private var launcher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode != RESULT_CANCELED) {
        if (it.resultCode == RESULT_OK && it.data?.data != null) {

            uri = it.data?.data!!
            bitMap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri) //

            val model = Final.newInstance(this)
            val image = Bitmap.createScaledBitmap(bitMap, 224, 224, true)
            val inputFeature0 =
                TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)
            val tensorImage = TensorImage(DataType.FLOAT32)
            tensorImage.load(image)
            val byteBuffer = tensorImage.buffer
            Log.d("shape", byteBuffer.toString())
            Log.d("shape", inputFeature0.buffer.toString())
            inputFeature0.loadBuffer(byteBuffer)
            val outputs = model.process(inputFeature0)
            val outputFeature0 = outputs.outputFeature0AsTensorBuffer
            val result = outputFeature0.floatArray[0]

            if (result >= 0.5) {
                viewBinding.resultTV.text = getString(R.string.cancer_detected)
                viewBinding.resultTV.setTextColor(Color.RED)
                viewBinding.haveYouMadeSurgeryTV.isVisible = true
                viewBinding.yesForOpBtn.isVisible = true
                viewBinding.noBtn.isVisible = true

            } else if (result < 0.5) {
                viewBinding.resultTV.text = getString(R.string.no_cancer)
                viewBinding.resultTV.setTextColor(Color.GREEN)
                viewBinding.haveYouMadeSurgeryTV.isVisible = true
                viewBinding.yesForOpBtn.isVisible = true
                viewBinding.noBtn.isVisible = true

            }
            resultTV = viewBinding.resultTV.text.toString()
            viewBinding.yesForOpBtn.setOnClickListener {
                protocolResult = true
                val data = ModelResults(resultTV, protocolResult)
                setData(data)
                navigateToSurgeryProtocols()
            }
            viewBinding.noBtn.setOnClickListener {
                protocolResult = false
                val data = ModelResults(resultTV, protocolResult)
                setData(data)
                navigateToNonProtocols()
            }



            viewBinding.image.setImageBitmap(bitMap)
            model.close()


        }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityModelBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
    }

    private fun initViews() {
        viewBinding.uploadImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            launcher.launch(intent)
        }
        viewBinding.nextBtn.setOnClickListener {

        }
    }

    private fun setData(data: ModelResults) {
        val pref = getSharedPreferences("User", MODE_PRIVATE)

        val json = gson.toJson(data)

        if (!pref.contains("modelAnswer")) {
            val list = mutableSetOf(json)
            val edit = pref.edit().putStringSet("modelAnswer", list)
            edit.apply()
        } else {
            pref.getStringSet("modelAnswer", mutableSetOf())?.let { set ->
                val res = set.toMutableList()
                list.addAll(res)
                list.add(json)
            }
            pref.edit().putStringSet("modelAnswer", list.toMutableSet()).apply()
        }

        Log.d("list res", list.toString())

    }

    private fun navigateToNonProtocols() {
        val intent = Intent(this, SelectExcActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToSurgeryProtocols() {
        val intent = Intent(this, AfterSurgeryProtocol::class.java)
        startActivity(intent)
        finish()
    }

}