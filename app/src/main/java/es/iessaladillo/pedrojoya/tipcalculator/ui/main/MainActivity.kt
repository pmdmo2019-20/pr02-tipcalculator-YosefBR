package es.iessaladillo.pedrojoya.tipcalculator.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.tipcalculator.R
import es.iessaladillo.pedrojoya.tipcalculator.model.TipCalculator



class MainActivity : AppCompatActivity() {

    private lateinit var txtBill: EditText
    private lateinit var txtPercentage: EditText
    private lateinit var txtTip: EditText
    private lateinit var txtTotal: EditText
    private lateinit var txtDiners: EditText
    private lateinit var txtPerDiner: EditText
    private lateinit var txtPerDinerRounded: EditText
    private lateinit var btnResetTip: Button
    private lateinit var btnResetDiners: Button
    private lateinit var tipCalculator: TipCalculator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
    }

    private fun setupViews() {
        txtBill = findViewById(R.id.txtBill)
        txtPercentage = findViewById(R.id.txtPercentage)
        txtTip = findViewById(R.id.txtTip)
        txtTotal = findViewById(R.id.txtTotal)
        txtDiners = findViewById(R.id.txtDiners)
        txtPerDiner = findViewById(R.id.txtPerDiner)
        txtPerDinerRounded = findViewById(R.id.txtPerDinerRounded)
        btnResetTip = findViewById(R.id.btnResetTip)
        btnResetDiners = findViewById(R.id.btnResetDiners)

        txtBill.requestFocus()

        txtBill.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //No hace nada
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //No hace nada
            }

            override fun afterTextChanged(p0: Editable?) {
                if(!txtBill.text.toString().equals("")) {
                    tipCalculator = TipCalculator(
                        txtBill.text.toString().toFloat(),
                        txtPercentage.text.toString().toFloat(),
                        txtDiners.text.toString().toFloat()
                    )
                    txtTip.setText(getString(R.string.showCalculations, tipCalculator.calculateTip()).replace(",","."))
                    txtTotal.setText(getString(R.string.showCalculations, tipCalculator.calculateTotal()).replace(",","."))
                    txtPerDiner.setText(getString(R.string.showCalculations, tipCalculator.calculatePerDiner()).replace(",","."))
                    txtPerDinerRounded.setText(getString(R.string.showCalculations, tipCalculator.calculatePerDinerRounded()).replace(",","."))
                }
                else {
                    txtBill.setText("0.00")
                    txtBill.clearFocus()
                    txtBill.requestFocus()
                }
            }
        })

        txtPercentage.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //No hace nada
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //No hace nada
            }

            override fun afterTextChanged(p0: Editable?) {
                if(!txtPercentage.text.toString().equals("")) {
                    tipCalculator = TipCalculator(
                        txtBill.text.toString().toFloat(),
                        txtPercentage.text.toString().toFloat(),
                        txtDiners.text.toString().toFloat()
                    )
                    txtTip.setText(getString(R.string.showCalculations, tipCalculator.calculateTip()).replace(",","."))
                    txtTotal.setText(getString(R.string.showCalculations, tipCalculator.calculateTotal()).replace(",","."))
                    txtPerDiner.setText(getString(R.string.showCalculations, tipCalculator.calculatePerDiner()).replace(",","."))
                    txtPerDinerRounded.setText(getString(R.string.showCalculations, tipCalculator.calculatePerDinerRounded()).replace(",","."))
                }
                else {
                    txtPercentage.setText("10.00")
                    txtPercentage.clearFocus()
                    txtPercentage.requestFocus()
                }
            }
        })

        txtDiners.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //No hace nada
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (txtDiners.text.toString().equals("0")) {
                    txtDiners.setText("1")
                    txtDiners.clearFocus()
                    txtDiners.requestFocus()
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                if(!txtDiners.text.toString().equals("")) {
                    tipCalculator = TipCalculator(
                        txtBill.text.toString().toFloat(),
                        txtPercentage.text.toString().toFloat(),
                        txtDiners.text.toString().toFloat()
                    )
                    txtTip.setText(getString(R.string.showCalculations, tipCalculator.calculateTip()).replace(",","."))
                    txtTotal.setText(getString(R.string.showCalculations, tipCalculator.calculateTotal()).replace(",","."))
                    txtPerDiner.setText(getString(R.string.showCalculations, tipCalculator.calculatePerDiner()).replace(",","."))
                    txtPerDinerRounded.setText(getString(R.string.showCalculations, tipCalculator.calculatePerDinerRounded()).replace(",","."))
                }
                else {
                    txtDiners.setText("1")
                    txtDiners.clearFocus()
                    txtDiners.requestFocus()
                }
            }
        })

        btnResetTip.setOnClickListener { resetTopSide() }

        btnResetDiners.setOnClickListener { resetBotSide() }

    }

    private fun resetTopSide() {
        txtBill.setText("0.00")
        txtPercentage.setText("10.00")
        txtBill.requestFocus()
    }

    private fun resetBotSide() {
        txtDiners.setText("1")
        txtDiners.requestFocus()
    }
}
