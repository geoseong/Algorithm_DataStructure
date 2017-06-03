package baekjoon.line_2252;

/**
 * Created by TSPark on 2017-06-03.
 */
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Topological_Sort{
    public static LinkedList<Integer> graph[]; //인접 리스트 그래프
    public static int n, indegree[]; //진입차수를 세기 위한 배열
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String line[] = sc.nextLine().split(" ");
        int i, from, to, m;
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        indegree = new int[n];
        graph = new LinkedList[n];
        for(i=0;i<n;i++) graph[i] = new LinkedList<>(); //LinkedList 초기화

        for(i=0;i<m;i++){
            line = sc.nextLine().split(" ");

            from = Integer.parseInt(line[0]) - 1; //인덱스니까 -1
            to = Integer.parseInt(line[1]) - 1; //상동;

            graph[from].add(to);//인접리스트를 이용해 from -> to 표현
            indegree[to]++; //진입 차수를 계산해야 하므로 to의 진입차수+1
        }

        topologicalSort(); //위상 정렬

        sc.close();
    }

    private static void topologicalSort(){
        Queue<Integer> searchQ = new LinkedList<>(); //탐색 큐
        Queue<Integer> resultQ = new LinkedList<>(); //결과 큐

		/* 초기 진입차수가 0인 노드 탐색 후 탐색 큐에 삽입 */
        for(int i=0;i<n;i++)
            if(indegree[i]==0)
                searchQ.offer(i);

		/* 탐색 큐가 빌 때까지 계속 탐색 */
        while(!searchQ.isEmpty()){

            //진입노드가 0인 노드와 연결된 노드를 탐색하기 위해 저장
            int zeroIndegreeNode = searchQ.poll();
            resultQ.offer(zeroIndegreeNode);//진입노드 0=정렬완료->결과 큐에 삽입

            //linkedNode = 진입노드가 0인 노드와 연결되어 있던 노드
            for(int linkedNode : graph[zeroIndegreeNode]){

                //진입노드 0인 노드들을 제거하므로, 연결되어있던 노드들의 차수-1
                indegree[linkedNode]--;

                if(indegree[linkedNode]==0)//연결된 노드 진입차수 수정 결과가 0이면
                    searchQ.offer(linkedNode); //추후 탐색을 위해 탐색 큐에 삽입
            }
        }

        //탐색 결과 출력(인덱스를 노드번호로 나타내기위해 +1)
        while(!resultQ.isEmpty())
            System.out.print((resultQ.poll()+1)+" ");
    }
}
