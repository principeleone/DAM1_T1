package pe.edu.cibertec.appgrupo5

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo5.databinding.ActivityPregunta4Binding
import java.util.Locale

class Pregunta4Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPregunta4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCalcular -> calcularTarifaExtra()
        }
    }

    private fun calcularTarifaExtra() {
        val minutosTexto = binding.etMinutos.text.toString().trim()

        if (minutosTexto.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese los minutos adicionales", Toast.LENGTH_SHORT).show()
            return
        }

        val minutosAdicionales = minutosTexto.toIntOrNull()

        if (minutosAdicionales == null || minutosAdicionales < 0) {
            Toast.makeText(this, "Ingrese un número de minutos válido", Toast.LENGTH_SHORT).show()
            return
        }

        if (minutosAdicionales <= 10) {
            binding.tvResultado.text = "Tiempo de tolerancia para desalojo y cambio de turno."
        } else {
            val minutosComputables = minutosAdicionales - 10
            val montoAdicional = 30.00 + (minutosComputables * 2.50)

            val resultado = """
                Minutos adicionales usados: $minutosAdicionales min
                Minutos computables para cobro: $minutosComputables min
                Monto adicional a facturar: ${String.format(Locale.US, "S/ %.2f", montoAdicional)}
            """.trimIndent()

            binding.tvResultado.text = resultado
        }
    }
}