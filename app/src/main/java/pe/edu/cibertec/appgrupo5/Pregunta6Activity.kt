package pe.edu.cibertec.appgrupo5

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.appgrupo5.databinding.ActivityPregunta6Binding

class Pregunta6Activity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPregunta6Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_pregunta6)
        binding = ActivityPregunta6Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnCalcularPreg6.setOnClickListener(this)
        binding.btnRegresar6.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnCalcularPreg6 -> calcularEstancia()
            R.id.btn_regresar6 -> regresarMain()
        }
    }
    private fun regresarMain() {
        finish()
    }

    fun calcularEstancia() {
        val textoDias = binding.edtDias.text.toString()

        if (textoDias.isEmpty()) {
            binding.txtResultadoPreg6.text = "Ingrese los días de estancia"
            return
        }
        if (textoDias == null) {
            binding.txtResultadoPreg6.text =
                "Ingrese dias correctamente."
            return
        }

        if (textoDias.toInt() < 0) {
            binding.txtResultadoPreg6.text =
                "los dias no puede ser negativo."
            return
        }

        val dias = textoDias.toInt()

        if (dias <= 3) {
            binding.txtResultadoPreg6.text =
                "Días cubiertos por el paquete quirúrgico contratado."
        } else {

            val diasExcedentes = dias - 3
            val costo = 95.00 + (diasExcedentes * 45.00)

            binding.txtResultadoPreg6.text =
                "Total de días: $dias\n" +
                        "Días excedentes: $diasExcedentes\n" +
                        "Costo adicional: S/ %.2f".format(costo)
        }
    }
}

