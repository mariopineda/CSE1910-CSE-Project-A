<DOCTYPE html>
<html>
<Head>
<script type="text/javascript">
 	$(document).ready(function(){
      	$('#test-area').mouseout(function(){
           	$('#mycursor').hide();
           	return >false;
      	});
      	$('#test-area').mouseenter(function(){
           	$('#mycursor').show();
           	return >false;
      	});
      	$('#test-area').mousemove(function(e){
           	$('#mycursor').css('left', e.clientX - 20).css('top', e.clientY + 7);
      	});
});
</script>
<style>
div {
    border: 1px solid black;
    background-color: lightblue;
    padding-top: 50px;
    padding-right: 30px;
    padding-bottom: 50px;
    padding-left: 100px;
}
#test-area {
 	height: 200px;
 	border: 3px dashed #CCCCCC;
 	background: #FFFFFF;
 	padding: 20px;
 	cursor: url("http://ddragon.leagueoflegends.com/cdn/6.24.1/img/item/3078.png");
}
#mycursor {
 	cursor: none;
 	width: 97px;
 	height: 137px;
 	background: url("images/custom-cursor.jpg") no-repeat left top;
 	position: absolute;
 	display: none;
 	top: 0;
 	left: 0;
 	z-index: 10000;
}
</style>
<div id="mycursor"></div>
</Head>

<title>LoL Coaching</title>


<body background="http://5pots.com/img/upload/SR%20Wallpaper.jpg">


<marquee behavior="scroll" direction="left"><img src="https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/15873532_1635479153424218_2877884122929684993_n.jpg?oh=ec7eba5e576a371353a853c88d87d363&oe=58EB7B1D" width="120" height="80" alt="Natural" /></marquee>
<br>
<p style="color:red;"><b>Summoner Name: EIcIco
  Region:North America
  Elo:Plat 1.</b></p>

<table style="width:100%">
  <tr>
  <td><img src="http://s.lolstatic.com/site/ekko-comic/f4c70d670bccb225431148424fc4900fc49da818/issue/01/pages/en_US/12/12_1.jpg" width="400" height="120"></td>
    <th><img src="http://i.imgur.com/4eSpH89.gif" width="300" height="128"><h1 style="color:blue;">About me and this website:</h1>
<br>
<p style="color:red;">Hello this is a non-benefitial website for coaching on LoL.Almost all information is from me(with a bit of help
from references of course),however,it is biased with my own opinions and views of the game so not all of it will help 
you.</p>
</th> 
  
  <tr>
  <td><p>Click on these links below to be redirected to the other parts of this website.</p><nav>
  <ul>
    <li><a href="https://melvin-tran-cs.github.io/Reference-Links/">Reference Links</a></li>
    <li><a href="https://melvin-tran-cs.github.io/Itemization/">Itemization/Decision Making</a></li>
    <li><a href="Strategies and Laning Phase.html">Strategies/Laning Phase</a></li>
    <li><a href="Gamer's Mindset.html">Gamer's Mindset</a></li>
    <li><a href="Late Game.html">Late game</a></li>
  </ul>
  </nav></td>
    <td><div id="test-area">
     If you move your mouse over here it gains shaco's q.
</div>
<div id="mycursor"></div></td> 
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td> 
    <td></td>
  </tr>
  
 
  <footer>
  <p style="color:white;">Posted by: Melvin Tran</p>
  <p style="color:white;">Contact information: <a href="bobthebilbo@gmail.com">
   bobthebilbo@gmail.com</a>.</p>
</footer>
  
