package pe.edu.cibertec.appgrupo5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.appgrupo5.databinding.ActivityPregunta5Binding // Importación generada automáticamente

class pregunta5Activity : AppCompatActivity() {

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




        binding.btnCalcular.setOnClickListener {
            val input = binding.etPotencia.text.toString()


            if (input.isEmpty()) {
                binding.tvResultado.text = ".Ingrese un valor en watts."
                return@setOnClickListener
            }

            val potencia = input.toDouble()

            if (potencia <= 1000.0) {
                binding.tvResultado.text = ".Consumo eléctrico dentro de la capacidad asignada."
            } else {
                val sobrecargaWatts = potencia - 1000.0
                val cobroTotal = 180.0 + (sobrecargaWatts * 0.40)

                val mensaje = "*** Potencia registrada: $potencia W\n" +
                        "*** Sobrecarga de potencia: $sobrecargaWatts W\n" +
                        "*** Cobro por sobrecarga : S/ " + String.format("%.2f", cobroTotal)

                binding.tvResultado.text = mensaje
            }
        }
    }
}