package game;

import card.HeartCard;
import card.LevelCard;
import card.NinjaCard;

import java.util.LinkedList;
import java.util.Stack;

public class Desk {
   private Stack<Number> shownNumberCards;
   private LinkedList<HeartCard> heartCards;
   private LinkedList<NinjaCard> ninjaCards;
   private LevelCard levelCard;

   public Desk(Stack<Number> shownNumberCards, LinkedList<HeartCard> heartCards,
               LinkedList<NinjaCard> ninjaCards, LevelCard levelCard) {
      this.shownNumberCards = shownNumberCards;
      this.heartCards = heartCards;
      this.ninjaCards = ninjaCards;
      this.levelCard = levelCard;
   }
}
