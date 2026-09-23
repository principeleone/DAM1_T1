package pe.edu.cibertec.appgrupo5

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.appgrupo5.databinding.ActivityPregunta1Binding

class Pregunta1Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityPregunta1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnCalcular1.setOnClickListener(this)
        binding.btnRegresar.setOnClickListener(this)
    }

    fun calcularCargoLate(horasAdicionales: Int): Double{
        if(horasAdicionales<=2){
            return 0.0
        }else{
            return 60.0+25.0*(horasAdicionales-2)
        }
    }

    fun mostrarMensaje(){
        val horasAdicionales = binding.etHorasAdicionales.text.toString().toIntOrNull()?:0

        val horasCobro = if(horasAdicionales<=2) 0 else horasAdicionales-2
        val cargo = calcularCargoLate(horasAdicionales)
        val total = String.format("%.2f", cargo)
        val mensaje =  if (horasAdicionales<=2){
            "Salida dentro del margen de cortesía del hotel."
        } else {
            """
            Horas adicionales: $horasAdicionales
            Horas sujetas a cobro: $horasCobro
            Cargo total por Late Check-out: S/ $total
            """
        }
        binding.tvResultado.text = mensaje
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_calcular1-> mostrarMensaje()
            R.id.btn_regresar-> regresarMain()
        }

    }

    private fun regresarMain() {
        finish()
    }
}