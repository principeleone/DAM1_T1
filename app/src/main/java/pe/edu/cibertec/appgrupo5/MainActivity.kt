package pe.edu.cibertec.appgrupo5

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.appgrupo5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnPregunta1.setOnClickListener(this)
        binding.btnPregunta2.setOnClickListener(this)
        binding.btnPregunta3.setOnClickListener(this)
        binding.btnPregunta4.setOnClickListener(this)
        binding.btnPregunta5.setOnClickListener(this)
        binding.btnPregunta6.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
      when(p0.id){
          R.id.btn_pregunta1 ->irPregunta(1)
          R.id.btn_pregunta2 ->irPregunta(2)
          R.id.btn_pregunta3 ->irPregunta(3)
          R.id.btn_pregunta4 ->irPregunta(4)
          R.id.btn_Pregunta5 ->irPregunta(5)
          R.id.btn_pregunta6 ->irPregunta(6)

      }
    }

    private fun irPregunta(numPregunta: Int)  {
        when(numPregunta){
            1 -> startActivity(Intent(this, Pregunta1Activity::class.java))
            2 -> startActivity(Intent(this, Pregunta2Activity::class.java))
            3 -> startActivity(Intent(this, Pregunta3Activity::class.java))
            4 -> startActivity(Intent(this, Pregunta4Activity::class.java))
            5 -> startActivity(Intent(this, pregunta5Activity::class.java))
            6 -> startActivity(Intent(this, Pregunta6Activity::class.java))
        }
    }

}




