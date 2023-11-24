 //algorithmes de sorting
 public static void triSelection(int[] t){
        int min;
        int index;
        for(int p = 0;p<t.length;p++){
            min = t[p];
            index=p;
            for (int i=p;i<t.length;i++ ){
                if (t[i]<min)  {index = i; min=t[i];}
            }
            t[index]=t[p];
            t[p]=min;
        }

    }

    public static void triInsertion(int[] tableau) {
        int n = tableau.length;
        for (int j = 1; j < n; j++) {
            int cle = tableau[j];
            int i = j - 1;
            while (i >= 0 && tableau[i] > cle) {
                tableau[i + 1] = tableau[i];
                i--;
            }
            tableau[i + 1] = cle;
        }
    }


    public static void triBulles(int[] tableau) {
        int n = tableau.length;
        boolean estEchange;
//        Arrays.stream(tableau)

        for(int nmbr : tableau){
            System.out.println(nmbr);
        }
        do {
            estEchange = false;
            for (int i = 0; i < n - 1; i++) {
                if (tableau[i] > tableau[i + 1]) {
                    // Échanger les éléments si ils sont dans le mauvais ordre
                    int temp = tableau[i];
                    tableau[i] = tableau[i + 1];
                    tableau[i + 1] = temp;
                    estEchange = true;
                }
            }
        } while (estEchange);
    }


    public static void triFusion(int[] tableau) {
        if (tableau.length <= 1) {
            return; // Le tableau est déjà trié s'il a 0 ou 1 élément.
        }

        // Divisez le tableau en deux moitiés.
        int milieu = tableau.length / 2;
        int[] gauche = new int[milieu];
        int[] droite = new int[tableau.length - milieu];

        for (int i = 0; i < milieu; i++) {
            gauche[i] = tableau[i];
        }
        for (int i = milieu; i < tableau.length; i++) {
            droite[i - milieu] = tableau[i];
        }

        // Triez récursivement les deux moitiés.
        triFusion(gauche);
        triFusion(droite);

        // Fusionnez les deux moitiés triées pour obtenir le tableau trié final.
        fusionner(tableau, gauche, droite);
    }

    private static void fusionner(int[] tableau, int[] gauche, int[] droite) {
        int longueurGauche = gauche.length;
        int longueurDroite = droite.length;
        int i = 0, j = 0, k = 0;

        // Comparez les éléments de gauche et de droite et placez-les dans le tableau.
        while (i < longueurGauche && j < longueurDroite) {
            if (gauche[i] <= droite[j]) {
                tableau[k++] = gauche[i++];
            } else {
                tableau[k++] = droite[j++];
            }
        }

        // Copiez les éléments restants de gauche (s'il y en a).
        while (i < longueurGauche) {
            tableau[k++] = gauche[i++];
        }

        // Copiez les éléments restants de droite (s'il y en a).
        while (j < longueurDroite) {
            tableau[k++] = droite[j++];
        }
    }




        public static void triRapide(int[] tableau) {
            triRapide(tableau, 0, tableau.length - 1);
        }

        private static void triRapide(int[] tableau, int debut, int fin) {
            if (debut < fin) {
                int pivotIndex = partitionner(tableau, debut, fin);

                // Trie récursivement les sous-tableaux à gauche et à droite du pivot.
                triRapide(tableau, debut, pivotIndex - 1);
                triRapide(tableau, pivotIndex + 1, fin);
            }
        }

        private static int partitionner(int[] tableau, int debut, int fin) {
            int pivot = tableau[fin];
            int i = debut - 1;

            for (int j = debut; j < fin; j++) {
                if (tableau[j] <= pivot) {
                    i++;
                    // Échange les éléments tableau[i] et tableau[j].
                    int temp = tableau[i];
                    tableau[i] = tableau[j];
                    tableau[j] = temp;
                }
            }

            // Échange l'élément pivot (tableau[fin]) avec l'élément à la position i + 1.
            int temp = tableau[i + 1];
            tableau[i + 1] = tableau[fin];
            tableau[fin] = temp;

            return i + 1;
        }
