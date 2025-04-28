package org.example.Sa;
import org.example.Sa.Flower;

import java.util.*;
public class Garden implements Iterable<Flower>{
    private Map<String, Flower> flower;
    private int gardenNum;

    public Garden(Flower rose, Flower aster, Flower romashka, int gardenNum){
        this.flower = new HashMap<>();
        this.flower.put("астра", aster);
        this.flower.put("роза", rose);
        this.flower.put("ромашка", romashka);
        this.gardenNum = gardenNum;
    }

    public Iterator<Flower> iterator(){
        return new GardenIterator();
    }

    public class GardenIterator implements Iterator<Flower>{
        private List<String> order;
        private int currentIndex = 0;

        public GardenIterator(){
            if(gardenNum == 1){
                this.order = Arrays.asList("роза", "астра", "ромашка");
            }else if (gardenNum == 2){
                this.order = Arrays.asList("ромашка", "астра", "роза");
            }
        }
        @Override
        public boolean hasNext(){
            return currentIndex < order.size();
        }
        @Override
        public Flower next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            String flowerName = order.get(currentIndex);
            currentIndex++;
            return flower.get(flowerName);
        }
    }
}
