/**
 * https://leetcode-cn.com/problems/bulls-and-cows/
 *
 * @author infearOnTheWay
 */
public class GetHintSolution {
    public String getHint(String secret, String guess) {
        int x = 0;
        int[] y1 = new int[10], y2 = new int[10];
        for (int idx = 0; idx != secret.length(); idx++) {
            if (secret.charAt(idx) == guess.charAt(idx)) {
                x++;
            } else {
                y1[secret.charAt(idx) - '0']++;
                y2[guess.charAt(idx) - '0']++;
            }
        }
        int y = 0;
        for (int i = 0; i != 10; i++) {
            y += Math.min(y1[i], y2[i]);
        }
        return x + "A" + y + "B";
    }
}
