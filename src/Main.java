import java.util.*;
import java.io.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int N1, N2, N3;
    static int[] list, list2;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    static int count;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N1 = sc.nextInt();
        N2 = sc.nextInt();
        N3 = sc.nextInt();

        list = new int[N1 + 1];
        list2 = new int[N1 + 1];

        for(int i = 0; i <= N1; i++) {
            arr.add(new ArrayList<>());
        }

        for(int i = 0; i < N2; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            arr.get(n1).add(n2);
            arr.get(n2).add(n1);
        }

        count = 1;

        for(int i = 1; i <= N1; i++) {
            Collections.sort(arr.get(i));
        }


        bfs(N3);
        dfs(N3);

        System.out.println(sb2);
        System.out.print(sb);

    }

    public static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.offer(start);
        list[start] = count;
        sb.append(start).append(" ");

        while(!que.isEmpty()) {
            int num = que.poll();

            for(int i = 0; i < arr.get(num).size(); i++) {
                if(list[arr.get(num).get(i)] == 0) {
                    list[arr.get(num).get(i)] = ++count;
                    sb.append(arr.get(num).get(i)).append(" ");
                    que.offer(arr.get(num).get(i));
                }
            }
        }
    }

    public static void dfs(int start) {
        list2[start] = count;
        sb2.append(start).append(" ");
        for(int i = 0; i < arr.get(start).size(); i++) {
            if(list2[arr.get(start).get(i)] == 0) {
                list2[arr.get(start).get(i)] = ++count;
                dfs(arr.get(start).get(i));
            }
        }
    }
}