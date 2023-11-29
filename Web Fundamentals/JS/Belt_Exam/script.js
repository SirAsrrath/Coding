function hide(element) {
    element.remove();
}

function pet(element) {
    if (element.options[element.selectedIndex].value == 'Dog')
        alert("You are looking for a: Dog");
    else if (element.options[element.selectedIndex].value == 'Cat') 
        alert("You are looking for a: Cat")
}

let likes = [0,0,0];
let tLikes = document.querySelector('#totalLikes')
let tLikes2 = document.querySelector('#totalLikes2')
let tLikes3 = document.querySelector('#totalLikes3')
document.querySelector('#petbtn').addEventListener('click', function (){
    likes[0] += 1;
    tLikes.innerHTML = likes[0];
})
document.querySelector('#petbtn2').addEventListener('click', function (){
    likes[1] += 1;
    tLikes2.innerHTML = likes[1];
})
document.querySelector('#petbtn3').addEventListener('click', function (){
    likes[2] += 1;
    tLikes3.innerHTML = likes[2];
})