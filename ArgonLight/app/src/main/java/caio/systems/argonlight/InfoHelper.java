package caio.systems.argonlight;

import android.widget.TextView;

/*
Esta classe será utilizada para suporte e tratamento de strings, JSon e etc.
*/

public class InfoHelper {

    //textviews basic drawer
    private TextView txtValor_total, txtValor_emissao_total, txtValor_media_total;
    //textviews dash board das unidades de consumo
    private TextView txtValor_unidade, txtValor_emissao_unidade, txtValor_media_unidade;

    //variaveis da home
    private String strVal_total, strVal_emi_total, strVal_med_total;

    //variaveis da dash unit
    private String strVal_unit, strVal_emi_unit, strVal_med_unit;

    public String getStrVal_total() {
        return strVal_total;
    }

    public void setStrVal_total(String strVal_total) {
        this.strVal_total = strVal_total;
    }

    public String getStrVal_emi_total() {
        return strVal_emi_total;
    }

    public void setStrVal_emi_total(String strVal_emi_total) {
        this.strVal_emi_total = strVal_emi_total;
    }

    public String getStrVal_med_total() {
        return strVal_med_total;
    }

    public void setStrVal_med_total(String strVal_med_total) {
        this.strVal_med_total = strVal_med_total;
    }

    public String getStrVal_unit() {
        return strVal_unit;
    }

    public void setStrVal_unit(String strVal_unit) {
        this.strVal_unit = strVal_unit;
    }

    public String getStrVal_emi_unit() {
        return strVal_emi_unit;
    }

    public void setStrVal_emi_unit(String strVal_emi_unit) {
        this.strVal_emi_unit = strVal_emi_unit;
    }

    public String getStrVal_med_unit() {
        return strVal_med_unit;
    }

    public void setStrVal_med_unit(String strVal_med_unit) {
        this.strVal_med_unit = strVal_med_unit;
    }

    public void publish_values(){

    }




}
