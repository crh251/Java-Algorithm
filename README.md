# Java-Algorithm

## 1
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
<br>例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。


## 2
求区间交集，输入：
1 2
2 4
2 3
输出：
2 3

```java
import java.util.Scanner;

/**
 * @author laijh25319
 * @date 2021/3/22 22:54
 */
public class IntervalIntersection {

    public static void main(String[] args) {

        // 线段树

        // 暴力

        Scanner scanner = new Scanner(System.in);

        int[] s = new int[1000];
        int[] e = new int[1000];

        int cnt = 0;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (; ; ) {
            String s1 = scanner.nextLine();
            if (s1 == null || s1
                    .length() == 0) {
                break;
            }
            String[] n = s1.split(" ");
            s[cnt] = Integer.parseInt(n[0]);
            min = Math.min(min, s[cnt]);
            e[cnt] = Integer.parseInt(n[1]);
            max = Math.max(max, e[cnt]);
            cnt++;
        }

        int l = Integer.MIN_VALUE, r = Integer.MIN_VALUE;

        boolean hasOutput = false;

        // i 为点
        for (int i = min; i <= max; i++) {

            // ec 区间右边界为i的个数
            // sc 区间左边界为i的个数
            int ec = 0, sc = 0;

            // 左边界或右边界为i的个数
            int vc = 0;

            boolean common = false;
            for (int j = 0; j < cnt; j++) {

                // 横跨
                if (s[j] < i && e[j] > i) {
                    if (l == Integer.MIN_VALUE) {
                        l = r = i;
                    } else {
                        r = i;
                    }
                    common = true;
                    break;
                }

                if (e[j] == i) {
                    ec++;
                    vc++;
                } else if (s[j] == i) {
                    sc++;
                    vc++;
                }

                if (ec > 1 || sc > 1) {
                    if (l == Integer.MIN_VALUE) {
                        l = r = i;
                    } else {
                        r = i;
                    }
                    common = true;
                    break;
                }

            }

            if (!common || i == max) {
                if (l != Integer.MIN_VALUE) {
                    System.out.println(l + " " + r);
                    hasOutput = true;
                }
                if (vc > 1 && i < max) {
                    System.out.println(i + " " + i);
                    hasOutput = true;
                }
                l = r = Integer.MIN_VALUE;
            }


        }

        if (!hasOutput) {
            System.out.println("None");
        }

    }
}
```
