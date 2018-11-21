package com.example.debce.calculos

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_inss.*

class InssActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inss)

        //incluir botão de voltar na pagina
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnInss.setOnClickListener {
            val bruto = etSalarioBruto.text.toString().toDouble()
            var liquido = 0.00
            var desconto = 0.00

            if (bruto <= 1693.72){
                liquido = bruto * 0.08
                desconto = bruto - liquido
            }
            else if (bruto > 1693.72 && bruto <= 2822.90){
                liquido = bruto * 0.09
                desconto = bruto - liquido
            }
            else if (bruto > 2822.90 && bruto <= 5645.80){
                liquido = bruto * 0.11
                desconto = bruto - liquido
            }
            txtInss.text = "O valor do INSS é: " + liquido.toString()
        }

        btnFonteInss.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://www.calculador.com.br/calculo/inss#")))
        }

        }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // caso o botão home seja selecionado (esse é o botão padrão quando inserimos o DisplayHome
        return if (item?.itemId == android.R.id.home){
            //finalizando a activity
            finish()
            true
        } else {
            super.onOptionsItemSelected(item)
        }

    }

    }
