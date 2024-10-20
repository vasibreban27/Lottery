import java.math.BigDecimal;
import java.util.Random;
public class Loterie {

    public BigDecimal factorial(int n) {
        BigDecimal prod = BigDecimal.ONE;
        for (int i = 2; i <= n; i++) {
            prod = prod.multiply(BigDecimal.valueOf(i));
        }
        return prod;
    }

    public BigDecimal combinari(int n, int k) {
        BigDecimal rez1 = BigDecimal.ONE;
        rez1 = factorial(n);
        BigDecimal rez2 = BigDecimal.ONE;
        rez2 = factorial(k);
        BigDecimal rez3 = BigDecimal.ONE;
        rez3 = factorial(n - k);
        return rez1.divide(rez2.multiply(rez3));
    }

    public BigDecimal sanseCastig(int n, int k) {
        return combinari(n, k);
    }
}
    class Extragere
    {
        private long extrageri;
        private int nrExtrase;
        private int maxNumere;

        public Extragere(int nrExtrase, int maxNumere) {
            this.extrageri = 0;
            this.nrExtrase = nrExtrase;
            this.maxNumere = maxNumere;

        }
        public void simulareExtragere(int nrExtrase,int maxNumere )
        {

            int extrase = 0;
            while(extrase < nrExtrase) {
                int nrGenerat = (int) (Math.random() * 51);
                long masca = 1L << (nrGenerat - 1);
                if ((extrageri & masca) == 0) {
                    extrageri = extrageri | masca;
                    extrase++;
                }
            }
        }

        public  void afiseazaNumereExtrase( boolean crescator) {
            if (crescator) {
                for (int i = 1; i <= maxNumere; i++) {
                    if ((extrageri & (1L << (i - 1))) != 0) {
                        System.out.print(i + " ");
                    }
                }
            } else {
                for (int i = maxNumere; i >= 1; i--) {
                    if ((extrageri & (1L << (i - 1))) != 0) {
                        System.out.print(i + " ");
                    }
                }
            }
            System.out.println();
        }

        public long getExtrageri() {
            return extrageri;
        }
    }

class ExtragereLoterie
{
    public static void main(String[] args){
        int n = 49;
        int k = 6;
        Loterie loterie = new Loterie();
        BigDecimal sanse = loterie.sanseCastig(n,k);
        System.out.println("Sansele de a castiga la loto sunt 1 din " + sanse);

        Extragere extragere = new Extragere(k,n);
        extragere.simulareExtragere(k,n);

        System.out.println("Numerele extrase sunt(in ordine crescatoare): ");
        extragere.afiseazaNumereExtrase(true);

        System.out.println("Numerele extrase sunt(in ordine descrescatoare): ");
        extragere.afiseazaNumereExtrase(false);
    }
}

