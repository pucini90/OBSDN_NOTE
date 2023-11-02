
00. 변수, 기본연산자만 갖고 푸는 문제

01. 짝수는 짝수제곱합, 홀수는 홀수합 구하는 문제
class Solution {
    public int solution(int n) {<br>        if (n % 2 == 1) {<br>            return (n + 1) * (n + 1) / 2 / 2;<br>        } else {<br>            return 4 * n/2 * (n/2 + 1) * (2 * n/2 + 1) / 6;   <br>        }<br>    }<br>}

02. >=, <=, >, < 구하는 문제
import java.util.Map;
import java.util.function.BiFunction;

class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        Map<String, BiFunction<Integer, Integer, Boolean>> functions = Map.of(
                ">=", (a, b) -> a >= b,
                "<=", (a, b) -> a <= b,
                ">!", (a, b) -> a > b,
                "<!", (a, b) -> a < b
        );
        return functions.get(ineq + eq).apply(n, m) ? 1 : 0;
    }
}


<table>

</table>
