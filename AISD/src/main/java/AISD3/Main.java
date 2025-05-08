package AISD3;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> firstQueue = new ArrayDeque<>();
        firstQueue.add(1);
        firstQueue.add(3);
        firstQueue.add(534);
        Queue<Integer> secondQueue = new ArrayDeque<>();
        secondQueue.add(2);
        secondQueue.add(4);
//        System.out.println(merge(firstQueue,secondQueue));
        LinkedList<Integer> firstl = new LinkedList<>();
        firstl.add(1);
        firstl.add(42);
        firstl.add(47);
        LinkedList<Integer> secl = new LinkedList<>();
        secl.add(2);
        secl.add(3);

        System.out.println(sort(secl,firstl));

    }
    public static LinkedList<Integer> sort(LinkedList<Integer> p, LinkedList<Integer> pp){
        LinkedList<Integer> res = new LinkedList<>();
        while((!p.isEmpty() && !pp.isEmpty())){
            if (p.getFirst() > pp.getFirst()){
                res.add(pp.poll());
            }else{
                res.add(p.poll());
            }
        }
        while(!(p.isEmpty())){
            res.add(p.poll());
        }
        while (!(pp.isEmpty())){
            res.add(pp.poll());
        }
        return res;
    }
    public static Queue<Integer> merge(Queue<Integer> firtsQueue, Queue<Integer> secondQueue){
        Queue<Integer> res = new ArrayDeque<>();

        while (!firtsQueue.isEmpty() && !secondQueue.isEmpty()){
            if (firtsQueue.peek() <= secondQueue.peek()){
                res.offer(firtsQueue.poll());
            }else{
                res.offer(secondQueue.poll());
            }
        }

        while (!firtsQueue.isEmpty()){
            res.offer(firtsQueue.poll());
        }

        while (!secondQueue.isEmpty()){
            res.offer(secondQueue.poll());
        }
        return res;
    }

}
