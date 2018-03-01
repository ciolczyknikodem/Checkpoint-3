package services;

import java.util.Random;

public class ISBNgenerator {

    private Random random = new Random();
    private StringBuilder sb = new StringBuilder();

    public Long numberGenerator() {

        for (int i=0; i < 13; ++i) {
            String randomNumber = String.valueOf(random.nextInt(9));
            sb.append(randomNumber);
        }
        return convertToNumber();
    }

    private Long convertToNumber() {
        String ISBNumberString = sb.toString();
        return Long.valueOf(ISBNumberString);
    }

}
