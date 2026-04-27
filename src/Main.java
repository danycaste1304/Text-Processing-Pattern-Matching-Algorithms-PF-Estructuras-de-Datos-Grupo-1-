public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Bienvenidos a reseñas Patitos");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        //System.out.println("Donde las mujeres ya no lloran, facturan");
        System.out.println("");
        System.out.println("Aqui vamos a identificar si tu reseña es positiva o negativa, encontrando las palabras clave.");

        Review r1 = new Review(01, "Juan","El producto es excelente, lo recomiendo mucho.");
        Review r2 = new Review(02, "María", "El servicio fue terrible y decepcionante.");
        Review r3 = new Review(03, "Pedro", "El producto es perfecto, pero el empaque fue malo.");
        Review r4 = new Review(04, "Ana", "El paquete llegó ayer en la tarde.");
        Review r5 = new Review(05, "Luis", "Estoy encantado con la compra, fue increible.");

        Review[] reviews = {r1, r2, r3, r4, r5};

        WordAnalyzer analyzer = new WordAnalyzer(reviews);

        System.out.println();
        System.out.println("Palabras Positivas:");
        for (String palabra : analyzer.getPositiveKeywords()) {
            System.out.println("- " + palabra);
        }

        System.out.println();
        System.out.println("Palabras Negativas:");
        for (String palabra : analyzer.getNegativeKeywords()) {
            System.out.println("- " + palabra);
        }

        System.out.println();
        System.out.println("Clasificación de Reseñas:");
        System.out.println("----------------------------------------");

        for (Review review : analyzer.getReviews()) {
            System.out.println("Reseña: " + review.getText());
            System.out.println("Clasificación: " + analyzer.classifyReview(review));
            System.out.println("----------------------------------------");
        }

        System.out.println();
        System.out.println("Prueba de Búsqueda de Palabras Clave:");
        System.out.println("----------------------------------------");

        Review reviewPrueba = r1;
        String keyword = "recomiendo";

        System.out.println("Texto analizado:");
        System.out.println(reviewPrueba.getText());

        System.out.println();
        System.out.println("Palabra buscada: " + keyword);

        int posBrute = analyzer.searchBrute(reviewPrueba, keyword);
        int posBoyer = analyzer.searchBoyerMoore(reviewPrueba, keyword);
        int posKMP = analyzer.searchKMP(reviewPrueba, keyword);

        System.out.println();
        System.out.println("Resultado Brute Force: " + posBrute);
        System.out.println("Resultado Boyer-Moore: " + posBoyer);
        System.out.println("Resultado KMP: " + posKMP);

        System.out.println();
        System.out.println("Interpretación:");
        if (posKMP != -1) {
            System.out.println("La palabra \"" + keyword + "\" fue encontrada en la posición " + posKMP + ".");
        } else {
            System.out.println("La palabra \"" + keyword + "\" no fue encontrada en la reseña.");
        }
        
    }
}
