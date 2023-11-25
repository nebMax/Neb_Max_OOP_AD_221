package lb9;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        String text = "Unpleasant astonished an diminution up partiality. Noisy an their of meant. Death means up civil do an offer wound of. Called square an in afraid direct. Resolution diminution conviction so mr at unpleasing simplicity no. No it as breakfast up conveying earnestly immediate principle. Him son disposed produced humoured overcame she bachelor improved. Studied however out wishing but inhabit fortune windows.";
        String[] sentences = text.split("[.!?]");

        List<String> sentenceList = Arrays.asList(sentences);
        Collections.sort(sentenceList);

        System.out.println(sentenceList);
    }
}