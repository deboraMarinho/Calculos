package com.example.debce.calculos

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_hora.*

class HoraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hora)

        //incluir botão de voltar na pagina
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnHoraSalario.setOnClickListener {
            val hora = ((etHoraSemana.text.toString().toDouble()) / (etDiaSemana.text.toString().toDouble())) *( etDiaMes.text.toString().toDouble())

            val total = (etSalario.text.toString().toDouble()) / hora

            txtHora.text = "O valor da hora trabalhada é: " + total
        }

        btnFonteHora.setOnClickListener {
            val uris = Uri.parse("https://www.beirithadvogados.com.br/como-calcular-salario-hora/")
            val intents = Intent(Intent.ACTION_VIEW, uris)
            startActivity(intents)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //caso o botão home seja selecionado (esse é o botão padrão quando inserimos o DisplayHome)
        return if (item?.itemId == android.R.id.home){
            //finalizando a Activity
            finish()
            true
        } else {
           super.onOptionsItemSelected(item)
        }

    }
}
