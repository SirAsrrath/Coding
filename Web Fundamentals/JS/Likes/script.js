let likes = [0,0,0];
let tLikes = document.getElementById('totalLikes')
let tLikes2 = document.getElementById('totalLikes2')
let tLikes3 = document.getElementById('totalLikes3')
document.getElementById('likeBtn').addEventListener('click', function (){
    likes[0] += 1;
    tLikes.innerHTML = likes[0];
    
})
document.getElementById('likeBtn2').addEventListener('click', function (){
    likes[1] += 1;
    tLikes2.innerHTML = likes[1];
    
})
document.getElementById('likeBtn3').addEventListener('click', function (){
    likes[2] += 1;
    tLikes3.innerHTML = likes[2];
    
})