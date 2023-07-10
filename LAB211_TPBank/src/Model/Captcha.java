package Model;

import java.util.Random;

public class Captcha {
    private String captcha;

    public Captcha() {
        this.captcha = randomCaptcha(6);
    }

    @Override
    public String toString() {
        return this.captcha;
    }

    public String randomCaptcha(Integer lenght) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < lenght; i++) {
            int randomInt = random.nextInt(62);
            char randomChar;

            if(randomInt < 26) randomChar = (char) (randomInt + 'A');
            else if(randomInt < 52) randomChar = (char) (randomInt - 26 + 'a');
            else randomChar = (char) (randomInt - 52 + '0');

            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }
}
