package pe.edu.cibertec.appgrupo5

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.appgrupo5.databinding.ActivityPregunta2Binding
import java.util.Locale

class Pregunta2Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_pregunta2)
        binding = ActivityPregunta2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnCalcularPreg2.setOnClickListener (this)
        binding.btnRegresar2.setOnClickListener(this)
    }

    fun calcularRecargo() {
        val peso = binding.txtPeso.text.toString().toDoubleOrNull()
        if (peso == null) {
            binding.txtResultado.text =
                "Ingrese el peso de la mascota."
            return
        }

        if (peso < 0) {
            binding.txtResultado.text =
                "El peso no puede ser negativo."
            return
        }

        if (peso <= 8) {
            binding.txtResultado.text =
                "Mascota apta para viajar en cabina sin sobrecosto."
        } else {

            val exceso = peso - 8
            val recargo = 150.0 + (exceso * 35.0)
            binding.txtResultado.text = String.format(
                Locale.US,
                "Peso total ingresado: %.2f kg\n" +
                        "Exceso de peso: %.2f kg\n" +
                        "Monto total a pagar por recargo: S/ %.2f",
                peso,
                exceso,
                recargo
            )
        }
    }
    private fun regresarMain() {
        finish()
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.btnCalcularPreg2 -> calcularRecargo()
            R.id.btn_regresar2 -> regresarMain()
        }
    }
}