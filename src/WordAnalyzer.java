
public class WordAnalyzer {

    private static final String[] POSITIVE_KEYWORDS = {
        "excelente", "increible", "recomiendo", "perfecto", "encantado"
    };

    private static final String[] NEGATIVE_KEYWORDS = {
        "terrible", "pesimo", "horrible", "decepcionante", "malo"
    };

    private Review[] reviews;

    public WordAnalyzer(Review[] reviews) {
        this.reviews = reviews;
    }

    public String[] getPositiveKeywords() { 
        return POSITIVE_KEYWORDS;
    }
    public String[] getNegativeKeywords() { 
        return NEGATIVE_KEYWORDS; 
    }

    public int searchBrute(Review review, String keyword) {
        return PatternMatching.findBrute(
            review.getText().toLowerCase().toCharArray(),
            keyword.toCharArray()
        );
    }

    public int searchBoyerMoore(Review review, String keyword) {
        return PatternMatching.findBoyerMoore(
            review.getText().toLowerCase().toCharArray(),
            keyword.toCharArray()
        );
    }

    public int searchKMP(Review review, String keyword) {
        return PatternMatching.findKMP(
            review.getText().toLowerCase().toCharArray(),
            keyword.toCharArray()
        );
    }

    public String classifyReview(Review review) {
        char[] text = review.getText().toLowerCase().toCharArray();
        int positiveHits = 0;
        int negativeHits = 0;

        for (String keyword : POSITIVE_KEYWORDS)
            if (PatternMatching.findKMP(text, keyword.toCharArray()) != -1)
                positiveHits++;

        for (String keyword : NEGATIVE_KEYWORDS)
            if (PatternMatching.findKMP(text, keyword.toCharArray()) != -1)
                negativeHits++;

        if (positiveHits > negativeHits)      
            return "POSITIVA";
        else if (negativeHits > positiveHits) 
            return "NEGATIVA";
        else if (positiveHits > 0)            
            return "MIXTA";
        else                                  
            return "NEUTRAL";
    }

    public Review[] getReviews() {
        return reviews;
    }
}