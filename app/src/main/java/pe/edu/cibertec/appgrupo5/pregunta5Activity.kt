package pe.edu.cibertec.appgrupo5

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.appgrupo5.databinding.ActivityPregunta5Binding // Importación generada automáticamente

class pregunta5Activity : AppCompatActivity(), View.OnClickListener {

    // variable
    private lateinit var binding: ActivityPregunta5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPregunta5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnRegresar5.setOnClickListener(this)
        binding.btnCalcular5.setOnClickListener (this)
    }

    private fun regresarMain() {
        finish()
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnCalcular5-> calcular()
            R.id.btn_regresar5-> regresarMain()
        }
    }

    private fun calcular() {
        val input = binding.etPotencia.text.toString()


        if (input.isEmpty()) {
            binding.tvResultado5.text = ".Ingrese un valor en watts."
            return
        }

        val potencia = input.toDouble()

        if (potencia <= 1000.0) {
            binding.tvResultado5.text = ".Consumo eléctrico dentro de la capacidad asignada."
        } else {
            val sobrecargaWatts = potencia - 1000.0
            val cobroTotal = 180.0 + (sobrecargaWatts * 0.40)

            val mensaje = "*** Potencia registrada: $potencia W\n" +
                    "*** Sobrecarga de potencia: $sobrecargaWatts W\n" +
                    "*** Cobro por sobrecarga : S/ " + String.format("%.2f", cobroTotal)

            binding.tvResultado5.text = mensaje
        }
    }
}