package com.graduation.breastcancer.ui

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.graduation.breastcancer.databinding.ActivityModelBinding
import com.graduation.breastcancer.ml.Final
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.text.DecimalFormat

class ModelActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityModelBinding
    private lateinit var uri: Uri
    private lateinit var bitMap: Bitmap
    private var launcher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
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
            val df = DecimalFormat("#.######")
            val ans = df.format(result)
            if (ans.toFloat() >= 0.5) {
                viewBinding.resultTV.text = "Cancer Detected"
            } else if (ans.toFloat() < 0.5) {
                viewBinding.resultTV.text = "No Cancer"
            }
            viewBinding.image.setImageBitmap(bitMap)
            model.close()


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
}