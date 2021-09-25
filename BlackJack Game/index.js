let message = "";
let sumEl = document.querySelector("#sum");
let cardsEl = document.querySelector("#cards");
let sum =0;
let cards = [];

let player={
   name:"Razvan",
   cash:1000,
};

let playerEl = document.querySelector("#player-el");

playerEl.textContent=player.name+": $"+player.cash;

function startGame(){
    
    if(cards.length<2){
    let firstCard = randomCard();
    let secondCard =randomCard();
    sum = firstCard + secondCard;
    cards.push(firstCard);
    cards.push(secondCard);
    renderGame();
  }else{
    restartGame();
  }

}

function renderGame() {
   cardsEl.textContent="Cards: ";

   for (let i = 0; i <cards.length; i++) {
       cardsEl.textContent +=cards[i]+" ";
   }

   sumEl.textContent="Sum: "+sum;
   if(sum <21){
     message = "Do you want to draw a new card?";
   }else if (sum>21){
     message = "You lost!";
   }else{
     message = "You won!";
   }
   document.querySelector("#result").textContent=message;
}

function newCard() { 
    if (sum <= 21){
    let newCard = randomCard();
    sum+=newCard;
    cards.push(newCard);
    renderGame();
    }else{
      document.querySelector("#result").textContent="You can't draw a new card, you are out !";
    }
}

function randomCard() {
   let newCard =Math.floor(Math.random()*13)+1;;
   if(newCard ===1){
     return 11;
   }else if (newCard >=11 && newCard <=13){
     return 10;
   }else{
     return newCard;
   } 
}

function restartGame(){
      while(cards.length>0){
        cards.pop();
      }
      cardsEl.textContent="Cards: ";
      sum=0;
      sumEl.textContent="Sum: ";
      document.querySelector("#result").textContent="Restult: ";
}