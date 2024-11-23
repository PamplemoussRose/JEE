package fr.univtours.polytech.td9.business;

public class SecuBusinessImpl implements SecuBusiness {

    public boolean checkNumSecu(long numero) {
        // 97 - (13 premier chiffres modulo 97)
        long num = numero / 100;
        long cle = numero % 100;
        if (97 - (num % 97) == cle) {
            return true;
        } else {
            return false;
        }
    }
}
