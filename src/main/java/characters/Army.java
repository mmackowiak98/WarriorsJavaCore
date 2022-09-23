package characters;

import java.util.*;
import java.util.function.Supplier;



public class Army {

    private static class Node{
        Warrior warrior;
        Node next;

        public Node(Warrior warrior) {
            this.warrior = warrior;
            this.next = this;
        }
    }

    private final Node head = new Node(null);
    private Node tail = head;


    boolean isEmpty(){
        return tail==head;
    }

    private void addToTail(Warrior warrior){
        var node = new Node(warrior);
        node.next = head;
        tail.next = node;
        tail = node;

    }



    public Iterator<Warrior> firstAlive(){
        return new FirstAliveIterator();

    }

        private class FirstAliveIterator implements Iterator<Warrior>{

             Warrior peek(){
                return head.next.warrior;
            }

            private void removeFromHead(){
                if(isEmpty()){
                    throw new NoSuchElementException();
                }
                if(tail==head.next){
                    tail=head;
                }
                head.next = head.next.next;
            }

            @Override
            public boolean hasNext() {
                while(!isEmpty() && !peek().isAlive()){
                    removeFromHead();
                }
                return !isEmpty();
            }
            @Override
            public Warrior next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                return peek();
            }

        }

    /**
     * Method to add units to Collection
     * using Supplier interface
     *
     * @param warriorFactory - Supplier
     * @param amount - amount of units to be added
     * @return - Army
     */
    public Army addUnits(Supplier<Warrior> warriorFactory, int amount) { //Can be done with Cloneable interface too
        for (int i = 0; i < amount; i++) {
            addToTail(warriorFactory.get());
        }
        return this;
    }













}
