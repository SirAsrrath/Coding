// Deleting Connections
function DeleteConn(button){
    button.parentElement.parentElement.remove();
}
//

// Connection Numbers
let crequest = document.querySelector('.num1')
let num = 2;

let cnum = document.querySelector('.num2')
let n2 = 500;

let elements = document.querySelectorAll('.accept , .decline');
let clickEvent = () => {
    num -= 1;
    crequest.innerHTML = num;
}
elements.forEach((item) => {
    item.addEventListener('click', clickEvent)
});

let aelements = document.querySelectorAll('.accept');
let aclickEvent = () => {
    n2 += 1
    cnum.innerHTML = n2
}
aelements.forEach((item) => {
    item.addEventListener('click', aclickEvent)
});

//

//Name Change
function change() {
    
    let text;
    let person = prompt("Please enter your name:", "");
    if (person == null || person == "") {
        text = "User cancelled the prompt.";
    } else {
        text = person ;
    }
    document.getElementById("name").innerHTML = text;
}
//