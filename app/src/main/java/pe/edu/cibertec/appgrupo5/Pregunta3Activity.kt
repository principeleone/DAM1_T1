package pe.edu.cibertec.appgrupo5

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo5.databinding.ActivityPregunta3Binding

class Pregunta3Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta3Binding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(p0: View) {

        when(p0.id){
            R.id.btnCalcular -> calcularDesperdicio()
        }

    }

    fun calcularDesperdicio(){

        val gramos = binding.edtGramos.text.toString().toDouble()

        if(gramos <= 100){

            binding.tvResultado.text =
                "Plato dentro del margen admisible de consumo."

        }else{

            val exceso = gramos - 100

            val penalizacion = 15 + (exceso * 0.12)

            binding.tvResultado.text =
                "Gramos sobrantes: $gramos g\n" +
                        "Exceso de desperdicio: $exceso g\n" +
                        "Penalización total: S/ %.2f".format(penalizacion)
        }
    }
}