package handlers;

import characters.Warrior;

public abstract class Handler {
    private Handler next;

    public Handler setNextHandler(Handler next) {
        this.next = next;
        return next;
    }

    public abstract boolean handle(Warrior warrior);

    protected boolean handleNext(Warrior warrior){
        if(next==null){
            return true;
        }
        return next.handle(warrior);
    }
}
