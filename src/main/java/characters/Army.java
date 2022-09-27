package characters;

import java.util.*;
import java.util.function.Supplier;



public class Army implements Iterable<Warrior> {




    private class Node extends Warrior implements ArmyWarrior, IHealer {
        Warrior warrior;
        Node next;

        public Node(Warrior warrior) {
            this.warrior = warrior;
            this.next = this;
        }

        @Override
        public Warrior getWarriorBehind() {

            return next == head ? null : next.warrior;
        }

        @Override
        public Warrior next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return next.warrior;
        }

        @Override
        public boolean hasNext() {
            if(next!=head){
                return true;
            }
            return false;
        }


        @Override
        public void hit(CanReceiveDamage opponent) {
            warrior.hit(opponent);
            next.healUnit(warrior);
        }

        @Override
        public void healUnit(Warrior ally) {

            if (warrior instanceof Healer healer) {
                healer.heal(ally);
                if (next != head) {
                    next.healUnit(warrior);
                }

            }
       }

        @Override
        public void receiveDamage(HasAttack damager) {
            warrior.receiveDamage(damager);
        }

        @Override
        public int getHealth() {
            return warrior.getHealth();
        }

        @Override
        public int getAttack() {
            return warrior.getAttack();
        }

        @Override
        public void setHealth(int health) {
            warrior.setHealth(health);
        }


    }

    private final Node head = new Node(null);
    private Node tail = head;

    boolean isEmpty() {
        return tail == head;
    }

    private void addToTail(Warrior warrior) {
        var node = new Node(warrior);
        node.next = head;
        tail.next = node;
        tail = node;

    }


    public Iterator<Warrior> iterator() {
        return new SimpleIterator();
    }

    public Iterator<Warrior> firstAlive() {
        return new FirstAliveIterator();

    }

    private class FirstAliveIterator implements Iterator<Warrior> {

        Warrior peek() {
            return head.next;
        }

        private void removeFromHead() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            if (tail == head.next) {
                tail = head;
            }
            head.next = head.next.next;
        }

        @Override
        public boolean hasNext() {
            while (!isEmpty() && !peek().isAlive()) {
                removeFromHead();
            }
            return !isEmpty();
        }

        @Override
        public Warrior next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            var res = peek();
            return res == head ? null : res;
        }

    }

    private class SimpleIterator implements Iterator<Warrior> {

        Node cursor = head;


        @Override
        public boolean hasNext() {
            return cursor.next != head;
        }

        @Override
        public Warrior next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Warrior warrior = cursor.next;
            return warrior;
        }


        @Override
        public void remove() {
            cursor.next = cursor.next.next;
        }
    }


    /**
     * Method to add units to Collection
     * using Supplier interface
     *
     * @param warriorFactory - Supplier
     * @param amount         - amount of units to be added
     * @return - Army
     */
    public Army addUnits(Supplier<Warrior> warriorFactory, int amount) { //Can be done with Cloneable interface too
        for (int i = 0; i < amount; i++) {
            final Warrior warrior = warriorFactory.get();
            addToTail(warrior);
        }
        return this;
    }

    public boolean removeDeadUnits() {
        while(iterator().hasNext()){
            if(!iterator().next().isAlive()){
                iterator().remove();
                return true;
            }

            }
        return false;
        }
    }






