function hide(element){
    element.parentElement.remove();
}

function msg(element){
    alert('Loading weather report...')
}

var hightempc = ['°24','°27','°21','°16']
var lowtempc = ['°18','°19','°16','°21']
var hightempf = ['°75','°80','°69','°78']
var lowtempf = ['°65','°66','°61','°70']


function changetemp(element){
    if (element.value == "celsius"){
        document.querySelector('.high1').innerHTML=hightempc [0]
        document.querySelector('.high2').innerHTML=hightempc [1]
        document.querySelector('.high3').innerHTML=hightempc [2]
        document.querySelector('.high4').innerHTML=hightempc [3]
        document.querySelector('.low1').innerHTML=lowtempc [0]
        document.querySelector('.low2').innerHTML=lowtempc [1]
        document.querySelector('.low3').innerHTML=lowtempc [2]
        document.querySelector('.low4').innerHTML=lowtempc [3]
    }
    else{
        document.querySelector('.high1').innerHTML=hightempf [0]
        document.querySelector('.high2').innerHTML=hightempf [1]
        document.querySelector('.high3').innerHTML=hightempf [2]
        document.querySelector('.high4').innerHTML=hightempf [3]
        document.querySelector('.low1').innerHTML=lowtempf [0]
        document.querySelector('.low2').innerHTML=lowtempf [1]
        document.querySelector('.low3').innerHTML=lowtempf [2]
        document.querySelector('.low4').innerHTML=lowtempf [3]
    }
}